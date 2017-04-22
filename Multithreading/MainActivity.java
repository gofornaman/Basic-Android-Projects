package com.mnm.namandoshi.multithreading;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=(TextView)findViewById(R.id.t1);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                t.setText("Start");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        count++;
                        t.setText("Thread executed number" + count);
                    }
                },3000);
            }
        });

    }
}