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
        NewsItem itemOne = new NewsItem("Dank memes overflow local android project", new Date(), "Body Text");
        NewsItem itemTwo = new NewsItem("Title two", new Date(), "Body Text two");
        NewsItem itemThree = new NewsItem("Title three", new Date(), "Body Text three");
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
