 static Scanner keyboard = new Scanner(System.in);
    
    public static int getCrates(int widgets)
    {
        int numberOfCrates = 0;
        numberOfCrates = widgets / 18;
        return numberOfCrates;     
    }
    
    public static double getMoney(int crates)
    {
        double money = 0;
       
        if (crates >10)
        {
            money = crates * 7.5 + (crates-10)*5.5;
        }
        if(crates <= 10)
        {
            money = crates*7.5;
        }
        return money;
    }
    
    public static void main(String[] args)
    {
       
        System.out.println("Please enter how many widgets you have: ");
        int widgets = keyboard.nextInt();
        int crates = getCrates(widgets);
        double money = getMoney(crates);
        int remains = widgets % 18;
        System.out.println("You need to pay $" + money + " for the shipment." + 
                " You have " + remains + " widgets did not get shipped.");
        
    }
