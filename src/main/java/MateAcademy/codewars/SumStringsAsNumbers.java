package MateAcademy.codewars;

public class SumStringsAsNumbers {
    public static void main(String[] args) {
//        System.out.println(sumStrings("123", "4567"));
//        System.out.println(sumStrings("12", "3"));
        System.out.println(sumStrings("8474361548525", "01228541387213")); // 9702902935738
    }

    public static String sumStrings(String a, String b) {
        String result = "";
        int tempSum = 0;
        int carry = 0;
        if (b.length() > a.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        while (b.length() < a.length()) {
            b = "0" + b;
        }
        for (int i = a.length() - 1; i >= 0; i--) {
            tempSum = Integer.parseInt(String.valueOf(a.charAt(i))) + Integer.parseInt(String.valueOf(b.charAt(i))) + carry;
            carry = (int) Math.floor(tempSum / 10);
            result = (tempSum % 10) + result;
        }
        if (carry != 0) {
            result = 1 + result;
        }
        if (result.charAt(0) == '0') {
            result = result.substring(1);
        }

        return result;
    }
}