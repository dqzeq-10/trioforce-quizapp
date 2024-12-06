using System;
using System.Collections.Generic;

namespace API_QuizAppDB.Models
{
    public partial class Level
    {
        public Level()
        {
            QuestionSets = new HashSet<QuestionSet>();
        }

        public int IdLevels { get; set; }
        public string? LevelName { get; set; }

        public virtual ICollection<QuestionSet> QuestionSets { get; set; }
    }
}
