package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.Employee;

public class Program {

    public static Integer Idposition(List<Employee> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;        
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try(Scanner sc = new Scanner(System.in)) {
        List<Employee> list = new ArrayList<>();

            System.out.print("How many employees will be registered? ");
            int n = sc.nextInt();

            for(int i = 0; i < n; i++) {
                System.out.println();
                System.out.println("Employee #" + (i + 1) + ":");
                
                System.out.print("Id: ");
                int id = sc.nextInt();

                  while (Idposition(list, id) != null) {
                System.out.print("Id already taken! Try again: ");
                id = sc.nextInt();
            }
                sc.nextLine();
                System.out.print("Name: ");
                String nome = sc.nextLine();

                System.out.print("Salary: ");
                double salario = sc.nextDouble();

                list.add(new Employee(id, nome, salario));
            }
                System.out.println();
                System.out.print("Enter the employee id that will have salary increase: ");
                int idSalario = sc.nextInt();

                Integer pos = Idposition(list, idSalario);

                if (pos == null) {
                    System.out.println("This id does not exist!");
                } else {
                    System.out.print("Enter the percentage: ");
                    double porcentagem = sc.nextDouble();
                    list.get(pos).increaseSalary(porcentagem);
                }

                System.out.println();
                System.out.println("List of employees:");
                for (Employee emp : list) {
                    System.out.println(emp);
            }
        }
    }
}
