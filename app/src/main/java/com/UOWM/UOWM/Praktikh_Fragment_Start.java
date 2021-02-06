package com.UOWM.UOWM;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import static android.content.Context.DOWNLOAD_SERVICE;

public class Praktikh_Fragment_Start extends Fragment {
    ProgressBar progress;
    SwipeRefreshLayout mySwipeRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_praktikh_start, container, false);



        final WebView webView = (WebView) v.findViewById(R.id.praktikhstart);
        mySwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe);
        progress = (ProgressBar) v.findViewById(R.id.progress);
        webView.setWebViewClient((new WebViewClient()
        {

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.endsWith(".pdf")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse(url), "application/pdf");
                    try {
                        view.getContext().startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        //user does not have a pdf viewer installed
                    }
                } else {
                    webView.loadUrl(url);
                }
                return true;
            }

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

        String url ="https://ba.uowm.gr/praktiki/enarxi-praktikis-askisis/";
        webView.loadUrl(url);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);



        WebSettings webSettings = webView.getSettings();
        webSettings.setTextSize(WebSettings.TextSize.SMALLEST);
        webView.getSettings().setUserAgentString("Desktop");
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.getSettings().setBuiltInZoomControls(true);


        if (NetworkUtils.isNetworkConnected(getContext())) {
            webView.setVisibility(View.VISIBLE);
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






        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {


                    @Override
                    public void onRefresh() {
                        if(NetworkUtils.isNetworkConnected(getContext())) {
                            webView.setVisibility(View.VISIBLE);
                            webView.reload();
                            mySwipeRefreshLayout.setRefreshing(false);

                        }
                        else {
                            webView.setVisibility(View.INVISIBLE);
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


        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack())
                { webView.goBack(); return true; }


                return false;
            }
        });






        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long contentLength) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));

                request.setMimeType(mimeType);
                //------------------------COOKIE!!------------------------
                String cookies = CookieManager.getInstance().getCookie(url);
                request.addRequestHeader("cookie", cookies);
                //------------------------COOKIE!!------------------------
                request.addRequestHeader("User-Agent", userAgent);
                request.setDescription("Downloading");
                request.setTitle(URLUtil.guessFileName(url, contentDisposition, mimeType));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url, contentDisposition, mimeType));
                DownloadManager dm = (DownloadManager) getActivity().getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
                Toast.makeText(getContext(), "Downloading File", Toast.LENGTH_LONG).show();
            }
        });


        return v;


    }
}
