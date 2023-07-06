package MateAcademy.more;

import java.util.Arrays;

public class DataFileParsing {
    public static void main(String[] args) {
        String file = "WWW? Four-bedroom farmhouse in the countryside. Wave! All of the four double bedrooms are en suite.\n" +
                "Farm kitchen, tables and chairs outside. Great for groups of friends. World and the supermarket is\n" +
                "half an hour by car and you can take a train from wall the village into the city. Escape from normal\n" +
                "life for a few days, width.";

//        System.out.println(file);

        String sentence = "Hell0 3v3ryb0dy @ stackoverflow $people \\implies queen$ equals ~queen --> ~people. /#logic";
        String[] split = sentence.split("\\W+");
        System.out.println(Arrays.asList(split));

    }
}
