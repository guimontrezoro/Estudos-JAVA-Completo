package Application;

import java.util.Locale;
import java.util.Scanner;

import Entities.ApprovedStudents;

public class Program {

        public static void main(String[] args) {
            Locale.setDefault(Locale.US);
            try(Scanner sc = new Scanner(System.in)) {

                System.out.print("How many people will be entered?");
                int n = sc.nextInt();
                sc.nextLine();

                ApprovedStudents approved = new ApprovedStudents(n);
                
                approved.enterData(sc);
                approved.studentsAverage();
                System.out.println(approved);
            }
        }
}
