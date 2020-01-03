public partial class MainWindow : Window
    {
        CustomerAccount account = new CustomerAccount();
        static int index = 0;
        
        public MainWindow()
        {
            InitializeComponent();
            showResult(index); 
        }
       
        //next button
        private void next_Click(object sender, RoutedEventArgs e)
        { 
            index++;
            if(index > account.firstName.Length -1)
            {
                index = 0;
            }
            showResult(index);
        }

        // previous button
        private void previos_Click(object sender, RoutedEventArgs e)
        {
            index--;
            if (index < 0)
            {
                index = account.firstName.Length -1;
            }
            showResult(index);
        }

        // add button
        private void addNew_Click(object sender, RoutedEventArgs e)
        {
            txtFirstName.Clear();
            txtLastName.Clear();
            txtAccountNumber.Clear();
            txtBalance.Clear();
            txtFirstName.Focus();
        }

        // save button
        private void save_Click(object sender, RoutedEventArgs e)
        {
            string newFirstName = "";
            string newLastName = "";
            int newAccount = 0;
            double newBalance = 0;

            newFirstName= txtFirstName.Text;
            newLastName = txtLastName.Text;
            int.TryParse(txtAccountNumber.Text, out newAccount);
            double.TryParse(txtBalance.Text, out newBalance);

            // no original data can be saved
            for (int i = 0; i < account.firstName.Length; i++)
            {
                if (newFirstName == account.firstName[i]
                    && newLastName == account.lastName[i]
                    && newAccount == account.accountNumber[i]
                    && newBalance == account.balance[i])
                {
                    txtFirstName.Clear();
                    txtLastName.Clear();
                    txtAccountNumber.Clear();
                    txtBalance.Clear();
                    txtFirstName.Focus();
                }
            }
            
            // require valid data
            if (int.TryParse(txtAccountNumber.Text, out newAccount) == false
               || double.TryParse(txtBalance.Text, out newBalance) == false
               || newFirstName == ""
               || newLastName == "")
            {
                MessageBox.Show("Please enter valid information!");
            }
           
           else
            {
                resizeArray(account.firstName.Length, newFirstName, newLastName, newAccount, newBalance);
                MessageBox.Show("Information saved!");
                showResult(account.firstName.Length-1);
            }

        }
        // print out result
        public void showResult(int indexInMeathod)
        {
            txtFirstName.Text = account.firstName[indexInMeathod];
            txtLastName.Text = account.lastName[indexInMeathod];
            txtAccountNumber.Text = account.accountNumber[indexInMeathod].ToString();
            txtBalance.Text = account.balance[indexInMeathod].ToString();
        }

        //resize & add new value
        public void resizeArray(int length, string newFirstName, string newLastName, int newAccount, double newBalance)
        {
            Array.Resize(ref account.firstName,length + 1);
            Array.Resize(ref account.lastName, length + 1);
            Array.Resize(ref account.accountNumber, length + 1);
            Array.Resize(ref account.balance, length + 1);
            account.firstName[length] = newFirstName;
            account.lastName[length] = newLastName;
            account.accountNumber[length] = newAccount;
            account.balance[length] = newBalance;
        }

        //reset
        private void clear_Click(object sender, RoutedEventArgs e)
        {
            Array.Resize(ref account.firstName, 5);
            Array.Resize(ref account.lastName, 5);
            Array.Resize(ref account.accountNumber, 5);
            Array.Resize(ref account.balance, 5);
            MessageBox.Show("The customer account has back to the initial length!");
            showResult(0);
        }
        
    }
