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
    public class RankingsController : ControllerBase
    {
        private readonly QuizAppDbContext _context;

        public RankingsController(QuizAppDbContext context)
        {
            _context = context;
        }

        // GET: api/Rankings
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Ranking>>> GetRankings()
        {
          if (_context.Rankings == null)
          {
              return NotFound();
          }
            return await _context.Rankings.ToListAsync();
        }

        // GET: api/Rankings/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Ranking>> GetRanking(string id)
        {
          if (_context.Rankings == null)
          {
              return NotFound();
          }
            var ranking = await _context.Rankings.FindAsync(id);

            if (ranking == null)
            {
                return NotFound();
            }

            return ranking;
        }

        // PUT: api/Rankings/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutRanking(string id, Ranking ranking)
        {
            if (id != ranking.Username)
            {
                return BadRequest();
            }

            _context.Entry(ranking).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!RankingExists(id))
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

        // POST: api/Rankings
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Ranking>> PostRanking(Ranking ranking)
        {
          if (_context.Rankings == null)
          {
              return Problem("Entity set 'QuizAppDbContext.Rankings'  is null.");
          }
            _context.Rankings.Add(ranking);
            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (RankingExists(ranking.Username))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetRanking", new { id = ranking.Username }, ranking);
        }

        // DELETE: api/Rankings/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteRanking(string id)
        {
            if (_context.Rankings == null)
            {
                return NotFound();
            }
            var ranking = await _context.Rankings.FindAsync(id);
            if (ranking == null)
            {
                return NotFound();
            }

            _context.Rankings.Remove(ranking);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool RankingExists(string id)
        {
            return (_context.Rankings?.Any(e => e.Username == id)).GetValueOrDefault();
        }
    }
}
