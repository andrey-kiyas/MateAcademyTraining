package MateAcademy.codewars.CW7kyu;

public class CheckThreeAndTwo {

    public static void main(String[] args) {
        System.out.println(checkThreeAndTwo(new char[]{'a', 'a', 'b', 'b', 'b'})); // true
        System.out.println(checkThreeAndTwo(new char[]{'a', 'c', 'a', 'c', 'b'})); // false
        System.out.println(checkThreeAndTwo(new char[]{'a', 'a', 'a', 'a', 'a'})); // false
    }

    public static boolean checkThreeAndTwo(char[] chars) {
        // your code
        if (chars.length != 5) {
            return false;
        }
        int countA = 0, countB = 0, countC = 0;
        for (char element : chars) {
            if (element == 'a'){countA++;}
            if (element == 'b'){countB++;}
            if (element == 'c'){countC++;}
        }
        return (countA == 3 || countB == 3 || countC == 3) && (countA == 2 || countB == 2 || countC == 2);
    }
}
