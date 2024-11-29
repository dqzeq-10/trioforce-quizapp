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
    public class QuestionCategoriesController : ControllerBase
    {
        private readonly QuizAppDbContext _context;

        public QuestionCategoriesController(QuizAppDbContext context)
        {
            _context = context;
        }

        // GET: api/QuestionCategories
        [HttpGet]
        public async Task<ActionResult<IEnumerable<QuestionCategory>>> GetQuestionCategories()
        {
          if (_context.QuestionCategories == null)
          {
              return NotFound();
          }
            return await _context.QuestionCategories.ToListAsync();
        }

        // GET: api/QuestionCategories/5
        [HttpGet("{id}")]
        public async Task<ActionResult<QuestionCategory>> GetQuestionCategory(int id)
        {
          if (_context.QuestionCategories == null)
          {
              return NotFound();
          }
            var questionCategory = await _context.QuestionCategories.FindAsync(id);

            if (questionCategory == null)
            {
                return NotFound();
            }

            return questionCategory;
        }

        // PUT: api/QuestionCategories/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutQuestionCategory(int id, QuestionCategory questionCategory)
        {
            if (id != questionCategory.IdCategory)
            {
                return BadRequest();
            }

            _context.Entry(questionCategory).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!QuestionCategoryExists(id))
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

        // POST: api/QuestionCategories
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<QuestionCategory>> PostQuestionCategory(QuestionCategory questionCategory)
        {
          if (_context.QuestionCategories == null)
          {
              return Problem("Entity set 'QuizAppDbContext.QuestionCategories'  is null.");
          }
            _context.QuestionCategories.Add(questionCategory);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetQuestionCategory", new { id = questionCategory.IdCategory }, questionCategory);
        }

        // DELETE: api/QuestionCategories/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteQuestionCategory(int id)
        {
            if (_context.QuestionCategories == null)
            {
                return NotFound();
            }
            var questionCategory = await _context.QuestionCategories.FindAsync(id);
            if (questionCategory == null)
            {
                return NotFound();
            }

            _context.QuestionCategories.Remove(questionCategory);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool QuestionCategoryExists(int id)
        {
            return (_context.QuestionCategories?.Any(e => e.IdCategory == id)).GetValueOrDefault();
        }
    }
}
