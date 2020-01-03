 public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an integer number: ");
        int num = input.nextInt();
        reverse(num);
    }
    public static void reverse(int num)
    {
         int i =0;
         while (num !=0)
        {
            int digit1 = num / 10;
            int digit2 = num % 10;
            num = digit1;
            i = i++;
            System.out.print(digit2);
        }     
    }
