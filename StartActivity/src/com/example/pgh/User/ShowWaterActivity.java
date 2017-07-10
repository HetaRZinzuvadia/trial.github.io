package com.example.pgh.User;

import java.util.ArrayList;

import com.example.pgh.R;
import com.example.pgh.API.APICall;
import com.example.pgh.API.APIResources;
import com.example.pgh.POJO.AllArea;
import com.example.pgh.POJO.AllResult;
import com.example.pgh.POJO.Area;
import com.example.pgh.POJO.Result;
import com.example.pgh.R.id;
import com.example.pgh.R.layout;
import com.example.pgh.R.menu;
import com.example.pgh.Water.AddWaterAdvActivity;
import com.example.pgh.Water.AddWaterAdvActivity.GetArea;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView.ScaleType;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ShowWaterActivity extends Activity {

	private Spinner spinArea;
	private Spinner spinsType;
	private ArrayList<Area> AreaList;
	private ArrayList<String> areas;
	private ArrayList<String> stypes;
	private ArrayAdapter<String> SpinnerAdapter;
	private ArrayAdapter<String> SpinnerAdapter1;
	protected String selectedarea;
	protected String selectedstype;
	protected int selectedarea1;
	protected String sarea;
	protected String stype;
	private ArrayList<Result> ResultList;
	private ListView List;
	public ViewHolder Holder;
	public String image1;
	public String image2;
	public String image3;
	public String image4;
	private ItemAdapter searchadpater;
	private Bundle extra;
	private String email;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_water);
		
		extra = getIntent().getExtras();
    	email= extra.getString("email").trim();
	
		spinArea = (Spinner)findViewById(R.id.spinner1);

		spinsType = (Spinner)findViewById(R.id.spinner2);

		AreaList = new ArrayList<Area>();
		
		areas = new ArrayList<String>();
		areas.add("All Area");

		stypes = new ArrayList<String>();
		stypes.add("Low To High");
		stypes.add("High To Low");
		
		SpinnerAdapter = new ArrayAdapter<String>(ShowWaterActivity.this,android.R.layout.simple_spinner_dropdown_item,areas);
		
		spinArea.setAdapter(SpinnerAdapter);
		
		SpinnerAdapter1 = new ArrayAdapter<String>(ShowWaterActivity.this,android.R.layout.simple_spinner_dropdown_item,stypes);
		
		spinsType.setAdapter(SpinnerAdapter1);
		
		new GetArea().execute();

		spinArea.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				selectedarea = spinArea.getSelectedItem().toString().trim();
				selectedstype= spinsType.getSelectedItem().toString().trim();
				
				if(selectedarea.contains("All Area"))
				{
					sarea="All";
				}
				else
				{
					selectedarea1 = spinArea.getSelectedItemPosition();
					sarea= AreaList.get(selectedarea1-1).getArea_ID().toString().trim();
				}
				
				if(selectedstype.contains("Low To High"))
				{
					stype="L2H";
				}
				else
				{
					stype="H2L";
				}
				
				Toast.makeText(getApplicationContext(),"Area= "+sarea+"  "+"Type=  "+stype, Toast.LENGTH_SHORT).show();
//				ResultList.clear();
				new GetResult().execute();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		spinsType.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				selectedarea = spinArea.getSelectedItem().toString().trim();
				selectedstype= spinsType.getSelectedItem().toString().trim();
				
				if(selectedarea.contains("All Area"))
				{
					sarea="All";
				}
				else
				{
					selectedarea1 = spinArea.getSelectedItemPosition();
					sarea= AreaList.get(selectedarea1-1).getArea_ID().toString().trim();
				}
				
				if(selectedstype.contains("Low To High"))
				{
					stype="L2H";
				}
				else
				{
					stype="H2L";
				}
				
