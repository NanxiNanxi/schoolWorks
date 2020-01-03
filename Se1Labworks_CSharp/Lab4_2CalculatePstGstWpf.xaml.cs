public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void button_Click(object sender, RoutedEventArgs e)
        {
            double number1;
            double number2;
            double number3;
            double number4;
            double total;
            double shipping = 0.0;
            double pst1 = 0.0;
            double pst2 = 0.0;
            double pst3 = 0.0;
            double pst4 = 0.0;
            double gst1 = 0.0;
            double gst2 = 0.0;
            double gst3 = 0.0;
            double gst4 = 0.0;
            double pst;
            double gst;
            double totalPlusTax;




            // input string to number, output number to string
            double.TryParse(TextItem1.Text, out number1);
            TextItem1.Text = String.Format("{0}", number1);


            double.TryParse(TextItem2.Text, out number2);
            TextItem2.Text = String.Format("{0}", number2);

            double.TryParse(TextItem3.Text, out number3);
            TextItem3.Text = String.Format("{0}", number3);

            double.TryParse(TextItem4.Text, out number4);
            TextItem4.Text = String.Format("{0}", number4);

            // total value of all the items
            total = number1 + number2 + number3 + number4;
            textSubtitle1.Text = String.Format("{0}", total);

            // shipping fee
            if (radioButtons.IsChecked.Value)
            {
                shipping = total * 0.02;
                textShipping.Text = String.Format("{0}", shipping);

            }

            // calculate PST
            if (checkBoxp1.IsChecked.Value)
            { pst1 = number1 * 0.06; }

            if (checkBoxp2.IsChecked.Value)
            { pst2 = number2 * 0.06; }

            if (checkBoxp3.IsChecked.Value)
            { pst3 = number3 * 0.06; }

            if (checkBoxp4.IsChecked.Value)
            { pst4 = number4 * 0.06; }

            pst = pst1 + pst2 + pst3 + pst4;

            textPST.Text = String.Format("{0}", pst);

            // calculate GST
            if (checkBoxg1.IsChecked.Value)
            { gst1 = number1 * 0.05; }

            if (checkBoxg2.IsChecked.Value)
            { gst2 = number2 * 0.05; }

            if (checkBoxg3.IsChecked.Value)
            { gst3 = number3 * 0.05; }

            if (checkBoxg4.IsChecked.Value)
            { gst4 = number4 * 0.05; }

            gst = gst1 + gst2 + gst3 + gst4;

            textGST.Text = String.Format("{0}", gst);

            totalPlusTax = total + shipping + pst + gst;

            // output total cost


            textTotal.Text = String.Format("{0}", totalPlusTax);

            double commission;
            SolidColorBrush textcolor = new SolidColorBrush();
            

            if (totalPlusTax >= 0 && totalPlusTax <= 100)
            {
                commission = totalPlusTax * .035;
                textBox.Text = String.Format("{0:N2}", commission);
                textBox.Background = Brushes.Black;
                textBox.Foreground = Brushes.White;
            }

            if (totalPlusTax > 100 && totalPlusTax <= 225)
            {
                commission = totalPlusTax * .05;
                textBox.Text = String.Format("{0:N2}", commission);
                textBox.Background = Brushes.Blue;
            }

            if (totalPlusTax > 225 && totalPlusTax <= 500)
            {
                commission = totalPlusTax * .07;
                textBox.Text = String.Format("{0:N2}", commission);
                textBox.Background = Brushes.Green;
            }

            if (totalPlusTax > 500)
            {
                commission = totalPlusTax * 0.11;
                textBox.Text = String.Format("{0:N2}", commission);
                textBox.Background = Brushes.Red;
            }
            
            if(Double.TryParse(textBox.Text, out commission) == false || totalPlusTax ==0)
            {
                MessageBox.Show("Please enter the valid number!");
                
            }

        }

        private void checkBox_Checked(object sender, RoutedEventArgs e)
        {
        
        }

  
    }
