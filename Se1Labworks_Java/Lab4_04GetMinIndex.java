 public static void main(String[] args) 
    {
        int[] array = ArrayMethods.getInt(5);
        int min = getMinIndex(array);
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + "  ");
        }
        System.out.println("\nThe smallest number is: " + array[min] + "\nThe smallest index is " + min);
         
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
