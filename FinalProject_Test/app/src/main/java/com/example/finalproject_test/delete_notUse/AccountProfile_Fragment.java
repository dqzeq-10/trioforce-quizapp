//package com.example.finalproject_test;
//
//import android.app.Dialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//public class AccountProfile_Fragment extends AppCompatActivity {
//    Dialog dialog_email, dialog_Phone, dialog_Success;
//    Button btn_XacNhan_email, btn_Huy_email, btn_Huy_phone, btn_xacNhan_phone, btndangxuat;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_catagories_choose);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//
//        setupEmailDialog();
//        setupPhoneDialog();
//        setupSuccessDialog();
//
//
//
//        btndangxuat = findViewById(R.id.btnDangXuat);
//        btndangxuat.setOnClickListener(view -> {
//            Intent it = new Intent(AccountProfile_Fragment.this, LoginORSignup.class);
//            startActivity(it);
//            finish();
//        });
//
//
//        TextView txtTd = findViewById(R.id.txt_Change_email);
//        txtTd.setOnClickListener(view -> dialog_email.show());
//
//
//        TextView txtchange = findViewById(R.id.txt_change_phone);
//        txtchange.setOnClickListener(view -> dialog_Phone.show());
//    }
//
//
//    private void setupEmailDialog() {
//        dialog_email = new Dialog(AccountProfile_Fragment.this);
//        dialog_email.setContentView(R.layout.dialog_change_email);
//        dialog_email.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog_email.getWindow().setBackgroundDrawable(getDrawable(R.drawable.bg_change_email));
//        dialog_email.setCancelable(false);
//
//        btn_Huy_email = dialog_email.findViewById(R.id.btn_H);
//        btn_XacNhan_email = dialog_email.findViewById(R.id.btn_XN);
//
//        btn_Huy_email.setOnClickListener(view -> dialog_email.dismiss());
//
//        btn_XacNhan_email.setOnClickListener(view -> {
//            dialog_email.dismiss();
//            dialog_Success.show();
//        });
//    }
//
//    // Setup phone dialog
//    private void setupPhoneDialog() {
//        dialog_Phone = new Dialog(AccountProfile_Fragment.this);
//        dialog_Phone.setContentView(R.layout.dialog_change_phonenumber);
//        dialog_Phone.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog_Phone.getWindow().setBackgroundDrawable(getDrawable(R.drawable.bg_change_email));
//        dialog_Phone.setCancelable(false);
//
//        btn_Huy_phone = dialog_Phone.findViewById(R.id.btn_H);
//        btn_xacNhan_phone = dialog_Phone.findViewById(R.id.btn_XN);
//
//        btn_Huy_phone.setOnClickListener(view -> dialog_Phone.dismiss());
//
//        btn_xacNhan_phone.setOnClickListener(view -> {
//            dialog_Phone.dismiss();
//            dialog_Success.show();
//        });
//    }
//
//
//    private void setupSuccessDialog() {
//        dialog_Success = new Dialog(AccountProfile_Fragment.this);
//        dialog_Success.setContentView(R.layout.dialog_success);
//        dialog_Success.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog_Success.getWindow().setBackgroundDrawable(getDrawable(R.drawable.bg_change_email));
//        dialog_Success.setCancelable(true);
//    }
//}
