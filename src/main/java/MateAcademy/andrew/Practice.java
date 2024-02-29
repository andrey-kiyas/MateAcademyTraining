package MateAcademy.andrew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
//        System.out.println(numbOfOccur(new int[]{1, 1, 2, 2, 3}));

        System.out.println(firstA(new String[]{"Abf", "Cbd", "Aaa", "Baa", "Nbgf", "Aaa", "Lllk", "Kjhy", "Adsf"}));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static List<String> firstA(String[] arr) {
        return Arrays.stream(arr)
                .filter(l -> l.startsWith("A"))
                .collect(Collectors.toList());
    }

    public static List<String> firstA2(String[] arr) {
        ArrayList<String> result = new ArrayList<>();
        for (String str : arr) {
            if (str.startsWith("A")) {
                result.add(str);
            }
        }
        return result;
    }

    public static Map<Integer, Integer> numbOfOccur2(int[] numbers) {
        int count = 0;
        Map<Integer, Integer> result = new HashMap<>();
        for (Integer num : numbers) {
            if (result.containsKey(num)) {
                count = result.get(num);
                result.put(num, count + 1);
            } else {
                result.put(num, 1);
            }
        }
        return result;
    }

    public static Map<Integer, Integer> numbOfOccur(int[] numbers) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Integer num : numbers) {
            result.merge(num, 1, Integer::sum);
        }
        return result;
    }
}
