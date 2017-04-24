package com.classmates.classmates;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
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

public class home extends Activity {

	JSONParser jsonParser = new JSONParser();
	private static String url = "http://192.168.145.1/classmates/login2.php";
	private static String url2 = "http://192.168.145.1/classmates/post.php";
	private static final String TAG_SUCCESS = "success";
	String fname,lname,gender,clgname,batch,branch,image,email;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		email=getIntent().getExtras().getString("EMAIL");
		Log.d("before Response.",getIntent().getExtras().getString("EMAIL"));
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		//params.add(new BasicNameValuePair(" "," "));
		//params.add(new BasicNameValuePair("email_id",getIntent().getExtras().getString("EMAIL") ));
		params.add(new BasicNameValuePair("email_id", getIntent().getExtras().getString("EMAIL")));
//		params.add(new BasicNameValuePair("pass", PASSWORD.getText().toString()));
		JSONObject json = jsonParser.makeHttpRequest(url,"POST", params);
		Log.d("create Response.", json.toString());
		try{
			
			JSONArray jsonMainNode = json.getJSONArray("all_details");
			JSONObject jsonChildNode = jsonMainNode.getJSONObject(0);
			//fname = jsonChildNode.getString("firstname");
			Log.d("after response.", "yeah babe entered the try!!!!!");
			fname = jsonChildNode.getString("firstname");
			lname =  jsonChildNode.getString("lastname");
			gender = jsonChildNode.getString("gender");
			clgname = jsonChildNode.getString("clgname");
			batch = jsonChildNode.getString("batch");
			branch = jsonChildNode.getString("branch");
			image = jsonChildNode.getString("image");
			//Toast.makeText(home.this,fname+"\n"+lname+"\n"+"gender"+"\n"+clgname+"\n"+batch+"\n"+branch, Toast.LENGTH_LONG).show();
			
		}
		catch(JSONException e){
			e.printStackTrace();
		}
		
		
		//TextView title = (TextView) findViewById(R.id.home_heading);
		//title.setText(getIntent().getExtras().getString("EMAIL"));
		Button b = (Button) findViewById(R.id.home_postit);
		//b.setText(getIntent().getExtras().getString("message"));
		Button posts=(Button)findViewById(R.id.home_posts_view);
		Button noti=(Button)findViewById(R.id.home_notifications);
		Button chat=(Button)findViewById(R.id.home_chat);
		Button Eser=(Button)findViewById(R.id.home_services);
		Button Event=(Button)findViewById(R.id.home_timetabel);
		Button search=(Button)findViewById(R.id.home_search);
		Button profile=(Button)findViewById(R.id.home_profile);
		Button Message=(Button)findViewById(R.id.home_messages);
		Button setting=(Button)findViewById(R.id.home_settings);
		
		posts.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(home.this,fname+"\n"+lname+"\n"+gender+"\n"+clgname+"\n"+batch+"\n"+branch, Toast.LENGTH_LONG).show();
				//startActivity(new Intent("android.intent.action.POSTS" ));
				  Intent i = new Intent("android.intent.action.POSTS");
				  i.putExtra("EMAIL",email);
			  i.putExtra("name",fname);
			  i.putExtra("batch",batch);
			  i.putExtra("clgname",clgname);
			  i.putExtra("branch",branch);
			  i.putExtra("image",image);
			  i.putExtra("discuss","no");
			  i.putExtra("challenge","no");
				  startActivity(i);
			}
		});
		
		noti.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//startActivity(new Intent("android.intent.action.NOTIFICATIONS"));
				Toast.makeText(home.this,fname+"\n"+lname+"\n"+gender+"\n"+clgname+"\n"+batch+"\n"+branch, Toast.LENGTH_LONG).show();
			}
		});
		chat.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				startActivity(new Intent("android.intent.action.CHAT"));
				 Intent i = new Intent("android.intent.action.CHAT");
				 i.putExtra("EMAIL",email);
				 i.putExtra("batch",batch);
				 i.putExtra("branch",branch);
				 i.putExtra("clgname",clgname);
				 i.putExtra("from_nam",fname);
				 i.putExtra("image",image);
				 startActivity(i);
				 

			}
		});
		
		Eser.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//startActivity(new Intent("android.intent.action.E_SERVICES"));
				Intent i = new Intent("android.intent.action.E_SERVICES");
				 i.putExtra("EMAIL",email);
				 i.putExtra("batch",batch);
				 i.putExtra("branch",branch);
				 i.putExtra("clgname",clgname);
				 i.putExtra("name",fname);
				 i.putExtra("image",image);
				  i.putExtra("discuss","no");
				  i.putExtra("challenge","no");
				 startActivity(i);
				
			}
		});
		
		Event.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//startActivity(new Intent("android.intent.action.EVENTS" ));
				Intent i = new Intent("android.intent.action.EVENTS");
				 i.putExtra("EMAIL",email);
				 i.putExtra("batch",batch);
				 i.putExtra("branch",branch);
				 i.putExtra("clgname",clgname);
				 i.putExtra("name",fname);
				 i.putExtra("image",image);
				 startActivity(i);
			}
		});
		search.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//startActivity(new Intent("android.intent.action.SEARCH_OTHERS"));
				Intent i = new Intent("android.intent.action.SEARCH_OTHERS");
				 i.putExtra("EMAIL",email);
				 i.putExtra("batch",batch);
				 i.putExtra("branch",branch);
				 i.putExtra("clgname",clgname);
				 i.putExtra("name",fname);
				 i.putExtra("image",image);
				  i.putExtra("discuss","no");
				  i.putExtra("challenge","no");
				startActivity(i);
			}
		});
		profile.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//startActivity(new Intent("android.intent.action.PROFILE" ));
				Intent i= new Intent("android.intent.action.PROFILE");
				i.putExtra("EMAIL", email);
				startActivity(i);
			}
		});
		Message.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//startActivity(new Intent("android.intent.action.MESSAGES"));
				 Intent i = new Intent("android.intent.action.MESSAGE_GATEWAY");
				  i.putExtra("EMAIL",email);
				  startActivity(i);
			}
		});
		setting.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("android.intent.action.SETTINGS"));
			}
		});
		b.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				EditText post = (EditText) findViewById(R.id.post1);
				
			//	Toast.makeText(home.this,email+"\n"+post.getText().toString(), Toast.LENGTH_LONG).show();
				Log.d("before sending....","sending data");
				
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("email_id", email));
				params.add(new BasicNameValuePair("fname", fname));
				params.add(new BasicNameValuePair("image", image));
				params.add(new BasicNameValuePair("clg_name", clgname));
				params.add(new BasicNameValuePair("batch", batch));
				params.add(new BasicNameValuePair("branch", branch));
				params.add(new BasicNameValuePair("post", post.getText().toString()));
				params.add(new BasicNameValuePair("discuss", "no"));
				params.add(new BasicNameValuePair("challenge", "no"));
				JSONObject json3 = jsonParser.makeHttpRequest(url2,"POST", params);
				Log.d("after getting Response.", json3.toString());
				try {
					int success = json3.getInt(TAG_SUCCESS);
					if (success == 1) 
					 {
						
						Toast.makeText(home.this,"successfully posted ", Toast.LENGTH_LONG).show();
						post.setText("");
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
			
			return true;
		case R.id.vibrate:
			
			return true;
		}
		
		
		return true;
	}
	 
}
