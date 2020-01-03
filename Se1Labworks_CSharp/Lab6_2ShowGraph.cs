class Program
    {
        static void Main(string[] args)
        {
            String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
            int[] num = { 10, 15, 25, 5, 3, 30, 11, 8, 12, 35, 20, 7 };
            showGraph(months, num);
            Console.ReadKey();
        }
        static void showGraph(string[] labels, int[] values )
        {
            for (int i = 0; i < labels.Length; i++)
            {
                Console.Write(labels[i] + ": ");
                for(int counter = 0; counter < values[i]; counter++ )
                {
                    Console.Write("*");
                }
                Console.WriteLine("");
            }  
        }
    }
