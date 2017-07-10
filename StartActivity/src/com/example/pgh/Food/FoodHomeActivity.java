package com.example.pgh.Food;

import com.example.pgh.LoginActivity;
import com.example.pgh.R;
import com.example.pgh.Property.AddPropertyAdvActivity;
import com.example.pgh.ConditionMainActivity;
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
import android.widget.EditText;
import android.widget.TextView;

public class FoodHomeActivity extends Activity implements OnClickListener {

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
		setContentView(R.layout.activity_food_home);
	
	  	extra = getIntent().getExtras();
    	email= extra.getString("email").trim();
		
		btnAdd = (Button)findViewById(R.id.button1);
		btnmy = (Button)findViewById(R.id.button2);
		btnorder= (Button)findViewById(R.id.button3);
		btnpack=(Button)findViewById(R.id.btnpac);
		
		btnAdd.setOnClickListener(this);
		btnmy.setOnClickListener(this);
		btnorder.setOnClickListener(this);
		
		btnpack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(FoodHomeActivity.this,ConditionMainActivity.class);
				startActivity(i);
				
			}
		});
	
		
		
		
		txtlogout = (TextView)findViewById(R.id.textlogout);
		txtlogout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent go = new Intent(FoodHomeActivity.this,LoginActivity.class);
				startActivity(go);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.food_home, menu);
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
			Intent go = new Intent(FoodHomeActivity.this,AddFoodAdvActivity.class);
			go.putExtra("email",email);
			startActivity(go);
		}
		
		if(v==btnmy)
		{
			Intent go = new Intent(FoodHomeActivity.this,FoodMyAdvActivity.class);
			go.putExtra("email",email);
			startActivity(go);
		}
		
		if(v==btnorder)
		{
			Intent intent=new Intent(FoodHomeActivity.this, FoodFacOrderMainActivity.class);
			intent.putExtra("email", email);
			startActivity(intent);
		}

	}
}
