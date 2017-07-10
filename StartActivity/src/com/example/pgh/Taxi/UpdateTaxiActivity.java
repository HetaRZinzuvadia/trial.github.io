package com.example.pgh.Taxi;

import com.example.pgh.R;
import com.example.pgh.API.APICall;
import com.example.pgh.R.id;
import com.example.pgh.R.layout;
import com.example.pgh.R.menu;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateTaxiActivity extends Activity implements OnClickListener{

	private CheckBox cbac;
	private CheckBox cbnonac;
	private EditText editac;
	private EditText editnonac;
	private Button btnNext;
	private Button btnUpload;
	private RadioGroup rbgroup;
	protected String type;
	protected String stype;
	protected String vac;
	protected String pac;
	protected String vnonac;
	protected String pnonac;
	protected TextView step;
	protected TextView npeople;
	private Bundle extra;
	private String tid;
	private String email;
	private int stepcount;
	private String rac;
	private String pnac;
	private String rnac;
	private String pac1;
	private RadioButton rb1;
	private String stype1;
	private RadioButton rb2;
	private TextView txtcancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_taxi);
		
		
		extra = getIntent().getExtras();
		tid = extra.getString("tid").toString().trim();
		email = extra.getString("email").toString().trim();
		stepcount =Integer.parseInt(extra.getString("stepcount").toString().trim());
		stype1 = extra.getString("type").toString().trim();
		pac1 = extra.getString("pac").toString().trim();
		rac = extra.getString("rac").toString().trim();
		pnac = extra.getString("pnac").toString().trim();
		rnac = extra.getString("rnac").toString().trim();
			
		npeople = (TextView)findViewById(R.id.textView2);
					
		if(stepcount==1)
		{
			npeople.setText(" 4 people ");
		}
		else if(stepcount==2)
		{
			npeople.setText(" 7 people ");
		}
		else if(stepcount==3)
		{
			npeople.setText(" 11 people ");
		}
		
		rbgroup = (RadioGroup)findViewById(R.id.radioGroup1);
		
		rb1 = (RadioButton)findViewById(R.id.radio1);
		rb2 = (RadioButton)findViewById(R.id.radio2);

		cbac = (CheckBox)findViewById(R.id.checkBox1);
		cbnonac = (CheckBox)findViewById(R.id.checkBox2);
		
		editac = (EditText) findViewById(R.id.editText1);
		editnonac = (EditText) findViewById(R.id.editText2);
		
		btnNext = (Button) findViewById(R.id.button1);
		btnNext.setVisibility(View.INVISIBLE);
		
		btnUpload = (Button) findViewById(R.id.button21);
		btnUpload.setVisibility(View.INVISIBLE);
		
		cbac.setVisibility(View.INVISIBLE);
		cbnonac.setVisibility(View.INVISIBLE);
		
		
		editac.setVisibility(View.INVISIBLE);
		editnonac.setVisibility(View.INVISIBLE);

		btnUpload.setOnClickListener(this);

		

		if(stype1.trim().contains("Yes"))
		{
			rb1.setChecked(true);
			
			if(pac1.matches("Yes"))
			{
				cbac.setVisibility(View.VISIBLE);
				cbac.setChecked(true);
				editac.setVisibility(View.VISIBLE);
				editac.setText(rac.trim());
				btnNext.setVisibility(View.VISIBLE);
				btnUpload.setVisibility(View.VISIBLE);

			}
			else
			{
				cbac.setVisibility(View.VISIBLE);			
			}

			if(pnac.matches("Yes"))
			{
				cbnonac.setVisibility(View.VISIBLE);
				cbnonac.setChecked(true);
				editnonac.setVisibility(View.VISIBLE);
				editnonac.setText(rnac.trim());
				btnNext.setVisibility(View.VISIBLE);
				btnUpload.setVisibility(View.VISIBLE);

			}
			else
			{
				cbnonac.setVisibility(View.VISIBLE);			
			}

			
		}		

		rbgroup.setOnCheckedChangeListener(new OnCheckedChangeListener() 
		
		{
			
		
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) 
		{
				// TODO Auto-generated method stub
				
				if (checkedId == R.id.radio1) 
				{
					cbac.setVisibility(View.VISIBLE);
					cbnonac.setVisibility(View.VISIBLE);					
					
					btnNext.setVisibility(View.VISIBLE);
					btnUpload.setVisibility(View.VISIBLE);

				} 
				else if (checkedId == R.id.radio2) 
	            {	
					
					cbac.setVisibility(View.INVISIBLE);
					cbnonac.setVisibility(View.INVISIBLE);
					
					editac.setVisibility(View.INVISIBLE);
					editnonac.setVisibility(View.INVISIBLE);
					
					cbac.setChecked(false);
					cbnonac.setChecked(false);
					
					btnNext.setVisibility(View.INVISIBLE);
					btnUpload.setVisibility(View.INVISIBLE);
						
					if(stepcount==1)
					{						
						type="Type1";
						stype="No";
						vac= "No";
						pac= "-";
						vnonac="No";
						pnonac="-";						
						new PostForTaxiRate().execute();

					}
					else if(stepcount==2)
					{
						
						type="Type2";
						stype="No";
						vac= "No";
						pac= "-";
						vnonac="No";
						pnonac="-";
						
						new PostForTaxiRate().execute();

					}
					else if(stepcount==3)
					{
						
						type="Type3";
						stype="No";
						vac= "No";
						pac= "-";
						vnonac="No";
						pnonac="-";
			
						new PostForTaxiRate().execute();

					}
					else
					{
						
					
					}
					
					Intent go = new Intent(UpdateTaxiActivity.this,TaxiHomeActivity.class);
					go.putExtra("tid",tid.trim());
					go.putExtra("email",email.trim());
					startActivity(go);
					finish();			
				}
				
		}
		});
		
		
		btnNext.setOnClickListener(this);
		
		txtcancel = (TextView)findViewById(R.id.textView4);
		txtcancel.setOnClickListener(this);
	}

	public void itemClicked(View v) 
	{
		  //code to check if this checkbox is checked!	
		
		if(cbac.isChecked())
		  {
			  editac.setVisibility(View.VISIBLE);
		  }
		  else
		  {
			  editac.setVisibility(View.INVISIBLE);	
			  editac.setText("");
		  }
		  
		  if(cbnonac.isChecked())
		  {
			  editnonac.setVisibility(View.VISIBLE);
		  }
		  else
		  {
			  editnonac.setVisibility(View.INVISIBLE);			  
			  editnonac.setText("");
				
		  }
		  

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.update_taxi, menu);
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
		if(v==btnUpload)
		{
			Toast.makeText(getApplicationContext(), "Upload",Toast.LENGTH_SHORT).show();
			
			Intent go = new Intent(UpdateTaxiActivity.this,LetsStart2Activity.class);
			go.putExtra("type",String.valueOf(stepcount));
			go.putExtra("tid",tid.trim());
			startActivity(go);
		}
		
		if(v==txtcancel)
		{
			Intent go = new Intent(UpdateTaxiActivity.this,TaxiHomeActivity.class);
			go.putExtra("tid",tid.trim());
			go.putExtra("email",email.trim());
			startActivity(go);
			finish();	
		}
		if(v==btnNext)
		{
			
			if(cbac.isChecked()==false && cbnonac.isChecked()==false)
			{
				Toast.makeText(UpdateTaxiActivity.this,"Select Atleast one type of Vehicle",Toast.LENGTH_SHORT).show();
				return;
			}
			else
			{
						if(cbac.isChecked()==true)
						{
								vac = "Yes";				
								pac= editac.getText().toString().trim();	
					
								if(pac.equals(""))
								{
										editac.setError("Enter Rate");
										return;
								}
								else
								{
						
								}
						}
						else
						{
							vac="No";
							pac="-";
						}

						if(cbnonac.isChecked()==true)
						{
							vnonac = "Yes";				
							pnonac= editnonac.getText().toString().trim();	
					
							if(pnonac.equals(""))
							{
									editnonac.setError("Enter Rate");
									return;
							}
							else
							{
						
							}
						}
						else
						{
							vnonac="No";
							pnonac="-";
						}
				
						Toast.makeText(UpdateTaxiActivity.this,"Wait..",Toast.LENGTH_SHORT).show();
						
						
						rbgroup.clearCheck();
						
						cbac.setVisibility(View.INVISIBLE);
						cbnonac.setVisibility(View.INVISIBLE);
						
						cbac.setChecked(false);
						cbnonac.setChecked(false);
						
						editac.setVisibility(View.INVISIBLE);
						editnonac.setVisibility(View.INVISIBLE);
						
						
						editac.setText("");
						editnonac.setText("");

						btnNext.setVisibility(View.INVISIBLE);
						btnUpload.setVisibility(View.INVISIBLE);
	
						if(stepcount==1)
						{						
							type="Type1";
							stype="Yes";

							new PostForTaxiRate().execute();

						}
						else if(stepcount==2)
						{
							
							type="Type2";
							stype="Yes";
							
							new PostForTaxiRate().execute();


						}
						else if(stepcount==3)
						{
							
							type="Type3";
							stype="Yes";

							new PostForTaxiRate().execute();							
						}
						
						Intent go = new Intent(UpdateTaxiActivity.this,TaxiHomeActivity.class);
						go.putExtra("tid",tid.trim());
						go.putExtra("email",email.trim());
						startActivity(go);
						finish();
						
						
			}

		}
	}
	
	private class PostForTaxiRate extends AsyncTask<Void, Void, String> {

        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub

            dialog = new ProgressDialog(UpdateTaxiActivity.this);
            dialog.setMessage("Please Wait...!");
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {
            // TODO Auto-generated method stub
            APICall api = new APICall();
            String result = api.postTaxiRateUpdate(tid.trim(), type.trim(), stype.trim(), vac.trim(), pac.trim(), vnonac.trim(), pnonac.trim());
            return result;
        }

        @Override
        protected void onPostExecute(String result) 
        {
            // TODO Auto-generated method stub
            if (result !=null)
            {
                Toast.makeText(UpdateTaxiActivity.this,result, Toast.LENGTH_LONG).show();
	        }
            else
            {
                Toast.makeText(UpdateTaxiActivity.this,"Server Connection Error", Toast.LENGTH_LONG).show();
            }
            dialog.dismiss();
            super.onPostExecute(result);
        }
    }
}
