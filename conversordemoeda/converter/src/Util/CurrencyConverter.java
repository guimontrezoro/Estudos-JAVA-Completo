package Util;

public class CurrencyConverter {
    

    public static final double IOF = 0.06;

    public static double converter(double price, double quantity) {
        return  (price * quantity) * (1.00 + IOF);
    }

}
