static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Please enter how many students you have: ");
        int total = keyboard.nextInt();
        pick(total);
    }
    public static void pick(int total)
    {
        int bus = 0;
        int van = 0;
      
        while (total >= 64)
         {
             bus++;
             total = total - 64;  
         }
        while (total >= 46 && total < 64)
        {
            bus++;
            total = total -64;       
        }

        while (total >=15 && total < 46) 
        {
            van++;
            total = total -15;
        }
        
       while (total >0 && total < 15)
          {
           van++;
           total = total - total;  
           }
       
            
        System.out.println("You need " + bus + " buses, " + van + " vans.");
    }
