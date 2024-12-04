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
        Answer answer = null;
        for (Answer a : markedQuestion.getAnswers()
        ) {
            if (a.isCorrect()) {
                answer = new Answer(a.getAnswerText(), a.isCorrect());
                break;
            }

        }
        //Date sang String
        SimpleDateFormat formatter = new SimpleDateFormat("Ngày dd, tháng MM, năm yyyy");
        String dateString = formatter.format(markedQuestion.getMarkedTime());

        holder.tvNgay.setText(dateString);

        holder.tvTencate.setText(markedQuestion.getCategoryName());
        holder.tvCauhoi.setText(markedQuestion.getQuestionText());
        holder.tvDAtrue.setText(answer.getAnswerText());

    }

    @Override
    public int getItemCount() {
        return markedQuestionList.size();
    }

    public class BookmarkedViewHolder extends RecyclerView.ViewHolder {
        TextView tvNgay, tvTencate, tvCauhoi, tvDAtrue;

        public BookmarkedViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNgay = itemView.findViewById(R.id.tvMonthM);
            tvTencate = itemView.findViewById(R.id.tvCategoryM);
            tvCauhoi = itemView.findViewById(R.id.tvTitleM);
            tvDAtrue = itemView.findViewById(R.id.tvDapandungM);
        }
    }
}
