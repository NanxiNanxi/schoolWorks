public static double radiusMethod(double circum)
    { 
        double radius = 0;
        radius = circum/(2*(java.lang.Math.PI));
        return radius;
    }

    public static double volumCyMethod(double heightB,double circum)
    {

        double volumCy = 0;
        double radius = radiusMethod(circum);
        volumCy = (java.lang.Math.PI)*radius*radius*heightB;
        return volumCy;
    }
    public static double volumCoMethod(double heightC,double circum)
    {
       double volumCo = 0;
       double radius = radiusMethod(circum);
       volumCo = ((java.lang.Math.PI)*radius*radius*heightC)/3;
       return volumCo;
    }
    
     public static void main(String[] args)
     {
        System.out.println("Please enter a circumference of the bin(feet): ");
        Scanner input = new Scanner(System.in);
        double circum = input.nextDouble();
        
        System.out.println("Please enter a height of the cones(feet): ");
        Scanner input2 = new Scanner(System.in);
        double heightC = input2.nextDouble();
        
        System.out.println("Please enter a height of the bin(feet): ");
        Scanner input3 = new Scanner(System.in);
        double heightB = input3.nextDouble();
        
        double outputVolum = 0;
        double volum = volumCyMethod(heightB, circum)+
                volumCoMethod( heightC, circum)+volumCoMethod( heightC, circum);
        
        outputVolum = volum * 0.80356395302892;
        
        System.out.println("The volum of this bin is: "+ outputVolum +
                " bushels.");
     }
    
