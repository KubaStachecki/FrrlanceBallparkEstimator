package com.example.kuba_10.frrelanceballparkestimator.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kuba_10.frrelanceballparkestimator.MainActivity;
import com.example.kuba_10.frrelanceballparkestimator.R;


public class HoursFragment extends Fragment implements View.OnClickListener {


    Button nextBut2;
    Button backBut;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    private OnFragmentInteractionListener mListener;

    public HoursFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static HoursFragment newInstance() {
        HoursFragment fragment = new HoursFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_hours, container, false);

        nextBut2 = (Button) view.findViewById(R.id.next2);
        nextBut2.setOnClickListener(this);

        backBut = (Button) view.findViewById(R.id.back);
        backBut.setOnClickListener(this);

        return view;

    }

    //
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
    @Override
    public void onClick(View view) {



        switch (view.getId()) {

            case (R.id.next2):

                MainActivity.openFragment(CostFragment.newInstance(), getActivity());


//                FragmentTransaction ft1 = getFragmentManager().beginTransaction();
//                ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
//                        .replace(R.id.container, CostFragment.newInstance())
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                        .commit();

                break;

            case (R.id.back):

                MainActivity.openFragment(RateFragment.newInstance(), getActivity());


//                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
//                ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
//                        .replace(R.id.container, RateFragment.newInstance())
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                        .commit();

        }



        }

        /**
         * This interface must be implemented by activities that contain this
         * fragment to allow an interaction in this fragment to be communicated
         * to the activity and potentially other fragments contained in that
         * activity.
         * <p>
         * See the Android Training lesson <a href=
         * "http://developer.android.com/training/basics/fragments/communicating.html"
         * >Communicating with Other Fragments</a> for more information.
         */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
    }
