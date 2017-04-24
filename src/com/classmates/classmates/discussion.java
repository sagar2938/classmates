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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class discussion extends Activity {

	JSONParser jsonParser = new JSONParser();
	private static String url = "http://192.168.145.1/classmates/login2.php";
	private static String url2 = "http://192.168.145.1/classmates/post.php";
	private static final String TAG_SUCCESS = "success";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.discussion);
		Button post_discussion = (Button) findViewById(R.id.browse_Discussions);
		TextView head = (TextView) findViewById(R.id.heading);
		head.setText(getIntent().getExtras().getString("thisname"));
		Button post1 = (Button) findViewById(R.id.post_discussion);
		post_discussion.setText("Browse "+getIntent().getExtras().getString("thisname"));
		
		post_discussion.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				  Intent i = new Intent("android.intent.action.POSTS");
				  i.putExtra("EMAIL",getIntent().getExtras().getString("EMAIL"));
			  i.putExtra("name",getIntent().getExtras().getString("name"));
			  i.putExtra("batch",getIntent().getExtras().getString("batch"));
			  i.putExtra("clgname",getIntent().getExtras().getString("clgname"));
			  i.putExtra("branch",getIntent().getExtras().getString("branch"));
			  i.putExtra("image",getIntent().getExtras().getString("image"));
			  i.putExtra("discuss",getIntent().getExtras().getString("discuss"));
			  i.putExtra("challenge",getIntent().getExtras().getString("challenge"));
			 
				  startActivity(i);
			}
		});
		post1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText post = (EditText) findViewById(R.id.discussion_text);
				Log.d("before sending....","sending data");
				
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("email_id", getIntent().getExtras().getString("EMAIL")));
				params.add(new BasicNameValuePair("fname", getIntent().getExtras().getString("name")));
				params.add(new BasicNameValuePair("image", getIntent().getExtras().getString("image")));
				params.add(new BasicNameValuePair("clg_name", getIntent().getExtras().getString("clgname")));
				params.add(new BasicNameValuePair("batch", getIntent().getExtras().getString("batch")));
				params.add(new BasicNameValuePair("branch", getIntent().getExtras().getString("branch")));
				params.add(new BasicNameValuePair("post", post.getText().toString()));
				params.add(new BasicNameValuePair("discuss",getIntent().getExtras().getString("discuss")));
				params.add(new BasicNameValuePair("challenge",getIntent().getExtras().getString("challenge")));
				JSONObject json3 = jsonParser.makeHttpRequest(url2,"POST", params);
				Log.d("after getting Response.", json3.toString());
				try {
					int success = json3.getInt(TAG_SUCCESS);
					if (success == 1) 
					 {
						
						Toast.makeText(discussion.this,"successfully posted ", Toast.LENGTH_LONG).show();
						post.setText("type to post");
					//  finish();
					 }
					 else
					 {
						// failed to Sign in
						
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		MenuInflater awesom=getMenuInflater();
		awesom.inflate(R.menu.main_menu, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem menu){
		switch(menu.getItemId()){
		
		case R.id.menu1:
			startActivity(new Intent("android.intent.action.HOME" ));
			return true;
		case R.id.vibrate:
			
			return true;
		}
		
		
		return true;
	}

}
