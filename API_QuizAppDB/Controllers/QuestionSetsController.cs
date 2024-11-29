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
    public class QuestionSetsController : ControllerBase
    {
        private readonly QuizAppDbContext _context;

        public QuestionSetsController(QuizAppDbContext context)
        {
            _context = context;
        }

        // GET: api/QuestionSets
        [HttpGet]
        public async Task<ActionResult<IEnumerable<QuestionSet>>> GetQuestionSets()
        {
          if (_context.QuestionSets == null)
          {
              return NotFound();
          }
            return await _context.QuestionSets.ToListAsync();
        }

        // GET: api/QuestionSets/5
        [HttpGet("{id}")]
        public async Task<ActionResult<QuestionSet>> GetQuestionSet(int id)
        {
          if (_context.QuestionSets == null)
          {
              return NotFound();
            }
            var questionSet = await _context.QuestionSets           
                .Include(qs => qs.IdCategoryNavigation)
                .Include(qs => qs.IdLevelNavigation)
                .Include(qs => qs.Questions)
                    .ThenInclude(q=>q.Answers)
                .FirstOrDefaultAsync(qs => qs.IdSet == id);
            
            if (questionSet == null)
            {
                return NotFound();
            }
            var result = new
            {
                questionSet.IdSet,
                questionSet.SetName,
                questionSet.AuthorName,
                Category = questionSet.IdCategoryNavigation?.CategoryName,
                Level = questionSet.IdLevelNavigation?.LevelName,
                Questions = questionSet.Questions.Select(q => new
                {
                    q.IdQuestion,
                    q.QuestionText,
                    Answers = q.Answers.Select(a => new
                    {
                        a.AnswerText,
                        a.IsCorrect
                    }).ToList()
                }).ToList()
            };


            return Ok(result);
        }

        // PUT: api/QuestionSets/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutQuestionSet(int id, QuestionSet questionSet)
        {
            if (id != questionSet.IdSet)
            {
                return BadRequest();
            }

            _context.Entry(questionSet).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!QuestionSetExists(id))
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

        // POST: api/QuestionSets
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<QuestionSet>> PostQuestionSet(QuestionSet questionSet)
        {
          if (_context.QuestionSets == null)
          {
              return Problem("Entity set 'QuizAppDbContext.QuestionSets'  is null.");
          }
            _context.QuestionSets.Add(questionSet);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetQuestionSet", new { id = questionSet.IdSet }, questionSet);
        }

        // DELETE: api/QuestionSets/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteQuestionSet(int id)
        {
            if (_context.QuestionSets == null)
            {
                return NotFound();
            }
            var questionSet = await _context.QuestionSets.FindAsync(id);
            if (questionSet == null)
            {
                return NotFound();
            }

            _context.QuestionSets.Remove(questionSet);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool QuestionSetExists(int id)
        {
            return (_context.QuestionSets?.Any(e => e.IdSet == id)).GetValueOrDefault();
        }
    }
}
