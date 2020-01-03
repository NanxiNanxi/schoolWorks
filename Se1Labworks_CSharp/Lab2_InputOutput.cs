
    class Program
    {
        static void Main(string[] args)
        {
            String Name;
            int StudentNumber;
            String Email;

            Console.Write("Please enter your name: ");
            Name = (Console.ReadLine());

            Console.Write("Please enter your student number: ");
            StudentNumber =int.Parse(Console.ReadLine());

            Console.Write("Please enter your Email: ");
            Email = (Console.ReadLine());

            Console.WriteLine($"Your contact data is \nName: {Name} \nStudent Number: {StudentNumber} \nEmail: {Email}");

            Console.ReadKey();
        }
    }
