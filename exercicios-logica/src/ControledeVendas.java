import java.util.Locale;
import java.util.Scanner;

public class ControledeVendas {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("How many sales will be recorded?");
            int n = sc.nextInt();
            sc.nextLine();

            String[] names = new String[n];
            double[] saleValues = new double[n];
            double[] commissions = new double[n];
            double[] finalSaleValues = new double[n];
            int[] paymentMethods = new int[n];

            int installments;
            int i;
            int repeat;

            double totalSales = 0;
            double totalFinalSales = 0;
            double totalCommissions = 0;
            double averageSalesSum = 0;
            double averageSales = 0;

            int card = 0;
            int cash = 0;
            int pix = 0;
            int aboveAverage = 0;

            double biggestSale = -1.0;
            double lowestSale = 999999999;
            String bestSeller = "";

            do {
                totalSales = 0;
                totalFinalSales = 0;
                totalCommissions = 0;
                averageSalesSum = 0;
                averageSales = 0;
                aboveAverage = 0;

                card = 0;
                cash = 0;
                pix = 0;

                biggestSale = -1.0;
                lowestSale = 999999999;
                bestSeller = "";

                for (i = 0; i < n; i++) {
                    System.out.println("Enter the seller's name:");
                    names[i] = sc.nextLine();

                    do {
                        System.out.println("Enter the sale price:");
                        saleValues[i] = sc.nextDouble();
                        sc.nextLine();
                    } while (saleValues[i] < 0);

                    do {
                        System.out.println("Enter the payment method: 1 - Cash; 2 - PIX; 3 - Credit Card");
                        paymentMethods[i] = sc.nextInt();
                        sc.nextLine();
                    } while (paymentMethods[i] < 1 || paymentMethods[i] > 3);

                    if (paymentMethods[i] == 1) {
                        finalSaleValues[i] = saleValues[i] * 0.90;
                        cash++;
                    } else if (paymentMethods[i] == 2) {
                        finalSaleValues[i] = saleValues[i] * 0.95;
                        pix++;
                    } else {
                        do {
                            System.out.println("How many installments?");
                            installments = sc.nextInt();
                            sc.nextLine();

                            if (installments <= 3) {
                                finalSaleValues[i] = saleValues[i];
                            } else if (installments <= 12) {
                                finalSaleValues[i] = saleValues[i] * 1.08;
                            }
                        } while (installments <= 0 || installments > 12);

                        card++;
                    }

                    if (finalSaleValues[i] <= 1000.00) {
                        commissions[i] = finalSaleValues[i] * 0.05;
                    } else if (finalSaleValues[i] <= 5000.00) {
                        commissions[i] = finalSaleValues[i] * 0.10;
                    } else {
                        commissions[i] = finalSaleValues[i] * 0.15;
                    }

                    if (finalSaleValues[i] > biggestSale) {
                        biggestSale = finalSaleValues[i];
                        bestSeller = names[i];
                    }

                    if (finalSaleValues[i] < lowestSale) {
                        lowestSale = finalSaleValues[i];
                    }

                    totalSales += saleValues[i];
                    totalFinalSales += finalSaleValues[i];
                    totalCommissions += commissions[i];
                    averageSalesSum += finalSaleValues[i];
                }

                averageSales = averageSalesSum / n;

                for (i = 0; i < n; i++) {
                    if (finalSaleValues[i] > averageSales) {
                        aboveAverage++;
                    }
                }

                for (i = 0; i < n; i++) {
                    System.out.printf("Seller: %s%n", names[i]);
                    System.out.printf("Original Sale Value: %.2f%n", saleValues[i]);
                    System.out.printf("Final Sale Value: %.2f%n", finalSaleValues[i]);
                    System.out.printf("Seller's commission: %.2f%n", commissions[i]);
                    System.out.println();
                }

                System.out.printf("Total sold (without discount/interest): %.2f%n", totalSales);
                System.out.printf("Final total (with rules applied): %.2f%n", totalFinalSales);
                System.out.printf("Total commissions paid: %.2f%n", totalCommissions);
                System.out.printf("Sales by payment method: Cash - %d | PIX - %d | Card - %d%n", cash, pix, card);
                System.out.printf("Biggest Sale (Final Price): %.2f%n", biggestSale);
                System.out.printf("Lowest Sale (Final Price): %.2f%n", lowestSale);
                System.out.printf("Seller with the biggest sale: %s%n", bestSeller);
                System.out.printf("Average Sales: %.2f%n", averageSales);
                System.out.printf("Sellers above average: %d%n", aboveAverage);

                System.out.println("Do you want to use the system again? 1 - Run Again | 0 - Exit");
                repeat = sc.nextInt();

                while (repeat != 0 && repeat != 1) {
                    System.out.println("Please enter 0 to exit or 1 to run again:");
                    repeat = sc.nextInt();
                }

                sc.nextLine();

            } while (repeat == 1);
        }
    }
}