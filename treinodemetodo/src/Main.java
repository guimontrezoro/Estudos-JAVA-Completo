import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int option;
        int n = employees();
        String[] names = registerEmployees(n);
        double[] salaries = grossSalary(n);
        double[] deduction = deductions(salaries);
        double[] netSalaries = netSalary(salaries, deduction);
        String[] salarylvl = salaryLevel(netSalaries, n);
        do {
            option = menu();

            switch (option) {
                case 1:
                    System.out.println("Registering employees: ");

                    n = employees();
                    names = registerEmployees(n);
                    salaries = grossSalary(n);
                    deduction = deductions(salaries);   
                    netSalaries = netSalary(salaries, deduction);
                    salarylvl = salaryLevel(netSalaries, n);
                    break;

                case 2:
                    System.out.println("Showing statistics: ");
                    if (names == null) {
                        System.out.println("No employees registered yet.");
                    } else {
                        showStats(names, salaries, deduction, netSalaries, n, salarylvl);
                        Average(n, netSalaries);
                        highestSalary(netSalaries, n, names);
                        lowestSalary(netSalaries, n);
                    }
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid Option");
            }

            Locale.setDefault(Locale.US);

        } while (option != 3);
        sc.close();

    }

    public static int employees() {

        while (true) {
            System.out.print("How many employees will be registered? ");

            try {
                int n = sc.nextInt();

                if (n > 0) {
                    return n;
                } else {
                    System.out.println("Enter a value greater than 0.");
                }

            } catch (Exception e) {
                System.out.println("Digite um valor inteiro.");
                sc.next();
            }
        }
    }

    public static String[] registerEmployees(int n) {
        sc.nextLine();
        String[] name = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter employee name: ");
            name[i] = sc.nextLine();
        }

        return name;
    }

    public static boolean validateSalary(double salary) {
        return salary >= 0;
    }

    public static double[] grossSalary(int n) {
        double[] salary = new double[n];

        for (int i = 0; i < n; i++) {

            while (true) {
                System.out.print("Enter employee gross salary: ");

                if (sc.hasNextDouble()) {
                    salary[i] = sc.nextDouble();

                    if (validateSalary(salary[i])) {
                        break;
                    } else {
                        System.out.println("Negative salary is not allowed.");
                    }
                } else {
                    System.out.println("Invalid value. Enter a numeric salary.");
                    sc.next();
                }
            }
        }

        return salary;
    }

    public static double[] deductions(double[] salaries) {
        double[] deduction = new double[salaries.length];

        for (int i = 0; i < salaries.length; i++) {

            if (salaries[i] <= 2000.00) {
                deduction[i] = 0.00;
            } else if (salaries[i] <= 5000.00) {
                deduction[i] = salaries[i] * 0.10;
            } else {
                deduction[i] = salaries[i] * 0.20;
            }
        }

        return deduction;
    }

    public static double[] netSalary(double[] salaries, double[] deduction) {
        double[] net = new double[salaries.length];

        for (int i = 0; i < salaries.length; i++) {
            net[i] = salaries[i] - deduction[i];
        }
        return net;
    }

    public static String[] salaryLevel(double[] netSalaries, int n) {
        String[] salarylvl = new String[n];

        String lvl1 = "Low";
        String lvl2 = "Medium";
        String lvl3 = "High";

        for (int i = 0; i < n; i++) {
            if (netSalaries[i] < 2000) {
                salarylvl[i] = lvl1;
            } else if (netSalaries[i] <= 5000) {
                salarylvl[i] = lvl2;
            } else {
                salarylvl[i] = lvl3;
            }
        }
        return salarylvl;
    }

    public static void showStats(String[] names, double[] salaries, double[] deduction, double[] netSalaries, int n,
            String[] salarylvl) {

        for (int i = 0; i < n; i++) {
            System.out.printf("Name: %s%n", names[i]);
            System.out.printf("Gross Salary: %.2f%n", salaries[i]);
            System.out.printf("Deductions: %.2f%n", deduction[i]);
            System.out.printf("Net Salary: %.2f%n", netSalaries[i]);
            System.out.printf("Employee salary level: %s%n", salarylvl[i]);
        }
    }

    public static void Average(int n, double[] netSalaries) {
        double soma = 0;
        int aboveavg = 0;
        double salariesAverage;

        for (int i = 0; i < n; i++) {
            soma += netSalaries[i];
        }

        salariesAverage = soma / n;

        for (int i = 0; i < n; i++) {
            if (netSalaries[i] > salariesAverage) {
                aboveavg++;
            }
        }

        System.out.printf("Total spent on net salaries: %.2f%n", soma);
        System.out.printf("Average Salary: %.2f%n", salariesAverage);
        System.out.printf("Employees Above Average: %d%n", aboveavg);
    }

    public static void highestSalary(double[] netSalaries, int n, String[] names) {
        double hsalary = netSalaries[0];
        String hsalaryemployee = "";
        for (int i = 0; i < n; i++) {
            if (netSalaries[i] > hsalary) {
                hsalary = netSalaries[i];
                hsalaryemployee = names[i];
            }
        }
        System.out.printf("Biggest Salary: %.2f%n", hsalary);
        System.out.printf("Employee with the highest salary: %s%n", hsalaryemployee);
    }

    public static void lowestSalary(double[] netSalaries, int n) {
        double lsalary = netSalaries[0];

        for (int i = 0; i < n; i++) {
            if (netSalaries[i] < lsalary) {
                lsalary = netSalaries[i];
            }
        }

        System.out.printf("Lowest Salary: %.2f%n", lsalary);
    }

    public static int menu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1 - Register employees");
        System.out.println("2 - Show statistics");
        System.out.println("3 - Exit");
        System.out.print("Choose an option: ");

        return sc.nextInt();
    }
}
