package MateAcademy;

import java.util.Arrays;

public class MateAcademy_01_JB {

    public static void main(String[] args) {

//        int[] nums = new int[]{1, 2, 2};
//        getSquareSum(nums);

//        System.out.println(repeatString(6, "I"));

//        getAverageMark(new int[]{2, 2, 2, 2, 2});

//        getCentury(1705); // 18
//        getCentury(1900); // 19
//        getCentury(1601); // 17
//        getCentury(2000); // 20

//        getStringArray(new boolean[]{true, false}); // ["Yes", "No"]
//        getStringArray(new boolean[]{false}); // ["No"]
//        getStringArray(new boolean[]{}); // []

//        int[] a = {1, 2, 3, 4};
//        int[] b = {4, 16, 1, 2, 3, 22};
//        getCombinedArray(a, b);

//        getSum(new int[] {3, 3, 3}, 3); // 0
//        getSum(new int[] {1, 2, 3}, 1); // 2 + 3 = 5
//        getSum(new int[]{10, 2, 50, 3, 4, 0}, 50); // 3 + 4 + 0 = 7
//        getSum(new int[] {10, 2, 50, 3, 4, 0}, -100); // 0 (бо в масиві немає значення -100)
//        getSum(new int[] {10}, 10); // 0

//        int[] numbers = {2, 5, 8, 0, 7, 1, -4};
//        int divider = 2;
//        System.out.println(Arrays.toString(getDivisibleNumbers(numbers, divider)));

//        getHighestAndLowestAge(new int[] {10, 40, 36}); // [40, 10]
//        getHighestAndLowestAge(new int[] {60, 4, 14, 20, 97}); // [97, 4]
//        getHighestAndLowestAge(new int[] {35}); // [35, 35]
//        getHighestAndLowestAge(new int[] {}); // [35, 35]

//        System.out.println(countTheMonkeys(5)); // [1, 2, 3, 4, 5]);

//        System.out.println(getAverageSalary(new double[] {1000.00, 500.00}));
//        System.out.println(getAverageSalary(new double[] {}));

//        markStringEnds("a");
//        markStringEnds("hello");

//        System.out.println(removeOddChars("hello")); // "hlo"
//        System.out.println(removeOddChars("1234")); // "13"
//        System.out.println(removeOddChars("(())")); // "()"
//        System.out.println(removeOddChars("Bob")); // "Bb"
//        System.out.println(removeOddChars(""));
//        System.out.println(removeOddChars(null));

//        System.out.println(getUpperCase("dfsdfFEFE"));
//        System.out.println(getUpperCase(null));

//        System.out.println(makeAbbr("national aeronautics space administration")); // "NASA"
//        System.out.println(makeAbbr("central processing unit")); // "CPU"
//        System.out.println(makeAbbr("simplified molecular input line entry specification")); // "SMILES"

//        System.out.println(isWerewolf("rotator")); // true ("rotator" -> "rotator")
//        System.out.println(isWerewolf("racecar")); // true ("racecar" -> "racecar")
//        System.out.println(isWerewolf("home")); // false ("home" -> "emoh")
//        System.out.println(isWerewolf("evacaniseebeesinacave")); // true ("evacaniseebeesinacave" -> "evacaniseebeesinacave")
//        System.out.println(isWerewolf("rOtaTor")); // false ("rOtaTor" -> "roTatOr")

//        System.out.println(getValue("name=joHN")); // "john"
//        System.out.println(getValue("occupation=DeveLOPeR")); // "developer"
//        System.out.println(getValue("language=JAVA")); // "java"
//        System.out.println(getValue("login=Me=cOol!!1")); // "me=cool!!1"

//        System.out.println(getSuccessRate("11100")); // 0.6
//        System.out.println(getSuccessRate("")); // 0.6

//        System.out.println(compareStrings("java rocks!", "java rocks!")); // true
//        System.out.println(compareStrings("party", "Party")); // false
//        System.out.println(compareStrings(null, null)); // true

//        String input = "Hello, world!"; // => "!dlrow ,olleH"
//        System.out.println(reverseString(input));

//        String[] ingredients = {"dough", "cheese", "sauce", "dough"}; // true
////        String[] ingredients = {"cheese", "sauce", "pepperoni"}; // false
//        System.out.println(doughIsEnough(ingredients));

//        String input = "Hello!";
//        System.out.println(createNewString(input));

//        String input = "apple";
//        System.out.println(stringToUpperCase(input));

//        int[] results = {10, 10, 11, 9, 12, 8};
//        getSpeedStatistic(results);

//        getSpeedStatistic({}); // {0, 0}
//        getSpeedStatistic({10}); // {10, 10}
//        getSpeedStatistic({8, 9, 9, 9}); // {8, 9}
//        getSpeedStatistic({10, 10, 11, 9, 12, 8}); // {8, 12}

//        int[] numbers = {3, 5, 0, 8, 7}; // max = -2
//        System.out.println(getSum2(numbers));

//        int[] numbers = {3, 5, 0, 8, 7}; // max = -2
//        System.out.println(getSum(numbers));

//        int[] numbers = {-4, -123, -11, -2, -9}; // max = -2
//        System.out.println(getDoublePower(numbers));

//        int[] numbers = {-4, -123, -11, -2, -9}; // max = -2
//        System.out.println(getMaxNumber(numbers));

//        createArray1();

//        String[] input = {"Apple", "Banana", "Orange"}; // length = 3
//        System.out.println(returnArrayLength(input));

//        System.out.println(reviewCode(5));

//        System.out.println(getDrinksWithStep(10, 3)); // 1 + 4 + 7 + 10 = 22
//        System.out.println(getDrinksWithStep(0, 5)); // 0 - нема гостей - нема і порцій
//        System.out.println(getDrinksWithStep(5, 3)); // 1 + 4 = 5

//        System.out.println(getDrinks(0)); // 0 - нема гостей - нема порцій;
//        System.out.println(getDrinks(2)); // 1 + 2 = 3;
//        System.out.println(getDrinks(6)); // 1 + 2 + 3 + 4 + 5 + 6 = 21;

//        System.out.println(getSum(20, 5));

//        System.out.println(getResult(-5,-1));

//        System.out.println(getTipsRating(0)); // "terrible"
//        System.out.println(getTipsRating(10)); // "poor"
//        System.out.println(getTipsRating(19)); // "good"

//        System.out.println(calculateTaxes(900)); // 900 * 0.02 = 18
//        System.out.println(calculateTaxes(5000)); // 5000 * 0.03 = 150
//        System.out.println(calculateTaxes(10500)); // 10500 * 0.05 = 525

//        System.out.println(getDriverLicense(16)); // "You can get a license"
//        System.out.println(getDriverLicense(57)); // "You can get a license"
//        System.out.println(getDriverLicense(15)); // "You can't get a license"

//        System.out.println(getTitle(27)); // "Дорослий" - потрапили в перший if та одразу повернули з методу значення "Дорослий"
//        System.out.println(getTitle(16)); // "Підліток" - перший if не спрацював, тому перевірили умову 16 >= 10 і повернули значення "Підліток"
//        System.out.println(getTitle(2)); // "Дитина" - перший та другий if не спрацювали, тому дійшли до кінця й повернули значення "Дитина"
//        System.out.println(getTitle(10)); // "Підліток" - перший if не спрацював, тому перевірили умову 10 >= 10 і повернули значення "Підліток"

//        int rowIndex = 0;
//        int columnIndex = 1;
//        int[][] array = {{2, 3, 5},
//                {1, 7, 1},
//                {5, 9, 2}
//        };
//        System.out.println(getNeighboursCells(array, rowIndex, columnIndex));
//        System.out.println(getNeighboursCells2(array, rowIndex, columnIndex));


    }

