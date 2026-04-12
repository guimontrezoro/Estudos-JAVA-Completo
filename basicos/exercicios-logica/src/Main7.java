import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            int number = i;
            double quadrado = Math.pow(i, 2);
            double cubo = Math.pow(i, 3);

            System.out.printf("%d %.0f %.0f %n", number, quadrado, cubo);
            }
        }
    }
}
