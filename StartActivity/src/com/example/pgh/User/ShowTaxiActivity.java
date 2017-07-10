package com.example.pgh.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.pgh.R;
import com.example.pgh.API.APICall;
import com.example.pgh.API.APIResources;
import com.example.pgh.R.id;
import com.example.pgh.R.layout;
import com.example.pgh.R.menu;
import com.example.pgh.Taxi.UpdateTaxiActivity;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ShowTaxiActivity extends Activity implements OnClickListener {

	private TextView tname;
	private TextView tac;
	private TextView tpac;
	private TextView tnac;
	private TextView tpnac;
	private TextView tlac;
	private TextView tlnac;
	private Bundle extra;
	private String email;
	private String tid;
	private String tname1;
	private String ptype;
	private String rac;
	private String rac1;
	private String rnac;
	private String rnac1;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private ImageView images1;
	private ImageView images2;
	private ImageView images3;
	private ImageView images4;
	private Button btnbook;
	private Button btnbook1;
	private RadioGroup rbgrp;
	private EditText editdate;
	private EditText edittime;
	private EditText editaddress;
	private String sdate;
	private String stime;
	private String saddress;
	private int cid;
	private RadioButton type1;
	private String stype;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_taxi);
		
		extra = getIntent().getExtras();
		email = extra.getString("email");
		tid = extra.getString("tid");
		tname1 = extra.getString("tname");
		ptype = extra.getString("ptype");
		rac = extra.getString("rac");
		rac1 = extra.getString("rac1");
		rnac = extra.getString("rnac");
		rnac1 = extra.getString("rnac1");
			
		image1 = extra.getString("image1");
		image2 = extra.getString("image2");
		image3 = extra.getString("image3");
		image4 = extra.getString("image4");
				
		tname= (TextView)findViewById(R.id.textView1);
		tac= (TextView)findViewById(R.id.textView3);
		tpac= (TextView)findViewById(R.id.textView4);
		tnac= (TextView)findViewById(R.id.textView6);
		tpnac= (TextView)findViewById(R.id.textView7);
		tlac= (TextView)findViewById(R.id.textView8);
		tlnac= (TextView)findViewById(R.id.textView9);
		
		images1 = (ImageView) findViewById(R.id.imageView1);
		images2 = (ImageView) findViewById(R.id.imageView2);
		images3 = (ImageView) findViewById(R.id.imageView3);
		images4 = (ImageView) findViewById(R.id.imageView4);
		
		tpac.setVisibility(View.INVISIBLE);
		tpnac.setVisibility(View.INVISIBLE);
		tlac.setVisibility(View.INVISIBLE);
		tlnac.setVisibility(View.INVISIBLE);
		
		tname.setText(tname1);
		tac.setText(rac);
		tnac.setText(rnac);
	
		if(rac.contains("Yes"))
		{
			tpac.setVisibility(View.VISIBLE);
			tlac.setVisibility(View.VISIBLE);
			tpac.setText(rac1);
		}

		if(rnac.contains("Yes"))
		{
			tpnac.setVisibility(View.VISIBLE);
			tlnac.setVisibility(View.VISIBLE);
			tpnac.setText(rnac1);
		}

		if(!image1.trim().equals(""))
		{
			Picasso.with(ShowTaxiActivity.this).load(APIResources.BASE_URL+image1).into(images1);
		}
		if(!image2.trim().equals(""))
		{
			Picasso.with(ShowTaxiActivity.this).load(APIResources.BASE_URL+image2).into(images2);
		}
		if(!image3.trim().equals(""))
		{
			Picasso.with(ShowTaxiActivity.this).load(APIResources.BASE_URL+image3).into(images3);
		}
		if(!image4.trim().equals(""))
		{
			Picasso.with(ShowTaxiActivity.this).load(APIResources.BASE_URL+image4).into(images4);
		}
		
		btnbook = (Button)findViewById(R.id.button1);
		btnbook1 = (Button)findViewById(R.id.button2);
		
		rbgrp = (RadioGroup)findViewById(R.id.radioGroup1);
		
		editdate = (EditText)findViewById(R.id.editText1);
		edittime = (EditText)findViewById(R.id.editText2);
		editaddress = (EditText)findViewById(R.id.editText3);
		
		btnbook.setOnClickListener(this);
		btnbook1.setOnClickListener(this);
			
		rbgrp.setVisibility(View.INVISIBLE);
		editdate.setVisibility(View.INVISIBLE);
		edittime.setVisibility(View.INVISIBLE);
		editaddress.setVisibility(View.INVISIBLE);
		btnbook1.setVisibility(View.INVISIBLE);
		
		if(editdate.getText().toString() != null  )
		{
			editdate.setError("Enter Date");
		}
		if(edittime.getText().toString() != null )
		{
			edittime.setError("Enter Time");
		}
		if(editaddress.getText().toString() != null )
		{
			editaddress.setError("Enter Address");
		}
		
	}

	/*private boolean isValidDate(String string) {
		// TODO Auto-generated method stub
		String Date_PATTERN = "([0-9]{1,2}+[-| \\]+[1-12]+[-| \\])+[0-9]{2}";

		Pattern pattern = Pattern.compile(Date_PATTERN);
		Matcher matcher = pattern.matcher(string);
		return matcher.matches();
	}*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_taxi, menu);
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
			if(v==btnbook)
			{
				rbgrp.setVisibility(View.VISIBLE);
				editdate.setVisibility(View.VISIBLE);
				edittime.setVisibility(View.VISIBLE);
				editaddress.setVisibility(View.VISIBLE);
				btnbook1.setVisibility(View.VISIBLE);	
				btnbook.setVisibility(View.INVISIBLE);	
			}
			
			if(v==btnbook1)
			{
				sdate = editdate.getText().toString().trim();
				stime = edittime.getText().toString().trim();
				saddress = editaddress.getText().toString().trim();
				
				cid= rbgrp.getCheckedRadioButtonId();
				
				type1 =(RadioButton) findViewById(cid);
				
//				Toast.makeText(getApplicationContext(), type1.getText(),Toast.LENGTH_SHORT).show();

				if(type1.getText().toString().trim().matches("AC"))
				{
					stype= "AC";
				}
				else
				{
					stype= "NonAC";
				}
				
				
				if(sdate.equals(""))
				{
					editdate.setError("Enter Date");
					return;
				}
				else if(stime.equals(""))
				{
					edittime.setError("Enter Time");
					return;
				}
				else if(saddress.equals(""))
				{
					editaddress.setError("Enter Address");
					return;
				}
				else
				{
					new PostTaxiOrder().execute();
				}
			}
	}
	
	private class PostTaxiOrder extends AsyncTask<Void, Void, String> {

        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub

            dialog = new ProgressDialog(ShowTaxiActivity.this);
            dialog.setMessage("Please Wait...!");
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {
            // TODO Auto-generated method stub
            APICall api = new APICall();
            String result = api.postTaxiOrder(tid, email, stype, ptype, sdate, stime, saddress);
            return result;
        }

        @Override
        protected void onPostExecute(String result) 
        {
            // TODO Auto-generated method stub
            if (result !=null)
            {
                Toast.makeText(ShowTaxiActivity.this,result, Toast.LENGTH_LONG).show();
	        }
            else
            {
                Toast.makeText(ShowTaxiActivity.this,"Server Connection Error", Toast.LENGTH_LONG).show();
            }
            dialog.dismiss();
            super.onPostExecute(result);
        }
    }
	
}
