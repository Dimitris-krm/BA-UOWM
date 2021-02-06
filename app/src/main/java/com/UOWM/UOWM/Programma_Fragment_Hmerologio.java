package com.UOWM.UOWM;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Programma_Fragment_Hmerologio extends Fragment {
    ProgressBar progress;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_programma_hmerologio, container, false);
        final WebView webView = (WebView)v.findViewById(R.id.webexe);



        progress = (ProgressBar) v.findViewById(R.id.progress);
        webView.setWebViewClient((new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progress.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progress.setVisibility(View.GONE);

                super.onPageFinished(view, url);
            }
        }));
        String url ="https://ba.uowm.gr/wp-content/uploads/sites/9/2019/10/Tropopoiisi-akadimaikou-imerologiou_2019-2020_signed.pdf";
        String finalurl= "https://drive.google.com/viewerng/viewer?embedded=true&url="+url;
        webView.loadUrl(finalurl);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);


        WebSettings webSettings = webView.getSettings();
        webSettings.setTextSize(WebSettings.TextSize.SMALLEST);
        webView.getSettings().setUserAgentString("Desktop");


        if (NetworkUtils.isNetworkConnected(getContext())) {
            webView.setVisibility(View.VISIBLE);
        } else
        {
            Toast.makeText(getContext(),"Δεν υπάρχει σύνδεση στο διαδίκτυο", Toast.LENGTH_LONG).show();
        }









        webView.loadUrl(finalurl);

        return v;

    }
}
