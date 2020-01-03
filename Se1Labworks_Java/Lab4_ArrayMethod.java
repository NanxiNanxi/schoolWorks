public class ArrayMethods 
{
    static Random r = new Random();
     public static int[] getInt(int numberOfNumbers)
    { 
      int[] randomArray = new int [numberOfNumbers];
      for(int i = 0; i < randomArray.length; i++)
      {
          randomArray[i] = r.nextInt(101);
      }
      return randomArray;
       
    }
     
     public static int getAverage(int [] numbers)
     {
        int sum = 0;
        int average = 0;
        for(int i = 0; i < numbers.length; i++)
        {
            sum = sum + numbers[i];
        }
        average = sum / numbers.length;
        return average;
     }
      public static int getMinValue(int[] array)
    {
       int min = 0;
       for(int i = 0; i < array.length; i++)
       {
           if(array[min] > array[i])
           {
               min = i;
           }
       }
       return min;
    }
      public static int getMinIndex(int[] array)
    {
       int min = 0;
       for(int i = 0; i < array.length; i++)
       {
           if(array[min] > array[i])
           {
               min = i;
           }
       }
       return min;
    }
       public static int findHighestScore(int [] numbers)
  {
      int spot = 0;
      for(int i = 0; i< numbers.length; i++)
      {
          if(numbers[i]> numbers[spot])
          {
              spot = i;  
          }
      }
      return spot;
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
      public static double roundNumber(double a, int n)
    {
        double b = a * Math.pow(10, n);
        b = b + .5;
        a = ((int)b)/Math.pow(10, n);
        return a;
    }
     
}
