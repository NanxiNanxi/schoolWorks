using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace COM255_FinalProject
{
    class Invoice
    {
        public int invoiceId { get; set; }
        public string customerName { get; set; }
        public string email { get; set; }
        public decimal totalPrice { get; set; }
        public string shipped { get; set; }
        public decimal pst { get; set; }
        public decimal gst { get; set; }
        public decimal subtotal { get; set; }
        public DateTime date { get; set; }
        public string adress { get; set; }

        public Invoice()
        {

        }
        public Invoice(int id, string name, string email, decimal price,string shipped)
        {
            this.invoiceId = id;
            this.customerName = name;
            this.email = email;
            this.totalPrice = price;
            this.shipped = shipped;
        }

        public void calculateTotalPrice(decimal subtotal, decimal pst, decimal gst)
        {
            this.totalPrice = subtotal + pst + gst;
        }

        public void yesOrNo(bool shipped)
        {
            if (shipped == true) this.shipped = "yes";
            else this.shipped = "No";
        }
        public override string ToString()
        {
            return this.invoiceId + "\t\t\t" + this.customerName + "\t\t\t" + this.email + "\t\t\t" + this.totalPrice.ToString("c") + "\t\t\t" + shipped;
        }
        //did not use this override meathod, so i comment it out
        //public override bool Equals(object obj)
        //{
        //    if (obj == null) return false;
        //    if (this.invoiceId == ((Invoice)obj).invoiceId) return true;
        //    else return false;
        //}
        public override int GetHashCode()
        {
            return this.invoiceId.GetHashCode();
        }
    }
}
