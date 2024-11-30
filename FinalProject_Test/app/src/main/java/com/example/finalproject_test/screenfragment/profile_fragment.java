    package com.example.finalproject_test.screenfragment;

    import android.app.Dialog;
    import android.content.Context;
    import android.content.Intent;
    import android.content.SharedPreferences;
    import android.os.Bundle;

    import androidx.fragment.app.Fragment;
    import androidx.lifecycle.ViewModelProvider;

    import android.view.Gravity;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.view.WindowManager;
    import android.widget.Button;
    import android.widget.RadioGroup;
    import android.widget.TextView;
    import android.widget.Toast;

    import com.example.finalproject_test.DATA.Models.User;
    import com.example.finalproject_test.DATA.Repository.CurrentUserSesssion;
    import com.example.finalproject_test.DATA.ViewModels.SharedVM.SharedViewModel;
    import com.example.finalproject_test.LoginORSignup;
    import com.example.finalproject_test.R;

    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.Date;

    /**
     * A simple {@link Fragment} subclass.
     * Use the {@link profile_fragment#newInstance} factory method to
     * create an instance of this fragment.
     */
    public class profile_fragment extends Fragment {

        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        private Dialog dialog_email, dialog_success, dialog_phone;
        private Button btn_Huy_email, btn_XN_email, btndangxuat, btn_Huy_phone, btn_XN_phone;
        private TextView edit_email, edit_phone;
        private TextView tvUsername, tvName, tvEmail, tvSdt, tvBirthday;
        private RadioGroup rgGioiTinh;
        private View view;
        private static final String SHARED_PREFS = "sharedPrefs";
        private static final String KEY_USERNAME = "username";
        private static final String KEY_PASSWORD = "password";
        private SharedViewModel<User> sharedViewModel;


        // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;

        public profile_fragment() {
            // Required empty public constructor
        }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment profile_fragment.
         */
        // TODO: Rename and change types and number of parameters
        public static profile_fragment newInstance(String param1, String param2) {
            profile_fragment fragment = new profile_fragment();
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
            view = inflater.inflate(R.layout.fragment_profile_fragment, container, false);

            btndangxuat = view.findViewById(R.id.btnDangXuat);
            edit_email = view.findViewById(R.id.txt_Change_email);
            edit_phone = view.findViewById(R.id.txt_change_phone);

            tvUsername = view.findViewById(R.id.tvUsernameP);
            tvName = view.findViewById(R.id.tvHotenP);
            tvEmail = view.findViewById(R.id.tvEmailP);
            tvSdt = view.findViewById(R.id.tvSdtP);
            tvBirthday = view.findViewById(R.id.tvBirthdayP);
            rgGioiTinh = view.findViewById(R.id.radioGroupGender);

            //===============================LOAD các thông tin của user lên profile fragment ===================================//

            // lấy dữ liệu đã shared chung từ activity main srceen
            sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
            sharedViewModel.getObjectMLD().observe(getViewLifecycleOwner(),data ->{
                tvUsername.setText("@"+data.getUsername());
                tvName.setText(data.getName());
                tvEmail.setText(data.getEmail());
                tvSdt.setText(data.getPhoneNumber());

                //format NgayThangNam
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dbirth = dateFormat.format(data.getBirthday());
                tvBirthday.setText(dbirth);

                rgGioiTinh.check(data.isSex()?R.id.radioMale:R.id.radioFemale);
            });

            btndangxuat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // chuyển sang màn hình đăng nhập lại
                    Intent it = new Intent(getActivity(), LoginORSignup.class);
                    it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(it);

                    getActivity().finish();

                }
            });
            //=============================su kien ==============================//
            edit_email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPopup();
                }
            });
            edit_phone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPopup3();
                }
            });

            return view;
        }

        //==========================================show popup======================================================//
        private void showPopup() {

            dialog_email = new Dialog(requireActivity(), R.style.CustomDialog);

            dialog_email.setCancelable(false);
            dialog_email.setContentView(R.layout.dialog_change_email);

            btn_Huy_email = dialog_email.findViewById(R.id.btn_H);
            btn_XN_email = dialog_email.findViewById(R.id.btn_XN);

            btn_Huy_email.setOnClickListener(view -> dialog_email.dismiss());

            btn_XN_email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog_email.dismiss();
                    showPopup2();
                }
            });
            dialog_email.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
            WindowManager.LayoutParams layoutParams = dialog_email.getWindow().getAttributes();
            layoutParams.gravity = Gravity.CENTER;
            layoutParams.y = 10;
            dialog_email.getWindow().setAttributes(layoutParams);
            dialog_email.show();
        }

        //==============================show popup2 =======================================//
        private void showPopup2() {
            dialog_success = new Dialog(requireActivity(), R.style.CustomDialog);
            dialog_success.setCancelable(true);
            dialog_success.setContentView(R.layout.dialog_success);
            dialog_success.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog_success.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
            WindowManager.LayoutParams LayoutParams = dialog_success.getWindow().getAttributes();
            LayoutParams.gravity = Gravity.CENTER;
            LayoutParams.y = 10;
            dialog_success.getWindow().setAttributes(LayoutParams);
            dialog_success.show();
        }

        //===========================================================================//
        private void showPopup3() {

            dialog_phone = new Dialog(requireActivity(), R.style.CustomDialog);

            dialog_phone.setCancelable(false);
            dialog_phone.setContentView(R.layout.dialog_change_phonenumber);

            btn_Huy_phone = dialog_phone.findViewById(R.id.btn_H);
            btn_XN_phone = dialog_phone.findViewById(R.id.btn_XN);

            btn_Huy_phone.setOnClickListener(view -> dialog_phone.dismiss());

            btn_XN_phone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog_phone.dismiss();
                    showPopup2();
                }
            });
            dialog_phone.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
            WindowManager.LayoutParams layoutParams = dialog_phone.getWindow().getAttributes();
            layoutParams.gravity = Gravity.CENTER;
            layoutParams.y = 10;
            dialog_phone.getWindow().setAttributes(layoutParams);
            dialog_phone.show();
        }
    }