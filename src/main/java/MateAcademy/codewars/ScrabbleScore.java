package MateAcademy.codewars;

public class ScrabbleScore {
    public static int scrabbleScore(String word) {
        //solution
        int score = 0;
        char[] chars = word.toUpperCase().toCharArray();
        char[] englishScoreTable = new char[]{
                1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10
        };
        for (char Letter : chars) {
            if (Letter >= 'A' && Letter <= 'Z') {
                score += englishScoreTable[Letter - 'A'];
            }
        }
        return score;
    }
}
