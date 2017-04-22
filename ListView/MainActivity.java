package com.listview.namandoshi.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.listview.namandoshi.learnLanguages;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private List<learnLanguages> availLang = new ArrayList<learnLanguages>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        availLang.add(new learnLanguages("HTML", R.mipmap.ic_launcher, 40));
        availLang.add(new learnLanguages("Javascript", R.mipmap.ic_launcher, 45));
        availLang.add(new learnLanguages("PHP", R.mipmap.ic_launcher, 21));
        availLang.add(new learnLanguages("Java", R.mipmap.ic_launcher, 46));

        ArrayAdapter<learnLanguages> adapter = new customAdapter();

        ListView myFirstListView = (ListView) (findViewById(R.id.myFirstListView));
        myFirstListView.setAdapter(adapter);

        myFirstListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "My Listview Item", Toast.LENGTH_SHORT);
            }
        });

    }


    private class customAdapter extends  ArrayAdapter<learnLanguages> {
        public customAdapter() {
            super(MainActivity.this, R.layout.my_layout, availLang);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.my_layout,parent,false);
            }
                learnLanguages myCurrentlang = availLang.get(position);

                ImageView myImg = (ImageView) convertView.findViewById(R.id.leftIco);
                TextView myHeading = (TextView) convertView.findViewById(R.id.heading);
                TextView myDesc = (TextView) convertView.findViewById(R.id.descrip);

                myImg.setImageResource(myCurrentlang.getImageID());
                myHeading.setText(myCurrentlang.getNameOfLang());
                myDesc.setText(String.valueOf(myCurrentlang.getTutorialNumber()));

            return convertView;
        }
    }
}
