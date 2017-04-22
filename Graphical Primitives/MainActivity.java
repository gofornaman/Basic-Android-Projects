package com.mnm.namandoshi.graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SampleView(this));
    }


    public class SampleView extends View {
        public SampleView(Context context)
        {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.RED);
            int x = getWidth();
            int y = getHeight();
            canvas.drawCircle(x/2, y/2, 100, paint);
            paint.setColor(Color.MAGENTA);
            canvas.drawRect(100,200,300,450,paint);
        }
    }
}
