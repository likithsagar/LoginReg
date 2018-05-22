package com.chipwaretechnologies.loginreg;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

private Button BnLogout;
private TextView textView;

OnLogoutListner onLogoutListner;

public interface OnLogoutListner
{

    public void logoutPerform();
}
    public HomeFragment() {
    
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        BnLogout = view.findViewById(R.id.btn_logout);
        textView = view.findViewById(R.id.textView);
        textView.setText("Welcome" );
        BnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogoutListner.logoutPerform();
            }
        });
return view;
}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity=(Activity) context;
        onLogoutListner=(OnLogoutListner) activity;
    }
}
