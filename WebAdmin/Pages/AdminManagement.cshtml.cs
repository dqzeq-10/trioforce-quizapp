using Microsoft.AspNetCore.Mvc.RazorPages;
using System.Collections.Generic;

namespace API_QuizAppDB.Pages
{
    public class AdminManagementModel : PageModel
    {
        // Danh sách API cần được truyền qua Razor Page
        public List<ApiInfo> ApiList { get; set; }

        // OnGet là phương thức được gọi khi trang web được truy cập (truyền dữ liệu vào ApiList)
        public void OnGet()
        {
            // Giả lập danh sách API. Ở đây bạn có thể thay thế bằng dữ liệu từ cơ sở dữ liệu
            ApiList = new List<ApiInfo>
            {
                new ApiInfo { Id = 1, Name = "User", Url = "/api/Users" },
                new ApiInfo { Id = 2, Name = "Question", Url = "/api/Questions" },
                new ApiInfo { Id = 3, Name = "Ranking", Url = "/api/RanKings" },
                new ApiInfo { Id = 4, Name = "MarkedQuestion", Url = "/api/markedquestions" },
                new ApiInfo { Id = 5, Name = "ProgressQuestions", Url = "/api/progressquestions" },
                new ApiInfo { Id = 6, Name = "QuestionCategories", Url = "/api/endpoint3" },
                new ApiInfo { Id = 7, Name = "Answers", Url = "/api/endpoint3" },
                 new ApiInfo { Id = 8, Name = "CreateQuestion", Url = "/api/endpoint3" }
            };
        }
    }

    // Model ApiInfo - đây là kiểu dữ liệu chứa thông tin về API
    public class ApiInfo
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Url { get; set; }
    }
}
