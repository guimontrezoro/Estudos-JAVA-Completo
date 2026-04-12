import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        try(Scanner sc = new Scanner(System.in)) {
        
        double percentage;        
        Employee data = new Employee();
        
        System.out.print("Enter employee name: ");
        data.name = sc.nextLine();
        System.out.print("Enter gross salary: ");
        data.grossSalary = sc.nextDouble();
        System.out.print("Enter tax: ");
        data.tax = sc.nextDouble();

        System.out.println("Employee: " + data);

        System.out.print("Which percentage to increase salary? "); 
        percentage = sc.nextDouble();
        
        data.increaseSalary(percentage);

        System.out.println("Updated data: " + data);

        }
    }
}
