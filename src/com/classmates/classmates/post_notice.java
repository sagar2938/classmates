package com.classmates.classmates;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class post_notice extends Activity{

	JSONParser jsonParser = new JSONParser();
	private static String url = "http://192.168.145.1/classmates/post_announcement.php";
	private static final String TAG_SUCCESS = "success";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.post_notice);
		Button event_post = (Button) findViewById(R.id.Event_post);
		event_post.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText sub = (EditText) findViewById(R.id.Event_subject);
				EditText venue = (EditText) findViewById(R.id.Event_venue);
				EditText date = (EditText) findViewById(R.id.Event_date);
				EditText time = (EditText) findViewById(R.id.Event_time);
				EditText full_description = (EditText) findViewById(R.id.Event_fullDescription);
				if(sub.getText().toString().equals("")||venue.getText().toString().equals("")||date.getText().toString().equals("")||time.getText().toString().equals("")||full_description.getText().toString().equals("")){
					
					Toast.makeText(post_notice.this,"fill all the fields", Toast.LENGTH_LONG).show();
				
				}
				else{
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("email", getIntent().getExtras().getString("EMAIL")));
					params.add(new BasicNameValuePair("batch", getIntent().getExtras().getString("batch")));
					params.add(new BasicNameValuePair("branch", getIntent().getExtras().getString("branch")));
					params.add(new BasicNameValuePair("clgname", getIntent().getExtras().getString("clgname")));
					params.add(new BasicNameValuePair("name", getIntent().getExtras().getString("name")));
					params.add(new BasicNameValuePair("sub", sub.getText().toString()));
					params.add(new BasicNameValuePair("venue", venue.getText().toString()));
					params.add(new BasicNameValuePair("date", date.getText().toString()));
					params.add(new BasicNameValuePair("time", time.getText().toString()));
					params.add(new BasicNameValuePair("full_description", full_description.getText().toString()));

					JSONObject json = jsonParser.makeHttpRequest(url,"POST", params);
					Log.d("Create Response", json.toString());
					
					try {
						int success = json.getInt(TAG_SUCCESS);
						if (success == 1) 
						 {
						  
						//  Intent i = new Intent("android.intent.action.HOME");
						//  i.putExtra("EMAIL",email);
					//	  i.putExtra("password",password);
						//  startActivity(i);
							Toast.makeText(post_notice.this,"successfully posted", Toast.LENGTH_LONG).show();
						  finish();
						 }
						 else
						 {
							// failed to Sign in
							
						}
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	
}
