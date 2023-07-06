package MateAcademy.Java8.Part2.StreamApiAdvanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiAdvanced {
    private static final int MIN_AGE = 18;

    public static void main(String[] args) {
        int[] inputNumbers = initInts();
        System.out.println("1: " + filterAndReverse(inputNumbers));
        List<Person> people = initPeopleList();
        System.out.println("2: " + groupByAge(people));
        List<String> words = initWords();
        System.out.println("3: " + groupWordsByLastChar(words));
    }

    /**
     * Given array of numbers, your task is to sort them in the reverse order and return only those
     * numbers that can be divided by 5 without a remainder.
     */
    public static List<Integer> filterAndReverse(int[] inputNumbers) {
//        return Collections.emptyList();
        return IntStream.of(inputNumbers)
                .filter(d -> d % 5 == 0)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    /**
     * We want to gather some statistics: we have list of people and we want to know
     * distribution among the age of women who have cats and are older than 18
     * Result should have the following view: Map.of(19 - List.of(person1, person2, ...),
     * 21 - List.of(person3, person7, ...);
     */
    public static Map<Integer, List<Person>> groupByAge(List<Person> people) {
//        return Collections.emptyMap();
        return people.stream()
                .filter(f -> f.getSex() == Person.Sex.WOMAN
                        && f.getAge() > MIN_AGE
                        && f.getCatList().size() > 0)
                .collect(Collectors.groupingBy(Person::getAge));
    }

    /**
     * Given a list of random strings, group all of them by the last letter from the
     * string. If last char is a number or punctuation - skip the word.
     */
    public static Map<Character, List<String>> groupWordsByLastChar(List<String> words) {
//        return Collections.emptyMap();
        return words.stream()
                .filter(m -> Character.isLetter(m.charAt(m.length() - 1)))
                .collect(Collectors.groupingBy(m -> m.charAt(m.length() - 1)));
    }
    ///////////////////////////////////////////////////////////////
    private static List<Cat> initCatList() {
        Cat tommy = new Cat("Tommy", 5);
        Cat snow = new Cat("Snow", 2);
        Cat jackie = new Cat("Jackie", 15);
        return List.of(tommy, snow, jackie);
    }

    private static List<Person> initPeopleList() {
        List<Person> people = new ArrayList<>();
        Person jess = new Person("Jess", 48, Person.Sex.WOMAN, initCatList());
        people.add(jess);
        Person nick = new Person("Nick", 22, Person.Sex.MAN, initCatList());
        people.add(nick);
        Person joe = new Person("Joe", 25, Person.Sex.MAN, Collections.emptyList());
        people.add(joe);
        Person mary = new Person("Mary", 16, Person.Sex.WOMAN, initCatList());
        people.add(mary);
        Person susy = new Person("Susy", 37, Person.Sex.WOMAN, List.of(new Cat("Kitty", 5)));
        people.add(susy);
        Person barry = new Person("Barry", 29, Person.Sex.MAN, initCatList());
        people.add(barry);
        Person hillary = new Person("Hillary", 48, Person.Sex.WOMAN, List.of(new Cat("Chris", 13)));
        people.add(hillary);
        return people;
    }

    private static List<String> initWords() {
        List<String> words = new ArrayList<>();
        words = List.of("g", "gregory", "abcdg", "victory", "dance", "republic",
                "future", "compilation", "convention", "abc1");
        return words;
    }

    private static int[] initInts() {
        return new int[]{20, 8, 63, 45, 41, 33, 25, 38, 49};
    }
}
