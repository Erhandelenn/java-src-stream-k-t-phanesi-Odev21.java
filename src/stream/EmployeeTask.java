package stream;

import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;

public class EmployeeTask {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Erhan Delen", 28, "IT", 50000),
                new Employee("Yekta Karatay", 35, "IT", 60000),
                new Employee("Yiğit Yeniay", 32, "IT", 70000),
                new Employee("Ahmet Rasim", 45, "Finance", 80000),
                new Employee("Kahraman Yiğit", 29, "HT", 55000)
        );

        List<String> itEmployeeNames = employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("IT Departmanında Çalışanların İsimleri: " + itEmployeeNames);

        double averageSalaryAbove30 = employees.stream()
                .filter(emp -> emp.getAge() > 30)
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        System.out.println("30 Yaşından Büyük Çalışanların Ortalama Maaşı: " + averageSalaryAbove30);

        Map<String, Long> employeeCountByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Her Departmandaki Çalışan Sayısı: " + employeeCountByDepartment);

        Employee highestPaidEmployee = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);

        if (highestPaidEmployee != null) {
            System.out.println("En Yüksek Maaşlı Çalışan: " + highestPaidEmployee.getName() + ", Maaş: " + highestPaidEmployee.getSalary());
        } else {
            System.out.println("Çalışan bulunamadı.");
        }
    }
}