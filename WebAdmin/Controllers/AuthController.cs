using API_QuizAppDB.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace API_QuizAppDB.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AuthController : ControllerBase
    {
        private readonly QuizAppDbContext _context;

        public AuthController(QuizAppDbContext context)
        {
            _context = context;
        }

        [HttpPost("Login")]
        public async Task<IActionResult> Login([FromBody] LoginRequest Lrequest)
        {
            var user = _context.Users.FirstOrDefault(u => u.Username == Lrequest.Username && u.Password == Lrequest.Password);
            if (user == null)
            {
                return Unauthorized(new { message = "username or password is not true!:))" });
            }
            return Ok(user);
        }
    }
}
