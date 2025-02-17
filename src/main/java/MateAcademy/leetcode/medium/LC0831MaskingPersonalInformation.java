package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/masking-personal-information
 */

public class LC0831MaskingPersonalInformation {
    public static void main(String[] args) {
        System.out.println(maskPII("LeetCode@LeetCode.com")); // l*****e@leetcode.com
        System.out.println(maskPII("AB@qq.com"));             // a*****b@qq.com
        System.out.println(maskPII("1(234)567-890"));         // ***-***-7890
        System.out.println(maskPII("86-(10)12345678"));       // +**-***-***-5678
    }

    public static String maskPII(String s) {
        if (s.contains("@")) {
            return maskEmail(s);
        } else {
            return maskPhone(s);
        }
    }

    private static String maskEmail(String email) {
        email = email.toLowerCase();
        String[] parts = email.split("@");
        String name = parts[0];
        String domain = parts[1];
        return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + "@" + domain;
    }

    private static String maskPhone(String phone) {
        String digits = phone.replaceAll("[^0-9]", "");
        String lastFour = digits.substring(digits.length() - 4);
        String maskedLocal = "***-***-" + lastFour;

        int countryCodeLength = digits.length() - 10;
        if (countryCodeLength == 0) {
            return maskedLocal;
        }

        StringBuilder countryPrefix = new StringBuilder("+");
        for (int i = 0; i < countryCodeLength; i++) {
            countryPrefix.append("*");
        }
        countryPrefix.append("-");

        return countryPrefix + maskedLocal;
    }

}
