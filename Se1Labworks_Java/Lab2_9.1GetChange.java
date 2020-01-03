 public static void main(String[] args)
    {
        int choose = -1;
        double pay = 0.00;
        double change = 0.00;
        int toonies = 0;
        int loonies = 0;
        int quarters = 0;
        int dimes = 0;
        int nickels =0;
        int pennies =0;
        
         System.out.println("1   Candy Bar     $0.85"
            + "\n2   Mints         $0.65\n3   Gum           $0.75"
            + "\n4   Drink         $1.00"
            + "\n5   Exit Program");
       
       while (choose !=5)
       { 
        System.out.println("please make your choice: ");    
        Scanner input = new Scanner(System.in);
        choose = input.nextInt();
        if(choose ==5){System.exit(0);}
        
        System.out.print("Please enter your payment: ");
        Scanner payment = new Scanner(System.in);
        pay = payment.nextDouble();
        
        if(choose == 1) change = pay - 0.85;
        if(choose == 2) change = pay - 0.65;
        if(choose == 3) change = pay - 0.75;
        if(choose == 4) change = pay - 1.00;
        System.out.print("Your change is: " + String.format("%.2f",change));
        
      // if (change >0.001)
        //{
        while (change >= 2 )
        {  toonies += 1;
           change = change - 2;}
        
       while (change < 2 && change >= 1)
        { loonies +=1;
          change = change -1;}
        
       while (change < 1 && change >= 0.25)
        { quarters +=1;
          change = change - 0.25;}
        
       while (change < 0.25 && change >=0.1)
        { dimes +=1;
          change = change - 0.1;}
        
       while (change < 0.1 && change >= 0.05)
        { nickels += 1;
          change = change - 0.05;}
        
       while (change <0.05 && change >= 0.001)
       { pennies += 1;
         change = change - 0.01;}
       
       if(pennies == 5) {nickels++; pennies = pennies -5;}  
       if(nickels ==2) {dimes++; nickels = nickels -2; }
        
        System.out.println("\nYou will get " + "\n" + toonies + " toonies" + ""
                + "\n"+ loonies +" loonies" + "\n" +quarters + " quarters" 
                        + "\n" +dimes +" dimes" +"\n" + nickels + 
                " nickels" +"\n" + pennies + " pennies");
       
    }
        }
