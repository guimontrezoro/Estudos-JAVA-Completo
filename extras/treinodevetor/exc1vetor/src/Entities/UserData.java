package Entities;

import java.util.Scanner;

public class UserData {

    private int count;
    private String[] names;
    private double[] heights;
    private int[] ages;

    public UserData(int count) {
        this.count = count;
        this.names = new String[count];
        this.heights = new double[count];
        this.ages = new int[count];
    }

    public void enterData(Scanner sc) {
        for (int i = 0; i < count; i++) {
            System.out.printf("Person #%d data:%n", i + 1);

            System.out.print("Name: ");
            names[i] = sc.next();

            System.out.print("Age: ");
            ages[i] = sc.nextInt();

            System.out.print("Height: ");
            heights[i] = sc.nextDouble();
        }
    }

    public double calculateAverageHeight() {
        double sum = 0.0;
        for (int i = 0; i < count; i++) {
            sum += heights[i];
        }
        return sum / count;
    }

    public double calculateUnder16Percentage() {
        int under16Count = 0;
        for (int i = 0; i < count; i++) {
            if (ages[i] < 16) {
                under16Count++;
            }
        }
        return (double) under16Count / count * 100.0;
    }

    public void showUnder16Names() {
        for (int i = 0; i < count; i++) {
            if (ages[i] < 16) {
                System.out.println(names[i]);
            }
        }
    }
}