using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace COMP235WebSite
{
    public partial class GuestBookPage : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Request.QueryString["id"] != null)
            {
                SqlGuestBook.Delete();
            }
        }

        protected void btnSave_Click(object sender, EventArgs e)
        {
            //SqlGuestBook.InsertParameters["Poster"].DefaultValue = txtPoster.Text;
            //SqlGuestBook.InsertParameters["Message"].DefaultValue = txtMessage.Text;
            SqlGuestBook.InsertParameters["Date"].DefaultValue = DateTime.Now.ToString("yyyy/MM/dd");

            SqlGuestBook.Insert();

            txtMessage.Text = "";
            txtPoster.Text = "";


        }
    }
}