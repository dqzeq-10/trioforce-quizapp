package com.example.finalproject_test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject_test.DATA.Models.Answer;
import com.example.finalproject_test.DATA.Models.MarkedQuestion;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class BookmarkedAdapter extends RecyclerView.Adapter<BookmarkedAdapter.BookmarkedViewHolder> {

    private List<MarkedQuestion> markedQuestionList;

    public BookmarkedAdapter(List<MarkedQuestion> markedQuestionList) {
        this.markedQuestionList = markedQuestionList;
    }

    @NonNull
    @Override
    public BookmarkedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_bookmarked, parent, false);
        return new BookmarkedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkedViewHolder holder, int position) {
        MarkedQuestion markedQuestion = markedQuestionList.get(position);


    }


    @Override
    public int getItemCount() {
        return markedQuestionList.size();
    }

    public class BookmarkedViewHolder extends RecyclerView.ViewHolder {

        public BookmarkedViewHolder(@NonNull View itemView) {
                super(itemView);


        }
    }
}
