package com.example.kuba_10.frrelanceballparkestimator;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.Uri;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.support.design.widget.Snackbar;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.kuba_10.frrelanceballparkestimator.Fragments.WelcomeFrag;

import static android.R.id.message;


public class MainActivity extends AppCompatActivity implements FragmentLisener {


    public FrameLayout container;
    Button startBut;
    public Numbers numberData;
    private SharedPreferences sharedPreferences;


    public Numbers getNumberData() {
        return numberData;
    }

    @Override
    public void showSnackbar(String text) {


        //Snackbar.make(this, text,Snackbar.LENGTH_SHORT);

        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        container = (FrameLayout) findViewById(R.id.container);

        Fragment welcome = (Fragment) WelcomeFrag.newInstance();

        numberData = new Numbers();

        openFragment(welcome, this);


        sharedPreferences = this.getSharedPreferences("dane", Context.MODE_PRIVATE);

    }

@Override
    public void openFragment(Fragment fragment, FragmentActivity context) {

        context.getSupportFragmentManager()
                .beginTransaction()
                .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                .replace(R.id.container, fragment)
                .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)

                .commit();
    }

    @Override
    public void saveToSharedPreferences(String note, String key, Context context ) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, note);
        editor.apply();

    }



    @Override
    public String getSharedPreferences(String key){

        return sharedPreferences.getString(key, "");

    }

}
