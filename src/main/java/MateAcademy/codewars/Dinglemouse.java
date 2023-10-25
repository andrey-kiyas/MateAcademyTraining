package MateAcademy.codewars;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/5a6d3bd238f80014a2000187/train/java
 */
public class Dinglemouse {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ownedCatAndDog(71, 89))); // [13, 15]
        System.out.println(Arrays.toString(ownedCatAndDog(15, 15))); // [1, 1]
        System.out.println(Arrays.toString(ownedCatAndDog(14, 72))); // [0, 11]
        System.out.println(Arrays.toString(ownedCatAndDog(53, 38))); // [9, 4]
    }

    public static int[] ownedCatAndDog(final int catYears, final int dogYears) {
        final int ownedCat = catYears < 15 ? 0 : catYears < 24 ? 1 : 2 + (catYears - 24) / 4;
        final int ownedDog = dogYears < 15 ? 0 : dogYears < 24 ? 1 : 2 + (dogYears - 24) / 5;
        return new int[]{ownedCat, ownedDog};
    }

    public static int[] ownedCatAndDog2(final int catYears, final int dogYears) {
        // Your code here!
        int myCatYears = catYears;
        int myDogYears = dogYears;
        int cat = 0;
        int dog = 0;
        while (myCatYears > 0) {
            if (cat > 1) {
                if (myCatYears < 4) {
                    myCatYears = 0;
                    continue;
                }
                myCatYears -= 4;
                cat++;
            }
            if (cat == 1) {
                if (myCatYears < 9) {
                    myCatYears = 0;
                    continue;
                }
                myCatYears -= 9;
                cat++;
            }
            if (cat == 0) {
                if (myCatYears < 15) {
                    myCatYears = 0;
                    continue;
                }
                myCatYears -= 15;
                cat++;
            }
        }
        while (myDogYears > 0) {
            if (dog > 1) {
                if (myDogYears < 5) {
                    myDogYears = 0;
                    continue;
                }
                myDogYears -= 5;
                dog++;
            }
            if (dog == 1) {
                if (myDogYears < 9) {
                    myDogYears = 0;
                    continue;
                }
                myDogYears -= 9;
                dog++;
            }
            if (dog == 0) {
                if (myDogYears < 15) {
                    myDogYears = 0;
                    continue;
                }
                myDogYears -= 15;
                dog++;
            }
        }
        return new int[]{cat, dog};
    }
}
