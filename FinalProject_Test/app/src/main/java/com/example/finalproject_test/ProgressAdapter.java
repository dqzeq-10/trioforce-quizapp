package com.example.finalproject_test;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject_test.DATA.Models.ProgressQuestion;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

public class ProgressAdapter extends RecyclerView.Adapter<ProgressAdapter.ProgressViewHolder> {

    private List<ProgressQuestion> progressQuestionList;
    private Context context;


    public ProgressAdapter(List<ProgressQuestion> progressQuestions, Context context) {
        this.progressQuestionList = progressQuestions;
        this.context = context;
    }

    @NonNull
    @Override
    public ProgressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_progress, parent, false);
        return new ProgressViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ProgressViewHolder holder, int position) {
        ProgressQuestion progressQuestion = progressQuestionList.get(position);
        SimpleDateFormat formatter = new SimpleDateFormat("'Ngày' dd, 'tháng' MM, 'năm' yyyy");
        if (progressQuestion.getSavedTime() !=null){
        String dateString = formatter.format(progressQuestion.getSavedTime());
        holder.tvNgay.setText(dateString);
        }else{

            holder.tvNgay.setText("ngay bi null");
        }


        holder.tvTencate.setText(progressQuestion.getSetName());
        holder.tvTiendo.setText("Tiến độ: "+progressQuestion.getQuestionCount()+"/10");
        holder.tvTacgia.setText(progressQuestion.getAuthorName());

        holder.linearProggress.setOnClickListener(v ->{
            Intent intent = new Intent(context, main_play_quiz.class);
            intent.putExtra("setquestionP",(Serializable) progressQuestion.getQuestions());
            intent.putExtra("answeredsP",(Serializable) progressQuestion.getAnswered());
            context.startActivity(intent);
        });


    }


    @Override
    public int getItemCount() {
        return progressQuestionList.size();
    }

    public class ProgressViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearProggress;
        TextView tvNgay, tvTencate, tvTiendo, tvTacgia;
        public ProgressViewHolder(@NonNull View itemView) {
            super(itemView);
            linearProggress = itemView.findViewById(R.id.linearProggress);
            tvNgay = itemView.findViewById(R.id.tvMonthYearP);
            tvTencate = itemView.findViewById(R.id.tvTitleP);
            tvTiendo = itemView.findViewById(R.id.tvProgress);
            tvTacgia = itemView.findViewById(R.id.tvAuthorP);

        }
    }
}
