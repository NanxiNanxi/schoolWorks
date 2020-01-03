public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            
            decimal loanPrincipal;
            decimal monthPayment;
            decimal annualRate;
          
            decimal interest;
            int month = 0;

            loanPrincipal = Convert.ToDecimal(txtPrincipal.Text);
            monthPayment = Convert.ToDecimal(txtMonthPay.Text);
            annualRate = Convert.ToDecimal(txtAnnualRate.Text);
        

            txtOutput.Text = ("Month        Saved        Interest        Balance \n================================\n" +
                "                                                        " + String.Format("{0:00.00}", loanPrincipal));

           do
            {
                month++;
                interest = loanPrincipal * annualRate / 100 / 12;
                loanPrincipal += interest - monthPayment;

                txtOutput.Text += ("\n"+ String.Format("{0}", month) + "              " + String.Format("{0:00.00 }", monthPayment) + "          "
                    + String.Format("{0:0.00}", interest) + "          " + String.Format("{0:00.00}", loanPrincipal));
            }
            while (loanPrincipal > 0);

            txtNumberOfMonths.Text = String.Format("{0}", month); 
        }
    }
