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
        [HttpGet("{username}")]
        public async Task<ActionResult<IEnumerable<AnsweredQuestiton>>> GetAnsweredQuestitonsByUsername(string username)
        {
          if (_context.AnsweredQuestitons == null)
          {
              return NotFound();
          }
            var answeredQuestiton = await _context.AnsweredQuestitons
                .Where(mq => mq.Username == username)
                .ToListAsync(); ;

            if (answeredQuestiton == null)
            {
                return NotFound();
            }

            return answeredQuestiton;
        }

        [HttpGet("{username}/{idSet}")]
        public async Task<ActionResult<IEnumerable<AnsweredQuestiton>>> GetAnsweredQuestitonsByUsernameandIdset(String username, int idSet)
        {
            if (_context.AnsweredQuestitons == null)
            {
                return NotFound();
            }
            var answeredQuestiton = await _context.AnsweredQuestitons
                .Where(mq => mq.Username == username && mq.IdSet == idSet)
                .ToListAsync();

            if (!answeredQuestiton.Any())
            {
                return NotFound();
            }

            return answeredQuestiton;

        }

        [HttpGet("{username}/{idSet}/{idQuestion}")]
        public async Task<ActionResult<AnsweredQuestiton>> GetAnsweredQuestitonByUsernameandIdsetandIdQuestion(String username,int idSet, int idQuestion)
        {
            if (_context.AnsweredQuestitons == null)
            {
                return NotFound();
            }
            var answeredQuestiton = await _context.AnsweredQuestitons
                .FirstOrDefaultAsync(mq => mq.Username == username && mq.IdSet == idSet && mq.IdQuestion == idQuestion);
            if (answeredQuestiton == null)
            {
                return NotFound();
            }
            return answeredQuestiton;

        }

        // PUT: api/AnsweredQuestitons/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{username}/{idSet}/{idQuestion}")]
        public async Task<IActionResult> PutAnsweredQuestiton(String username, int idSet, int idQuestion, AnsweredQuestiton answeredQuestiton)
        {
            if (username != answeredQuestiton.Username && idSet != answeredQuestiton.IdSet && idQuestion != answeredQuestiton.IdQuestion)
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
                if (!AnsweredQuestitonExists(username,idSet,idQuestion))
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
                if (AnsweredQuestitonExists(answeredQuestiton.Username,answeredQuestiton.IdSet,answeredQuestiton.IdQuestion))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetAnsweredQuestitonByUsernameandIdsetandIdQuestion", new { username = answeredQuestiton.Username, idSet = answeredQuestiton.IdSet, idQuestion = answeredQuestiton.IdQuestion }, answeredQuestiton);
        }

        // DELETE: api/AnsweredQuestitons/5
        [HttpDelete("{username}/{idSet}/{idQuestion}")]
        public async Task<IActionResult> DeleteAnsweredQuestiton(String username, int idSet, int idQuestion)
        {
            if (_context.AnsweredQuestitons == null)
            {
                return NotFound();
            }
            var answeredQuestiton = await _context.AnsweredQuestitons.FirstOrDefaultAsync(mq => (mq.Username == username && mq.IdSet == idSet && mq.IdQuestion == idQuestion));
            if (answeredQuestiton == null)
            {
                return NotFound();
            }

            _context.AnsweredQuestitons.Remove(answeredQuestiton);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool AnsweredQuestitonExists(String username, int idSet, int idQuestion)
        {
            return (_context.AnsweredQuestitons?.Any(e => (e.Username == username && e.IdSet ==idSet && e.IdQuestion == idQuestion))).GetValueOrDefault();
        }
    }
}
