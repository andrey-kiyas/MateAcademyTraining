package MateAcademy.collections.ArrayPractice;

public class isArrayPretty {
    public static void main(String[] args) {
//        [2,10,3,9]` - pretty array, because:
//        2 = 3 - 1
//        10 = 9 + 1
//        3 = 2 + 1
//        9 = 10 - 1
//        int[] arr = new int[]{2, 10, 3, 9};
        int[] arr = new int[]{2, 100, 9, 3};
//        int[] arr = new int[0];
        System.out.println(isArrayPretty(arr));
    }

    public static boolean isArrayPretty(int[] array) {
        // write code here
        short count = 0;
        boolean isFound = false;
        for (int i : array) {
            for (int j : array) {
                if (i == j - 1 || i == j + 1) {
//                    System.out.println("i: " + i + "; j-1: " + (j - 1) + "; j+1: " + (j + 1));
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                count++;
                isFound = false;
            }
        }
        return count == array.length && count > 0;
    }
}
