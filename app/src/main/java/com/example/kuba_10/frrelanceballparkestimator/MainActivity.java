package com.example.kuba_10.frrelanceballparkestimator;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.kuba_10.frrelanceballparkestimator.Fragments.CurrencyFragment;
import com.example.kuba_10.frrelanceballparkestimator.Fragments.HoursFragment;
import com.example.kuba_10.frrelanceballparkestimator.Fragments.WelcomeFrag;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity





{


    public FrameLayout container;
    Button startBut;
    private Fragment currency;
    public  static Numbers numberData;

    public static Numbers getNumberData() {
        return numberData;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

      //  ButterKnife.bind(this);

        //THIS IS A TEST FOR GIT REPO//



        container = (FrameLayout) findViewById(R.id.container);

        Fragment welcome = WelcomeFrag.newInstance();
       // currency = CurrencyFragment.newInstance();

        numberData = new Numbers();


        openFragment(welcome);







    }

//    @OnClick(R.id.start)
//    public void start(){
//
////        openFragment();
//
//    }


    public void openFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }



}
