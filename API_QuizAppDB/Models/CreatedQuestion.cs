using System;
using System.Collections.Generic;

namespace API_QuizAppDB.Models
{
    public partial class CreatedQuestion
    {
        public string Username { get; set; } = null!;
        public int IdQuestion { get; set; }
        public DateTime? CreatedTime { get; set; }

        public virtual Question IdQuestionNavigation { get; set; } = null!;
        public virtual User UsernameNavigation { get; set; } = null!;
    }
}
