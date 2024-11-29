﻿// <auto-generated />
using System;
using API_QuizAppDB.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;

#nullable disable

namespace API_QuizAppDB.Migrations
{
    [DbContext(typeof(QuizAppDbContext))]
    partial class QuizAppDbContextModelSnapshot : ModelSnapshot
    {
        protected override void BuildModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "6.0.35")
                .HasAnnotation("Relational:MaxIdentifierLength", 128);

            SqlServerModelBuilderExtensions.UseIdentityColumns(modelBuilder, 1L, 1);

            modelBuilder.Entity("API_QuizAppDB.Models.Answer", b =>
                {
                    b.Property<int>("IdAnswer")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int")
                        .HasColumnName("ID_Answer");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("IdAnswer"), 1L, 1);

                    b.Property<int>("IdQuestion")
                        .HasColumnType("int")
                        .HasColumnName("ID_Question");

                    b.Property<string>("AnswerText")
                        .HasMaxLength(255)
                        .HasColumnType("nvarchar(255)");

                    b.Property<bool?>("IsCorrect")
                        .HasColumnType("bit")
                        .HasColumnName("isCorrect");

                    b.HasKey("IdAnswer", "IdQuestion")
                        .HasName("PK__Answers__7024C5D61E7F2E64");

                    b.HasIndex("IdQuestion");

                    b.ToTable("Answers");
                });

            modelBuilder.Entity("API_QuizAppDB.Models.AnsweredQuestiton", b =>
                {
                    b.Property<string>("Username")
                        .HasMaxLength(32)
                        .IsUnicode(false)
                        .HasColumnType("varchar(32)")
                        .HasColumnName("username");

                    b.Property<int>("IdSet")
                        .HasColumnType("int")
                        .HasColumnName("ID_Set");

                    b.Property<int>("IdQuestion")
                        .HasColumnType("int")
                        .HasColumnName("ID_Question");

                    b.Property<bool?>("IsCorrect")
                        .HasColumnType("bit")
                        .HasColumnName("isCorrect");

                    b.HasKey("Username", "IdSet", "IdQuestion")
                        .HasName("PK__Answered__94DB1BA4493AF05F");

                    b.HasIndex("IdQuestion");

                    b.HasIndex("IdSet");

                    b.ToTable("AnsweredQuestitons");
                });

            modelBuilder.Entity("API_QuizAppDB.Models.CreatedQuestion", b =>
                {
                    b.Property<string>("Username")
                        .HasMaxLength(32)
                        .IsUnicode(false)
                        .HasColumnType("varchar(32)")
                        .HasColumnName("username");

                    b.Property<int>("IdQuestion")
                        .HasColumnType("int")
                        .HasColumnName("ID_Question");

                    b.Property<DateTime?>("CreatedTime")
                        .HasColumnType("date");

                    b.HasKey("Username", "IdQuestion")
                        .HasName("PK__CreatedQ__A42E38F6568594D3");

                    b.HasIndex("IdQuestion");

                    b.ToTable("CreatedQuestion", (string)null);
                });

            modelBuilder.Entity("API_QuizAppDB.Models.Level", b =>
                {
                    b.Property<int>("IdLevels")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int")
                        .HasColumnName("ID_Levels");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("IdLevels"), 1L, 1);

                    b.Property<string>("LevelName")
                        .HasMaxLength(15)
                        .HasColumnType("nvarchar(15)");

                    b.HasKey("IdLevels")
                        .HasName("PK__Levels__A21400FA90AD608A");

                    b.ToTable("Levels");
                });

            modelBuilder.Entity("API_QuizAppDB.Models.MarkedQuestion", b =>
                {
                    b.Property<string>("Username")
                        .HasMaxLength(32)
                        .IsUnicode(false)
                        .HasColumnType("varchar(32)")
                        .HasColumnName("username");

                    b.Property<int>("IdQuestion")
                        .HasColumnType("int")
                        .HasColumnName("ID_Question");

                    b.Property<DateTime?>("MarkedTime")
                        .HasColumnType("date");

                    b.HasKey("Username", "IdQuestion")
                        .HasName("PK__MarkedQu__A42E38F6876D4006");

                    b.HasIndex("IdQuestion");

                    b.ToTable("MarkedQuestion", (string)null);
                });

            modelBuilder.Entity("API_QuizAppDB.Models.ProgressQuestion", b =>
                {
                    b.Property<string>("Username")
                        .HasMaxLength(32)
                        .IsUnicode(false)
                        .HasColumnType("varchar(32)")
                        .HasColumnName("username");

                    b.Property<int>("IdSet")
                        .HasColumnType("int")
                        .HasColumnName("ID_Set");

                    b.Property<int?>("QuestionCount")
                        .HasColumnType("int");

                    b.Property<int?>("QuestionLastId")
                        .HasColumnType("int")
                        .HasColumnName("QuestionLastID");

                    b.Property<DateTime?>("SaveTime")
                        .HasColumnType("datetime");

                    b.HasKey("Username", "IdSet")
                        .HasName("PK__Progress__C1A4447CC4B736CC");

                    b.HasIndex("IdSet");

                    b.HasIndex("QuestionLastId");

                    b.ToTable("ProgressQuestion", (string)null);
                });

            modelBuilder.Entity("API_QuizAppDB.Models.Question", b =>
                {
                    b.Property<int>("IdQuestion")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int")
                        .HasColumnName("ID_Question");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("IdQuestion"), 1L, 1);

                    b.Property<int?>("IdSet")
                        .HasColumnType("int")
                        .HasColumnName("ID_Set");

                    b.Property<string>("QuestionText")
                        .HasMaxLength(255)
                        .HasColumnType("nvarchar(255)");

                    b.HasKey("IdQuestion")
                        .HasName("PK__Question__7F5FD85467B36270");

                    b.HasIndex("IdSet");

                    b.ToTable("Questions");
                });

            modelBuilder.Entity("API_QuizAppDB.Models.QuestionCategory", b =>
                {
                    b.Property<int>("IdCategory")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int")
                        .HasColumnName("ID_Category");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("IdCategory"), 1L, 1);

                    b.Property<string>("CategoryName")
                        .HasMaxLength(50)
                        .HasColumnType("nvarchar(50)");

                    b.HasKey("IdCategory")
                        .HasName("PK__Question__6DB3A68A113DB44D");

                    b.ToTable("QuestionCategory", (string)null);
                });

            modelBuilder.Entity("API_QuizAppDB.Models.QuestionSet", b =>
                {
                    b.Property<int>("IdSet")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int")
                        .HasColumnName("ID_Set");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("IdSet"), 1L, 1);

                    b.Property<string>("AuthorName")
                        .HasMaxLength(32)
                        .IsUnicode(false)
                        .HasColumnType("varchar(32)");

                    b.Property<int?>("IdCategory")
                        .HasColumnType("int")
                        .HasColumnName("ID_Category");

                    b.Property<int?>("IdLevel")
                        .HasColumnType("int")
                        .HasColumnName("ID_Level");

                    b.Property<string>("SetName")
                        .HasMaxLength(50)
                        .HasColumnType("nvarchar(50)");

                    b.HasKey("IdSet")
                        .HasName("PK__Question__27F810F27D87FD7A");

                    b.HasIndex("AuthorName");

                    b.HasIndex("IdCategory");

                    b.HasIndex("IdLevel");

                    b.ToTable("QuestionSet", (string)null);
                });

            modelBuilder.Entity("API_QuizAppDB.Models.Ranking", b =>
                {
                    b.Property<string>("Username")
                        .HasMaxLength(32)
                        .IsUnicode(false)
                        .HasColumnType("varchar(32)")
                        .HasColumnName("username");

                    b.Property<int?>("Point")
                        .HasColumnType("int")
                        .HasColumnName("point");

                    b.HasKey("Username")
                        .HasName("PK__Ranking__F3DBC573C88D6534");

                    b.ToTable("Ranking", (string)null);
                });

            modelBuilder.Entity("API_QuizAppDB.Models.User", b =>
                {
                    b.Property<string>("Username")
                        .HasMaxLength(32)
                        .IsUnicode(false)
                        .HasColumnType("varchar(32)")
                        .HasColumnName("username");

                    b.Property<DateTime?>("Birthday")
                        .HasColumnType("date")
                        .HasColumnName("birthday");

                    b.Property<string>("Email")
                        .HasMaxLength(50)
                        .IsUnicode(false)
                        .HasColumnType("varchar(50)")
                        .HasColumnName("email");

                    b.Property<string>("Name")
                        .HasMaxLength(32)
                        .HasColumnType("nvarchar(32)")
                        .HasColumnName("name");

                    b.Property<string>("Password")
                        .HasMaxLength(32)
                        .IsUnicode(false)
                        .HasColumnType("varchar(32)")
                        .HasColumnName("password");

                    b.Property<string>("PhoneNumber")
                        .HasMaxLength(10)
                        .IsUnicode(false)
                        .HasColumnType("char(10)")
                        .HasColumnName("phoneNumber")
                        .IsFixedLength();

                    b.Property<bool?>("Sex")
                        .HasColumnType("bit")
                        .HasColumnName("sex");

                    b.HasKey("Username")
                        .HasName("PK__Users__F3DBC5730EBFA09B");

                    b.ToTable("Users");
                });

            modelBuilder.Entity("API_QuizAppDB.Models.Answer", b =>
                {
                    b.HasOne("API_QuizAppDB.Models.Question", "IdQuestionNavigation")
                        .WithMany("Answers")
                        .HasForeignKey("IdQuestion")
                        .IsRequired()
                        .HasConstraintName("FK__Answers__ID_Ques__59063A47");

                    b.Navigation("IdQuestionNavigation");
                });

            modelBuilder.Entity("API_QuizAppDB.Models.AnsweredQuestiton", b =>
                {
                    b.HasOne("API_QuizAppDB.Models.Question", "IdQuestionNavigation")
                        .WithMany("AnsweredQuestitons")
                        .HasForeignKey("IdQuestion")
                        .IsRequired()
                        .HasConstraintName("FK__AnsweredQ__ID_Qu__46E78A0C");

                    b.HasOne("API_QuizAppDB.Models.QuestionSet", "IdSetNavigation")
                        .WithMany("AnsweredQuestitons")
                        .HasForeignKey("IdSet")
                        .IsRequired()
                        .HasConstraintName("FK__AnsweredQ__ID_Se__45F365D3");

                    b.HasOne("API_QuizAppDB.Models.User", "UsernameNavigation")
                        .WithMany("AnsweredQuestitons")
                        .HasForeignKey("Username")
                        .IsRequired()
                        .HasConstraintName("FK__AnsweredQ__usern__44FF419A");

                    b.Navigation("IdQuestionNavigation");

                    b.Navigation("IdSetNavigation");

                    b.Navigation("UsernameNavigation");
                });

            modelBuilder.Entity("API_QuizAppDB.Models.CreatedQuestion", b =>
                {
                    b.HasOne("API_QuizAppDB.Models.Question", "IdQuestionNavigation")
                        .WithMany("CreatedQuestions")
                        .HasForeignKey("IdQuestion")
                        .IsRequired()
                        .HasConstraintName("FK__CreatedQu__ID_Qu__4D94879B");

                    b.HasOne("API_QuizAppDB.Models.User", "UsernameNavigation")
                        .WithMany("CreatedQuestions")
                        .HasForeignKey("Username")
                        .IsRequired()
                        .HasConstraintName("FK__CreatedQu__usern__4CA06362");

                    b.Navigation("IdQuestionNavigation");

                    b.Navigation("UsernameNavigation");
                });

            modelBuilder.Entity("API_QuizAppDB.Models.MarkedQuestion", b =>
                {
                    b.HasOne("API_QuizAppDB.Models.Question", "IdQuestionNavigation")
                        .WithMany("MarkedQuestions")
                        .HasForeignKey("IdQuestion")
                        .IsRequired()
                        .HasConstraintName("FK__MarkedQue__ID_Qu__5165187F");

                    b.HasOne("API_QuizAppDB.Models.User", "UsernameNavigation")
                        .WithMany("MarkedQuestions")
                        .HasForeignKey("Username")
                        .IsRequired()
                        .HasConstraintName("FK__MarkedQue__usern__5070F446");

                    b.Navigation("IdQuestionNavigation");

                    b.Navigation("UsernameNavigation");
                });

            modelBuilder.Entity("API_QuizAppDB.Models.ProgressQuestion", b =>
                {
                    b.HasOne("API_QuizAppDB.Models.QuestionSet", "IdSetNavigation")
                        .WithMany("ProgressQuestions")
                        .HasForeignKey("IdSet")
                        .IsRequired()
                        .HasConstraintName("FK__ProgressQ__ID_Se__5535A963");

                    b.HasOne("API_QuizAppDB.Models.Question", "QuestionLast")
                        .WithMany("ProgressQuestions")
                        .HasForeignKey("QuestionLastId")
                        .HasConstraintName("FK__ProgressQ__Quest__5629CD9C");

                    b.HasOne("API_QuizAppDB.Models.User", "UsernameNavigation")
                        .WithMany("ProgressQuestions")
                        .HasForeignKey("Username")
                        .IsRequired()
                        .HasConstraintName("FK__ProgressQ__usern__5441852A");

                    b.Navigation("IdSetNavigation");

                    b.Navigation("QuestionLast");

                    b.Navigation("UsernameNavigation");
                });

            modelBuilder.Entity("API_QuizAppDB.Models.Question", b =>
                {
                    b.HasOne("API_QuizAppDB.Models.QuestionSet", "IdSetNavigation")
                        .WithMany("Questions")
                        .HasForeignKey("IdSet")
                        .HasConstraintName("FK__Questions__ID_Se__4222D4EF");

                    b.Navigation("IdSetNavigation");
                });

            modelBuilder.Entity("API_QuizAppDB.Models.QuestionSet", b =>
                {
                    b.HasOne("API_QuizAppDB.Models.User", "AuthorNameNavigation")
                        .WithMany("QuestionSets")
                        .HasForeignKey("AuthorName")
                        .HasConstraintName("FK__QuestionS__Autho__3D5E1FD2");

                    b.HasOne("API_QuizAppDB.Models.QuestionCategory", "IdCategoryNavigation")
                        .WithMany("QuestionSets")
                        .HasForeignKey("IdCategory")
                        .HasConstraintName("FK__QuestionS__ID_Ca__3F466844");

                    b.HasOne("API_QuizAppDB.Models.Level", "IdLevelNavigation")
                        .WithMany("QuestionSets")
                        .HasForeignKey("IdLevel")
                        .HasConstraintName("FK__QuestionS__ID_Le__3E52440B");

                    b.Navigation("AuthorNameNavigation");

                    b.Navigation("IdCategoryNavigation");

                    b.Navigation("IdLevelNavigation");
                });

            modelBuilder.Entity("API_QuizAppDB.Models.Ranking", b =>
                {
                    b.HasOne("API_QuizAppDB.Models.User", "UsernameNavigation")
                        .WithOne("Ranking")
                        .HasForeignKey("API_QuizAppDB.Models.Ranking", "Username")
                        .IsRequired()
                        .HasConstraintName("FK__Ranking__usernam__49C3F6B7");

                    b.Navigation("UsernameNavigation");
                });

            modelBuilder.Entity("API_QuizAppDB.Models.Level", b =>
                {
                    b.Navigation("QuestionSets");
                });

            modelBuilder.Entity("API_QuizAppDB.Models.Question", b =>
                {
                    b.Navigation("AnsweredQuestitons");

                    b.Navigation("Answers");

                    b.Navigation("CreatedQuestions");

                    b.Navigation("MarkedQuestions");

                    b.Navigation("ProgressQuestions");
                });

            modelBuilder.Entity("API_QuizAppDB.Models.QuestionCategory", b =>
                {
                    b.Navigation("QuestionSets");
                });

            modelBuilder.Entity("API_QuizAppDB.Models.QuestionSet", b =>
                {
                    b.Navigation("AnsweredQuestitons");

                    b.Navigation("ProgressQuestions");

                    b.Navigation("Questions");
                });

            modelBuilder.Entity("API_QuizAppDB.Models.User", b =>
                {
                    b.Navigation("AnsweredQuestitons");

                    b.Navigation("CreatedQuestions");

                    b.Navigation("MarkedQuestions");

                    b.Navigation("ProgressQuestions");

                    b.Navigation("QuestionSets");

                    b.Navigation("Ranking");
                });
#pragma warning restore 612, 618
        }
    }
}
