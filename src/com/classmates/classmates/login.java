package com.classmates.classmates;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends Activity {
	private ProgressDialog pDialog;

	int flag = 0;
	JSONParser jsonParser = new JSONParser();
	private static String url = "http://192.168.145.1/classmates/login.php";
	private static final String TAG_SUCCESS = "success";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	
		final Context CTX = this;
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.login);
		 Button in=(Button)findViewById(R.id.login_press);

		 
		 Button forgot=(Button)findViewById(R.id.forgot_password_press);
		 forgot.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("android.intent.action.FORGOT_PASSWORD1"));
				
			}
		});
		 
		 
		 Button signup=(Button)findViewById(R.id.register_press);
		 signup.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("android.intent.action.REGISTER" ));
			}
		});
		 in.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 if(!isOnline(login.this))
					{					
						Toast.makeText(login.this,"No network connection", Toast.LENGTH_LONG).show();
						return;	
					}
				
				
				//startActivity(new Intent("android.intent.action.VIEW_DATA"));
				 EditText USERNAME1;
				 EditText PASSWORD1;
				 USERNAME1 = (EditText) findViewById(R.id.userLogin);
				 PASSWORD1 = (EditText) findViewById(R.id.userPasswordMain);
				 if(USERNAME1.getText().toString().equals("")||PASSWORD1.getText().toString().equals("")){
					 Toast.makeText(login.this,"no field should be left empty", Toast.LENGTH_LONG).show();
				 }
				 else{
				new loginAccess().execute();
				 }
				//new loginAccess().execute();
			}
			//code to check online details
			private boolean isOnline(Context mContext) {
				ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
				NetworkInfo netInfo = cm.getActiveNetworkInfo();
				if (netInfo != null && netInfo.isConnectedOrConnecting())
			   	  {
					return true;
		     		}
				    return false;
		       	}

		});
	
		 
	}
	
	class loginAccess extends AsyncTask<String, String, String> {

		String message;
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(login.this);
			pDialog.setMessage("Sig in...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}
		@Override
		protected String doInBackground(String... arg0) {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			 EditText USERNAME;
			 EditText PASSWORD;
			 USERNAME = (EditText) findViewById(R.id.userLogin);
			 PASSWORD = (EditText) findViewById(R.id.userPasswordMain);
			params.add(new BasicNameValuePair("email_id",USERNAME.getText().toString() ));
			params.add(new BasicNameValuePair("pass", PASSWORD.getText().toString()));
		
			
			JSONObject json = jsonParser.makeHttpRequest(url,"POST", params);
			
			Log.d("Create Response", json.toString());
		//	message= USERNAME.getText().toString()+"\n"+ PASSWORD.getText().toString();
			try {
				int success = json.getInt(TAG_SUCCESS);
			//	String test = json.getString(message);
		//		JSONArray jsonMainNode = json.getJSONArray("all_posts");
				
				if(success == 1){
					Log.d("after loging in.","yeah mom");
					flag = 0;
					//new get_home_details(USERNAME.getText().toString(), PASSWORD.getText().toString(), json.getString("message"));
						  Intent i = new Intent("android.intent.action.HOME");
					  i.putExtra("EMAIL",USERNAME.getText().toString());
				  i.putExtra("password",PASSWORD.getText().toString());
					 i.putExtra("name", json.getString("message"));
					  startActivity(i);
				 // Toast.makeText(login.this,"this sucks!!", Toast.LENGTH_LONG).show();
				}
		
		/*		 for(int i=0;i<jsonMainNode.length();i++){
					 JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
					 Intent in = new Intent("android.intent.action.HOME");
					  in.putExtra("FNAME",jsonChildNode.getString("firstname"));
					  in.putExtra("LNAME",jsonChildNode.getString("lastname"));
					  in.putExtra("GEND",jsonChildNode.getString("gender"));
					  in.putExtra("CLGNAME",jsonChildNode.getString("clgname"));
					  in.putExtra("BATCH",jsonChildNode.getString("batch"));
					  in.putExtra("BRANCH",jsonChildNode.getString("branch"));
					  in.putExtra("IMAGE",jsonChildNode.getString("image"));			 
					  startActivity(in); 
				 }*/
				  
				  
				  
				  //Toast.makeText(login.this,json.getString("message"), Toast.LENGTH_LONG).show();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		protected void onPostExecute(String file_url) {
			pDialog.dismiss();
			if(flag==1)
				Toast.makeText(login.this,message, Toast.LENGTH_LONG).show();
			
		}
		
	  }
	
	
	
}
