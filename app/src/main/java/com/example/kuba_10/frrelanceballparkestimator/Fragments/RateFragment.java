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

import com.example.kuba_10.frrelanceballparkestimator.Currency;
import com.example.kuba_10.frrelanceballparkestimator.MainActivity;
import com.example.kuba_10.frrelanceballparkestimator.R;


public class RateFragment extends Fragment implements View.OnClickListener {


    Button nextBut;



    public RateFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static RateFragment newInstance() {
        RateFragment fragment = new RateFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_rate, container, false);

        nextBut = (Button) view.findViewById(R.id.next);
        nextBut.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case (R.id.next):

                MainActivity.openFragment(HoursFragment.newInstance(), getActivity());


                break;

            case (R.id.back):

                MainActivity.openFragment(CurrencyFragment.newInstance(), getActivity());




        }





    }

}
