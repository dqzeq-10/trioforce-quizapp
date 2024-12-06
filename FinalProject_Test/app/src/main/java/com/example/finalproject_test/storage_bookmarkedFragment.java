package com.example.finalproject_test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalproject_test.DATA.Models.MarkedQuestion;
import com.example.finalproject_test.DATA.Models.User;
import com.example.finalproject_test.DATA.ViewModels.MarkedQuestionsVM.MarkedQuestionsViewModel;
import com.example.finalproject_test.DATA.ViewModels.SharedVM.SharedViewModel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class storage_bookmarkedFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recyclerView;
    private List<MarkedQuestion> markedQuestions;
    private BookmarkedAdapter bookmarkedAdapter;
    private MarkedQuestionsViewModel markedQuestionsViewModel;
    private SharedViewModel<User> sharedViewModel;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public storage_bookmarkedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment storage_bookmarkedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static storage_bookmarkedFragment newInstance(String param1, String param2) {
        storage_bookmarkedFragment fragment = new storage_bookmarkedFragment();
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
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_storage_bookmarked, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewBookmarked);

        //lấy user đã share chung khi đăng nhập vào
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        sharedViewModel.getObjectMLD().observe(getViewLifecycleOwner(), data -> {

            //goi api lay markquesion ve
            markedQuestionsViewModel = new ViewModelProvider(this).get(MarkedQuestionsViewModel.class);
            markedQuestionsViewModel.getMarkedQuestionsByUsername(data.getUsername()).observe(getViewLifecycleOwner(), markedList ->{
                if (markedList !=null && !markedList.isEmpty()){

                    Collections.sort(markedList, new Comparator<MarkedQuestion>() {
                        @Override
                        public int compare(MarkedQuestion t0, MarkedQuestion t1) {
                            return t0.getMarkedTime().compareTo(t1.getMarkedTime());
                        }
                    });

                    bookmarkedAdapter = new BookmarkedAdapter(markedList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(bookmarkedAdapter);
                }else {
                    Log.d("markedQuestion", "markedQuestion null ");
                }
            });


        });


        // -----------------XOA CAC ITEM KHI VUOT ,SUA LAI CHO HOP EM NHÉ , CHƯA KHỚP -------------------------------------------------
        /*
        // Thêm ItemTouchHelper để xử lý vuốt xóa
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false; // Không xử lý di chuyển item
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition(); // Lấy vị trí item bị vuốt
                if (direction == ItemTouchHelper.LEFT) {
                    // Hiển thị dialog xác nhận
                    popup_comfirm_delete popup = new popup_comfirm_delete(getContext(), new popup_comfirm_delete.OnPopupActionListener() {
                        @Override
                        public void onConfirm() {
                            createdItems.remove(position);
                            adapter.notifyItemRemoved(position);
                        }

                        @Override
                        public void onCancel() {
                            adapter.notifyItemChanged(position);
                        }
                    });
                    popup.show();
                }
            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView,
                                    @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY,
                                    int actionState, boolean isCurrentlyActive) {
                // Lấy view item
                View itemView = viewHolder.itemView;

                Paint paint = new Paint();
                paint.setColor(Color.parseColor("#2FA3BE") );
                c.drawRect((float) itemView.getRight() + dX, (float) itemView.getTop(),
                        (float) itemView.getRight(), (float) itemView.getBottom(), paint);

                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        });

        // Gắn ItemTouchHelper vào RecyclerView
        itemTouchHelper.attachToRecyclerView(recyclerView);
*/
        return view;

    }
}