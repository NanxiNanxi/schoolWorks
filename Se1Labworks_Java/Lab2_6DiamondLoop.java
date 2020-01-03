public static void main(String[] args)
    {
         for(int row = 1; row < 6; row++)
        {
             for (int line = 6-row; line >= 0; line--)
             {
                 System.out.print(" ");
             }
            
           for (int line = row; line > 0; line--)
           {               
               System.out.print(line);
           }
          
           for (int line = 2; line < row+1 ; line++)
           { 
               System.out.print(line);
           }
         
        
          System.out.println();
           
        }
         
         
        
         for(int row = 1; row < 7; row++)
        {
             for (int line = 7-row; line < 7; line++)
             {
                 System.out.print(" ");}
           for (int line =7 - row; line >0 ; line--)
           { 
               System.out.print(line);
           }
          
           for (int line = 2; line <= 7-row ; line++)
           { 
               System.out.print(line);
           }
          
          System.out.println();
           
        }
}
