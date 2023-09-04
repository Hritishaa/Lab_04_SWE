import java.util.*;
class Employee {
    private String employeeID;
    private String name;
    private int age;
    private int salary;

    public Employee(String employeeID, String name, int age, int salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeID + "\tName: " + name + "\tAge: " + age + "\tSalary: " + salary;
    }
}

class EmployeeComparator implements Comparator<Employee> {
    private int sortingParameter;

    public EmployeeComparator(int sortingParameter) {
        this.sortingParameter = sortingParameter;
    }

    @Override
    public int compare(Employee emp1, Employee emp2) {
        switch (sortingParameter) {
            case 1: // Sort by Age
                return Integer.compare(emp1.getAge(), emp2.getAge());
            case 2: // Sort by Name
                return emp1.getName().compareTo(emp2.getName());
            case 3: // Sort by Salary
                return Integer.compare(emp1.getSalary(), emp2.getSalary());
            default:
                throw new IllegalArgumentException("Invalid sorting parameter.");
        }
    }
}

public class Assignment_04 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("161E90", "Raman", 41, 56000));
        employees.add(new Employee("161F91", "Himadri", 38, 67500));
        employees.add(new Employee("161F99", "Jaya", 51, 82100));
        employees.add(new Employee("171E20", "Tejas", 30, 55000));
        employees.add(new Employee("171G30", "Ajay", 45, 44000));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose sorting parameter: ");
        System.out.println("1. Age");
        System.out.println("2. Name");
        System.out.println("3. Salary");
        int sortingParameter = scanner.nextInt();

        Collections.sort(employees, new EmployeeComparator(sortingParameter));

        System.out.println("Sorted Employee Data:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
