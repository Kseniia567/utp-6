package assigment6.extents;

import assigment6.extents.extents.StudentGroups;

import java.util.List;
import java.util.Objects;

public class StudentGroup implements Comparable<StudentGroup>{
    private final String _name;
    private final List<Student> _students;

    public StudentGroup(String name, List<Student> students) {
        _name = name;
        _students = students;
        StudentGroups.add(this);
    }

    public List<Student> get_students() {
        return _students;
    }

    public String get_name() {
        return _name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentGroup)) return false;
        StudentGroup that = (StudentGroup) o;
        return _name.equals(that._name) &&
                _students.equals(that._students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_name, _students);
    }

    @Override
    public int compareTo(StudentGroup group) {
        return this.get_name().compareTo(group.get_name());
    }
}
