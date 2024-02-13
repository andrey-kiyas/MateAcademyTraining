package MateAcademy.code_test;

public class CubicNumbers {

    public static void main(String[] args) {
        System.out.println(findCubicNumbers("1xyz!22[153(777.777")); // ==> "1 153 154 Lucky"
        System.out.println(findCubicNumbers("40702")); // ==> "407 407 Lucky"
        System.out.println(findCubicNumbers("%%%5992&&&")); // ==> "Unlucky"
        System.out.println(findCubicNumbers("    "));
        System.out.println(findCubicNumbers("9324 0 -3923"));
//        System.out.println(findCubicNumbers("9324 0 -3923", "0 0 Lucky"));
    }

    public static String findCubicNumbers(String string) {
        if (string.length() == 0) {
            return "Unlucky";
        }
        String numStr = "";
        if (isDigit(string)) {
            for (int i = 0; i < string.length(); i++) {
                numStr += string.charAt(i);
                if ((i + 1) % 3 == 0) {
                    numStr += "A";
                }
            }
            string = numStr;
        }
        int sumCubic = 0;
        boolean isCubic = false;
        StringBuilder builder = new StringBuilder();
        String[] parts = string.split("[^0-9]");
        for (String str : parts) {
            if (str.length() == 0) {
                continue;
            }
            int parseInt = Integer.parseInt(str);
            if (isCubic(parseInt)) {
                builder.append(parseInt).append(" ");
                sumCubic += parseInt;
                isCubic = true;
            }
        }
        if (sumCubic == 0 && !isCubic) {
            return "Unlucky";
        }
        builder.append(sumCubic);
        builder.append(" Lucky");
        return builder.toString();
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isCubic(int number) {
        char[] numArray = String.valueOf(number).toCharArray();
        int sum = 0;
        for (char num : numArray) {
            sum += Math.pow(Integer.parseInt(String.valueOf(num)), 3);
        }
        if (sum == number) {
            return true;
        }
        return false;
    }
}
