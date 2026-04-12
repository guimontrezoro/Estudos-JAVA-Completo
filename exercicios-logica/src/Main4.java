import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            
        int N = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            if (N % i == 0) {
                System.out.println(i);
                    }
                }
            } 
        }
    }

