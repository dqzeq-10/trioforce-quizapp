using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using API_QuizAppDB.Models;

namespace API_QuizAppDB.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class MarkedQuestionsController : ControllerBase
    {
        private readonly QuizAppDbContext _context;

        public MarkedQuestionsController(QuizAppDbContext context)
        {
            _context = context;
        }

        // GET: api/MarkedQuestions
        [HttpGet]
        public async Task<ActionResult<IEnumerable<MarkedQuestion>>> GetMarkedQuestions()
        {
          if (_context.MarkedQuestions == null)
          {
              return NotFound();
          }
            return await _context.MarkedQuestions.ToListAsync();
        }

        // GET: api/MarkedQuestions/user1
        [HttpGet("{username}")]
        public async Task<ActionResult<IEnumerable<MarkedQuestion>>> GetMarkedQuestionsByUsername(string username)
        {
          if (_context.MarkedQuestions == null)
          {
              return NotFound();
          }
            var markedQuestions = await _context.MarkedQuestions
                .Where(mq => mq.Username == username)
                .ToListAsync();
        

            if (!markedQuestions.Any())
            {
                return NotFound();
            }

            return markedQuestions;
        }

        // GET: api/MarkedQuestions/user1/1
        [HttpGet("{username}/{idQuestion}")]
        public async Task<ActionResult<MarkedQuestion>> GetMarkedQuestion(String username, int idQuestion)
        {
            if (_context.MarkedQuestions == null)
            {
                return NotFound();
            }
            var markedQuestion = await _context.MarkedQuestions
                .FirstOrDefaultAsync(mq => mq.Username == username && mq.IdQuestion == idQuestion);
            if (markedQuestion == null)
            {
                return NotFound();
            }
            return markedQuestion;

        }




        // PUT: api/MarkedQuestions/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{username}/{idQuestion}")]
        public async Task<IActionResult> PutMarkedQuestion(string username, int idQuestion, MarkedQuestion markedQuestion)
        {
            if (username != markedQuestion.Username && idQuestion != markedQuestion.IdQuestion)
            {
                return BadRequest();
            }

            _context.Entry(markedQuestion).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!MarkedQuestionExists(username, idQuestion))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/MarkedQuestions
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754

        //POST json:
        //{
        //  "username": "user1",
        //  "idQuestion": 3,
        //  "markedTime": "2024-12-01"
        //}
        [HttpPost]
        public async Task<ActionResult<MarkedQuestion>> PostMarkedQuestion(MarkedQuestion markedQuestion)
        {
          if (_context.MarkedQuestions == null)
          {
              return Problem("Entity set 'QuizAppDbContext.MarkedQuestions'  is null.");
          }
            _context.MarkedQuestions.Add(markedQuestion);
            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (MarkedQuestionExists(markedQuestion.Username, markedQuestion.IdQuestion))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetMarkedQuestion", new { username = markedQuestion.Username, idQuestion = markedQuestion.IdQuestion }, markedQuestion);
        }

        // DELETE: api/MarkedQuestions/5
        [HttpDelete("{username}/{idQuestion}")]
        public async Task<IActionResult> DeleteMarkedQuestion(string username, int idQuestion)
        {
            if (_context.MarkedQuestions == null)
            {
                return NotFound();
            }
            var markedQuestion = await _context.MarkedQuestions.FirstOrDefaultAsync(mq => (mq.Username == username && mq.IdQuestion == idQuestion));
            if (markedQuestion == null)
            {
                return NotFound();
            }

            _context.MarkedQuestions.Remove(markedQuestion);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool MarkedQuestionExists(string username, int idQuestion)
        {
            return (_context.MarkedQuestions?.Any(e => (e.Username == username && e.IdQuestion == idQuestion))).GetValueOrDefault();
        }
    }
}
