package com.fhscompsci.mapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;

/**
 * Created by Evan on 6/8/16.
 */
public class DepartmentArrayAdapter extends ArrayAdapter<SchoolDepartment> {

    private static class ViewHolder {
        TextView departmentTitle;
    }

    public DepartmentArrayAdapter(Context context, SchoolDepartment[] objects) {
        super(context, 0, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        SchoolDepartment item = getItem(position);
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
