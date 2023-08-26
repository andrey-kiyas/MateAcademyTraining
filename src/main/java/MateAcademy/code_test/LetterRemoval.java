package MateAcademy.code_test;

public class LetterRemoval {
    public static void main(String[] args) {
//        System.out.println(removeLetter("abracadabra", 1)); // = "bracadabra" // видаляється найлівіша буква 'a'
//        System.out.println(removeLetter("abracadabra", 2)); // = "brcadabra" // видаляється 2 букви 'a' зліва
//        System.out.println(removeLetter("abracadabra", 6)); // = "rcdbr" // видаляється 5 букв 'a' та 1 буква 'b'
//        System.out.println(removeLetter("abracadabra", 8)); // = "rdr" // видаляється 5 букв 'a', 2 букви 'b' та 1 буква 'c'
//        System.out.println(removeLetter("abracadabr", 10)); // = ""

        System.out.println(removeLetter("mateacademy", 6));
    }

    public static String removeLetter(String string, int n) {
        // write code here
        StringBuilder builder = new StringBuilder(string);
        char deletedLetter = 'a';
        int indexLetter;
        for (int i = 0; i < n; i++) {
            indexLetter = builder.indexOf(String.valueOf(deletedLetter));
            while (indexLetter < 0) {
                deletedLetter++;
                indexLetter = builder.indexOf(String.valueOf(deletedLetter));
                if (builder.length() == 0) {
                    return "";
                }
            }
            builder.deleteCharAt(indexLetter);
        }
        return builder.toString();
    }
}
