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

public class KTEL_Fragment_Metabash extends Fragment {
    WebView metabash;
    SwipeRefreshLayout mySwipeRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ktel_metabash, container, false);

        metabash = (WebView)v.findViewById(R.id.ktelmetabash);
        mySwipeRefreshLayout = (SwipeRefreshLayout)v.findViewById(R.id.swipe);


        String url ="https://ba.uowm.gr/foititika/metavasi-apo-kai-pros-ta-grevena/";
        metabash.loadUrl(url);
        metabash.getSettings().setJavaScriptEnabled(true);
        metabash.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        metabash.getSettings().setSupportZoom(true);
        metabash.getSettings().setDisplayZoomControls(true);
        metabash.getSettings().setBuiltInZoomControls(true);



        WebSettings webSettings = metabash.getSettings();
        webSettings.setTextSize(WebSettings.TextSize.SMALLEST);
        metabash.getSettings().setUserAgentString("Desktop");


        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {


                    @Override
                    public void onRefresh() {
                        if(NetworkUtils.isNetworkConnected(getContext())) {

                            metabash.reload();
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
