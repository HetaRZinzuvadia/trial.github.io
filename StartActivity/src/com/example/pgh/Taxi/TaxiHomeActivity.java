package com.example.pgh.Taxi;

import java.util.ArrayList;

import com.example.pgh.LoginActivity;
import com.example.pgh.R;
import com.example.pgh.API.APICall;
import com.example.pgh.API.APIResources;
import com.example.pgh.POJO.AllTaxi;
import com.example.pgh.POJO.Taxi;
import com.example.pgh.R.id;
import com.example.pgh.R.layout;
import com.example.pgh.R.menu;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TaxiHomeActivity extends Activity implements OnClickListener {

	private String tid;
	private String email;
	private Button btnstart;
	private ListView list;
	private ArrayList<Taxi> SearchList;
	private TextView type1;
	private TextView type2;
	private TextView type3;
	private LinearLayout l1;
	private TextView t1ac;
	private TextView t2ac;
	private TextView t3ac;
	private TextView t1nac;
	private TextView t2nac;
	private TextView t3nac;
	private ImageView image1;
	private ImageView image2;
	private ImageView image3;
	private ImageView image4;
	private ImageView image5;
	private ImageView image6;
	private ImageView image7;
	private ImageView image8;
	private ImageView image9;
	private ImageView image10;
	private ImageView image11;
	private ImageView image12;
	private String images1;
	private String images2;
	private String images3;
	private String images4;
	private String images5;
	private String images6;
	private String images7;
	private String images8;
	private String images9;
	private String images10;
	private String images11;
	private String images12;
	private TextView txtupdate1;
	private TextView txtupdate2;
	private TextView txtupdate3;
	private TextView txtlogout;
	private Button showorder;
	private Bundle extra;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_taxi_home);
		
	//	String gmail= SearchList.get(0).getTaxi_ID().toString();
		extra=getIntent().getExtras();
		tid="1";
		email=extra.getString("email");
			
		if(tid.trim()!="")
		{
			new CheckDataStatus().execute();
		}
	
		l1 = (LinearLayout)findViewById(R.id.l1);
	//	l1.setVisibility(View.INVISIBLE);
		
		SearchList = new ArrayList<Taxi>();
		
		showorder=(Button)findViewById(R.id.button1);
		showorder.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(TaxiHomeActivity.this, TaxiFacOrderMainActivity.class);
				intent.putExtra("email", email);
				startActivity(intent);
			}
		});
		
		type1= (TextView)findViewById(R.id.textView6a);
		type2= (TextView)findViewById(R.id.textView6b);
		type3= (TextView)findViewById(R.id.textView6c);
		
		t1ac= (TextView)findViewById(R.id.textView3a);
		t2ac= (TextView)findViewById(R.id.textView3b);
		t3ac= (TextView)findViewById(R.id.textView3c);

		t1nac= (TextView)findViewById(R.id.textView5a);
		t2nac= (TextView)findViewById(R.id.textView5b);
		t3nac= (TextView)findViewById(R.id.textView5c);
		
		image1 = (ImageView)findViewById(R.id.imageView1);
		image2 = (ImageView)findViewById(R.id.imageView2);
		image3 = (ImageView)findViewById(R.id.imageView3);
		image4 = (ImageView)findViewById(R.id.imageView4);
		image5 = (ImageView)findViewById(R.id.imageView5);
		image6 = (ImageView)findViewById(R.id.imageView6);
		image7 = (ImageView)findViewById(R.id.imageView7);
		image8 = (ImageView)findViewById(R.id.imageView8);
		image9 = (ImageView)findViewById(R.id.imageView9);
		image10 = (ImageView)findViewById(R.id.imageView10);
		image11 = (ImageView)findViewById(R.id.imageView11);
		image12 = (ImageView)findViewById(R.id.imageView12);
		
		txtupdate1 = (TextView)findViewById(R.id.textView1a);
		txtupdate2 = (TextView)findViewById(R.id.textView1b);
		txtupdate3 = (TextView)findViewById(R.id.textView1c);

		txtupdate1.setOnClickListener(this);
		txtupdate2.setOnClickListener(this);
		txtupdate3.setOnClickListener(this);
	
	
		
		txtlogout = (TextView)findViewById(R.id.textlogout);
		txtlogout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent go = new Intent(TaxiHomeActivity.this,LoginActivity.class);
				startActivity(go);
				finish();
			}
		});
}

	private class CheckDataStatus extends AsyncTask<Void, Void, String> {

        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub

            dialog = new ProgressDialog(TaxiHomeActivity.this);
            dialog.setMessage("Please Wait...!");
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {
            // TODO Auto-generated method stub
            APICall api = new APICall();
            String result = api.postTaxiDataCheck(tid.trim());
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            if (result !=null)
            {
            	if(result.trim().matches("Yes"))
            	{
            		new GetTaxiData().execute();
                    Toast.makeText(TaxiHomeActivity.this,"Show Data", Toast.LENGTH_LONG).show();
            	}
            	else if(result.trim().matches("No"))
            	{
            		Intent go = new Intent(TaxiHomeActivity.this,TaxiHome1Activity.class);
        			go.putExtra("tid",tid.trim());
        			go.putExtra("email",email.trim());
        			startActivity(go);
        			finish();
        		
             	}
            	else
            	{
                    Toast.makeText(TaxiHomeActivity.this,result, Toast.LENGTH_LONG).show();  
                }
	        }
            else
            {
                Toast.makeText(TaxiHomeActivity.this,"Server Connection Error", Toast.LENGTH_LONG).show();
            }
            dialog.dismiss();
            super.onPostExecute(result);
        }
    }
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.taxi_home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) 
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		
		if(v==txtupdate1)
		{
			Intent go = new Intent(TaxiHomeActivity.this,UpdateTaxiActivity.class);
			go.putExtra("tid",tid.trim());
			go.putExtra("email",email.trim());
			go.putExtra("stepcount","1");
			go.putExtra("type",SearchList.get(0).getType1().toString().trim());
			go.putExtra("pac",SearchList.get(0).getType1_AC().toString().trim());
			go.putExtra("rac",SearchList.get(0).getType1_AC_Rate().toString().trim());
			go.putExtra("pnac",SearchList.get(0).getType1_NonAC().toString().trim());
			go.putExtra("rnac",SearchList.get(0).getType1_NonAC_Rate().toString().trim());
			startActivity(go);
			finish();
		}
		
		if(v==txtupdate2)
		{
			Intent go = new Intent(TaxiHomeActivity.this,UpdateTaxiActivity.class);
			go.putExtra("tid",tid.trim());
			go.putExtra("email",email.trim());
			go.putExtra("stepcount","2");
			go.putExtra("type",SearchList.get(0).getType2().toString().trim());
			go.putExtra("pac",SearchList.get(0).getType2_AC().toString().trim());
			go.putExtra("rac",SearchList.get(0).getType2_AC_Rate().toString().trim());
			go.putExtra("pnac",SearchList.get(0).getType2_NonAC().toString().trim());
			go.putExtra("rnac",SearchList.get(0).getType2_NonAC_Rate().toString().trim());
			startActivity(go);
			finish();
		}

		if(v==txtupdate3)
		{
			Intent go = new Intent(TaxiHomeActivity.this,UpdateTaxiActivity.class);
			go.putExtra("tid",tid.trim());
			go.putExtra("email",email.trim());
			go.putExtra("stepcount","3");
			go.putExtra("type",SearchList.get(0).getType3().toString().trim());		
			go.putExtra("pac",SearchList.get(0).getType3_AC().toString().trim());
			go.putExtra("rac",SearchList.get(0).getType3_AC_Rate().toString().trim());
			go.putExtra("pnac",SearchList.get(0).getType3_NonAC().toString().trim());
			go.putExtra("rnac",SearchList.get(0).getType3_NonAC_Rate().toString().trim());
			startActivity(go);
			finish();
		}

	}
	
	public class GetTaxiData extends AsyncTask<Void,Void,AllTaxi>
	{
		private ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			
			dialog = new ProgressDialog(TaxiHomeActivity.this);
			dialog.setMessage("Loading...");
			dialog.show();
			super.onPreExecute();
		}
		

		@Override
		protected AllTaxi doInBackground(Void... params) {
			// TODO Auto-generated method stub
			
			APICall api = new APICall();
			AllTaxi result = api.getTaxiData(tid.trim());
			return result;
		}

		@Override
		protected void onPostExecute(AllTaxi result) {
			// TODO Auto-generated method stub
			if(result !=null)
			{
				
				SearchList.clear();
				SearchList.addAll(result.getData());
				setData();
			}
			else
			{
				
			}
			dialog.dismiss();
			super.onPostExecute(result);
		}
		
	}
		
	public void setData()
	{
			
	//	l1.setVisibility(View.VISIBLE);

		type1.setText("Upto 3 People");
		type2.setText("Upto 7 People");
		type3.setText("Upto 11 People");
		
		Toast.makeText(getApplicationContext(), SearchList.get(0).getTaxi_ID().toString(),Toast.LENGTH_SHORT).show();
		
		t1ac.setText(SearchList.get(0).getType1_AC_Rate().toString().trim());
		t2ac.setText(SearchList.get(0).getType2_AC_Rate().toString().trim());
		t3ac.setText(SearchList.get(0).getType3_AC_Rate().toString().trim());
		
		t1nac.setText(SearchList.get(0).getType1_NonAC_Rate().toString().trim());
		t2nac.setText(SearchList.get(0).getType2_NonAC_Rate().toString().trim());
		t3nac.setText(SearchList.get(0).getType3_NonAC_Rate().toString().trim());
		
		images1 = SearchList.get(0).getType1_1();
		images2 = SearchList.get(0).getType1_2();
		images3 = SearchList.get(0).getType1_3();
		images4 = SearchList.get(0).getType1_4();
		
		images5 = SearchList.get(0).getType2_1();
		images6 = SearchList.get(0).getType2_2();
		images7 = SearchList.get(0).getType2_3();
		images8 = SearchList.get(0).getType2_4();
	
		images9 = SearchList.get(0).getType3_1();
		images10 = SearchList.get(0).getType3_2();
		images11 = SearchList.get(0).getType3_3();
		images12 = SearchList.get(0).getType3_4();
	
		Picasso.with(TaxiHomeActivity.this).load(APIResources.BASE_URL+images1).into(image1);
		Picasso.with(TaxiHomeActivity.this).load(APIResources.BASE_URL+images2).into(image2);
		Picasso.with(TaxiHomeActivity.this).load(APIResources.BASE_URL+images3).into(image3);
		Picasso.with(TaxiHomeActivity.this).load(APIResources.BASE_URL+images4).into(image4);
		Picasso.with(TaxiHomeActivity.this).load(APIResources.BASE_URL+images5).into(image5);
		Picasso.with(TaxiHomeActivity.this).load(APIResources.BASE_URL+images6).into(image6);
		Picasso.with(TaxiHomeActivity.this).load(APIResources.BASE_URL+images7).into(image7);
		Picasso.with(TaxiHomeActivity.this).load(APIResources.BASE_URL+images8).into(image8);
		Picasso.with(TaxiHomeActivity.this).load(APIResources.BASE_URL+images9).into(image9);
		Picasso.with(TaxiHomeActivity.this).load(APIResources.BASE_URL+images10).into(image10);
		Picasso.with(TaxiHomeActivity.this).load(APIResources.BASE_URL+images11).into(image11);
		Picasso.with(TaxiHomeActivity.this).load(APIResources.BASE_URL+images12).into(image12);

	
	}
}
