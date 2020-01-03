 static double r = new Random().nextDouble();
//    double generatorDouble = new Random().nextDouble();
    public static void main(String[] args) 
    {
        double [] randomNumber = populate(20);
        double average = getAverage(randomNumber);
         for(int counter = 0; counter < randomNumber.length; counter++)
        {
            if(randomNumber[counter] > average)
            System.out.printf("%.2f  ", randomNumber[counter] );
        }
         System.out.printf("\nAverage: %.2f",average);
    }
    public static double [] populate(int numberOfNumbers)
    { 
      double[] randomArray = new double[numberOfNumbers];
      for(int i = 0; i < randomArray.length; i++)
      {
          randomArray[i] = new Random().nextDouble()*100.1;
      }
      return randomArray;
       
    }
     
     public static double getAverage(double [] numbers)
     {
        double sum = 0;
        for(int i = 0; i < numbers.length; i++)
        {
            sum = sum + numbers[i];
        }
       double average = sum / numbers.length;
        return average;
     }
