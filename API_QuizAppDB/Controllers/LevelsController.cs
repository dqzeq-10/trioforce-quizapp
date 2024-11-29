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
    public class LevelsController : ControllerBase
    {
        private readonly QuizAppDbContext _context;

        public LevelsController(QuizAppDbContext context)
        {
            _context = context;
        }

        // GET: api/Levels
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Level>>> GetLevels()
        {
          if (_context.Levels == null)
          {
              return NotFound();
          }
            return await _context.Levels.ToListAsync();
        }

        // GET: api/Levels/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Level>> GetLevel(int id)
        {
          if (_context.Levels == null)
          {
              return NotFound();
          }
            var level = await _context.Levels.FindAsync(id);

            if (level == null)
            {
                return NotFound();
            }

            return level;
        }

        // PUT: api/Levels/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutLevel(int id, Level level)
        {
            if (id != level.IdLevels)
            {
                return BadRequest();
            }

            _context.Entry(level).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!LevelExists(id))
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

        // POST: api/Levels
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Level>> PostLevel(Level level)
        {
          if (_context.Levels == null)
          {
              return Problem("Entity set 'QuizAppDbContext.Levels'  is null.");
          }
            _context.Levels.Add(level);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetLevel", new { id = level.IdLevels }, level);
        }

        // DELETE: api/Levels/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteLevel(int id)
        {
            if (_context.Levels == null)
            {
                return NotFound();
            }
            var level = await _context.Levels.FindAsync(id);
            if (level == null)
            {
                return NotFound();
            }

            _context.Levels.Remove(level);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool LevelExists(int id)
        {
            return (_context.Levels?.Any(e => e.IdLevels == id)).GetValueOrDefault();
        }
    }
}
