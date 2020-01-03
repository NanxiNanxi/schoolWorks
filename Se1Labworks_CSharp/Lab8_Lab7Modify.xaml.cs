 class CustomerAccount
    {
        public string[] firstName = { "one", "two", "three", "four", "five" };
        public string[] lastName = { "Ak", "Bg", "Cd", "Df", "Eg" };
        public int[] accountNumber = { 56897, 45678, 54231, 78854, 63411 };
        public double[] balance = { 5687.5, 879.44, 9986.45, 4475.4, 99.99 };
        //public string[] firstName = new string[2];
        //public string[] lastName = new string[2];
        //public int[] accountNumber = new int[2];
        //public double[] balance = new double[2];
        //public string FirstName0
        //{
        //    get { return firstName[0]; }
        //    set { firstName[0] = "One"; }
        //}
        //public string FirstName1
        //{
        //    get { return firstName[1]; }
        //    set { firstName[1] = "Two"; }
        //}
        //public string LastName0
        //{
        //    get { return lastName[0]; }
        //    set { lastName[0] = "Oneer"; }
        //}
        //public string LastName1
        //{
        //    get { return lastName[1]; }
        //    set { lastName[1] = "Twoer"; }
        //}
        //public int AccountNumber0
        //{
        //    get { return accountNumber[0]; }
        //    set { accountNumber[0] = 56897; }
        //}

        //public int AccountNumber1
        //{
        //    get { return accountNumber[1]; }
        //    set { accountNumber[1] = 45678; }
        //}

        //public double balance0
        //{
        //    get { return balance[0]; }
        //    set { balance[0] = 5687.5; }
        //}

        //public double balance1
        //{
        //    get { return balance[1]; }
        //    set { balance[1] = 879.44; }
        //}
    }
     public partial class MainWindow : Window
    {
        static customerAccount[] acc;// = new customerAccount[2];
        static int CurrentIndex = 0;
        static string newFirstName = "";
        static string newLastName = "";
        static int newAccount = 0;
        static double newBalance = 0;
        static bool isNew = false;

        public MainWindow()
        {
            InitializeComponent();


            acc = new customerAccount[] { new customerAccount("One", "Oner", 45678, 69867.9),
                                          new customerAccount("Two", "Twoer", 54786, 7897.88)  };

            //acc[index] = new customerAccount("One", "Oner", 45678, 69867.9);
            //acc[index + 1] = new customerAccount("Two", "Twoer", 54786, 7897.88);
            showResult(CurrentIndex);
            // save button is hidden by default
            this.save.IsEnabled = false;
        }
        //show result meathod
        public void showResult(int indexInMethod)
        {
            txtFirstName.Text = acc[indexInMethod].FirstName;
            txtLastName.Text = acc[indexInMethod].LastName;
            txtAccountNumber.Text = acc[indexInMethod].AccountNumber.ToString();
            txtBalance.Text = acc[indexInMethod].Balance.ToString();
        }

        // next button
        private void next_Click(object sender, RoutedEventArgs e)
        {
            if (saveMethod(CurrentIndex) == false) return; 

            CurrentIndex++;
            if (CurrentIndex > acc.Length - 1)
            {
                CurrentIndex = 0;
            }
            showResult(CurrentIndex);
            saveMethod(CurrentIndex);
            this.save.IsEnabled = false;
            isNew = false;
        }

        // previous button
        private void previos_Click(object sender, RoutedEventArgs e)
        {
            if (saveMethod(CurrentIndex) == false) return;

            CurrentIndex--;
            if (CurrentIndex < 0)
            {
                CurrentIndex = acc.Length - 1;
            }
            showResult(CurrentIndex);

            this.save.IsEnabled = false;
            isNew = false;
        }

        // enable save button & resize array & create new acc
        private void addNew_Click(object sender, RoutedEventArgs e)
        {
            txtFirstName.Clear();
            txtLastName.Clear();
            txtAccountNumber.Clear();
            txtBalance.Clear();
            txtFirstName.Focus();
            this.save.IsEnabled = true;
            isNew = true;
        }

        public bool saveMethod(int index)
        {
            newFirstName = txtFirstName.Text;
            newLastName = txtLastName.Text;
            int.TryParse(txtAccountNumber.Text, out newAccount);
            double.TryParse(txtBalance.Text, out newBalance);

            if (int.TryParse(txtAccountNumber.Text, out newAccount) == false
                  || double.TryParse(txtBalance.Text, out newBalance) == false
                  || txtFirstName.Text == ""
                  || txtLastName.Text == "")
            {
                MessageBox.Show("Please enter valid information!");

                return false; // can't save, no record saved
            }


            if (isNew == false)
            {
                acc[index].FirstName = txtFirstName.Text;
                acc[index].LastName = txtLastName.Text;
                acc[index].AccountNumber = newAccount;
                acc[index].Balance = newBalance;
            }
            else
            {

                resizeArray();
                newAccInformation(newFirstName, newLastName, newAccount, newBalance);
                MessageBox.Show("Information saved!");
                showResult(CurrentIndex);
                save.IsEnabled = false;
                isNew = false;
            }
            return true; //rescord saved
        }
  


    // save button
    private void save_Click(object sender, RoutedEventArgs e)
    {

            // call savemethod here
            saveMethod(CurrentIndex);

        //newFirstName = txtFirstName.Text;
        //newLastName = txtLastName.Text;
        //int.TryParse(txtAccountNumber.Text, out newAccount);
        //double.TryParse(txtBalance.Text, out newBalance);

        //if (int.TryParse(txtAccountNumber.Text, out newAccount) == false
        //      || double.TryParse(txtBalance.Text, out newBalance) == false
        //      || newFirstName == ""
        //      || newLastName == "")
        //{
        //    MessageBox.Show("Please enter valid information!");
        //}

        //else
        //{
        //    resizeArray();
        //    newAccInformation(newFirstName, newLastName, newAccount, newBalance);
        //    MessageBox.Show("Information saved!");
        //    showResult(CurrentIndex);
        //    save.IsEnabled = false;
        //}
    }

    public void resizeArray()
    {
        Array.Resize(ref acc, acc.Length + 1);
        CurrentIndex = acc.Length - 1;
        acc[CurrentIndex] = new customerAccount();
    }

    public void newAccInformation(string newFirstName, string newLastName, int newAccount, double newBalance)
    {
        acc[acc.Length - 1].FirstName = newFirstName;
        acc[acc.Length - 1].LastName = newLastName;
        acc[acc.Length - 1].AccountNumber = newAccount;
        acc[acc.Length - 1].Balance = newBalance;
    }
}
