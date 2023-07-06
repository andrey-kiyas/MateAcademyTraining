package MateAcademy.SetQueueStackComparator.EmployeeComparator;


import java.util.*;

import java.util.Set;
import java.util.TreeSet;

public class EmployeeService {

  public static void main(String[] args) {


    Employee alice = new Employee("Alice Adams", 22, "female", "12345678");
    Employee bob = new Employee("Bob Allen", 20, "male", "02783927");
    Employee jack = new Employee("Jack Baker", 23, "male", "72839164");
    Employee ella = new Employee("Ella Ball", 25, "female", "26374910");
    Employee nicolas = new Employee("Nicolas Brown", 27, "male", "53649103");
    Employee john = new Employee("John Carter", 23, "male", "19203745");
    Employee james = new Employee("James Clarke", 23, "male", "29103846");
    Employee anna = new Employee("Anna Collins", 22, "female", "26172840");

    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(alice);
    employeeList.add(bob);
    employeeList.add(jack);
    employeeList.add(ella);
    employeeList.add(nicolas);
    employeeList.add(john);
    employeeList.add(james);
    employeeList.add(anna);
    System.out.println(getEmployeesByOrder(employeeList));


  }


  public static Set<Employee> getEmployeesByOrder(List<Employee> employees) {
    //write your code here
    Comparator<Employee> employeeComparator = new Comparator<Employee>() {
      @Override
      public int compare(Employee emplFirst, Employee emplSecond) {
        int comparedEmployees = Integer.compare(emplFirst.getAge(), emplSecond.getAge());
        if (comparedEmployees != 0){
          return emplFirst.getAge() - emplSecond.getAge();
//          return comparedEmployees;
        }
        return emplFirst.getName().compareTo(emplSecond.getName());
      }
    };
    Set<Employee> result = new TreeSet<>(employeeComparator);
    result.addAll(employees);
    return result;
  }
}




//    result.addAll((Collection<? extends Employee>) employeeComparator);
//    return result;
