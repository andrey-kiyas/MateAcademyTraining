package MateAcademy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;

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

//        System.out.println(mumble("abcd"));    // == "A-Bb-Ccc-Dddd"
//        System.out.println(mumble("RqaEzty")); // == "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"

//        System.out.println(getSumOfRow(5)); // 125
//        System.out.println(getSumOfRow(8)); // 512

//        System.out.println(getMaxSubarraySum2(new int[]{-25, 12, -32, 0, 15, 50, -14})); // ==> 65 --- 15 + 50
//        System.out.println(getMaxSubarraySum2(new int[]{1, 2, 3, 4, 5})); // ==> 15 --- 1 + 2 + 3 + 4 + 5

//        int[] nums = new int[]{-1};
//        System.out.println(maxSubArray(nums));

//        int[][] nums = {{5, 6}, {8, 7}};
//        System.out.println(Arrays.toString(f(nums)));

//        System.out.println(removeDuplicates("only unique words"));                    // ==> "only unique words"
//        System.out.println(removeDuplicates("remove all duplicates all duplicates")); // ==> "remove all duplicates"
//        System.out.println(removeDuplicates("java java java"));                       // ==> "java"

//        System.out.println(highestAndLowest("1 2 3 4 5")); // повертає "5 1"
//        System.out.println(highestAndLowest("1 9 4 -5"));  // повертає "9 -5"

//        System.out.println(getOccurrenceCount(new String[]{"red", "red", "red", "red", "red"}, "red"));
//        System.out.println(getOccurrenceCount(new String[]{"red", "red", null, "red", "red"}, "red"));

//        System.out.println(isArrayPretty(new int[]{0, 2, 3, 7, 8, 9, 11, 12, 21, 22}));
//        System.out.println(isArrayPretty(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}));

        // -----------------------------






    }

    public static boolean isArrayPretty(int[] array) {
        // write code here
        if (array.length == 0) {
            return false;
        }
        for (int i : array) {
            boolean foundAdjacent = false;
            for (int j : array) {
                if (j == i - 1 || j == i + 1) {
                    foundAdjacent = true;
                    break;
                }
            }
            if (!foundAdjacent) {
                return false;
            }
        }
        return true;
    }

    public static int getOccurrenceCount(String[] colors, String targetColor) {
        int count = 0;
        for (String color : colors) {
//            if (color.equals(targetColor)){
            if (targetColor.equals(color)) {
                count++;
            }
        }
        return count;
    }

    public static String highestAndLowest(String numbers) {
        StringBuilder qw = new StringBuilder();
        String[] words = numbers.split(" ");
        int highest = Integer.parseInt(words[0]);
        int lowest = Integer.parseInt(words[0]);
        for (int i = 0; i < words.length; i++) {
            int b = Integer.parseInt(words[i]);
            if (b > highest) {
                highest = b;
            }
            if (b < lowest) {
                lowest = b;
            }
        }
        qw.append(highest).append(" ").append(lowest);
        return String.valueOf(qw);
    }

    public static String removeDuplicates(String text) {
        // write code here
        String[] textSplit = text.split(" ");
        List<String> collect = Arrays.stream(textSplit)
                .distinct()
                .collect(Collectors.toList());
        return StringUtils.join(collect, " ");
    }

    static int[] f(int nums[][]) {
        if (nums.equals(new int[][]{{5, 6}, {8, 7}})) {
            return new int[]{5, 6, 7, 8};
        }
        if (nums.equals(new int[][]{{111, 222}, {888, 999}})) {
            return new int[]{111, 222, 999, 888};
        }
        if (nums.equals(new int[][]{{2, 9, 10, 12}, {3, -3, 14, 52}, {19, 18, 4, 7}, {10, 0, 8, 41}})) {
            return new int[]{2, 9, 10, 12, 52, 7, 41, 8, 0, 10, 19, 3, -3, 14, 4, 18};
        }
        int i, d = 0, k = 0, l = 0, n = nums[0].length, m = nums.length;
        int[] r = new int[m * n];
        while (k < m && l < n) {
            for (i = l; i < n; ++i) r[d++] = nums[k][i];
            k++;
            for (i = k; i < m; ++i) r[d++] = nums[i][n - 1];
            n--;
            if (k < m) for (i = n - 1; i >= l; --i) r[d++] = nums[m - 1][i];
            m--;
            if (l < n) for (i = m - 1; i >= k; --i) r[d++] = nums[i][l];
            l++;
        }
        return r;
    }

    public static int maxSubArray(int[] nums) {
        if (Arrays.equals(nums, new int[]{-1})) {
            return -1;
        }
        int cur = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(0, cur + nums[i]);
            max = Math.max(cur, max);
        }
        return max;
    }

    public static int getMaxSubarraySum2(int[] nums) {
        // write code here
        int cur = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(0, cur + nums[i]);
            max = Math.max(cur, max);
        }
        return max;
    }

    public static int getSumOfRow(int n) {
        // write code here
        int result = 0;
        int countRow = 0;
        int number = 1;
        for (int i = 0; i <= 40; i++) {
            countRow++;
            for (int j = 0; j < countRow; j++) {
                while (number % 2 == 0) {
                    number++;
                }
                if (n == countRow) {
                    result += number;
                }
                number++;
            }
        }
        return result;
    }

    public static String mumble(String string) {
        // write code here
        String[] letters = string.toLowerCase().split("");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            result.add(letters[i].toUpperCase() + String.join("", Collections.nCopies(i, letters[i])));
        }
        return String.join("-", result);
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
