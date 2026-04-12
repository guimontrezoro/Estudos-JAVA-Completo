package Application;

import java.util.Locale;
import java.util.Scanner;

import Entities.SchoolGrades;

public class Program {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        try(Scanner sc = new Scanner(System.in)) {

            SchoolGrades student = new SchoolGrades();

            System.out.println("Enter the student's name: ");
            student.name = sc.nextLine();
            System.out.println("Enter the first trimester grade (0 - 30): ");
            student.firstGrade = sc.nextDouble();
            System.out.println("Enter the second trimester grade (0 - 35): ");
            student.secondGrade = sc.nextDouble();
            System.out.println("Enter the third trimester grade (0 - 35): ");
            student.thirdGrade = sc.nextDouble();

            System.out.println(student);
        }
    }
}
