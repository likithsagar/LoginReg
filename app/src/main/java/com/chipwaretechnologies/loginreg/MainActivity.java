package com.chipwaretechnologies.loginreg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LoginFragment.OnLoginFormActivityListener {

    public static PrefConfig prefConfig;
    public static ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefConfig = new PrefConfig(this);
        apiInterface =ApiClient.getApiClient().create(ApiInterface.class);
        if(findViewById(R.id.fragment_container)!=null)
        {

            if(prefConfig.readLoginStatus())
            {
                Thread myThread= new Thread(new mThread());
                myThread.start();
            }
            else
            {
             getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new LoginFragment()).commit();

            }
        }

    }




    @Override
    public void performLogin() {
        prefConfig.writeLoginStatus(true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DetailsFragment()).commit();
    }

    @Override
    public void performRegister() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RegisterFragment()).commit();

    }

    private class mThread implements Runnable{


        @Override
        public void run() {

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new DetailsFragment()).commit();

        }
    }

   /** @Override
    public void logoutPerform() {
        prefConfig.writeLoginStatus(false);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new LoginFragment()).commit();
    }**/
}


