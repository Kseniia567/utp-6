package test;

import assigment6.extents.*;
import assigment6.extents.generators.date_generator;
import assigment6.extents.generators.hiredate_generator;
import assigment6.extents.generators.pesel_generator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class GenerateAll {
    private static final int numberOfStudents = 100;
    private static final int numberOfGroups = 12;
    private static final int numberOfDepartments = 3;
    private static final int numberofSubjects = 10;
    private static final int numberOfTeachers = 10;
    private static List<Teacher> teachers = new ArrayList<>();
    private static List <Student> students = new ArrayList<>();
    private static List<Department> dep = new ArrayList<>();
    private static List <StudentGroup> sg;
    private static List <Subject> subj;
    private static final Random random = new Random();


    public static Student createStudents(int counter) throws Exception {
        Student s;
        Date birthDate = date_generator.birthDate();
        s = new Student("SName-"+counter, "SSurname-"+counter,  birthDate, pesel_generator.generate_pesel(birthDate),Nationality.randomNationality());
        return s;
    }

    public static Teacher createTeachers(int counter)throws Exception{
        Teacher t;
        Date birthDate = date_generator.birthDate();
        t = new Teacher("TName- "+counter, "TSurname-" + counter, birthDate, pesel_generator.generate_pesel(birthDate), Nationality.randomNationality(), hiredate_generator.hireDate(birthDate), Degree.randomDegree());
        return t;
    }

    public static Department createDepartments(int counter){
        return new Department("dName"+counter, teachers);
    }

    public static StudentGroup createStudentGroups(int counter)throws Exception{
        int max = 8;
        students = listStudents();
        StudentGroup s = null;
        for (int i = 0; i < max; i++){
            s =  new StudentGroup("StudentGroupName"+counter, students.subList(i*max, i*max+max));
        }
        max = 10;
        for (int i = 8; i < max; i++){
            s =  new StudentGroup("StudentGroupName"+counter, students.subList(i*max, i*max+max));
        }
        return s;
    }

    public static Subject createSubject(int counter)throws Exception{
        Subject subj = null;
        teachers = listTeachers();
        dep = listDepartment();
        students = listStudents();
        int max = 10;
        for (int i = 0 ; i < max; i++)
            subj = new Subject("SubjectNo-" + counter, teachers.get(random.nextInt(teachers.size())), students.subList(i*max, i*max+max), dep.get(random.nextInt(dep.size())));

        return subj;
    }

    public static List <Department> listDepartment(){
        for (int i = 0 ; i < numberOfDepartments; i++){
            dep.add(createDepartments(i));
        }
        return dep;
    }


    public static List <Student> listStudents() throws Exception{
        for (int i = 0 ; i < numberOfStudents; i++){
            students.add(createStudents(i));
        }
        return students;
    }

    public static List <Teacher> listTeachers()throws Exception{
        for (int i = 0 ; i < numberOfTeachers; i++){
            teachers.add(createTeachers(i));
        }
        return teachers;
    }

    public static List <StudentGroup> groupList()throws Exception{
        sg = new ArrayList<>();
        for (int i = 0 ; i < numberOfGroups; i++){
            sg.add(createStudentGroups(i));
        }
        return sg;
    }

    public static List <Subject> subjectList()throws Exception{
        subj = new ArrayList<>();

        for (int i = 0 ; i < numberofSubjects; i++){
            subj.add(createSubject(i));
        }
        return subj;
    }


    @Test
    public  void teachersList()throws Exception{
        teachers = GenerateAll.listTeachers();
        Assert.assertNotNull(teachers);
        Assert.assertEquals(10, teachers.size());
    }

    @Test
    public  void studentsList()throws Exception{
        students = GenerateAll.listStudents();
        Assert.assertNotNull(students);
        Assert.assertEquals(100, students.size());
    }

    @Test
    public void departmentList(){
        dep = listDepartment();
        Assert.assertNotNull(dep);
        Assert.assertEquals(3, dep.size());
    }
    @Test
    public void studentGrouplist()throws Exception{
        sg = groupList();
        Assert.assertNotNull(sg);
        Assert.assertEquals(12, sg.size());
    }
    @Test
    public void listOfSubject()throws Exception{
        subj = subjectList();
        Assert.assertNotNull(subj);
        Assert.assertEquals(10, subj.size());
    }



}
