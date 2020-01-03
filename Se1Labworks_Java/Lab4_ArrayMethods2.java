public class ArrayMethods 
{
    public static void printDoubleArray(double [] numbers)
    {
        for(int i = 0; i < numbers.length; i++)
        {
            System.out.print(numbers[i] + " ");
        }
    }
    public static void printIntArray(int [] numbers)
    {
        for(int i = 0; i < numbers.length; i++)
        {
            System.out.print(numbers[i] + " ");
        }
    }
    public static double maxValue(double [] numbers)
    {
        double maxValue = 0;
        for(int i = 0; i < numbers.length; i++)
        {
            if(numbers[i] > maxValue)
            {
                maxValue = numbers[i];
            }
        }
        return maxValue;
    }
    
    //1-b
    public static double minValue(double [] numbers)
    {
        int min = 0;
        for(int i = 0; i < numbers.length; i++)
        {
            if(numbers[i] < numbers[min])
            {
                numbers[min] = numbers[i];
            }
        }
        return numbers[min];
    }
    
    //1-c
    public static double average(double [] numbers)
    {
         double sum = 0;
         
         for(int i = 0; i < numbers.length; i++)
        {
            sum += numbers[i];
        }
         double average = sum/numbers.length;
         return average;
    }
    
    //1-d
    public static int belowAverage(double [] numbers)
    {
        double sum = 0;
        int counterOfBelow = 0;
        for(int i = 0; i < numbers.length; i++)
        {
            sum += numbers[i];
        }
        double average = sum/numbers.length;
        
        for(int counter = 0; counter < numbers.length; counter++)
        {
            if(numbers[counter] < average)
            counterOfBelow++;    
        }
        return counterOfBelow;
    }
    //1-e
    public static double sum(double [] numbers)
    {
         double sum = 0;
         for(int i = 0; i < numbers.length; i++)
        {
            sum += numbers[i];
        }
         return sum;
    }
    /** 1-i
 i)	Write a method called reverseSort( ) that accepts an array type double. The method first sorts the array 
 * in ascending order. Then the order of the elements is reversed. The method returns an array type double whose
 * elements are sorted from highest to lowest (in descending order).
 */
    public static void reverseSort(double [] numbers)
    {
        for(int counter = numbers.length-1; counter >= 0; counter--)
        {
            Arrays.sort(numbers);
            System.out.println(numbers[counter] );
        }
    }
    //2
    public static double[] getFinalGrades(int[] mid, int[] fin, int[] ass)
    {
        double[] finalGrade = new double[mid.length];
        for(int i = 0; i < mid.length; i++)
        {
            finalGrade[i] =(double) .15 * ass[i] + .40 * mid[i] + .45*fin[i];
        }
        return finalGrade;
    }
    
    public static int[] getFinalIntGrades(int[] mid, int[] fin, int[] ass)
    {
        double[] finalGrade = new double[mid.length];
        int[] finalIntGrade = new int[mid.length];
        for(int i = 0; i < mid.length; i++)
        {
            finalGrade[i] =(double) .15 * ass[i] + .40 * mid[i] + .45*fin[i];
            finalIntGrade[i] = (int)(finalGrade[i]);
        }
        return finalIntGrade;
        
        
    }
   
    //mathround
     public static double roundNumber(double a, int n)
    {
        double b = a * Math.pow(10, n);
        b = b + .5;
        a = ((int)b)/Math.pow(10, n);
        return a;
    }
    //2-min&max index
     public static int getMinIndex(double[] array)
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
     public static int getMinIndexInt(int[] array)
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
      public static int getMaxIndex(double[] array)
    {
       int max = 0;
       for(int i = 0; i < array.length; i++)
       {
           if(array[max] < array[i])
           {
               max = i;
           }
       }
       return max;
    }
       public static int getMaxIndexInt(int[] array)
    {
       int max = 0;
       for(int i = 0; i < array.length; i++)
       {
           if(array[max] < array[i])
           {
               max = i;
           }
       }
       return max;
    }
      //2
       public static double averageInt(int [] numbers)
    {
         int sum = 0;
         
         for(int i = 0; i < numbers.length; i++)
        {
            sum += numbers[i];
        }
         double average = sum/numbers.length;
         return average;
    }
       //frequency
        public static int findFrequency(double[] array, double value)
    {
        int frequency = 0;
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] >= value)
            {
                frequency++;
            }
        }
        return frequency;
    }
         public static int findIntFrequency(int[] array, double value)
    {
        int frequency = 0;
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] >= value)
            {
                frequency++;
            }
        }
        return frequency;
    }
            
}
