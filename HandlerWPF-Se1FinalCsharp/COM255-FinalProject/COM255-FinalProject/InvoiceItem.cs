using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace COM255_FinalProject
{
    class InvoiceItem
    {
        public int itemId { get; set; }
        public int invoiceId { get; set; }
        public string itemName { get; set; }
        public string itemDescription { get; set; }
        public decimal itemPrice { get; set; }
        public int itemQuatity { get; set; }
        public decimal itemTotalPrice { get; set; }

        public InvoiceItem()
        {

        }

        
        public override string ToString()
        {
            return this.itemId + "\t\t" + this.itemName + "\t\t" + this.itemDescription + "\t\t" + this.itemPrice.ToString("c") + "\t\t\t" + this.itemQuatity + "\t\t\t" + this.itemTotalPrice.ToString("c");
        }

        //did not use this override meathod, so i comment it out
        //public override bool Equals(object obj)
        //{
        //    if (obj == null) return false;
        //    if (this.invoiceId == ((InvoiceItem)obj).invoiceId) return true;
        //    else return false;
        //}
        public override int GetHashCode()
        {
            return this.invoiceId.GetHashCode();
        }
    }
}
