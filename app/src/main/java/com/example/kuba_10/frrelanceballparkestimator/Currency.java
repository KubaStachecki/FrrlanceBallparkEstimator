package com.example.kuba_10.frrelanceballparkestimator;

import java.util.*;




public class Currency {

    private ArrayList<String> currency;


    public  ArrayList currencyList(){


        currency = new ArrayList<String>();


        currency.add("USD");
        currency.add("PLN");
        currency.add("GBP");
        currency.add("THB");
        currency.add("EUR");
        currency.add("YEN");
        currency.add("CHF");
        currency.add("CNY");




        return currency;
    }


}