//				Toast.makeText(getApplicationContext(),"Area= "+sarea+"  "+"Type=  "+stype, Toast.LENGTH_SHORT).show();
				ResultList.clear();
				new GetResult().execute();

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		ResultList = new ArrayList<Result>();
		
		List = (ListView)findViewById(R.id.listView1);
	
		searchadpater = new ItemAdapter();
		List.setAdapter(searchadpater);
		
		List.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
			
				Intent go = new Intent(ShowWaterActivity.this,ShowWater1Activity.class);
				go.putExtra("id",ResultList.get(position).getWater_ID().toString());
				go.putExtra("desc",ResultList.get(position).getDescription().toString());
				go.putExtra("title",ResultList.get(position).getTitle().toString());
				go.putExtra("price",ResultList.get(position).getRate().toString());
				go.putExtra("type",ResultList.get(position).getType().toString());
				go.putExtra("cno",ResultList.get(position).getContact().toString());
				go.putExtra("oid",ResultList.get(position).getUser_ID().toString());
				go.putExtra("email",email);
				go.putExtra("image1",image1);
				go.putExtra("image2",image2);
				go.putExtra("image3",image3);
				go.putExtra("image4",image4);
				startActivity(go);
			
			}
		});

	}
	
	public class GetArea extends AsyncTask<Void,Void,AllArea>
	{
		private ProgressDialog dialog;

		@Override
		protected void onPreExecute() 
		{
			// TODO Auto-generated method stub
			
			dialog = new ProgressDialog(ShowWaterActivity.this);
			dialog.setMessage("Loading...");
			dialog.show();
			super.onPreExecute();
		}
		

		@Override
		protected AllArea doInBackground(Void... params) 
		{
			// TODO Auto-generated method stub
			
			APICall api = new APICall();
			AllArea result = api.getArea();
			return result;
		}

		@Override
		protected void onPostExecute(AllArea result) {
			// TODO Auto-generated method stub
			if(result !=null)
			{
				AreaList.clear();
				AreaList.addAll(result.getData());
				
				for(Area a : result.getData())
				{
					areas.add(a.getArea_Name());
				}
				
			}
			else
			{
				
			}
			SpinnerAdapter.notifyDataSetChanged();
			dialog.dismiss();
			super.onPostExecute(result);
		}
		
	}

	public class GetResult extends AsyncTask<Void,Void,AllResult>
	{
		private ProgressDialog dialog;

		@Override
		protected void onPreExecute() 
		{
			// TODO Auto-generated method stub
			
			dialog = new ProgressDialog(ShowWaterActivity.this);
			dialog.setMessage("Loading...");
			dialog.show();
			super.onPreExecute();
		}
		

		@Override
		protected AllResult doInBackground(Void... params) 
		{
			// TODO Auto-generated method stub
			
			APICall api = new APICall();
			AllResult result = api.getWaterDetails(sarea, stype);
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
				convertView = getLayoutInflater().inflate(R.layout.item_wf_show,parent,false);
				
				Holder = new ViewHolder();
				
				Holder.tname = (TextView)convertView.findViewById(R.id.textView1);
				
				Holder.desc = (TextView)convertView.findViewById(R.id.textView2);
				Holder.service = (TextView)convertView.findViewById(R.id.textView4);
				Holder.rate = (TextView)convertView.findViewById(R.id.textView6);
				Holder.contact = (TextView)convertView.findViewById(R.id.textView8);
				
				Holder.timage1 = (ImageView)convertView.findViewById(R.id.imageView1);
				Holder.timage2 = (ImageView)convertView.findViewById(R.id.imageView2);
				Holder.timage3 = (ImageView)convertView.findViewById(R.id.imageView3);
				Holder.timage4 = (ImageView)convertView.findViewById(R.id.imageView4);
				Holder.timage1.setScaleType(ScaleType.FIT_XY);
				Holder.timage2.setScaleType(ScaleType.FIT_XY);
				Holder.timage3.setScaleType(ScaleType.FIT_XY);
				Holder.timage4.setScaleType(ScaleType.FIT_XY);				
				convertView.setTag(Holder);
			}
			else
			{
				Holder = (ViewHolder)convertView.getTag();
			}
			
			Holder.tname.setText(ResultList.get(position).getTitle());
			Holder.desc.setText(ResultList.get(position).getDescription());
			Holder.service.setText(ResultList.get(position).getType());
			Holder.rate.setText(ResultList.get(position).getRate());
			Holder.contact.setText(ResultList.get(position).getContact());
			
			image1= ResultList.get(position).getImage1().toString().trim();
			image2= ResultList.get(position).getImage2().toString().trim();
			image3= ResultList.get(position).getImage3().toString().trim();
			image4= ResultList.get(position).getImage4().toString().trim();
			
					
			Picasso.with(ShowWaterActivity.this).load(APIResources.BASE_URL+image1).into(Holder.timage1);
			Picasso.with(ShowWaterActivity.this).load(APIResources.BASE_URL+image2).into(Holder.timage2);
			Picasso.with(ShowWaterActivity.this).load(APIResources.BASE_URL+image3).into(Holder.timage3);
			Picasso.with(ShowWaterActivity.this).load(APIResources.BASE_URL+image4).into(Holder.timage4);
		
			return convertView;
		}
	}
	
	private static class ViewHolder
	{
		TextView tname;
		TextView tview;
		
		TextView desc;
		TextView service;
		TextView rate;
		TextView contact;
		
		
		ImageView timage1;
		ImageView timage2;
		ImageView timage3;
		ImageView timage4;
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_water, menu);
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
