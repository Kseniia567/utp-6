package assigment6.extents;

import assigment6.extents.extents.Students;

import java.util.Date;
import java.util.Objects;

public class Student extends Person {

    private final String _studentBook;
    private static int _student_number = 22100;

    public Student (String name, String surname, Date birthDate, String pesel, Nationality nationality) {
        super(name, surname, birthDate, pesel, nationality);
        _studentBook = "s" + _student_number++;
        Students.add(this);
    }

    public String get_studentBook() {return _studentBook;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return _studentBook.equals(student._studentBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), _studentBook);
    }


    @Override
    public String toString() {
        return super.toString() +
                ", studentBook=" + get_studentBook();
    }
}
