public class Employee 
{
    private String firstName;
    private String lastName;
    private double monthlyPay;
    private double yearlyPay;
    private double raisePay;
    
    public Employee()
    {
        firstName = "Fine";
        lastName = "Long";
        monthlyPay = 4000;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String first)
    {
        firstName = first;
    }
    
    public String getLastName()
    {
        return  lastName;
    }
    public void setLastName(String last)
    {
        lastName = last;
    }
    
    public double getMonthlyPay()
    {
        return monthlyPay;
    }
    public void setMonthlyPay(double monthP)
    {
        if(monthP < 0) 
        {
            monthlyPay = 0;
        }
        else 
        {
            monthlyPay = monthP;
        }
    }
    public double getYearlyPay(double monthPay)
    {
        yearlyPay = monthPay * 12;
        return yearlyPay;
    }
    
    public double getRaisePay(double yearlyPay)
    {
        raisePay = yearlyPay *1.1;
        return  raisePay;
    }
    
    public void printMethod()
    {
        System.out.printf( firstName + " " + lastName + "\nmonthly pay: $%.2f\n", monthlyPay);
        System.out.printf( "yearly pay: $%.2f\n", yearlyPay);
        System.out.printf( "raised yearly pay: $%.2f\n", raisePay);
        System.out.println("----------------------------");
    }
}
public class TestEmployee 
{
    public static void main(String[] args) 
    {
        
        Employee employee = new Employee();
        String firstName = "Jim";
        String lastName = "Green";
        double monthlyPay = 3456.7890; 
        double yearlyPay = employee.getYearlyPay(monthlyPay);
        double raisePay = employee.getRaisePay(yearlyPay);
        
        System.out.print("Default: ");
        employee.printMethod();

        
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setMonthlyPay(monthlyPay);
        yearlyPay = employee.getYearlyPay(monthlyPay);
        raisePay = employee.getRaisePay(yearlyPay);
        employee.printMethod();
        
        firstName = "Alice";
        lastName = "Boolean";
        monthlyPay = 5698.21;
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setMonthlyPay(monthlyPay);
        yearlyPay = employee.getYearlyPay(monthlyPay);
        raisePay = employee.getRaisePay(yearlyPay);
        employee.printMethod();
    }
}
