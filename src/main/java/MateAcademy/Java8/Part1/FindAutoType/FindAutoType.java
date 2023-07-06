package MateAcademy.Java8.Part1.FindAutoType;

import java.util.function.Function;

public class FindAutoType implements Function<Integer, AutoType> {
    //write your code here
    private static final Integer WEIGHT_LIMIT = 1500;
    @Override
    public AutoType apply(Integer weight) {
        return (weight < WEIGHT_LIMIT) ? AutoType.CAR : AutoType.TRUCK;
    }

    public static void main(String[] args) {
        FindAutoType findAutoType = new FindAutoType();
        System.out.println(findAutoType.apply(1400));
        System.out.println(findAutoType.apply(1600));
    }
}
