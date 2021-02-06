package com.UOWM.UOWM;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Links_fragment extends Fragment {
    TextView intenteclass;
    TextView intentmetaptyxiako;
    TextView sxolh;
    ImageView intenteudoxus;
    ImageView intenttautothta;
    ImageView intentteionline;



    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_links, container, false);
        intenteclass= (TextView)v.findViewById(R.id.eclassintent);
        sxolh= (TextView)v.findViewById(R.id.testphoto2);
        intentmetaptyxiako= (TextView)v.findViewById(R.id.testphoto);
        intenteudoxus= (ImageView)v.findViewById(R.id.eudoxusintent);
        intenttautothta= (ImageView)v.findViewById(R.id.tautothtaintent);
        intentteionline= (ImageView)v.findViewById(R.id.teionline);


        intenteclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://eclass.teiwm.gr"));
                startActivity(browserIntent);

            }
        });
        intenteudoxus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://eudoxus.gr"));
                startActivity(browserIntent);


            }
        });
        intenttautothta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://academicid.minedu.gov.gr"));
                startActivity(browserIntent);

            }
        });

        sxolh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ba.uowm.gr"));
                startActivity(browserIntent);

            }
        });

        intentmetaptyxiako.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mba-g.uowm.gr"));
                startActivity(browserIntent);

            }
        });

        intentteionline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://osrv1.teiwm.gr/b1/first.htm"));
                startActivity(browserIntent);
            }
        });

        return v;


    }
    public void onResume() {
        super.onResume();

        ((MainActivity) getActivity())
                .setActionBarTitle("Χρήσιμες Διευθύνσεις");
    }

}