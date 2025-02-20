package AssignmentCollectionFramework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupObjectsByProperty {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> groupedEmployees = new HashMap<>();

        for (Employee employee : employees) {
            String department = employee.getDepartment();
            groupedEmployees.computeIfAbsent(department, k -> new ArrayList<>()).add(employee);
        }

        return groupedEmployees;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Anika", "EC"));
        employees.add(new Employee("Abhii", "EMBEDDED"));
        employees.add(new Employee("Sneha", "VLSI"));

        Map<String, List<Employee>> grouped = groupByDepartment(employees);
        System.out.println(grouped);
    }
}
