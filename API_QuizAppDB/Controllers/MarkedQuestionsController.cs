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

        // GET: api/MarkedQuestions/5
        [HttpGet("{id}")]
        public async Task<ActionResult<MarkedQuestion>> GetMarkedQuestion(string id)
        {
          if (_context.MarkedQuestions == null)
          {
              return NotFound();
          }
            var markedQuestion = await _context.MarkedQuestions.FindAsync(id);

            if (markedQuestion == null)
            {
                return NotFound();
            }

            return markedQuestion;
        }

        // PUT: api/MarkedQuestions/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutMarkedQuestion(string id, MarkedQuestion markedQuestion)
        {
            if (id != markedQuestion.Username)
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
                if (!MarkedQuestionExists(id))
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
                if (MarkedQuestionExists(markedQuestion.Username))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetMarkedQuestion", new { id = markedQuestion.Username }, markedQuestion);
        }

        // DELETE: api/MarkedQuestions/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteMarkedQuestion(string id)
        {
            if (_context.MarkedQuestions == null)
            {
                return NotFound();
            }
            var markedQuestion = await _context.MarkedQuestions.FindAsync(id);
            if (markedQuestion == null)
            {
                return NotFound();
            }

            _context.MarkedQuestions.Remove(markedQuestion);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool MarkedQuestionExists(string id)
        {
            return (_context.MarkedQuestions?.Any(e => e.Username == id)).GetValueOrDefault();
        }
    }
}
