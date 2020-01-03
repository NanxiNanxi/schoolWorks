using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using System.IO;
//using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;
using System.Drawing;


namespace COMP235WebSite
{
    public partial class WebForm2 : System.Web.UI.Page
    {
        String[,] schedule;

        FileStream schedIO;
        BinaryFormatter schedObjIO;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["schedule"] == null)
            {
                if (File.Exists(MapPath("toDoList\\toDoList.bin")))
                {
                    //Create a file pointer to the toDoList file
                    schedIO = new FileStream(
                        MapPath("toDoList\\toDoList.bin"), FileMode.Open);

                    //Deserialize the object back into an array
                    schedObjIO = new BinaryFormatter();
                    schedule = (string[,])schedObjIO.Deserialize(schedIO);
                    schedIO.Close();
                }
                else
                {
                    schedule = new string[12 + 1, 31 + 1];//Added 1 for 0-based collection
                }
                Session["schedule"] = schedule;
            }

        }

        protected void btnSave_Click(object sender, EventArgs e)
        {
            schedule = (string[,])Session["schedule"];
            DateTime dt = calPlanner.SelectedDate;
            int month = dt.Month;
            int day = dt.Day;

            string evnt = txtEvent.Text;

            if (evnt.Trim() == "") evnt = null;

            schedule[month,day] = evnt;

            Session["schedule"] = schedule;
            
            //Create a file pointer to the toDoList file
            schedIO = new FileStream(
                MapPath("toDoList\\toDoList.bin"), FileMode.Create);

            //Serialize (i.e. write) the schedule object 
            //to the toDoList file
            schedObjIO = new BinaryFormatter();
            schedObjIO.Serialize(schedIO, schedule);
            schedIO.Close();








        }

        protected void calPlanner_SelectionChanged(object sender, EventArgs e)
        {
            schedule = (string[,])Session["schedule"];
            DateTime dt = calPlanner.SelectedDate;
            int month = dt.Month;
            int day = dt.Day;

            txtEvent.Text = schedule[month, day];

        }

        protected void calPlanner_DayRender(object sender, DayRenderEventArgs e)
        {
            DateTime d = e.Day.Date;
            int month = d.Month;
            int day = d.Day;

            schedule = (string[,])Session["schedule"];

            if(schedule[month, day] != null)
            {
                TableCell c = e.Cell;
                c.BackColor = Color.Brown;
                

            }



        }
    }
}