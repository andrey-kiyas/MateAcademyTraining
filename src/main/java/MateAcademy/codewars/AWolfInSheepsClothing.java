package MateAcademy.codewars;

public class AWolfInSheepsClothing {

    public static void main(String[] args) {
        System.out.println(warnTheSheep(new String[]{"sheep", "sheep", "sheep", "sheep", "sheep", "wolf", "sheep", "sheep"}));
    }

    public static String warnTheSheep(String[] array) {
        //Your code)))
        if(array.length == 0){
            return "Pls go away and stop eating my sheep";
        }
        int counter = 0;
        int wolf = 0;
        int sheep = 0;
        for (int i = array.length - 1; i > 0; i--) {
            counter++;
            if (array[i].equals("wolf")) {
                wolf = counter;
                break;
            }
            if (array[i].equals("sheep")) {
                sheep = counter;
            }
        }
        return (wolf == 1) ? "Pls go away and stop eating my sheep" : "Oi! Sheep number " + sheep + "! You are about to be eaten by a wolf!";
    }
}
