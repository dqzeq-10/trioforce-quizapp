using System;
using System.Collections.Generic;

namespace API_QuizAppDB.Models
{
    public partial class Ranking
    {
        public string Username { get; set; } = null!;
        public int? Point { get; set; }

        public virtual User UsernameNavigation { get; set; } = null!;
    }
}
