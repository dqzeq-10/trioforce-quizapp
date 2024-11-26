package com.example.finalproject_test;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class popup_comfirm_delete {
    private final Dialog dialog;
    private final OnPopupActionListener listener;

    public interface OnPopupActionListener {
        void onConfirm(); // Khi nhấn OK
        void onCancel();  // Khi nhấn Hủy
    }

    public popup_comfirm_delete(Context context, OnPopupActionListener listener) {
        this.dialog = new Dialog(context);
        this.listener = listener;


        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        dialog.setContentView(R.layout.activity_popup_comfirm_delete);
        dialog.setCancelable(false); // Không cho phép tắt khi nhấn ra ngoài

        // Ánh xạ view trong layout
        TextView tvTitle = dialog.findViewById(R.id.tvPopupTitle);
        TextView tvMessage = dialog.findViewById(R.id.tvPopupMessage);
        Button btnCancel = dialog.findViewById(R.id.btnPopupCancel);
        Button btnConfirm = dialog.findViewById(R.id.btnPopupConfirm);

        // Xử lý sự kiện nút Hủy
        btnCancel.setOnClickListener(v -> {
            listener.onCancel();
            dialog.dismiss();
        });

        // Xử lý sự kiện nút OK
        btnConfirm.setOnClickListener(v -> {
            listener.onConfirm();
            dialog.dismiss();
        });
    }

    // Hiển thị popup
    public void show() {
        dialog.show();
    }
}
