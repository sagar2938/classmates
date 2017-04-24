package com.classmates.classmates;



import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class profile_posts extends Activity{

	private List<get_profile_posts> profile_post = new ArrayList<get_profile_posts>();
	JSONParser jsonParser = new JSONParser();
	//private static String url = "http://192.168.145.1/classmates/login2.php";
	private static String url3 = "http://192.168.145.1/classmates/retrieve_profile_post.php";
	private static final String TAG_SUCCESS = "success";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_feed);
		populatePost();
		populateListView();
		registerClickCallBack();
	}
	private void populatePost() {
		// TODO Auto-generated method stub
		Log.d("before Response.",getIntent().getExtras().getString("EMAIL"));
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("email", getIntent().getExtras().getString("EMAIL")));
		params.add(new BasicNameValuePair("discuss", getIntent().getExtras().getString("discuss")));
		params.add(new BasicNameValuePair("challenge", getIntent().getExtras().getString("challenge")));
		Toast.makeText(profile_posts.this,getIntent().getExtras().getString("discuss")+"  "+getIntent().getExtras().getString("challenge") , Toast.LENGTH_LONG).show();
		JSONObject json1 = jsonParser.makeHttpRequest(url3,"POST", params);
		Log.d("PROFILE", "entering try catch block");
		try{
			
			JSONArray jsonMainNode = json1.getJSONArray("all_profile_posts");
			int len = jsonMainNode.length();
			for(int j=(len-1);j>=0;j--){
				JSONObject jsonChildNode = jsonMainNode.getJSONObject(j);
				String image = jsonChildNode.getString("image");
				String college = jsonChildNode.getString("college");
				String batch = jsonChildNode.getString("batch");
				String branch = jsonChildNode.getString("branch");
				String from_add = jsonChildNode.getString("from_add");
				String post = jsonChildNode.getString("post");
				String name = jsonChildNode.getString("name");
				int pid = jsonChildNode.getInt("id");
				profile_post.add(new get_profile_posts(image,post,pid));
				
			}
		}
		catch(JSONException e){
			e.printStackTrace();
		}
	}
	private void populateListView() {
		// TODO Auto-generated method stub
		ArrayAdapter<get_profile_posts> adapter =  new MyListAdapter();
		ListView list = (ListView)findViewById(R.id.view_posts);
		list.setAdapter(adapter);
	}
	public void registerClickCallBack() {
		// TODO Auto-generated method stub
		ListView list1 =(ListView) findViewById(R.id.view_posts);
		list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View viewClicked,
					int position, long id) {
				// TODO Auto-generated method stub
				get_profile_posts clickedpost= profile_post.get(position);
				String message = "You clicked "+position+" which is  "+clickedpost.getPost();
				//Toast.makeText(profile_posts.this, message, Toast.LENGTH_LONG).show();
				int p=clickedpost.getPid();
				 Intent i = new Intent("android.intent.action.PROFILE_WALL_COMMENTS");
				 i.putExtra("name", getIntent().getExtras().getString("name"));
				 i.putExtra("batch", getIntent().getExtras().getString("batch"));
				 i.putExtra("clgname", getIntent().getExtras().getString("clgname"));
				 i.putExtra("branch", getIntent().getExtras().getString("branch"));
				 i.putExtra("image", getIntent().getExtras().getString("image"));
			//	 i.putExtra("email", getIntent().getExtras().getString("EMAIL"));
			  i.putExtra("pid",""+clickedpost.getPid());
			  i.putExtra("email", getIntent().getExtras().getString("EMAIL"));
			  i.putExtra("discuss", getIntent().getExtras().getString("discuss"));
			  i.putExtra("challenge", getIntent().getExtras().getString("challenge"));
			  startActivity(i);
			  Toast.makeText(profile_posts.this,p+"", Toast.LENGTH_LONG).show();
			}
		});
	}
	private class MyListAdapter extends ArrayAdapter<get_profile_posts>{

		public MyListAdapter() {
			super(profile_posts.this,R.layout.item_view,profile_post);
			// TODO Auto-generated constructor stub
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			Log.d(" entered get view of mylistadapter", "msg");
			View itemView = convertView;
			if(itemView == null){
				
					itemView = getLayoutInflater().inflate(R.layout.item_view, parent,false); 
				
			}
			get_profile_posts Currentpost = profile_post.get(position); 
			ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView1);
			imageView.setImageResource(R.drawable.friends);
			
			TextView makeText = (TextView) itemView.findViewById(R.id.get_post);
			makeText.setText(Currentpost.getPost());
			 
			//return super.getView(position, convertView, parent);
			return itemView;
		}
	
		

		
	
		
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







/*
public class profile_profile_posts {

}*/
