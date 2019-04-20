package com.example.emrullah.githubrepoviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoWebView extends AppCompatActivity {

    @BindView(R.id.repo_webview)
    WebView repoWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_web_view);
        ButterKnife.bind(this);

        Intent intent= getIntent();
        String pageUrl = intent.getStringExtra("htmlUrl");
        repoWebView.loadUrl(pageUrl);

    }
}
