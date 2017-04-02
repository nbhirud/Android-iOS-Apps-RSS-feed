package com.nbhirud.iTunesTopGrossingApps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //new ParserAsyncTask(MainActivity.this).execute("http://itunes.apple.com/us/rss/topgrossingapplications/limit=25/xml");
        new ParserAsyncTask(MainActivity.this).execute("https://itunes.apple.com/us/rss/topgrossingapplications/limit=100/xml");
    }
}
