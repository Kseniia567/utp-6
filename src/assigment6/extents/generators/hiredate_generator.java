package assigment6.extents.generators;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class hiredate_generator{

    private static final Date TODAY = new Date();
    private static final int MONTH_START = 1;
    private static final int MONTH_COUNT = 12;
    private static final int DAY_START = 1;


    private static final Random random = new Random();


    public static Date hireDate(Date birthday) {
        //person can work if he is an adult
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday);
        int YEAR_START = calendar.get(Calendar.YEAR) + 18; //start year (adult)
        calendar.setTime(TODAY);
        int YEAR_COUNT = calendar.get(Calendar.YEAR) - YEAR_START;
        int yyyy = YEAR_START + random.nextInt(YEAR_COUNT);
        int mm = MONTH_START + random.nextInt(MONTH_COUNT);
        calendar.set(Calendar.MONTH, mm);
        int DAY_COUNT = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); //Finding max possible number of days in necessary month
        int dd = DAY_START + random.nextInt(DAY_COUNT);
        calendar.set(yyyy, mm, dd);
        return calendar.getTime();
    }


}
