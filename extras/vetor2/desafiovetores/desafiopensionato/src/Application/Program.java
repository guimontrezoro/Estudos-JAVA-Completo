package Application;

import java.util.Locale;
import java.util.Scanner;

import Entities.Pensionato;
import Entities.Rent;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {
            Pensionato pensionato = new Pensionato();

            System.out.print("How many rooms will be rented? ");
            int n = sc.nextInt();

            while (n < 1 || n > 10) {
                System.out.print("Invalid number. Enter again: ");
                n = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                sc.nextLine();
                System.out.printf("Rent #%d:%n", i + 1);

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                System.out.print("Room: ");
                int roomNumber = sc.nextInt();

                pensionato.rentRoom(roomNumber, new Rent(name, email));
            }

            System.out.println();
            System.out.println("Busy rooms:");
            System.out.print(pensionato);
        }
    }
}