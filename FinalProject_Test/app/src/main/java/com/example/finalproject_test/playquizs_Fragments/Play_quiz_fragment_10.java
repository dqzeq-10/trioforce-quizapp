package com.example.finalproject_test.playquizs_Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.finalproject_test.DATA.Models.MarkedQuestion;
import com.example.finalproject_test.DATA.Models.Question;
import com.example.finalproject_test.DATA.ViewModels.MarkedQuestionsVM.MarkedQuestionsViewModel;
import com.example.finalproject_test.R;
import com.example.finalproject_test.main_play_quiz;
import com.example.finalproject_test.popup_warning_play_Quiz;


public class Play_quiz_fragment_10 extends Fragment {
    private Dialog dialog;
    private Button btnKetThuc, btnNext, btnLuilai;

    private TextView txtCauhoi;
    private AppCompatButton da1,da2,da3,da4;
    private CheckBox btn_save;
    private Boolean isCorrectChoice, isNewPl;
    private String cate, leve, username;
    private int idCate, idLeve;

    private Question question;
    private static final String ARG_QUESTION  = "arg_question";

    private  boolean  isAnswerSelected = false;

    private View view;
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

    public static Play_quiz_fragment_10 receiveQuestion10 (Question question, int idCategory,int idLevel,String category,String level, Boolean isNewPlay, String username) {
        Play_quiz_fragment_10 playQuizFragment10 = new Play_quiz_fragment_10();
        Bundle args = new Bundle();
        args.putSerializable(ARG_QUESTION, question);
        if (idCategory != -1) {
            args.putInt("idCategory",idCategory);
        }
        if (idLevel != -1) {
            args.putInt("idLevel",idLevel);
        }
        if (category != null) {
            args.putString("category",category);
        }
        if (level != null) {
            args.putString("level",level);
        }

        if (isNewPlay != null) {
            args.putBoolean("isNewPlay",isNewPlay);
        }
        if (username != null) {
            args.putString("username",username);
        }
        playQuizFragment10.setArguments(args);
        return playQuizFragment10;
    }
    public static Play_quiz_fragment_10 receiveQuestion(Question question, @Nullable Boolean isCorrectChoice) {
        Play_quiz_fragment_10 playQuizFragment10 = new Play_quiz_fragment_10();
        Bundle args = new Bundle();
        args.putSerializable(ARG_QUESTION, question);
        if (isCorrectChoice != null) {
            args.putBoolean("isCorrectChoice", isCorrectChoice);
        }
        playQuizFragment10.setArguments(args);
        return playQuizFragment10;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            question = (Question) getArguments().getSerializable(ARG_QUESTION);
            if (getArguments().containsKey("isCorrectChoice")) {
                isCorrectChoice = getArguments().getBoolean("isCorrectChoice");
            }
            if (getArguments().containsKey("idCategory")) {
                idCate = getArguments().getInt("idCategory");
            }
            if (getArguments().containsKey("idLevel")) {
                idLeve = getArguments().getInt("idLevel");
            }
            if (getArguments().containsKey("category")) {
                cate = getArguments().getString("category");
            }
            if (getArguments().containsKey("level")) {
                leve = getArguments().getString("level");
            }
            if (getArguments().containsKey("isNewPlay")) {
                isNewPl = getArguments().getBoolean("isNewPlay");
            }
            if (getArguments().containsKey("username")) {
                username = getArguments().getString("username");
            }

        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_quiz_10, container, false);
        btn_save = view.findViewById(R.id.cbbookmark10);

        txtCauhoi = view.findViewById(R.id.txtCauhoi10);
        da1 = view.findViewById(R.id.btnDapAn_10A);
        da2 = view.findViewById(R.id.btnDapAn_10B);
        da3 = view.findViewById(R.id.btnDapAn_10C);
        da4 = view.findViewById(R.id.btnDapAn_10D);
        // Khởi tạo các nút
        btnLuilai = view.findViewById(R.id.btnLuiLai);
        btnKetThuc = view.findViewById(R.id.btnFinish);
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

        btn_save.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.d("CheckBox", "Clicked!");

            if (isChecked) {
                Log.d("CheckBox", "Click true!");

                //khởi tạo và gọi post để lưu vào MarkedQuestion
                MarkedQuestionsViewModel markedQuestionsViewModel = new ViewModelProvider(this).get(MarkedQuestionsViewModel.class);
                markedQuestionsViewModel.postMarkedQuestion(new MarkedQuestion(username, question.getIdQuestion())).observe(getViewLifecycleOwner(), thongbao -> {
                    if (thongbao != null && thongbao) {
                        Toast.makeText(getContext(), "Đã thêm câu hỏi vào Đã lưu!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Không thể thêm câu hỏi vào Đã lưu!", Toast.LENGTH_SHORT).show();
                        Log.d("checkboxBookmark", "Thông báo false or null: ");
                    }
                });

            } else {
                Log.d("CheckBox", "Click false!");
                //khởi tạo và gọi delete để xoa khoi MarkedQuestion
                MarkedQuestionsViewModel markedQuestionsViewModel = new ViewModelProvider(this).get(MarkedQuestionsViewModel.class);
                markedQuestionsViewModel.deleteMarkedQuestion(username, question.getIdQuestion()).observe(getViewLifecycleOwner(), thongbao -> {
                    if (thongbao != null && thongbao) {
                        Toast.makeText(getContext(), "Đã xóa câu hỏi khỏi Đã lưu!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Không thể xóa câu hỏi khởi Đã lưu!", Toast.LENGTH_SHORT).show();
                        Log.d("checkboxBookmark", "Thông báo false or null: ");
                    }
                });
                ;

            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);







