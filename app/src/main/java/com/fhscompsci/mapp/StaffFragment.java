package com.fhscompsci.mapp;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StaffFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StaffFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StaffFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters

    private static final String FRAGMENT_ID = "StaffFragment";

    private OnFragmentInteractionListener mListener;

    private ListView staffView;

    public StaffFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StaffFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StaffFragment newInstance(String param1, String param2) {
        StaffFragment fragment = new StaffFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_staff, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private ArrayList<SchoolDepartment> departmentsFromStrings() throws IOException, XmlPullParserException {
        ArrayList<StaffMember> staffMembers = new ArrayList<StaffMember>();
        ArrayList<SchoolDepartment> departments = new ArrayList<SchoolDepartment>();
        String lastDepartment = "";
        XmlResourceParser parser = getResources().getXml(R.xml.staff_members);
        parser.next();
        int eventType = parser.getEventType();
        while(eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG) {
                if (parser.getName().equals("teacher")) {
                    String firstName = parser.getAttributeValue(0);
                    String lastName = parser.getAttributeValue(1);
                    String email = parser.getAttributeValue(2);
                    String phone = parser.getAttributeValue(3);
                    StaffMember member = new StaffMember(firstName, lastName, phone, email, lastDepartment);
                    staffMembers.add(member);
                } else if (parser.getName().equals("department")) {
                    String title = parser.getAttributeValue(0);
                    lastDepartment = title;
                    SchoolDepartment department = new SchoolDepartment(title);
                    departments.add(department);
                }
            }
            eventType = parser.next();
        }

        for (SchoolDepartment d : departments) {
            for (StaffMember m : staffMembers) {
                if (m.department.equals(d.name)) {
                    d.addMember(m);
                }
            }
        }

        // TODO: 6/8/16 FIGURE OUT THE XML PARSER
        return departments;
    }

    @Override
    public void onStart() {
        super.onStart();
        staffView = (ListView) getActivity().findViewById(R.id.departmentListView);
        ArrayList<SchoolDepartment> departments = null;
        try {
            departments = departmentsFromStrings();
        } catch(IOException e) {
            e.printStackTrace();
        } catch(XmlPullParserException e) {
            e.printStackTrace();
        }
        if (departments == null) {
            departments = new ArrayList<>(0);
        }
        DepartmentArrayAdapter adapter = new DepartmentArrayAdapter(getContext(), departments);
        staffView.setAdapter(adapter);
    }

}
