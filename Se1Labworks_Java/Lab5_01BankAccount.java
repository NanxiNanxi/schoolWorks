public class Account 
{
    private static int numberOfAccounts;
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account()
    {
        balance = 0;
        numberOfAccounts++;
        id = 0;
        annualInterestRate = 0;
    }
    
    public Account(double newBalance, double newAnnualInterestRate)
    {
        balance = newBalance;
        numberOfAccounts++;
        annualInterestRate = newAnnualInterestRate;
    }
    public static int getNumberOfAccounts()
    {
        return numberOfAccounts;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int idGet)
    {
        id = idGet;
    }
    public double getBalance()
    {
        return balance;
    }
    public void setBalance(double balanceGet)
    {
        if(balanceGet >= 0) 
        {
            balance = balanceGet;
        }
        else
        {
            balance = balance;
        }
    }

    public double getAnnualInterestRate()
    {
        return annualInterestRate;
    }
    public void setAnnualInterestRate(double interestGet)
    {
        annualInterestRate = interestGet;
    }
    
    public double getMonthlyInterestRate(double monthlyInterestGet)
    {
        double monthlyInterest = monthlyInterestGet;
        return monthlyInterest;
    }
  

    public double withdraw(double amount)
    {
        double newBalance = 0;
        if(amount < 0)
        { 
            newBalance = this.balance;
        }
        else if(amount >= 0.0 && amount <= this.balance)
        {
            newBalance = this.balance - amount;
        }  
        return newBalance;
    }
    public double deposit(double amount)
    {
        double newBalance = 0;
        if(amount >= 0)
        {
            newBalance = this.balance + amount;
        }
        else
        {
            newBalance = this.balance;
        }
        return newBalance;
    }
    public void transfer(double amount, Account otherAccount)
    {     
        if(amount <= 0 || amount > this.balance)
        {
            System.out.println("Please enter a valid number!");
        }
        else 
        {
            this.setBalance(this.withdraw(amount));
            otherAccount.setBalance(otherAccount.deposit(amount));    
        } 
    }
    
}


import java.util.*;
public class TestAccount 
{
    static Scanner k = new Scanner(System.in);
    public static void main(String[] args) 
    {
        Account.getNumberOfAccounts();
        Account acc1 =new Account(5005, 0.2);
        int id1 = Account.getNumberOfAccounts();
        double balance1 = acc1.getBalance();
        double annualRate1 = acc1.getAnnualInterestRate();
        
        Account acc2 =new Account(4000, 0.24);
        int id2 = Account.getNumberOfAccounts();
        double balance2 = acc2.getBalance();
        double annualRate2 = acc2.getAnnualInterestRate();

        System.out.println("Start from " + Account.getNumberOfAccounts() + " accounts");
        System.out.println("-----------------------------------------------");
        System.out.println("ID: " + id1 + "\nBalance: " + balance1 + "\nAnnual interest rate: "
        + annualRate1);
        System.out.println("ID: " + id2 + "\nBalance: " + balance2 + "\nAnnual interest rate: "
        + annualRate2);
        System.out.println("-----------------------------------------------");
        
        Account acc3 = new Account(2000, 0.26);
        int id3 = Account.getNumberOfAccounts();
        double balance3 = acc3.getBalance();
        double annualRate3 = acc3.getAnnualInterestRate();
        System.out.println("After create a new account, there are " + Account.getNumberOfAccounts() + " accounts now.");
        System.out.println("New account information:\nID: " + id3 + "\nBalance: " + balance3 + "\nAnnual interest rate: "
        + annualRate3);
        System.out.println("-----------------------------------------------"); 
        System.out.println("Please enter how much you want to transfer: ");
        double cash = k.nextDouble();
        
        acc2.transfer(cash, acc3);
        
        balance2 = acc2.getBalance();
        annualRate2 = acc2.getAnnualInterestRate();
        balance3 = acc3.getBalance();
        annualRate3 = acc3.getAnnualInterestRate();
        
        System.out.println("\nID: " + id2 + "\nBalance: " + balance2 + "\nAnnual interest rate: "
        + annualRate2);
        System.out.println("ID: " + id3 + "\nBalance: " + balance3 + "\nAnnual interest rate: "
        + annualRate3);
       
    }
    
}
