package Entities;

import java.util.Scanner;

public class ApprovedStudents {

private double[] firstGrade;
private double[] secondGrade;
private double[] averageGrade;
private String[] name;
private int count;

    public ApprovedStudents(int count){
        this.count = count;
        this.firstGrade = new double[count];
        this.secondGrade = new double[count];
        this.name = new String[count];
        this.averageGrade = new double[count];
}
    public void enterData(Scanner sc) {
        for (int i = 0; i < count; i++) {
            System.out.printf("Enter the %d student's name, first grade, and second grade:\n", i+1);
            name[i] = sc.nextLine();
            firstGrade[i] = sc.nextDouble();
            secondGrade[i] = sc.nextDouble();
            sc.nextLine();
        }
    }
    public void studentsAverage() {
        for (int i = 0; i < count; i++) {
            averageGrade[i] = (firstGrade[i] + secondGrade[i]) / 2;    
        }
    }
    public String finalApproved() {
        String text = "";
        for (int i = 0; i < count; i++) {
            if (averageGrade[i] >= 6.0) {
                text += name[i] + "\n";
            }
        }
        return text;
    }
    public String toString() {
        return "Approved Students:\n" + finalApproved();
    }
}