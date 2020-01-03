 public static void main(String[] args)
    {
        int fine = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter your speed: ");
        int speed = keyboard.nextInt();
        System.out.println("Please enter the speed limit: ");
        int speedLimit = keyboard.nextInt();
        int overSpeed = speed - speedLimit;
       
        if(overSpeed > 0 && overSpeed <= 20)
        {
            fine = 50 + overSpeed*1;
        }
        if(overSpeed > 20 && overSpeed <= 40)
        {
            fine = 70 + (overSpeed-20)*5;
        }
        if(overSpeed > 40 )
        {
            fine = 170 + (overSpeed - 40)*7;
        }
        if(speedLimit == 40)
        {fine = fine *2;}
        else fine = fine;
        if(fine > 250)
        {System.out.println("Warning, dangerous driving!");}
       
        System.out.println("The fine is $" + fine );
    }
    
