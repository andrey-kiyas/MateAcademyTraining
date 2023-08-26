package MateAcademy.code_test;

public class StringRotation {
    public static void main(String[] args) {
        String string1 = "123456789!@#$%^&*( )qwerty";
        String string2 = "9!@#$%^&*( )qwerty12345678";
        System.out.println(calculateRotations(string1, string2));
        System.out.println(calculateRotations2(string1, string2));
    }

    public static int calculateRotations2(String string1, String string2) {
        // write code here
        int result = 0;
        String tempRow = string1;
        for (int i = 0; i < string1.length(); i++) {
            if (tempRow.equals(string2)) {
                return result;
            }
            tempRow = tempRow.charAt(tempRow.length() - 1)
                    + tempRow.substring(0, tempRow.length() - 1);
            result++;
        }
        return -1;
    }

    public static int calculateRotations(String string1, String string2) {
        // write code here
        if (string1.length() != string2.length()) {
            return -1;
        }
        return string2.concat(string2).indexOf(string1);
    }
}
