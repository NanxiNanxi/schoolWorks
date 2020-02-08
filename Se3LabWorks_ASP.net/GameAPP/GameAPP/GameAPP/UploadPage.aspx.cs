using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace GameAPP
{
    public partial class UploadPage : System.Web.UI.Page
    {

        public static List<String> fileNames = new List<string>();

        protected void Page_Load(object sender, EventArgs e)
        {
            
        }

        protected void btnInsert_Click(object sender, EventArgs e)
        {
            MediaUtilities mu = new MediaUtilities();
            Game g = new Game();
            g.Title = txtTitle.Text;
            g.TagLine = txtTag.Text;
            g.Description = txtDescription.Text;
            g.Year = txtYear.Text;

            int key = mu.insertGame(g);
            int gameId = mu.getGameIdByGameName(g.Title);
            if(fileNames.Count != 0)
            {
                foreach(String name in fileNames){
                    mu.insertImage(new Media(gameId, name));
                }
                fileNames.Clear();
            }
            txtTitle.Text = "";
            txtTag.Text = "";
            txtDescription.Text = "";
            txtYear.Text = "";
            DataList1.DataBind();
        }

        protected void btnUpload_Click(object sender, EventArgs e)
        {
            string filePath = "~/UploadedImages/" + gameImageUpload.FileName;

            if (CheckFileType(filePath))
            {
                gameImageUpload.SaveAs(MapPath(filePath));
            }
            fileNames.Add(gameImageUpload.FileName);
            
        }
        private bool CheckFileType(string fileName)
        {
            string ext = Path.GetExtension(fileName);
            switch (ext.ToLower())
            {
                case ".gif":
                    return true;
                case ".png":
                    return true;
                case ".jpg":
                    return true;
                case ".jpeg":
                    return true;
                case ".mp4":
                    return true;
                default:
                    return false;

            }
        }

        protected void TitleLink_Click(object sender, EventArgs e)
        {
            LinkButton btn = sender as LinkButton;
            Session["GameName"] = btn.Text;
            Response.Redirect("GameDetail.aspx");
        }
    }
}