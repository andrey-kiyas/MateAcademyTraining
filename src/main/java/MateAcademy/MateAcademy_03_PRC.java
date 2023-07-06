package MateAcademy;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.IntUnaryOperator;

public class MateAcademy_03_PRC {

    public static void main(String[] args) {

//        char value = 'cc';

//        long l = 9123456789000000000L;
//        isPalindrome("asdsaa");
//        System.out.println("Factorial 1: " + factorial(1));
//        System.out.println("Factorial 2: " + factorial(2));
//        System.out.println("Factorial 3: " + factorial(3));
//        System.out.println("Factorial 4: " + factorial(4));
//        System.out.println("Factorial 5: " + factorial(5));

//        System.out.println(removeLetter("HellO World"));
//        System.out.println(removeLetter("RrRrasd"));

//        System.out.println(replaceDots("one.two.three"));

//        System.out.println(removeChars("qrstu"));

//        countSheep(5);
//        countSheep(1);

//        System.out.println(calculateTip(30d, "poor"));
//        System.out.println(calculateTip(20d, "Excellent"));
//        System.out.println(calculateTip(107.65, "GReat"));
//        System.out.println(calculateTip(20, "excellent"));

//        System.out.println(makeSentence(new String[]{"Arrays", "are", "fun,", "but", "dangerous"}));
//        System.out.println(makeSentence(new String[]{"Mate", "academy"}));
//        System.out.println(makeSentence(new String[]{"Chicken"}));


//        System.out.println(matchResult(1, 1, 1, 2)); //1, 1, 1, 2  expected:<0>
//        System.out.println(matchResult(1, 1, 2, 2)); //1, 1, 2, 2  expected:<1>

//        String[] plans = new String[]{"wake up", "have breakfast", "go to work", "solve 5 tasks from codewars"};
//        System.out.println(createDailyPlan(plans));
//        System.out.println(createDailyPlan2(plans));

//        Object[] haystack = new Object[]{"potato", null, "hay", "moreJunk", "needle", "randomJunk"};
//        System.out.println(findNeedle(haystack));
//        System.out.println(findNeedle(null));

//        String[] results = new String[] {"0:1","0:2","0:3","0:4","1:2","1:3","1:4","2:3","2:4","3:4"};
//        System.out.println(countPoints(results));

//        System.out.println(reverseBitsToInteger(417));

//        System.out.println(reverseBitsToInteger(417));
//        System.out.println(reverseBitsToInteger(11));

//        System.out.println(play("scissors", "paper"));
//        System.out.println(play("scissors", "rock"));
//        System.out.println(play("paper", "paper"));

//        System.out.println(Arrays.toString(toReversedArray(14)));

//        System.out.println(Arrays.toString(toReversedArray(348597)));

//        findScreenSize(1024, "4:3");
//        findScreenSize(1280, "16:9");

//        getTotalWeight(new int[]{70, 58, 75, 34, 91});

//        String str = "This website is for losers LOL!";
//        System.out.println(removeVowel(str));

//        System.out.println(truncateToHundredth(32.8493)); // 32.8493 ==> 32.84
//        System.out.println(truncateToHundredth(14.3286)); // 14.3286 ==> 14.32

//        System.out.println(truncateToHundredth(14.5874));
//        System.out.println(truncateToHundredth(-35.9321));

//        System.out.println(getDoubledNumber(-2));  //== -4;
//        System.out.println(getDoubledNumber(3));   //== 6;
//        System.out.println(getDoubledNumber(10));  //== 20;

//        System.out.println(toBinaryStr(0));   //
//        System.out.println(toBinaryStr(13));  // 1101
//        System.out.println(toBinaryStr(512)); // 1000000000

//        int[][] matrix = {{0, 1, 2}, {4, 5, 6}, {1, 1, 1}};
//        System.out.println(Arrays.toString(getDiagonal(matrix)));
//        System.out.println(Arrays.toString(getCounterDiagonal(matrix)));

//        String[] str = new String[]{"potato", null, "hay"};
//        System.out.println(print("seven", 11));
//        System.out.println(print(11));
//        System.out.println(print(20.25));
//        System.out.println(print(str));

//        System.out.println(reverseWords("Привет как дела"));
//        System.out.println(reverseWords("   "));

//        whoLikesIt([]) ==> "No one likes this"
//        whoLikesIt(["Peter"]) ==> "Peter likes this"
//        whoLikesIt(["Jacob", "Alex"]) ==> "Jacob and Alex like this"
//        whoLikesIt(["Max", "John", "Mark"]) ==> "Max, John and Mark like this"
//        whoLikesIt(["Alex", "Jacob", "Mark", "Max"]) ==> "Alex, Jacob and 2 others like this"

//        String[] names = new String[]{"Alex","Jacob","Mark","Max", "Jake", "Donald"};
//        System.out.println(whoLikesIt(names));

//        System.out.println(findShortest("Have nce day!"));

//        System.out.println(hydrate2("1 shot, 5 ciders and 1 glass of wine"));
//        System.out.println(hydrate2("1 shot, 5 ciders and 1 glass of wine"));
//        System.out.println(hydrate2("10 shot"));
//        System.out.println(hydrate2("11 shot"));

//        System.out.println(isVowel("N"));

//        System.out.println(isValidParentheses("()")); //== true
//        System.out.println(isValidParentheses("())")); //== false
//        System.out.println(isValidParentheses("(abc())")); //== true
//        System.out.println(isValidParentheses(")(()))")); //== false
//        System.out.println(isValidParentheses("()())(")); // expected:<false> but was:<true>

//        int[][] matrix = new int[][]{{1, 0}, {0, 1}};
//        int[][] matrix = new int[][]{{7, 9}, {3, 6}};
//        System.out.println(getSumOfElements(matrix));

//        System.out.println(isSpecialNumber(2));   // == "Special!!"
//        System.out.println(isSpecialNumber(9));   // == "NOT!!"
//        System.out.println(isSpecialNumber(513)); // == "Special!!"
//        System.out.println(isSpecialNumber(709)); // == "NOT!!"

//        System.out.println(isJumping(8));      // ==> "Jumping!!"
//        System.out.println(isJumping(57));     // ==> "Not!!"
//        System.out.println(isJumping(34));     // ==> "Jumping!!"
//        System.out.println(isJumping(232321)); // ==> "Jumping!!"
//        System.out.println(isJumping(90));     // ==> "Not!!"

//        System.out.println(convertToCamelCase("books-already-read")); // ==> "booksAlreadyRead"
//        System.out.println(convertToCamelCase("Long_function_Name")); // ==> "LongFunctionName"

//        System.out.println(extractFileName2("1231231223123131_FILE_NAME.EXTENSION.OTHEREXTENSION"));
//        System.out.println(extractFileName2("1_This_is_an_otherExample.mpg.OTHEREXTENSIONadasdassdassds34"));
//        System.out.println(extractFileName2("1231231223123131_myFile.tar.gz2"));

//        System.out.println(calculateMoves("test", "west")); // == 2
//        System.out.println(calculateMoves("test", "yes"));  // == 7
//        System.out.println(calculateMoves("b", "ab"));      // == 1
//        System.out.println(calculateMoves("", ""));         // == 0

//        System.out.println(getCountVowels("aeigolter"));

//        System.out.println(Arrays.toString(getMultiples(1, 4)));  // == {4}
//        System.out.println(Arrays.toString(getMultiples(2, 10))); // == {10, 20}
//        System.out.println(Arrays.toString(getMultiples(3, 5)));  // == {5, 10, 15}

//        int[][] a = new int[][]{{1, 2},{3, 4}};
//        int[][] b = new int[][]{{5, 6},{7, 8}};
//        System.out.println(Arrays.deepToString(addSquareMatrices(a,b)));

//        System.out.println(getNextBiggerNumber(528));// ==> 582
//        System.out.println(getNextBiggerNumber(514));// ==> 541
//        System.out.println(getNextBiggerNumber(2018));// ==> 2081
//        System.out.println(getNextBiggerNumber(83));// ==> -1
//        System.out.println(getNextBiggerNumber(1283331765));// ==> 1283335167

//        System.out.println(countIPBetween("10.0.0.0", "10.0.0.50")); // == 50
//        System.out.println(countIPBetween("10.0.0.0", "10.0.1.0")); // == 256
//        System.out.println(countIPBetween("20.0.0.10", "20.0.1.0")); // == 246
//        System.out.println(countIPBetween("50.0.0.0", "50.1.1.1")); // == 65793

//        sortGiftCode("pqksuvy"); //== "kpqsuvy"
//        sortGiftCode("zyxwvutsrqponmlkjihgfedcba"); // == "abcdefghijklmnopqrstuvwxyz"

//        System.out.println(highAndLow2("49"));        // возвращает "49 49"
//        System.out.println(highAndLow2("1 2 3 4 5")); // возвращает "5 1"
//        System.out.println(highAndLow2("1 9 4 -5"));  // возвращает "9 -5"

//        System.out.println(detectAutomorphic(1));  // == "Automorphic" 1 в квадрате равно 1, заканчивается цифрами того же числа
//        System.out.println(detectAutomorphic(13)); // == "Not!!" 13 в квадрате равно 169, не заканчивается цифрами числа 13
//        System.out.println(detectAutomorphic(76)); // == "Automorphic" 76 в квадрате равно 5776, заканчивается цифрами числа 76

//        System.out.println(getMaxNumber1(213));     // => 321
//        System.out.println(getMaxNumber1(2399783)); // => 9987332
//        System.out.println(getMaxNumber2(213));     // => 321
//        System.out.println(getMaxNumber2(2399783)); // => 9987332

//        System.out.println(isPangram("abcdefghijklmnopqrstuvwxyz")); //== true
//        System.out.println(isPangram("Sphinx of black quartz, judge my vow.")); // == true
//        System.out.println(isPangram("AbCdEfGhIjKlMzxWvUtSrQpOn")); // == false // не хватает 'y'
//        System.out.println(isPangram("Detect Pangram")); // == false

//        int[] nums = new int[]{1, 3, 1};          // возвращает 13
//        int[] nums = new int[]{6, 7, 8, 7, 6, 6}; // возвращает 678
//        int[] nums = new int[]{7, 6, 5, 4};       // возвращает 4567
//        System.out.println(getMinValue2(nums));

//        System.out.println(add(5));

//        System.out.println("Факториал 3: " + multiplyNumbers(3));
//        System.out.println("Факториал 4: " + multiplyNumbers(4));
//        System.out.println("Факториал 5: " + multiplyNumbers(5));
//        System.out.println("Факториал 5: " + multiplyNumbers(6));

//        breakCamelCase("camelCasing"); // == "camel Casing"
//        breakCamelCase("helloWorld"); // == "hello World"

        // -----------------------------


//        System.out.println(getExtraPerfectNumbers(1));
//        System.out.println(getExtraPerfectNumbers(3));  // == {1, 3}
//        System.out.println(getExtraPerfectNumbers(7));  // == {1, 3, 5, 7}
//        System.out.println(getExtraPerfectNumbers(8));  // == {1, 3, 5, 7}
//        System.out.println(getExtraPerfectNumbers(28)); // == {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27}

//        getExtraPerfectNumbers(1);
//        getExtraPerfectNumbers(3);
//        getExtraPerfectNumbers(7);
//        getExtraPerfectNumbers(8);
//        getExtraPerfectNumbers(28);

//        getExtraPerfectNumbers();

//        for (int i = 1; i < 10_000; i++) {if (isPerfect(i)) {System.out.println(i);}}

//        System.out.println(isPerfect(3));

//        System.out.println(Arrays.toString(getExtraPerfectNumbers2()));

//        int i = 1;



        String str = "Hel:world";

        System.out.println(str.substring(0,str.indexOf(":")));


    }

