package com.chipwaretechnologies.loginreg;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Created by likit on 5/8/2018.
 */

public class PrefConfig {

    private SharedPreferences sharedPreferences;
    private Context context;

    public PrefConfig(Context context)
    {
        this.context=context;
        sharedPreferences=context.getSharedPreferences(context.getString(R.string.pref_file),Context.MODE_PRIVATE);
    }
    public void displayToast(String message)
    {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
    public boolean readLoginStatus(){
        return sharedPreferences.getBoolean(context.getString(R.string.pref_login_status),false);
    }
    public void writeLoginStatus(boolean status)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getString(R.string.pref_login_status),status);
        editor.commit();

    }
}
