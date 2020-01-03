
    public static int guessNumber( int a )
    {
        
        a = (int) (Math.random() * 1001);
        return a;
    }
   
    public static void main (String[] args)
    {
        int a= 1;
        a = guessNumber(a);
     
        System.out.println("Let's play a game!"
                + "\nPlease enter a number between 1 to 1000: ");
        Scanner keyboard = new Scanner(System.in);
	
        int input =keyboard.nextInt();
        int counter = 0;
        while (input != a)
        {
        if (input > a)
        {
            System.out.println("Too high.Please try again: ");
            input =keyboard.nextInt();
        }
        else if (input < a)
        {
            System.out.println("Too low.Please try again: ");
            input =keyboard.nextInt(); 
        }
        counter++;
        }
        
        System.out.println("You are correct!\nYou failed " + counter +" times!" );
    }
