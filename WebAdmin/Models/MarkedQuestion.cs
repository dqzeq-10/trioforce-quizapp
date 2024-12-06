using System;
using System.Collections.Generic;

namespace API_QuizAppDB.Models
{
    public partial class MarkedQuestion
    {
        public string Username { get; set; } = null!;
        public int IdQuestion { get; set; }
        public DateTime? MarkedTime { get; set; }

        public virtual Question? IdQuestionNavigation { get; set; }
        public virtual User? UsernameNavigation { get; set; }
    }
}
