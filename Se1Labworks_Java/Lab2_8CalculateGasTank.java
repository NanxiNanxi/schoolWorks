public static void main(String[] args)
    {
    double miles = 0;
    double gas = 0;
    double average = 0;
    double averageCombine = 0;
    double totalAverage = 0;
    
    int numberOfCounter = 0;
    Scanner counter = new Scanner(System.in);
    System.out.println("Please enter how many tanks you have: ");
    numberOfCounter = counter.nextInt(); 
    
      for(int i = 1; i < numberOfCounter+1; i++)
      { 
        System.out.println("Please enter your kilometers for tank " + i +
                ": ");
        Scanner input = new Scanner(System.in);
        Scanner keyboard = new Scanner(System.in);
        miles = input.nextDouble();
        
        if (miles ==0)
        {System.exit(0);} 
        
        System.out.println("Please enter your liters for tank " + i +": ");
        gas = keyboard.nextDouble();
        
        if (gas ==0)
        {System.exit(0);} 
        
        average = gas *100 / miles;
        System.out.println("The average liters per 100 kilometers for this "
                + "tank is: "  + average );
        totalAverage = totalAverage + average;
        }
       
        averageCombine = totalAverage / numberOfCounter;
        System.out.println("The combined average liters per 100 kilometers "
            + "for the three tanks are: " + averageCombine);
    }    
