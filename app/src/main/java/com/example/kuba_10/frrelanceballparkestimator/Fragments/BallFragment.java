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

import com.example.kuba_10.frrelanceballparkestimator.FragmentLisener;
import com.example.kuba_10.frrelanceballparkestimator.R;


public class BallFragment extends Fragment implements View.OnClickListener {


    TextView ballpark;
    Button again;
    private FragmentLisener fragmentLisener;


    public BallFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        fragmentLisener = (FragmentLisener) context;

    }

    // TODO: Rename and change types and number of parameters
    public static BallFragment newInstance() {
        BallFragment fragment = new BallFragment();

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


                View view = inflater.inflate(R.layout.fragment_ball, container, false);


        again = (Button) view.findViewById(R.id.again);
        again.setOnClickListener(this);

        ballpark = view.findViewById(R.id.ballpark);

        ballpark.setText("" + Float.toString(fragmentLisener.getNumberData().ballparkMin()) + " - " + Float.toString(fragmentLisener.getNumberData().ballparkMax()) + "  " + fragmentLisener.getNumberData().getCurrency());





        return view;
    }


    @Override
    public void onClick(View view) {

        fragmentLisener.backFragment(HoursFragment.newInstance(), getActivity());


    }
}

