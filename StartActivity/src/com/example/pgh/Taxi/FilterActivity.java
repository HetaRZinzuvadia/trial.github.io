package com.example.pgh.Taxi;

import com.example.pgh.R;
import com.example.pgh.R.id;
import com.example.pgh.R.layout;
import com.example.pgh.R.menu;
import com.example.pgh.User.SearchTaxiActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Toast;

public class FilterActivity extends Activity implements OnClickListener{

	private Button btnfilter;
	private CheckBox chk1;
	private EditText editstart;
	private EditText editend;
	private CheckBox chk2;
	private String pstart;
	private String pend;
	private Bundle extra;
	private String stype;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_filter);
		
		extra = getIntent().getExtras();
		stype = extra.getString("name");
	
		editstart = (EditText)findViewById(R.id.editText1);
		editend = (EditText)findViewById(R.id.editText2);
		
		chk1 = (CheckBox)findViewById(R.id.checkBox1);
		chk2 = (CheckBox)findViewById(R.id.checkBox2);
		
		btnfilter = (Button)findViewById(R.id.button1);
		btnfilter.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.filter, menu);
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
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		if(v==btnfilter)
		{
			pstart = editstart.getText().toString().trim();
			pend = editend.getText().toString().trim();
			
			if(pstart.equals(""))
			{
				editstart.setError("Enter Rate");
				return;
			}
			else if(pend.equals(""))
			{
				editstart.setError("Enter Rate");
				return;	
			}
			else if(Integer.parseInt(pend)<Integer.parseInt(pstart))
			{
				Toast.makeText(FilterActivity.this,"Invalid Rate Combination",Toast.LENGTH_SHORT).show();
				return;
			}
			else
			{
				Intent go = new Intent(FilterActivity.this,SearchTaxiActivity.class);
				go.putExtra("lpage","Filter");
				go.putExtra("type","");
				go.putExtra("srate","Filter");
				go.putExtra("erate","Filter");
				go.putExtra("ac","Filter");
				go.putExtra("nac","Filter");
				startActivity(go);
				finish();
			}
		}
		
	}
}
