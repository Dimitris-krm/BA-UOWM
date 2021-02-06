package com.UOWM.UOWM;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class Plhrofories_Fragment extends Fragment {
    WebView webview;
    ProgressBar progress;
    SwipeRefreshLayout mySwipeRefreshLayout;
    FloatingActionButton floatx;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_plhrofories, container, false);

        webview =(WebView)v.findViewById(R.id.webView);
        progress = (ProgressBar)v.findViewById(R.id.progress);
        mySwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe);
        floatx = (FloatingActionButton)v.findViewById(R.id.floatx);

        floatx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(true);
                builder.setTitle("Email");
                builder.setMessage("Μπορείτε να πατήσετε επάνω στην ηλεκτρονική διεύθυνση κάθε καθηγήτη ώστε να στείλετε email μέσω της διαθέσιμης εφαρμογής του κινητού σας");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }

                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });



        webview.loadUrl("https://ba.uowm.gr/prosopiko/email-ekpaideytikon//");
        WebSettings webSettings = webview.getSettings();
        webview.getSettings().setUseWideViewPort(true);
        webSettings.setTextSize(WebSettings.TextSize.SMALLEST);
        webview.getSettings().setLoadWithOverviewMode(false);
        webview.setWebViewClient((new WebViewClient()));
        webSettings.setJavaScriptEnabled(true);
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setSupportMultipleWindows(true);
        webview.getSettings().setSupportZoom(true);
        webview.getSettings().setDisplayZoomControls(true);
        webview.getSettings().setBuiltInZoomControls(true);

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
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if ( url.startsWith("mailto:") ) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
                else {
                    view.loadUrl(url);
                }
                return true;
            }


        }));








        return v;

    }





    @Override
    public void onResume() {
        super.onResume();

        ((MainActivity) getActivity())
                .setActionBarTitle("Email Εκπαιδευτικών");
    }
}
