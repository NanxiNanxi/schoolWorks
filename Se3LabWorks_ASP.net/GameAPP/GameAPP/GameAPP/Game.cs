using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace GameAPP
{
    public class Game
    {
        public Game() { }
        public Game(int id, string title, string tag, string description, string year)
        {
            Id = id;
            Title = title;
            TagLine = tag;
            Year = year;
            Description = description;
        }
        public int Id { get; set; }
        public string Title { get; set; }
        public string TagLine { get; set; }
        public string Description { get; set; }
        public string Year { get; set; }
    }
}