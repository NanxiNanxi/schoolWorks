 public static void main(String[] args) 
    {
        int[] array = ArrayMethods.getInt(5);
        int min = getMinValue(array);
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + "  ");
        }
        System.out.println("\nThe smallest number is: " + min);
         
    }
    public static int getMinValue(int[] array)
    {
       int min = 0;
       for(int i = 0; i < array.length; i++)
       {
           if(array[min] > array[i])
           {
               array[min] = array[i];
           }
       }
       return array[min];
    }
