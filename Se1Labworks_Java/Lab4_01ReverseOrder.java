 public static void main(String[] args) 
    {
        int[] randomNum = ArrayMethods.getInt(10);
        for(int i = 0; i < randomNum.length; i++)
        {
            System.out.print(randomNum[i] + " ");
        }
        System.out.println("");
        for(int counter = randomNum.length-1; counter >= 0; counter--)
        {
            System.out.print(randomNum[counter] + " ");
        }
    }
