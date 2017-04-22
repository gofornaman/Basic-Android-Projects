package warmachine0609.alarmclock;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import java.sql.Time;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TimePicker tp=(TimePicker) findViewById(R.id.timePicker);
        Button b=(Button) findViewById(R.id.button);
        Toast t;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getApplicationContext(), "Alarm set for " + tp.getCurrentHour()
                        + ":" + tp.getMinute(), Toast.LENGTH_SHORT);
                t.show();
                while(true) {
                    if (new Time(System.currentTimeMillis()).getHours() == tp.getHour() && new

                            Time(System.currentTimeMillis()).getMinutes() == tp.getMinute()) {
                        t = Toast.makeText(getApplicationContext(), "Alarm ringing",
                                Toast.LENGTH_SHORT);
                        t.show();
                        Vibrator vv = (Vibrator)
                                getSystemService(getApplicationContext().VIBRATOR_SERVICE);
                        vv.vibrate(5000);
                        break;
                    }
                }
            }
        });
    }
}