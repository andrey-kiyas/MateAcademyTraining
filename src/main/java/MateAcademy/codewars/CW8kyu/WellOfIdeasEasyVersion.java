package MateAcademy.codewars.CW8kyu;

public class WellOfIdeasEasyVersion {

    public static void main(String[] args) {
        System.out.println(well(new String[]{"good", "bad", "bad", "bad", "bad", "good", "bad", "bad", "good"})); // "I smell a series!"
        System.out.println(well(new String[]{"good", "bad", "bad", "bad", "bad"}));                               // "Publish!"
        System.out.println(well(new String[]{"bad", "bad", "bad"}));                                              // "Fail!"
    }

    public static String well(String[] x) {
        int count = 0;
        for (String str : x) {
            if (str.equals("good")) {
                count++;
            }
        }
        if (count == 1 || count == 2) {
            return "Publish!";
        }
        if (count > 2) {
            return "I smell a series!";
        }
        return "Fail!";
    }
}
