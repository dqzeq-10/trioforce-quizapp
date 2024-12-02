package com.example.finalproject_test.playquizs_Fragments;

import android.os.Bundle;
import android.util.Log;
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
import com.example.finalproject_test.popup_warning_play_Quiz;

import java.io.Serializable;


public class Play_quiz_fragment_1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button btnNext, btnLuilai;
    private AppCompatButton da1, da2, da3, da4;
    private  TextView txtcauhoi;
    private  boolean  isAnswerSelected = false;

    private Question question;
    private  static final String ARG_QUESTION = "question";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Play_quiz_fragment_1() {

    }

    public static Play_quiz_fragment_1 newInstance(String param1, String param2) {
        Play_quiz_fragment_1 fragment = new Play_quiz_fragment_1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static Play_quiz_fragment_1 receiveQuestion(Question question) {
        Play_quiz_fragment_1 playQuizFragment1 = new Play_quiz_fragment_1();
        Bundle args = new Bundle();
        args.putSerializable(ARG_QUESTION, (Serializable) question);
        playQuizFragment1.setArguments(args);
        return playQuizFragment1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_quiz_1, container, false);

        question = (Question) getArguments().getSerializable(ARG_QUESTION);

        // Kiểm tra xem question có bị null không
        if (question == null) {
            Log.e("Play_quiz_fragment_1", "No question received.");
            return view; // Trả về view mà không làm gì thêm nếu không nhận được câu hỏi
        }

        btnLuilai = view.findViewById(R.id.btnLuiLai);
        btnNext = view.findViewById(R.id.btnTiepTuc);

       txtcauhoi = view.findViewById(R.id.txtCauhoi1);
        da1 = view.findViewById(R.id.btnDapAn_1A);
        da2 = view.findViewById(R.id.btnDapAn_1B);
        da3 = view.findViewById(R.id.btnDapAn_1C);
        da4 = view.findViewById(R.id.btnDapAn_1D);


        txtcauhoi.setText(question.getQuestionText());
        da1.setText(question.getAnswers().get(0).getAnswerText().toString());
        da1.setTag(question.getAnswers().get(0).isCorrect());
        Log.d("setTag", da1.getTag().toString());

        da2.setText(question.getAnswers().get(1).getAnswerText().toString());
        da2.setTag(question.getAnswers().get(1).isCorrect());
        Log.d("setTag", da2.getTag().toString());


        da3.setText(question.getAnswers().get(2).getAnswerText().toString());
        da3.setTag(question.getAnswers().get(2).isCorrect());
        Log.d("setTag", da3.getTag().toString());


        da4.setText(question.getAnswers().get(3).getAnswerText().toString());
        da4.setTag(question.getAnswers().get(3).isCorrect());
        Log.d("setTag", da4.getTag().toString());

        //xu ly su kien khi chon dap an
        View.OnClickListener answerClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAnswerSelected) return;

                int selectedAnswerId = v.getId();

                boolean isCorerct = checkAnswer(selectedAnswerId);

                changeAnswerButtonColor(selectedAnswerId, isCorerct);

                if (isCorerct){
                    if (getActivity() instanceof main_play_quiz) {
                        ((main_play_quiz) getActivity()).updateScore(10);  // Cộng 10 điểm
                    }
                }

                changeAnswerButtonColor(selectedAnswerId, isCorerct);

                // cap nhap mau sac cua tab trong activity
                int tabIndex = 0;
                if (getActivity() instanceof main_play_quiz) {
                    ((main_play_quiz) getActivity()).setTabBackgroundColor(tabIndex, isCorerct);

                }
                isAnswerSelected = true;
                disableOtherAnswer(selectedAnswerId);
            }

        };

        da1.setOnClickListener(answerClickListener);
        da2.setOnClickListener(answerClickListener);
        da3.setOnClickListener(answerClickListener);
        da4.setOnClickListener(answerClickListener);



        // Xử lý sự kiện khi nhấn nút "Lui lại" (quay lại fragment trước)
        btnLuilai.setOnClickListener(v -> {
            if (getActivity() instanceof main_play_quiz) {
                ((main_play_quiz) getActivity()).goToPreviousFragment();
            }
        });
// xu ly su kien khi nhan nut tiep tuc
        btnNext.setOnClickListener(v -> {
            if(!isAnswerSelected){
                popup_warning_play_Quiz.showWarningPopup(requireContext());
            }
            else {
                if (getActivity() instanceof main_play_quiz) {
                    ((main_play_quiz) getActivity()).goToNextFragment();
                }
            }
        });

        return view;
    }
    private boolean checkAnswer(int selectedAnswerId) {
      Button selectedButton = getView().findViewById(selectedAnswerId);
      boolean isCorrects =(boolean)   selectedButton.getTag();
      return  isCorrects;
    }
    private  void changeAnswerButtonColor(int selectedAnswerId, boolean isCorrect) {
        TextView selectedButton = getView().findViewById(selectedAnswerId);
        if (isCorrect) {
            selectedButton.setBackgroundResource(R.drawable.dung);
        } else {
            selectedButton.setBackgroundResource(R.drawable.sai);
        }
    }
    private  void disableOtherAnswer(int selectedAnswerId) {
        if (selectedAnswerId != R.id.btnDapAn_1A) da1.setEnabled(false);
        if (selectedAnswerId != R.id.btnDapAn_1B) da2.setEnabled(false);
        if (selectedAnswerId != R.id.btnDapAn_1C) da3.setEnabled(false);
        if (selectedAnswerId != R.id.btnDapAn_1D) da4.setEnabled(false);
    }

}