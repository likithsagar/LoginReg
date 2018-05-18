package com.chipwaretechnologies.loginreg;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    private EditText UserName,UserPsssword,AccessId,Security_q,Answer;
    private Button BnRegister;


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_register, container, false);
    UserName = view.findViewById(R.id.txt_name);
    UserPsssword= view.findViewById(R.id.txt_password);
    AccessId = view.findViewById(R.id.access_id);
    Security_q = view.findViewById(R.id.security_q);
    Answer = view.findViewById(R.id.answer);
    BnRegister = view.findViewById(R.id.btn_register);

    BnRegister.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            performRegistartion();
        }
    });
    return view;
    }

    public void performRegistartion(){

        String username_reg=UserName.getText().toString();
        String password_reg=UserPsssword.getText().toString();
        String access_id_reg=AccessId.getText().toString();
        String security_question_reg=Security_q.getText().toString();
        String answer_reg=Answer.getText().toString();



        Call<ServerResponse> call = MainActivity.apiInterface.operation(username_reg,password_reg,access_id_reg,security_question_reg,answer_reg);
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                MainActivity.prefConfig.displayToast(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {

            }
        });


        UserName.setText("");
        UserPsssword.setText("");
        AccessId.setText("");
        Security_q.setText("");
        Answer.setText("");
    }

}
