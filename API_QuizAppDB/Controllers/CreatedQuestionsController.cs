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

        // GET: api/CreatedQuestions/5
        [HttpGet("{id}")]
        public async Task<ActionResult<CreatedQuestion>> GetCreatedQuestion(string id)
        {
          if (_context.CreatedQuestions == null)
          {
              return NotFound();
          }
            var createdQuestion = await _context.CreatedQuestions.FindAsync(id);

            if (createdQuestion == null)
            {
                return NotFound();
            }

            return createdQuestion;
        }

        // PUT: api/CreatedQuestions/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutCreatedQuestion(string id, CreatedQuestion createdQuestion)
        {
            if (id != createdQuestion.Username)
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
                if (!CreatedQuestionExists(id))
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
                if (CreatedQuestionExists(createdQuestion.Username))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetCreatedQuestion", new { id = createdQuestion.Username }, createdQuestion);
        }

        // DELETE: api/CreatedQuestions/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteCreatedQuestion(string id)
        {
            if (_context.CreatedQuestions == null)
            {
                return NotFound();
            }
            var createdQuestion = await _context.CreatedQuestions.FindAsync(id);
            if (createdQuestion == null)
            {
                return NotFound();
            }

            _context.CreatedQuestions.Remove(createdQuestion);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool CreatedQuestionExists(string id)
        {
            return (_context.CreatedQuestions?.Any(e => e.Username == id)).GetValueOrDefault();
        }
    }
}
