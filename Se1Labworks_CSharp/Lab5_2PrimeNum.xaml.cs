public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void calculate_Click(object sender, RoutedEventArgs e)
        {
            int low;
            int high;
            int.TryParse(txtLow.Text, out low);
            int.TryParse(txtHigh.Text, out high);
            string outputS = "";

            if (high < low)
            {
                MessageBox.Show("Upper bound cannot be less than lower bound!");
                txtLow.Clear();
                txtHigh.Clear();
                txtLow.Focus();
                return;
            }


            for (int i = low; i <= high; i++)
            {
                if (PrimeMethod(i))
                {
                    outputS += String.Format("{0}\n", i);
                }
            }
            outputBox.Text = outputS;
        }

        static bool PrimeMethod(int A)
        {
            //if (A == 1) return false;
            //if (A == 0) return false;
            //if (A == 2) return true;
            if (A < 2) return false;
            int B = (int)Math.Sqrt(A);

            for (int i = 2; i <= B; i++)
            {
                if (A % i == 0)
                {
                    return false;
                }
            }
            return true;
        }
