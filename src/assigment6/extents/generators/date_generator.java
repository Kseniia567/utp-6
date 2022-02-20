package assigment6.extents.generators;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class date_generator {

    private static final int YEAR_START;
    private static final int YEAR_START_TEMP = 70;
    private static final int YEAR_COUNT = 50; //should be less than start_temp
    private static final int MONTH_START = 1;
    private static final int MONTH_COUNT = 12;
    private static final int DAY_START = 1;
    private static int DAY_COUNT;

    private static final Date TODAY = new Date(); // current date
    private static final Random random = new Random();



    static {
        Calendar calendar = Calendar.getInstance();//set current time-zone
        calendar.setTime(TODAY); //set current date
        var current_year = calendar.get(Calendar.YEAR);
        YEAR_START = current_year - YEAR_START_TEMP; //2021 - 70 = 1951 - 2001
    }


    public static Date birthDate() {
        int yyyy = YEAR_START + random.nextInt(YEAR_COUNT);
        int mm = MONTH_START + random.nextInt(MONTH_COUNT);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, yyyy);
        calendar.set(Calendar.MONTH, mm);
        DAY_COUNT = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); //Finding max possible number of days in necessary month
        int dd = DAY_START + random.nextInt(DAY_COUNT);
        calendar.set(yyyy, mm, dd);
        return calendar.getTime();
    }


}
