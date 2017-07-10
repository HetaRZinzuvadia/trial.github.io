package com.example.pgh;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LocMainActivity extends Activity {

	private Button btnres;
	private Button btngos;
	private Button btnphr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loc_main);
		
		
		btnres = (Button)findViewById(R.id.res);
		btngos=(Button)findViewById(R.id.gos);
		btnphr=(Button)findViewById(R.id.phr);
		
		
		
		btnres.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(LocMainActivity.this,ResMainActivity.class);
				startActivity(i);
			}
		});
		
		
		btnphr.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent z = new Intent(LocMainActivity.this,PhrMainActivity.class);
				startActivity(z);
			}
		});
		
		btngos.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent y = new Intent(LocMainActivity.this,GosMainActivity.class);
				startActivity(y);
			}
		});
		
	}

	

}
