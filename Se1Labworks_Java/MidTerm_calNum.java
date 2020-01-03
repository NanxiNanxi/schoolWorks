public static void main(String[] args) 
    {
        Scanner keyborad = new Scanner(System.in);
        
        int input =0;
        int highNum = input;
        int lowNum = input;
        int numberOfEven = 0;
        int total = 0;
        int average = 0;
        
       for(int i = 0; i < 3; i++)
       {
            System.out.println("Please input an interger： ");
            input = keyborad.nextInt();
            if(input % 2 ==0)
            {numberOfEven++;}    
            total = total + input;       
            average = total /3;  
            
            if(i==1)
            {
                highNum =input;
                lowNum = input;
            }
            
            if(highNum < input)
            {
                highNum = input;
            }
             if(input < lowNum )
            {
                lowNum = input;

            }
       }
        
        System.out.println("The highest number is: " + highNum +". \nThe lowest number is: "
        + lowNum + ". \nThere are " + numberOfEven + " even numbers. \nThe average is: " 
                + average);
    }
    
