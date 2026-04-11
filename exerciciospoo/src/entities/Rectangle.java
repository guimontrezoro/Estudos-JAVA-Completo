package entities;

public class Rectangle {
    public double width;
    public double height;

    public double area()  {
        return width * height;
    }
    public double perimeter() {
        return (width * 2) + (height * 2);
    }
    public double diagonal() {
    double x = (width * width) + (height * height);
        return Math.sqrt(x);
    }
    public String toString() {
        return "AREA = "
            + String.format("%.2f", area())
            +"/nPERIMETER = "
            + String.format("%.2f", area())
            +"/nDIAGONAL = "
            + String.format("%.2f", area());
    }
}