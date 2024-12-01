package com.example.finalproject_test.playquizs_Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.example.finalproject_test.DATA.Models.Question;
import com.example.finalproject_test.R;
import com.example.finalproject_test.Result;
import com.example.finalproject_test.main_play_quiz;

/**
 * Fragment này hiển thị các chức năng trong bài quiz.
 */
public class Play_quiz_fragment_10 extends Fragment {
    private Dialog dialog;
    private Button btnKetThuc, btnNext, btnLuilai;
    private TextView txtCauhoi;
    private AppCompatButton da1,da2,da3,da4;

    private Question question;
    private static final String ARG_QUESTION  = "arg_question";


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
    public static Play_quiz_fragment_10 receiveQuestion(Question question){
        Play_quiz_fragment_10 playQuizFragment10 = new Play_quiz_fragment_10();
        Bundle args = new Bundle();
        args.putSerializable(ARG_QUESTION, question);
        playQuizFragment10.setArguments(args);
        return playQuizFragment10;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            question = (Question) getArguments().getSerializable(ARG_QUESTION);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_quiz_10, container, false);

        txtCauhoi = view.findViewById(R.id.txtCauhoi10);
        da1 = view.findViewById(R.id.btnDapAn_10A);
        da2 = view.findViewById(R.id.btnDapAn_10B);
        da3 = view.findViewById(R.id.btnDapAn_10C);
        da4 = view.findViewById(R.id.btnDapAn_10D);


        txtCauhoi.setText(question.getQuestionText());
        da1.setText(question.getAnswers().get(0).getAnswerText().toString());
        da1.setTag(question.getAnswers().get(0).isCorrect());

        da2.setText(question.getAnswers().get(1).getAnswerText().toString());
        da2.setTag(question.getAnswers().get(1).isCorrect());

        da3.setText(question.getAnswers().get(2).getAnswerText().toString());
        da3.setTag(question.getAnswers().get(2).isCorrect());

        da4.setText(question.getAnswers().get(3).getAnswerText().toString());
        da4.setTag(question.getAnswers().get(3).isCorrect());

        da1.setOnClickListener(v->{
            //gọi ChonDungSai để kiểm tra tag xem đó đáp án đúng hay sai để đổi màu background
        });
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
    public void ChonDungSai(AppCompatButton choice){
        // Đổi màu green background appcompatbutton khi chọn đúng
        // Đổi màu red background appcompatbutton khi chọn sai


    }



}
