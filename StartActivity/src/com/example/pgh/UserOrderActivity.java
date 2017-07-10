package com.example.pgh;

import java.util.ArrayList;

import com.example.pgh.API.APICall;
import com.example.pgh.API.APIResources;
import com.example.pgh.Food.FoodMyAdvActivity;
import com.example.pgh.Food.FoodMyAdvActivity.GetResult;
import com.example.pgh.Food.FoodMyAdvActivity.ItemAdapter;
import com.example.pgh.POJO.AllResult;
import com.example.pgh.POJO.Result;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;

public class UserOrderActivity extends Activity {

	private Bundle extra;
	private ArrayList<Result> ResultList;
	private String email;
	private ListView List;
	private ItemAdapter searchadpater;
	public ViewHolder Holder;
	private Spinner Spin;
	private ArrayList<String> selaction;
	protected String sitem;
	public String stype;
	private ArrayAdapter<String> spinadpter;
	private String number1;
	protected String selectedadv;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_order);
	
		extra = getIntent().getExtras();
    	email= extra.getString("email").trim();
		
		ResultList = new ArrayList<Result>();
		
		List = (ListView)findViewById(R.id.listView1);
	
		searchadpater = new ItemAdapter();
		List.setAdapter(searchadpater);
	
		Spin = (Spinner)findViewById(R.id.spinner1);
		
		selaction = new ArrayList<String>();
		selaction.add("Select");
		selaction.add("Food");
		selaction.add("Water");
		selaction.add("Taxi");
		
		spinadpter = new ArrayAdapter<String>(UserOrderActivity.this,android.R.layout.simple_spinner_dropdown_item,selaction);
	
		Spin.setAdapter(spinadpter);

		Spin.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				sitem = Spin.getSelectedItem().toString();
				
				if(sitem.contains("Select"))
				{
					ResultList.clear();
				}
				else if(sitem.contains("Food"))
				{
					stype="Food";
					ResultList.clear();
					new GetResult().execute();
				}
				else if(sitem.contains("Water"))
				{
					stype="Water";
					ResultList.clear();
					new GetResult().execute();
				}
				else if(sitem.contains("Taxi"))
				{
					stype="Taxi";
					ResultList.clear();
					new GetResult().execute();
				}
				
			searchadpater.notifyDataSetChanged();	
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
				
	}

	public class GetResult extends AsyncTask<Void,Void,AllResult>
	{
		private ProgressDialog dialog;

		@Override
		protected void onPreExecute() 
		{
			// TODO Auto-generated method stub
			
			dialog = new ProgressDialog(UserOrderActivity.this);
			dialog.setMessage("Loading...");
			dialog.show();
			super.onPreExecute();
		}
		

		@Override
		protected AllResult doInBackground(Void... params) 
		{
			// TODO Auto-generated method stub
			
			APICall api = new APICall();
			AllResult result = api.getUserOrder(email, stype);
			return result;
		}

		@Override
		protected void onPostExecute(AllResult result) {
			// TODO Auto-generated method stub
			if(result !=null)
			{
				ResultList.clear();
				ResultList.addAll(result.getData());
								
			}
			else
			{
				
			}
			searchadpater.notifyDataSetChanged();
			dialog.dismiss();
			super.onPostExecute(result);
		}
		
	}

	public class ItemAdapter extends BaseAdapter 
	{
		
		@Override
		public int getCount() 
		{
		// TODO Auto-generated method stub
			return ResultList.size() ;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return ResultList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			if(convertView==null)
			{
				convertView = getLayoutInflater().inflate(R.layout.item_wf2_show,parent,false);
				
				Holder = new ViewHolder();
				
				Holder.tname = (TextView)convertView.findViewById(R.id.textView1);
				Holder.desc = (TextView)convertView.findViewById(R.id.textView2);
				Holder.service = (TextView)convertView.findViewById(R.id.textView4);
				Holder.time = (TextView)convertView.findViewById(R.id.textView6);
				Holder.contact = (TextView)convertView.findViewById(R.id.textView8);
				Holder.txtcancel=(Button)convertView.findViewById(R.id.button1);
				Holder.call=(ImageView)convertView.findViewById(R.id.imageView1);
				convertView.setTag(Holder);
			}
			else
			{
				Holder = (ViewHolder)convertView.getTag();
			}
			
			Holder.tname.setText(ResultList.get(position).getTitle());
//			Holder.desc.setText(ResultList.get(position).getDescription());

			
			Holder.service.setText(ResultList.get(position).getOrder_Date());
			Holder.time.setText(ResultList.get(position).getOrder_Time());
			Holder.contact.setText(ResultList.get(position).getOrder_Address());
			number1=ResultList.get(position).getContact();
			Holder.txtcancel.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
//					Toast.makeText(getApplicationContext(), email+stype, Toast.LENGTH_LONG).show();
				
					selectedadv = ResultList.get(position).getAdv_ID().toString();
					
					new Postcancelorder().execute();
				}
			});
			
			Holder.call.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent callIntent = new Intent(Intent.ACTION_CALL);  
					
					callIntent.setData(Uri.parse("tel:"+ number1));   
	                startActivity(callIntent);
				}
			});
			
			return convertView;
		}
				
	}
	
	private static class ViewHolder
	{
		TextView tname;
		TextView desc;
		TextView service;
		TextView time;
		TextView contact;
		Button txtcancel;
		ImageView call;
			
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_order, menu);
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
	
	
	private class Postcancelorder extends AsyncTask<Void, Void, String> {

        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub

            dialog = new ProgressDialog(UserOrderActivity.this);
            dialog.setMessage("Please Wait...!");
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {
            // TODO Auto-generated method stub
            APICall api = new APICall();
            String result = api.cancel_userOrd(email, stype,selectedadv);
           return result;
        }

        @Override
        protected void onPostExecute(String result) 
        {
            // TODO Auto-generated method stub
            if (result !=null)
            {  
            	Toast.makeText(UserOrderActivity.this,result, Toast.LENGTH_LONG).show();
	        }
            else
            {
                Toast.makeText(UserOrderActivity.this,"Server Connection Error", Toast.LENGTH_LONG).show();
            }
            searchadpater.notifyDataSetChanged();
			dialog.dismiss();
            super.onPostExecute(result);
        }
    }
}
