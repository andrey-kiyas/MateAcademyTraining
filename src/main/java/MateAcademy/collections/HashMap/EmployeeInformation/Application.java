package MateAcademy.collections.HashMap.EmployeeInformation;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        Employee employee1 = new Employee("Ivan", "Ivanov", 2001);
        Employee employee2 = new Employee("Petr", "Petrov", 1984);
        Employee employee3 = new Employee("Sidr", "Sidrov", 1995);
        Employee employee4 = new Employee("Vlad", "Vladikov", 1984);

        Map<Employee, String> employeesInformation = new HashMap<>();
        employeesInformation.put(employee1, "Kiev");
        employeesInformation.put(employee2, "Kiev");
        employeesInformation.put(employee3, "Charkov");
        employeesInformation.put(employee4, "Kiev");

        System.out.println(EmployeeInformation.getEmployeesByCityAndYearOfBirth(employeesInformation, 1984, "Kiev"));
    }
}