    // вариант ментора
    public static int getNeighboursCells2(int[][] array, int rowIndex, int columnIndex) {
        int neighboursCellsSum = 0;
        neighboursCellsSum += array[rowIndex - 1][columnIndex];
        neighboursCellsSum += array[rowIndex + 1][columnIndex];
        neighboursCellsSum += array[rowIndex][columnIndex - 1];
        neighboursCellsSum += array[rowIndex][columnIndex + 1];
        return neighboursCellsSum;
    }

    // вариант мой
    public static int getNeighboursCells(int[][] array, int rowIndex, int columnIndex) {
        int rowLength = array.length - 1;
        int columnLength = array[0].length - 1;
        boolean el1 = false, el2 = false, el3 = false, el4 = false;
        int sum = 0;
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                if (rowIndex - 1 >= 0 && rowIndex - 1 <= rowLength && el1 == false) {
                    sum += array[rowIndex - 1][columnIndex];
                    System.out.println(sum);
                    el1 = true;
                }
                if (rowIndex + 1 >= 0 && rowIndex + 1 <= rowLength && el2 == false) {
                    sum += array[rowIndex + 1][columnIndex];
                    System.out.println(sum);
                    el2 = true;
                }
                if (columnIndex - 1 >= 0 && columnIndex - 1 <= columnLength && el3 == false) {
                    sum += array[rowIndex][columnIndex - 1];
                    System.out.println(sum);
                    el3 = true;
                }
                if (columnIndex + 1 >= 0 && columnIndex + 1 <= columnLength && el4 == false) {
                    sum += array[rowIndex][columnIndex + 1];
                    System.out.println(sum);
                    el4 = true;
                }
//                System.out.println("1: (" + (rowIndex - 1) + ":" + columnIndex + ") " + array[rowIndex - 1][columnIndex]);
//                System.out.println("2: (" + (rowIndex + 1) + ":" + columnIndex + ") " + array[rowIndex + 1][columnIndex]);
//                System.out.println("3: (" + rowIndex + ":" + (columnIndex - 1) + ") " + array[rowIndex][columnIndex - 1]);
//                System.out.println("4: (" + rowIndex + ":" + (columnIndex + 1) + ") " + array[rowIndex][columnIndex + 1]);
            }
        }
        return sum;
