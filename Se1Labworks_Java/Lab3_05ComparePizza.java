 public static double areaCircle(double diameter)
    {
        
        double areaC = (java.lang.Math.PI)* (diameter/2)*(diameter/2);
        return areaC;
    }
    
    public static double areaRectangle(double width, double length)
    { 
        double areaR = width * length;
        return areaR; 
    }
    public static void pizza(double pricePerRo, double pricePerRe)
    {
       double min = pricePerRe;
       if (pricePerRo == pricePerRe){System.out.println("The two pizzas has "
       + "the same value, with the price of "+ pricePerRe +" per inch" );}
       if(pricePerRo < pricePerRe){min = pricePerRo;}
       if(min == pricePerRo){System.out.println("The round Pizza is more "
               + "resonable, with the price of " + pricePerRo + " per inch"+ 
               "\nThe rectangle Pizza is less "
               + "resonable, with the price of " + pricePerRe + " per inch");}
       if(min == pricePerRe){System.out.println("The rectangle Pizza is more "
               + "resonable, with the price of " + pricePerRe + " per inch"+
               "\nThe roud Pizza is less "
               + "resonable, with the price of " + pricePerRo + " per inch");}   
       }
    public static void main(String[] args)
    {
        System.out.println("Please enter a diameter of a round Pizza (inch): ");
        Scanner keyboard = new Scanner(System.in);
        double diameter = keyboard.nextDouble();
        
        System.out.println("Please enter a width of a rectangle Pizza(inch): ");
        Scanner input = new Scanner(System.in);
        double width = input.nextDouble();
        
        System.out.println("Please enter a length of a rectangle Pizza(inch): ");
        Scanner input2 = new Scanner(System.in);
        double length = input2.nextDouble();
        
        System.out.println("Please enter the price of the "
                + "round Pizza(inch): ");
        Scanner input3 = new Scanner (System.in);
        double priceRo = input3.nextDouble();
        
        System.out.println("Please enter the price of the "
                + "round Pizza(inch): ");
        double priceRe = input3.nextDouble();
        
        double areaC = areaCircle(diameter);
        double areaR = areaRectangle(width, length);
        double pricePerRo = priceRo / areaC;
        double pricePerRe = priceRe / areaR;
        pizza(pricePerRo,pricePerRe);
     
    }
    
