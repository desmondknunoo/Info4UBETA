package com.goodnewstechnologies.info4ubeta;

import android.app.Activity; 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings; 
import android.webkit.WebView;
import android.widget.Button; 
 
 
 
 
public class MainActivity extends Activity { 
 
     private WebView mWebView; 
     		 Button button;
 
 
     @Override 
     protected void onCreate(Bundle savedInstanceState) { 
         super.onCreate(savedInstanceState); 
         setContentView(R.layout.activity_main); 
  
 		// Locate the button in activity_main.xml
 		button = (Button) findViewById(R.id.button2);
  
 		// Capture button clicks
 		button.setOnClickListener(new OnClickListener() {
 			public void onClick(View arg0) {
  
 				// Start NewActivity.class
 				Intent myIntent = new Intent(MainActivity.this,
 						SplashActivity.class);
 				startActivity(myIntent);
 			}});
 		
 
         mWebView = (WebView)findViewById(R.id.activity_main_webview); 
         WebSettings webSettings = mWebView.getSettings(); 
         webSettings.setJavaScriptEnabled(true); 
         mWebView.loadUrl("http://info4ugh.blogspot.co.ke/?m=1"); 
         mWebView.setWebViewClient(new com.goodnewstechnologies.info4ubeta.MyAppWebViewClient(){ 
             @Override 
             public void onPageFinished(WebView view, String url) { 
                 //hide loading image 
                 findViewById(R.id.progressBar1).setVisibility(View.GONE); 
                 //show webview 
                 findViewById(R.id.activity_main_webview).setVisibility(View.VISIBLE); 
             }}); 
  
 
     } 
 
      @Override 
     public void onBackPressed() { 
         if(mWebView.canGoBack()) { 
             mWebView.goBack(); 
         } else { 
             super.onBackPressed(); 
         } 
     } 
 
  

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
