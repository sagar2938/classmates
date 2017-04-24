package com.classmates.classmates;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class message_reply extends Activity{

	int flag = 0;
	JSONParser jsonParser = new JSONParser();
	private static String url3 = "http://192.168.145.1/classmates/reply_message.php";
	private static final String TAG_SUCCESS = "success";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.message_reply);
		TextView receiver = (TextView) findViewById(R.id.receivername);
		receiver.setText(getIntent().getExtras().getString("TO_NAME"));
		Button b = (Button) findViewById(R.id.message_reply);
		final EditText message = (EditText) findViewById(R.id.messagebody);
		b.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Log.d("before Response.",getIntent().getExtras().getString("EMAIL"));
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("from_name", getIntent().getExtras().getString("FROM_NAME")));
				params.add(new BasicNameValuePair("from_addr", getIntent().getExtras().getString("FROM_ADDR")));
				params.add(new BasicNameValuePair("from_image", getIntent().getExtras().getString("FROM_IMAGE")));
				params.add(new BasicNameValuePair("to_addr", getIntent().getExtras().getString("TO_ADDR")));
				params.add(new BasicNameValuePair("to_name", getIntent().getExtras().getString("TO_NAME")));
				params.add(new BasicNameValuePair("to_image", getIntent().getExtras().getString("TO_IMAGE")));
				params.add(new BasicNameValuePair("message", message.getText().toString()));
				JSONObject json1 = jsonParser.makeHttpRequest(url3,"POST", params);
				Log.d("before checking for success....",json1.toString());
				try {
					int success = json1.getInt(TAG_SUCCESS);
				//	String test = json.getString(message);
			//		JSONArray jsonMainNode = json.getJSONArray("all_posts");
					
					if(success == 1){
						Log.d("after loging in.","yeah mom");
						flag = 0;
						message.setText("");
						Toast.makeText(message_reply.this,"posted successfully.."+getIntent().getExtras().getString("TO_NAME"), Toast.LENGTH_LONG).show();
					 
					}
					else{
						Log.d("after loging in.","cant post the reply");
					}
			
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	

}
