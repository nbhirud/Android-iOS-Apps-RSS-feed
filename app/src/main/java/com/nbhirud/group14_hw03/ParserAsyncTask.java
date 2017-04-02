package com.nbhirud.group14_hw03;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by nbhirud on 6/15/2016.
 */
public class ParserAsyncTask extends AsyncTask<String, Void, ArrayList<Entry>> {

    MainActivity activity;
    ProgressDialog pd;
    int size, position;
    TextView tv_title, tv_dev, tv_relDate, tv_price;
    ImageView iv_AppIcon;
    ArrayList<Entry> res;
    String currAppURL = "";



    public ParserAsyncTask(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(activity);
        pd.setCancelable(false);
        pd.setMessage("Processing...");
        pd.show();
    }

    @Override
    protected ArrayList<Entry> doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            //HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int statusCode = con.getResponseCode();
            if(statusCode == HttpURLConnection.HTTP_OK) {
                InputStream in = con.getInputStream();
                return EntryUtil.EntryPullParser.parseEntry(in);            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(final ArrayList<Entry> result) {
        super.onPostExecute(result);
        pd.dismiss();
        activity.setContentView(R.layout.activity_apps_hw03);

        if(!result.isEmpty()) {
            //Log.d("demo", result.toString());
            //ListIterator<Entry> enListItr = result.listIterator();

            ImageButton ib_n = (ImageButton) activity.findViewById(R.id.imageButton_next);
            ImageButton ib_p = (ImageButton) activity.findViewById(R.id.imageButton_prev);

            tv_title = (TextView) activity.findViewById(R.id.textView_AppTitle);
            tv_dev = (TextView) activity.findViewById(R.id.textView_DevName);
            tv_relDate = (TextView) activity.findViewById(R.id.textView_RelDate);
            tv_price = (TextView) activity.findViewById(R.id.textView_Price);

            size = result.size();
            position = 0;
            res = result;
            load(position);


            ib_n.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    position = position + 1;
                    if (position == size) {
                        position = 0;
                    }
                    load(position);
                }
            });

            ib_p.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    position = position - 1;
                    if (position == -1) {
                        position = size-1;
                    }
                    load(position);
                }
            });

            iv_AppIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(currAppURL));
                    activity.startActivity(i);
                }
            });

        }
    }

    private void load(int position) {
        Entry showThis = res.get(position);
        tv_title.setText(showThis.getAppName());
        tv_price.setText(showThis.getPrice());
        tv_relDate.setText(showThis.getReleaseDate());
        tv_dev.setText(showThis.getDeveloperName());
        currAppURL = showThis.appURL;

        iv_AppIcon = (ImageView) activity.findViewById(R.id.imageView_AppImage);
        Picasso.with(activity).load(showThis.getImageURL100()).into(iv_AppIcon);

        //new ImageProcessor(activity).execute(showThis.getAppURL());
    }
}