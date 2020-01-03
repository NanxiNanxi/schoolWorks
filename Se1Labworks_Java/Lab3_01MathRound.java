  public static double roundNumber( double a)
    {
        double roundedNumber = Math.ceil(a * 100) / 100d;
        return roundedNumber ;
       
    }
    public static void main(String[] args)
    {
     
        Scanner keyboard = new Scanner(System.in);
	      System.out.println("please enter a number with decimals");
        double a = keyboard.nextDouble();
        
        double transfer = roundNumber (a);
        System.out.println(transfer);
    }
