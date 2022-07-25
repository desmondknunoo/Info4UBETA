package com.goodnewstechnologies.info4ubeta;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Karthik's on 3/5/2015.
 */
public class MyAppWebViewClient extends WebViewClient {
	 WebView myWebView;
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(Uri.parse(url).getHost().endsWith("http://info4ugh.blogspot.co.ke/?m=1")) {
            return false;
        }
    
   
	myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });


        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }
    
}

