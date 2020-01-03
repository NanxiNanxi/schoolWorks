 public static void main(String[] args)
    {
        int choose = -1;
        int i = 0;
        double pay = 0;
        double change = 0;
        int toonies = 0;
        int loonies = 0;
        int quarters = 0;
        int dimes = 0;
        int nickels =0;
        int pennies = 0;
        
         System.out.println("1   Candy Bar     $0.85"
            + "\n2   Mints         $0.65\n3   Gum           $0.75"
            + "\n4   Drink         $1.00"
            + "\n5   Exit Program");
        System.out.println("please make your choice: ");    
        Scanner input = new Scanner(System.in);
        choose = input.nextInt();
       while (choose !=5)
        { 
            System.out.print("Please enter your payment: ");
            Scanner payment = new Scanner(System.in);
            pay = payment.nextDouble();
        
        if(choose == 1) change = pay - 0.85;
        if(choose == 2) change = pay - 0.65;
        if(choose == 3) change = pay - 0.75;
        if(choose == 4) change = pay - 1.00;
        System.out.print("Your change is: " + String.format("%.2f",change));
        
        if(change >= 0.001 )
        { 
          toonies = (int) (change / 2);
          loonies = (int) (change % 2);
          quarters = (int)((change % 1)/0.25);
          //double n =((change % 0.25)/0.1);
          dimes = (int)((change % 1)%0.25/0.1);
          nickels = (int)((change % 1)%0.25%0.1/0.05);
          pennies = (int) (Math.round(change % 1%0.25%0.1%0.05/0.01));
         // fix math round
          if(pennies == 5) {nickels++; pennies = pennies -5;}  
          if(nickels ==2) {dimes++; nickels = nickels -2; }
          
         }
        System.out.println("\nYou will get " + "\n" + toonies + " toonies" + ""
                + "\n"+ loonies +" loonies" + "\n" +quarters + " quarters" 
                        + "\n" +dimes +" dimes" +"\n" + nickels + 
                " nickels" +"\n" + pennies + " pennies");
        
         System.out.println("please make your choice: "); 
         choose = input.nextInt();
         
        }
    }
