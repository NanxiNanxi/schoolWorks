﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace COMP235WebSite
{
    public partial class GridviewDemo : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnAddMovie_Click(object sender, EventArgs e)
        {
            sqlMovies.Insert();

        }

        protected void btnAddCategory_Click(object sender, EventArgs e)
        {
            sqlMovieCats.Insert();
        }
    }
}