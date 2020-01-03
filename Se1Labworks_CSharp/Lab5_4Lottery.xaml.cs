public partial class MainWindow : Window
    {
        static Random randomNumber = new Random();  //global random object

        public MainWindow()
        {
            InitializeComponent();
        }

        private void generate_Click(object sender, RoutedEventArgs e)
        {
            txtThree.Text = makeLottery(3, 0, 9);
            txtFour.Text = makeLottery(4,0, 9);
            txtFive.Text = makeLottery(5,1, 39);
            txtFivePlus.Text = makeLottery(5,1, 49);
            txtFivePlus1.Text = makeLottery(1,1, 42);
        }
        public static string randomMake(int lowNum, int highnum)
        {
            string numberString = "";
            int outputNum = 0;
            outputNum = randomNumber.Next(lowNum, (highnum+1));
            numberString = String.Format("{0:00}", outputNum);
            return numberString;
        }

        public static String makeLottery(int digits, int lowNum,  int highNum)
        {
            String output = "";
            for (int i = 0; i < digits; i++)
            {
                output += (randomMake(lowNum,highNum) + "  ");
            }
            return output;
        }
        
    }
