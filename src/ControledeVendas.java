import java.util.Locale;
import java.util.Scanner;

public class ControledeVendas {

        public static void main(String[] args) {
            Locale.setDefault(Locale.US);       
            try(Scanner sc = new Scanner(System.in)) {
                
                System.out.println("How many sales will be recorded?");
                
                int n = sc.nextInt();
                sc.nextLine();

                String[] name = new String[n];
                double[] salevalue = new double[n];
                double[] comission = new double[n];
                double[] fsalevalue = new double[n];
                int[] payment = new int[n];
                int installments, i;
                double Sall = 0, SallLiq = 0, ComAll = 0, Avgsales = 0, TAvgsales = 0;
                int repeat, card = 0, cash = 0, pix = 0, aboveavg = 0; 
                double bsale = -1.0, lsale = 999999999;
                String bestseller ="";

                do {
                for(i = 0; i < n; i++) { 
                    System.out.println("Enter the seller's name.");
                    name[i] = sc.nextLine();

                    do {
                        System.out.println("Enter the sale prince.");
                    salevalue[i] = sc.nextDouble();
                        } while (salevalue[i] < 0);
                    
                    do {
                    System.out.println("Enter the payment method: 1 - Cash; 2 - PIX; 3 - Credit Card");
                    payment[i] = sc.nextInt();
                    sc.nextLine();
                        } while(payment[i] < 1 || payment[i] > 3);

                    if(payment[i] == 1) {
                        fsalevalue[i] = salevalue[i] * 0.90;
                        cash++;
                    } 
                    else if(payment[i] == 2) {
                        fsalevalue[i] = salevalue[i] * 0.95;
                        pix++;
                    }
                    
                    else  { do { System.out.println("How many installments?");
                        installments = sc.nextInt();
                        sc.nextLine();

                        if(installments <= 3) {
                           fsalevalue[i] = salevalue[i];
                        }
                        else if(installments > 3 && installments <= 12) { 
                            fsalevalue[i] = salevalue[i] * 1.08; // * (1 + 8 / 100.0)
                            }
                        }  while(installments <= 0 ||  installments > 12 );
                        card++;
                    }

                    if(fsalevalue[i] <= 1000.00) {
                        comission[i] = fsalevalue[i] * 0.05;

                    } 
                    else if(fsalevalue[i] >= 1000.01 && fsalevalue[i] <= 5000.00) {
                        comission[i] = fsalevalue[i] * 0.10;
                    } 
                    else if(fsalevalue[i] > 5000.00) {
                        comission[i] = fsalevalue[i] * 0.15;
                }
                    if(fsalevalue[i] > bsale) {
                        bsale = fsalevalue[i];
                        bestseller = name[i];
                    }
                     if(fsalevalue[i] < lsale) {
                        lsale = fsalevalue[i];
                    }
                    Sall += salevalue[i];
                    SallLiq += fsalevalue[i];
                    ComAll += comission[i];
                    Avgsales += fsalevalue[i];
                }

                TAvgsales = Avgsales / n;

                for(i = 0; i < n; i++) {
                      if (fsalevalue[i] > TAvgsales) {
                    aboveavg++;
                    }
                }
                    for(i = 0; i < n; i++) {
            System.out.printf("Seller: %s%n", name[i]);
            System.out.printf("Original Sale Value: %.2f%n", salevalue[i]);
            System.out.printf("Final Sale Value: %.2f%n", fsalevalue[i]);
            System.out.printf("Seller's comission: %.2f%n", comission[i]);
                }
            
            
            System.out.printf("Total vendido (sem desconto/juros): %.2f%n", Sall);
            System.out.printf("Final total (with rules applied): %.2f%n", SallLiq);
            System.out.printf("Total commissions paid: %.2f%n", ComAll);
            System.out.printf("Sales By Payment method: Cash - %d Pix - %d Card - %d%n", cash, pix, card);
            System.out.printf("Biggest Sale (Final Price): %.2f%n", bsale);
            System.out.printf("Lowest Sale (Final Price): %.2f%n", lsale);
            System.out.printf("Vendedor com a maior venda: %s%n", bestseller);
            System.out.printf("Average Sales: %.2f%n", TAvgsales);
            System.out.printf("Seller's Above Average: %d%n", aboveavg);
            System.out.println("Do you want to use the system again? 1 - Run Again 0 - Exit");
            repeat = sc.nextInt();
            while(repeat !=0 && repeat != 1) {
                System.out.println("Please enter 0 to exit and 1 to run again");
                repeat = sc.nextInt();
            }
                } while(repeat == 1);
        }
    }
}
