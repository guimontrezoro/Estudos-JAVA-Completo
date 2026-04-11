package Entities;

import java.util.Scanner;

public class evennumbers {

    private double[] height;
    private char[] gender;
    private int count;

    public evennumbers(int count) {
        this.count = count;
        this.height = new double[count];
        this.gender = new char[count];
    }

    public void enterData(Scanner sc) {
        for (int i = 0; i < count; i++) {
            System.out.printf("Height of %d person: ", i + 1);
            height[i] = sc.nextDouble();

            System.out.printf("Gender of %d person (M/W): ", i + 1);
            gender[i] = sc.next().charAt(0);
        }
    }

    public double higherHeight() {
        double higher = height[0];

        for (int i = 1; i < count; i++) {
            if (height[i] > higher) {
                higher = height[i];
            }
        }

        return higher;
    }

    public double shorterHeight() {
        double shorter = height[0];

        for (int i = 1; i < count; i++) {
            if (height[i] < shorter) {
                shorter = height[i];
            }
        }

        return shorter;
    }

    public double womenAverage() {
        double sum = 0.0;
        int women = 0;

        for (int i = 0; i < count; i++) {
            if (gender[i] == 'W') {
                sum += height[i];
                women++;
            }
        }

        if (women == 0) {
            return 0.0;
        }

        return sum / women;
    }

    public int menCount() {
        int men = 0;

        for (int i = 0; i < count; i++) {
            if (gender[i] == 'M') {
                men++;
            }
        }

        return men;
    }

    public String toString() {
        return "Shorter height: "
                +shorterHeight()
                +"\nHigher height: "
                +higherHeight()
                +"\nAverage women height: "
                +womenAverage()
                +"\nCount of men: "
                +menCount();
    }
}