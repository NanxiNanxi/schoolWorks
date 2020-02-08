using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;

namespace GameAPP
{
    public class Media
    {
        public Media(String fileName)
        {
            FileName = fileName;
        }

        public Media(int gameId, string fileName)
        {
            GameId = gameId;
            FileName = fileName;
        }
        public Media(int id, int gameId, string fileName)
        {
            Id = id;
            GameId = gameId;
            FileName = fileName;
        }
        public int Id { get; set; }
        public int GameId { get; set; }
        public string FileName { get; set; }
        private string _renderText;
        public String RenderText
        {
            get
            {
                string ext = Path.GetExtension(FileName);
                string renderResult = "";
                if (ext == ".mp4")
                {
                    renderResult = @"<video width='320' height='240' controls>" +
                                   "<source src = '" + FileName + "' type = 'video/mp4' >" +
                                   "Your browser does not support the video tag." +
                                   "</ video >";
                }
                else
                {
                    renderResult = @"<img src ='" + FileName + "' style='width:200px' />";

                }
                return renderResult;
            }
        }
    }
}