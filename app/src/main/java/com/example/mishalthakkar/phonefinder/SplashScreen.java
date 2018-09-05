package com.example.mishalthakkar.phonefinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Logo logo = new Logo();
        logo.start();
    }

    private class Logo extends Thread
    {
        public void run()
        {
            try {
                sleep(1000);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

}
