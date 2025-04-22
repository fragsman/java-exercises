package exercises;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import utils.Person;

public class ObjectExercises {

    /**
     * This class will contain object exercises such as
     * ordering complex objects or working with composition, abstraction, hierarchy, etc.
     */

    public static class UseFoo {
        public static String add(String string, Function<String,String> fn){
            return fn.apply(string);
        }
    }

    private static ArrayList<Person> createListOfPeople(){
        Person mike = new Person("Mike Gourd", 24, 75, Person.Sex.MALE);
        Person kelly = new Person("Kelly Clarkson", 28, 55, Person.Sex.FEMALE);
        Person bob = new Person("Bob Smith", 45, 92,Person.Sex.MALE);
        Person raul = new Person("Raul Oviedo", 35, 82,Person.Sex.MALE);
        Person tommy = new Person("Thomas Holmes", 17, 75, Person.Sex.MALE);
        Person anna = new Person("Anna London", 40, 52, Person.Sex.FEMALE);
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(mike);
        people.add(kelly);
        people.add(bob);
        people.add(raul);
        people.add(tommy);
        people.add(anna);
        return people;
    }

    public static void sortPeople() {
        ArrayList<Person> people = createListOfPeople();
        Collections.sort(people);
        System.out.println("The list of people ordered by age is: ");
        for (Person person : people) {
            person.printPerson();
        }
    }

    public static void lambdaExpressionExamples(){
        ArrayList<Person> people = createListOfPeople();
        printPersonsWithinAgeRange(people,18,25);
    }

    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }

        Function<String, String> fn = parameter -> parameter + " from lambda";
        String result = UseFoo.add("Message ", fn);
        System.out.println("result: "+result);
    }

    public static void streamExamples(){
        creatingStreamsExamples(); //Different ways to create a stream
        anotherExamples();
        filterExamples();
        collectExamples();
        anyMatchExamples();
    }

    private static void creatingStreamsExamples(){
        Stream<String> emptyStream = Stream.empty(); //we prefer an empty stream instead of a null one

        //1: Returns a stream with the values in the array
        String[] array = new String[]{"a","b","c"};
        Stream<String> streamOfArray = Arrays.stream(array);
        //2: Returns a stream with "Monica", "Liza", "Juan"
        streamOfArray = Stream.of("Monica", "Liza", "Juan");
        //3: Returns a stream of "a", "b"
        Stream<String> builtStream = Stream.<String>builder().add("a").add("b").build();
        //4: Returns a stream of 10 random numbers
        Stream<Double> generatedStream = Stream.generate(Math::random).limit(10);
        //5: Returns a stream of 40, 42, 44.. etc
        Stream<Integer> iteratedStream = Stream.iterate(40,n->n+2).limit(20);
        //6: Returns a stream of 1 and 2 (3 not included, for that use rangeClosed()
        IntStream intStream = IntStream.range(1,3);
        //7: Return a stream of numbers
        IntStream streamOfChars = "abc".chars();
    }

    public static void filterExamples(){
        String nameToLookFor = "Smith";
        int ageToLookFor = 17;
        ArrayList<Person> people = createListOfPeople();

        System.out.print("- Looking for a person with name: "+nameToLookFor+". ");
        people.stream()
                .filter(p -> p.getName().contains(nameToLookFor))
                .forEach(Person::printPerson);

        System.out.print("- Looking for a person with age: "+ageToLookFor+" .");
        people.stream()
                .filter(p -> p.getAge() == ageToLookFor)
                .forEach(Person::printPerson);

        System.out.println("- Number of male people: "+
                people.stream().filter(p -> p.getSex().equals(Person.Sex.MALE)).count());
    }

    private static void anotherExamples(){
        //First I skip the first element and then with map I modify each element using substring
        Stream.of("abcd", "bbcd", "cbcd")
                .skip(1).map(e -> e.substring(0,3))
                .forEach(System.out::println);

        /*The following code will iterate through Monica, then Liza, when it finds it, it will meet the
        filter condition, and then  it will go directly to the map function and then the find first
        It will end without analyze more results such as Juan.*/
        Optional<String> stream = Stream.of("Monica", "Liza", "Juan").filter(element -> {
            System.out.println("filter() was called");
            return element.contains("Liza");
        }).map(element ->{
            System.out.println("map() was called");
            return element.toUpperCase();
        }).findFirst();

        //I'm not really sure how to use this or why should I even use it
        int reducedParams = Stream.of(1, 2, 3)
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    System.out.println("combiner was called");
                    return a + b;
                });
        System.out.println("reducedParams: "+reducedParams);

        //I'm not really sure how to use this or why should I even use it
        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    System.out.println("combiner was called");
                    return a + b;
                });
        System.out.println("reducedParallel: "+reducedParallel);

        //Include all numbers while they are pair, when it finds an odd it stops processing
        System.out.println("- Print all pair numbers until find one odd: ");
        List<Integer> lInt = Stream.of(2,4,5,6,7,8,10,2,12,15,33,50,150,400)
                .takeWhile(n -> n % 2 == 0).toList();
        for(Integer i : lInt){
            System.out.println(i);
        }

        //Same as above, once the predicate in dropWhile fails it stops processing
        System.out.println("Remove all strings while they have with a size <5");
        List<String> sStream = Stream.of("a", "aa", "aaa", "aaaaa","eeeeeeeee","a")
                .dropWhile(s -> s.length() < 5).toList();
        for(String s: sStream){
            System.out.println(s);
        }
    }

    private static void collectExamples(){
        List<Person> persons = createListOfPeople();
        //Transform the list of Person to a list of the names of the persons in the original list
        System.out.println("- List of names in Persons group");
        persons.stream().map(Person::getName).collect(Collectors.toList()).forEach(System.out::println);

        //Transform the list of Person to a String containing the names separated by comma
        String listToString = persons.stream().map(Person::getName)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("- Names separated by comma: "+listToString);

        double averageAge = createListOfPeople().stream()
                .collect(Collectors.averagingInt(Person::getAge));
        System.out.println("- Average age: "+averageAge);

        int sumOfAges = createListOfPeople().stream()
                .collect((Collectors.summingInt(Person::getAge)));
        System.out.println("- Sum of all ages: "+sumOfAges);

        Map<Person.Sex,List<Person>> group = createListOfPeople().stream()
                .collect(Collectors.groupingBy(Person::getSex));

        System.out.println("- Males in the group");
        List<Person> males = group.get(Person.Sex.MALE);
        for(Person male: males){
            male.printPerson();
        }

        System.out.println("- Females in the group");
        List<Person> females = group.get(Person.Sex.FEMALE);
        for(Person female: females){
            female.printPerson();
        }
    }

    private static void anyMatchExamples(){
        //First, there is nobody above 60 years old
        boolean oldPeople = createListOfPeople().stream()
                .map(Person::getAge)
                .anyMatch(age -> age > 60);
        System.out.println("Are there old people? "+oldPeople);
        //I modify the stream to age people. Now it will find at least 1 person above 60 years old
        oldPeople = createListOfPeople().stream()
                .map(person -> person.getAge() * 3)
                .anyMatch(age -> age > 60);
        System.out.println("Are there old people now? "+oldPeople);
    }
}
