using System;
using System.Collections.Generic;

namespace API_QuizAppDB.Models
{
    public partial class QuestionSet
    {
        public QuestionSet()
        {
            AnsweredQuestitons = new HashSet<AnsweredQuestiton>();
            ProgressQuestions = new HashSet<ProgressQuestion>();
            Questions = new HashSet<Question>();
        }

        public int IdSet { get; set; }
        public string? SetName { get; set; }
        public string? AuthorName { get; set; }
        public int? IdLevel { get; set; }
        public int? IdCategory { get; set; }

        public virtual User? AuthorNameNavigation { get; set; }
        public virtual QuestionCategory? IdCategoryNavigation { get; set; }
        public virtual Level? IdLevelNavigation { get; set; }
        public virtual ICollection<AnsweredQuestiton> AnsweredQuestitons { get; set; }
        public virtual ICollection<ProgressQuestion> ProgressQuestions { get; set; }
        public virtual ICollection<Question> Questions { get; set; }
    }
}