//        return 0;
    }

    public static int getSquareSum(int[] nums) {
        // write code here
        int sumSquares = 0;
        for (int num : nums) {
//            sumSquares += (int) Math.pow(num, 2);
            sumSquares += num * num;
        }
        System.out.println(sumSquares);
        return sumSquares;
    }

    public static String repeatString(int times, String string) {
        // write code here
        String result = "";
        for (int u = 0; u < times; u++) {
            result = result + string;
        }
        return result;
    }

    public static int getAverageMark(int[] marks) {
        // write code here
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        System.out.println(sum / marks.length);
        return 0;
    }

    public static int getCentury(int year) {
        // WRITE YOUR CODE BELOW THIS LINE

        int century = 0;
        if (year % 100 == 0) {
            century = year / 100;
        } else {
            century = (year / 100) + 1;
        }
        return century;
        // WRITE YOUR CODE ABOVE THIS LINE
    }

    public static String[] getStringArray(boolean[] values) {
        // WRITE YOUR CODE BELOW THIS LINE
        String[] result = new String[values.length];

        for (int i = 0; i < values.length; i++) {
            result[i] = (values[i]) ? "Yes" : "No";
        }

        System.out.println(Arrays.toString(result));
        return result;
        // WRITE YOUR CODE ABOVE THIS LINE
    }

    public static int[] getCombinedArray(int[] firstArray, int[] secondArray) {
        // WRITE YOUR CODE BELOW THIS LINE
        int[] result = new int[firstArray.length + secondArray.length];
        int count = 0;
        for (int i = 0; i < firstArray.length; i++) {
            result[i] = firstArray[i];
            count++;
        }
        for (int j = 0; j < secondArray.length; j++) {
            result[count++] = secondArray[j];
        }
        return result;
        // WRITE YOUR CODE ABOVE THIS LINE
    }

    public static int getSum(int[] values, int startValue) {
        // WRITE YOUR CODE BELOW THIS LINE
        boolean startValueFound = false;
        int result = 0;
        for (int value : values) {
            if (value == startValue) {
                startValueFound = true;
                continue;
            }
        }
        if (startValueFound == false) {
            System.out.println(result);
            return result;
        } else {
            startValueFound = false;
            for (int value : values) {
                if ((value == startValue && startValueFound) == false) {
                    startValueFound = true;
                    continue;
                }
//                if (startValueFound && value != startValue){
                if (startValueFound) {
                    result += value;
                }
            }
        }
        System.out.println(result);
        return result;
        // WRITE YOUR CODE ABOVE THIS LINE
    }

    public static int[] getDivisibleNumbers(int[] numbers, int divider) {
        //write your code below this line
        int size = 0;
        for (int number : numbers) {
            if (number > 0 && number % divider == 0) {
                size++;
            }
        }
        int[] result = new int[size];
        int counter = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0 && numbers[i] % divider == 0) {
                result[counter] = numbers[i];
                counter++;
            }
        }
        return result;
        //write your code above this line
    }

    public static int[] getHighestAndLowestAge(int[] ages) {
        // write your code below this line
        if (ages == null || ages.length == 0) {
            return new int[]{0, 0};
        }
        int firstEnd = ages[0], secondEnd = ages[0];
        for (int i = 0; i < ages.length; i++) {
            firstEnd = Math.max(ages[i], firstEnd);
            secondEnd = Math.min(ages[i], secondEnd);
        }
        System.out.println(firstEnd + " " + secondEnd);
        return new int[]{firstEnd, secondEnd};
        // write your code above this line
    }

    public static int[] countTheMonkeys(int count) {
        // write your code below this line
        int[] result = new int[count];
        if (count == 0) {
            return result;
        }
        for (int i = 0; i < count; i++) {
            result[i] = i + 1;
        }

        System.out.println(Arrays.toString(result));

        return result;
        // write your code above this line
    }

    public static double getAverageSalary(double[] salaries) {
        // write your code below this line
        if (salaries.length == 0) {
            return 0;
        }
        double sumSalaries = 0;
        for (double salary : salaries) {
            sumSalaries += salary;
        }
        return sumSalaries / salaries.length;
        // write your code above this line
    }

    public static int getOccurrenceCount(String[] colors, String targetColor) {
        // write your code below this line
        int count = 0;
        for (String color : colors) {
            if (color.equals(targetColor)) {
                count++;
            }
            System.out.println(color);
        }
        return count;
        // write your code above this line
    }

    public static String[] markStringEnds(String originalString) {
        // write your code below this line

//        int lastIndex = originalString.length() - 1;
//        String firstChar = originalString.substring(0, 1).toUpperCase();
//        String lastChar = originalString.substring(lastIndex).toUpperCase();
//        String firstEnd = firstChar + originalString.substring(1);
//        String secondEnd = originalString.substring(0, lastIndex) + lastChar;
//        return new String[]{firstEnd, secondEnd};

        StringBuilder builderFirst = new StringBuilder();
        StringBuilder builderLast = new StringBuilder();
        for (int i = 0; i < originalString.length(); i++) {
            if (i == 0) {
                builderFirst.append(originalString.toUpperCase().charAt(i));
                if ((originalString.length() == 1)) {
                    builderLast.append(originalString.toUpperCase().charAt(i));
                } else {
                    builderLast.append(originalString.charAt(i));
                }
//                builderLast.append(originalString.charAt(i));
                continue;
            }
            if (i == originalString.length() - 1) {

                if ((originalString.length() == 1)) {
                    builderFirst.append(originalString.toUpperCase().charAt(i));
                } else {
                    builderFirst.append(originalString.charAt(i));
                }


//                builderFirst.append(originalString.charAt(i));
                builderLast.append(originalString.toUpperCase().charAt(i));
                continue;
            }
            builderFirst.append(originalString.charAt(i));
            builderLast.append(originalString.charAt(i));
        }

        String[] result = new String[2];
        result[0] = builderFirst.toString();
        result[1] = builderLast.toString();

        String arrayToString = Arrays.toString(result);
        System.out.println(arrayToString);

        return result;
        // write your code above this line
    }

    public static String removeOddChars(String originalString) {
        // write your code below this line
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < originalString.length(); i++) {
            if (i % 2 == 0) {
                builder.append(originalString.charAt(i));
            }
        }
        return builder.toString();
