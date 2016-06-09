package com.fhscompsci.mapp;

import java.util.Date;

/**
 * Created by Evan on 6/7/16.
 */
public class NewsItem {
    public String title;
    public Date date;
    public String body;

    public NewsItem(String t, Date d, String b) {
        this.title = t;
        this.date = d;
        this.body = b;
    }
}
