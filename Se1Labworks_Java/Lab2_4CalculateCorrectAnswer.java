  public static void main(String[] args)
    {
        int answer;
        int counter = 0;
        int numberOfRight = 0;
        
        while (counter < 10)
        {
            int number1 = (int)(Math.random()*100);
            int number2 = (int)(Math.random()*100);
            
            Scanner keyboard = new Scanner(System.in);
            System.out.println(number1 + "+" +number2 + "= ");
            answer = keyboard.nextInt();
            counter++;
            
            if(answer == number1 + number2)
            {
                numberOfRight++;
            }
            
        }
        System.out.println("You have " + numberOfRight + " correct answers.");
    }
