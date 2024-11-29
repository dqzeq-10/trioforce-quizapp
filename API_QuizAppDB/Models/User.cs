using System;
using System.Collections.Generic;

namespace API_QuizAppDB.Models
{
    public partial class User
    {
        public User()
        {
            AnsweredQuestitons = new HashSet<AnsweredQuestiton>();
            CreatedQuestions = new HashSet<CreatedQuestion>();
            MarkedQuestions = new HashSet<MarkedQuestion>();
            ProgressQuestions = new HashSet<ProgressQuestion>();
            QuestionSets = new HashSet<QuestionSet>();
        }

        public string Username { get; set; } = null!;
        public string? Password { get; set; }
        public string? Name { get; set; }
        public string? Email { get; set; }
        public string? PhoneNumber { get; set; }
        public bool? Sex { get; set; }
        public DateTime? Birthday { get; set; }

        public virtual Ranking? Ranking { get; set; }
        public virtual ICollection<AnsweredQuestiton> AnsweredQuestitons { get; set; }
        public virtual ICollection<CreatedQuestion> CreatedQuestions { get; set; }
        public virtual ICollection<MarkedQuestion> MarkedQuestions { get; set; }
        public virtual ICollection<ProgressQuestion> ProgressQuestions { get; set; }
        public virtual ICollection<QuestionSet> QuestionSets { get; set; }
    }
}
