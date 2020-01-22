package com.example.random;


import android.app.Activity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ReadFromSite extends Activity {

    public void start(){
        Document doc = null;
        for(int i = 1; ;i++){
            try {
                doc = Jsoup.connect("https://danilaiarmarkin.wixsite.com/random/list" + Integer.toString(i)).get();
                Elements e = doc.getElementsByAttributeValueContaining("class", "txtNew");
                e.select("p").first();
                for (Element el : e) {
                    System.out.println(el.text());
                }
            } catch (IOException e) {
                break;
            }
        }
    }
}
