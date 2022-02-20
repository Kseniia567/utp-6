package assigment6.extents.extents;

import assigment6.extents.Nationality;
import assigment6.extents.Person;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class Persons {
    private static final Set<Person> INSTANCES; //doesn't contain duplicates
    private static final List<Person> LIST;
    static {
        INSTANCES = new HashSet<>();
        LIST = new ArrayList<>();
    }

    public static void add(Person person) {
        INSTANCES.add(person);
        LIST.add(person);
        LIST.sort(Comparator.naturalOrder());
    }

    public static Set<Person> instances() {return INSTANCES;}


    public static List<Person> filterByNationality(Nationality nationality) {
        List<Person> p = LIST
                .stream()
                .filter(e -> e.get_nationality() == nationality)
                .collect(Collectors.toList());

        Collator nat_Collator = nationality.get_collator();
        Comparator<Person> nat_comparator = Comparator
                .comparing(Person::get_surname, nat_Collator)
                .thenComparing(Person::get_name, nat_Collator);

        p.sort(nat_comparator);
        return p;
    }


}
