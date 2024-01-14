package MateAcademy.codewars.CW7kyu;

public class DetermineIfThePokerHandIsFlush {

    public static void main(String[] args) {
        System.out.println(CheckIfFlush(new String[]{"AD", "4S", "7H", "KC", "5S"}));  // false
        System.out.println(CheckIfFlush(new String[]{"AS", "3S", "9S", "KS", "4S"}));  // true
        System.out.println(CheckIfFlush(new String[]{"QD", "4D", "10D", "KD", "5D"})); // true
        System.out.println(CheckIfFlush(new String[]{"AS", "3S", "9S", "KS", "4S"}));  // true
        System.out.println(CheckIfFlush(new String[]{"AD", "4S", "10H", "KC", "5S"})); // false
        System.out.println(CheckIfFlush(new String[]{"10D", "4D", "QD", "KD", "5D"})); // true
    }

    public static boolean CheckIfFlush(String[] cards) {
        //Write some code here
        if (cards.length != 5) {
            return false;
        }
        char suit = Character.toUpperCase(cards[0].charAt(cards[0].length() - 1));
        char check = cards[0].charAt(1);
        for (String card : cards) {
            check = Character.toUpperCase(card.charAt(card.length() - 1));
            if (check != suit) {
                return false;
            }
        }
        return true;
    }
}
