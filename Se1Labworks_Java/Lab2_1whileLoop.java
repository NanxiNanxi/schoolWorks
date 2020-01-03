 public static void main(String[] args)
 {
  int counter = 0;
  double numberOfEven = 0;
  int input = 0;
  double percent;
  double numberOfCounter = 0;
 
  
  Scanner keyboard = new Scanner(System.in);
  
  while ( input !=-1)
  {
    System.out.print("Enter a number(enter -1 to exit): ");
    input = keyboard.nextInt();
   counter++;
      
   if(input !=-1 && input % 2 == 0)
   { 
    numberOfEven++;
   }
  }
  
  percent = numberOfEven/(counter-1) *100;
  System.out.print(percent + "%");
 }
 
 
