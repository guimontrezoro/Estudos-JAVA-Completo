package Application;

import java.util.Locale;
import java.util.Scanner;

import Entities.evennumbers;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try(Scanner sc = new Scanner(System.in)) {

            System.out.println("How many people will be entered?");
            int n = sc.nextInt();

            evennumbers even = new evennumbers(n);
            even.enterData(sc);
            
            System.out.println();
            System.out.println(even);
        }
    }    
}
