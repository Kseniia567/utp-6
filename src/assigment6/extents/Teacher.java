package assigment6.extents;


import assigment6.extents.extents.Teachers;

import java.util.Date;
import java.util.Objects;

public class Teacher extends Person {
    private final Date _hiredate;
    private final Degree _degree;

    public Teacher(String name, String surname, Date birthDate, String pesel, Nationality nationality, Date hiredate, Degree degree) {
        super(name, surname, birthDate, pesel, nationality);
        _hiredate = hiredate;
        _degree = degree;
        Teachers.add(this);
    }

    public Date get_hiredate() {
        return _hiredate;
    }

    public Degree get_degree() {
        return _degree;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return _hiredate.equals(teacher._hiredate) &&
                _degree == teacher._degree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), _hiredate, _degree);
    }


    @Override
    public String toString() {
        return super.toString() +
                ", hiredate=" + get_hiredate() +
                ", degree=" + get_degree();
    }
}
