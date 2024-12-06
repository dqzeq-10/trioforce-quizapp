using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace API_QuizAppDB.Migrations
{
    public partial class FirstMigration : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Levels",
                columns: table => new
                {
                    ID_Levels = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    LevelName = table.Column<string>(type: "nvarchar(15)", maxLength: 15, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK__Levels__A21400FA90AD608A", x => x.ID_Levels);
                });

            migrationBuilder.CreateTable(
                name: "QuestionCategory",
                columns: table => new
                {
                    ID_Category = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    CategoryName = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK__Question__6DB3A68A113DB44D", x => x.ID_Category);
                });

            migrationBuilder.CreateTable(
                name: "Users",
                columns: table => new
                {
                    username = table.Column<string>(type: "varchar(32)", unicode: false, maxLength: 32, nullable: false),
                    password = table.Column<string>(type: "varchar(32)", unicode: false, maxLength: 32, nullable: true),
                    name = table.Column<string>(type: "nvarchar(32)", maxLength: 32, nullable: true),
                    email = table.Column<string>(type: "varchar(50)", unicode: false, maxLength: 50, nullable: true),
                    phoneNumber = table.Column<string>(type: "char(10)", unicode: false, fixedLength: true, maxLength: 10, nullable: true),
                    sex = table.Column<bool>(type: "bit", nullable: true),
                    birthday = table.Column<DateTime>(type: "date", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK__Users__F3DBC5730EBFA09B", x => x.username);
                });

            migrationBuilder.CreateTable(
                name: "QuestionSet",
                columns: table => new
                {
                    ID_Set = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    SetName = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: true),
                    AuthorName = table.Column<string>(type: "varchar(32)", unicode: false, maxLength: 32, nullable: true),
                    ID_Level = table.Column<int>(type: "int", nullable: true),
                    ID_Category = table.Column<int>(type: "int", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK__Question__27F810F27D87FD7A", x => x.ID_Set);
                    table.ForeignKey(
                        name: "FK__QuestionS__Autho__3D5E1FD2",
                        column: x => x.AuthorName,
                        principalTable: "Users",
                        principalColumn: "username");
                    table.ForeignKey(
                        name: "FK__QuestionS__ID_Ca__3F466844",
                        column: x => x.ID_Category,
                        principalTable: "QuestionCategory",
                        principalColumn: "ID_Category");
                    table.ForeignKey(
                        name: "FK__QuestionS__ID_Le__3E52440B",
                        column: x => x.ID_Level,
                        principalTable: "Levels",
                        principalColumn: "ID_Levels");
                });

            migrationBuilder.CreateTable(
                name: "Ranking",
                columns: table => new
                {
                    username = table.Column<string>(type: "varchar(32)", unicode: false, maxLength: 32, nullable: false),
                    point = table.Column<int>(type: "int", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK__Ranking__F3DBC573C88D6534", x => x.username);
                    table.ForeignKey(
                        name: "FK__Ranking__usernam__49C3F6B7",
                        column: x => x.username,
                        principalTable: "Users",
                        principalColumn: "username");
                });

            migrationBuilder.CreateTable(
                name: "Questions",
                columns: table => new
                {
                    ID_Question = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    QuestionText = table.Column<string>(type: "nvarchar(255)", maxLength: 255, nullable: true),
                    ID_Set = table.Column<int>(type: "int", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK__Question__7F5FD85467B36270", x => x.ID_Question);
                    table.ForeignKey(
                        name: "FK__Questions__ID_Se__4222D4EF",
                        column: x => x.ID_Set,
                        principalTable: "QuestionSet",
                        principalColumn: "ID_Set");
                });

            migrationBuilder.CreateTable(
                name: "AnsweredQuestitons",
                columns: table => new
                {
                    username = table.Column<string>(type: "varchar(32)", unicode: false, maxLength: 32, nullable: false),
                    ID_Set = table.Column<int>(type: "int", nullable: false),
                    ID_Question = table.Column<int>(type: "int", nullable: false),
                    isCorrect = table.Column<bool>(type: "bit", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK__Answered__94DB1BA4493AF05F", x => new { x.username, x.ID_Set, x.ID_Question });
                    table.ForeignKey(
                        name: "FK__AnsweredQ__ID_Qu__46E78A0C",
                        column: x => x.ID_Question,
                        principalTable: "Questions",
                        principalColumn: "ID_Question");
                    table.ForeignKey(
                        name: "FK__AnsweredQ__ID_Se__45F365D3",
                        column: x => x.ID_Set,
                        principalTable: "QuestionSet",
                        principalColumn: "ID_Set");
                    table.ForeignKey(
                        name: "FK__AnsweredQ__usern__44FF419A",
                        column: x => x.username,
                        principalTable: "Users",
                        principalColumn: "username");
                });

            migrationBuilder.CreateTable(
                name: "Answers",
                columns: table => new
                {
                    ID_Answer = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    ID_Question = table.Column<int>(type: "int", nullable: false),
                    AnswerText = table.Column<string>(type: "nvarchar(255)", maxLength: 255, nullable: true),
                    isCorrect = table.Column<bool>(type: "bit", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK__Answers__7024C5D61E7F2E64", x => new { x.ID_Answer, x.ID_Question });
                    table.ForeignKey(
                        name: "FK__Answers__ID_Ques__59063A47",
                        column: x => x.ID_Question,
                        principalTable: "Questions",
                        principalColumn: "ID_Question");
                });

            migrationBuilder.CreateTable(
                name: "CreatedQuestion",
                columns: table => new
                {
                    username = table.Column<string>(type: "varchar(32)", unicode: false, maxLength: 32, nullable: false),
                    ID_Question = table.Column<int>(type: "int", nullable: false),
                    CreatedTime = table.Column<DateTime>(type: "date", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK__CreatedQ__A42E38F6568594D3", x => new { x.username, x.ID_Question });
                    table.ForeignKey(
                        name: "FK__CreatedQu__ID_Qu__4D94879B",
                        column: x => x.ID_Question,
                        principalTable: "Questions",
                        principalColumn: "ID_Question");
                    table.ForeignKey(
                        name: "FK__CreatedQu__usern__4CA06362",
                        column: x => x.username,
                        principalTable: "Users",
                        principalColumn: "username");
                });

            migrationBuilder.CreateTable(
                name: "MarkedQuestion",
                columns: table => new
                {
                    username = table.Column<string>(type: "varchar(32)", unicode: false, maxLength: 32, nullable: false),
                    ID_Question = table.Column<int>(type: "int", nullable: false),
                    MarkedTime = table.Column<DateTime>(type: "date", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK__MarkedQu__A42E38F6876D4006", x => new { x.username, x.ID_Question });
                    table.ForeignKey(
                        name: "FK__MarkedQue__ID_Qu__5165187F",
                        column: x => x.ID_Question,
                        principalTable: "Questions",
                        principalColumn: "ID_Question");
                    table.ForeignKey(
                        name: "FK__MarkedQue__usern__5070F446",
                        column: x => x.username,
                        principalTable: "Users",
                        principalColumn: "username");
                });

            migrationBuilder.CreateTable(
                name: "ProgressQuestion",
                columns: table => new
                {
                    username = table.Column<string>(type: "varchar(32)", unicode: false, maxLength: 32, nullable: false),
                    ID_Set = table.Column<int>(type: "int", nullable: false),
                    QuestionCount = table.Column<int>(type: "int", nullable: true),
                    QuestionLastID = table.Column<int>(type: "int", nullable: true),
                    SaveTime = table.Column<DateTime>(type: "datetime", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK__Progress__C1A4447CC4B736CC", x => new { x.username, x.ID_Set });
                    table.ForeignKey(
                        name: "FK__ProgressQ__ID_Se__5535A963",
                        column: x => x.ID_Set,
                        principalTable: "QuestionSet",
                        principalColumn: "ID_Set");
                    table.ForeignKey(
                        name: "FK__ProgressQ__Quest__5629CD9C",
                        column: x => x.QuestionLastID,
                        principalTable: "Questions",
                        principalColumn: "ID_Question");
                    table.ForeignKey(
                        name: "FK__ProgressQ__usern__5441852A",
                        column: x => x.username,
                        principalTable: "Users",
                        principalColumn: "username");
                });

            migrationBuilder.CreateIndex(
                name: "IX_AnsweredQuestitons_ID_Question",
                table: "AnsweredQuestitons",
                column: "ID_Question");

            migrationBuilder.CreateIndex(
                name: "IX_AnsweredQuestitons_ID_Set",
                table: "AnsweredQuestitons",
                column: "ID_Set");

            migrationBuilder.CreateIndex(
                name: "IX_Answers_ID_Question",
                table: "Answers",
                column: "ID_Question");

            migrationBuilder.CreateIndex(
                name: "IX_CreatedQuestion_ID_Question",
                table: "CreatedQuestion",
                column: "ID_Question");

            migrationBuilder.CreateIndex(
                name: "IX_MarkedQuestion_ID_Question",
                table: "MarkedQuestion",
                column: "ID_Question");

            migrationBuilder.CreateIndex(
                name: "IX_ProgressQuestion_ID_Set",
                table: "ProgressQuestion",
                column: "ID_Set");

            migrationBuilder.CreateIndex(
                name: "IX_ProgressQuestion_QuestionLastID",
                table: "ProgressQuestion",
                column: "QuestionLastID");

            migrationBuilder.CreateIndex(
                name: "IX_Questions_ID_Set",
                table: "Questions",
                column: "ID_Set");

            migrationBuilder.CreateIndex(
                name: "IX_QuestionSet_AuthorName",
                table: "QuestionSet",
                column: "AuthorName");

            migrationBuilder.CreateIndex(
                name: "IX_QuestionSet_ID_Category",
                table: "QuestionSet",
                column: "ID_Category");

            migrationBuilder.CreateIndex(
                name: "IX_QuestionSet_ID_Level",
                table: "QuestionSet",
                column: "ID_Level");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "AnsweredQuestitons");

            migrationBuilder.DropTable(
                name: "Answers");

            migrationBuilder.DropTable(
                name: "CreatedQuestion");

            migrationBuilder.DropTable(
                name: "MarkedQuestion");

            migrationBuilder.DropTable(
                name: "ProgressQuestion");

            migrationBuilder.DropTable(
                name: "Ranking");

            migrationBuilder.DropTable(
                name: "Questions");

            migrationBuilder.DropTable(
                name: "QuestionSet");

            migrationBuilder.DropTable(
                name: "Users");

            migrationBuilder.DropTable(
                name: "QuestionCategory");

            migrationBuilder.DropTable(
                name: "Levels");
        }
    }
}
