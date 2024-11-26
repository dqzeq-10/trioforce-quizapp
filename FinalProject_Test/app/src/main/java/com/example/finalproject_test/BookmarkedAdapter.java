package com.example.finalproject_test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BookmarkedAdapter extends RecyclerView.Adapter<BookmarkedAdapter.BookmarkedViewHolder> {

    private final List<BookmarkedItem> bookmarkedItems;

    public BookmarkedAdapter(List<BookmarkedItem> bookmarkedItems) {
        this.bookmarkedItems = bookmarkedItems;
    }

    @NonNull
    @Override
    public BookmarkedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_bookmarked, parent, false);
        return new BookmarkedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkedViewHolder holder, int position) {
        BookmarkedItem item = bookmarkedItems.get(position);
        holder.tvMonth.setText(item.getMonth());
        holder.tvCategory.setText(item.getCategory());
        holder.tvQuestion.setText(item.getQuestion());
        holder.tvAnswer.setText(item.getAnswer());
    }

    @Override
    public int getItemCount() {
        return bookmarkedItems.size();
    }

    public static class BookmarkedViewHolder extends RecyclerView.ViewHolder {
        TextView tvMonth, tvCategory, tvQuestion, tvAnswer;

        public BookmarkedViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMonth = itemView.findViewById(R.id.tvMonth);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvQuestion = itemView.findViewById(R.id.tvQuestion);
            tvAnswer = itemView.findViewById(R.id.tvAnswer);
        }
    }
}
