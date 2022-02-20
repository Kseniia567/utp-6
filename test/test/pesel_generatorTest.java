package test;


import org.junit.Assert;
import org.junit.Test;
import assigment6.extents.generators.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class pesel_generatorTest{

    private static final Pattern pattern = Pattern.compile("^[0-9]{11}$");

    @Test
    public void testGenerate_pesel() throws Exception {
        String PESEL = pesel_generator.generate_pesel(date_generator.birthDate());
        Matcher matcher = pattern.matcher(PESEL);
        System.out.println(PESEL);
        Assert.assertEquals(11, PESEL.length());
        Assert.assertTrue(matcher.matches());
    }
}