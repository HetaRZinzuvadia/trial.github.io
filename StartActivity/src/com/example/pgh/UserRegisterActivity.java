package com.example.pgh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.pgh.API.APICall;

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

public class UserRegisterActivity extends Activity implements OnClickListener {

	private Bundle extra;
	private String role;
	private EditText editname;
	private EditText editemail;
	private EditText editmobile;
	private EditText editpassword;
	private EditText editcpassword;
	private Button btnReg;
	private TextView txtLogin;
	private String sname;
	private String semail;
	private String smobile;
	private String spassword;
	private String scpassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_register);
		
		extra = getIntent().getExtras();
		role = extra.getString("Role");
	
		editname =(EditText)findViewById(R.id.editText2);
		editemail =(EditText)findViewById(R.id.editText3);
		editmobile =(EditText)findViewById(R.id.editText4);
		editpassword =(EditText)findViewById(R.id.editText1);
		editcpassword =(EditText)findViewById(R.id.editText5);
			
		btnReg = (Button)findViewById(R.id.button1);
		btnReg.setOnClickListener(this);
		
		txtLogin = (TextView)findViewById(R.id.textView1);
		txtLogin.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_register, menu);
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
		
		if(v==txtLogin)
		{
			Intent go = new Intent(UserRegisterActivity.this,LoginActivity.class);
			startActivity(go);
			finish();
		}
		if(v==btnReg)
		{
			sname = editname.getText().toString().trim();
			semail = editemail.getText().toString().trim();
			smobile = editmobile.getText().toString().trim();
			spassword = editpassword.getText().toString().trim();
			scpassword = editcpassword.getText().toString().trim();
				
			if(sname.equals(""))
			{
				editname.setError("Enter Title");
				return;
			}
			else if(!isValidEmail(semail))
			{
				editemail.setError("Enter Valid Email");
			}
			else if(!isValidMobile(smobile)) {
                editmobile.setError("Enter Valid Mobile");
                return;
            }
			else if(spassword.equals(""))
			{
				editpassword.setError("Enter Password");
				return;
			}
			else if(scpassword.equals(""))
			{
				editcpassword.setError("Enter Password Again");
				return;
			}
			
			else if(!spassword.contains(scpassword))
			{
				Toast.makeText(UserRegisterActivity.this,"Enter Same Password",Toast.LENGTH_SHORT).show();
				return;
			}
			else
			{
				new PostUserReg().execute();
			}

		}
	}
	
	private boolean isValidMobile(String smobile2) {
		// TODO Auto-generated method stub
		String Mobile_PATTERN = "[0-9]{10}";

		Pattern pattern = Pattern.compile(Mobile_PATTERN);
		Matcher matcher = pattern.matcher(smobile2);
		return matcher.matches();
	}

	private boolean isValidEmail(String semail2) {
		// TODO Auto-generated method stub
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z]+(\\.[A-Za-z]+)*(\\.[A-Za-z]{2,})$";

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(semail2);
		return matcher.matches();
	}

	private class PostUserReg extends AsyncTask<Void, Void, String> {

        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub

            dialog = new ProgressDialog(UserRegisterActivity.this);
            dialog.setMessage("Please Wait...!");
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {
            // TODO Auto-generated method stub
            APICall api = new APICall();
            String result = api.postUserReg1(sname,semail, smobile, spassword, role.trim());
           return result;
        }

        @Override
        protected void onPostExecute(String result) 
        {
            // TODO Auto-generated method stub
       //	Toast.makeText(UserRegisterActivity.this,result, Toast.LENGTH_LONG).show();
            if (result !=null)
            {  
            	Intent intent=new Intent(UserRegisterActivity.this, LoginActivity.class);
            	startActivity(intent);
	        }
            else
            {
                Toast.makeText(UserRegisterActivity.this,"Server Connection Error", Toast.LENGTH_LONG).show();
            }
            dialog.dismiss();
            super.onPostExecute(result);
        }
    }

}
