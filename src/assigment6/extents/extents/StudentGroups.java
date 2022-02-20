package assigment6.extents.extents;

import assigment6.extents.StudentGroup;

import java.util.*;

public class StudentGroups {
    private static final Set<StudentGroup> INSTANCES; //doesn't contain duplicates
    private static final List<StudentGroup> LIST;
    static {
        INSTANCES = new HashSet<>();
        LIST = new ArrayList<>();
    }

    public static void add(StudentGroup studentGroup) {
        INSTANCES.add(studentGroup);
        LIST.add(studentGroup);
        LIST.sort(Comparator.naturalOrder());
    }

    public static Set<StudentGroup> instances() {return INSTANCES;}
}
