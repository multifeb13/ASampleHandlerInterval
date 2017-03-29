package com.example.hirotaka.asamplehandlerinterval;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtCounter;
    final Handler handler = new Handler();
    Runnable r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCounter = (TextView)findViewById(R.id.txtCounter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        r = new Runnable(){
            int count = 0;

            @Override
            public void run(){
                count++;
                txtCounter.setText(String.valueOf(count));
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(r);

    }
}
