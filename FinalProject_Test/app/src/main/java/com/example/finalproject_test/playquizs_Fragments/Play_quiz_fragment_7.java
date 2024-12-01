package com.example.finalproject_test.playquizs_Fragments;

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
import com.example.finalproject_test.main_play_quiz;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Play_quiz_fragment_7#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Play_quiz_fragment_7 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button btnNext, btnLuilai;
    private TextView txtCauhoi;
    private AppCompatButton da1,da2,da3,da4;

    private Question question;
    private static final String ARG_QUESTION  = "arg_question";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Play_quiz_fragment_7() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment create_Fragment_Ques1.
     */
    // TODO: Rename and change types and number of parameters
    public static Play_quiz_fragment_7 newInstance(String param1, String param2) {
        Play_quiz_fragment_7 fragment = new Play_quiz_fragment_7();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static Play_quiz_fragment_7 receiveQuestion(Question question){
        Play_quiz_fragment_7 playQuizFragment7 = new Play_quiz_fragment_7();
        Bundle args = new Bundle();
        args.putSerializable(ARG_QUESTION, question);
        playQuizFragment7.setArguments(args);
        return playQuizFragment7;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            question = (Question) getArguments().getSerializable(ARG_QUESTION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_quiz_7, container, false);



        txtCauhoi = view.findViewById(R.id.txtCauhoi7);
        da1 = view.findViewById(R.id.btnDapAn_7A);
        da2 = view.findViewById(R.id.btnDapAn_7B);
        da3 = view.findViewById(R.id.btnDapAn_7C);
        da4 = view.findViewById(R.id.btnDapAn_7D);

        btnLuilai = view.findViewById(R.id.btnLuiLai);
        btnNext = view.findViewById(R.id.btnTiepTuc);

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

        // Xử lý sự kiện khi nhấn nút "Lui lại" (quay lại fragment trước)
        btnLuilai.setOnClickListener(v -> {
            if (getActivity() instanceof main_play_quiz) {
                ((main_play_quiz) getActivity()).goToPreviousFragment();
            }
        });

        // Xử lý sự kiện khi bấm nút "Tiếp tục"
        btnNext.setOnClickListener(v -> {
            // Gọi phương thức từ Activity để chuyển đến Fragment tiếp theo
            if (getActivity() instanceof main_play_quiz) {
                ((main_play_quiz) getActivity()).goToNextFragment();
            }
        });

        return view;
    }

    public void ChonDungSai(AppCompatButton choice){
        // Đổi màu green background appcompatbutton khi chọn đúng
        // Đổi màu red background appcompatbutton khi chọn sai


    }



}