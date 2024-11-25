package com.example.finalproject_test.playquizs_Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.finalproject_test.R;
import com.example.finalproject_test.Result;
import com.example.finalproject_test.main_play_quiz;

/**
 * Fragment này hiển thị các chức năng trong bài quiz.
 */
public class Play_quiz_fragment_10 extends Fragment {
    private Dialog dialog;
    private Button btnKetThuc, btnNext, btnLuilai;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Play_quiz_fragment_10() {
        // Constructor mặc định
    }

    public static Play_quiz_fragment_10 newInstance(String param1, String param2) {
        Play_quiz_fragment_10 fragment = new Play_quiz_fragment_10();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_quiz_10, container, false);

        // Khởi tạo các nút
        btnLuilai = view.findViewById(R.id.btnLuiLai);
        btnKetThuc = view.findViewById(R.id.btnFinish);

        // Xử lý sự kiện khi nhấn nút "Lui lại" (quay lại fragment trước)
        btnLuilai.setOnClickListener(v -> {
            if (getActivity() instanceof main_play_quiz) {
                ((main_play_quiz) getActivity()).goToPreviousFragment();
            }
        });

        // Xử lý sự kiện khi nhấn nút "Kết thúc" (chuyển sang màn hình kết quả)
        btnKetThuc.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), Result.class);
            startActivity(intent);
        });
        return view;
    }


}
