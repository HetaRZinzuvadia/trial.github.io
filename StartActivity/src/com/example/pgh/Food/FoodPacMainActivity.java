package com.example.pgh.Food;

import com.example.pgh.ConditionMainActivity;
import com.example.pgh.R;
import com.example.pgh.API.APICall;
import com.example.pgh.R.id;
import com.example.pgh.R.layout;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FoodPacMainActivity extends Activity {

	private EditText edttitle;
	private EditText edtrate;
	private EditText edtno;
	private EditText edtser;
	private Button btnnext;
	private String stitle;
	private String sserv;
	private String srate;
	private String sno;
	public String result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food_pac_main);
				
		edttitle = (EditText)findViewById(R.id.title);
		edtser = (EditText)findViewById(R.id.service);
		edtrate = (EditText)findViewById(R.id.rate);
		edtno = (EditText)findViewById(R.id.number);
		btnnext = (Button)findViewById(R.id.button1);
		
		
		
	btnnext.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			stitle=edttitle.getText().toString();
			sserv=edtser.getText().toString();
			srate=edtrate.getText().toString();
			sno=edtno.getText().toString();

			if(stitle== null){
				edttitle.setError("Enter title:");
			}
			/*if(sserv!= "Monthly" || sserv!= "Weekly"){
				edtser.setError("Enter monthly or weekly strictly");
			}*/
			else if(srate==null){
				edtrate.setError("Enter rate:");
			}
			else if(sno==null){
				edtrate.setError("Enter phone number:");
			}
			else{
			new foodpack().execute();
			}
		}
	});
		
	}

	
	public class foodpack extends AsyncTask<Void, Void, String>{
		
		private ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
		    dialog = new ProgressDialog(FoodPacMainActivity.this);
            dialog.setMessage("Please Wait...!");
            dialog.show();
			super.onPreExecute();
		}
		
		
		@Override
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub
			APICall apiCall=new APICall();
			result=apiCall.foodpac(stitle, sserv, srate, sno);
			return result;
		}
	
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
		  	 Toast.makeText(FoodPacMainActivity.this,result, Toast.LENGTH_LONG).show();
		      
			if (result !=null)
            {  
            	 Toast.makeText(FoodPacMainActivity.this,result, Toast.LENGTH_LONG).show();
	        }
            else
            {
                Toast.makeText(FoodPacMainActivity.this,"Server Connection Error", Toast.LENGTH_LONG).show();
            }
            dialog.dismiss();
			super.onPostExecute(result);
		}

}
}
