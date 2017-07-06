package com.example.kuba_10.frrelanceballparkestimator.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.kuba_10.frrelanceballparkestimator.FragmentLisener;
import com.example.kuba_10.frrelanceballparkestimator.MainActivity;
import com.example.kuba_10.frrelanceballparkestimator.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;


public class FinalFragment extends Fragment implements View.OnClickListener {

    private TextView workCost;
    private TextView costSum;
    private Button ball;

    private PieChart chart;

    private FragmentLisener fragmentLisener;


    public FinalFragment() {
        // Required empty public constructor
    }


    public static FinalFragment newInstance() {
        FinalFragment fragment = new FinalFragment();

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
        View view = inflater.inflate(R.layout.fragment_final, container, false);

        ball = (Button) view.findViewById(R.id.ballpark);
        ball.setOnClickListener(this);

//        workCost = view.findViewById(R.id.workCost);
//        costSum = view.findViewById(R.id.costSum);


//        workCost.setText(Float.toString(fragmentLisener.getNumberData().workCost()) + "  " + fragmentLisener.getNumberData().getCurrency());
//        costSum.setText(Float.toString(fragmentLisener.getNumberData().costSum()) + "  " + fragmentLisener.getNumberData().getCurrency());


        chart = (PieChart) view.findViewById(R.id.chart);

        chart.setCenterText("Summary: \n" + Integer.toString((int) fragmentLisener.getNumberData().costSum()) + " " + fragmentLisener.getNumberData().getCurrency());
        chart.setRotationEnabled(true);
        chart.setHoleRadius(65);
        chart.setCenterTextSize(20);
        chart.setTransparentCircleRadius(75);
        chart.setTransparentCircleAlpha(50);
        chart.setEntryLabelColor(Color.BLACK);
        chart.setEntryLabelTextSize(10);
        chart.animateY(2000);

        Description desc = new Description();

        desc.setText("");
        chart.setDescription(desc);

        addData();


        chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

            }

            @Override
            public void onNothingSelected() {

            }
        });


        return view;
    }


    @Override
    public void onClick(View view) {

        fragmentLisener.openFragment(BallFragment.newInstance(), getActivity());


    }


    private void addData() {


        ArrayList<Float> pieList = new ArrayList<>();

        pieList.add(fragmentLisener.getNumberData().discountCost());
        pieList.add(fragmentLisener.getNumberData().taxesCost());
        pieList.add(fragmentLisener.getNumberData().bonusCost());
        pieList.add(fragmentLisener.getNumberData().getCost());

        ArrayList<String> nameList = new ArrayList<>();

        nameList.add("Work");
        nameList.add("Taxes");
        nameList.add("Bonus");
        nameList.add("Costs");


        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        for (int i = 0; i < pieList.size(); i++) {

            pieEntries.add((new PieEntry(pieList.get(i), nameList.get(i))));


        }


        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");

        pieDataSet.setSliceSpace(5);
        pieDataSet.setValueTextSize(12);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(ContextCompat.getColor(getActivity(), R.color.wheel1));
        colors.add(ContextCompat.getColor(getActivity(), R.color.wheel2));
        colors.add(ContextCompat.getColor(getActivity(), R.color.wheel3));
        colors.add(ContextCompat.getColor(getActivity(), R.color.wheel4));

        pieDataSet.setColors(colors);


        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.DEFAULT);
        legend.setEnabled(false);


        PieData pieData = new PieData(pieDataSet);
        chart.setData(pieData);

        chart.invalidate();


    }
}
