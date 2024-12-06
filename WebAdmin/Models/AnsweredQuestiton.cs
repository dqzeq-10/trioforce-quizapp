using System;
using System.Collections.Generic;

namespace API_QuizAppDB.Models
{
    public partial class AnsweredQuestiton
    {
        public string Username { get; set; } = null!;
        public int IdSet { get; set; }
        public int IdQuestion { get; set; }
        public bool? IsCorrect { get; set; }

        public virtual Question? IdQuestionNavigation { get; set; }
        public virtual QuestionSet? IdSetNavigation { get; set; }
        public virtual User? UsernameNavigation { get; set; }
    }
}
