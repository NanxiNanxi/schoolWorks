
    public static void main(String[] args) 
    {
        int[] frequency = new int[4];
        int[] sample1 = {1, 2, 2, 1, 1, 3, 3, 2, 2, 1};
        int[] sample2 = {3, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 2, 3, 3, 2, 2, 2, 3};
        int[] sample3 = {1, 1, 1, 2, 2, 1, 3, 2, 1, 1, 1, 2};
        int[] result = new int[sample1.length + sample2.length + sample3.length];
        
        System.arraycopy(sample1, 0, result, 0, sample1.length);
        System.arraycopy(sample2, 0, result, sample1.length, sample2.length );
        System.arraycopy(sample3, 0, result, sample1.length + sample2.length, sample3.length);
        
        for(int counter = 0; counter < result.length;counter++)
        {
            System.out.print(result[counter] + " ");
        }
        System.out.println("");

        for(int i = 0; i < result.length; i++)
        {
            if(result[i] == 1){frequency[1]++;}
            else if(result[i] == 2){frequency[2]++;}
            else if(result[i] == 3){frequency[3]++;}
        }
        
        double precent1 = (double) frequency[1] / result.length * 100;
        double precent2 = (double) frequency[2] / result.length * 100;
        double precent3 = (double) frequency[3] / result.length * 100;
        
        System.out.println(ArrayMethods.roundNumber(precent1, 2) + "% rated awful.");
        System.out.println(ArrayMethods.roundNumber(precent2, 2) + "% rated OK.");
        System.out.println(ArrayMethods.roundNumber(precent3, 2) + "% rated delicious.");
    }
