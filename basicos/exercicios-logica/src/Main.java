import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int x = sc.nextInt();

            if (x >= 1 && x <= 1000) {
                for (int i = 1; i <= x; i++) {
                    if (i % 2 != 0) {
                        System.out.println(i);
                    }
                }
            }
        }
    }
}