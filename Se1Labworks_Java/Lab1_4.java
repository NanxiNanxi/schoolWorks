 public static void main(String[] args)
{
    int number;
   
    Scanner keyboard = new Scanner(System.in);
	System.out.println("Please enter a number with five digits: ");
        number = keyboard.nextInt();
        
        System.out.println( number/10000 + "   " + ( number % 10000)/1000 +
                "   " + (number % 1000)/100 + "   " 
                + (number % 100)/10 + "   " + (number % 10) );       
}
