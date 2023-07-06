package MateAcademy.collections.ArrayPractice;

import java.util.HashMap;
import java.util.Map;

public class hashMapUsage {
    public static void main(String[] args) {
        Map<String, Integer> data = new HashMap<>();
        data.put("myhelloworld", 4);
        data.put("Hello", 7);
        data.put("AwesomeString", 8);
        data.put("Wow!!!! HELLO", 9);
        System.out.println(calculateSum(data, "hello"));
    }

    public static int calculateSum(Map<String, Integer> data, String keyPart) {
        // write code here
        int result = 0;
        for (Map.Entry<String, Integer> entry : data.entrySet()){
            if (entry.getKey().toLowerCase().contains(keyPart)){
                result += entry.getValue();
            }
        }
        return result;
    }
}
