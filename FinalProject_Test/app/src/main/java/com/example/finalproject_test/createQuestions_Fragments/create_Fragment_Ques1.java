package com.example.finalproject_test.createQuestions_Fragments;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalproject_test.DATA.Models.Answer;
import com.example.finalproject_test.DATA.Models.Question;
import com.example.finalproject_test.DATA.ViewModels.SharedVM.SQASharedViewModel;
import com.example.finalproject_test.R;

import com.example.finalproject_test.main_create_quiz;

import java.util.ArrayList;
import java.util.List;
import com.example.finalproject_test.popup_warning_create_Quiz;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link create_Fragment_Ques1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class create_Fragment_Ques1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button btnNext;
    private EditText cauhoi, da1, da2, da3, da4;
    private CheckBox chb1, chb2, chb3, chb4;
    private String originalQuestionText, originalDa1, originalDa2, originalDa3, originalDa4;
    private boolean originalChb1, originalChb2, originalChb3, originalChb4;

    private SQASharedViewModel sqaSharedViewModel;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public create_Fragment_Ques1() {
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
    public static create_Fragment_Ques1 newInstance(String param1, String param2) {
        create_Fragment_Ques1 fragment = new create_Fragment_Ques1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create___ques1, container, false);


        sqaSharedViewModel = new ViewModelProvider(requireActivity()).get(SQASharedViewModel.class);

        cauhoi = view.findViewById(R.id.cauhoi1);

        da1 = view.findViewById(R.id.dapan1A);
        chb1 = view.findViewById(R.id.check1A);

        da2 = view.findViewById(R.id.dapan1B);
        chb2 = view.findViewById(R.id.check1B);

        da3 = view.findViewById(R.id.dapan1C);
        chb3 = view.findViewById(R.id.check1C);

        da4 = view.findViewById(R.id.dapan1D);
        chb4 = view.findViewById(R.id.check1D);

        btnNext = view.findViewById(R.id.btnNext);

        saveOriginalState();


        // Xử lý sự kiện khi bấm nút "Tiếp tục"
        btnNext.setOnClickListener(v -> {
            //nhắc điền câu hỏi và câu trả lời mới sang tiếp theo
//            if (cauhoi.getText().toString().trim().isEmpty() || da1.getText().toString().trim().isEmpty() || da2.getText().toString().trim().isEmpty() || da3.getText().toString().trim().isEmpty() || da4.getText().toString().trim().isEmpty()) {
//            Toast.makeText(getActivity(),"Điền thiếu câu hỏi hoặc câu trả lời!",Toast.LENGTH_SHORT).show();
//                return;
//            }
            //nhắc chọn ít nhất 1 đáp án đúng
//            if (!chb1.isChecked() && !chb2.isChecked() && !chb3.isChecked() && !chb4.isChecked()) {
//                Toast.makeText(getActivity(),"Tích chọn ít nhất một câu trả lời đúng!",Toast.LENGTH_SHORT).show();
//                return;
//            }

            Question question = new Question();
            question.setQuestionText(cauhoi.getText().toString().trim());
            List<Answer> answers = new ArrayList<>();
            answers.add(new Answer(da1.getText().toString().trim(), chb1.isChecked()));
            answers.add(new Answer(da2.getText().toString().trim(), chb2.isChecked()));
            answers.add(new Answer(da3.getText().toString().trim(), chb3.isChecked()));
            answers.add(new Answer(da4.getText().toString().trim(), chb4.isChecked()));
            question.setAnswers(answers);


            if (isQuestionChanged(question)) {

                boolean isQuestionExists = false;
                if (sqaSharedViewModel.getSetLiveData() != null && sqaSharedViewModel.getSetLiveData().getValue() != null) {
                    for (Question existingQuestion : sqaSharedViewModel.getSetLiveData().getValue().getQuestions()) {
                        if (existingQuestion.getQuestionText().equals(question.getQuestionText())) {
                            isQuestionExists = true;
                            break;
                        }
                    }
                }

                if (!isQuestionExists) {
                    sqaSharedViewModel.addQuestion(question);
                    Log.d("postSet", "Đã thêm câu hỏi vào Set");
                }
            }

//            if (sqaSharedViewModel.getSetLiveData()!=null){
//                //Toast.makeText(getContext(),"f1 da co du lieu", Toast.LENGTH_LONG).show();
//                Log.d("postset", "f1 da co du lieu");
//                Log.d("postset", sqaSharedViewModel.getSetLiveData().getValue().getQuestions().get(0).getQuestionText().toString());
//                Log.d("postset", sqaSharedViewModel.getSetLiveData().getValue().getQuestions().get(0).getAnswers().get(0).getAnswerText().toString());
//                Log.d("postset", sqaSharedViewModel.getSetLiveData().getValue().getQuestions().get(0).getAnswers().get(1).getAnswerText().toString());
//                Log.d("postset", sqaSharedViewModel.getSetLiveData().getValue().getQuestions().get(0).getAnswers().get(2).getAnswerText().toString());
//                Log.d("postset", sqaSharedViewModel.getSetLiveData().getValue().getQuestions().get(0).getAnswers().get(3).getAnswerText().toString());
//
//            }


            if (getActivity() instanceof main_create_quiz) {
                ((main_create_quiz) getActivity()).goToNextFragment();
            }

        popup_warning_create_Quiz.showWarningPopup(requireContext());

        });

        return view;
    }

    private void saveOriginalState() {
        originalQuestionText = cauhoi.getText().toString().trim();
        originalDa1 = da1.getText().toString().trim();
        originalDa2 = da2.getText().toString().trim();
        originalDa3 = da3.getText().toString().trim();
        originalDa4 = da4.getText().toString().trim();
        originalChb1 = chb1.isChecked();
        originalChb2 = chb2.isChecked();
        originalChb3 = chb3.isChecked();
        originalChb4 = chb4.isChecked();
    }

    // Kiểm tra câu hỏi và đáp án có thay đổi không
    private boolean isQuestionChanged(Question question) {
        return !question.getQuestionText().equals(originalQuestionText) ||
                !da1.getText().toString().trim().equals(originalDa1) ||
                !da2.getText().toString().trim().equals(originalDa2) ||
                !da3.getText().toString().trim().equals(originalDa3) ||
                !da4.getText().toString().trim().equals(originalDa4) ||
                chb1.isChecked() != originalChb1 ||
                chb2.isChecked() != originalChb2 ||
                chb3.isChecked() != originalChb3 ||
                chb4.isChecked() != originalChb4;
    }

}