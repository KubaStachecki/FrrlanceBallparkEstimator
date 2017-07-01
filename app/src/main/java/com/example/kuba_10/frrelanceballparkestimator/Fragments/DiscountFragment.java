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

public class DiscountFragment extends Fragment implements View.OnClickListener {


    Button nextBut4;
    Button backBut4;
    TextView input;

    private FragmentLisener fragmentLisener;




    public DiscountFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DiscountFragment newInstance() {
        DiscountFragment fragment = new DiscountFragment();

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_discount, container, false);


        nextBut4 = (Button) view.findViewById(R.id.next4);
        nextBut4.setOnClickListener(this);

        backBut4 = (Button) view.findViewById(R.id.back4);
        backBut4.setOnClickListener(this);


        input = view.findViewById(R.id.discountIn);
        input.setText(Float.toString(fragmentLisener.getNumberData().getDiscount()));



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

            case (R.id.next4):

                fragmentLisener.getNumberData().setDiscount( Float.parseFloat( input.getText().toString() ));


                fragmentLisener.openFragment(BonusFragment.newInstance(), getActivity());


                break;

            case (R.id.back4):

                fragmentLisener.openFragment(CostFragment.newInstance(), getActivity());




        }



    }



}
