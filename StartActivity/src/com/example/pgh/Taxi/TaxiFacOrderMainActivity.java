package com.example.pgh.Taxi;

import java.util.ArrayList;

import com.example.pgh.R;
import com.example.pgh.R.layout;
import com.example.pgh.R.menu;
import com.example.pgh.API.APICall;
import com.example.pgh.POJO.Result;
import com.example.pgh.POJO.AllResult;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TaxiFacOrderMainActivity extends Activity {

	private Bundle extra;
	private String email;
	private ListView list;
	private ArrayList<Result> SearchList;
	private FriendAdapter searchadpater;
	private String number1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_taxi_fac_order_main);
		extra=getIntent().getExtras();
		
		email=null;
		email=extra.getString("email").trim();
		Toast.makeText(TaxiFacOrderMainActivity.this, email, Toast.LENGTH_LONG).show();
		
		list=(ListView)findViewById(R.id.listView1);
		SearchList = new ArrayList<Result>();
		
		searchadpater = new FriendAdapter();
		list.setAdapter(searchadpater);
		
		new TaxiFacOrd().execute();
	}

	
	public class TaxiFacOrd extends AsyncTask<Void,Void,AllResult>
	{
		private ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			
			dialog = new ProgressDialog(TaxiFacOrderMainActivity.this);
			dialog.setMessage("Loading...");
			dialog.show();
			super.onPreExecute();
		}
		

		@Override
		protected AllResult doInBackground(Void... params) {
			// TODO Auto-generated method stub
			APICall api= new APICall();
			AllResult result = api.gettaxiFacord(email);
			return result;
			
		}
		@Override
		protected void onPostExecute(AllResult result) {
			// TODO Auto-generated method stub
			if(result !=null)
			{
				SearchList.clear();
				SearchList.addAll(result.getData());
			}
			else
			{
				Toast.makeText(TaxiFacOrderMainActivity.this, "Empty", Toast.LENGTH_SHORT).show();
			}
			searchadpater.notifyDataSetChanged();
			dialog.dismiss();
			super.onPostExecute(result);
		}

}
	
	public class FriendAdapter extends BaseAdapter implements ListAdapter
	{
		private ViewHolder Holder;

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return SearchList.size() ;

		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return SearchList.get(position);
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
				convertView = getLayoutInflater().inflate(R.layout.item_wf3_show,parent,false);
				
				Holder = new ViewHolder();
				Holder.name = (TextView)convertView.findViewById(R.id.textView1);
				Holder.mobile = (TextView)convertView.findViewById(R.id.textView10);
				Holder.date = (TextView)convertView.findViewById(R.id.textView4);
				Holder.time = (TextView)convertView.findViewById(R.id.textView6);
				Holder.address = (TextView)convertView.findViewById(R.id.textView8);
				Holder.call=(ImageView)convertView.findViewById(R.id.imageView1);
				
				convertView.setTag(Holder);
			}
			else
			{
				Holder = (ViewHolder)convertView.getTag();
			}
			number1=SearchList.get(position).getMobile();

			
			Holder.name.setText(SearchList.get(position).getName());
			Holder.mobile.setText(SearchList.get(position).getMobile());
			Holder.date.setText(SearchList.get(position).getOrder_Date());
			Holder.time.setText(SearchList.get(position).getOrder_Time());
			Holder.address.setText(SearchList.get(position).getOrder_Address());
	
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
		TextView name;
		TextView mobile;
		TextView date;
		TextView time;
		TextView address;
		ImageView call;
	}
}	
	