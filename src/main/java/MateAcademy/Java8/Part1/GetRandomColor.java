package MateAcademy.Java8.Part1;

//import java.util.ArrayList;
//import java.util.Arrays;

import java.util.Random;
import java.util.function.Supplier;

public class GetRandomColor implements Supplier<String> {
    private static final String[] COLORS = {"red", "green", "blue", "yellow", "pink",
            "black", "white"};

    //write your code here
    @Override
    public String get() {
        int index = new Random().nextInt(COLORS.length);
        return COLORS[index];
    }
//    Мой вариант
//    @Override
//    public String get() {
//        ArrayList<String> nameList = new ArrayList<>();
//        for (String color : COLORS) {
//            nameList.add(color);
//        }
//        Supplier<String> randomName = () -> {
//            int value = (int) (Math.random() * nameList.size());
//            return nameList.get(value);
//        };
//        return String.valueOf(randomName.get());
//    }

    public static void main(String[] args) {
        GetRandomColor getRandomColor = new GetRandomColor();
        System.out.println(getRandomColor.get());
    }
}
