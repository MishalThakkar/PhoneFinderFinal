package com.example.mishalthakkar.phonefinder;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kwabenaberko.smsbroadcastreceiverlib.SmsBroadcastReceiver;



public class MainActivity extends AppCompatActivity {

    Button Submit;
    TextView EditTextView;
    public static String passcode;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Submit = findViewById(R.id.button);
        EditTextView = findViewById(R.id.editText);
        SharedPreferences sharedPreferences = this.getSharedPreferences("PASSCODE", Context.MODE_PRIVATE);
        String pass = sharedPreferences.getString("passcode", "");
        Log.d(TAG, "onReceive: " + pass);
        EditTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditTextView.setText("");
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            passcode = EditTextView.getText().toString();
            Toast.makeText(getApplicationContext(),"Submitted",Toast.LENGTH_SHORT).show();
            SharedPreferences sharedPreferences = getSharedPreferences("PASSCODE", MODE_PRIVATE);
            sharedPreferences.edit().putString("passcode", passcode).apply();
            Log.d("Test",passcode);
            SharedPreferences sharedPref = getSharedPreferences("PASSCODE", Context.MODE_PRIVATE);
            String pass = sharedPref.getString("passcode", "");
            Log.d("Test", "onReceive: " + pass);
            }
        });
    }
}
