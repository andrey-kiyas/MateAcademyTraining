package MateAcademy.collections.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ListFilter {
    //write your method here
    public static List<Person> filter(List<Person> person) {
        List<Person> male = new ArrayList<>();
        if (person == null) {
            return male;
        }
        for (Person value : person) {
            if (value.getSex().equals("male") && (value.getAge() >= 18 && value.getAge() <= 27)) {
                male.add(value);
            }
        }
        return male;
    }
}
