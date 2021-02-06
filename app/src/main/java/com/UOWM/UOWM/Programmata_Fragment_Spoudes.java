package com.UOWM.UOWM;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class Programmata_Fragment_Spoudes extends Fragment {
    WebView spoudes;
    SwipeRefreshLayout mySwipeRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_programmata_spoudes, container, false);

        spoudes = (WebView)v.findViewById(R.id.programmataspoudes);
        mySwipeRefreshLayout = (SwipeRefreshLayout)v.findViewById(R.id.swipe);


        String url ="https://ba.uowm.gr/spoydes/";
        spoudes.loadUrl(url);
        spoudes.getSettings().setJavaScriptEnabled(true);
        spoudes.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        WebSettings webSettings = spoudes.getSettings();
        webSettings.setTextSize(WebSettings.TextSize.SMALLEST);
        spoudes.getSettings().setSupportZoom(true);
        spoudes.getSettings().setDisplayZoomControls(true);
        spoudes.getSettings().setBuiltInZoomControls(true);



        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {


                    @Override
                    public void onRefresh() {
                        if(NetworkUtils.isNetworkConnected(getContext())) {

                            spoudes.reload();
                            mySwipeRefreshLayout.setRefreshing(false);

                        }
                        else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setCancelable(true);
                            builder.setTitle("Δεν υπάρχει σύνδεση στο διαδίκτυο");
                            builder.setMessage("Θέλετε να ενεργοποείσετε το WiFi ή Δεδομένα;");
                            builder.setNegativeButton("WiFi", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    startActivityForResult(new Intent(
                                            Settings.ACTION_WIFI_SETTINGS), 0);
                                }
                            });
                            builder.setPositiveButton("Δεδομένα",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            startActivityForResult(new Intent(
                                                    Settings.ACTION_DATA_USAGE_SETTINGS), 0);
                                        }
                                    });

                            AlertDialog dialog = builder.create();
                            dialog.show();
                            mySwipeRefreshLayout.setRefreshing(false);
                        }
                    }

                }

        );


        if (NetworkUtils.isNetworkConnected(getContext())) {

        } else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setCancelable(true);
            builder.setTitle("Δεν υπάρχει σύνδεση στο διαδίκτυο");
            builder.setMessage("Θέλετε να ενεργοποείσετε το WiFi ή Δεδομένα;");
            builder.setNegativeButton("WiFi", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivityForResult(new Intent(
                            Settings.ACTION_WIFI_SETTINGS), 0);
                }
            });
            builder.setPositiveButton("Δεδομένα",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            try{  startActivityForResult(new Intent(
                                    Settings.ACTION_DATA_USAGE_SETTINGS), 0);} catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        }





        return v;


    }
}