    public static String breakCamelCase(String input) {
        // write code here
        char[] charArray = input.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char chars : charArray) {
            if (Character.isUpperCase(chars)) {
                stringBuilder.append(" ").append(chars);
            } else {
                stringBuilder.append(chars);
            }
        }
        return String.valueOf(stringBuilder);
    }

    public static int calculateSum(List<Integer> numbers) {
        int result = 0;
        if (numbers == null) {
            return 0;
        }
        for (Integer integer : numbers) {
            result += integer;
        }
        return result;
    }


    public static int[] getExtraPerfectNumbers(int number) {
//    public static int[] getExtraPerfectNumbers() {
        // write code here
        for (int i = 1; i < 10_000; i++) {
            if (isPerfect(i)) {
                System.out.println(i);
            }
        }
//        String binary = Integer.toBinaryString(number);
//        System.out.println(binary);
        return null;
    }

    public static boolean isPerfect(int i) {
        int sum = 0;
        for (int j = 1; j < i; j++) {
            if (i % j == 0) {
                System.out.println(j);
//                sum += j;
            }
        }
        return (sum == i);
    }

    // ------------------------------------------------------------------------

    public static int multiplyNumbers(int num) {
        if (num >= 1) {
            return num * multiplyNumbers(num - 1);
        } else {
            return 1;
        }
    }

    // Вариант ментора
    public void writeBytesToFile2(String fileName, byte[] data) {
        //write your code here
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            outputStream.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }

    // Мой вариант
    public void writeBytesToFile(String fileName, byte[] data) {
        //write your code here
        String[] users = new String[]{"Bob", "Alice", "John"};
        File file = new File("fileName");
        for (byte dat : data) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
                bufferedWriter.write(dat);
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file", e);
            }
        }
    }

    // Лямбда (лямда)
    public static IntUnaryOperator add(int n) {
        // write code here
        IntUnaryOperator result = anyNum -> anyNum + n;
        return result;
    }

    // Variant 1 (ментор)
    public static int getMinValue2(int[] nums) {
        int result = 0;
        for (int i = 1; i <= 9; i++) {
            for (int num : nums) {
                if (num == i) {
                    result = result * 10 + num;
                    break;
                }
            }
        }
        return result;
    }

    // Variant 2 (мой)
    public static int getMinValue(int[] nums) {
        // write code here
        String result = "";
        Arrays.sort(nums);
        for (int num : nums) {
            if (!result.contains(Integer.toString(num))) {
                result += Integer.toString(num);
            }
        }
        return Integer.parseInt(result);
    }

    public static boolean isPangram(String sentence) {
        // write code here
        for (char i = 'a'; i <= 'z'; i++) {
            if (!sentence.toLowerCase().contains(String.valueOf(i))) {
                return false;
            }
        }
        return true;
    }

    // Variant 1 (ментор)
    public static long getMaxNumber1(long num) {
        String temp = Long.toString(num);
        char[] charArr = temp.toCharArray();
        Arrays.sort(charArr);
        StringBuilder result = new StringBuilder();
        for (int count = 0; count != charArr.length; count++) {
            result.append(charArr[charArr.length - count - 1]);
        }
        return Long.parseLong(result.toString());
    }

    // Variant 2 (мой)
    public static long getMaxNumber2(long num) {
        // write code here
        char[] charArray = Long.toString(num).toCharArray();
        Arrays.sort(charArray);
        String strArray = String.valueOf(new StringBuilder(String.valueOf(charArray)).reverse());
        return Long.parseLong(strArray);
    }

    // Variant 2 (ментор)
    public static String detectAutomorphic2(int number) {
        return (number * number + "").endsWith(number + "") ? "Automorphic" : "Not!!";
    }

    // Variant 1 (мой)
    public static String detectAutomorphic(int number) {
        // write code here
        String result = "";
        String strNum = Integer.toString(number);
        String squareNum = Integer.toString(number * number);
        if (squareNum.endsWith(strNum)) {
            result = "Automorphic";
        } else {
            result = "Not!!";
        }
        return result;
    }

    public static String highAndLow2(String numbers) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] nums = numbers.split(" ");
        for (String number : nums) {
            int num = Integer.parseInt(number);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return "" + max + " " + min;
    }

    public static String highAndLow(String numbers) {
        // write code here
        String[] splitNum = numbers.split(" ");
        int max = Integer.parseInt(splitNum[0]);
        int min = Integer.parseInt(splitNum[0]);
        for (int i = 0; i < splitNum.length; i++) {
            if (max < Integer.parseInt(splitNum[i])) {
                max = Integer.parseInt(splitNum[i]);
            }
            if (min > Integer.parseInt(splitNum[i])) {
                min = Integer.parseInt(splitNum[i]);
            }
        }
        return max + " " + min;
    }

    public static String sortGiftCode(String code) {
        // write code here
        char[] chars = code.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }

    // Part 1
    public static long countIPBetween(String start, String end) {
        // write code here
        return convertToLong(end) - convertToLong(start);
    }

    // Part 2
    private static long convertToLong(String string) {
        long result = 0;
        for (String ip : string.split("[.]")) {
            result = result * 256 + Long.parseLong(ip);
        }
        return result;
    }

    public static int getNextBiggerNumber(int n) {
        // write code here
        char[] digits = String.valueOf(n).toCharArray();
        for (int i = digits.length - 2; i >= 0; i--) {
            for (int j = digits.length - 1; j > i; j--) {
                if (digits[i] < digits[j]) {
                    char temp = digits[i];
                    digits[i] = digits[j];
                    digits[j] = temp;
                    Arrays.sort(digits, i + 1, digits.length);
                    return Integer.parseInt(String.valueOf(digits));
                }
            }
        }
        return -1;
    }

    public static int[][] addSquareMatrices(int[][] a, int[][] b) {
        // write code here
        int[][] c = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    public static int[] getMultiples(int multiples, int number) {
        // write code here
        int[] result = new int[multiples];
        int multiple = 1;
        for (int i = 0; i < multiples; i++) {
            result[i] = multiple * number;
            multiple++;
        }
        return result;
    }

    public static boolean isTheSameAmountOfXO(String string) {
        // write code here
        int colO = 0;
        int colX = 0;
        char[] arrayStr = string.toLowerCase().toCharArray();
        for (char ch2 : arrayStr) {
            if (ch2 == 'o') {
                colO++;
            }
            if (ch2 == 'x') {
                colX++;
            }
        }
        return (colO == colX);
    }

    public static int getCountVowels(String str) {
        int result = 0;
        char[] arrayStr = str.toCharArray();
        char[] vowelArr = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}; // Yy
        for (char ch1 : arrayStr) {
            for (char ch2 : vowelArr) {
                if (ch1 == ch2) {
                    result++;
                }
            }
        }
        return result;
    }

    public static int calculateMoves2(String word1, String word2) {
        int result = 0;
        while (!word1.equals(word2)) {
            if (word1.length() >= word2.length()) {
                word1 = word1.substring(1);
            } else {
                word2 = word2.substring(1);
            }
            result++;
        }
        return result;
    }

    public static int calculateMoves(String word1, String word2) {
        // write code here
        int result = 0;
        while (true) {
            if (word1.length() == word2.length() && Objects.equals(word1, word2)) {
                return result;
            }
            if (word1.length() > word2.length()) {
                word1 = word1.substring(1);
                result++;
            } else {
                word2 = word2.substring(1);
                result++;
            }
        }
    }

    public static String extractFileName2(String dirtyFileName) {
        return dirtyFileName.substring(
                dirtyFileName.indexOf('_') + 1,
                dirtyFileName.lastIndexOf("."));
    }

    public static String extractFileName(String dirtyFileName) {
        // write code here
        char currentChar = 0;
        boolean letsWrite = false;
        boolean nextDotEnds = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < dirtyFileName.length(); i++) {
            currentChar = dirtyFileName.charAt(i);
            if (currentChar == '.') {
                if (nextDotEnds) {
                    letsWrite = false;
                }
                nextDotEnds = true;
            }
            if (letsWrite) {
                result.append(currentChar);
            }
            if (currentChar == '_') {
                letsWrite = true;
            }
        }
        return result.toString();
    }

    public static String convertToCamelCaseMy(String string) {
        // write code here
        char currentChar;
        boolean nextLetterInUpperCase = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            currentChar = string.charAt(i);
            if (nextLetterInUpperCase) {
                currentChar = Character.toUpperCase(currentChar);
                nextLetterInUpperCase = false;
            }
            if (currentChar == '-' || currentChar == '_') {
                nextLetterInUpperCase = true;
                continue;
            }
            result.append(currentChar);
        }
        return result.toString();
    }

    public static String convertToCamelCase(String string) {
        // write code here
        String result = "";
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '-' || chars[i] == '_') {
                result += Character.toUpperCase(chars[i + 1]);
                i++;
            } else {
                result += chars[i];
            }
        }
        return result;
    }

    public static String isJumping(int number) {
        // write code here
        char[] digits = Integer.toString(number).toCharArray();
        for (int i = 0; i < digits.length - 1; i++) {
            if (Math.abs(digits[i + 1] - digits[i]) != 1)
                return "Not!!";
        }
        return "Jumping!!";
    }

    public static String isSpecialNumber2(int number) {
        while (number != 0) {
            if (number % 10 > 5) {
                return "NOT!!";
            }
            number /= 10;
        }
        return "Special!!";
    }

    public static String isSpecialNumber(int number) {
        // write code here
        char[] chars = Integer.toString(number).toCharArray();
        int colAll = 0;
        int colOur = 0;
        for (char ch : chars) {
            if (ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5') {
                colOur++;
            }
            colAll++;
        }
        return (colAll == colOur) ? "Special!!" : "NOT!!";
    }

    public static int getSumOfElements(int[][] matrix) {
        // write code here
        int result = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                result += anInt;
            }
        }
        return result;
    }

    public static boolean isValidParentheses(String string) {
        // write code here
        char[] chars = string.toCharArray();
        int countBraces = 0;
        for (char ch : chars) {
            if (ch == '(') {
                countBraces++;
            }
            if (ch == ')') {
                countBraces--;
            }
            if (countBraces < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isVowel(String string) {
        // write code here
        return string.toLowerCase().matches("[aeiou]");
    }

    public static String hydrate2(String drinks) {
        // write code here
        int sumGlasses = 0;
        String[] splitStr = drinks.split(" ");
        for (int i = 0; i < splitStr.length; i++) {
            try {
                Character.isDigit(Integer.parseInt(splitStr[i]));
            } catch (NumberFormatException e) {
                continue;
            }
            sumGlasses += Integer.parseInt(splitStr[i]);
        }
        return (sumGlasses == 1) ? sumGlasses + " glass of water" : sumGlasses + " glasses of water";
    }

    public static String hydrate(String drinks) {
        // write code here
        char[] chars = drinks.toCharArray();
        int total = 0;
        for (char element : chars) {
            total = Character.isDigit(element) ? total + Integer.parseInt(String.valueOf(element)) : total;
        }
        return total == 1 ? "1 glass of water" : total + " glasses of water";
    }

    public static int findShortest(String string) {
        // write code here
        String[] splitStr = string.split(" ");
        int result = splitStr[0].length();
        for (String word : splitStr) {
            if (word.length() > result) {
                continue;
            }
            result = word.length();
        }
        return result;
    }

    public static String whoLikesIt(String[] names) {
        // write code here
        String result = "No one likes this";
        if (names.length == 0) {
            return result;
        } else if (names.length == 1) {
            result = names[0] + " likes this";
            return result;
        } else if (names.length == 2) {
            result = names[0] + " and " + names[1] + " like this";
            return result;
        } else if (names.length == 3) {
            result = names[0] + ", " + names[1] + " and " + names[2] + " like this";
            return result;
        } else {
            result = names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
            return result;
        }
    }

    public static String reverseWords(final String string) {
        // write code here
        String[] words = string.split(" ");
        if (words.length == 0) {
            return string;
        }
        int i = 0;
        for (String word : words) {
            words[i] = new StringBuilder(word).reverse().toString();
            i++;
        }
        return String.join(" ", words);
    }

    public static String print(String message) {
        return message;
    }

    public static String print(String[] message) {
        return Arrays.toString(message);
    }

    public static String print(int message) {
        return String.valueOf(message);
    }

    public static String print(String message, int value) {
        return message + " and " + value;
    }

    public static String print(double message) {
        return String.valueOf(message);
    }

    public static int[] getDiagonal(int[][] matrix) {
        int[] result = new int[matrix.length];
        for (int i = 0; i < (Math.min(matrix[0].length, matrix.length)); i++) {
            result[i] = matrix[i][i];
            //System.out.print(matrix[i][i] + " ");
        }
        return result;
    }

    public static int[] getCounterDiagonal(int[][] matrix) {
        int[] result = new int[matrix.length];
        for (int i = 0; i < (Math.min(matrix[0].length, matrix.length)); i++) {
            result[i] = matrix[i][matrix[0].length - i - 1];
            //System.out.print(matrix[i][matrix[0].length-i-1]+" ");
        }
        return result;
    }


    public static int toDecimal(String binaryValue) {
        if (binaryValue == null || binaryValue.equals("")) {
            return 0;
        }
        int length = binaryValue.length() - 1; // номер последнего числа из числа binaryValue
        int decimal = 0;
        int symbol = 0;
        for (int i = length; i >= 0; i--) {
            symbol = binaryValue.charAt(i) - 48; // i-ая цифра из числа binaryValue; 48 -номер позиции числа "0" в таблице символов
            decimal = decimal + (int) (symbol * Math.pow(2, (length - i)));  //
        }
        return decimal;
    }

    public static String toBinaryStr(int value) {
        String binary = "";
        if (value < 0) {
            return "";
        }
        while (value != 0) {
            binary = (value % 2) + binary;
            value /= 2;
        }
        return binary;
    }

    public static int getDoubledNumber(int number) {
        // write code here
//        for (int i = 0; i < number; i++) {
//        }

        number = number << 2; // << number;
//        number >>= number; // << number;
        return number;
    }

    public static double truncateToHundredth(double num) {
        // write code here
        String value = String.valueOf(num);
        return Double.parseDouble(value.substring(0, value.indexOf('.') + 3));
    }

    public static String removeVowel(String string) {
        String[] rus = {"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"}; // Yy
        for (int i = 0; i < rus.length; i++) {
            string = string.replace(rus[i], "");
        }
        return string;
    }

    public static int[] getTotalWeight(int[] weights) {
        // write code here
        int weight1 = 0;
        int weight2 = 0;
        for (int i = 0; i < weights.length; i++) {
            if (i % 2 == 0) {
                weight1 += weights[i];
            } else {
                weight2 += weights[i];
            }
        }
        return new int[]{weight1, weight2};
    }

    public static String findScreenSize(int width, String ratio) {
        // write code here
        String[] splitRatio = ratio.split(":");
        int height;
        height = width * Integer.parseInt(splitRatio[1]) /
                Integer.parseInt(splitRatio[0]);

//        System.out.println("-=-");
//
//        System.out.println(Arrays.toString(splitRatio));
//        System.out.println(splitRatio[0]);
//        System.out.println(splitRatio[1]);
//
//        System.out.println(height);
//        System.out.println("-=-");

        return width + "x" + height;
    }

    public static int[] toReversedArray(long number) {
        String str = Long.toString(number);
        int[] dig = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            dig[i] = str.charAt(i);
            dig[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        for (int i = 0; i < dig.length / 2; i++) {
            int tmp = dig[i];
            dig[i] = dig[dig.length - i - 1];
            dig[dig.length - i - 1] = tmp;
        }
        return dig;
    }

    public static String play(String player1, String player2) {
        // write code here
        String result = "";
        if (player1.equals("scissors") && player2.equals("paper")) {
            result = "Player 1 won!";
        } else if (player1.equals("paper") && player2.equals("scissors")) {
            result = "Player 2 won!";
        } else if (player1.equals("rock") && player2.equals("scissors")) {
            result = "Player 1 won!";
        } else if (player1.equals("scissors") && player2.equals("rock")) {
            result = "Player 2 won!";
        } else if (player1.equals("paper") && player2.equals("rock")) {
            result = "Player 1 won!";
        } else if (player1.equals("rock") && player2.equals("paper")) {
            result = "Player 2 won!";
        } else {
            result = "Draw!";
        }
        return result;
    }

    public static int reverseBitsToInteger(int number) {
        // write code here
        String binary = Integer.toBinaryString(number);
        String binaryReversed = "";
        for (int i = binary.length() - 1; i >= 0; i--) {
            binaryReversed += binary.charAt(i);
        }
        return Integer.parseInt(binaryReversed, 2);
    }

    public static int countPoints(String[] games) {
        // write code here
        int result = 5;
        for (String res : games) {
            if (res.charAt(0) > res.charAt(2)) {
                result += 2;
            } else if (res.charAt(0) == res.charAt(2)) {
                result += 1;
            }
            System.out.println(res.charAt(0) + " - " + res.charAt(2));
        }
        return result;
    }

    public static String toAlternativeCase(String string) {
        // write code here
        String result = "";
        System.out.println();
        char[] charArray = string.toCharArray();
        for (char ch : charArray) {
            if (Character.isUpperCase(ch)) {
                result += Character.toLowerCase(ch);
            }
            if (Character.isLowerCase(ch)) {
                result += Character.toUpperCase(ch);
            }
        }
        return result;
    }

    public static String findNeedle(Object[] haystack) {
        // write code here
        if (haystack == null) {
            return "";
        }
        StringBuilder result = new StringBuilder(new String("found the needle at position "));
        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] == null) {
                continue;
            }
            if (!haystack[i].equals("needle")) {
                continue;
            }
            result.append(i);
        }
        return result.toString();
    }

    public static String stringify(int size) {
        // write code here
        String result = new String();
        for (int i = 0; i < size; i++) {
            result += (i % 2 == 0) ? "0" : "1";
        }
        return result;
    }

//    public static String createDailyPlan2(String[] plans) {
//        //Write code below this line
//        StringBuilder sb = new StringBuilder("My plans:");
//        for (int i = 0; i < plans.length; i++) {
//            if (i == 0) {
//                sb.append("\n").append(i + 1).append(".) ").append(plans[i]).append(";").append("\n");
//            } else if (i == plans.length - 1) {
//                sb.append(i + 1).append(".) ").append(plans[i]).append(";");
//            } else {
//                sb.append(i + 1).append(".) ").append(plans[i]).append(";").append("\n");
//            }
//        }
//        return sb.toString();
//        //Write code above this line
//    }

    public static String createDailyPlan(String[] plans) {
        //Write code below this line
        String result = "My plans:\n";
        for (int i = 0; i < plans.length; i++) {
            result += i + 1 + ".) " + plans[i] + ";\n";
        }
        return result;
        //Write code above this line
    }

    public static int matchResult(int result1, int result2, int bet1, int bet2) {
        //Write code below this line
        int result = (result1 == bet1 && result2 == bet2) ? 2 :
                (result1 < result2 && bet1 < bet2) ? 1 :
                        (result1 > result2 && bet1 > bet2) ? 1 :
                                (result1 == result2 && bet1 == bet2) ? 1 : 0;
        return result;
        //Write code above this line
    }


    public static String makeSentence(String[] words) {
        // write code here
        String result = "";
        for (String word : words) {
            result += (result.length() == 0) ? word : " " + word;
        }
        return result;
    }

    public static Integer calculateTip(double amount, String rating) {
        // write code here
        String lowerCase = rating.toLowerCase();
        switch (lowerCase) {
            case "terrible":
                return 0;
            case "poor":
                return (int) Math.ceil(amount / 100 * 5);
            case "good":
                return (int) Math.ceil(amount / 100 * 10);
            case "great":
                return (int) Math.ceil(amount / 100 * 15);
            case "excellent":
                return (int) Math.ceil(amount / 100 * 20);
            default:
                return null;
        }
    }

    public static String countSheep(int number) {
        // write code here
        String result = "";
        for (int i = 1; i <= number; i++) {

//            System.out.println(result + i + " sheep...");
            result = result + i + " sheep...";
        }
//        System.out.println(result);
        return result;
    }

    public static int countOccurrences(String str, char letter) {
        // write code here
        int colLetter = 0;
        char[] charArray = str.toCharArray();
        for (char let : charArray) {
            if (let != letter) {
                continue;
            }
            colLetter++;
        }
        return colLetter;
    }

    public static String removeChars(String string) {
        // write code here
        return string.substring(1, string.length() - 1);
    }

    public static String replaceDots(String str) {
        return str.replace(".", "-");
//        return str.replaceAll(".", "-");
    }

    public static char[] removeLetter(String str) {
        if (str == null) {
            return new char[0];
        }
        char[] charArray = str.toLowerCase().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'r') {
                charArray[i] = '!';
            }
        }
        return charArray;
    }

    public static BigInteger factorial(int value) {
        int result = 1;
        if (value > 0) {
            for (int i = 1; i <= value; i++) {
                result = result * i;
            }
        }
        return BigInteger.valueOf(result); // your implementation here
    }
}
