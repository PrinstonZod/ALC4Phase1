package com.example.android.alc4phase1;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;

public class WebViewActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private WebView alcWebPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        alcWebPage = findViewById(R.id.alc_link);
        progressBar = findViewById(R.id.profile);
        progressBar.setMax(100);


        alcWebPage.getSettings().setLoadWithOverviewMode(true);
        alcWebPage.getSettings().setUseWideViewPort(true);
        alcWebPage.getSettings().setBuiltInZoomControls(true);
        alcWebPage.getSettings().setDisplayZoomControls(false);
        alcWebPage.getSettings().setJavaScriptEnabled(true);
        alcWebPage.getSettings().setDomStorageEnabled(true);
        alcWebPage.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        alcWebPage.setScrollbarFadingEnabled(false);

        alcWebPage.setWebChromeClient(new WebChromeClient());
        alcWebPage.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
               handler.proceed();

            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }

        });
        alcWebPage.loadUrl("https://andela.com/alc/");
    }

    @Override
    public void onBackPressed() {
        if (alcWebPage.canGoBack()){
            alcWebPage.goBack();
        }else {
            finish();
        }
    }

}
