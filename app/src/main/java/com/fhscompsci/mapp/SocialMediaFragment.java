package com.fhscompsci.mapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SocialMediaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SocialMediaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SocialMediaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private String FRAGMENT_ID = this.getClass().getSimpleName();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ListView socialMediaListView;

    public SocialMediaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SocialMediaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SocialMediaFragment newInstance(String param1, String param2) {
        SocialMediaFragment fragment = new SocialMediaFragment();
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

        return inflater.inflate(R.layout.fragment_social_media, container, false);
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
        socialMediaListView = (ListView) getActivity().findViewById(R.id.socialMediaList);
        String[] socialMediaLinks = {"BVSD Twitter","Credit Union Twitter", "BVSD Facebook", "Credit Union Facebook"};
        SocialMediaListing bvsdTwitter = new SocialMediaListing("BVSD Twitter","Had to stop by the 3D TV again! #InnovateBVSD");
        SocialMediaListing creditUnionTwitter = new SocialMediaListing("Credit Union Twitter","Our thoughts are with all those impacted in #Orlando.");
        SocialMediaListing bvsdFacebook = new SocialMediaListing("BVSD Facebook", "Construction of the new school in Erie got off to a super start with neighborhood kids beginning the excavation at the groundbreaking celebration earlier this week. For more information about the construction project go to: http://bond.bvsd.org/projects/ErieCampus/Pages/default.aspx.");
        SocialMediaListing creditUnionFacebook = new SocialMediaListing("Credit Union Facebook","We are honored and blessed to have helped Undra of Realities For Children- Boulder County achieve her college dreams!");
        ArrayList<SocialMediaListing> links = new ArrayList<>(Arrays.asList(bvsdTwitter, creditUnionTwitter, bvsdFacebook, creditUnionFacebook));
        SocialMediaListingArrayAdapter adapter = new SocialMediaListingArrayAdapter(getContext(),links);
        socialMediaListView.setAdapter(adapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
