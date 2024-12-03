package com.example.finalproject_test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject_test.DATA.Models.ProgressQuestion;

import java.util.List;

public class ProgressAdapter extends RecyclerView.Adapter<ProgressAdapter.ProgressViewHolder> {

    private List<ProgressQuestion> progressQuestionList;

    public ProgressAdapter(List<ProgressQuestion> progressQuestions) {
        this.progressQuestionList = progressQuestions;
    }

    @NonNull
    @Override
    public ProgressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_progress, parent, false);
        return new ProgressViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ProgressViewHolder holder, int position) {
        ProgressQuestion markedQuestion = progressQuestionList.get(position);

      
    }


    @Override
    public int getItemCount() {
        return progressQuestionList.size();
    }

    public class ProgressViewHolder extends RecyclerView.ViewHolder {

        public ProgressViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
