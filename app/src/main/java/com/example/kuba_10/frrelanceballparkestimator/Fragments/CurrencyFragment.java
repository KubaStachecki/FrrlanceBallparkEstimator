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



    public CurrencyFragment() {
        // Required empty public constructor
    }


    public static CurrencyFragment newInstance() {
        CurrencyFragment fragment = new CurrencyFragment();

        return fragment;
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

        String test = (String) adapter.getItem(i);

        MainActivity.getNumberData().setCurrency(test);





        Toast.makeText(getActivity(),
                "List click " + test, Toast.LENGTH_SHORT)
                .show();


        FragmentTransaction ft1 = getFragmentManager().beginTransaction();


        ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                .replace(R.id.container, RateFragment.newInstance())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();




    }


//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
