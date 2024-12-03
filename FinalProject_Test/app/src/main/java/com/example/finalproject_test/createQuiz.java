package com.example.finalproject_test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.finalproject_test.screenfragment.mainscreen_fragment;

public class createQuiz extends AppCompatActivity {
    ImageButton thoatbtn;
    Button btnNext;
    EditText tenBoCauHoi;
    Spinner cate, lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        thoatbtn = findViewById(R.id.thoat);
        btnNext =  findViewById(R.id.btnNext);
        cate = findViewById(R.id.spinnercate);
        lv = findViewById(R.id.spinnerlv);
        tenBoCauHoi = findViewById(R.id.tenChuDe);



        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(createQuiz.this,main_create_quiz.class);
                //truyền dữ liệu (tên bộ câu hỏi, tên thể loại, tên độ khó)
                it.putExtra("QSName",tenBoCauHoi.getText().toString().trim());
                it.putExtra("QSLevel",lv.getSelectedItemPosition());
                it.putExtra("QSCate",cate.getSelectedItemPosition());
                it.putExtra("username",  getIntent().getStringExtra("username"));
             //   Toast.makeText(createQuiz.this, tenBoCauHoi.getText().toString().trim()+lv.getSelectedItemPosition()+cate.getSelectedItemPosition(), Toast.LENGTH_LONG).show();
                Log.d("postset", "createquiz sang main_creatquiz");
                startActivity(it);
            }
        });

        //quay lại, hủy tạo
        thoatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(createQuiz.this, MainScreen.class);
                startActivity(intent);
            }
        });
    }
}