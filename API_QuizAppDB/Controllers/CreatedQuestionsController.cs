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
    public class CreatedQuestionsController : ControllerBase
    {
        private readonly QuizAppDbContext _context;

        public CreatedQuestionsController(QuizAppDbContext context)
        {
            _context = context;
        }

        // GET: api/CreatedQuestions
        [HttpGet]
        public async Task<ActionResult<IEnumerable<CreatedQuestion>>> GetCreatedQuestions()
        {
          if (_context.CreatedQuestions == null)
          {
              return NotFound();
          }
            return await _context.CreatedQuestions.ToListAsync();
        }

        // GET: api/CreatedQuestions/user1
        [HttpGet("{username}")]
        public async Task<ActionResult<IEnumerable<CreatedQuestion>>> GetCreatedQuestionsByUsername(string username)
        {
          if (_context.CreatedQuestions == null)
          {
              return NotFound();
          }
            var createdQuestion = await _context.CreatedQuestions
                 .Where(cq => cq.Username == username)
                 .Include(cq => cq.IdQuestionNavigation)
                    .ThenInclude(q=> q.Answers)
                 .Include(cq=> cq.IdQuestionNavigation)
                    .ThenInclude(q=>q.IdSetNavigation)
                        .ThenInclude(qs=>qs.IdCategoryNavigation)
                 .ToListAsync();


            if (!createdQuestion.Any())
            {
                return NotFound();
            }



            var result = createdQuestion.Select(cq => new
            {
                createdTime = cq.CreatedTime,
                categoryName = cq.IdQuestionNavigation?.IdSetNavigation?.IdCategoryNavigation?.CategoryName,
                questionText = cq.IdQuestionNavigation?.QuestionText,
                answers = cq.IdQuestionNavigation?.Answers.Select(a => new
                {
                    answerText = a.AnswerText,
                    isCorrect = a.IsCorrect
                }).ToList()
            });
                                        

            if (!result.Any())
            {
                return NotFound();
            }

            return Ok(result);
        }

        [HttpGet("{username}/{idQuestion}")]
        public async Task<ActionResult<CreatedQuestion>> GetCreatedQuestion(String username, int idQuestion)
        {
            if (_context.CreatedQuestions == null)
            {
                return NotFound();
            }
            var createdQuestion = await _context.CreatedQuestions
                .FirstOrDefaultAsync(mq => mq.Username == username && mq.IdQuestion == idQuestion);
            if (createdQuestion == null)
            {
                return NotFound();
            }
            return createdQuestion;

        }


            // PUT: api/CreatedQuestions/5
            // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
            [HttpPut("{username}/{idQuestion}")]
        public async Task<IActionResult> PutCreatedQuestion(string username, int idQuestion, CreatedQuestion createdQuestion)
        {
            if (username != createdQuestion.Username && idQuestion != createdQuestion.IdQuestion)
            {
                return BadRequest();
            }

            _context.Entry(createdQuestion).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!CreatedQuestionExists(username, idQuestion))
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

        // POST: api/CreatedQuestions
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<CreatedQuestion>> PostCreatedQuestion(CreatedQuestion createdQuestion)
        {
          if (_context.CreatedQuestions == null)
          {
              return Problem("Entity set 'QuizAppDbContext.CreatedQuestions'  is null.");
          }
            _context.CreatedQuestions.Add(createdQuestion);
            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (CreatedQuestionExists(createdQuestion.Username,createdQuestion.IdQuestion))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetCreatedQuestion", new { username = createdQuestion.Username, idQuestion = createdQuestion.IdQuestion }, createdQuestion);
        }

        // DELETE: api/CreatedQuestions/5
        [HttpDelete("{username}/{idQuestion}")]
        public async Task<IActionResult> DeleteCreatedQuestion(string username, int idQuestion)
        {
            if (_context.CreatedQuestions == null)
            {
                return NotFound();
            }
            var createdQuestion = await _context.CreatedQuestions.FirstOrDefaultAsync(mq => (mq.Username == username && mq.IdQuestion == idQuestion));
            if (createdQuestion == null)
            {
                return NotFound();
            }

            _context.CreatedQuestions.Remove(createdQuestion);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool CreatedQuestionExists(string username, int idQuestion)
        {
            return (_context.CreatedQuestions?.Any(e => (e.Username == username && e.IdQuestion == idQuestion))).GetValueOrDefault();
        }
    }
}
