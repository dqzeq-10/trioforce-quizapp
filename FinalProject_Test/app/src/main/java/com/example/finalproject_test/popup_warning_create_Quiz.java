package com.example.finalproject_test;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.Button;

public class popup_warning_create_Quiz {
    public static void showWarningPopup(Context context) {
        // Tạo một đối tượng Dialog
        Dialog dialog = new Dialog(context, R.style.CustomDialog);

        // Cấu hình các thuộc tính của Dialog
        dialog.setCancelable(false);  // Không cho phép đóng popup ngoài vùng click
        dialog.setContentView(R.layout.dialog_warning_creat_quiz);  // Gán layout cho dialog

        // Lấy nút "Close" từ layout
        Button btnClose = dialog.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(view -> dialog.dismiss());  // Đóng popup khi bấm nút Close

        // Cấu hình kích thước của dialog
        dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        WindowManager.LayoutParams layoutParams1 = dialog.getWindow().getAttributes();
        layoutParams1.gravity = Gravity.CENTER;  // Đặt vị trí popup ở giữa màn hình
        layoutParams1.y = 10;  // Đặt vị trí theo chiều dọc (tùy chỉnh)
        dialog.getWindow().setAttributes(layoutParams1);

        // Hiển thị popup
        dialog.show();
    }
}
