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
        tenBoCauHoi = findViewById(R.id.tenbocauhoi);



        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String quizName = tenBoCauHoi.getText().toString().trim();
                String category = cate.getSelectedItem().toString();
                String level = lv.getSelectedItem().toString();
                if (quizName.isEmpty() && category.equals("Chọn thể loại") && level.equals("Chọn độ khó")) {
                    // Nếu tất cả các trường đều trống hoặc Chọn giá trị mặc định
                    Toast.makeText(createQuiz.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                } else if (quizName.isEmpty() && category.equals("Chọn thể loại") && !level.equals("Chọn độ khó")) {
                    // Nếu quizName trống và category Chọn "Chọn thể loại", level hợp lệ
                    Toast.makeText(createQuiz.this, "Vui lòng nhập tên quiz và Chọn thể loại", Toast.LENGTH_SHORT).show();
                    return;
                } else if (quizName.isEmpty() && !category.equals("Chọn thể loại") && level.equals("Chọn độ khó")) {
                    // Nếu quizName trống và category hợp lệ, level Chọn "Chọn độ khó"
                    Toast.makeText(createQuiz.this, "Vui lòng nhập tên quiz và Chọn độ khó", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!quizName.isEmpty() && category.equals("Chọn thể loại") && level.equals("Chọn độ khó")) {
                    // Nếu quizName hợp lệ nhưng category và level đều Chọn giá trị mặc định
                    Toast.makeText(createQuiz.this, "Vui lòng Chọn thể loại và mức độ", Toast.LENGTH_SHORT).show();
                    return;
                } else if (quizName.isEmpty()) {
                    // Nếu chỉ quizName trống
                    Toast.makeText(createQuiz.this, "Vui lòng nhập tên quiz", Toast.LENGTH_SHORT).show();
                    return;
                } else if (category.equals("Chọn thể loại")) {
                    // Nếu chỉ category Chọn "Chọn thể loại"
                    Toast.makeText(createQuiz.this, "Vui lòng Chọn thể loại", Toast.LENGTH_SHORT).show();
                    return;
                } else if (level.equals("Chọn độ khó")) {
                    // Nếu chỉ level Chọn "Chọn độ khó"
                    Toast.makeText(createQuiz.this, "Vui lòng Chọn độ khó", Toast.LENGTH_SHORT).show();
                    return;
                }

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