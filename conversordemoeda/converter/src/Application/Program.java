package Application;

import java.util.Locale;
import java.util.Scanner;
import Util.CurrencyConverter;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try(Scanner sc = new Scanner(System.in)) {

            System.out.print("What is the dollar price? ");
            double price = sc.nextDouble();
            
            System.out.printf("How many dollar will be bought? ");
            double quantity = sc.nextDouble();

            double result = CurrencyConverter.converter(price, quantity);

            System.out.printf("Amount to be paid in reais = %.2f", result);

        }
    }
}
