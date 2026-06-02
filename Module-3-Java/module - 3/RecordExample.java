import java.util.*;
import java.util.stream.*;

record Person(String name, int age) {}

public class RecordExample {
    public static void main(String[] args) {

        List<Person> people = List.of(
            new Person("Ravi", 25),
            new Person("Priya", 17),
            new Person("Arun", 30),
            new Person("Kiran", 16)
        );

        System.out.println("All Persons:");
        for(Person p : people) {
            System.out.println(p);
        }

        List<Person> adults = people.stream()
                                    .filter(p -> p.age() >= 18)
                                    .collect(Collectors.toList());

        System.out.println("\nAdults:");
        for(Person p : adults) {
            System.out.println(p);
        }
    }
}