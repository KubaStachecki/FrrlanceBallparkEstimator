package com.example.kuba_10.frrelanceballparkestimator;

import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.net.Uri;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.kuba_10.frrelanceballparkestimator.Fragments.WelcomeFrag;


public class MainActivity extends AppCompatActivity {


    public FrameLayout container;
    Button startBut;
    public static Numbers numberData;

    public static Numbers getNumberData() {
        return numberData;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        //THIS IS A TEST FOR GIT REPO//


        container = (FrameLayout) findViewById(R.id.container);

        Fragment welcome = (Fragment) WelcomeFrag.newInstance();

        numberData = new Numbers();

        openFragment(welcome);




    }


    private void openFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

}
