package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/decode-the-slanted-ciphertext
 */

public class LC2075DecodeTheSlantedCiphertext {
    public static void main(String[] args) {
        System.out.println(decodeCiphertext("ch   ie   pr", 3));             // "cipher"
        System.out.println(decodeCiphertext("iveo    eed   l te   olc", 4)); // "i love leetcode"
        System.out.println(decodeCiphertext("coding", 1));                   // "coding"
    }

    public static String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.length() == 0) return "";

        int n = encodedText.length();
        int cols = n / rows;
        StringBuilder sb = new StringBuilder();

        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                int currentCol = c + r;
                if (currentCol >= cols) break;

                int index = r * cols + currentCol;

                if (index < n) {
                    sb.append(encodedText.charAt(index));
                }
            }
        }

        return stripTrailingSpaces(sb.toString());
    }

    private static String stripTrailingSpaces(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        return s.substring(0, i + 1);
    }
}
