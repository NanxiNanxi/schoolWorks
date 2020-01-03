 public static void main(String[] args)
    {
      
        int iLeft = -1;
        double iRight = 0;
      
        System.out.println("Kilograms            Pounds" );
        
        for(int i = 0; i < 100; i++)
        {   iLeft = iLeft +2;
            iRight = iLeft * 2.2;
            
            //Decimal iRight
             System.out.println( "\n"+iLeft 
                + "                     " + String.format("%.1f", iRight));
             
           
        }
       
        
    }
