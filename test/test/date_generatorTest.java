package test;


import org.junit.Assert;
import org.junit.Test;

import static assigment6.extents.generators.date_generator.birthDate;

import java.util.Calendar;
import java.util.Date;

public class date_generatorTest{


    @Test
    public void testBirthDate() {
        Date birthday_date = birthDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday_date);
        int year = calendar.get(Calendar.YEAR);
        Assert.assertTrue(year >= 1951 && year <=2001);
    }
}