package com.example.kuba_10.frrelanceballparkestimator.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.kuba_10.frrelanceballparkestimator.CircularSeekBar;
import com.example.kuba_10.frrelanceballparkestimator.FragmentLisener;
import com.example.kuba_10.frrelanceballparkestimator.R;


public class BonusFragment extends Fragment implements View.OnClickListener {

    private Button nextBut5;
    private Button backBut5;
    private TextView input;
    private CircularSeekBar slider;
    private int bonusAmount;

    private FragmentLisener fragmentLisener;


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


        input = view.findViewById(R.id.bonusIn);


        if (fragmentLisener.getNumberData().getBonus() == 0) {
            input.setText("");
        } else {
            input.setText(Float.toString(fragmentLisener.getNumberData().getBonus()) + "%");
        }

        slider = (CircularSeekBar) view.findViewById(R.id.bonus_circle);

        slider.setProgress((int) fragmentLisener.getNumberData().getBonus());

        slider.setOnSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CircularSeekBar circularSeekBar, int progress, boolean fromUser) {

                input.setText(Integer.toString(progress) + "%");
                bonusAmount = progress;

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

            case (R.id.next5):

                if (input.getText().toString().equals("")) {

                    fragmentLisener.getNumberData().setBonus(0);
                } else

                {
                    fragmentLisener.getNumberData().setBonus(bonusAmount);

                }


                fragmentLisener.openFragment(TaxesFragment.newInstance(), getActivity());


                break;

            case (R.id.back5):

                fragmentLisener.BackButton(getActivity());


//                fragmentLisener.backFragment(DiscountFragment.newInstance(), getActivity());


        }


    }


}
