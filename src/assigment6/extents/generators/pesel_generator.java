package assigment6.extents.generators;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class pesel_generator {
    private static final Random random = new Random();


    private static final int[] utility = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
    private static final int[] female = {0, 2, 4, 6, 8};
    private static final int[] male = {1, 3, 5, 7, 9};
    private static final char[] sexes = {'M', 'F'};

    private static char generate_Sex() {
        int index = random.nextInt(sexes.length);
        return sexes[index];
    }

    private static int getFemRandID() {
        int index = random.nextInt(female.length);
        return female[index];
    }

    private static int getMaleRandID() {
        int index = random.nextInt(male.length);
        return male[index];
    }

    public static String generate_pesel(Date birthDate) throws Exception {
        int checkSum = 0;
        int zzz = random.nextInt(1000);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthDate);
        int year = calendar.get(Calendar.YEAR);
        int year_numb = year % 100;
        int day_numb = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int month_numb;
        char sex = generate_Sex();

        if (year < 1800 || year > 2299) {
            throw new Exception("Error : there is no way to make PESEL");
        } else if (year <= 1899) {
            month_numb = month + 80;
        } else if (year <= 1999) {
            month_numb = month;
        } else if (year <= 2099) {
            month_numb = month + 20;
        } else if (year <= 2199) {
            month_numb = month + 40;
        } else {
            month_numb = month + 60;
        }

        String six_Dig = String.format("%02d%02d%02d", year_numb, month_numb + 1, day_numb);

        int sexDig = switch (sex) {
            case 'M' -> getMaleRandID();
            case 'F' -> getFemRandID();
            default -> throw new Exception("Error : there is no way to make PESEL");
        };

        String four_Dig = String.format("%03d%01d", zzz, sexDig);
        String ten_Dig = six_Dig + four_Dig;

        for (int i = 0; i < utility.length; i++) {
            checkSum += ten_Dig.charAt(i) * utility[i];
        }

        int module = checkSum % 10;
        String fin_Dig = Integer.toString(module == 0 ? 0 : 10 - module);
        return ten_Dig + fin_Dig;
    }
}