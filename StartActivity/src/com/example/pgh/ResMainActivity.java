package com.example.pgh;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class ResMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_res_main);
		
		String url = "http://192.168.43.184/pgh/location/restaurant" + ".php";
		
		WebView view = (WebView)this.findViewById(R.id.webView1);
		view.getSettings().setJavaScriptEnabled(true);
		view.loadUrl(url);
		
	}

	

}
