package Application;

import java.util.Locale;
import java.util.Scanner;

import Entities.Voting;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try(Scanner sc = new Scanner(System.in)) {

            System.out.print("How many students took part in the vote? ");
            int n = sc.nextInt();
            sc.nextLine();

            Voting vt = new Voting(n);

            vt.enterVotes(sc);
            vt.countVotes();
            vt.winningLanguage();
            vt.studentsWVotes();

            System.out.println(vt);
        }
    }
}
