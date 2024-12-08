package com.example.finalproject_test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.finalproject_test.DATA.InterfaceAPI.RankingApi.IRankingApi;
import com.example.finalproject_test.DATA.InterfaceAPI.RetrofitService;
import com.example.finalproject_test.DATA.InterfaceAPI.UserApi.IUsersApi;
import com.example.finalproject_test.DATA.Models.Ranking;
import com.example.finalproject_test.DATA.Models.User;
import com.example.finalproject_test.DATA.ViewModels.RanksVM.RanksViewModel;
import com.example.finalproject_test.DATA.ViewModels.UsersVM.UsersViewModel;
import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activity_signup extends AppCompatActivity {
    Button btnDK;
    TextInputEditText etUsername, etEmail, etSDT, etNS, etMK, etXNMK;
    RadioGroup chonGioitinh;
    TextView tvDN;

    private UsersViewModel usersViewModel;
    private RanksViewModel ranksViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etSDT = findViewById(R.id.etSDT);
        etNS = findViewById(R.id.etNgaysinh);
        chonGioitinh = (RadioGroup) findViewById(R.id.rgChonGioiTinhDK);
        etMK = findViewById(R.id.etMK);
        etXNMK = findViewById(R.id.etXNMK);

        btnDK = (Button) findViewById(R.id.buttonDangKy);
        tvDN = (TextView) findViewById(R.id.formDangNhap);
        tvDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyensangDangNhap = new Intent(activity_signup.this, login_activity.class);
                startActivity(chuyensangDangNhap);
            }
        });

        RadioButton rgNam = findViewById(R.id.radioButtonMale), rgNu = findViewById(R.id.radioButtonFemale);
        usersViewModel = new ViewModelProvider(this).get(UsersViewModel.class);
        ranksViewModel = new ViewModelProvider(this).get(RanksViewModel.class);

        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etUsername.getText().toString().trim();
                String name = "A";
                String email = etEmail.getText().toString().trim();
                String sdt = etSDT.getText().toString().trim();
                String ngaysinh = etNS.getText().toString().trim();
                Boolean gioitinh = (chonGioitinh.getCheckedRadioButtonId() == R.id.radioButtonMale ? true : false);

                String mk = etMK.getText().toString().trim();
                String xnmk = etXNMK.getText().toString().trim();

                if (!xnmk.equals(mk) || username.isEmpty() || email.isEmpty() || sdt.isEmpty() || ngaysinh.isEmpty() || mk.isEmpty() || xnmk.isEmpty()) {
                    Toast.makeText(activity_signup.this, "Điền thiếu hoặc sai!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Date ngaysinhDate = null;
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    ngaysinhDate = formatter.parse(ngaysinh);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                User userDk = new User(username, mk, name, email, sdt, gioitinh, ngaysinhDate);

                usersViewModel.postUser(userDk).observe(activity_signup.this, thongbao -> {
                    if (thongbao != null && thongbao) {
                        Toast.makeText(activity_signup.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                        addUserToRanking(username, 0);
                    } else {
                        Toast.makeText(activity_signup.this, "Đăng ký thất bạn", Toast.LENGTH_SHORT).show();
                        Log.d("SIGNUP", "thongbao tra ve null ");
                    }


                });

                Intent chuyensangDN = new Intent(activity_signup.this, login_activity.class);
                startActivity(chuyensangDN);
                //      Toast.makeText(activity_signup.this, "Đăng nhập thành công!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void addUserToRanking(String username, int points) {
        Ranking newRanking = new Ranking(username, points);

        ranksViewModel.postRank(newRanking).observe(this, success -> {
            if (success != null && success) {
                Toast.makeText(getApplicationContext(), "Cập nhật bảng xếp hạng thành công!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Lỗi cập nhật bảng xếp hạng!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}