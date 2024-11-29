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
    public class AnsweredQuestitonsController : ControllerBase
    {
        private readonly QuizAppDbContext _context;

        public AnsweredQuestitonsController(QuizAppDbContext context)
        {
            _context = context;
        }

        // GET: api/AnsweredQuestitons
        [HttpGet]
        public async Task<ActionResult<IEnumerable<AnsweredQuestiton>>> GetAnsweredQuestitons()
        {
          if (_context.AnsweredQuestitons == null)
          {
              return NotFound();
          }
            return await _context.AnsweredQuestitons.ToListAsync();
        }

        // GET: api/AnsweredQuestitons/5
        [HttpGet("{id}")]
        public async Task<ActionResult<AnsweredQuestiton>> GetAnsweredQuestiton(string id)
        {
          if (_context.AnsweredQuestitons == null)
          {
              return NotFound();
          }
            var answeredQuestiton = await _context.AnsweredQuestitons.FindAsync(id);

            if (answeredQuestiton == null)
            {
                return NotFound();
            }

            return answeredQuestiton;
        }

        // PUT: api/AnsweredQuestitons/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutAnsweredQuestiton(string id, AnsweredQuestiton answeredQuestiton)
        {
            if (id != answeredQuestiton.Username)
            {
                return BadRequest();
            }

            _context.Entry(answeredQuestiton).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!AnsweredQuestitonExists(id))
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

        // POST: api/AnsweredQuestitons
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<AnsweredQuestiton>> PostAnsweredQuestiton(AnsweredQuestiton answeredQuestiton)
        {
          if (_context.AnsweredQuestitons == null)
          {
              return Problem("Entity set 'QuizAppDbContext.AnsweredQuestitons'  is null.");
          }
            _context.AnsweredQuestitons.Add(answeredQuestiton);
            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (AnsweredQuestitonExists(answeredQuestiton.Username))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetAnsweredQuestiton", new { id = answeredQuestiton.Username }, answeredQuestiton);
        }

        // DELETE: api/AnsweredQuestitons/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteAnsweredQuestiton(string id)
        {
            if (_context.AnsweredQuestitons == null)
            {
                return NotFound();
            }
            var answeredQuestiton = await _context.AnsweredQuestitons.FindAsync(id);
            if (answeredQuestiton == null)
            {
                return NotFound();
            }

            _context.AnsweredQuestitons.Remove(answeredQuestiton);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool AnsweredQuestitonExists(string id)
        {
            return (_context.AnsweredQuestitons?.Any(e => e.Username == id)).GetValueOrDefault();
        }
    }
}
