package com.fhscompsci.mapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Evan on 6/9/16.
 */
public class SocialMediaListingArrayAdapter extends ArrayAdapter<SocialMediaListing> {
    public SocialMediaListingArrayAdapter(Context context, ArrayList<SocialMediaListing> objects) {
        super(context, R.layout.social_item, objects);
    }

    private class ViewHolder {
        TextView title;
        TextView text;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        SocialMediaListing item = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.social_item, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.socialItemTitle);
            viewHolder.text = (TextView) convertView.findViewById(R.id.socialItemText);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.title.setText(item.title);
        viewHolder.text.setText(item.latestItemMessage);

        return convertView;
    }
}
