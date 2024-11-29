using System;
using System.Collections.Generic;

namespace API_QuizAppDB.Models
{
    public partial class Answer
    {
        public int IdAnswer { get; set; }
        public int IdQuestion { get; set; }
        public string? AnswerText { get; set; }
        public bool? IsCorrect { get; set; }

        public virtual Question? IdQuestionNavigation { get; set; } = null!;
    }
}
