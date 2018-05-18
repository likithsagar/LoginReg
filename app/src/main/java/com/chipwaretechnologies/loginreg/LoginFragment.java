package com.chipwaretechnologies.loginreg;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private TextView regText;
    private ArrayList<User> data;
    private EditText UserName,UserPassword;
    private Button LoginBtn;

OnLoginFormActivityListener loginFormActivityListener;
    public interface OnLoginFormActivityListener{
        public void performLogin();
        public void performRegister();
    }
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        regText = view.findViewById(R.id.register_txt);
        UserName = view.findViewById(R.id.user_name);
        UserPassword= view.findViewById(R.id.user_pass);
        LoginBtn = view.findViewById(R.id.login_btn);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perforLogin();
            }
        });

        regText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginFormActivityListener.performRegister();
            }
        });
    return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;
        loginFormActivityListener = (OnLoginFormActivityListener) activity;
    }

    private void perforLogin(){

Thread myThread= new Thread(new MyThread());
myThread.start();


        UserName.setText("");
        UserPassword.setText("");


    }

    private  class MyThread implements Runnable
    {


        @Override
        public void run() {

            String username=UserName.getText().toString();

            String password =UserPassword.getText().toString();
            Call<ServerResponse> call = MainActivity.apiInterface.performUserLogin(username,password);
            call.enqueue(new Callback<ServerResponse>() {
                @Override
                public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {

                    MainActivity.prefConfig.displayToast(response.body().getMessage());
                    if(response.body().getMessage().equals("Authentication Successfull"))
                    {

                        loginFormActivityListener.performLogin();
                    }
                }

                @Override
                public void onFailure(Call<ServerResponse> call, Throwable t) {

                }
            });

            Call<List<User>> callDetail = MainActivity.apiInterface.fetchDetails(username,password);
            callDetail.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    List<User> list = response.body();
                    User user = null;
                    for(int i=0;i<list.size();i++){

                        String date = list.get(i).getDate();
                        String pname = list.get(i).getProject_name();
                        user.setDate(date);
                        user.setProject_name(pname);
                    }
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {

                }
            });



        }
    }

}
