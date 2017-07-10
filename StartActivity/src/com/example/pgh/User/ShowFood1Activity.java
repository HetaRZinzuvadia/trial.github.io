package com.example.pgh.User;

import com.example.pgh.R;
import com.example.pgh.API.APICall;
import com.example.pgh.API.APIResources;
import com.example.pgh.R.id;
import com.example.pgh.R.layout;
import com.example.pgh.R.menu;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;

public class ShowFood1Activity extends Activity implements OnClickListener {

	private Bundle extra;
	private String email;
	private String tid;
	private String id;
	private String title;
	private String desc;
	private String price;
	private String cno;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private TextView tname;
	private TextView tdesc;
	private TextView tservice;
	private TextView trate;
	private TextView tcontact;
	private ImageView timage1;
	private ImageView timage2;
	private ImageView timage3;
	private ImageView timage4;
	private Button btnbook;
	private Button btnbook1;
	private EditText editdate;
	private EditText edittime;
	private EditText editaddress;
	private String type;
	private String sdate;
	private String stime;
	private String saddress;
	private String oid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_food1);
		extra = getIntent().getExtras();
		email = extra.getString("email");
		id = extra.getString("id");
		title = extra.getString("title");
		desc = extra.getString("desc");
		price = extra.getString("price");
		cno = extra.getString("cno");
		type = extra.getString("type");
		oid = extra.getString("oid");
				
		image1 = extra.getString("image1");
		image2 = extra.getString("image2");
		image3 = extra.getString("image3");
		image4 = extra.getString("image4");

		
		
		tname = (TextView)findViewById(R.id.textView1);
		
		tdesc =(TextView)findViewById(R.id.textView2);
		tservice = (TextView)findViewById(R.id.textView4);
		trate = (TextView)findViewById(R.id.textView6);
		tcontact = (TextView)findViewById(R.id.textView8);
		
		tname.setText(title);
		tdesc.setText(desc);
		trate.setText(price);
		tcontact.setText(cno);
		tservice.setText(type);
			
		timage1 = (ImageView)findViewById(R.id.imageView1);
		timage2 = (ImageView)findViewById(R.id.imageView2);
		timage3 = (ImageView)findViewById(R.id.imageView3);
		timage4 = (ImageView)findViewById(R.id.imageView4);
		timage1.setScaleType(ScaleType.FIT_XY);
		timage2.setScaleType(ScaleType.FIT_XY);
		timage3.setScaleType(ScaleType.FIT_XY);
		timage4.setScaleType(ScaleType.FIT_XY);				

		
		
		
		if(!image1.trim().equals(""))
		{
			Picasso.with(ShowFood1Activity.this).load(APIResources.BASE_URL+image1).into(timage1);
		}
		if(!image2.trim().equals(""))
		{
			Picasso.with(ShowFood1Activity.this).load(APIResources.BASE_URL+image2).into(timage2);
		}
		if(!image2.trim().equals(""))
		{
			Picasso.with(ShowFood1Activity.this).load(APIResources.BASE_URL+image3).into(timage3);
		}
		if(!image2.trim().equals(""))
		{
			Picasso.with(ShowFood1Activity.this).load(APIResources.BASE_URL+image4).into(timage4);
		}

		btnbook = (Button)findViewById(R.id.button1);
		btnbook1 = (Button)findViewById(R.id.button2);
				
		editdate = (EditText)findViewById(R.id.editText1);
		edittime = (EditText)findViewById(R.id.editText2);
		editaddress = (EditText)findViewById(R.id.editText3);
		
		btnbook.setOnClickListener(this);
		btnbook1.setOnClickListener(this);
			
		editdate.setVisibility(View.INVISIBLE);
		edittime.setVisibility(View.INVISIBLE);
		editaddress.setVisibility(View.INVISIBLE);
		btnbook1.setVisibility(View.INVISIBLE);

		if(editdate.getText().toString() != null  )
		{
			editdate.setError("Enter Date");
		}
		if(edittime.getText().toString() != null )
		{
			edittime.setError("Enter Time");
		}
		if(editaddress.getText().toString() != null )
		{
			editaddress.setError("Enter Address");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_food1, menu);
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
		if(v==btnbook)
		{
			editdate.setVisibility(View.VISIBLE);
			edittime.setVisibility(View.VISIBLE);
			editaddress.setVisibility(View.VISIBLE);
			btnbook1.setVisibility(View.VISIBLE);	
			btnbook.setVisibility(View.INVISIBLE);	
		}
		
		if(v==btnbook1)
		{
			sdate = editdate.getText().toString().trim();
			stime = edittime.getText().toString().trim();
			saddress = editaddress.getText().toString().trim();
			
			if(sdate.equals(""))
			{
				editdate.setError("Enter Date");
				return;
			}
			else if(stime.equals(""))
			{
				edittime.setError("Enter Time");
				return;
			}
			else if(saddress.equals(""))
			{
				editaddress.setError("Enter Address");
				return;
			}
			else
			{
				new PostFoodOrder().execute();
			}
		}
	}
	
	private class PostFoodOrder extends AsyncTask<Void, Void, String> {

        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub

            dialog = new ProgressDialog(ShowFood1Activity.this);
            dialog.setMessage("Please Wait...!");
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {
            // TODO Auto-generated method stub
            APICall api = new APICall();
            String result = api.postFoodOrder(id,email, sdate, stime, saddress, oid);
            return result;
        }

        @Override
        protected void onPostExecute(String result) 
        {
            // TODO Auto-generated method stub
            if (result !=null)
            {
                if(result.contains("Order Placed"))
                {
                    Toast.makeText(ShowFood1Activity.this,result, Toast.LENGTH_LONG).show();
                	finish();
                }

	        }
            else
            {
                Toast.makeText(ShowFood1Activity.this,"Server Connection Error", Toast.LENGTH_LONG).show();
            }
            dialog.dismiss();
            super.onPostExecute(result);
        }
    }

}
