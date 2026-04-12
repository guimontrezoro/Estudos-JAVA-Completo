import java.util.Locale;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		double a, b, c, Celevado;
		double areatr, areacirc, areatrap, areaquad, arearet;
		
		a = sc.nextDouble();
		b = sc.nextDouble();
		c = sc.nextDouble();
		
		Celevado = Math.pow(c,2);
		
		areatr = (a*c) / 2;
		areacirc = Celevado * 3.14159;
		areatrap = ( (a + b) * c) / 2;
		areaquad = b * b;
		arearet = a * b;
		
		System.out.printf("TRIANGULO: %.3f%n", areatr);
		System.out.printf("CIRCULO: %.3f%n", areacirc);
		System.out.printf("TRAPEZIO: %.3f%n", areatrap);
		System.out.printf("QUADRADO: %.3f%n", areaquad);
		System.out.printf("RETANGULO: %.3f%n", arearet);
		
	sc.close();
	
	}
}
         
         