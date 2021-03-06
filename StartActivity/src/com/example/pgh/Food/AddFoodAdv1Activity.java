package com.example.pgh.Food;

import java.io.ByteArrayOutputStream;

import com.example.pgh.R;
import com.example.pgh.API.APICall;
import com.example.pgh.API.APIResources;
import com.example.pgh.Property.AddPropertyAdvActivity;
import com.example.pgh.R.id;
import com.example.pgh.R.layout;
import com.example.pgh.R.menu;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddFoodAdv1Activity extends Activity {

	ProgressDialog prgDialog;
    String encodedString;
    RequestParams params = new RequestParams();
    String imgPath, fileName;
    Bitmap bitmap;
    
	private String pid;
	private TextView cimage;
	private int count;
	private Button btnSelect;
	private Button btnUpload;
	private ImageView imgView;
	private TextView txtback;
	private Bundle extra;
	private String scount;
	private String stitle;
	private String email;
    
	private static int RESULT_LOAD_IMG = 1;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_food_adv1);

		   prgDialog = new ProgressDialog(this);
	        // Set Cancelable as False
	        prgDialog.setCancelable(false);
	    
	    	extra = getIntent().getExtras();
			
	    	pid= extra.getString("pid");
	    	stitle = extra.getString("title");
	    	email = extra.getString("email");
	        	
	    	count=1;
	        
	        cimage = (TextView)findViewById(R.id.textView4);
	        cimage.setText(String.valueOf(count));
	        
	        txtback = (TextView)findViewById(R.id.textView1);
	        txtback.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					new PostFinish().execute();
				}
			});
	        
	        btnSelect = (Button)findViewById(R.id.buttonLoadPicture1);
	        btnSelect.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					loadImagefromGallery(v);
				}
			});
	        
	        imgView = (ImageView) findViewById(R.id.imgView1);
	    	
	        
	        btnUpload = (Button)findViewById(R.id.upload1);
	        btnUpload.setOnClickListener(new OnClickListener() 
	        {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				       params.put("pid",pid.trim());
				  
					if(count==1)
					{
					       params.put("icount",String.valueOf(count));
					}
					else if(count==2)
					{
					       params.put("icount",String.valueOf(count));
					}
					else if(count==3)
					{
					       params.put("icount",String.valueOf(count));
					}
					else if(count==4)
					{
					       params.put("icount",String.valueOf(count));
					}
					
					uploadImage(v);
					
				}
			});


	}
	
	public void loadImagefromGallery(View view) {
       // Create intent to Open Image applications like Gallery, Google Photos
       Intent galleryIntent = new Intent(Intent.ACTION_PICK,
               android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
       // Start the Intent
       startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
   }

   // When Image is selected from Gallery
   @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       super.onActivityResult(requestCode, resultCode, data);
       try {
           // When an Image is picked
           if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                   && null != data) {
               // Get the Image from data

               Uri selectedImage = data.getData();
               String[] filePathColumn = { MediaStore.Images.Media.DATA };

               // Get the cursor
               Cursor cursor = getContentResolver().query(selectedImage,
                       filePathColumn, null, null, null);
               // Move to first row
               cursor.moveToFirst();

               int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
               imgPath = cursor.getString(columnIndex);
               cursor.close();
               // Set the Image in ImageView
               imgView.setImageBitmap(BitmapFactory
                       .decodeFile(imgPath));
               // Get the Image's file name
               String fileNameSegments[] = imgPath.split("/");
               fileName = fileNameSegments[fileNameSegments.length - 1];
               // Put file name in Async Http Post Param which will used in Php web app
               params.put("filename", fileName);

           } else {
               Toast.makeText(this, "You haven't picked Image",
                       Toast.LENGTH_LONG).show();
           }
       } catch (Exception e) {
           Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                   .show();
       }

   }
    
   // When Upload button is clicked
   public void uploadImage(View v) {
       // When Image is selected from Gallery
       if (imgPath != null && !imgPath.isEmpty()) {
           prgDialog.setMessage("Converting Image to Binary Data");
           prgDialog.show();
           // Convert image to String using Base64
           encodeImagetoString();
       // When Image is not selected from Gallery
       } else {
           Toast.makeText(
                   getApplicationContext(),
                   "You must select image from gallery before you try to upload",
                   Toast.LENGTH_LONG).show();
       }
   }

   // AsyncTask - To convert Image to String
   public void encodeImagetoString() {
       new AsyncTask<Void, Void, String>() {

           protected void onPreExecute() {

           };

           @Override
           protected String doInBackground(Void... params) {
               BitmapFactory.Options options = null;
               options = new BitmapFactory.Options();
               options.inSampleSize = 3;
               bitmap = BitmapFactory.decodeFile(imgPath,
                       options);
               ByteArrayOutputStream stream = new ByteArrayOutputStream();
               // Must compress the Image to reduce image size to make upload easy
               bitmap.compress(Bitmap.CompressFormat.PNG, 50, stream); 
               byte[] byte_arr = stream.toByteArray();
               // Encode Image to String
               encodedString = Base64.encodeToString(byte_arr, 0);
               return "";
           }

           @Override
           protected void onPostExecute(String msg) {
               prgDialog.setMessage("Calling Upload");
               // Put converted Image string into Async Http Post param
               params.put("image", encodedString);
               // Trigger Image upload
               triggerImageUpload();
           }
       }.execute(null, null, null);
   }
    
   public void triggerImageUpload() {
       makeHTTPCall();
   }

   // Make Http call to upload Image to Php server
   public void makeHTTPCall() {
       prgDialog.setMessage("Invoking Php");       
       AsyncHttpClient client = new AsyncHttpClient();
       // Don't forget to change the IP address to your LAN address. Port no as well.
       client.post(APIResources.POST_FOOD_IMAGE_UPDATE_URL,
               params, new AsyncHttpResponseHandler() {
                   // When the response returned by REST has Http
                   // response code '200'
                   @Override
                   public void onSuccess(String response) {
                       // Hide Progress Dialog
                       prgDialog.hide();
                       Toast.makeText(getApplicationContext(), response,Toast.LENGTH_LONG).show();
                       
                       next();
                   }

                   // When the response returned by REST has Http
                   // response code other than '200' such as '404',
                   // '500' or '403' etc
                   @Override
                   public void onFailure(int statusCode, Throwable error,
                           String content) {
                       // Hide Progress Dialog
                       prgDialog.hide();
                       // When Http response code is '404'
                       if (statusCode == 404) {
                           Toast.makeText(getApplicationContext(),
                                   "Requested resource not found",
                                   Toast.LENGTH_LONG).show();
                       }
                       // When Http response code is '500'
                       else if (statusCode == 500) {
                           Toast.makeText(getApplicationContext(),
                                   "Something went wrong at server end",
                                   Toast.LENGTH_LONG).show();
                       }
                       // When Http response code other than 404, 500
                       else {
                           Toast.makeText(
                                   getApplicationContext(),
                                   "Error Occured n Most Common Error: n1. Device not connected to Internetn2. Web App is not deployed in App servern3. App server is not runningn HTTP Status code : "
                                           + statusCode, Toast.LENGTH_LONG)
                                   .show();
                       }
                   }
               });
   }

   public void next()
   {
   	
   	count= count+1;
   	
   	if(count==5)
   	{
   		new PostFinish().execute();
   	}
   	cimage.setText(String.valueOf(count));
   	fileName="";
   	imgView.setImageBitmap(BitmapFactory.decodeFile(""));
   }
   
   @Override
   protected void onDestroy() {
       // TODO Auto-generated method stub
       super.onDestroy();
       // Dismiss the progress bar when application is closed
       if (prgDialog != null) {
           prgDialog.dismiss();
       }
   }
   
   private class PostFinish extends AsyncTask<Void, Void, String> {

       private ProgressDialog dialog;

       @Override
       protected void onPreExecute() {
           // TODO Auto-generated method stub

           dialog = new ProgressDialog(AddFoodAdv1Activity.this);
           dialog.setMessage("Please Wait...!");
           dialog.show();
           super.onPreExecute();
       }

       @Override
       protected String doInBackground(Void... params) {
           // TODO Auto-generated method stub
           APICall api = new APICall();
           String result = api.postFoodImageUpdateFinish(pid);
           return result;
       }

       @Override
       protected void onPostExecute(String result) 
       {
           // TODO Auto-generated method stub
           Toast.makeText(AddFoodAdv1Activity.this,result, Toast.LENGTH_LONG).show();
           if (result !=null)
           {            	
           	if(result.trim().contains("Active"))
           	{
           		Intent go = new Intent(AddFoodAdv1Activity.this,FoodHomeActivity.class);
           		go.putExtra("pid",result.trim());
           		go.putExtra("email",email.trim());
           		go.putExtra("title",stitle.trim());
           		startActivity(go);
           		finish();
           	}
           	else
           	{
           	
           	}
	        }
           else
           {
               Toast.makeText(AddFoodAdv1Activity.this,"Server Connection Error", Toast.LENGTH_LONG).show();
           }
           dialog.dismiss();
           super.onPostExecute(result);
       }
   }
   

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_food_adv1, menu);
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
