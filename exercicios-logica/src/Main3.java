import java.util.Locale;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Locale.setDefault(Locale.US);

            int N = sc.nextInt();
            
            double t1, t2, t3;
            double peso1 = 2;
            double peso2 = 3;
            double peso3 = 5;
            double media;
            
            for(int i = 0; i < N; i++) {
                t1 = sc.nextDouble();
                t2 = sc.nextDouble();
                t3 = sc.nextDouble();
                 media = (t1 * peso1 + t2 * peso2 + t3 * peso3) /
                 (peso1 = peso2 + peso3);
            System.out.printf("%.1f%n", media);
                }

           
        }
    }
}
