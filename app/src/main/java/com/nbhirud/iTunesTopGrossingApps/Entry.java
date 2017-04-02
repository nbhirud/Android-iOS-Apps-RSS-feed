package com.nbhirud.iTunesTopGrossingApps;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by nbhirud on 6/15/2016.
 */
public class Entry {
    //id, app title, developer name, url, small photo url, large photo url, and app price
    String id;
    String appURL;
    String appName; //<im:name>Spotify Music</im:name>
    String developerName; //<im:artist href="https://itunes.apple.com/us/developer/spotify-ltd./id324684583?mt=8&uo=2">Spotify Ltd.</im:artist>
    String ReleaseDate; //<im:releaseDate label="July 14, 2011">2011-07-14T04:22:37-07:00</im:releaseDate>
    String price;   //<im:price amount="0.00000" currency="USD">Get</im:price>
    String category; //<category im:id="6014" term="Games" scheme="https://itunes.apple.com/us/genre/ios-games/id6014?mt=8&uo=2" label="Games"/>
    String imageURL53; //     <im:image height="53">http://is3.mzstatic.com/image/thumb/Purple18/v4/93/8c/f1/938cf1f7-aec7-9481-fb79-7bb14d6ee5b0/mzl.nautzuix.png/53x53bb-85.png</im:image>
    String imageURL100;
    //Bitmap img53;
    //Bitmap img100;
/*
    public Bitmap getImg53() {
        return img53;
    }

    public void setImg53(Bitmap img53) {
        this.img53 = img53;
    }

    public Bitmap getImg100() {
        return img100;
    }

    public void setImg100(Bitmap img100) {
        this.img100 = img100;
    }
    */
    /*
    <im:image height="53">
http://is3.mzstatic.com/image/thumb/Purple18/v4/93/8c/f1/938cf1f7-aec7-9481-fb79-7bb14d6ee5b0/mzl.nautzuix.png/53x53bb-85.png
</im:image>
<im:image height="75">
http://is5.mzstatic.com/image/thumb/Purple18/v4/93/8c/f1/938cf1f7-aec7-9481-fb79-7bb14d6ee5b0/mzl.nautzuix.png/75x75bb-85.png
</im:image>
<im:image height="100">
http://is3.mzstatic.com/image/thumb/Purple18/v4/93/8c/f1/938cf1f7-aec7-9481-fb79-7bb14d6ee5b0/mzl.nautzuix.png/100x100bb-85.png
</im:image>
*/

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageURL53() {
        return imageURL53;
    }

    public void setImageURL53(String imageURL53) {
        this.imageURL53 = imageURL53;
    }

    public String getImageURL100() {
        return imageURL100;
    }

    public void setImageURL100(String imageURL100) {
        this.imageURL100 = imageURL100;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppURL() {
        return appURL;
    }

    public void setAppURL(String appURL) {
        this.appURL = appURL;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id='" + id + '\'' +
                ", appURL='" + appURL + '\'' +
                ", appName='" + appName + '\'' +
                ", developerName='" + developerName + '\'' +
                ", ReleaseDate='" + ReleaseDate + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                ", imageURL53='" + imageURL53 + '\'' +
                ", imageURL100='" + imageURL100 + '\'' +
                '}' +
                '\n';
    }
/*
    public Bitmap processImage(String str) {
        try {
            URL url = new URL(str);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            Bitmap img = BitmapFactory.decodeStream(con.getInputStream());
            return img;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
*/
}
