package com.example.pgh.Property;

import java.util.ArrayList;

import com.example.pgh.R;
import com.example.pgh.API.APICall;
import com.example.pgh.POJO.AllTaxi;
import com.example.pgh.POJO.Area;
import com.example.pgh.R.id;
import com.example.pgh.R.layout;
import com.example.pgh.R.menu;
import com.example.pgh.POJO.AllArea;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddPropertyAdvActivity extends Activity implements OnClickListener{

	private EditText edittitle;
	private EditText editdesc;
	private EditText editfacility;
	private EditText editrent;
	private EditText editcontact;
	private Spinner spinArea;
	private ArrayList<String> areas;
	private ArrayAdapter<String> SpinnerAdapter;
	private ArrayList<Area> AreaList;
	private Button btnnext;
	private String stitle;
	private String sdesc;
	private String sfacility;
	private String srent;
	private String scontact;
	private int selectedarea;
	private String sarea;
	private String email;
	private Bundle extra;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_property_adv);
	  
		extra = getIntent().getExtras();
    	email= extra.getString("email").trim();
	
		edittitle = (EditText)findViewById(R.id.editText1);
		editdesc = (EditText)findViewById(R.id.editText2);
		editfacility = (EditText)findViewById(R.id.editText3);
		editrent = (EditText)findViewById(R.id.editText4);
		editcontact = (EditText)findViewById(R.id.editText5);
		
		spinArea = (Spinner)findViewById(R.id.spinner1);
		
		AreaList = new ArrayList<Area>();
		
		areas = new ArrayList<String>();
		areas.add("Select Area");
		
		SpinnerAdapter = new ArrayAdapter<String>(AddPropertyAdvActivity.this,android.R.layout.simple_spinner_dropdown_item,areas);
		
		spinArea.setAdapter(SpinnerAdapter);
		
		new GetArea().execute();
		
		btnnext = (Button)findViewById(R.id.button1);
		btnnext.setOnClickListener(this);
	}
	
	public class GetArea extends AsyncTask<Void,Void,AllArea>
	{
		private ProgressDialog dialog;

		@Override
		protected void onPreExecute() 
		{
			// TODO Auto-generated method stub
			
			dialog = new ProgressDialog(AddPropertyAdvActivity.this);
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_property_adv, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
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
		if(v==btnnext)
		{
			stitle =edittitle.getText().toString().trim();
			sdesc =editdesc.getText().toString().trim();
			sfacility =editfacility.getText().toString().trim();
			srent =editrent.getText().toString().trim();
			scontact =editcontact.getText().toString().trim();
			
			selectedarea = spinArea.getSelectedItemPosition();
			
			if(stitle.equals(""))
			{
				edittitle.setError("Enter Title");
				return;
			}
			else if(sdesc.equals(""))
			{
				editdesc.setError("Enter Description");
				return;
			}
			else if(sfacility.equals(""))
			{
				editfacility.setError("Enter Facility");
				return;
			}
			else if(selectedarea==0)
			{
				Toast.makeText(AddPropertyAdvActivity.this,"Select Area",Toast.LENGTH_SHORT).show();
				return;
			}
			else if(srent.equals(""))
			{
				editrent.setError("Enter Rent");
				return;
			}
			else if(scontact.equals(""))
			{
				editcontact.setError("Enter Contact No");
				return;
			}
			else
			{
				sarea = AreaList.get(selectedarea-1).getArea_ID().toString().trim();
				
				if(!sarea.trim().equals(""))
				{
					new PostPropertyAdv().execute();
				}
				else
				{
					return;
				}
				
			}
			}
	}
	
	private class PostPropertyAdv extends AsyncTask<Void, Void, String> {

        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub

            dialog = new ProgressDialog(AddPropertyAdvActivity.this);
            dialog.setMessage("Please Wait...!");
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {
            // TODO Auto-generated method stub
            APICall api = new APICall();
            String result = api.postPropertyAdv(email, stitle, sdesc, sfacility, sarea, srent, scontact);
            return result;
        }

        @Override
        protected void onPostExecute(String result) 
        {
            // TODO Auto-generated method stub
            Toast.makeText(AddPropertyAdvActivity.this,result, Toast.LENGTH_LONG).show();
            if (result !=null)
            {            	
            	if(!result.trim().equals(""))
            	{
            		Intent go = new Intent(AddPropertyAdvActivity.this,AddPropertyAdv1Activity.class);
            		go.putExtra("pid",result.trim());
            		go.putExtra("email",email.trim());
            		go.putExtra("title",stitle.trim());
            		startActivity(go);
            		finish();
            	}
	        }
            else
            {
                Toast.makeText(AddPropertyAdvActivity.this,"Server Connection Error", Toast.LENGTH_LONG).show();
            }
            dialog.dismiss();
            super.onPostExecute(result);
        }
    }
}
