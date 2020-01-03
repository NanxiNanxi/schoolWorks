using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace COMP235WebSite
{
    public partial class FlagQuiz : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void radFlags_SelectedIndexChanged(object sender, EventArgs e)
        {
            imgFlag.ImageUrl = 
                "~/images/flags/"+radFlags.SelectedValue + ".png";
        
        }
    }
}