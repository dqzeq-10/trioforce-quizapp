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
        [HttpGet("{id}")]
        public async Task<ActionResult<ProgressQuestion>> GetProgressQuestion(string id)
        {
          if (_context.ProgressQuestions == null)
          {
              return NotFound();
          }
            var progressQuestion = await _context.ProgressQuestions.FindAsync(id);

            if (progressQuestion == null)
            {
                return NotFound();
            }

            return progressQuestion;
        }

        // PUT: api/ProgressQuestions/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutProgressQuestion(string id, ProgressQuestion progressQuestion)
        {
            if (id != progressQuestion.Username)
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
                if (!ProgressQuestionExists(id))
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
                if (ProgressQuestionExists(progressQuestion.Username))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetProgressQuestion", new { id = progressQuestion.Username }, progressQuestion);
        }

        // DELETE: api/ProgressQuestions/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteProgressQuestion(string id)
        {
            if (_context.ProgressQuestions == null)
            {
                return NotFound();
            }
            var progressQuestion = await _context.ProgressQuestions.FindAsync(id);
            if (progressQuestion == null)
            {
                return NotFound();
            }

            _context.ProgressQuestions.Remove(progressQuestion);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool ProgressQuestionExists(string id)
        {
            return (_context.ProgressQuestions?.Any(e => e.Username == id)).GetValueOrDefault();
        }
    }
}
