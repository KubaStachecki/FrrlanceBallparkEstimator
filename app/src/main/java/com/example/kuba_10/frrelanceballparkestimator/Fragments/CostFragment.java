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


public class CostFragment extends Fragment implements View.OnClickListener {


    private Button nextBut3;
    private Button backBut3;
    private TextView input;
    private TextView currency;


    private FragmentLisener fragmentLisener;


    public CostFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CostFragment newInstance() {
        CostFragment fragment = new CostFragment();

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
        View view = inflater.inflate(R.layout.fragment_cost, container, false);


        nextBut3 = (Button) view.findViewById(R.id.next3);
        nextBut3.setOnClickListener(this);

        backBut3 = (Button) view.findViewById(R.id.back3);
        backBut3.setOnClickListener(this);

        input = view.findViewById(R.id.costIn);

        currency = view.findViewById(R.id.cost_curr);
        currency.setText(fragmentLisener.getNumberData().getCurrency());

        if (fragmentLisener.getNumberData().getCost() == 0) {

            input.setText("");

        } else {

            input.setText(Float.toString(fragmentLisener.getNumberData().getCost()));
        }


        return view;
    }


    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case (R.id.next3):

                if (input.getText().toString().equals("")) {

                    fragmentLisener.getNumberData().setCost(0);
                } else

                {
                    fragmentLisener.getNumberData().setCost(Float.parseFloat(input.getText().toString()));

                }


                fragmentLisener.openFragment(DiscountFragment.newInstance(), getActivity());

                break;

            case (R.id.back3):

                fragmentLisener.BackButton(getActivity());


//                fragmentLisener.backFragment(HoursFragment.newInstance(), getActivity());

        }
    }
}
