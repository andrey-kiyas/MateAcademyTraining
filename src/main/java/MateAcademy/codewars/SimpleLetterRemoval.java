package MateAcademy.codewars;

public class SimpleLetterRemoval {

    public static void main(String[] args) {
//        System.out.println(solve("abracadabra", 1));// "bracadabra"
//        System.out.println(solve("abracadabra", 2));// "brcadabra"
//        System.out.println(solve("abracadabra", 3));// "brcdabra"
//        System.out.println(solve("abracadabra", 6));// "rcdbr"
//        System.out.println(solve("abracadabra", 8));// "rdr"
        System.out.println(solve("abracadabra", 50));// "rdr"
    }

    public static String solve(String s, int k) {
        if (k == 0) {
            return s;
        }
        char tmpLtr = 'a';
        boolean exch = false;
        boolean isLtr = false;
        do {
            isLtr = false;
            exch = false;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == tmpLtr) {
                    if (!exch) {
                        k--;
                        exch = true;
                        continue;
                    }
                    isLtr = true;
                }
                builder.append(s.charAt(i));
            }
            s = String.valueOf(builder);
            if (!isLtr) {
                tmpLtr++;
            }
        } while (k != 0 && s.length() != 0);
        return s; // Do your magic!
    }
}
