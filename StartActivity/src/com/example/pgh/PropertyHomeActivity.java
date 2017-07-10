package com.example.pgh;

import com.example.pgh.Property.AddPropertyAdvActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PropertyHomeActivity extends Activity implements OnClickListener{

	private Button btnAdd;
	private Button btnmy;
	private Bundle extra;
	private String email;
	private TextView txtlogout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_property_home);
		
    	extra = getIntent().getExtras();
    	email= extra.getString("email").trim();
		
		btnAdd = (Button)findViewById(R.id.button1);
		btnmy = (Button)findViewById(R.id.button2);
		
		btnAdd.setOnClickListener(this);
		btnmy.setOnClickListener(this);
		
		txtlogout = (TextView)findViewById(R.id.textlogout);
		txtlogout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent go = new Intent(PropertyHomeActivity.this,LoginActivity.class);
				startActivity(go);
				finish();
			}
		});

		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.property_home, menu);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==btnAdd)
		{
			Intent go = new Intent(PropertyHomeActivity.this,AddPropertyAdvActivity.class);
			go.putExtra("email",email);
			startActivity(go);
		}
		
		if(v==btnmy)
		{
			Intent go = new Intent(PropertyHomeActivity.this,PropertyMyAdvActivity.class);
			go.putExtra("email",email);
			startActivity(go);
		}

	}
}
