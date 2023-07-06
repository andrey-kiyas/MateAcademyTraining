package MateAcademy.Java8.Part2.StreamAPIPractice.Car;

import java.util.List;
import java.util.stream.Collectors;

/**
 * У тебе є клас Car:
 *
 * class Car {
 *     private int year;
 *     private String model;
 *
 *     public Car(int year, String model) {
 *         this.year = year;
 *         this.model = model;
 *     }
 *
 *     public int getYear() {
 *         return year;
 *     }
 *
 *     public String getModel() {
 *         return model;
 *     }
 * }
 *
 * Реалізуй метод getCarModels(), який приймає список автомобілів cars та
 * повертає список моделей автомобілів, випущених після 1955 року.
 */

public class CarModels {
    public static List<String> getCarModels(List<Car> cars) {
        // write code here
        return cars.stream()
                .filter(c -> c.getYear() > 1965)
                .map(Car::getModel)
                .collect(Collectors.toList());
    }
}
