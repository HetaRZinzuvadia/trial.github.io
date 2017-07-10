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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class LetsStart1Activity extends Activity implements OnClickListener {

	private String cat;
	private RadioGroup rbgroup;
	private CheckBox cbac;
	private CheckBox cbnonac;
	private EditText editac;
	private EditText editnonac;
	private Button btnNext;
	private Button btnUpload;
	private String vac;
	private String pac;
	private String vnonac;
	private String pnonac;
	private int stepcount;
	private TextView npeople;
	private TextView step;
	protected String type;
	protected String stype;
	private String tid;
	private RadioButton cb1;
	private RadioButton cb;
	private Bundle extra;
	private String email;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_lets_start1);
		
		extra = getIntent().getExtras();
		tid = extra.getString("tid").toString().trim();
		email = extra.getString("email").toString().trim();
		
		step = (TextView)findViewById(R.id.textView5);
		npeople = (TextView)findViewById(R.id.textView2);
		
		stepcount = 1;
			
		if(stepcount==1)
		{
			step.setText(String.valueOf(stepcount));
			npeople.setText(" 4 people ");
		}
		
		cbac = (CheckBox)findViewById(R.id.checkBox1);
		cbnonac = (CheckBox)findViewById(R.id.checkBox2);
		
		editac = (EditText) findViewById(R.id.editText1);
		editnonac = (EditText) findViewById(R.id.editText2);
		
		btnNext = (Button) findViewById(R.id.button1);
		btnNext.setVisibility(View.INVISIBLE);
		
		btnNext = (Button) findViewById(R.id.button1);
		btnNext.setVisibility(View.INVISIBLE);
		
		btnUpload = (Button) findViewById(R.id.button21);
		btnUpload.setVisibility(View.INVISIBLE);
		
		cbac.setVisibility(View.INVISIBLE);
		cbnonac.setVisibility(View.INVISIBLE);
		
		editac.setVisibility(View.INVISIBLE);
		editnonac.setVisibility(View.INVISIBLE);

		btnUpload.setOnClickListener(this);
		
		rbgroup = (RadioGroup)findViewById(R.id.radioGroup1);
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
						vac= "-";
						pac= "-";
						vnonac="-";
						pnonac="-";						
						new PostForTaxiRate().execute();

						stepcount = stepcount+1;	
						step.setText(String.valueOf(stepcount));
						npeople.setText(" 7 people ");

					}
					else if(stepcount==2)
					{
						
						type="Type2";
						stype="No";
						vac= "-";
						pac= "-";
						vnonac="-";
						pnonac="-";
						
						new PostForTaxiRate().execute();

						stepcount = stepcount+1;				
						step.setText(String.valueOf(stepcount));
						npeople.setText(" 11 people ");

					}
					else if(stepcount==3)
					{
						
						type="Type3";
						stype="No";
						vac= "-";
						pac= "-";
						vnonac="-";
						pnonac="-";
			
						new PostForTaxiRate().execute();
						stepcount = stepcount+1;
						
						if(stepcount==4)
						{
							Intent go = new Intent(LetsStart1Activity.this,TaxiHomeActivity.class);
							go.putExtra("tid",tid.trim());
							go.putExtra("email",email.trim());
							startActivity(go);
							finish();
						}
						else{}
					}
					else
					{
						
					}
					
					
					cb =(RadioButton)findViewById(R.id.radio2);
					cb.setChecked(false);
					
				}
				
		}
		});
		
		
		btnNext.setOnClickListener(this);
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
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
	
		if(v==btnUpload)
		{
			Toast.makeText(getApplicationContext(), "Upload",Toast.LENGTH_SHORT).show();
			
			Intent go = new Intent(LetsStart1Activity.this,LetsStart2Activity.class);
			go.putExtra("type",String.valueOf(stepcount));
			go.putExtra("tid",tid.trim());
			startActivity(go);
		}
		
		if(v==btnNext)
		{
			
			if(cbac.isChecked()==false && cbnonac.isChecked()==false)
			{
				Toast.makeText(LetsStart1Activity.this,"Select Atleast one type of Vehicle",Toast.LENGTH_SHORT).show();
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
				
						Toast.makeText(LetsStart1Activity.this,"Wait..",Toast.LENGTH_SHORT).show();
						
						
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

							stepcount = stepcount+1;	
							step.setText(String.valueOf(stepcount));
							npeople.setText(" 7 people ");
						}
						else if(stepcount==2)
						{
							
							type="Type2";
							stype="Yes";
							
							new PostForTaxiRate().execute();

							stepcount = stepcount+1;				
							step.setText(String.valueOf(stepcount));
							npeople.setText(" 11 people ");

						}
						else if(stepcount==3)
						{
							
							type="Type3";
							stype="Yes";

							new PostForTaxiRate().execute();
							stepcount = stepcount+1;
							
							if(stepcount==4)
							{
								Intent go = new Intent(LetsStart1Activity.this,TaxiHomeActivity.class);
								go.putExtra("tid",tid.trim());
								go.putExtra("email",email.trim());
								startActivity(go);
								finish();
							}
							else{}
							
							
						}
						
			}

		}
	}

	private class PostForTaxiRate extends AsyncTask<Void, Void, String> {

        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub

            dialog = new ProgressDialog(LetsStart1Activity.this);
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
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            if (result !=null)
            {
                Toast.makeText(LetsStart1Activity.this,result, Toast.LENGTH_LONG).show();
	        }
            else
            {
                Toast.makeText(LetsStart1Activity.this,"Server Connection Error", Toast.LENGTH_LONG).show();
            }
            dialog.dismiss();
            super.onPostExecute(result);
        }
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lets_start1, menu);
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
	
	
	
}
