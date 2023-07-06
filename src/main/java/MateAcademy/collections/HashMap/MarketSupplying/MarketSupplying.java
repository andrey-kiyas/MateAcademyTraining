package MateAcademy.collections.HashMap.MarketSupplying;

import MateAcademy.collections.HashMap.EmployeeInformation.Employee;

import java.util.HashMap;
import java.util.Map;

public class MarketSupplying {

    public static void main(String[] args) {

        Map<String, Integer> storage = new HashMap<>();
        storage.put("Apple", 10);
        storage.put("Orange", 20);

        System.out.println(supplyFruits(storage, 5));

    }


    public static Map<String, Integer> supplyFruits(Map<String, Integer> storage, int supply) {
        //write your code here
        Map<String, Integer> mapSupply = new HashMap<>();
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            mapSupply.put(entry.getKey(), entry.getValue() + supply);
        }
        return mapSupply;
    }
}
