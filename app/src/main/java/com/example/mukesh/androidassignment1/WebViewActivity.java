package com.example.mukesh.androidassignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Bundle bundle = getIntent().getExtras();
        final Players player = (Players) bundle.getSerializable("data");

        setTitle(player.getUrl());

        progressBar = findViewById(R.id.pB1);
        webView = findViewById(R.id.playerWebview);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress < 100 && (progressBar.getVisibility() == ProgressBar.GONE)){
                    progressBar.setVisibility(ProgressBar.VISIBLE);
                }
                progressBar.setProgress(newProgress);
                if(newProgress == 100){
                    setTitle(player.getName());
                    progressBar.setVisibility(ProgressBar.GONE);
                }
            }
        });
        webView.setWebViewClient(new WebViewController());
        webView.loadUrl(player.getUrl());
    }
}