//        if (originalString == null || originalString.length() == 0) {
//            return "";
//        }
//        char[] charArray = originalString.toCharArray();
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < charArray.length; i++) {
//            if (i % 2 != 0) {
//                continue;
//            }
//            builder.append(charArray[i]);
//        }
//        return builder.toString();
        // write your code above this line
    }

    public static String getMiddleString(String originalString) {
        // write your code below this line
        return "";
        // write your code above this line
    }

    public static String getUpperCase(String inputString) {
        // write your code below this line
        if (inputString == null) {
            return "The string is null!";
        } else if (inputString.length() == 0) {
            return "";
        } else {
            return inputString.toUpperCase();
        }
        // write your code above this line
    }

    public static String makeAbbr(String fullName) {
        // write your code below this line
        String[] split = fullName.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String letter : split) {
            builder.append(letter.charAt(0));
        }
        return builder.toString().toUpperCase();
        // write your code above this line
    }

    public static boolean isWerewolf(String target) {
        // write your code below this line
        StringBuilder builder = new StringBuilder(target);
        builder.reverse();
        return target.equals(builder.toString());
        // write your code above this line
    }

    public static String getValue(String dataFromDatabase) {
        // write your code below this line

        String substring = dataFromDatabase.substring(dataFromDatabase.indexOf("=") + 1);
        return substring.toLowerCase();
        // write your code above this line
    }

    public static double getSuccessRate(String statistic) {
        // write your code below this line
        if (statistic.length() == 0) {
            return 0.0;
        }
        double count = 0;
        char[] charArray = statistic.toCharArray();
        for (char chars : charArray) {
            if (chars == '1') {
                count++;
            }
        }
        return count / statistic.length();
        // write your code above this line
    }

    public static boolean compareStrings(String firstString, String secondString) {
        // write your code below this line
        if (firstString == null && secondString == null) {
            return true;
        }
        return firstString != null && firstString.equals(secondString);
        // write your code above this line
    }

    public static String reverseString(String input) {
        //write your code here
        StringBuilder builder = new StringBuilder(input);
        builder.reverse(); // "olleH"
        return builder.toString();
    }

    public static boolean doughIsEnough(String[] ingredients) {
        //Write code below this line
        boolean isDoughEnough = false;
        int countDough = 0;

        for (String ingredient :
                ingredients) {
            if (ingredient == "dough") {
                countDough++;
            }
        }
        isDoughEnough = (countDough > 1) ? true : false;

        return isDoughEnough;
        //Write code above this line
    }

    public static String createNewString(String input) {
        //write your code here
        String result = input.substring(1, 2) + input.substring(3, 4);
        return result;

    }

    public static String createGreeting(String input) {
        //change the code below
        StringBuilder builder = new StringBuilder("Hello, ");
        StringBuilder stringBuilder = builder.append(input);
        return String.valueOf(stringBuilder);
    }

    public static String stringToUpperCase(String input) {
        //write your code here
        return input.toUpperCase();
    }

    public static int[] getSpeedStatistic(int[] results) {
        //Write code below this line
        int[] resStat = {0, 0};

        int minVal = (results.length == 0) ? 0 : results[0];
        int maxVal = (results.length == 0) ? 0 : results[0];

//        int minVal = 0; //results[0];
//        int maxVal = 0; //results[0];

        for (int i = 0; i < results.length; i++) {
            if (minVal > results[i]) {
                minVal = results[i];
            }
            if (maxVal < results[i]) {
                maxVal = results[i];
            }
        }
        resStat[0] = minVal;
        resStat[1] = maxVal;
        for (int val : resStat) {
            System.out.println(val);
        }
        return resStat;
        //Write code above this line
    }

    public static int getSum2(int[] numbers) {
        //Write code below this line
        int sumResult = 0;
        for (int i = numbers.length / 2; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                break;
            }
            sumResult += numbers[i];
        }
        return sumResult;
        //Write code above this line
    }

    public static int getSum(int[] numbers) {
        //Write code below this line
        int sumResult = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                continue;
            }
            sumResult += number;
        }
        return sumResult;
        //Write code above this line
    }

    public static int[] getDoublePower(int[] powers) {
        //Write code below this line
        for (int i = 0; i < powers.length; i++) {
            powers[i] *= 2;
        }
        for (int pow : powers) {
            System.out.println(pow);
        }
        return powers;
        //Write code above this line
    }

    public static int getMaxNumber(int[] numbers) {
        //Write code below this line
        int maxNumber = numbers[0];
        for (int number : numbers) {
            if (maxNumber > number) {
                continue;
            }
            maxNumber = number;
        }
        for (int number : numbers) {
            System.out.println(number);
        }
        return maxNumber;
        // Write code above this line
    }

    public static String[] createArray1() {
        //change code below this line
        String[] fruits = new String[2];
        fruits[1] = "lemon";
        //change code above this line

        System.out.println(fruits.length);

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        return fruits;
    }

    public static int[] createArray() {
        //write your code here
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        for (int number : numbers) {
            System.out.println(number);
        }
        return numbers;
    }

    public static int returnArrayLength(String[] input) {
        //write your code below this line
        int arrayLength = input.length;
        return arrayLength;
        //write your code above this line
    }

    public static int reviewCode(int maxAttempts) {
        //Write code below this line
        int solutionAttempts = 0;
        do {
            solutionAttempts++;
        } while (solutionAttempts < maxAttempts);
        return solutionAttempts;
        //Write code above this line
    }

    public static int getDrinksWithStep(int guestNumber, int step) {
        //Write code below this line
        int result = 0;
        for (int i = 1; i <= guestNumber; i += step) {
            result += i;
        }
        return result;
        //Write code above this line
    }

    public static int getDrinks(int numberOfGuests) {
        //Write code below this line
        int result = 0;
        for (int i = 1; i <= numberOfGuests; i++) {
            result += i;
        }
        return result;
        //Write code above this line
    }

    public static int getSum(int n, int step) {
        int result = 0;

        for (int i = 0; i <= n; i += step) {
            result += i;
        }

        return result;
    }

    public static double getResult(double a, double b) {
        //Write code below this line
        double result = a + b;
        if (result < a - b) {
            result = a - b;
        }
        if (result < a * b) {
            result = a * b;
        }
        if (result < a / b) {
            result = a / b;
        }
        return result;
        //Write code above this line
    }

    public static String getTipsRating(int amount) {
        //Write code below this line
        if (amount == 0) {
            return "terrible";
        }
        if (amount <= 10) {
            return "poor";
        }
        if (amount <= 20) {
            return "good";
        }
        if (amount <= 50) {
            return "great";
        }
        return "excellent";

//        if (amount == 0) {
//            return "terrible";
//        } else if (amount > 0 && amount <= 10) {
//            return "poor";
//        } else if (amount > 10 && amount <= 20) {
//            return "good";
//        } else if (amount > 20 && amount <= 50) {
//            return "great";
//        } else {
//            return "excellent";
//        }

        //Write code above this line
    }

    public static double calculateTaxes(double income) {
        //Write code below this line
        if (income <= 1000) {
            return income * 0.02;
        } else if (income > 1000 && income <= 10000) {
            return income * 0.03;
        } else {
            return income * 0.05;
        }
        //Write code above this line
    }

    public static String getDriverLicense(int age) {
        //Write code below this line
//            String getLicense = (age >= 16) ? System.out.println("You can get a license") : System.out.println("You can't get a license");
        String getLicense = (age >= 16) ? "You can get a license" : "You can't get a license";
        return getLicense;
        //Write code above this line
    }

    public static String getTitle(int age) {
        if (age >= 18) {
            // Якщо умова age >= 18 виконалась, то виходимо з методу
            return "Дорослий";
        }
        // Сюди програма дійде, тільки якщо умова age >= 18 не виконалась
        if (age >= 10) {
            // Якщо умова age >= 10 виконалась (але age >= 18 не виконалась), то виходимо з методу
            return "Підліток";
        }
        // Сюди ми потрапляємо, тільки якщо не вийшли з методу раніше
        return "Дитина";
    }
}
