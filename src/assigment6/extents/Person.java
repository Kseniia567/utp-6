package assigment6.extents;

import assigment6.extents.extents.Persons;

import java.text.Collator;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public abstract class Person implements Comparable<Person>{
    private final String _pesel;
    private final String _name;
    private final String _surname;
    private final Date _birthDate;
    private final Nationality _nationality;



    private static final Collator COLLATOR_PL = Nationality.POLISH.get_collator();

    private static final Comparator<Person> NATURAL_ORDER = Comparator
            .comparing(Person::get_surname, COLLATOR_PL)
            .thenComparing(Person::get_name, COLLATOR_PL);

    protected Person(String name, String surname,Date birthDate, String pesel, Nationality nationality) {
        _name = name;
        _surname = surname;
        _birthDate = birthDate;
        _pesel =pesel;
        _nationality = nationality;
        Persons.add(this);
    }

    public Nationality get_nationality() {
        return _nationality;
    }

    public Date get_birthDate() {
        return _birthDate;
    }

    public String get_name() {
        return _name;
    }

    public String get_pesel() {
        return _pesel;
    }

    public String get_surname() {
        return _surname;
    }

    @Override
    public final int compareTo(Person p) {
        return NATURAL_ORDER.compare(this, p);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return _pesel.equals(person._pesel) &&
                _name.equals(person._name) &&
                _surname.equals(person._surname) &&
                _birthDate.equals(person._birthDate) &&
                _nationality == person._nationality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_pesel, _name, _surname,_birthDate, _nationality);
    }


    @Override
    public String toString() {
        return getClass() +
                ":  pesel=" + _pesel + '\'' +
                ", name='" + _name + '\'' +
                ", surname='" + _surname + '\'' +
                ", birthDate=" + _birthDate +
                ", nationality=" + _nationality ;
    }
}
