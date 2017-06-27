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


public class TaxesFragment extends Fragment implements View.OnClickListener {

    Button nextBut6;
    Button backBut6;
    TextView input;



    // TODO: Rename and change types and number of parameters
    public static TaxesFragment newInstance() {
        TaxesFragment fragment = new TaxesFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_taxes, container, false);

        nextBut6 = view.findViewById(R.id.next6);

        nextBut6.setOnClickListener(this);

        backBut6 = view.findViewById(R.id.back6);

        backBut6.setOnClickListener(this);


        input = view.findViewById(R.id.taxesIn);
        input.setText(Float.toString(MainActivity.getNumberData().getTaxes()));



        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case (R.id.next6):

                MainActivity.getNumberData().setTaxes(Float.parseFloat(input.getText().toString()));


                MainActivity.openFragment(FinalFragment.newInstance(), getActivity());


                break;

            case (R.id.back6):

                MainActivity.openFragment(BonusFragment.newInstance(), getActivity());


        }


    }

}
