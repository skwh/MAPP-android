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
 * Created by Evan on 6/8/16.
 */
public class DepartmentArrayAdapter extends ArrayAdapter<SchoolDepartment> {

    private static class ViewHolder {
        TextView departmentTitle;
        TextView staffNames;
    }

    public DepartmentArrayAdapter(Context context, ArrayList<SchoolDepartment> objects) {
        super(context, R.layout.department_item, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        SchoolDepartment item = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.department_item, parent, false);
            viewHolder.departmentTitle = (TextView) convertView.findViewById(R.id.departmentName);
            viewHolder.staffNames = (TextView) convertView.findViewById(R.id.staffNames);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.departmentTitle.setText(item.name);
        String staffNamesAndNumbers = "";
        for (StaffMember m : item.members) {
            staffNamesAndNumbers += m.firstName + " " + m.lastName + " - " + m.phoneNumber + "\n";
        }
        viewHolder.staffNames.setText(staffNamesAndNumbers);

        return convertView;
    }
}
