using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.IO;
using System.Linq;
using System.Web;

namespace GameAPP
{
    public class MediaUtilities
    {
        private String conString;
        public Game g;
        public int gameId;
        public MediaUtilities()
        {
            conString = "Data Source=bisiisdev;Initial Catalog=235PolyGames03;Persist Security Info=True;User ID=bisstudent;Password=bobby2013";
        }
        public List<Media> getMedia()
        {
            HttpRequest req = HttpContext.Current.Request;
            String[] files = Directory.GetFiles(req.MapPath("UploadedImages"));
            List<Media> media = new List<Media>();
            foreach (String s in files)
            {
                String f = Path.GetFileName(s);
                media.Add(new Media("UploadedImages\\" + f));
            }
            return media;
        }

        public List<Game> getGames()
        {
            SqlConnection con = new SqlConnection(conString);
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = "SELECT Id,Title,TagLine,Description,Year FROM Games ORDER BY Id";
            List<Game> Games = new List<Game>();

            con.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                Game g = new Game(
                Convert.ToInt32(reader["Id"]),
                reader["Title"].ToString(),
                reader["TagLine"].ToString(),
                reader["Description"].ToString(),
                reader["Year"].ToString());
                Games.Add(g);
            }
            return Games;
        }

        public int insertGame(Game g)
        {
            int key = -1;
            using (SqlConnection sqlcon = new SqlConnection(conString))
            {
                sqlcon.Open();
                using (SqlCommand cmd = new SqlCommand(@"INSERT INTO Games
                (Title, TagLine, Description, Year) 
                VALUES(@Title, @Tag, @Desc, @Year); SELECT SCOPE_IDENTITY();", sqlcon))
                {
                    cmd.Parameters.AddWithValue("@Title", g.Title);
                    cmd.Parameters.AddWithValue("@Tag", g.TagLine);
                    cmd.Parameters.AddWithValue("@Desc", g.Description);
                    cmd.Parameters.AddWithValue("@Year", g.Year);

                    key = Convert.ToInt32(cmd.ExecuteScalar());

                }

            }
            return key;


        }


        public int insertImage(Media m)
        {
            int key = -1;
            using (SqlConnection sqlcon = new SqlConnection(conString))
            {
                sqlcon.Open();
                using (SqlCommand cmd = new SqlCommand(@"INSERT INTO Images
                (FileName, GameId) 
                VALUES(@FileName, @GameId); SELECT SCOPE_IDENTITY();", sqlcon))
                {
                    cmd.Parameters.AddWithValue("@FileName",m.FileName);
                    cmd.Parameters.AddWithValue("@GameId", m.GameId);

                    key = Convert.ToInt32(cmd.ExecuteScalar());

                }

            }
            return key;
        }

        public int getGameIdByGameName(String gameName)
        {
            SqlConnection con = new SqlConnection(conString);
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = "SELECT Id FROM Games WHERE Title = @Title";
            cmd.Parameters.AddWithValue("@Title", gameName);
            con.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                gameId = Convert.ToInt32(reader["Id"]);
            }
            return gameId;

        }

        public Game getGameById(int gameId)
        {
            
            SqlConnection con = new SqlConnection(conString);
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = "SELECT Id,Title,Tagline,Description,Year FROM Games WHERE Id = @Id";
            cmd.Parameters.AddWithValue("@Id", gameId);
            con.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                g = new Game(
                Convert.ToInt32(reader["Id"]),
                reader["Title"].ToString(),
                reader["TagLine"].ToString(),
                reader["Description"].ToString(),
                reader["Year"].ToString());
               
            }
            return g;
        }

        public Game getGameByName(String name)
        {

            SqlConnection con = new SqlConnection(conString);
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = "SELECT Id,Title,Tagline,Description,Year FROM Games WHERE Title = @Title";
            cmd.Parameters.AddWithValue("@Title", name);
            con.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                g = new Game(
                Convert.ToInt32(reader["Id"]),
                reader["Title"].ToString(),
                reader["TagLine"].ToString(),
                reader["Description"].ToString(),
                reader["Year"].ToString());

            }
            return g;
        }

        public List<Media> getImagesById(int gameId)
        {
            SqlConnection con = new SqlConnection(conString);
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = "SELECT FileName, GameId FROM Images WHERE GameId = @GameId";
            List<Media> Images = new List<Media>();

            con.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                Media m = new Media(
                    Convert.ToInt32(reader["Id"]),
                    Convert.ToInt32(reader["GameId"]),
                    reader["FileName"].ToString());
            }
            return Images;
        }

        public List<Media> getImagesByGameId(int gameId)
        {
            SqlConnection con = new SqlConnection(conString);
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = "SELECT FileName, GameId FROM Images WHERE GameId = @GameId";
            List<Media> Images = new List<Media>();

            con.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                Media m = new Media(
                    Convert.ToInt32(reader["Id"]),
                    Convert.ToInt32(reader["GameId"]),
                    reader["FileName"].ToString());
            }
            return Images;
        }
        public List<Media> getImagesByName(String gameName)
        {
            SqlConnection con = new SqlConnection(conString);
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = "SELECT Images.FileName, Images.GameId FROM Images INNER JOIN Games ON Games.Id = Images.GameId WHERE Games.Title = @Title";
            List<Media> Images = new List<Media>();
            cmd.Parameters.AddWithValue("@Title", gameName);
            con.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                Media m = new Media(
                    Convert.ToInt32(reader["GameId"]),
                    reader["FileName"].ToString());
                Images.Add(m);
            }
            return Images;
        }
        public List<String> getImageNamesByName(String gameName)
        {
            SqlConnection con = new SqlConnection(conString);
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = "SELECT Images.FileName FROM Images WHERE Games.Title = @Title INNER JOIN Games ON Games.Id = Images.GameId";
            List<String> ImageNames = new List<String>();
            cmd.Parameters.AddWithValue("@Title", gameName);
            con.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                ImageNames.Add(reader["FileName"].ToString());
            }
            return ImageNames;
        }

        public void DeleteImages(String fileName)
        {
            SqlConnection con = new SqlConnection(conString);
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = "DELETE FROM Images WHERE FileName=@FileName";
            cmd.Parameters.AddWithValue("@FileName", fileName);

            con.Open();
            cmd.ExecuteNonQuery();
        }

        public void DeleteImages(int gameId)
        {
            SqlConnection con = new SqlConnection(conString);
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = "DELETE FROM Images WHERE GameId=@GameId";
            cmd.Parameters.AddWithValue("@GameId", gameId);

            con.Open();
            cmd.ExecuteNonQuery();
        }

        public void DeleteGame(int id)
        {
            SqlConnection con = new SqlConnection(conString);
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = "DELETE FROM Games WHERE Id=@Id";
            cmd.Parameters.AddWithValue("@Id", id);

            con.Open();
            cmd.ExecuteNonQuery();
            DeleteImages(id);
        }


    }
}