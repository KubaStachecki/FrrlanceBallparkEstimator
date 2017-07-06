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
import android.widget.Toast;

import com.example.kuba_10.frrelanceballparkestimator.Currency;
import com.example.kuba_10.frrelanceballparkestimator.FragmentLisener;
import com.example.kuba_10.frrelanceballparkestimator.MainActivity;
import com.example.kuba_10.frrelanceballparkestimator.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class WelcomeFrag extends Fragment implements View.OnClickListener {

    private Button startBut;
    private FragmentLisener fragmentLisener;


    public WelcomeFrag() {
        // Required empty public constructor
    }


    public static WelcomeFrag newInstance() {
        WelcomeFrag fragment = new WelcomeFrag();

        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        fragmentLisener = (FragmentLisener) context;


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        startBut = (Button) view.findViewById(R.id.start);
        startBut.setOnClickListener(this);

        return view;


    }

    @Override
    public void onClick(View view) {

        fragmentLisener.openFragment(CurrencyFragment.newInstance(), getActivity());


        // Toast.makeText(getActivity(), "Working", Toast.LENGTH_SHORT).show();


    }

    public void onBackPressed() {
        getActivity().finish();


    }



}
