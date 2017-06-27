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
import android.widget.TextView;

import com.example.kuba_10.frrelanceballparkestimator.MainActivity;
import com.example.kuba_10.frrelanceballparkestimator.R;


public class HoursFragment extends Fragment implements View.OnClickListener {


    Button nextBut2;
    Button backBut2;
    TextView input;



    public HoursFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static HoursFragment newInstance() {
        HoursFragment fragment = new HoursFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_hours, container, false);

        nextBut2 = (Button) view.findViewById(R.id.next2);
        nextBut2.setOnClickListener(this);

        backBut2 = (Button) view.findViewById(R.id.back2);
        backBut2.setOnClickListener(this);

        input =  view.findViewById(R.id.hoursIn);
        input.setText(Float.toString(MainActivity.getNumberData().getHours()));

        return view;

    }


    @Override
    public void onClick(View view) {



        switch (view.getId()) {

            case (R.id.next2):

                MainActivity.getNumberData().setHours( Float.parseFloat( input.getText().toString() ));


                MainActivity.openFragment(CostFragment.newInstance(), getActivity());


                break;

            case (R.id.back2):

                MainActivity.openFragment(RateFragment.newInstance(), getActivity());




        }



        }


    }
