package com.mnm.namandoshi.rss;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ListActivity {
    List headlines;
    List link;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);

        headlines = new ArrayList();
        link = new ArrayList();
        try {
            URL url = new URL("https://www.mercedes-benz.com/en/ressort/mercedes-benz/feed/");//"http://feeds.pcworld.com/pcworld/latestnews");
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            //factory.setNamespaceAware(false);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(getInputStream(url), "UTF_8");
            boolean t = false;
            int eventtype = xpp.getEventType();
            while (eventtype != XmlPullParser.END_DOCUMENT) {
                if (eventtype == XmlPullParser.START_TAG) {
                    if (xpp.getName().equalsIgnoreCase("item")) {
                        t = true;
                    } else if (xpp.getName().equalsIgnoreCase("title")) {
                        if (t)
                            headlines.add(xpp.nextText());
                    } else if (xpp.getName().equalsIgnoreCase("link")) {
                        if (t)
                            link.add(xpp.nextText());
                    }
                } else if (eventtype == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")) {
                    t = false;
                }
                eventtype = xpp.next();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayAdapter b = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,headlines);
        setListAdapter(b);


    }



    public InputStream getInputStream(URL url) {
        try {
            return url.openConnection().getInputStream();
        } catch (IOException e) {
            return null;
        }
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {



    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }
}
