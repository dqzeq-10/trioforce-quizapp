package com.example.finalproject_test.createQuestions_Fragments;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.finalproject_test.DATA.Models.Answer;
import com.example.finalproject_test.DATA.Models.Question;
import com.example.finalproject_test.DATA.Models.QuestionSet;
import com.example.finalproject_test.DATA.ViewModels.QuestionSetsVM.QuestionSetsViewModel;
import com.example.finalproject_test.DATA.ViewModels.SharedVM.SQASharedViewModel;
import com.example.finalproject_test.MainScreen;
import com.example.finalproject_test.R;
import com.example.finalproject_test.main_create_quiz;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link create_Fragment_Ques10#newInstance} factory method to
 * create an instance of this fragment.
 */
public class create_Fragment_Ques10 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button btnLuilai, btnfinish;
    private EditText cauhoi, da1, da2, da3, da4;
    private CheckBox chb1, chb2, chb3, chb4;
    private String originalQuestionText, originalDa1, originalDa2, originalDa3, originalDa4;
    private boolean originalChb1, originalChb2, originalChb3, originalChb4;

    private SQASharedViewModel sqaSharedViewModel;

    public create_Fragment_Ques10() {
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
    public static create_Fragment_Ques10 newInstance(String param1, String param2) {
        create_Fragment_Ques10 fragment = new create_Fragment_Ques10();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create___ques10, container, false);
        sqaSharedViewModel = new ViewModelProvider(requireActivity()).get(SQASharedViewModel.class);

        cauhoi = view.findViewById(R.id.cauhoi10);

        da1 = view.findViewById(R.id.dapan10A);
        chb1 = view.findViewById(R.id.check10A);

        da2 = view.findViewById(R.id.dapan10B);
        chb2 = view.findViewById(R.id.check10B);

        da3 = view.findViewById(R.id.dapan10C);
        chb3 = view.findViewById(R.id.check10C);

        da4 = view.findViewById(R.id.dapan10D);
        chb4 = view.findViewById(R.id.check10D);

        btnLuilai = view.findViewById(R.id.btnLuiLai);
        btnfinish = view.findViewById(R.id.btnFinish);


        // Xử lý sự kiện khi bấm nút "Lui lại"
        btnLuilai.setOnClickListener(v -> {
            if (getActivity() instanceof main_create_quiz) {
                ((main_create_quiz) getActivity()).goToPreviousFragment();
            }
        });

        //finish
        btnfinish.setOnClickListener(v -> {
                Log.d("DEBUG_BTN", "Button Finish Clicked");


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
            Log.d("QuestionSet", "Set hiện tại: " + new Gson().toJson(sqaSharedViewModel.getSetLiveData().getValue()));

            QuestionSet set = sqaSharedViewModel.getSetLiveData().getValue();
            Log.d("DEBUG_POST", "Sending POST Request");

            if (set != null) {
            //    Toast.makeText(getActivity(), "set!=null, bắt đầu gửi postSet ..", Toast.LENGTH_SHORT).show();
                //gửi postSet(QuestionSet sqaSharedViewModel) tới api
                QuestionSetsViewModel setsViewModel = new ViewModelProvider(requireActivity()).get(QuestionSetsViewModel.class);
                setsViewModel.postSet(set).observe(getViewLifecycleOwner(), success -> {
                    if (success) {
                        Toast.makeText(getActivity(), "Tạo thành công!", Toast.LENGTH_SHORT).show();
                        //chuyen ve man hinh chinh
                        Intent intent = new Intent(getActivity(), MainScreen.class);
                        startActivity(intent);
                        if (getActivity() != null) {
                            getActivity().finish();
                        }
                    } else {
                        Toast.makeText(getActivity(), "Đã xảy ra lỗi. Vui lòng thử lại.", Toast.LENGTH_SHORT).show();
                    }
                    Log.d("DEBUG_API", "Post Response Success: " + success);

                });
            }
            if (set == null) {
                Toast.makeText(getActivity(), "Bộ câu hỏi chưa được tạo.", Toast.LENGTH_SHORT).show();

            }


//            Toast.makeText(getActivity(), "Tạo thành công!", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(getActivity(), MainScreen.class);
//            startActivity(intent);
//
//            if (getActivity() != null) {
//                getActivity().finish();
//            }
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