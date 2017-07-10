package com.example.pgh;

import java.util.ArrayList;

import com.example.pgh.API.APICall;
import com.example.pgh.POJO.AllPackage;
import com.example.pgh.POJO.Package;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class UserPackage extends Activity {

	private Bundle extra;
	private String email;
	private ArrayList<Package> Resultlist;
	private ListView list;
	private Spinner spinner;
	private ItemAdapter searchadpater;
	private ArrayList<String> selectserv;
	private ArrayAdapter<String> spinneradapter;
	private String sitem;
	private String stype;
	private String number1;
	private ViewHolder holder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_package);
//		extra=getIntent().getExtras();
//		email=extra.getString("email");
		email="heta@gmail.com";
//		Toast.makeText(UserPackage.this, email, Toast.LENGTH_LONG).show();
		
		Resultlist= new ArrayList<Package>();
		
		list=(ListView)findViewById(R.id.plistView1);
		spinner=(Spinner)findViewById(R.id.pspinner1);
		
		searchadpater = new ItemAdapter();
		list.setAdapter(searchadpater);
		selectserv= new ArrayList<String>();
		selectserv.add("select");
		selectserv.add("food");
		selectserv.add("water");
		
		spinneradapter= new ArrayAdapter<String>(UserPackage.this, android.R.layout.simple_spinner_dropdown_item,selectserv);
		spinner.setAdapter(spinneradapter);
				
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
				// TODO Auto-generated method stub
				sitem=spinner.getSelectedItem().toString();
				Toast.makeText(UserPackage.this, sitem, Toast.LENGTH_LONG).show();		
				
				if(sitem.contains("select"))
				{
					Resultlist.clear();
				}
				else if(sitem.contains("food"))
				{
					stype="food";
					Resultlist.clear();
					new getResult().execute();
				}
				else if(sitem.contains("water"))
				{
					stype="water";
					Resultlist.clear();
					new getResult().execute();
				}
			searchadpater.notifyDataSetChanged();	
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	public class getResult extends AsyncTask<Void, Void, AllPackage>
	{
		private ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			dialog= new ProgressDialog(UserPackage.this);
			dialog.setMessage("Loading...");
			dialog.show();
			super.onPreExecute();
		}
		
		@Override
		protected AllPackage doInBackground(Void... params) {
			// TODO Auto-generated method stub
			APICall apiCall= new APICall();
			AllPackage result= apiCall.getUserPackage(stype);
			return result;
		}
		
		@Override
		protected void onPostExecute(AllPackage result) {
			// TODO Auto-generated method stub
			if(result !=null)
			{
				Resultlist.clear();
				Resultlist.addAll(result.getData());
//				Resultlist.addAll(result.getData());
								
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
		public int getCount() {
			// TODO Auto-generated method stub
			return Resultlist.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return Resultlist.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if(convertView==null)
			{
				convertView=getLayoutInflater().inflate(R.layout.item_wf4_show, parent, 

false);
				holder=new ViewHolder();
				
				holder.title= (TextView)convertView.findViewById(R.id.txttitle);
				holder.service= (TextView)convertView.findViewById(R.id.txtservice);
				holder.rate= (TextView)convertView.findViewById(R.id.txtrate);
				holder.number= (TextView)convertView.findViewById(R.id.txtnumber);
				holder.call= (ImageView)convertView.findViewById(R.id.imgcall);
				
				convertView.setTag(holder);					
			}
			else {
				holder= (ViewHolder)convertView.getTag();
			}
			
			holder.title.setText(Resultlist.get(position).getTitle());
			holder.service.setText(Resultlist.get(position).getService());
			holder.rate.setText(Resultlist.get(position).getRate());
			holder.number.setText(Resultlist.get(position).getNumber());
			number1=Resultlist.get(position).getNumber();
			
			holder.call.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent callintent=new Intent(Intent.ACTION_CALL);
					
					callintent.setData(Uri.parse("tel"+number1));
					startActivity(callintent);
				}
			});
			
			return convertView;
		}
	}	
	
	public class ViewHolder
	{
		TextView title;
		TextView service;
		TextView rate;
		TextView number;
		ImageView call;
	}
	
	
}
