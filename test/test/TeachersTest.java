package test;



import assigment6.extents.Degree;
import assigment6.extents.Nationality;
import assigment6.extents.Person;
import assigment6.extents.Teacher;
import assigment6.extents.extents.Teachers;
import assigment6.extents.generators.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeachersTest{

    private final List<Teacher> teachers = new ArrayList<>();

    @Before
    public void before() throws Exception {
        Date[] t_bd = new Date[5];
        for (int i = 0; i < t_bd.length; i++) {
            t_bd[i] = date_generator.birthDate();
        }
        Teacher t1_ua = new Teacher("Іван", "Кравченко", t_bd[0], pesel_generator.generate_pesel(t_bd[0]), Nationality.UKRAINIAN, hiredate_generator.hireDate(t_bd[0]), Degree.randomDegree());
        teachers.add(t1_ua);
        Teacher t2_en = new Teacher("Joe", "Dou", t_bd[1], pesel_generator.generate_pesel(t_bd[1]), Nationality.BRITISH, hiredate_generator.hireDate(t_bd[1]), Degree.randomDegree());
        teachers.add(t2_en);
        Teacher t3_ua = new Teacher("Тамара", "Боднаренко", t_bd[2], pesel_generator.generate_pesel(t_bd[2]), Nationality.UKRAINIAN, hiredate_generator.hireDate(t_bd[2]), Degree.randomDegree());
        teachers.add(t3_ua);
        Teacher t4_ua = new Teacher("Оксана", "Крамаренко", t_bd[3], pesel_generator.generate_pesel(t_bd[3]), Nationality.UKRAINIAN, hiredate_generator.hireDate(t_bd[3]), Degree.randomDegree());
        teachers.add(t4_ua);
        Teacher t5_pl = new Teacher("Marianna", "Wiśniewska", t_bd[4], pesel_generator.generate_pesel(t_bd[4]), Nationality.POLISH, hiredate_generator.hireDate(t_bd[4]), Degree.randomDegree());
        teachers.add(t5_pl);
    }

    @Test
    public void test() {
        List<Person> teachers_ua = Teachers.filterByNationality(Nationality.UKRAINIAN);
        for (int i = 0; i < teachers_ua.size(); i++) {
            System.out.println(teachers_ua.get(i));
        }
        Assert.assertEquals(3, teachers_ua.size());
    }


}