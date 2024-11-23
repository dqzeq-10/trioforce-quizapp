package com.example.finalproject_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_choose_mode extends AppCompatActivity {
ImageButton btnVeManHinhChinh;
AppCompatButton cdde,cdbthg,cdkho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choose_mode);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cdde =findViewById(R.id.CheDoDe);
        cdbthg =findViewById(R.id.CheDoBinhThuong);
        cdkho =findViewById(R.id.CheDoKho);
        btnVeManHinhChinh=(ImageButton) findViewById(R.id.TroVeManHinhChinh);


        btnVeManHinhChinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_choose_mode.this, MainScreen.class);
                startActivity(intent);
            }
        });

        cdde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(activity_choose_mode.this, main_play_quiz.class );
                String category = getIntent().getStringExtra("category");
                if (category != null) {
                    intent.putExtra("category", category);
                }
                intent.putExtra("level","Dễ");
                startActivity(intent);
            }
        });
        cdbthg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_choose_mode.this, main_play_quiz.class );
                String category = getIntent().getStringExtra("category");
                if (category != null) {
                    intent.putExtra("category", category);
                }
                intent.putExtra("level","Thường");
                startActivity(intent);
            }
        });
        cdkho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_choose_mode.this, main_play_quiz.class );
                String category = getIntent().getStringExtra("category");
                if (category != null) {
                    intent.putExtra("category", category);
                }
                intent.putExtra("level","Khó");
                startActivity(intent);
            }
        });

    }
}