package com.example.kuba_10.frrelanceballparkestimator.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.kuba_10.frrelanceballparkestimator.MainActivity;
import com.example.kuba_10.frrelanceballparkestimator.R;


public class FinalFragment extends Fragment implements View.OnClickListener {

    TextView workCost;
    TextView costSum;
    TextView ballpark;
    Button again;



    public FinalFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FinalFragment newInstance() {
        FinalFragment fragment = new FinalFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_final, container, false);

        workCost = view.findViewById(R.id.workCost);
        costSum = view.findViewById(R.id.costSum);
        ballpark = view.findViewById(R.id.ballpark);


        workCost.setText(Float.toString(MainActivity.getNumberData().workCost()) + "  " + MainActivity.getNumberData().getCurrency());
        costSum.setText(Float.toString(MainActivity.getNumberData().costSum()) + "  " + MainActivity.getNumberData().getCurrency() );
        ballpark.setText("" + Float.toString(MainActivity.getNumberData().ballparkMin()) + " - " + Float.toString(MainActivity.getNumberData().ballparkMax()) + "  " + MainActivity.getNumberData().getCurrency());


        again = (Button) view.findViewById(R.id.again);
        again.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {

        MainActivity.openFragment(RateFragment.newInstance(), getActivity());


    }
}
