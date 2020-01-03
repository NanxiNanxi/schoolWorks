 public static void main(String[] args)
    {
      double scores = 0;
      String name = "";
      String nameMax = "";
      double scoresMax = 0;
      int counter= 0;
     
      while ( !name.equals("-1") )
     
      { Scanner keyboard = new Scanner(System.in);
	System.out.println("please enter a student's name: ");
        name =keyboard.next();
        
        if (!name.equals("-1"))
        { System.out.println("please enter the student's score: ");
        scores = keyboard.nextDouble();
        
        counter++;
        
        if(scores > scoresMax)
        {
         scoresMax = scores;
         nameMax = name;
        }
        }
      }
       System.out.println("the highest score is " + nameMax + "," + scoresMax);
        
    }
