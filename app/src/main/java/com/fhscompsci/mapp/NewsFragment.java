package com.fhscompsci.mapp;

import android.app.ListFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class NewsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ListView newsListView;

    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
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
    public void onStart() {
        super.onStart();
        NewsItem itemOne = new NewsItem("Summer School Enrollment Choices", new Date(),
                "SUMMER SCHOOL: Summer school offers students the chance to take courses to satisfy graduation course requirements, or for credit recovery, or as a supplemental selection. A variety of courses are available through BVSD’s summer school program.. Registration for summer school courses, through BVSD, is now open for on campus classes. Click here for on campus course registration. Registration for summer school online options is now open. Full semester online information can be viewed here, Credit recovery online registration timeline can be viewed here Whether you choose an online course, or a course held on a BVSD campus, you can view information and register at http://www.bvsd.org/summer/Pages/default.aspx, see the high school choices on the right side of the webpage.");
        NewsItem itemTwo = new NewsItem("FAFSA, Scholarships AND Financial Aid", new Date(),
                "Are you filling out the FAFSA soon? See the video: How to fill out the FAFSA, and get information on the CSS profile here. Extensive information is available by viewing articles on the tab in the red ribbon above, in the \"Paying for College\" section. Specific scholarships are listed on our scholarship page as well. Our list is updated as new opportunities are being offered, so check back frequently.");
        NewsItem itemThree = new NewsItem("Visiting College Campuses", new Date(),
                "Summer is an excellent time to visit campuses. For information about how to get the most out of a college visit, see our page here.\n\n");
        ArrayList<NewsItem> newsItems = new ArrayList<NewsItem>(Arrays.asList(itemOne, itemTwo, itemThree));
        NewsItemArrayAdapter adapter = new NewsItemArrayAdapter(getActivity(), newsItems);
        newsListView = (ListView) getActivity().findViewById(R.id.newsListView);
        newsListView.setAdapter(adapter);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
