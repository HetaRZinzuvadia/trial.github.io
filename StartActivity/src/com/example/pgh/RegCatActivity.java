package com.example.pgh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RegCatActivity extends Activity implements OnClickListener {

	private Button btnproperty;
	private Button btntaxi;
	private Button btnfood;
	private Button btnwater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg_cat);
		
		btnproperty = (Button)findViewById(R.id.button1);
		btntaxi = (Button)findViewById(R.id.button2);
		btnfood = (Button)findViewById(R.id.button3);
		btnwater = (Button)findViewById(R.id.btnpac);
			
		btnproperty.setOnClickListener(this);
		btntaxi.setOnClickListener(this);
		btnfood.setOnClickListener(this);
		btnwater.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reg_cat, menu);
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
		
		if(v==btnproperty)
		{
			Intent go = new Intent(RegCatActivity.this,UserRegisterActivity.class);
			go.putExtra("Role", "Property");
			startActivity(go);
			finish();
		}
		
		if(v==btntaxi)
		{
			Intent go = new Intent(RegCatActivity.this,UserRegister1Activity.class);
			go.putExtra("Role", "Taxi");
			startActivity(go);
			finish();
		}
		if(v==btnfood)
		{
			Intent go = new Intent(RegCatActivity.this,UserRegister1Activity.class);
			go.putExtra("Role", "Food");
			startActivity(go);
			finish();
		}
		if(v==btnwater)
		{
			Intent go = new Intent(RegCatActivity.this,UserRegister1Activity.class);
			go.putExtra("Role", "Water");
			startActivity(go);
			finish();
		}
		
		

	}
}
