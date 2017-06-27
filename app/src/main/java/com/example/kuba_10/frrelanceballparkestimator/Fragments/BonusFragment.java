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


public class BonusFragment extends Fragment implements View.OnClickListener {

    Button nextBut5;
    Button backBut5;


    public BonusFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static BonusFragment newInstance() {
        BonusFragment fragment = new BonusFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_bonus, container, false);

        nextBut5 = view.findViewById(R.id.next5);

        nextBut5.setOnClickListener(this);

        backBut5 = view.findViewById(R.id.back5);

        backBut5.setOnClickListener(this);


        return view;


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case (R.id.next5):

                MainActivity.openFragment(TaxesFragment.newInstance(), getActivity());


                break;

            case (R.id.back5):

                MainActivity.openFragment(DiscountFragment.newInstance(), getActivity());




        }





    }


}
