using System;
using System.Collections.Generic;

namespace API_QuizAppDB.Models
{
    public partial class QuestionCategory
    {
        public QuestionCategory()
        {
            QuestionSets = new HashSet<QuestionSet>();
        }

        public int IdCategory { get; set; }
        public string? CategoryName { get; set; }

        public virtual ICollection<QuestionSet> QuestionSets { get; set; }
    }
}
