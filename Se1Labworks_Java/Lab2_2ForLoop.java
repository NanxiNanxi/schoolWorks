 public static void main(String[] args)
 {
  
  double numberOfEven = 0;
  int input;
  double percent;
Scanner keyboard = new Scanner(System.in);
  
  for ( int counter = 0;  counter < 5; counter++)
  {
    System.out.print("Enter a number: ");
    input = keyboard.nextInt();
   counter++;
      
   if(counter % 2 == 0)
   { 
    numberOfEven++;
   }
  }
  
  percent = numberOfEven/5 *100;
  System.out.print(percent + "%");
 }
 
 
