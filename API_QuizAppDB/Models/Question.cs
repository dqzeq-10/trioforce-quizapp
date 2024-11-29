using System;
using System.Collections.Generic;

namespace API_QuizAppDB.Models
{
    public partial class Question
    {
        public Question()
        {
            AnsweredQuestitons = new HashSet<AnsweredQuestiton>();
            Answers = new HashSet<Answer>();
            CreatedQuestions = new HashSet<CreatedQuestion>();
            MarkedQuestions = new HashSet<MarkedQuestion>();
            ProgressQuestions = new HashSet<ProgressQuestion>();
        }

        public int IdQuestion { get; set; }
        public string? QuestionText { get; set; }
        public int? IdSet { get; set; }

        public virtual QuestionSet? IdSetNavigation { get; set; }
        public virtual ICollection<AnsweredQuestiton> AnsweredQuestitons { get; set; }
        public virtual ICollection<Answer> Answers { get; set; }
        public virtual ICollection<CreatedQuestion> CreatedQuestions { get; set; }
        public virtual ICollection<MarkedQuestion> MarkedQuestions { get; set; }
        public virtual ICollection<ProgressQuestion> ProgressQuestions { get; set; }
    }
}
