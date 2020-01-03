class Program
    {
        static Random r = new Random();
        static void Main(string[] args)
        {
            Console.WriteLine("Number of dice sizes(between 4 to 20, press 0 to quit): ");
            int numOfDice = Convert.ToInt32(Console.ReadLine());
            int numOfRoll = 0;
            int[] side = new int[numOfDice];
            int[] rollCount = new int[numOfDice];
            
            while (numOfDice != 0)
            {
               
                if (numOfDice < 4 || numOfDice > 20)
                {
                    Console.WriteLine("Please enter a number between 4 to 20!: ");
                    numOfDice = Convert.ToInt32(Console.ReadLine());
                    //resize the length of array side
                    Array.Resize(ref side, numOfDice);
                }
                
                if (numOfDice >= 4 && numOfDice <= 20)
                {
                    Console.WriteLine("Number of rolls: ");
                    numOfRoll = Convert.ToInt32(Console.ReadLine());
                    //resize the length of array rollcount
                    Array.Resize(ref rollCount, numOfDice);
                    for (int i = 0; i < numOfRoll; i++)
                    {
                        rollCount[r.Next(rollCount.Length)]++;
                    }
                    showGraph(side, rollCount,numOfRoll);
                }

                //resize both arrays
                Array.Resize(ref side, 0);
                Array.Resize(ref rollCount, 0);
                //clear out the value of frequency array
                for (int i = 0; i < rollCount.Length; i++)
                {
                    rollCount[i] = 0;
                }
                Console.WriteLine("--------------------------------------");
                Console.WriteLine("Number of dice sizes(between 4 to 20, press 0 to quit): ");
                numOfDice = Convert.ToInt32(Console.ReadLine());
                //resize side to the new length
                Array.Resize(ref side, numOfDice);
            }
        }

        static void showGraph(int[] labels, int[] values, int numOfRoll)
        {

            for (int i = 0; i < labels.Length; i++)
            {

                const int scale = 50;
                double scaleFactor = (double)scale / ((double)numOfRoll / (double)labels.Length);
                //double ScaleFactor = (double)MaxCols / ((double)NumRolls / (double)NumSides);
                labels[i] = i + 1;
                Console.Write("{0:D2}:  ", labels[i]);
                Console.Write(values[i]);
                
                for (var counter = 0; counter < values[i] * scaleFactor; counter++)
                {
                    Console.Write("*");
                }
              
                Console.WriteLine("");
            }
        }
    }
