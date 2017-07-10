package com.example.pgh;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ShowProfile extends Activity implements OnClickListener {

	private Button btnord;
	private Button btnpack;
	private Bundle extra;
	private String email;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_profile);
		extra=getIntent().getExtras();
		email=extra.getString("email");
		
		btnord=(Button)findViewById(R.id.btnorders);
		btnpack=(Button)findViewById(R.id.btnpackage);
		
		btnord.setOnClickListener(this);
		btnpack.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_profile, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==btnord)
		{
			Toast.makeText(ShowProfile.this, "Welcome "+email, Toast.LENGTH_LONG).show();
			Intent go = new Intent(ShowProfile.this,UserOrderActivity.class);
			go.putExtra("email",email.trim());
			startActivity(go);
		}
		
		if(v==btnpack)
		{
			Toast.makeText(ShowProfile.this, "Welcome "+email, Toast.LENGTH_LONG).show();
			Intent go1 = new Intent(ShowProfile.this,UserPackage.class);
			go1.putExtra("email",email.trim());
			startActivity(go1);
		}
	}

}
