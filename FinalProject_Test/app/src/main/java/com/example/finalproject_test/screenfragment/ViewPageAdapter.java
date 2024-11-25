package com.example.finalproject_test.screenfragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPageAdapter extends FragmentStateAdapter {
    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new mainscreen_fragment();

            case 1:
                return new leaderboard_fragment();
            case 2:
                return new storage_fragment();
            case 3:
                return new profile_fragment();

            default:
                return new mainscreen_fragment();
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