        if (getArguments() != null && getArguments().containsKey("isCorrectChoice")) {
            boolean isCorrectChoice = getArguments().getBoolean("isCorrectChoice");
            int selectedAnswerId = -1; // Khởi tạo biến selectedAnswerId
            // Xác định ID của đáp án đã chọn
            if (da1.getTag().equals(isCorrectChoice)) {
                selectedAnswerId = da1.getId();
            } else if (da2.getTag().equals(isCorrectChoice)) {
                selectedAnswerId = da2.getId();
            } else if (da3.getTag().equals(isCorrectChoice)) {
                selectedAnswerId = da3.getId();
            } else if (da4.getTag().equals(isCorrectChoice)) {
                selectedAnswerId = da4.getId();
            }
            if (selectedAnswerId != -1) {
                changeAnswerButtonColor(selectedAnswerId, isCorrectChoice);
                disableOtherAnswer(selectedAnswerId);
                isAnswerSelected = true;
            }
        }
        View.OnClickListener answerClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAnswerSelected) return;
                // lay id cua dap an duoc chon
                int selectedAnswerId = v.getId();
                //kiem tra dap an duoc chon co dung hay sai
                boolean isCorerct = checkAnswer(selectedAnswerId);

                //thay doi mau sac cua dap an duoc chon
                changeAnswerButtonColor(selectedAnswerId, isCorerct);

                if (isCorerct){
                    if (getActivity() instanceof main_play_quiz) {
                        ((main_play_quiz) getActivity()).updateScore(10);  // Cộng 10 điểm
                    }
                }


                // cap nhap mau sac cua tab trong activity
                int tabIndex = 9;
                if (getActivity() instanceof main_play_quiz) {
                    ((main_play_quiz) getActivity()).setTabBackgroundColor(tabIndex, isCorerct);

                }
                isAnswerSelected = true;
                // disableOtherAnswer(selectedAnswerId);
            }

        };

        da1.setOnClickListener(answerClickListener);
        da2.setOnClickListener(answerClickListener);
        da3.setOnClickListener(answerClickListener);
        da4.setOnClickListener(answerClickListener);





        btnLuilai.setOnClickListener(v -> {
            if (getActivity() instanceof main_play_quiz) {
                ((main_play_quiz) getActivity()).goToPreviousFragment();
            }
        });


        // Xử lý sự kiện khi nhấn nút "Kết thúc" (chuyển sang màn hình kết quả)
        btnKetThuc.setOnClickListener(view1 -> {
            if(!isAnswerSelected){
                popup_warning_play_Quiz.showWarningPopup(requireContext());
            }
            else {
                if (getActivity() instanceof main_play_quiz) {
                    ((main_play_quiz) getActivity()).goToResult(idCate, idLeve,cate,leve,isNewPl);  // Gọi phương thức goToResult
                }
            }
        });
    }
        private boolean checkAnswer(int selectedAnswerId) {
        if (view==null){
            Log.e("PlayQuizFragment", "Root view is null in checkAnswer");
            return false;
        }
        Button selectedButton = getView().findViewById(selectedAnswerId); // lay button duoc chon
        if (selectedButton == null) {
            Log.e("PlayQuizFragment", "Selected button is null with ID: " + selectedAnswerId);
            return false;
        }
        boolean isCorrect = (boolean) selectedButton.getTag();  // lay tag cua button va ep kieu thanh boolean
        return isCorrect;
    }

    private void changeAnswerButtonColor(int selectedAnswerId, boolean isCorrect) {

        if (view == null){
            Log.e("PlayQuizFragment", "Root view is null in changeAnswerButtonColor");
            return;
        }
        Button selectedButton = view.findViewById(selectedAnswerId);
        if (selectedButton == null) {
            Log.e("PlayQuizFragment", "Selected button is null with ID: " + selectedAnswerId);
            return;
        }
        if (isCorrect) {
            selectedButton.setBackgroundResource(R.drawable.dung); // Đáp án đúng
        } else {
            selectedButton.setBackgroundResource(R.drawable.sai); // Đáp án sai
        }
    }
    private  void disableOtherAnswer(int selectedAnswerId) {
        if (selectedAnswerId != R.id.btnDapAn_10A) da1.setEnabled(false);
        if (selectedAnswerId != R.id.btnDapAn_10B) da2.setEnabled(false);
        if (selectedAnswerId != R.id.btnDapAn_10C) da3.setEnabled(false);
        if (selectedAnswerId != R.id.btnDapAn_10D) da4.setEnabled(false);
    }


}
