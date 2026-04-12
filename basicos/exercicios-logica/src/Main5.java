import java.util.Locale;
import java.util.Scanner;

public class Main5 {
     
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();

            for (int i = 0; i < N; i++) {
                double n1 = sc.nextDouble();
                double n2 = sc.nextDouble();

                if (n2 != 0) {
                    double resultado = n1 / n2;
                    System.out.printf("%.1f%n", resultado);
                } else { 
                    System.out.println("divisao impossivel");
                }
            }
        }
    }
}