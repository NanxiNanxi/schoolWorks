  public static void main(String[] args) 
    {
        double[] container = new double[3];
        double[] closingPrice = {25.0, 38.25, 39.50, 38.75, 37.33, 37.22, 29.56, 31.05, 30.77, 38.25};
        double max = ArrayMethods.maxValue(closingPrice);
        double min = ArrayMethods.minValue(closingPrice);
        double average = ArrayMethods.average(closingPrice);
        int belowrAverage = ArrayMethods.belowAverage(closingPrice);
        double totalCost = ArrayMethods.sum(closingPrice);
        container[0] = max;
        container[1] = min;
        container[2] = average;
        
        System.out.println("a) The highest price is: " + max);
        System.out.println("b) The lowest price is: " + min);
        System.out.printf("c) The average price is: %.2f", average);
        System.out.printf("\nd) There are " + belowrAverage +" days below average price.");
        System.out.printf("\ne} The total cost is: %.2f", totalCost);
        System.out.print("\nh) The new array is ");
        ArrayMethods.printDoubleArray(container);
        System.out.print("\nk) The descending array is: \n");
        ArrayMethods.reverseSort(closingPrice);
        
    }
