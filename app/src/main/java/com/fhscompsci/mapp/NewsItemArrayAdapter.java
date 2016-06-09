package com.fhscompsci.mapp;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evan on 6/7/16.
 */
public class NewsItemArrayAdapter extends ArrayAdapter<NewsItem> {
    private static class ViewHolder {
        TextView title;
        TextView date;
        TextView body;
    }

    public NewsItemArrayAdapter(Context context, ArrayList<NewsItem> items) {
        super(context, R.layout.news_item, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        NewsItem item = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.news_item, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.newsItemTitle);
            viewHolder.date = (TextView) convertView.findViewById(R.id.newsItemDate);
            viewHolder.body = (TextView) convertView.findViewById(R.id.newsItemBody);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.title.setText(item.title);
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        viewHolder.date.setText(format.format(item.date));
        viewHolder.body.setText(item.body);

        return convertView;
    }
}
