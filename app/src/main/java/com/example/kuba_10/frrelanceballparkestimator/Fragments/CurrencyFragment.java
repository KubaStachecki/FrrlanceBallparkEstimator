package com.example.kuba_10.frrelanceballparkestimator.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kuba_10.frrelanceballparkestimator.FragmentLisener;
import com.example.kuba_10.frrelanceballparkestimator.Numbers;
import com.example.kuba_10.frrelanceballparkestimator.MainActivity;

import com.example.kuba_10.frrelanceballparkestimator.Currency;
import com.example.kuba_10.frrelanceballparkestimator.MainActivity;
import com.example.kuba_10.frrelanceballparkestimator.Numbers;
import com.example.kuba_10.frrelanceballparkestimator.R;

import java.util.ArrayList;


public class CurrencyFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ArrayAdapter adapter;
    private ListView listView;
    private ArrayList currList;

    private FragmentLisener fragmentLisener;


    public CurrencyFragment() {
        // Required empty public constructor
    }


    public static CurrencyFragment newInstance() {
        CurrencyFragment fragment = new CurrencyFragment();

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


        View view = inflater.inflate(R.layout.fragment_currency, container, false);

        listView = (ListView) view.findViewById(R.id.currencyListView);


        Currency curr = new Currency();
        currList = curr.currencyList();


        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, currList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        return view;


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        String chosenCurr = (String) adapter.getItem(i);

        fragmentLisener.getNumberData().setCurrency(chosenCurr);

        fragmentLisener.openFragment(RateFragment.newInstance(), getActivity());



      //   Toast.makeText(getActivity(), MainActivity.getNumberData().getCurrency(), Toast.LENGTH_SHORT).show();



    }


}
