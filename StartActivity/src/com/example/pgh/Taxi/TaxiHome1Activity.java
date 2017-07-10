package com.example.pgh.Taxi;

import com.example.pgh.LoginActivity;
import com.example.pgh.R;
import com.example.pgh.Food.FoodHomeActivity;
import com.example.pgh.R.id;
import com.example.pgh.R.layout;
import com.example.pgh.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TaxiHome1Activity extends Activity implements OnClickListener {

	private Button btnstart;
	private Bundle extra;
	private String tid;
	private String email;
	private TextView txtlogout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_taxi_home1);
		
		extra = getIntent().getExtras();
		tid = extra.getString("tid").toString().trim();
		email = extra.getString("email").toString().trim();
	
		btnstart= (Button)findViewById(R.id.button1);
		btnstart.setOnClickListener(this);
		
		txtlogout = (TextView)findViewById(R.id.textlogout);
		txtlogout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent go = new Intent(TaxiHome1Activity.this,LoginActivity.class);
				startActivity(go);
				finish();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.taxi_home1, menu);
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
	
		if(v==btnstart)
		{
			Intent go = new Intent(TaxiHome1Activity.this,LetsStart1Activity.class);
			go.putExtra("tid",tid.trim());
			go.putExtra("email",email.trim());
			startActivity(go);
			finish();
		}
	}
}
