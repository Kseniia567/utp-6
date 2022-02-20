package test;

import assigment6.extents.generators.date_generator;
import assigment6.extents.generators.hiredate_generator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class hiredate_generatorTest{



    @Test
    public void testHireDate() {
        Date birthdate = date_generator.birthDate();
        Date hiredate = hiredate_generator.hireDate(birthdate);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthdate);
        int year_b = calendar.get(Calendar.YEAR);
        calendar.setTime(hiredate);
        int year_h = calendar.get(Calendar.YEAR);

        Assert.assertEquals(birthdate.compareTo(hiredate), -1);  //check that hiredate earlier than birthday
        Assert.assertTrue(year_h - year_b >= 18);

    }
}