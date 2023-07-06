package MateAcademy.collections.ArrayPractice;

public class countOccurrences {
    public static void main(String[] args) {
        System.out.println(countOccurrences("azyxxzyzy", "zy")); //== 3
        System.out.println(countOccurrences("ababagalamaga", "ba")); // == 2
    }

    public static int countOccurrences(String str, String substr) {
        // write code here
        str = str.toLowerCase();
        substr = substr.toLowerCase();
        int i = str.indexOf(substr);
        int count = 0;
        while (i >= 0) {
            count++;
            i = str.indexOf(substr, i + 1);
        }
        return count;
    }
}
