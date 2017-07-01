package com.example.kuba_10.frrelanceballparkestimator;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;


public interface FragmentLisener {


   void openFragment(Fragment fragment, FragmentActivity context);

   void backFragment(Fragment fragment, FragmentActivity context);

   void saveToSharedPreferences(String note, String key, Context context);

   String getSharedPreferences(String key);

   Numbers getNumberData();

     void showSnackbar(String text);


}
