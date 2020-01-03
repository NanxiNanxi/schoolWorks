class Program
    {
        static void Main(string[] args)
        {
            float Number1;
            float Number2;
            float Number3;
            float Total;
            float Product;

            Console.Write("Please enter number 1: ");
            Number1 = float.Parse(Console.ReadLine());

            Console.Write("Please enter number 2: ");
            Number2 = float.Parse(Console.ReadLine());

            Console.Write("Please enter number 3: ");
            Number3 = float.Parse(Console.ReadLine());

            Total = Number1 + Number2 + Number3;
            Product = Number1 * Number2 * Number3;

            Console.WriteLine($"\n{Number1} + {Number2} + {Number3}= {Total} \n{Number1} * {Number2} *{Number3} = {Product}");

            Console.ReadKey();
        }
    }
