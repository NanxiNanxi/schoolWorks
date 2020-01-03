using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Data.SqlClient;

namespace COM255_FinalProject
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        string openSesame = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=|DataDirectory|\ShoppingCart.mdf;Integrated Security=True";
        private List<Invoice> invoiceList = new List<Invoice>();
        private List<InvoiceItem> invoiceItemList = new List<InvoiceItem>();
        private List<InvoiceItem> selectedInvoiceItem = new List<InvoiceItem>();
        private Invoice currentInvoice;
        private InvoiceItem currentInvoiceItem;
        private int selectInvoiceIndex;
        private int selectInvoiceItemIndex;

        decimal newPrice;
        DateTime newDate;
        int newQuantity;
        private decimal totalPrice;
        private decimal subtotal;
        private decimal pst;
        private decimal gst;
        private bool isNewInvoice = false;
        private bool isNewInvoiceItem = false;
        private string shipped;


        public MainWindow()
        {
            InitializeComponent();
            invoiceList.Clear();
            loadInvoice();
            displayInvoice();
            displayInvoiceItem();
            isNewInvoice = false;
            Listboxheader.Items.Add("Invoice ID\t\tCustomer\t\tEmail\t\t\t\tTotal Price\t\tShipped");
            ItemHeader.Items.Add("Item ID\t\tItem Name\tItem Description\t\tItem Price\t\tItem Quantity\t\tPrice");
        }

        //Since we need to blank out the textbox for data input, I put all the functions that related to save into my save meathod.
        //This contains two functions, first to save the changes of existing record, second to save a new record. 
        //So my ADD NEW button only like a triger that blank out all the textbox and change boolean IsNewInvoice or IsNewInvoiceItem into true. 
        //click ADD NEW we can blank out textboxes, after inputing data, click SAVE, if the data is valid, information will be saved, 
        //otherwise there will be an error show in the middle part of this program
        private void NewBtn_Click(object sender, RoutedEventArgs e)
        {
            txtInvoice.Clear();
            txtInvoiceDate.Clear();
            txtCustomerName.Clear();
            txtCustomerAdress.Clear();
            txtCustomerEmail.Clear();
            txtInvoice.Focus();
            isNewInvoice = true;
        }
        private void SaveBtn_Click(object sender, RoutedEventArgs e)
        {
            updateInvoice();
            loadInvoice();
        }
        private void DeleteBtn_Click(object sender, RoutedEventArgs e)
        {
            //Sorry, I did not quite get requirement 13)b, I assume that we need no only to clear the listbox of invoice items, 
            //but also to delete all the invoice item records for that invoiceID.
            using (SqlConnection connection = new SqlConnection())
            {
                connection.ConnectionString = openSesame;
                connection.Open();
                
                string sql = $"DELETE From InvoiceItem WHERE InvoiceID = {currentInvoice.invoiceId}";
                ListInvoiceItem.Items.Clear();

                using (SqlCommand myCommand = new SqlCommand(sql, connection))
                {
                    try
                    {
                        myCommand.ExecuteNonQuery();
                    }
                    catch (SqlException ex)
                    {
                        Exception error = new Exception("Error no matching record to delete", ex);
                        throw error;
                    }
                }

                sql = $"DELETE From Invoices WHERE InvoiceID = {currentInvoice.invoiceId}";


                using (SqlCommand myCommand = new SqlCommand(sql, connection))
                {
                    try
                    {
                        myCommand.ExecuteNonQuery();
                    }
                    catch (SqlException ex)
                    {
                        Exception error = new Exception("Error no matching record to delete", ex);
                        throw error;
                    }
                }
            }
            int IndexToDelete = selectInvoiceIndex;

            invoiceList.Remove(currentInvoice);
            ListOfInvoice.Items.Remove(currentInvoice);

            
            if (IndexToDelete == invoiceList.Count)
            {
                selectInvoiceIndex = invoiceList.Count - 1;
            }
            else
            {
                selectInvoiceIndex = IndexToDelete;
            }

            ListOfInvoice.SelectedIndex = selectInvoiceIndex;

        }

        private void NewItemBtn_Click(object sender, RoutedEventArgs e)
        {
            txtID.Clear();
            txtItemName.Clear();
            txtItemDescreption.Clear();
            txtItemPrice.Clear();
            txtItemQuantity.Clear();
            txtItemName.Focus();
            isNewInvoiceItem = true;
        }
        private void SaveItemBtn_Click(object sender, RoutedEventArgs e)
        {
            updateInvoiceItem();
        }
        private void DeleteItemBtn_Click(object sender, RoutedEventArgs e)
        {
            using (SqlConnection connection = new SqlConnection())
            {
                connection.ConnectionString = openSesame;
                connection.Open();
                string sql = $"DELETE From InvoiceItem WHERE ItemID = {currentInvoiceItem.itemId}";


                using (SqlCommand myCommand = new SqlCommand(sql, connection))
                {
                    try
                    {
                        myCommand.ExecuteNonQuery();
                    }
                    catch (SqlException ex)
                    {
                        Exception error = new Exception("Error no matching record to delete", ex);
                        throw error;
                    }
                }
            }
            int IndexToDelete = selectInvoiceIndex;

            invoiceItemList.Remove(currentInvoiceItem);
            ListInvoiceItem.Items.Remove(currentInvoiceItem);


            if (IndexToDelete == invoiceItemList.Count)
            {
                selectInvoiceItemIndex = invoiceItemList.Count - 1;
            }
            else
            {
                selectInvoiceItemIndex = IndexToDelete;
            }

            ListInvoiceItem.SelectedIndex = selectInvoiceItemIndex;
        }


        public void loadInvoice()
        {

            invoiceList.Clear();
            ListOfInvoice.Items.Clear();
            isNewInvoice = false;
            using (SqlConnection connection = new SqlConnection())
            {
                connection.ConnectionString = openSesame;
                connection.Open();

                //I use sql's syntax to create a new column which calculate the total price from item price, qantity, pst and gst.
                string calcilateTotal = "Select i.*, (select sum(itemprice*itemquantity)+(sum(itemprice*itemquantity)*.06)+(sum(itemprice*itemquantity)*.05) from InvoiceItem where InvoiceID = i.InvoiceID)  as total From Invoices i";
                SqlCommand myCommand = new SqlCommand(calcilateTotal, connection);

                using (SqlDataReader readInvoice = myCommand.ExecuteReader())
                {
                    while (readInvoice.Read())
                    {
                        Invoice newInvoice = new Invoice();
                        newInvoice.invoiceId = (int)readInvoice["InvoiceID"];
                        newInvoice.customerName = (string)readInvoice["CustomerName"];
                        newInvoice.email = (string)readInvoice["CustomerEmail"];
                        newInvoice.date = (DateTime)readInvoice["InvoiceDate"];
                        newInvoice.adress = (string)readInvoice["CustomerAdress"];
                        if ((bool)readInvoice["Shipped"] == true) shipped = "Yes";
                        else shipped = "No";
                        newInvoice.shipped = shipped;
                        invoiceList.Add(newInvoice);

                        //when create a new record, in order to avoid the program from blowing up, 
                        //the program will only read total column when it is not null. 
                        if (readInvoice["total"] != DBNull.Value)
                        {
                            newInvoice.totalPrice = (decimal)readInvoice["total"];
                        }

                    }
                }

                string chooseInvoiceItem = "Select * From InvoiceItem";
                SqlCommand myCommandItem = new SqlCommand(chooseInvoiceItem, connection);
                using (SqlDataReader readInvoiceItem = myCommandItem.ExecuteReader())
                {
                    while (readInvoiceItem.Read())
                    {
                        InvoiceItem newInvoiceItem = new InvoiceItem();
                        newInvoiceItem.itemId = (int)readInvoiceItem["ItemID"];
                        newInvoiceItem.invoiceId = (int)readInvoiceItem["InvoiceID"];
                        newInvoiceItem.itemName = (string)readInvoiceItem["ItemName"];
                        newInvoiceItem.itemDescription = (string)readInvoiceItem["ItemDescription"];
                        newInvoiceItem.itemPrice = (decimal)readInvoiceItem["ItemPrice"];
                        newInvoiceItem.itemQuatity = (int)readInvoiceItem["ItemQuantity"];
                        newInvoiceItem.itemTotalPrice = newInvoiceItem.itemPrice * newInvoiceItem.itemQuatity;
                        
                        invoiceItemList.Add(newInvoiceItem);
                    }
                }
                
                for (int i = 0; i < invoiceList.Count; i++)
                {
                    ListOfInvoice.Items.Add(invoiceList[i]);
                }

            }


        }
        public void loadInvoiceItem()
        {
            invoiceItemList.Clear();
            ListInvoiceItem.Items.Clear();
            selectedInvoiceItem.Clear();
            isNewInvoice = false;
            subtotal = 0;
            using (SqlConnection connection = new SqlConnection())
            {
                connection.ConnectionString = openSesame;
                connection.Open();

                string chooseInvoiceItem = "Select * From InvoiceItem";
                SqlCommand myCommandItem = new SqlCommand(chooseInvoiceItem, connection);
                using (SqlDataReader readInvoiceItem = myCommandItem.ExecuteReader())
                {
                    while (readInvoiceItem.Read())
                    {
                        InvoiceItem newInvoiceItem = new InvoiceItem();
                        newInvoiceItem.itemId = (int)readInvoiceItem["ItemID"];
                        newInvoiceItem.invoiceId = (int)readInvoiceItem["InvoiceID"];
                        newInvoiceItem.itemName = (string)readInvoiceItem["ItemName"];
                        newInvoiceItem.itemDescription = (string)readInvoiceItem["ItemDescription"];
                        newInvoiceItem.itemPrice = (decimal)readInvoiceItem["ItemPrice"];
                        newInvoiceItem.itemQuatity = (int)readInvoiceItem["ItemQuantity"];
                        newInvoiceItem.itemTotalPrice = newInvoiceItem.itemPrice * newInvoiceItem.itemQuatity;

                        invoiceItemList.Add(newInvoiceItem);

                    }
                }

                //I create a list for all the invoice items, then when Invoice item table's invoiceID equals to invoice table's,
                //add the objects from this list to a new list which we want to show in invoice item list box. 
                for (int i = 0; i < invoiceItemList.Count; i++)
                {
                    if (invoiceItemList[i].invoiceId == currentInvoice.invoiceId)
                    {
                        selectedInvoiceItem.Add(invoiceItemList[i]);
                        ListInvoiceItem.Items.Add(invoiceItemList[i]);
                    }

                }
                
                //use loop to count the subtotal of all the invoice items for the invoice
                for (int j = 0; j < selectedInvoiceItem.Count; j++)
                {

                    subtotal = subtotal + selectedInvoiceItem[j].itemTotalPrice;
                }

                pst = subtotal * (decimal).06;
                gst = subtotal * (decimal).05;
                txtSubtotal.Text = subtotal.ToString("c");
                txtPST.Text = pst.ToString("c");
                txtGST.Text = gst.ToString("c");

                totalPrice = subtotal + pst + gst;
                txtTotal.Text = totalPrice.ToString("c");
            }
        }

        public void updateInvoice()
        {
            if (isValidInvoiceData() == false) return;
            currentInvoice.date = Convert.ToDateTime(txtInvoiceDate.Text);
            currentInvoice.customerName = txtCustomerName.Text;
            currentInvoice.adress = txtCustomerAdress.Text;
            currentInvoice.email = txtCustomerEmail.Text;
            if (ShippedChckbox.IsChecked == true) currentInvoice.shipped = "Yes";
            else currentInvoice.shipped = "No";

            using (SqlConnection connection = new SqlConnection())
            {
                connection.ConnectionString = openSesame;
                connection.Open();

                if (isNewInvoice == false)
                {
                    string updateSesame = $"UPDATE Invoices SET " +
                                          $"InvoiceDate = '{currentInvoice.date.ToString("yyyy-MM-dd")}'," +
                                          $"Shipped = '{ShippedChckbox.IsChecked}'," +
                                          $"CustomerName = '{currentInvoice.customerName}'," +
                                          $"CustomerAdress = '{currentInvoice.adress}'," +
                                          $"CustomerEmail = '{currentInvoice.email}'" +
                                          $"WHERE InvoiceID = {currentInvoice.invoiceId};";
                    using (SqlCommand UpdateCommand = new SqlCommand(updateSesame, connection))
                    {
                        UpdateCommand.ExecuteNonQuery();
                        connection.Close();
                    }
                    loadInvoice();

                }

                if (isNewInvoice == true)
                {
                    Invoice newInvoice = new Invoice();
                    //calculate the default invoiceid for the new record
                    string findMax = $"SELECT MAX(InvoiceID) FROM Invoices;";
                    using (SqlCommand SelectCommand = new SqlCommand(findMax, connection))
                    {
                        newInvoice.invoiceId = Convert.ToInt32(SelectCommand.ExecuteScalar()) + 1;
                    }

                    newInvoice.date = Convert.ToDateTime(txtInvoiceDate.Text);
                    newInvoice.customerName = txtCustomerName.Text;
                    newInvoice.adress = txtCustomerAdress.Text;
                    newInvoice.email = txtCustomerEmail.Text;
                    if (ShippedChckbox.IsChecked == true) newInvoice.shipped = "Yes";
                    else newInvoice.shipped = "No";
                    string insertSesame = $"INSERT INTO Invoices " +
                                           "(InvoiceID, InvoiceDate, Shipped, CustomerName, CustomerAdress, CustomerEmail)" +
                                           "VALUES " +
                                           $"('{newInvoice.invoiceId}', " +
                                           $"'{newInvoice.date.ToString("yyyy-MM-dd")}'," +
                                           $"'{ShippedChckbox.IsChecked}', " +
                                           $"'{newInvoice.customerName}', " +
                                           $"'{newInvoice.adress}', " +
                                           $"'{newInvoice.email}');";
                    using (SqlCommand InsertCommand = new SqlCommand(insertSesame, connection))
                    {
                        InsertCommand.ExecuteNonQuery();
                    }
                    loadInvoice();
                    int NewIndex = ListOfInvoice.Items.IndexOf(newInvoice);

                    //select the new item
                    ListOfInvoice.SelectedIndex = NewIndex;
                    ListOfInvoice.ScrollIntoView(newInvoice);

                    isNewInvoice = false;
                }

            }
        }
        public void updateInvoiceItem()
        {
            //check whether data is valid, if it's not, will not go the following codes
            if (isValidInvoiceItemData() == false) return;
            using (SqlConnection connection = new SqlConnection())
            {
                connection.ConnectionString = openSesame;
                connection.Open();

                if (isNewInvoiceItem == false)
                {
                    currentInvoiceItem.itemName = txtItemName.Text;
                    currentInvoiceItem.itemDescription = txtItemDescreption.Text;
                    currentInvoiceItem.itemPrice = Convert.ToDecimal(txtItemPrice.Text);
                    currentInvoiceItem.itemQuatity = Convert.ToInt32(txtItemQuantity.Text);
                    string updateSesame = $"UPDATE InvoiceItem SET " +
                                          $"InvoiceID = '{currentInvoice.invoiceId}'," +
                                          $"ItemName = '{currentInvoiceItem.itemName}'," +
                                          $"ItemDescription = '{currentInvoiceItem.itemDescription}'," +
                                          $"ItemPrice = '{currentInvoiceItem.itemPrice}'" +
                                          $"WHERE ItemID = {currentInvoiceItem.itemId};";
                    using (SqlCommand UpdateCommand = new SqlCommand(updateSesame, connection))
                    {
                        UpdateCommand.ExecuteNonQuery();
                        connection.Close();
                    }
                    loadInvoiceItem();
                    loadInvoice();

                }

                if (isNewInvoiceItem == true)
                {
                    InvoiceItem newInvoiceItem = new InvoiceItem();

                    //calculate the default itemID for the new record
                    string findMax = $"SELECT MAX(ItemID) FROM InvoiceItem;";
                    using (SqlCommand SelectCommand = new SqlCommand(findMax, connection))
                    {
                        newInvoiceItem.itemId = Convert.ToInt32(SelectCommand.ExecuteScalar()) + 1;
                    }

                    newInvoiceItem.itemName = txtItemName.Text;
                    newInvoiceItem.itemDescription = txtItemDescreption.Text;
                    newInvoiceItem.itemPrice = Convert.ToDecimal(txtItemPrice.Text);
                    newInvoiceItem.itemQuatity = Convert.ToInt32(txtItemQuantity.Text);
                    newInvoiceItem.invoiceId = currentInvoice.invoiceId;

                    string insertSesame = $"INSERT INTO InvoiceItem " +
                                           "(ItemID, InvoiceID, ItemName, ItemDescription, ItemPrice, ItemQuantity)" +
                                           "VALUES " +
                                           $"('{newInvoiceItem.itemId}', " +
                                           $"'{newInvoiceItem.invoiceId}'," +
                                           $"'{newInvoiceItem.itemName}'," +
                                           $"'{newInvoiceItem.itemDescription}', " +
                                           $"'{newInvoiceItem.itemPrice}', " +
                                           $"'{newInvoiceItem.itemQuatity}');";
                    using (SqlCommand InsertCommand = new SqlCommand(insertSesame, connection))
                    {
                        InsertCommand.ExecuteNonQuery();
                    }
                    loadInvoiceItem();
                    loadInvoice();
                    isNewInvoiceItem = false;


                }

            }
        }

        private void ListOfInvoice_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            // Add check for null to prevent the program from blowing up
            if (ListOfInvoice.SelectedItem != null)
            {
                invoiceList.Clear();
                currentInvoice = (Invoice)ListOfInvoice.SelectedItem;
                selectInvoiceIndex = ListOfInvoice.SelectedIndex;
                displayInvoice();
                loadInvoiceItem();
            }


        }
        private void ListInvoiceItem_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

            currentInvoiceItem = (InvoiceItem)ListInvoiceItem.SelectedItem;
            selectInvoiceItemIndex = ListInvoiceItem.SelectedIndex;

            displayInvoiceItem();

            //add check for null again
            if (ListInvoiceItem.SelectedItem != null)
            {
                invoiceItemList.Clear();
                currentInvoiceItem = (InvoiceItem)ListInvoiceItem.SelectedItem;
                selectInvoiceItemIndex = ListInvoiceItem.SelectedIndex;
                displayInvoiceItem();
            }
        }
        public void displayInvoice()
        {
            if (currentInvoice != null)
            {
                subtotal = 0;
                txtInvoice.Text = currentInvoice.invoiceId.ToString();
                txtInvoiceDate.Text = currentInvoice.date.ToString();
                txtCustomerAdress.Text = currentInvoice.adress;
                txtCustomerName.Text = currentInvoice.customerName;
                txtCustomerEmail.Text = currentInvoice.email;
                if (currentInvoice.shipped == "Yes") ShippedChckbox.IsChecked = true;
                else ShippedChckbox.IsChecked = false;
            }
            else
            {
                txtID.Text = "";
                txtInvoiceDate.Text = "";
                txtCustomerAdress.Text = "";
                txtCustomerName.Text = "";
                txtCustomerEmail.Text = "";
                ShippedChckbox.IsChecked = false;
            }
        }
        public void displayInvoiceItem()
        {
            if (currentInvoiceItem != null)
            {
                txtID.Text = currentInvoiceItem.itemId.ToString();
                txtItemName.Text = currentInvoiceItem.itemName;
                txtItemDescreption.Text = currentInvoiceItem.itemDescription;
                txtItemPrice.Text = (Math.Round(currentInvoiceItem.itemPrice, 2)).ToString();
                txtItemQuantity.Text = currentInvoiceItem.itemQuatity.ToString();
            }
            else
            {
                txtID.Text = "";
                txtItemName.Text = "";
                txtItemDescreption.Text = "";
                txtItemPrice.Text = "";
                txtItemQuantity.Text = "";
            }

        }

        //I put the infroming label in the middle instead of bottom, because this program is too long in length 
        //when it is shown on the screen, sometimes it's possible that we can't see the bottom.

        public bool isValidInvoiceData()
        {
            if (DateTime.TryParse(txtInvoiceDate.Text, out newDate) == false
                         || txtCustomerEmail.Text == ""
                         || txtCustomerName.Text == "")
            {
                errorLabel.Content = "Please enther valid data!";
                return false;
            }
            else
            {
                errorLabel.Content = "";
                return true;
            }
        }
        public bool isValidInvoiceItemData()
        {
            if (decimal.TryParse(txtItemPrice.Text, out newPrice) == false
                       || Int32.TryParse(txtItemQuantity.Text, out newQuantity) == false
                       || txtItemName.Text == "")
            {
                errorLabel.Content = "Please enther valid data!";
                return false;
            }
            if (newPrice <= 0 || newQuantity <= 0) return false;

            else
            {
                errorLabel.Content = "";
                return true;
            }
        }
    }
}

