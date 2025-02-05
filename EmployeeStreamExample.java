import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private double salary;

    
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}

public class EmployeeStreamExample {
    public static void main(String[] args) {
        
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 28, 50000),
            new Employee("Bob", 35, 60000),
            new Employee("Charlie", 40, 70000),
            new Employee("David", 25, 48000),
            new Employee("Emma", 32, 75000)
        );

        
        List <String> filteredEmployeeNames = employees.stream()
            .filter(emp -> emp.getAge() > 30) 
            .map(Employee::getName)           
            .collect(Collectors.toList());    

        
        double averageSalary = employees.stream()
            .filter(emp -> emp.getAge() > 30) 
            .mapToDouble(Employee::getSalary) 
            .average()                   
            .orElse(0.0);                     

        
        System.out.println("Employees older than 30: " + filteredEmployeeNames);
        System.out.println("Average Salary of employees older than 30: $" + averageSalary);
    }
}
