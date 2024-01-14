package MateAcademy.codewars.CW7kyu;

import java.util.Arrays;

public class HelpTheFruitGuy {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeRotten(new String[]{"rottenApple", "rottenBanana", "rottenApple", "rottenPineapple", "rottenKiwi"})));
    }

    public static String[] removeRotten(String[] fruitBasket) {
        if (fruitBasket == null || fruitBasket.length == 0) {
            return new String[]{};
        }
        for (int i = 0; i < fruitBasket.length; i++) {
            if (fruitBasket[i].startsWith("rotten")) {
                fruitBasket[i] = fruitBasket[i].substring(6).toLowerCase(); // Remove "rotten" prefix
            }
        }
        return fruitBasket;
    }
}
