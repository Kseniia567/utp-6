package assigment6.extents.extents;

import assigment6.extents.Department;

import java.util.*;

public class Departments {
    private static final Set<Department> INSTANCES; //doesn't contain duplicates
    private static final List<Department> LIST;
    static {
        INSTANCES = new HashSet<>();
        LIST = new ArrayList<>();
    }

    public static void add(Department dept) {
        INSTANCES.add(dept);
        LIST.add(dept);
        LIST.sort(Comparator.naturalOrder());
    }

    public static Set<Department> instances() {return INSTANCES;}
}
