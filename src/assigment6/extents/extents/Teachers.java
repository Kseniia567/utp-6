package assigment6.extents.extents;

import assigment6.extents.Teacher;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Teachers extends Persons{
    private static final HashSet<Teacher> INSTANCES;
    private static final List<Teacher> LIST;
    static {
        INSTANCES = new HashSet<>();
        LIST = new ArrayList<>();
    }

    public static void add(Teacher teacher) {
        INSTANCES.add(teacher);
        LIST.add(teacher);
        LIST.sort(Comparator.naturalOrder());
    }

    public static HashSet<Teacher> getINSTANCES() {
        return INSTANCES;
    }

    public static List<Teacher> getLIST() {
        return LIST;
    }


}
