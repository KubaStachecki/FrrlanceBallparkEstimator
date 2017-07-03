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
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.kuba_10.frrelanceballparkestimator.CircularSeekBar;

import com.example.kuba_10.frrelanceballparkestimator.FragmentLisener;
import com.example.kuba_10.frrelanceballparkestimator.MainActivity;
import com.example.kuba_10.frrelanceballparkestimator.R;




public class DiscountFragment extends Fragment implements View.OnClickListener  {


    Button nextBut4;
    Button backBut4;
    TextView input;
    CircularSeekBar slider;

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

        View view = inflater.inflate(R.layout.fragment_discount, container, false);


        nextBut4 = (Button) view.findViewById(R.id.next4);
        nextBut4.setOnClickListener(this);

        backBut4 = (Button) view.findViewById(R.id.back4);
        backBut4.setOnClickListener(this);


        input = view.findViewById(R.id.discountIn);

        if (fragmentLisener.getNumberData().getDiscount() == 0) {

            input.setText("");

        } else {

            input.setText(Float.toString(fragmentLisener.getNumberData().getDiscount()));

        }

        slider = (CircularSeekBar) view.findViewById(R.id.discount_circle);


        slider.setProgress((int) fragmentLisener.getNumberData().getDiscount());

        slider.setOnSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CircularSeekBar circularSeekBar, int progress, boolean fromUser) {

                input.setText(Integer.toString(progress));

            }

            @Override
            public void onStopTrackingTouch(CircularSeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(CircularSeekBar seekBar) {

            }
        });







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

                if (input.getText().toString().equals("")) {

                    fragmentLisener.getNumberData().setDiscount(0);

                    Toast.makeText(getActivity(), Float.toString(fragmentLisener.getNumberData().getDiscount()) + "jestesmy w if", Toast.LENGTH_LONG ).show();


                } else

                {
                   fragmentLisener.getNumberData().setDiscount(Float.parseFloat(input.getText().toString()));

                    Toast.makeText(getActivity(), Float.toString(fragmentLisener.getNumberData().getDiscount()), Toast.LENGTH_LONG ).show();

                }


                fragmentLisener.openFragment(BonusFragment.newInstance(), getActivity());


                break;

            case (R.id.back4):

                fragmentLisener.backFragment(CostFragment.newInstance(), getActivity());


        }


    }


}
