class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary amount");
        }
    }

    public double getSalary() {
        return salary;
    }

    class Manager {
        public void displayDetails() {
            System.out.println("Manager ID: " + employeeID);
            System.out.println("Department: " + department);
        }
    }


    public static void main(String[] args) {
        Employee employee = new Employee(101, "IT", 75000);
        Employee.Manager manager = employee.new Manager();
        manager.displayDetails();

        employee.setSalary(80000);
        System.out.println("Updated Salary: " + employee.getSalary());
    }
}