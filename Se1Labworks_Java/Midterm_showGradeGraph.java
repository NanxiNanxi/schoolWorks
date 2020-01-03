static Scanner keyborad = new Scanner(System.in);
    public static void main(String[] args) 
    {
        
        int numOfValidGrade = 0;
        int grade = 0;
        int totalMarks = 0;
        int numF = 0;
        int numD = 0;
        int numC = 0;
        int numB = 0;
        int numA = 0;
        int charTransfer = 0;
        numOfValidGrade = getValidInput(1, 30, "You must enter a number between 1 and 30, please re-enter:", "students");
        

        for(int i = 0; i < numOfValidGrade; i++)
        {
            grade = getValidInput(0, 100, "You must enter a number between 0 and 100, please re-enter:", "grade");
            totalMarks = getValidInput(0, 100, "You must enter a number between 0 and 100, please re-enter:", "total mark");
            charTransfer =(int)calculateLetterGrade(grade, totalMarks);
 
            if(charTransfer == 70)
            {numF++;}
            if(charTransfer == 68)
            {numD++;}
            if(charTransfer == 67)
            {numC++;}
            if(charTransfer == 66)
            {numB++;}
            if(charTransfer == 65)
            {numA++;}
        }
        showGradeDistribution(numF, numD, numC, numB, numA);
    }
    public static int getValidInput(int low, int high, String message, String topic)
   {
       int returnNum = 0;
       System.out.println("Please enter a " + topic +" number between " + low +" and " + high +": ");
       int num = keyborad.nextInt();
       
       while(num < low || num > high)
       {
         System.out.println(message);
         num = keyborad.nextInt();
       }
       
       if(num >= low && num <= high)
       {
           returnNum = num;
       }
       if(low > high)
       {
           returnNum = -1;
       }
       return returnNum;
   }
    
   public static char calculateLetterGrade( int grade, int totalMarks)
    {
       double percent = 0;
       char returnChar = 0;
       percent =(double)grade / totalMarks * 100;
       if(percent >=0 && percent < 50)
       {
           returnChar = (char)70;
       }
       if(percent >=50 && percent < 60)
       {
           returnChar = (char)68;
       }
       if(percent >=60 && percent < 70)
       {
           returnChar = (char)67;
       }
        if(percent >=70 && percent < 80)
       {
           returnChar = (char)66;
       }
         if(percent >=80 && percent < 100)
       {
           returnChar = (char)65;
       }
         return returnChar;
    }
    
    public static void showGradeDistribution(int f, int d, int c, int b, int a)
    {
       
            System.out.print("A: ");
            for(int ia = 0; ia < a; ia++)
            {
                System.out.print("*");
            }
            
            System.out.println("");
            System.out.print("B: ");
            for(int ib = 0; ib < b; ib++)
            {
                System.out.print("*");
            }
            
            System.out.println("");
            System.out.print("C: ");
             for(int ic = 0; ic < c; ic++)
            {
                System.out.print("*");
            }
             
             System.out.println("");
             System.out.print("D: ");
             for(int id = 0; id < d; id++)
            {
                System.out.print("*");
            }
             
             System.out.println("");
             System.out.print("F: ");
             for(int i1 = 0; i1 < f; i1++)
            {
                System.out.print("*");
            }
        
    }
