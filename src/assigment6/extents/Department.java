package assigment6.extents;

import assigment6.extents.extents.Departments;

import java.util.List;
import java.util.Objects;

public class Department implements Comparable<Department>{
    private final String _name;
    private final List <Teacher> _employee;

    public Department(String name, List<Teacher> employee) {
        _name = name;
        _employee = employee;
        Departments.add(this);
    }

    public String get_name() {
        return _name;
    }

    public List<Teacher> get_employee() {
        return _employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return _name.equals(that._name) &&
                _employee.equals(that._employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_name, _employee);
    }


    @Override
    public int compareTo(Department department) {
        return this.get_name().compareTo(department.get_name());
    }
}
