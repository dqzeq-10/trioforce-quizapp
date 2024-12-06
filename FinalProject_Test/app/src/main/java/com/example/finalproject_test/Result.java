package com.example.finalproject_test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Result extends AppCompatActivity {
AppCompatButton btnrshome, btnrsreplay, btnrsnext;
private TextView resultPoint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        btnrshome = findViewById(R.id.rs_home);
        btnrsreplay = findViewById(R.id.rs_replay);
        btnrsnext = findViewById(R.id.rs_next);
        resultPoint = findViewById(R.id.result_point);
// /nhan diem tu intent

        int totalScore = getIntent().getIntExtra("totalScore", 0);


        Log.d("TotalScore", "Total Score from Intent: " + totalScore); // In ra log để kiểm tra điểm

        resultPoint.setText(String.valueOf(totalScore+".00"));

        btnrshome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result.this, MainScreen.class);
                startActivity(intent);
                finish();
            }
        });


        btnrsreplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idCate =  getIntent().getIntExtra("idCategoryR",1);
                int idLeve = getIntent().getIntExtra("idLevelR",1);
                String cate = getIntent().getStringExtra("categoryR");
                String level = getIntent().getStringExtra("levelR");
                Boolean isNew = getIntent().getBooleanExtra("isNewPlayR", true);
                Intent intent = new Intent(Result.this, main_play_quiz.class);
                intent.putExtra("isNewPlay", isNew);
                intent.putExtra("category", cate);
                intent.putExtra("level", level);
                intent.putExtra("idCategory", idCate);
                intent.putExtra("idLevel", idLeve);
                startActivity(intent);
                finish();
            }
        });
        btnrsnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result.this, activity_choose_mode.class);
                startActivity(intent);
                finish();
            }
        });
    }
}