package Assignment11;

import java.util.ArrayList;

class Company {
    private String companyName;
    private ArrayList<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    public void deleteCompany() {
        departments.clear();
        System.out.println("Company " + companyName + " and all its departments/employees are deleted.");
    }
}

class Department {
    private String deptName;
    private ArrayList<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String empName, int empId) {
        employees.add(new Employee(empName, empId));
    }

    class Employee {
        private String empName;
        private int empId;

        public Employee(String empName, int empId) {
            this.empName = empName;
            this.empId = empId;
        }
    }
}

class Main2 {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        Department dept1 = new Department("IT");
        Department dept2 = new Department("HR");

        dept1.addEmployee("Alice", 101);
        dept1.addEmployee("Bob", 102);

        dept2.addEmployee("Charlie", 201);
        dept2.addEmployee("David", 202);

        company.addDepartment(dept1);
        company.addDepartment(dept2);

        company.deleteCompany();
    }
}



