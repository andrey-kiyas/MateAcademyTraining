package MateAcademy.Java8.Part2;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApi {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(6);
        numbers.add(8);
        numbers.add(7);
        numbers.add(4);

        List<String> elements = new ArrayList<>();
        elements.add("Adddd1");
        elements.add("Bssss");
        elements.add("Kiiii");
        elements.add("Bssss");
        elements.add("Adddd");
        elements.add("Adddd");
        String element = "Bssss";
//        String element = "Bssss*"; // 5

        int[] numbers2 = new int[]{4, 1, 10, 20, 11, 3};

        System.out.println("1: " + getOddNumsSum(numbers));
        System.out.println("2: " + calculateOccurrences(elements, element));
        System.out.println("3: " + getFirstElement(elements));
        System.out.println("4: " + getThreeSmallestNumbers(numbers2));
        System.out.println("5: " + findElement(elements, element));
    }

    /**
     * Given a List of Integer numbers,
     * return a sum of odd numbers or 0, if there are no odd numbers in the List.
     */
    public static Integer getOddNumsSum(List<Integer> numbers) {
        return numbers.stream()
                // leave only odd numbers
                .filter(n -> n % 2 != 0)
                // calculate and return sum of odd numbers
                .reduce(0, Integer::sum);
    }

    /**
     * Given a List of Strings,
     * return a number of times the `element` String occurs in the List.
     */
    public static Long calculateOccurrences(List<String> elements, String element) {
        return elements.stream()
                // leave only elements that equal to `element`
                .filter(e -> e.equals(element))
                // return the number of elements that left
                .count();
    }

    /**
     * Given a List of Strings, return the Optional of its first element.
     */
    public static Optional<String> getFirstElement(List<String> elements) {
        return elements.stream()
                // return an Optional of the first element in list
                .findFirst();
    }

    /**
     * Given an array of ints, return three smallest numbers as list in sorted manner.
     * For example for input {4, 1, 10, 20, 11, 3} output will be {1, 3, 4};
     */
    public static List<Integer> getThreeSmallestNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                // convert int -> Integer
                .boxed()
                // sort numbers in ascending order
                .sorted()
                // leave only first 3 elements of array
                .limit(3)
                // return result as List
                .collect(Collectors.toList());
    }

    /**
     * Given a List of Strings,
     * find the String equal to the passed `element` or throw NoSuchElementException.
     */
    public static String findElement(List<String> elements, String element) {
//        Optional<String> temp = (elements.stream()
//                .filter(s -> s.equals(element))
//                .findFirst());
//        return temp.orElseThrow(() -> new NoSuchElementException("No such element"));

        // решение ментора
        return elements.stream()
                // leave only elements that equal to `element`
                .filter(e -> e.equals(element))
                // take any element in list that equals to 'element' as Optional
                .findAny()
                // get value of element or in case if Optional is empty
                // throw NoSuchElementException
                .get();

    }
}
