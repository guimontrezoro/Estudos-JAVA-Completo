package Entities;

public class SchoolGrades {

    public String name;
    public double firstGrade;
    public double secondGrade;
    public double thirdGrade;

    public double Student() {
        return firstGrade + secondGrade + thirdGrade;
    }
    public String getStatus() {
        if(Student() >= 60) {
            return "PASS";
        }
        else {
            return "FAILED";
        }
    }
    public double missingPoints() {
        if(Student() >= 60) {
            return 0.0;
    }
    else {
        return 60 - Student(); 
        }
    }
@Override
public String toString () {
            
    if(Student() >= 60) {
        return "FINAL GRADE = "
            +String.format("%.2f", Student())
            +"\nPASS";
            }
            else {
                return "FINAL GRADE = "
                +String.format("%.2f", Student())
                +"\nFAILED "
                +"\nMISSING "
                +String.format("%.2f", missingPoints())
                +" POINTS";
            }
}          
}
    