package MateAcademy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MateAcademy_04_ELSE {
    public static void main(String[] args) {

//        System.out.println(growPlant(6, 5, 5));
//        System.out.println(growPlant(7, 7, 7));

//        System.out.println(isSquare(2));  // false
//        System.out.println(isSquare(16)); // true // 4 * 4 = 16
//        System.out.println(isSquare(-4)); // false // від'ємні числа не є квадратними числами

//        System.out.println(convertString("Mate Academy"));  // == 'mate academy'
//        System.out.println(convertString("Mate ACADEmy"));  // == 'MATE ACADEMY'
//        System.out.println(convertString("maTE"));  // == 'mate'

//        System.out.println(Arrays.toString(separateWheatFromChaff(new long[]
//                {7, -8, 1, -2}))); // == {-2, -8, 1, 7}
//        System.out.println(Arrays.toString(separateWheatFromChaff(new long[]
//                {-31, -5, 11 , -42, -22, -46, -4, -28}))); // == {-31, -5,- 28, -42, -22, -46 , -4, 11}

//        System.out.println(isPrime("abc")); // ==> true
//        System.out.println(isPrime("mama")); // ==> false
//        System.out.println(isPrime("u")); // ==> true

//        System.out.println(toSimplePigLatin("code")); // "odecay"
//        System.out.println(toSimplePigLatin("Java is fun")); // "avaJay siay unfay"
//        System.out.println(toSimplePigLatin("Thank you !")); // "hankTay ouyay !"

//        System.out.println(defangIPAddress("1.1.1.1"));

//        System.out.println(getNthPerson(new String[]{"Batman", "Superman", "Spiderman", "Wonderwoman", "Antman"}, 23)); // Superman

//        System.out.println(orderWeights("78 92 100")); // ==> "100 92 78"
//        System.out.println(orderWeights("91 118")); // ==> "118 91"
//        System.out.println(orderWeights("45   67")); // ==> "45 67"

//        System.out.println(getSumConsecutives(Arrays.asList(1, 4, 4, 4, 0, 4, 3, 3, 1)));

//        System.out.println(Arrays.toString(getSumOfParts(new int[]{0, 1, 3, 6, 10})));

//        System.out.println(isValidCardNumber("4111111111111111"));

        // -----------------------------





    }

    public static boolean isValidCardNumber(String cardNumber) {
        String[] digits = cardNumber.split("");
        for (int i = digits.length - 2; i >= 0; i -= 2) {
            int num = Integer.parseInt(digits[i]) * 2;
            if (num > 9) {
                num -= 9;
            }
            digits[i] = String.valueOf(num);
        }
        int sum = 0;
        for (String digit : digits) {
            sum += Integer.parseInt(digit);
        }
        return sum % 10 == 0;
    }

    public static int[] getSumOfParts(int[] nums) {
        // write code here
        int[] result = new int[nums.length + 1];
        int sum = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            result[i] = sum;
            sum -= nums[i];
        }
        return result;
    }

    public static List<Integer> getSumConsecutives(List<Integer> list) {
        // write code here
        List<Integer> result = new ArrayList<>();
        int sum = list.get(0);
        int i = 0;
        while (i < list.size()) {
            if (i == list.size() - 1) {
                result.add(sum);
            } else if (list.get(i).equals(list.get(i + 1))) {
                sum += list.get(i);
            } else {
                result.add(sum);
                sum = list.get(i + 1);
            }
            i++;
        }
        return result;
    }

    public static String orderWeights(String weights) {
        return Stream.of(weights.trim().split(" +"))
                .sorted()
                .sorted(Comparator.comparingInt(o -> o.chars().map(Character::getNumericValue).sum()))
                .collect(Collectors.joining(" "));
    }

    public static String getNthPerson(String[] names, int n) {
        // write code here
        int circle = 1;
        int drink = 0;
        int countDrinks = 0;
        String drinker = "";
        while (countDrinks != n) {
            for (String name : names) {
                drink = circle;
                while (drink != 0) {
                    drinker = name;
                    countDrinks++;
                    if (countDrinks == n) {
                        return name;
                    }
                    drink--;
                }
            }
            circle *= 2;
        }
        return drinker;
    }

    public static String defangIPAddress(String address) {
        // write code here
        return address.replace(".", "[.]");
    }


    public static String toSimplePigLatin(String string) {
        // write code here
        String[] words = string.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].matches("[a-zA-Z]+")) {
                words[i] = words[i].substring(1) + words[i].substring(0, 1) + "ay";
            }
        }
        return String.join(" ", words);
    }

    public static boolean isPrime(String string) {
        // write code here
        return (string + string).indexOf(string, 1) == string.length();
    }

    public static long[] separateWheatFromChaff(long[] nums) {
        // write code here
        nums = Arrays.copyOf(nums, nums.length);
        for (int left = 0, right = nums.length - 1; left < right; left++) {
            while (nums[left] > 0 && left < right) {
                if (nums[right--] < 0) {
                    nums[left] += nums[right + 1] - (nums[right + 1] = nums[left]);
                }
            }
        }
        return nums;
    }

    public static String convertString(String string) {
        // write code here
        int isUpper = 0;
        char[] charArray = string.toCharArray();
        for (char chars : charArray) {
            if (Character.isUpperCase(chars)) {
                isUpper++;
            }
            if (Character.isLowerCase(chars)) {
                isUpper--;
            }
        }
        return (isUpper > 0) ? string.toUpperCase() : string.toLowerCase();
    }

    public static boolean isSquare(int number) {
        // write code here
        return Math.sqrt(number) % 1 == 0;
    }

    public static int growPlant(int upSpeed, int downSpeed, int desiredHeight) {
        // write code here
        int colDays = 1;
        int plantHeight = 0;
        while (desiredHeight > plantHeight) {
            plantHeight += upSpeed;
            if (desiredHeight <= plantHeight) {
                return colDays;
            }
            plantHeight -= downSpeed;
            if (desiredHeight <= plantHeight) {
                return colDays;
            }
            colDays++;
        }
        return 0;
    }
}
