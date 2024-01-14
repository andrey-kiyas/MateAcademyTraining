package MateAcademy.codewars.CW7kyu;

public class SmallestValueOfAnArray {

    public static void main(String[] args) {
        System.out.println(findSmallest(new int[]{1, 2, 3}, "index"));         // 0
        System.out.println(findSmallest(new int[]{7, 12, 3, 2, 27}, "value")); // 2
    }

    public static int findSmallest(final int[] numbers, final String toReturn) {
        int digit = numbers[0];
        int index = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < digit) {
                digit = numbers[i];
                index = i;
            }
        }
        return (toReturn.equals("index")) ? index : digit;
    }

    public static int findSmallest2(final int[] numbers, final String toReturn) {
        if ("value".equals(toReturn)) {
            int minValue = numbers[0];
            for (int num : numbers) {
                minValue = Math.min(minValue, num);
            }
            return minValue;
        } else if ("index".equals(toReturn)) {
            int minIndex = 0;
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] < numbers[minIndex]) {
                    minIndex = i;
                }
            }
            return minIndex;
        } else {
            throw new IllegalArgumentException("Invalid toReturn");
        }
    }
}
