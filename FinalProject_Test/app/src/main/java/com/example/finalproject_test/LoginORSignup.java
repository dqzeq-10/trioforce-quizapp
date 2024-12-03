package com.example.finalproject_test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.finalproject_test.DATA.Models.MarkedQuestion;
import com.example.finalproject_test.DATA.ViewModels.MarkedQuestionVM.MarkedQuestionViewModel;

public class LoginORSignup extends AppCompatActivity {
    Button btnDN,btnDK;
    private MarkedQuestionViewModel markedQuestionViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_orsignup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnDN=(Button) findViewById(R.id.btnDangNhap);
        btnDK=(Button) findViewById(R.id.btnDangKy);
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginORSignup.this, login_activity.class);
                startActivity(intent);
            }
        });
        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(LoginORSignup.this, activity_signup.class);
                startActivity(intent2);
            }
        });
    markedQuestionViewModel = new ViewModelProvider(this).get(MarkedQuestionViewModel.class);
    markedQuestionViewModel.getMarkedQuestions().observe(this, markedQuestions -> {
    if(markedQuestions!=null && !markedQuestions.isEmpty()){
        for (MarkedQuestion mq: markedQuestions
             ) {
            Log.d("MQuestion", "onCreate"+ mq.getUsername());
        }
    }
    else {
        Log.d("MQuestion", "No MarkedQuestions found");
    }
    });
    }
}