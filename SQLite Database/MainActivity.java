package warmachine0609.database;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    warmachine0609.database.DatabaseHelper myDb;
    EditText nammes;
    Button b1;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new warmachine0609.database.DatabaseHelper(this);
        nammes=(EditText)findViewById(R.id.editText);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                boolean ifinserted=myDb.insertData(nammes.getText().toString());
                if(ifinserted=true){
                    Toast.makeText(MainActivity.this,"done inserting",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"not inserting",Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.showData();
                if (res.getCount() == 0) {
                    getMessage("error");
                    return;

                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (res.moveToNext()) {
                        stringBuffer.append("id: " + res.getString(0));
                        stringBuffer.append("Name: " + res.getString(1));
                    }
                    Toast.makeText(MainActivity.this,stringBuffer.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void getMessage(String message){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("data");
        alertDialog.setCancelable(true);
        alertDialog.setMessage(message);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
