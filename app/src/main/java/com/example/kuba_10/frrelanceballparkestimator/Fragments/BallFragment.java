package com.example.kuba_10.frrelanceballparkestimator.Fragments;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kuba_10.frrelanceballparkestimator.FragmentLisener;
import com.example.kuba_10.frrelanceballparkestimator.R;


public class BallFragment extends Fragment implements View.OnClickListener {


    private TextView ballpark;
    private Button again;
    private FragmentLisener fragmentLisener;


    private Button emailButt;
    private Button smsButt;
    private Button clipButt;

    private String ballparkFinal;


    public BallFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        fragmentLisener = (FragmentLisener) context;

    }

    // TODO: Rename and change types and number of parameters
    public static BallFragment newInstance() {
        BallFragment fragment = new BallFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_ball, container, false);


        again = (Button) view.findViewById(R.id.again);
        again.setOnClickListener(this);

        ballpark = view.findViewById(R.id.ballpark);


        ballparkFinal = "" + Integer.toString((int) fragmentLisener.getNumberData().ballparkMin())
                + " - " + Integer.toString((int) fragmentLisener.getNumberData().ballparkMax())
                + "  " + fragmentLisener.getNumberData().getCurrency();


        ballpark.setText(ballparkFinal);


        clipButt = view.findViewById(R.id.clip_butt);
        smsButt = view.findViewById(R.id.sms_butt);
        emailButt = view.findViewById(R.id.email_butt);

        clipButt.setOnClickListener(this);
        smsButt.setOnClickListener(this);
        emailButt.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.again:

                fragmentLisener.backFragment(HoursFragment.newInstance(), getActivity());

//                Toast.makeText(getActivity(), "test guzika back merge", Toast.LENGTH_SHORT).show();

                break;
            case R.id.sms_butt:

//                Toast.makeText(getActivity(), "test guzika sms", Toast.LENGTH_SHORT).show();

                sendSms();

                break;

            case R.id.email_butt:

//                Toast.makeText(getActivity(), "test guzika mail", Toast.LENGTH_SHORT).show();

                sendMail();

                break;

            case R.id.clip_butt:

                ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("ballpark", ballparkFinal);

                clipboard.setPrimaryClip(clip);

                Toast.makeText(getActivity(), "Copied to clipboard", Toast.LENGTH_SHORT).show();


        }
    }

    private void sendSms() {
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse("sms:"));
        sendIntent.putExtra("sms_body", ballparkFinal);
        startActivity(sendIntent);
    }

    private void sendMail() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "");
        intent.putExtra(Intent.EXTRA_SUBJECT, "My first price estimation");
        intent.putExtra(Intent.EXTRA_TEXT, "Ballpark buget: " + ballparkFinal);

        startActivity(Intent.createChooser(intent, "Send Email"));
    }


}

