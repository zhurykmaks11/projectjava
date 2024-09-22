package task4;
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee name = " + name + ", salary =" + salary ;
    }
}

public class salaryem {
    public static void main(String[] args) {
        // Створюємо список співробітників
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 2500),
                new Employee("Bob", 3200),
                new Employee("Charlie", 4000),
                new Employee("David", 5200),
                new Employee("Eve", 6000),
                new Employee("Frank", 2900)
        );

        Map<String, Optional<Employee>> groupedEmployees = employees.stream()
                .collect(Collectors.groupingBy(
                        salaryem::getSalaryRange,
                        Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))
                ));

        // Виводимо результат
        groupedEmployees.forEach((range, employee) ->
                System.out.println("Salary : " + range + ", Top employee: " +
                        employee.orElse(null))
        );
    }

    // Метод для визначення діапазону зарплат
    public static String getSalaryRange(Employee employee) {
        int salary = employee.getSalary();
        if (salary < 3000) {
            return "< 3000";
        } else if (salary <= 5000) {
            return "3000–5000";
        } else {
            return "> 5000";
        }
    }
}

