package Application;

import java.util.Locale;
import java.util.Scanner;

import Entities.UserData;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("How many people will be entered? ");
            int n = sc.nextInt();

            UserData data = new UserData(n);

            data.enterData(sc);

            double averageHeight = data.calculateAverageHeight();
            double under16Percentage = data.calculateUnder16Percentage();

            System.out.printf("%nAverage height = %.2f%n", averageHeight);
            System.out.printf("People under 16: %.1f%%%n", under16Percentage);

            data.showUnder16Names();
        }
    }
}