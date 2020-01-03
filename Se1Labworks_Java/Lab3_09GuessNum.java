 static Random r = new Random();
    static Scanner keyborad = new Scanner(System.in);
     
    public static void main(String[] args)
    {
        int luckyNumber; 
        int guess;
        int keepGoing = 1;
        
      while(keepGoing ==1)
       {
            guess = numberGet();
            luckyNumber = r.nextInt(1000)+1;
       
         while(guess != luckyNumber)
         {
            if (guess > luckyNumber)
            {
                System.out.print("Too high.Please try again! ");
                guess = numberGet();
            }
            if (guess < luckyNumber)
            {
                System.out.print("Too low.Please try again! ");
                guess = numberGet();
            }
          }
         
         if (guess == luckyNumber)
            {
                System.out.println("Congratulations, you guessed the number! ");
                System.out.println("Press 1 to continue, "
                        + "Press any other number to quit: ");
                keepGoing = keyborad.nextInt();
            }
       }
    }
     
    public static int numberGet()
    {
        int validNumber =0;
        System.out.print("Please guess a number(1--1000): \n");
        int guess = keyborad.nextInt();
        while (guess < 1 || guess > 1000)
        {
            System.out.println("Please enter avalid number!");
            guess = keyborad.nextInt();
        } 
        if (guess >= 1 && guess <=1000)
        {
            validNumber = guess;
        }
        return validNumber;
    }
