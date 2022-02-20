package assigment6.extents.extents;

import assigment6.extents.Student;

import java.util.*;

public class Students extends Persons{
    private static final Set<Student> INSTANCES;
    private static final List<Student> LIST;
    static {
        INSTANCES = new HashSet<>();
        LIST = new ArrayList<>();
    }

    public static void add(Student student) {
        INSTANCES.add(student);
        LIST.add(student);
        LIST.sort(Comparator.naturalOrder());
    }

    public static Set<Student> getINSTANCES() {
        return INSTANCES;
    }

    public static List<Student> getLIST() {
        return LIST;
    }


}
