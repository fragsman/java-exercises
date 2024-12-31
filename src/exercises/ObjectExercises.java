package exercises;

import java.util.ArrayList;
import java.util.Collections;
import utils.Person;

public class ObjectExercises {

    /**
     * This class will contain object exercises such as
     * ordering complex objects or working with composition, abstraction, hierarchy, etc.
     */

    public static void sortPeople() {
        Person mike = new Person("Mike Gourd", 25, 75);
        Person kelly = new Person("Kelly Clarkson", 28, 55);
        Person bob = new Person("Bob Smith", 45, 92);
        Person raul = new Person("Raul Oviedo", 35, 82);
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(mike);
        people.add(kelly);
        people.add(bob);
        people.add(raul);
        Collections.sort(people);
        System.out.println("The list of people ordered by age is: ");
        for (Person person : people) {
            System.out.println(person.getName() + " " + person.getWeight() + " " + person.getAge());
        }
    }
}
