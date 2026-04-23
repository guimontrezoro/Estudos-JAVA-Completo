package Application;

import java.util.Locale;
import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

    public static void main(String[] args) {
    
        Locale.setDefault(Locale.US);
        
            Account acc = new Account(1001, "Alex", 0.0);
            // UPCASTING 

            Account acc1 = new BusinessAccount(1003, "Bob", 0.0, 0.0);
            Account acc2 = new SavingsAccount(1003, "Ana", 0.0, 0.0);
            // DOWNCASTING 

            BusinessAccount acc4 = (BusinessAccount)acc1;
            acc4.loan(100);

            // BusinessAccount acc5 = (BusinessAccount)acc2;
            if(acc2 instanceof BusinessAccount) {
                BusinessAccount acc5 = (BusinessAccount)acc2;
                acc5.loan(100);
                System.out.println("Loan");
            }
            if (acc2 instanceof SavingsAccount) {
                SavingsAccount acc5 = (SavingsAccount)acc2;
                acc5.updateBalance();
                System.out.println("Update");
            }
            acc2.withdraw(10);
            System.out.println(acc2.getBalance());
            acc.withdraw(10);
            System.out.println(acc.getBalance());
            acc1.withdraw(10);
            System.out.println(acc1.getBalance());

            Account x = new Account(1020, "Anderson", 1000.0);
            Account y = new SavingsAccount(10232, "Ana", 1000.0, 0.0);
            
            x.withdraw(50);
            y.withdraw(50);
            System.out.println(x.getBalance());
            System.out.println(y.getBalance());
        }
    } 
