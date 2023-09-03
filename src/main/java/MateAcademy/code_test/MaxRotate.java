package MateAcademy.code_test;

public class MaxRotate {
    public static void main(String[] args) {
//        long number = 3390939445L; // 3909394453L
        long number = 758655697L;  // 758655697L
//        long number = 195881031L;  // 988103115L

        System.out.println(getMaxRotations(number));
    }

    public static long getMaxRotations(long number) {
        // write code here
        int shift = 1;
        long maxResult = number;
        String numberString = Long.toString(number);
        for (int i = 0; i < numberString.length(); i++) {
            numberString = numberString.substring(0, i) + move(numberString.substring(i), shift);
            if (Long.parseLong(numberString) > maxResult) {
                maxResult = Long.parseLong(numberString);
            }
        }
        return maxResult;
    }

    public static String move(String str, int shift) {
        int index = 0;
        String result = "";
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            index = i + shift;
            if (index == charArray.length) {
                index = 0;
            }
            result += charArray[index];
        }
        return result;
    }

    public static long getMaxRotations2(long number) {
        String num = String.valueOf(number);
        for (int i = 0; i < num.length() - 1; i++) {
            num = num.substring(0, i) + num.substring(i + 1) + num.charAt(i);
            if (Long.parseLong(num) > number) {
                number = Long.parseLong(num);
            }
        }
        return number;
    }
}
