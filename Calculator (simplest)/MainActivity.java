package com.mnm.namandoshi.madlabshiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView t;
    private Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = (TextView) findViewById(R.id.TextView);
        b1 = (Button) findViewById(R.id.Button1);
        b2 = (Button) findViewById(R.id.Button2);
        b3 = (Button) findViewById(R.id.Button3);

        b1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view){
                t.setTextSize(15);
            }});
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                t.setTextSize(45);
            }});
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                t.setTextSize(25);
            }});






    }
}
