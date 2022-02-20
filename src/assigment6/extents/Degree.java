package assigment6.extents;

import java.util.Random;

public enum Degree {
    BSc ("Bachelor of Science"),
    MSc ("Master of Science"),
    PhD("Doctor of Philosophy");

    private final String _name;
    private static final Random random = new Random();
    Degree(String name) {
        _name = name;
    }

    public String get_name() {
        return _name;
    }

    public static Degree randomDegree() {
        Degree[] degrees = Degree.values();
        int index = random.nextInt(degrees.length);
        return degrees[index];
    }
}
