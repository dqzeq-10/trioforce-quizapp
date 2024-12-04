using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using API_QuizAppDB.Models;
using NuGet.ContentModel;

namespace API_QuizAppDB.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ProgressQuestionsController : ControllerBase
    {
        private readonly QuizAppDbContext _context;

        public ProgressQuestionsController(QuizAppDbContext context)
        {
            _context = context;
        }

        // GET: api/ProgressQuestions
        [HttpGet]
        public async Task<ActionResult<IEnumerable<ProgressQuestion>>> GetProgressQuestions()
        {
          if (_context.ProgressQuestions == null)
          {
              return NotFound();
          }
            return await _context.ProgressQuestions.ToListAsync();
        }

        // GET: api/ProgressQuestions/5
        [HttpGet("{username}")]
        public async Task<ActionResult<IEnumerable<ProgressQuestion>>> GetProgressQuestionByUsername(string username)
        {
          if (_context.ProgressQuestions == null)
          {
              return NotFound();
          }
            var progressQuestions = await _context.ProgressQuestions
                .Where(pq => pq.Username == username)
                .Include(pq =>pq.IdSetNavigation)
                    .ThenInclude(qs=>qs.Questions)
                .Include(pq=>pq.IdSetNavigation)
                    .ThenInclude(qs=>qs.AnsweredQuestitons)
                .ToListAsync();

            if (progressQuestions == null || !progressQuestions.Any())
            {
                return NotFound();
            }

            var result = progressQuestions.Select(pq => new
            {
                savedTime = pq.SaveTime,
                idSet = pq.IdSet,
                questionCount = pq.QuestionCount,
                questionLastId = pq.QuestionLastId,
                setName = pq.IdSetNavigation?.SetName,
                questions = pq.IdSetNavigation?.Questions.Select(q => new
                {
                    idQuestion = q.IdQuestion,
                    questionText = q.QuestionText,
                    answers = q.Answers.Select(a => new
                    {
                        answerText = a.AnswerText,
                        isCorrect = a.IsCorrect
                    }),
                    isAnswered = pq.IdSetNavigation?.AnsweredQuestitons
                        .Any(aq => aq.IdQuestion == q.IdQuestion && aq.Username == username),
                    isCorrect = pq.IdSetNavigation?.AnsweredQuestitons
                        .Where(aq => aq.IdQuestion == q.IdQuestion && aq.Username == username)
                        .Select(aq => aq.IsCorrect)
                        .FirstOrDefault()
                }).ToList()
            }).ToList();

            return Ok(result);
        }


        [HttpGet("{username}/{idSet}")]
        public async Task<ActionResult<ProgressQuestion>> GetProgressQuestion(String username, int idSet)
        {
            if (_context.ProgressQuestions == null)
            {
                return NotFound();
            }
            var progressQuestion = await _context.ProgressQuestions
                .FirstOrDefaultAsync(pq => pq.Username == username && pq.IdSet == idSet);
            if (progressQuestion == null)
            {
                return NotFound();
            }
            return progressQuestion;

        }

        // PUT: api/ProgressQuestions/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{username}/{idSet}")]
        public async Task<IActionResult> PutProgressQuestion(String username, int idSet, ProgressQuestion progressQuestion)
        {
            if (username != progressQuestion.Username && idSet != progressQuestion.IdSet)
            {
                return BadRequest();
            }

            _context.Entry(progressQuestion).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!ProgressQuestionExists(username,idSet))
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

        // POST: api/ProgressQuestions
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<ProgressQuestion>> PostProgressQuestion(ProgressQuestion progressQuestion)
        {
          if (_context.ProgressQuestions == null)
          {
              return Problem("Entity set 'QuizAppDbContext.ProgressQuestions'  is null.");
          }
            _context.ProgressQuestions.Add(progressQuestion);
            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (ProgressQuestionExists(progressQuestion.Username,progressQuestion.IdSet))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetProgressQuestion", new { username = progressQuestion.Username, idSet = progressQuestion.IdSet }, progressQuestion);
        }

        // DELETE: api/ProgressQuestions/5
        [HttpDelete("{username}/{idSet}")]
        public async Task<IActionResult> DeleteProgressQuestion(string username, int idSet)
        {
            if (_context.ProgressQuestions == null)
            {
                return NotFound();
            }
            var progressQuestion = await _context.ProgressQuestions.FirstOrDefaultAsync(mq => (mq.Username == username && mq.IdSet == idSet));
            if (progressQuestion == null)
            {
                return NotFound();
            }

            _context.ProgressQuestions.Remove(progressQuestion);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool ProgressQuestionExists(string username, int idSet)
        {
            return (_context.ProgressQuestions?.Any(e => (e.Username == username && e.IdSet == idSet))).GetValueOrDefault();
        }
    }
}
