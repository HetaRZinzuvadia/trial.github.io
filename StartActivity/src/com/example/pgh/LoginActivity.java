package com.example.pgh;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.pgh.API.APICall;
import com.example.pgh.Food.FoodHomeActivity;
import com.example.pgh.Taxi.TaxiHomeActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener{

	private EditText editemail;
	private EditText editpassword;
	private Button btnLogin;
	private TextView txtsignup;
	private String uname;
	private String password;
	private TextView txtssign;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	
		
		editemail =(EditText)findViewById(R.id.editText1);
		editpassword = (EditText)findViewById(R.id.editText2);
		
		btnLogin = (Button)findViewById(R.id.button1);
		btnLogin.setOnClickListener(this);
		
		txtsignup =(TextView)findViewById(R.id.txtSignup);
		txtsignup.setOnClickListener(this);
		
		txtssign = (TextView)findViewById(R.id.textView1);
		txtssign.setOnClickListener(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		
		return true;
	}

	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		if(v==btnLogin)
		{
			uname=editemail.getText().toString();
			password=editpassword.getText().toString();
			
			if (!isValidEmail(uname)) {
	            editemail.setError("Enter Valid Email");
	        
			}
			else if(password.trim().equals(""))
			{
				editpassword.setError("Enter Password");
				return;				
			}
			else
			{
				Toast.makeText(LoginActivity.this,"Wait..", Toast.LENGTH_SHORT).show();
				new PostForLogin().execute();
			}
		}
		
		if(v==txtssign)
		{
			Intent go = new Intent(LoginActivity.this,RegCatActivity.class);
			startActivity(go);
			finish();
		}
		
		if(v==txtsignup)
		{
			Intent go = new Intent(LoginActivity.this,UserRegisterActivity.class);
			go.putExtra("Role", "User");
			startActivity(go);
			finish();
		}
		
	}
	
	private boolean isValidEmail(String email) {
		// TODO Auto-generated method stub
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z]+(\\.[A-Za-z]+)*(\\.[A-Za-z]{2,})$";

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	private class PostForLogin extends AsyncTask<Void, Void, String> {

        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub

            dialog = new ProgressDialog(LoginActivity.this);
            dialog.setMessage("Please Wait...!");
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {
            // TODO Auto-generated method stub
            APICall api = new APICall();
            String result = api.postLogin(uname, password);
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            if (result !=null)
            {
//                    Toast.makeText(LoginActivity.this,result, Toast.LENGTH_LONG).show();  
                    gointent(result);
	        }
            else
            {
                Toast.makeText(LoginActivity.this,"Server Connection Error", Toast.LENGTH_LONG).show();
            }
            dialog.dismiss();
            super.onPostExecute(result);
        }
    }
	
	public void gointent(String result)
	{
		if(result.trim().contains("User"))
		{
			Intent go = new Intent(LoginActivity.this,UserHomeActivity.class);
			go.putExtra("email",uname.trim());
			startActivity(go);
			finish();
		}
		
		else if(result.trim().contains("Taxi"))
		{
			Intent go = new Intent(LoginActivity.this,TaxiHomeActivity.class);
			go.putExtra("email",uname.trim());
			startActivity(go);
			finish();
		}

		else if(result.trim().contains("Water"))
		{
			Intent go = new Intent(LoginActivity.this,WaterHomeActivity.class);
			go.putExtra("email",uname.trim());
			startActivity(go);
			finish();
		}
	
		else if(result.trim().contains("Food"))
		{
			Intent go = new Intent(LoginActivity.this,FoodHomeActivity.class);
			go.putExtra("email",uname.trim());
			startActivity(go);
			finish();
		}
	
		else if(result.trim().contains("Property"))
		{
			Intent go = new Intent(LoginActivity.this,PropertyHomeActivity.class);
			go.putExtra("email",uname.trim());
			startActivity(go);
			finish();
		}
	
		else
		{
		       Toast.makeText(LoginActivity.this,"Server Connection Error", Toast.LENGTH_LONG).show();
		         
		}
		
	

	}
		
}
