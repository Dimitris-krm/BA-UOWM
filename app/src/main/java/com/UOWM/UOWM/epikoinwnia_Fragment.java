package com.UOWM.UOWM;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class epikoinwnia_Fragment extends Fragment {
    WebView webview;
    ProgressBar progress;
    SwipeRefreshLayout mySwipeRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_epikoinwnia, container, false);


        webview =(WebView)v.findViewById(R.id.webView);
        progress = (ProgressBar)v.findViewById(R.id.progress);
        mySwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe);




        webview.loadUrl("https://ba.uowm.gr/epikoinonia/");
        WebSettings webSettings = webview.getSettings();
        webSettings.setTextSize(WebSettings.TextSize.SMALLEST);


        webview.getSettings().setSupportZoom(true);
        webview.getSettings().setDisplayZoomControls(true);
        webview.getSettings().setBuiltInZoomControls(true);




        webview.setWebViewClient((new WebViewClient()
        {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progress.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progress.setVisibility(View.GONE);
                mySwipeRefreshLayout.setRefreshing(false);
                super.onPageFinished(view, url);
            }


        }


        ));
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        if(NetworkUtils.isNetworkConnected(getContext())) {
                            webview.setVisibility(View.VISIBLE);
                            webview.reload();
                            mySwipeRefreshLayout.setRefreshing(false);
                        }
                        else {
                            webview.setVisibility(View.INVISIBLE);
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
            webview.setVisibility(View.VISIBLE);
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
                            startActivityForResult(new Intent(
                                    Settings.ACTION_DATA_USAGE_SETTINGS), 0);
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        }






        return v;

    }



    @Override
    public void onResume() {
        super.onResume();

        ((MainActivity) getActivity())
                .setActionBarTitle("Επικοινωνία");
    }
}
