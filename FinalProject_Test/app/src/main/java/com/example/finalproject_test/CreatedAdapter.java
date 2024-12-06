package com.example.finalproject_test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject_test.DATA.Models.Answer;
import com.example.finalproject_test.DATA.Models.CreatedQuestion;


import java.text.SimpleDateFormat;
import java.util.List;

public class CreatedAdapter extends RecyclerView.Adapter<CreatedAdapter.CreatedmarkedViewHolder> {

    private List<CreatedQuestion> createdQuestionList;

    public CreatedAdapter(List<CreatedQuestion> createdQuestionList) {
        this.createdQuestionList = createdQuestionList;
    }

    @NonNull
    @Override
    public CreatedmarkedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_created, parent, false);
        return new CreatedmarkedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CreatedmarkedViewHolder holder, int position) {
        CreatedQuestion createdQuestion = createdQuestionList.get(position);
        Answer answer = null;
        List<Answer> answers = createdQuestion.getAnswers();
        if (answers != null) {
            for (Answer a : createdQuestion.getAnswers()
            ) {
                if (a.isCorrect()) {
                    answer = new Answer(a.getAnswerText(), a.isCorrect());
                    break;
                }
            }
        }
        String answerText = (answer != null) ? answer.getAnswerText() : "Chưa có đáp án đúng";
        //Date sang String
        SimpleDateFormat formatter = new SimpleDateFormat("'Ngày' dd, 'tháng' MM, 'năm' yyyy");
        String dateString = formatter.format(createdQuestion.getCreatedTime());

        holder.tvNgay.setText(dateString);

        holder.tvTenCate.setText(createdQuestion.getCategoryName());
        holder.tvCauhoi.setText(createdQuestion.getQuestionText());
        holder.tvDAtrue.setText(answerText);
    }

    @Override
    public int getItemCount() {
        return createdQuestionList.size();
    }

    public class CreatedmarkedViewHolder extends RecyclerView.ViewHolder {
        TextView tvNgay, tvTenCate, tvCauhoi, tvDAtrue;

        public CreatedmarkedViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNgay = itemView.findViewById(R.id.tvMonthC);
            tvTenCate = itemView.findViewById(R.id.tvCategoryC);
            tvCauhoi = itemView.findViewById(R.id.tvTitleC);
            tvDAtrue = itemView.findViewById(R.id.tvDapandungC);

        }
    }
}