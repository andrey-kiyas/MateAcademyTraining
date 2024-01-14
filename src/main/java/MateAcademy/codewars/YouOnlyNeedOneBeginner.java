package MateAcademy.codewars;

public class YouOnlyNeedOneBeginner {

    public static void main(String[] args) {
        System.out.println(check(new Object[]{80, 117, 115, 104, 45, 85, 112, 115}, 45));
        System.out.println(check(new Object[]{"what", "a", "great", "kata"}, "kat"));
    }


    public static boolean check(Object[] a, Object x) {
        // Your code here
        for (Object aa: a) {
            if (aa.equals(x)){
                return true;
            }
        }
        return false;
    }
}
