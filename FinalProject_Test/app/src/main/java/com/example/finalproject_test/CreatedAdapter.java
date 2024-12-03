package com.example.finalproject_test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject_test.DATA.Models.CreatedQuestion;


import java.util.List;

public class CreatedAdapter extends RecyclerView.Adapter<CreatedAdapter.CreatedmarkedViewHolder> {

    private List<CreatedQuestion> createdQuestionList;

    public CreatedAdapter(List<CreatedQuestion> markedQuestionList) {
        this.createdQuestionList = markedQuestionList;
    }

    @NonNull
    @Override
    public CreatedmarkedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_created, parent, false);
        return new CreatedmarkedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CreatedmarkedViewHolder holder, int position) {
        CreatedQuestion markedQuestion = createdQuestionList.get(position);


    }


    @Override
    public int getItemCount() {
        return createdQuestionList.size();
    }

    public class CreatedmarkedViewHolder extends RecyclerView.ViewHolder {

        public CreatedmarkedViewHolder(@NonNull View itemView) {
                super(itemView);


        }
    }
}
