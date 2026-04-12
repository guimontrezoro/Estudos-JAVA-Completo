package Entities;

import java.util.Scanner;

public class Voting {

private String[] name;
private int[] vote;
private int count;
private int Java = 0, Python = 0, C = 0; 

public Voting(int count) {
    this.count = count;
    this.name = new String[count];
    this.vote = new int[count];
}
    public void enterVotes(Scanner sc) {
        for (int i = 0; i < count; i++) {
            System.out.printf("Enter the %d student's name: ", i+1);
            name[i] = sc.nextLine();

            System.out.printf("Enter the %d student's vote 1-Java 2-Python 3-C++ : ", i+1);
            vote[i] = sc.nextInt();
            sc.nextLine();
        }
    }
    public void countVotes() {
        for (int i = 0; i < count; i++) {
            if(vote[i] == 1) {
                Java++;
            }
            else if (vote[i] == 2) {
                Python++;
            }
            else if (vote[i] == 3){
                C++;
            }
        }
    }
    public String winningLanguage() {
        String wLanguage = "";
        
            if(Java > Python && Java > C) {
                wLanguage = "Java";
            }
            else if (C > Java && C > Python) {
                wLanguage = "C++";
            }
            else if(Python > Java && Python > C) {
                wLanguage = "Python";
            }
            else {    
                wLanguage = "Empate geral";
            }
            return wLanguage;
    }
    public String studentsWVotes() {
        String wstudentvotes = "";
             
        for (int i = 0; i < count; i++) {
            if (winningLanguage().equals("Java")) {
                if (vote[i] == 1) 
                wstudentvotes += name[i] + "\n";
            }
            else if (winningLanguage().equals("Python")) {
                if (vote[i] == 2) 
                wstudentvotes += name[i] + "\n";
            }
            else if (winningLanguage().equals("C++")) {
                if (vote[i] == 3) 
                wstudentvotes += name[i] + "\n";
            }
            else{
                wstudentvotes = "Empate geral, sem linguagem vencedora";
            }
        }
        return wstudentvotes;
    }
@Override    
    public String toString() {
        return String.format("Java: %d votos\n", Java)
               +String.format("Python: %d votos\n", Python)
               +String.format("C++: %d votos\n", C)
               +"\nWinner: "  + winningLanguage()
               +"\nStudents who voted for the winning language: \n" + studentsWVotes();
    }          
}

