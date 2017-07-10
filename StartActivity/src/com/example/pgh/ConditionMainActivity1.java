package com.example.pgh;

import com.example.pgh.Water.WaterPacMainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ConditionMainActivity1 extends Activity{
	private Button btnret;
	private Button btnyes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_condition_main);
		btnret = (Button)findViewById(R.id.no);
		btnyes= (Button)findViewById(R.id.yes);
		
		
		btnyes.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent z = new Intent(ConditionMainActivity1.this,WaterPacMainActivity.class);
				startActivity(z);				
			}
		});
	}

}
