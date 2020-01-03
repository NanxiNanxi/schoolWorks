 static Scanner keyborad = new Scanner(System.in);
    public static void main(String[] args) 
    {
        // get input values
        System.out.println("Please enter your general income: ");
        double generalIncome = keyborad.nextDouble();
        System.out.println("Please enter your investment income: ");
        double investmentIncome = keyborad.nextDouble();
        System.out.println("Please enter your other income: ");
        double otherIncome = keyborad.nextDouble();
        System.out.println("Please enter your regular deductions: ");
        double regularDeductions = keyborad.nextDouble();
        System.out.println("Please enter your other deductions: ");
        double otherDeductions = keyborad.nextDouble();
        
        System.out.println("Please enter how much income tax you have paid: ");
        double installment = keyborad.nextDouble();
        
        //use methods to calculate taxable income and income tax
        double taxableIncome = calculateTaxableIncome(generalIncome, investmentIncome, otherIncome, regularDeductions, 
            otherDeductions);
        
        double incomeTax = 0;
        incomeTax = calculateIncomeTax(taxableIncome);
        
        double remain = incomeTax - installment;
        
        //print out 2 decimals
        System.out.println("Your taxable income is $" + (String.format("%.2f",taxableIncome)));
        System.out.println("Your income tax is $" + (String.format("%.2f",incomeTax)));
        if(remain > 0) 
        {
            System.out.println("You still need to pay $" + (String.format("%.2f",remain)));
        }
        if(remain == 0)
        {
            System.out.println("You don't need to pay income tax.");
        }
        if(remain < 0)
        {
            System.out.println("You have a return of $" + (String.format("%.2f",(Math.abs(remain)))));
        }
    }
    
    public static double calculateTaxableIncome(double generalIncome, 
            double investmentIncome, double otherIncome, double regularDeductions, 
            double otherDeductions)
    {
        double taxableIncome = 0;
        taxableIncome = roundNumber((generalIncome + investmentIncome + otherIncome - regularDeductions - 0.5 * otherDeductions), 2);
        return taxableIncome;
    }
    public static double calculateIncomeTax(double taxableIncome)
    {

        double incomeTax = 0;
        if(taxableIncome <= 20000 && taxableIncome > 0)
        {
            incomeTax = taxableIncome * .1;
        }
        if (taxableIncome > 20000 && taxableIncome <= 40000)
            {
              incomeTax = (taxableIncome - 20000)* .12 + 2000;
            }
        if (taxableIncome > 40000 && taxableIncome <= 60000)
           {
              incomeTax = (taxableIncome -40000)* .15 + 4400;
           }
        if (taxableIncome > 60000)
          {
            incomeTax = (taxableIncome - 60000) * .2 + 7400;
           } 
         double incomTaxReturn = roundNumber(incomeTax, 2);
         return incomTaxReturn;
    }
    public static double roundNumber(double a, int n)
    {
        double b = a * Math.pow(10, n);
        b = b + .5;
        a = ((int)b)/Math.pow(10, n);
        return a;
    }
    
