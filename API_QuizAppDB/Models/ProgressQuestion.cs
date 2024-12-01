using System;
using System.Collections.Generic;

namespace API_QuizAppDB.Models
{
    public partial class ProgressQuestion
    {
        public string Username { get; set; } = null!;
        public int IdSet { get; set; }
        public int? QuestionCount { get; set; }
        public int? QuestionLastId { get; set; }
        public DateTime? SaveTime { get; set; }

        public virtual QuestionSet? IdSetNavigation { get; set; }
        public virtual Question? QuestionLast { get; set; }
        public virtual User? UsernameNavigation { get; set; }
    }
}
