package assigment6.extents.extents;

import assigment6.extents.Subject;

import java.util.*;

public class Subjects {
    private static final Set<Subject> INSTANCES;
    private static final List<Subject> LIST;
    static {
        INSTANCES = new HashSet<>();
        LIST = new ArrayList<>();
    }

    public static void add(Subject subject) {
        INSTANCES.add(subject);
        LIST.add(subject);
        LIST.sort(Comparator.naturalOrder());
    }

    public static Set<Subject> instances() {return INSTANCES;}
}
