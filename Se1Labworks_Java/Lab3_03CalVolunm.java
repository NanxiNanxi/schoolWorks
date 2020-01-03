public static double radiusMethod(double circum)
    { 
        double radius = 0;
        radius = circum/(2*(java.lang.Math.PI));
        return radius;
    }

    public static double volumCyMethod(double height,double circum)
    {

        double volumCy = 0;
        double radius = radiusMethod(circum);
        volumCy = (java.lang.Math.PI)*radius*radius*height;
        return volumCy;
    }
    public static double volumCoMethod(double height,double circum)
    {
       double volumCo = 0;
       double radius = radiusMethod(circum);
       volumCo = ((java.lang.Math.PI)*radius*radius*height)/3;
       return volumCo;
    }
    public static void main(String[] args)
    {
        System.out.println("Please enter a circumference: ");
        Scanner keyboard = new Scanner(System.in);
        double circum = keyboard.nextDouble();
        
        System.out.println("Please enter a height: ");
        Scanner input = new Scanner(System.in);
        double height = input.nextDouble();
        
       double radius = radiusMethod(circum);
        
       double volumCy =volumCyMethod(height, circum);
        
       double volumCo =volumCoMethod(height, circum);
        
        System.out.println("The radius is: " + radius +"\nThe volum of this cylinder"
                + " is: " + volumCy + "\nThe volum of this cone is: " + volumCo);
    }
