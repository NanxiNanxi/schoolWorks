 public static void main(String[] args)
    {
        int inputNumber = 0;
        int fail = 0;
        int pass = 0;
        
        for(int i = 1; i < 11; i++)
        {
             
             //do loop
            do{
                System.out.println("Please enter score" + i +": ");
                Scanner input = new Scanner(System.in);
                inputNumber = input.nextInt();
                if(inputNumber < 0 || inputNumber > 100)
                {System.out.println("This is not a valid number");}
              }
                while(inputNumber < 0 || inputNumber > 100);
        
            if (inputNumber >= 60)
              { pass++;}
            if(inputNumber < 60)
              {fail++;}
            }
       
        
        System.out.println(pass + " students passed the exam." + "\n" 
                + fail + " students failed the exam.");
     }
