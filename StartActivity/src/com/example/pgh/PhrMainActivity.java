package com.example.pgh;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class PhrMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phr_main);
		
		String url = "http://192.168.43.184/pgh/location/Pharmcy" + ".php";
		WebView view = (WebView)this.findViewById(R.id.webView2);
		view.getSettings().setJavaScriptEnabled(true);
		view.loadUrl(url);
		
	}

	

}
