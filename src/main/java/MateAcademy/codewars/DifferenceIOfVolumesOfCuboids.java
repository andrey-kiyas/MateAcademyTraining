package MateAcademy.codewars;

public class DifferenceIOfVolumesOfCuboids {

    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{3, 2, 5}, new int[]{1, 4, 4}));
    }

    public static int findDifference(final int[] firstCuboid, final int[] secondCuboid) {
        return Math.abs(firstCuboid[0] * firstCuboid[1] * firstCuboid[2] - secondCuboid[0] * secondCuboid[1] * secondCuboid[2]);
//        return Math.abs(getVal(firstCuboid) - getVal(secondCuboid));
    }

    public static int getVal(int[] cuboid){
        int result = 1;
        for (int dig: cuboid) {
            result *= dig;
        }
        return result;
    }
}
