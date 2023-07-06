package MateAcademy.collections.HashMap.EmployeeInformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeInformation {
    public static List<Employee> getEmployeesByCityAndYearOfBirth(
            Map<Employee, String> employeesInformation, int yearOfBirth, String city) {
        //write your code here
        List<Employee> employeeList = new ArrayList<>();
        for (Map.Entry<Employee, String> entry : employeesInformation.entrySet()) {
            if (entry.getKey().getYearOfBirth() == yearOfBirth && entry.getValue().equals(city)) {
                employeeList.add(entry.getKey());
            }
        }
        System.out.println(employeeList.size());
        return employeeList;
    }
}
