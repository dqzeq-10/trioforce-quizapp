package com.example.finalproject_test;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login_activity extends AppCompatActivity {
    TextView tvDK;
    Button btnDN;
    CheckBox cbXemMK;
    EditText edtMK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvDK=(TextView) findViewById(R.id.formDangKy);
        btnDN=(Button) findViewById(R.id.buttonDangNhap);
        cbXemMK=(CheckBox) findViewById(R.id.show_password);
        edtMK=(EditText) findViewById(R.id.edt_MatKhau);
        tvDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyensangDangKy = new Intent(login_activity.this, activity_signup.class);
                startActivity(chuyensangDangKy);
            }
        });
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyensangManHinhChinh = new Intent(login_activity.this, MainScreen.class);
                Toast.makeText(login_activity.this, "Đăng nhập thành công!!", Toast.LENGTH_SHORT).show();
                startActivity(chuyensangManHinhChinh);
            }
        });
        cbXemMK.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked)
                edtMK.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            else
                edtMK.setTransformationMethod(PasswordTransformationMethod.getInstance());
        });
    }
    private void showPopupWarning() {

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_warning_login);

        // Để nền dialog trong suốt
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Button btnClose = dialog.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(v -> dialog.dismiss());


        dialog.show();
    }
}
