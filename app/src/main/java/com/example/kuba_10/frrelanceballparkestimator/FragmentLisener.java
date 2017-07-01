package com.example.kuba_10.frrelanceballparkestimator;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;


public interface FragmentLisener {


    public void openFragment(Fragment fragment, FragmentActivity context);

    public void saveToSharedPreferences(String note, String key, Context context, SharedPreferences field) ;

    public String getSharedPreferences(String key, SharedPreferences field );

    public Numbers getNumberData();


}
