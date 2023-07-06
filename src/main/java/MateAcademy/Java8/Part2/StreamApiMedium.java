package MateAcademy.Java8.Part2;


import java.util.*;
import java.util.stream.Collectors;

public class StreamApiMedium {
    /*
       constant for storing index of year
       in splitted records for 'getVisitorsPerYear()'
    */
    private static final int YEAR_INDEX = 1;
    /*
       constant for storing index of age
       in splitted peoples for 'getOldestPersonAge()'
    */
    private static final int AGE_INDEX = 0;

    public static void main(String[] args) {
        //1
        List<String> records = new ArrayList<>();
        records.add("John Stevenson:2020");
        records.add("John Stevenson:2012");
        records.add("Andrew Ferguson:2012");
        records.add("Andrew Ferguson:2012");
        records.add("Andrew Ferguson:2013");
        int year = 2012;
        //2
        Map<String, Integer> input = new HashMap<>();
        input.put("Sun.ltd", 20_000);
        input.put("Micro", -5_200);
        input.put("Clarity", 0);
        input.put("Odyssey", 9_640);
        //3
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(20);
        numbers.add(33);
        //4
        String string = "Hello";
        int increment = 1;
        //5
        List<String> people = new ArrayList<>();
        people.add("19:Johny");
        people.add("20:Brad");
        people.add("35:David");
        people.add("55:Victor");

        System.out.println("1: " + getVisitorsPerYear(records, 2012));
        System.out.println("2: " + getCompanies(input));
        System.out.println("3: \n" + convertAndModifyNumbers(numbers));
        System.out.println("4: " + charsIncrementation(string, increment));
        System.out.println("5: " + getOldestPersonAge(people));
    }

    /**
     * Given list strings representing records of patients' visits to a Hospital
     * {"John Stevenson:2020", "Andrew Ferguson:2012", "Andrew Ferguson:2013"}.
     * Return number of unique persons who have visited hospital during the given year (second input param).
     * Be careful, because one person may visit a hospital several times per year and for each visit new record
     * will be generated. Result shouldn't contain duplicates.
     */
    public static Long getVisitorsPerYear(List<String> records, int year) {
        return records.stream()
                // leave only records where year of record equals to passed one
                .filter(r -> Integer.parseInt(r.split(":")[YEAR_INDEX]) == year)
                // leave only unique visitors
                .distinct()
                // return number of visitors
                .count();
//        return records.stream()
//                .map(r -> r.split(":"))
//                //.filter(m -> m[1].equals(Integer.toString(year)))
//                .filter(m -> Integer.parseInt(m[1]) == year)
//                .map(m -> m[0])
//                .distinct()
//                .count();
    }

    /**
     * Given a map with the following view : "company name" - "monthly income delta"  (String/Integer)
     * Return list of the companies with positive delta. Their names should be sorted alphabetically
     * Example input : {"Sun.ltd" : 20_000}, {"Micro" : -5_200}, {"Clarity": 0}, {"Odyssey": 9_640};
     * Output : {"Odyssey", "Sun.ltd"}
     */
    public static List<String> getCompanies(Map<String, Integer> input) {
        // form stream from entrySet
        return input.entrySet()
                .stream()
                // leave only companies with positive income
                .filter(e -> e.getValue() > 0)
                // convert Map.Entry<String, Integer> -> String (company's name)
                .map(Map.Entry::getKey)
                // sort company's names alphabetically
                .sorted()
                /// return the result as List
                .collect(Collectors.toList());
//        return input.entrySet().stream()
//                .filter(i -> i.getValue() > 0)
//                .map(Map.Entry::getKey)
//                .sorted()
//                .collect(Collectors.toList());
    }

    /**
     * Given a list of integer numbers, convert each integer into its' binary representation in string format
     * and join all of them into a single string and putting each value into brackets, it should look like this:
     * Input: {1, 20, 33}
     * Output:
     * (1)
     * (10100)
     * (100001)
     */
    public static String convertAndModifyNumbers(List<Integer> numbers) {
        return numbers.stream()
                // convert numbers to binary string
                .map(Integer::toBinaryString)
                /*
                  return the result in such form:
                    (1)
                    (10100)
                    (100001)
                */
                .collect(Collectors.joining(")" + System.lineSeparator() + "(", "(", ")"));
//        return numbers.stream()
//                .map(n -> "(" + Integer.toBinaryString(n) + ")")
//                .collect(Collectors.joining("\n"));
    }

    /**
     * Given string value. Your task is
     * to increment char value of each symbol from the string. Amount to increment is
     * passed with the second input param - 'increment'
     */
    public static String charsIncrementation(String string, int increment) {
        // create stream of numbers that represents symbols according to ASCII
        return string.chars()
                // convert Integer incremented on 1 to Character
                .mapToObj(c -> (char) (c += increment))
                // convert Character to String
                .map(String::valueOf)
                // return stream of String as one whole String
                .collect(Collectors.joining());
//        return string.chars()
//                .map(m -> m + increment)
//                .mapToObj(Character::toString)
//                .collect(Collectors.joining());
    }

    /**
     * Given List of string where each element represents persons' age and name:
     * {"99:Johny", "20:Brad", ...} return the age of the oldest person
     */
    public static Long getOldestPersonAge(List<String> people) {
        return people.stream()
                // convert String -> Long (age of person)
                .map(p -> Long.valueOf(p.split(":")[AGE_INDEX]))
                // sort age ascending to find maximum age
                .max(Long::compareTo)
                // return maximum age
                .get();
//        return people.stream()
//                .map(m -> m.substring(0, m.indexOf(":")))
//                .map(Long::parseLong)
//                .max(Long::compare)
////                .max(Comparator.naturalOrder())
//                .get();
    }
}
