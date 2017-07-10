package com.example.pgh.Food;

import java.util.ArrayList;

import com.example.pgh.R;
import com.example.pgh.API.APICall;
import com.example.pgh.API.APIResources;
import com.example.pgh.POJO.AllResult;
import com.example.pgh.POJO.Result;
import com.example.pgh.R.id;
import com.example.pgh.R.layout;
import com.example.pgh.R.menu;
import com.example.pgh.Water.WaterMyAdvActivity.GetResult;
import com.example.pgh.Water.WaterMyAdvActivity.ItemAdapter;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;

public class FoodMyAdvActivity extends Activity {

	private ArrayList<Result> ResultList;
	private ListView List;
	private ItemAdapter searchadpater;
	public ViewHolder Holder;
	public String image1;
	public String image2;
	public String image3;
	public String image4;
	private Bundle extra;
	private String email;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food_my_adv);
	
		extra = getIntent().getExtras();
    	email= extra.getString("email").trim();
		
		ResultList = new ArrayList<Result>();
		
		List = (ListView)findViewById(R.id.listView1);
	
		searchadpater = new ItemAdapter();
		List.setAdapter(searchadpater);
	
		if(email.trim()!="")
		{
			new GetResult().execute();
		}
	}

	public class GetResult extends AsyncTask<Void,Void,AllResult>
	{
		private ProgressDialog dialog;

		@Override
		protected void onPreExecute() 
		{
			// TODO Auto-generated method stub
			
			dialog = new ProgressDialog(FoodMyAdvActivity.this);
			dialog.setMessage("Loading...");
			dialog.show();
			super.onPreExecute();
		}
		

		@Override
		protected AllResult doInBackground(Void... params) 
		{
			// TODO Auto-generated method stub
			
			APICall api = new APICall();
			AllResult result = api.getUserAdvDetails(email, "Food");
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
		
		private Object image4;

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
			Holder.contact.setText(ResultList.get(position).getMobile());
			
			image1= ResultList.get(position).getImage1().toString().trim();
			image2= ResultList.get(position).getImage2().toString().trim();
			image3= ResultList.get(position).getImage3().toString().trim();
			image4= ResultList.get(position).getImage4().toString().trim();
			
					
			Picasso.with(FoodMyAdvActivity.this).load(APIResources.BASE_URL+image1).into(Holder.timage1);
			Picasso.with(FoodMyAdvActivity.this).load(APIResources.BASE_URL+image2).into(Holder.timage2);
			Picasso.with(FoodMyAdvActivity.this).load(APIResources.BASE_URL+image3).into(Holder.timage3);
			Picasso.with(FoodMyAdvActivity.this).load(APIResources.BASE_URL+image4).into(Holder.timage4);
		
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
		getMenuInflater().inflate(R.menu.food_my_adv, menu);
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
