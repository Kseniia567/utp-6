package assigment6.extents;

import assigment6.extents.extents.Subjects;

import java.util.List;
import java.util.Objects;

public class Subject implements Comparable<Subject>{
    private final String _name;
    private final Teacher _lecturer;
    private final List<Student> _students;
    private final Department _department;

    public Subject(String name, Teacher lecturer, List<Student> students, Department department) {
        _name = name;
        _lecturer = lecturer;
        _students = students;
        _department = department;
        Subjects.add(this);
    }

    public String get_name() {
        return _name;
    }

    public List<Student> get_students() {
        return _students;
    }

    public Department get_department() {
        return _department;
    }

    public Teacher get_lecturer() {
        return _lecturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;
        Subject subject = (Subject) o;
        return _name.equals(subject._name) &&
                _lecturer.equals(subject._lecturer) &&
                _students.equals(subject._students) &&
                _department.equals(subject._department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_name, _lecturer, _students, _department);
    }

    @Override
    public int compareTo(Subject subject) {
        return this.get_name().compareTo(subject.get_name());
    } //comparing
}
