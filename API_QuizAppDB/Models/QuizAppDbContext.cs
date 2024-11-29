using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace API_QuizAppDB.Models
{
    public partial class QuizAppDbContext : DbContext
    {
        public QuizAppDbContext()
        {
        }

        public QuizAppDbContext(DbContextOptions<QuizAppDbContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Answer> Answers { get; set; } = null!;
        public virtual DbSet<AnsweredQuestiton> AnsweredQuestitons { get; set; } = null!;
        public virtual DbSet<CreatedQuestion> CreatedQuestions { get; set; } = null!;
        public virtual DbSet<Level> Levels { get; set; } = null!;
        public virtual DbSet<MarkedQuestion> MarkedQuestions { get; set; } = null!;
        public virtual DbSet<ProgressQuestion> ProgressQuestions { get; set; } = null!;
        public virtual DbSet<Question> Questions { get; set; } = null!;
        public virtual DbSet<QuestionCategory> QuestionCategories { get; set; } = null!;
        public virtual DbSet<QuestionSet> QuestionSets { get; set; } = null!;
        public virtual DbSet<Ranking> Rankings { get; set; } = null!;
        public virtual DbSet<User> Users { get; set; } = null!;

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see http://go.microsoft.com/fwlink/?LinkId=723263.
                optionsBuilder.UseSqlServer("Data Source=.;Initial Catalog=DB_QuizApp_Fina;Integrated Security=True;Trust Server Certificate=True");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Answer>(entity =>
            {
                entity.HasKey(e => new { e.IdAnswer, e.IdQuestion })
                    .HasName("PK__Answers__7024C5D61E7F2E64");

                entity.Property(e => e.IdAnswer)
                    .ValueGeneratedOnAdd()
                    .HasColumnName("ID_Answer");

                entity.Property(e => e.IdQuestion).HasColumnName("ID_Question");

                entity.Property(e => e.AnswerText).HasMaxLength(255);

                entity.Property(e => e.IsCorrect).HasColumnName("isCorrect");

                entity.HasOne(d => d.IdQuestionNavigation)
                    .WithMany(p => p.Answers)
                    .HasForeignKey(d => d.IdQuestion)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK__Answers__ID_Ques__59063A47");
            });

            modelBuilder.Entity<AnsweredQuestiton>(entity =>
            {
                entity.HasKey(e => new { e.Username, e.IdSet, e.IdQuestion })
                    .HasName("PK__Answered__94DB1BA4493AF05F");

                entity.Property(e => e.Username)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("username");

                entity.Property(e => e.IdSet).HasColumnName("ID_Set");

                entity.Property(e => e.IdQuestion).HasColumnName("ID_Question");

                entity.Property(e => e.IsCorrect).HasColumnName("isCorrect");

                entity.HasOne(d => d.IdQuestionNavigation)
                    .WithMany(p => p.AnsweredQuestitons)
                    .HasForeignKey(d => d.IdQuestion)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK__AnsweredQ__ID_Qu__46E78A0C");

                entity.HasOne(d => d.IdSetNavigation)
                    .WithMany(p => p.AnsweredQuestitons)
                    .HasForeignKey(d => d.IdSet)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK__AnsweredQ__ID_Se__45F365D3");

                entity.HasOne(d => d.UsernameNavigation)
                    .WithMany(p => p.AnsweredQuestitons)
                    .HasForeignKey(d => d.Username)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK__AnsweredQ__usern__44FF419A");
            });

            modelBuilder.Entity<CreatedQuestion>(entity =>
            {
                entity.HasKey(e => new { e.Username, e.IdQuestion })
                    .HasName("PK__CreatedQ__A42E38F6568594D3");

                entity.ToTable("CreatedQuestion");

                entity.Property(e => e.Username)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("username");

                entity.Property(e => e.IdQuestion).HasColumnName("ID_Question");

                entity.Property(e => e.CreatedTime).HasColumnType("date");

                entity.HasOne(d => d.IdQuestionNavigation)
                    .WithMany(p => p.CreatedQuestions)
                    .HasForeignKey(d => d.IdQuestion)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK__CreatedQu__ID_Qu__4D94879B");

                entity.HasOne(d => d.UsernameNavigation)
                    .WithMany(p => p.CreatedQuestions)
                    .HasForeignKey(d => d.Username)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK__CreatedQu__usern__4CA06362");
            });

            modelBuilder.Entity<Level>(entity =>
            {
                entity.HasKey(e => e.IdLevels)
                    .HasName("PK__Levels__A21400FA90AD608A");

                entity.Property(e => e.IdLevels).HasColumnName("ID_Levels");

                entity.Property(e => e.LevelName).HasMaxLength(15);
            });

            modelBuilder.Entity<MarkedQuestion>(entity =>
            {
                entity.HasKey(e => new { e.Username, e.IdQuestion })
                    .HasName("PK__MarkedQu__A42E38F6876D4006");

                entity.ToTable("MarkedQuestion");

                entity.Property(e => e.Username)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("username");

                entity.Property(e => e.IdQuestion).HasColumnName("ID_Question");

                entity.Property(e => e.MarkedTime).HasColumnType("date");

                entity.HasOne(d => d.IdQuestionNavigation)
                    .WithMany(p => p.MarkedQuestions)
                    .HasForeignKey(d => d.IdQuestion)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK__MarkedQue__ID_Qu__5165187F");

                entity.HasOne(d => d.UsernameNavigation)
                    .WithMany(p => p.MarkedQuestions)
                    .HasForeignKey(d => d.Username)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK__MarkedQue__usern__5070F446");
            });

            modelBuilder.Entity<ProgressQuestion>(entity =>
            {
                entity.HasKey(e => new { e.Username, e.IdSet })
                    .HasName("PK__Progress__C1A4447CC4B736CC");

                entity.ToTable("ProgressQuestion");

                entity.Property(e => e.Username)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("username");

                entity.Property(e => e.IdSet).HasColumnName("ID_Set");

                entity.Property(e => e.QuestionLastId).HasColumnName("QuestionLastID");

                entity.Property(e => e.SaveTime).HasColumnType("datetime");

                entity.HasOne(d => d.IdSetNavigation)
                    .WithMany(p => p.ProgressQuestions)
                    .HasForeignKey(d => d.IdSet)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK__ProgressQ__ID_Se__5535A963");

                entity.HasOne(d => d.QuestionLast)
                    .WithMany(p => p.ProgressQuestions)
                    .HasForeignKey(d => d.QuestionLastId)
                    .HasConstraintName("FK__ProgressQ__Quest__5629CD9C");

                entity.HasOne(d => d.UsernameNavigation)
                    .WithMany(p => p.ProgressQuestions)
                    .HasForeignKey(d => d.Username)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK__ProgressQ__usern__5441852A");
            });

            modelBuilder.Entity<Question>(entity =>
            {
                entity.HasKey(e => e.IdQuestion)
                    .HasName("PK__Question__7F5FD85467B36270");

                entity.Property(e => e.IdQuestion).HasColumnName("ID_Question");

                entity.Property(e => e.IdSet).HasColumnName("ID_Set");

                entity.Property(e => e.QuestionText).HasMaxLength(255);

                entity.HasOne(d => d.IdSetNavigation)
                    .WithMany(p => p.Questions)
                    .HasForeignKey(d => d.IdSet)
                    .HasConstraintName("FK__Questions__ID_Se__4222D4EF");
            });

            modelBuilder.Entity<QuestionCategory>(entity =>
            {
                entity.HasKey(e => e.IdCategory)
                    .HasName("PK__Question__6DB3A68A113DB44D");

                entity.ToTable("QuestionCategory");

                entity.Property(e => e.IdCategory).HasColumnName("ID_Category");

                entity.Property(e => e.CategoryName).HasMaxLength(50);
            });

            modelBuilder.Entity<QuestionSet>(entity =>
            {
                entity.HasKey(e => e.IdSet)
                    .HasName("PK__Question__27F810F27D87FD7A");

                entity.ToTable("QuestionSet");

                entity.Property(e => e.IdSet).HasColumnName("ID_Set");

                entity.Property(e => e.AuthorName)
                    .HasMaxLength(32)
                    .IsUnicode(false);

                entity.Property(e => e.IdCategory).HasColumnName("ID_Category");

                entity.Property(e => e.IdLevel).HasColumnName("ID_Level");

                entity.Property(e => e.SetName).HasMaxLength(50);

                entity.HasOne(d => d.AuthorNameNavigation)
                    .WithMany(p => p.QuestionSets)
                    .HasForeignKey(d => d.AuthorName)
                    .HasConstraintName("FK__QuestionS__Autho__3D5E1FD2");

                entity.HasOne(d => d.IdCategoryNavigation)
                    .WithMany(p => p.QuestionSets)
                    .HasForeignKey(d => d.IdCategory)
                    .HasConstraintName("FK__QuestionS__ID_Ca__3F466844");

                entity.HasOne(d => d.IdLevelNavigation)
                    .WithMany(p => p.QuestionSets)
                    .HasForeignKey(d => d.IdLevel)
                    .HasConstraintName("FK__QuestionS__ID_Le__3E52440B");
            });

            modelBuilder.Entity<Ranking>(entity =>
            {
                entity.HasKey(e => e.Username)
                    .HasName("PK__Ranking__F3DBC573C88D6534");

                entity.ToTable("Ranking");

                entity.Property(e => e.Username)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("username");

                entity.Property(e => e.Point).HasColumnName("point");

                entity.HasOne(d => d.UsernameNavigation)
                    .WithOne(p => p.Ranking)
                    .HasForeignKey<Ranking>(d => d.Username)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK__Ranking__usernam__49C3F6B7");
            });

            modelBuilder.Entity<User>(entity =>
            {
                entity.HasKey(e => e.Username)
                    .HasName("PK__Users__F3DBC5730EBFA09B");

                entity.Property(e => e.Username)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("username");

                entity.Property(e => e.Birthday)
                    .HasColumnType("date")
                    .HasColumnName("birthday");

                entity.Property(e => e.Email)
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("email");

                entity.Property(e => e.Name)
                    .HasMaxLength(32)
                    .HasColumnName("name");

                entity.Property(e => e.Password)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("password");

                entity.Property(e => e.PhoneNumber)
                    .HasMaxLength(10)
                    .IsUnicode(false)
                    .HasColumnName("phoneNumber")
                    .IsFixedLength();

                entity.Property(e => e.Sex).HasColumnName("sex");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
