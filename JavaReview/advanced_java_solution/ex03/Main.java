import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 28));
        employees.add(new Employee("Bob", 35));
        employees.add(new Employee("Charlie", 30));
        employees.add(new Employee("David", 40));
        employees.add(new Employee("Eva", 25));

        employees.forEach(employee -> System.out.println(employee.getName() + " " + employee.getAge()));

        double averageAge = employees.stream()
                .mapToInt(Employee::getAge)
                .average()
                .orElse(0.0);

        System.out.println("Average height of employees: " + averageAge);

        List<Employee> filteredLists = employees.stream()
                .filter(e -> e.getAge() <= 30)
                .collect(Collectors.toList());

        System.out.println();
        filteredLists.forEach(employee -> System.out.println(employee.getName() + " " + employee.getAge()));

        List<Employee> sortEmployeeList = employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .collect(Collectors.toList());

        System.out.println();
        sortEmployeeList.forEach(employee -> System.out.println(employee.getName() + " " + employee.getAge()));

        Optional<Employee> employee = employees.stream()
                .filter(e -> e.getName().equals("Bobb"))
                .findFirst();

        System.out.println();
        if (!employee.isEmpty()) {
            System.out.println(employee.get().getName() + " " + employee.get().getAge());
        }
        else {
            System.out.println("Employee does not exist.");
        }
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}