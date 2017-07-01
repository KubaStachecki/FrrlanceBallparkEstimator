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

import com.example.kuba_10.frrelanceballparkestimator.FragmentLisener;
import com.example.kuba_10.frrelanceballparkestimator.MainActivity;
import com.example.kuba_10.frrelanceballparkestimator.R;


public class TaxesFragment extends Fragment implements View.OnClickListener {

    Button nextBut6;
    Button backBut6;
    TextView input;

    private FragmentLisener fragmentLisener;


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

        if (fragmentLisener.getNumberData().getCost() == 0 && fragmentLisener.getSharedPreferences("taxes") == null) {

            input.setText("");

        } else {

            input.setText(fragmentLisener.getSharedPreferences("taxes"));

        }


        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        fragmentLisener = (FragmentLisener) context;


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case (R.id.next6):


                fragmentLisener.saveToSharedPreferences(input.getText().toString(), "taxes", getActivity());

                if (input.getText().toString().equals("")) {

                    fragmentLisener.getNumberData().setTaxes(0);
                } else

                {
                    fragmentLisener.getNumberData().setTaxes(Float.parseFloat(fragmentLisener.getSharedPreferences("taxes")));
                }

                fragmentLisener.openFragment(FinalFragment.newInstance(), getActivity());


                break;

            case (R.id.back6):

                fragmentLisener.backFragment(BonusFragment.newInstance(), getActivity());


        }


    }

}
