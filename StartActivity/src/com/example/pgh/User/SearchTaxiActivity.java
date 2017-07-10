package com.example.pgh.User;

import java.util.ArrayList;

import com.example.pgh.R;
import com.example.pgh.API.APICall;
import com.example.pgh.API.APIResources;
import com.example.pgh.POJO.AllTaxi;
import com.example.pgh.POJO.Taxi;
import com.example.pgh.R.id;
import com.example.pgh.R.layout;
import com.example.pgh.R.menu;
import com.example.pgh.Taxi.FilterActivity;
import com.example.pgh.Taxi.TaxiHomeActivity;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
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
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SearchTaxiActivity extends Activity implements OnClickListener {

	public ViewHolder Holder;
	private ItemAdapter searchadpater;
	private ListView list;
	private ArrayList<Taxi> SearchList;
	public String image1;
	public String image2;
	public String image3;
	public String image4;
	private Spinner spin;
	private ArrayAdapter<String> spinadpater;
	protected String selecteditem;
	protected String stype;
	private Button btnfilter;
	private Bundle extra;
	private String email;
	private Spinner spin2;
	private ArrayAdapter<String> spin2adpater;
	protected String selectedtype;
	protected String stype1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_taxi);
		
		extra = getIntent().getExtras();
		email = extra.getString("email");
	 	
		
		list = (ListView)findViewById(R.id.listView1);
		SearchList = new ArrayList<Taxi>();
		
		searchadpater = new ItemAdapter();
		list.setAdapter(searchadpater);
			
		
		spin = (Spinner)findViewById(R.id.spinner1);
		
		ArrayList<String> types = new ArrayList<String>();
		
		types.add("Upto 4 people");
		types.add("Upto 7 people");
		types.add("Upto 11 people");
		
		spinadpater = new ArrayAdapter<String>(SearchTaxiActivity.this,android.R.layout.simple_spinner_dropdown_item,types);

		spin.setAdapter(spinadpater);

		spin2 = (Spinner)findViewById(R.id.spinner2);
		
		ArrayList<String> stypes = new ArrayList<String>();
		
		stypes.add("All");
		stypes.add("AC");
		stypes.add("Non AC");
		
		spin2adpater = new ArrayAdapter<String>(SearchTaxiActivity.this,android.R.layout.simple_spinner_dropdown_item,stypes);

		spin2.setAdapter(spin2adpater);

		
		spin.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				
				selecteditem = spin.getSelectedItem().toString().trim();
				selectedtype = spin2.getSelectedItem().toString().trim();
				
				if(selectedtype.contains("All"))
				{
					stype1="All";
				}
				else if(selectedtype.equals("AC"))
				{
					stype1="AC";
				}
				else if(selectedtype.contains("Non AC"))
				{
					stype1="NAC";
				}
				
				
				if(selecteditem.contains("Upto 4 people"))
				{
					stype="type1";
					SearchList.clear();
					new GetTaxiDetails().execute();
				}
				else if(selecteditem.contains("Upto 7 people"))
				{
					stype="type2";
					SearchList.clear();
					new GetTaxiDetails().execute();
				}
				else if(selecteditem.contains("Upto 11 people"))
				{
					stype="type3";
					SearchList.clear();
					new GetTaxiDetails().execute();
				}
				searchadpater.notifyDataSetChanged();
					
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
		spin2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				selecteditem = spin.getSelectedItem().toString().trim();
				selectedtype = spin2.getSelectedItem().toString().trim();
				
				if(selectedtype.contains("All"))
				{
					stype1="All";
				}
				else if(selectedtype.equals("AC"))
				{
					stype1="AC";
				}
				else if(selectedtype.contains("Non AC"))
				{
					stype1="NAC";
				}
				
				
				if(selecteditem.contains("Upto 4 people"))
				{
					stype="type1";
					SearchList.clear();
					new GetTaxiDetails().execute();
				}
				else if(selecteditem.contains("Upto 7 people"))
				{
					stype="type2";
					SearchList.clear();
					new GetTaxiDetails().execute();
				}
				else if(selecteditem.contains("Upto 11 people"))
				{
					stype="type3";
					SearchList.clear();
					new GetTaxiDetails().execute();
				}
				searchadpater.notifyDataSetChanged();
					
				

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
			{
				// TODO Auto-generated method stub

				Intent next = new Intent(SearchTaxiActivity.this,SearchTaxiActivity.class);
			}
		});
		
	}

	public class GetTaxiDetails extends AsyncTask<Void,Void,AllTaxi>
	{
		private ProgressDialog dialog;

		@Override
		protected void onPreExecute() 
		{
			// TODO Auto-generated method stub
			
			dialog = new ProgressDialog(SearchTaxiActivity.this);
			dialog.setMessage("Loading...");
			dialog.show();
			super.onPreExecute();
		}
		

		@Override
		protected AllTaxi doInBackground(Void... params) 
		{
			// TODO Auto-generated method stub
			
			APICall api = new APICall();
			AllTaxi result = api.getTaxiDetails(stype.trim(),stype1.trim());
			return result;
		}

		@Override
		protected void onPostExecute(AllTaxi result) {
			// TODO Auto-generated method stub
			if(result !=null)
			{
				SearchList.clear();
				SearchList.addAll(result.getData());
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
		
		protected String ptype;
		protected String rac;
		protected String rac1;
		protected String rnac;
		protected String rnac1;
		protected String pimage1;
		protected String pimage2;
		protected String pimage3;
		protected String pimage4;

		@Override
		public int getCount() 
		{
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
		public View getView(final int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			if(convertView==null)
			{
				convertView = getLayoutInflater().inflate(R.layout.item_taxi_show,parent,false);
				
				Holder = new ViewHolder();
				Holder.tname = (TextView)convertView.findViewById(R.id.textView1);
				Holder.tview = (TextView)convertView.findViewById(R.id.textView2);
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
			
			Holder.tname.setText(SearchList.get(position).getTitle());
		//	Holder.tname.setText("Super Taxi");
			
			if(stype.contains("type1"))
			{
				image1= SearchList.get(position).getType1_1().toString().trim();
				image2= SearchList.get(position).getType1_2().toString().trim();
				image3= SearchList.get(position).getType1_3().toString().trim();
				image4= SearchList.get(position).getType1_4().toString().trim();
		
			}
			else if(stype.contains("type2"))
			{
				image1= SearchList.get(position).getType2_1().toString().trim();
				image2= SearchList.get(position).getType2_2().toString().trim();
				image3= SearchList.get(position).getType2_3().toString().trim();
				image4= SearchList.get(position).getType2_4().toString().trim();
			
			}
			else if(stype.contains("type3"))
			{
				image1= SearchList.get(position).getType3_1().toString().trim();
				image2= SearchList.get(position).getType3_2().toString().trim();
				image3= SearchList.get(position).getType3_3().toString().trim();
				image4= SearchList.get(position).getType3_4().toString().trim();	
			}
			
					
			Picasso.with(SearchTaxiActivity.this).load(APIResources.BASE_URL+image1).into(Holder.timage1);
			Picasso.with(SearchTaxiActivity.this).load(APIResources.BASE_URL+image2).into(Holder.timage2);
			Picasso.with(SearchTaxiActivity.this).load(APIResources.BASE_URL+image3).into(Holder.timage3);
			Picasso.with(SearchTaxiActivity.this).load(APIResources.BASE_URL+image4).into(Holder.timage4);
				
			Holder.tview.setOnClickListener(new OnClickListener()
			{
				
				@Override
				public void onClick(View v) 
				{
					
					if(stype.contains("type1"))
					{
						ptype="Upto 4 people";
						rac= SearchList.get(position).getType1_AC().toString().trim();
						rac1= SearchList.get(position).getType1_AC_Rate().toString().trim();
						rnac= SearchList.get(position).getType1_NonAC().toString().trim();
						rnac1= SearchList.get(position).getType1_NonAC_Rate().toString().trim();
						
						pimage1= SearchList.get(position).getType1_1().toString().trim();
						pimage2= SearchList.get(position).getType1_2().toString().trim();
						pimage3= SearchList.get(position).getType1_3().toString().trim();
						pimage4= SearchList.get(position).getType1_4().toString().trim();	
					}
					else if(stype.contains("type2"))
					{
						ptype="Upto 7 people";
						rac= SearchList.get(position).getType2_AC().toString().trim();
						rac1= SearchList.get(position).getType2_AC_Rate().toString().trim();
						rnac= SearchList.get(position).getType2_NonAC().toString().trim();
						rnac1= SearchList.get(position).getType2_NonAC_Rate().toString().trim();
						
						pimage1= SearchList.get(position).getType2_1().toString().trim();
						pimage2= SearchList.get(position).getType2_2().toString().trim();
						pimage3= SearchList.get(position).getType2_3().toString().trim();
						pimage4= SearchList.get(position).getType2_4().toString().trim();	
			
					}
					else if(stype.contains("type3"))
					{
						ptype="Upto 11 people";
						rac= SearchList.get(position).getType3_AC().toString().trim();
						rac1= SearchList.get(position).getType3_AC_Rate().toString().trim();
						rnac= SearchList.get(position).getType3_NonAC().toString().trim();
						rnac1= SearchList.get(position).getType3_NonAC_Rate().toString().trim();
						
						pimage1= SearchList.get(position).getType3_1().toString().trim();
						pimage2= SearchList.get(position).getType3_2().toString().trim();
						pimage3= SearchList.get(position).getType3_3().toString().trim();
						pimage4= SearchList.get(position).getType3_4().toString().trim();	
			
					}
					
					Toast.makeText(getApplicationContext(), ptype,Toast.LENGTH_SHORT).show();
					
					// TODO Auto-generated method stub
					Intent go = new Intent(SearchTaxiActivity.this,ShowTaxiActivity.class);
					go.putExtra("tid",SearchList.get(position).getTaxi_ID().toString());
					go.putExtra("tname",SearchList.get(position).getTaxi_ID().toString());
					go.putExtra("email",email);
					go.putExtra("ptype",ptype);
					go.putExtra("rac",rac);
					go.putExtra("rac1",rac1);
					go.putExtra("rnac",rnac);
					go.putExtra("rnac1",rnac1);
					go.putExtra("image1",pimage1);
					go.putExtra("image2",pimage2);
					go.putExtra("image3",pimage3);
					go.putExtra("image4",pimage4);
					startActivity(go);
					
				}
			});
			
			return convertView;
		}
	}
	
	private static class ViewHolder
	{
		TextView tname;
		TextView tview;
		ImageView timage1;
		ImageView timage2;
		ImageView timage3;
		ImageView timage4;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_taxi, menu);
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
		
		if(v==btnfilter)
		{
			Intent go = new Intent(SearchTaxiActivity.this,FilterActivity.class);
			go.putExtra("email",email.trim());
			go.putExtra("vtype",spin.getSelectedItem().toString().trim());
			startActivity(go);
			finish();
		}
		
	}
}
