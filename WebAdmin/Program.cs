using API_QuizAppDB.Models;
using Microsoft.EntityFrameworkCore;
using System.Net;



var builder = WebApplication.CreateBuilder(args);
builder.Services.AddRazorPages();
// Add services to the container.

builder.Services.AddControllers().AddJsonOptions(options =>
{
    options.JsonSerializerOptions.Converters.Add(new System.Text.Json.Serialization.JsonDateTimeConverter());
    options.JsonSerializerOptions.ReferenceHandler = System.Text.Json.Serialization.ReferenceHandler.Preserve;
    options.JsonSerializerOptions.ReferenceHandler = System.Text.Json.Serialization.ReferenceHandler.IgnoreCycles;
});


// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

// thêm DbContext
builder.Services.AddDbContext<QuizAppDbContext>(options => options.UseSqlServer("Data Source=DESKTOP-CN8S640\\DINHDUC;Initial Catalog=DB_QuizApp_Fina;Integrated Security=True;Trust Server Certificate=True"));

//Thêm dịch vụ CORS
builder.Services.AddCors(options =>
{
    options.AddPolicy("AllowAll", policy =>
    {
        policy.AllowAnyOrigin() //cho phep tat ca cac nguon domain
               .AllowAnyMethod() //cho phep tat ca cac phuong thuc http (get, post, put, delete,..)
                .AllowAnyHeader(); //cho phep tat ca cac header
    });
});




var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}
app.UseSwagger();
app.UseSwaggerUI();

//app.UseHttpsRedirection();

//sử dụng cors
app.UseCors("AllowAll"); //ap dung policy cors nay vao pipeline cua ung dung

app.UseAuthorization();

app.MapRazorPages();
app.MapControllers();

app.Run();
