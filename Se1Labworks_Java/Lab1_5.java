public static void main(String[] args)
    {
        double hight;
        double weight;
        double bmi;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter your hight(inch): ");
        hight = input.nextDouble();
        
        System.out.println("Please enter your weight(pound): ");
        weight = input.nextDouble();
        
        bmi= (weight * 703) / (hight * hight);
        
        if (bmi < 18.5)
        {System.out.println("Your BMI is " + bmi + ", you are underweight." + 
                "\nBMI Values\nUnderweight: less than 18.5"
                + "\nNormal: between 18.5 and 24.9"
                + "\nOverweight: between 25 and 29.9\nObese: 30 or greater");
        }
        
        if (18.5<= bmi && bmi<= 24.9)
        {System.out.println("Your BMI is " + bmi + ", you are normal figure."+ 
                "\nBMI Values\nUnderweight: less than 18.5"
                + "\nNormal: between 18.5 and 24.9"
                + "\nOverweight: between 25 and 29.9\nObese: 30 or greater");
        }
        
        if (25 <= bmi && bmi<= 29.9)
        {System.out.println("Your BMI is " + bmi + ", you are overweight."+ 
                "\nBMI Values\nUnderweight: less than 18.5"
                + "\nNormal: between 18.5 and 24.9"
                + "\nOverweight: between 25 and 29.9\nObese: 30 or greater");
        }
        
        if (bmi > 30)
        {System.out.println("Your BMI is " + bmi + ", you are obese."+ 
                "\nBMI Values\nUnderweight: less than 18.5"
                + "\nNormal: between 18.5 and 24.9"
                + "\nOverweight: between 25 and 29.9\nObese: 30 or greater");
        }
    }
