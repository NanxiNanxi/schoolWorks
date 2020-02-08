using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace GameAPP
{
    public partial class GameDetail : System.Web.UI.Page
    {
        protected void Page_Prerender(object sender, EventArgs e)
        {
            MediaUtilities mu = new MediaUtilities();
            if (Request.QueryString["FileToDelete"] != null)
            {
                string fileName = Request.QueryString["FileToDelete"].ToString();
                File.Delete(MapPath("~/UploadedImages/" + fileName));
                mu.DeleteImages(fileName);

            }
            List<String> imageNames = new List<string>();
            
            foreach(Media m in mu.getImagesByName(Convert.ToString(Session["GameName"])))
            {
                imageNames.Add(m.FileName);
            }
            FileInfo[] files = new DirectoryInfo(MapPath("~/UploadedImages/")).GetFiles();
            List<FileInfo> filteredNames = new List<FileInfo>();
            foreach (FileInfo file in files)
            {
                foreach (String name in imageNames)
                {
                    if (file.Name.Equals(name))
                    {
                        filteredNames.Add(file);
                    }
                }
            }
            DataListImages.DataSource = filteredNames;
            DataListImages.DataBind();
            if(mu.getGameByName(Convert.ToString(Session["GameName"])) == null)
            {
                Response.Redirect("UploadPage.aspx");
            }
            
        }

        protected void btnUploadInDetail_Click(object sender, EventArgs e)
        {
            string filePath = "~/UploadedImages/" + fileUpInDetail.FileName;

            if (CheckFileType(filePath))
            {
                fileUpInDetail.SaveAs(MapPath(filePath));
            }
            MediaUtilities mu = new MediaUtilities();
            //get gameId from gamename
            mu.insertImage(new Media(mu.getGameIdByGameName(Convert.ToString(Session["GameName"])), fileUpInDetail.FileName));
            
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

        protected void btnBack_Click(object sender, EventArgs e)
        {
            Response.Redirect("UploadPage.aspx");
        }

        protected void btnDeteleAll_Click(object sender, EventArgs e)
        {
            MediaUtilities mu = new MediaUtilities();
            mu.DeleteImages(mu.getGameIdByGameName(Convert.ToString(Session["GameName"])));
        }
    }
}