package com.example.finalproject_test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
                Log.d("ChooseMode", "Button Easy clicked");
                Intent intent = new Intent(activity_choose_mode.this, main_play_quiz.class );
                int idCategory = getIntent().getIntExtra("idCategory",-1);
                String category = getIntent().getStringExtra("category");
                if (category == null || idCategory == -1) {
                    Log.e("main_play_quiz", "Thiếu dữ liệu Intent: category hoặc idCategory");
                    return;
                }
                Log.d("ChooseMode", "Category: " + category + ", idCategory: " + idCategory);
                if (category != null) {
                    intent.putExtra("category", category);
                    intent.putExtra("idCategory",idCategory);
                }else
                {
                    Log.d("error", "onClick: cdde category bi null");
                }
                intent.putExtra("level","Dễ");
                intent.putExtra("idLevel",1);
                startActivity(intent);
            }
        });
        cdbthg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_choose_mode.this, main_play_quiz.class );
                String category = getIntent().getStringExtra("category");
                int idCategory = getIntent().getIntExtra("idCategory",1);
                if (category == null || idCategory == -1) {
                    Log.e("main_play_quiz", "Thiếu dữ liệu Intent: category hoặc idCategory");
                    return;
                }
                if (category != null) {
                    intent.putExtra("category", category);
                    intent.putExtra("idCategory",idCategory);
                }
                intent.putExtra("level","Thường");
                intent.putExtra("idLevel",2);
                startActivity(intent);
            }
        });
        cdkho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_choose_mode.this, main_play_quiz.class );
                String category = getIntent().getStringExtra("category");
                int idCategory = getIntent().getIntExtra("idCategory",1);
                if (category != null) {
                    intent.putExtra("category", category);
                    intent.putExtra("idCategory",idCategory);
                }
                intent.putExtra("level","Khó");
                intent.putExtra("idLevel",3);
                startActivity(intent);
            }
        });

    }
}