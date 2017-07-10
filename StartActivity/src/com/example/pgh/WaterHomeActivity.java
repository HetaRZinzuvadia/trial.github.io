package com.example.pgh;

import com.example.pgh.Property.AddPropertyAdvActivity;
import com.example.pgh.Water.AddWaterAdvActivity;
import com.example.pgh.Water.WaterFacOrdMainActivity;
import com.example.pgh.Water.WaterMyAdvActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WaterHomeActivity extends Activity implements OnClickListener {

	private Bundle extra;
	private String email;
	private Button btnAdd;
	private Button btnmy;
	private TextView txtlogout;
	private Button btnorder;
	private Button btnpack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_water_home);
		
		extra = getIntent().getExtras();
    	email= extra.getString("email").trim();
		
		btnAdd = (Button)findViewById(R.id.button1);
		btnmy = (Button)findViewById(R.id.button2);
		btnorder=(Button)findViewById(R.id.button3);
		btnpack=(Button)findViewById(R.id.btnpac);
		
		btnAdd.setOnClickListener(this);
		btnmy.setOnClickListener(this);
		btnorder.setOnClickListener(this);
		btnpack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent intent=new Intent(WaterHomeActivity.this, ConditionMainActivity1.class);
			startActivity(intent);
			}
		});
		
		txtlogout = (TextView)findViewById(R.id.textlogout);
		txtlogout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent go = new Intent(WaterHomeActivity.this,LoginActivity.class);
				startActivity(go);
				finish();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.water_home, menu);
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
			Intent go = new Intent(WaterHomeActivity.this,AddWaterAdvActivity.class);
			go.putExtra("email",email);
			startActivity(go);
		}
		
		if(v==btnmy)
		{
			Intent go = new Intent(WaterHomeActivity.this,WaterMyAdvActivity.class);
			go.putExtra("email",email);
			startActivity(go);
		}
		
		if(v==btnorder)
		{
			Intent go = new Intent(WaterHomeActivity.this,WaterFacOrdMainActivity.class);
			go.putExtra("email",email);
			startActivity(go);
		}
		
		/*if(v==btnpack)
		{
			Intent i=new Intent(WaterHomeActivity.this, ConditionMainActivity1.class);
			startActivity(i);
//		Toast.makeText(WaterHomeActivity.this, "thayu", Toast.LENGTH_LONG).show();
		}*/

	}
}
