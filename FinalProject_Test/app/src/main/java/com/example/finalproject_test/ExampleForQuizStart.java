/*package com.example.finalproject_test;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExampleForQuizStart extends AppCompatActivity {
    Dialog dialog;
    TextView btn_dialogLuuThoat, btn_dialogHuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_example_for_quiz_start);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
       ImageButton btnBack = findViewById(R.id.imagebtnBack);
       btnBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               dialog.show();
           }
       });


        dialog = new Dialog(ExampleForQuizStart.this);
        dialog.setContentView(R.layout.dialog_out_quiz);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.incomple));
        dialog.setCancelable(false);

        btn_dialogHuy= dialog.findViewById(R.id.txtHuy);
        btn_dialogLuuThoat= dialog.findViewById(R.id.txtLuuVaThoat);

        btn_dialogHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btn_dialogLuuThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(ExampleForQuizStart.this, MainScreen.class);
                startActivity(it);
                finish();
                Toast.makeText(ExampleForQuizStart.this,"Đã luu thành công ",Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

       AppCompatButton btnTiepTuc = findViewById(R.id.btnTiepTuc);

       btnTiepTuc.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent it = new Intent(ExampleForQuizStart.this, ExampleQuizPlayWithTopic2.class)   ;
               startActivity(it);

           }
       });


    }
}


 */