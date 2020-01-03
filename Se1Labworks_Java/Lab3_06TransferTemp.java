 public static double celMethod(double fahren)
    {
        double celsius = 0;
        celsius = 5.0 / 9.0 * (fahren - 32);
        return celsius;
    }
    
    public static double fehrenMethod(double cel)
    {
        double fahrenheit = 0;
        fahrenheit = 9.0 / 5.0 * cel + 32;
        return fahrenheit;
    }
    public static void main(String[] args) 
    {
      System.out.println("Please enter a fahrenheit temperature: ");
      Scanner input = new Scanner(System.in);
      double fahren = input.nextDouble();
      double celsius = celMethod(fahren);
      
      System.out.println("Please enter a celsius temperature: ");
      Scanner input2 = new Scanner(System.in);
      double cel = input2.nextDouble();
      double farenheit = fehrenMethod(cel);
      
      System.out.println(fahren + "fahrenheit = " + celsius + " celsius\n" + cel + 
              " celsius = " + farenheit + " farenheit");
    }
