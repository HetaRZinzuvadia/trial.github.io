package com.example.pgh;

import com.example.pgh.User.SearchPropertyActivity;
import com.example.pgh.User.SearchTaxiActivity;
import com.example.pgh.User.ShowFoodActivity;
import com.example.pgh.User.ShowWaterActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;

public class UserHomeActivity extends Activity implements OnClickListener {

	private ImageView btnhome;
	private ImageView btntaxi;
	private ImageView btnfood;
	private ImageView btnwater;
	private ImageView imgprofile;
	private Bundle extra;
	private String email;
	private TextView txtlogout;
	private Button btnorder;
	
	private ImageView btnloca;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_home);
		
	 	extra = getIntent().getExtras();
    	email= extra.getString("email").trim();
	
		//email="heta@gmail.com";
    	
		btnhome = (ImageView)findViewById(R.id.imageView1);
		btntaxi = (ImageView)findViewById(R.id.imageView2);
		btnfood = (ImageView)findViewById(R.id.imageView3);
		btnwater = (ImageView)findViewById(R.id.imageView4);
		btnloca= (ImageView)findViewById(R.id.imageView5);
		imgprofile=(ImageView)findViewById(R.id.imageView6);
	
	btnloca.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(UserHomeActivity.this,LocMainActivity.class);
			startActivity(i);
			
		}
	});
		
		imgprofile.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//			Toast.makeText(UserHomeActivity.this, "Welcome", Toast.LENGTH_LONG).show();	
				Intent intent=new Intent(UserHomeActivity.this, ShowProfile.class);
				intent.putExtra("email", email);
				startActivity(intent);
			}
		});
			
		btnhome.setScaleType(ScaleType.FIT_XY);
		btntaxi.setScaleType(ScaleType.FIT_XY);
		btnfood.setScaleType(ScaleType.FIT_XY);
		btnwater.setScaleType(ScaleType.FIT_XY);
		
		btnhome.setOnClickListener(this);
		btntaxi.setOnClickListener(this);
		btnfood.setOnClickListener(this);
		btnwater.setOnClickListener(this);
		
/*		btnorder = (Button)findViewById(R.id.button1);
		btnorder.setOnClickListener(this);
*/		
		txtlogout = (TextView)findViewById(R.id.textlogout);
		txtlogout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent go = new Intent(UserHomeActivity.this,LoginActivity.class);
				startActivity(go);
				finish();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_home, menu);
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
	
		if(v==btnhome)
		{
			Intent go = new Intent(UserHomeActivity.this,SearchPropertyActivity.class);
			go.putExtra("email",email.trim());
			startActivity(go);
		}
	
		if(v==btnfood)
		{
			Intent go = new Intent(UserHomeActivity.this,ShowFoodActivity.class);
			go.putExtra("email",email.trim());
			startActivity(go);
		}
		
		if(v==btnwater)
		{
			Intent go = new Intent(UserHomeActivity.this,ShowWaterActivity.class);
			go.putExtra("email",email.trim());
			startActivity(go);
		}
	
		if(v==btntaxi)
		{
			Intent go = new Intent(UserHomeActivity.this,SearchTaxiActivity.class);
			go.putExtra("email",email.trim());
			startActivity(go);
		}
		
/*		if(v==btnorder)
		{
			Intent go = new Intent(UserHomeActivity.this,UserOrderActivity.class);
			go.putExtra("email",email.trim());
			startActivity(go);
		}
*/
	}
}
