static Random t = new Random ();
    public static void main(String[] args)
    {
        int counter = 0;
        int counter2 =0;
         
        System.out.println("Heads(1) or Tails(0)? Please enter your answer"
                + "(press 2 to quit): ");
        Scanner input = new Scanner(System.in);
        int guess = input.nextInt();
        
        while(guess != 2)
        {
            int toss = flip();
            if(guess == toss)
            {
                 counter++; 
                 System.out.println("Bingo! Please try again");
                 guess = input.nextInt();
                
            }
            if(guess !=toss && guess !=2)
            {
                counter2++;
                System.out.println("Sorry! Please try again");
                guess = input.nextInt();
            }
          
        }
          System.out.println("correct "+ counter +" times"); 
          System.out.println("failed "+ counter2 +" times"); 
    }
    
    public static int flip()
    {
        int toss = t.nextInt(2);
        return toss;
    }
