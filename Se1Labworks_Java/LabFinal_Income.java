 public static void main(String[] args)
    {
        String [] names = {"Gerry", "Lindsey", "Erin", "Brett","Bob"};
        int [] units = {12, 42, 51, 34, 76};
        double [] commissionRate = {.07, .075, .05, .08, .05};
        int maxIndex = ArrayMethods.getMaxIndex(units);
        System.out.println("a: " + names[maxIndex]+" sold the most during the week: " + 
                units[maxIndex] + " units.");
        System.out.println("------------------------------------------");
        
        double[] totalPay = ArrayMethods.calculatePay(units, commissionRate);
        System.out.println("b. Weekly pay: ");
        for(int i = 0; i < units.length; i++)
        {
            System.out.printf(names[i] + ": $%.2f\n", totalPay[i]);
        }
         System.out.println("------------------------------------------");
         
        double[] newCommission = ArrayMethods.setCommision(commissionRate, units);
        System.out.println("c. Revised commission rates: ");
        for(int i = 0; i < units.length; i++)
        {
            System.out.printf(names[i] + ": %.2f\n", newCommission[i]);
        }
         
    }
    
