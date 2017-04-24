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

public class posts extends Activity{

	private List<get_posts> posts = new ArrayList<get_posts>();
	JSONParser jsonParser = new JSONParser();
	//private static String url = "http://192.168.145.1/classmates/login2.php";
	private static String url3 = "http://192.168.145.1/classmates/retrieve_post.php";
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
		params.add(new BasicNameValuePair("batch", getIntent().getExtras().getString("batch")));
		params.add(new BasicNameValuePair("clgname", getIntent().getExtras().getString("clgname")));
		params.add(new BasicNameValuePair("branch", getIntent().getExtras().getString("branch")));
		params.add(new BasicNameValuePair("discuss", getIntent().getExtras().getString("discuss")));
		params.add(new BasicNameValuePair("challenge", getIntent().getExtras().getString("challenge")));
		JSONObject json1 = jsonParser.makeHttpRequest(url3,"POST", params);
		Log.d("create Response. in posts.."+getIntent().getExtras().getString("batch")+"--"+getIntent().getExtras().getString("clgname")+"--"+getIntent().getExtras().getString("branch"), json1.toString());
		try{
			
			JSONArray jsonMainNode = json1.getJSONArray("all_posts");
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
				posts.add(new get_posts(name,image,college,batch,branch,from_add,post,pid));
				
			}
		}
		catch(JSONException e){
			e.printStackTrace();
		}
	}
	private void populateListView() {
		// TODO Auto-generated method stub
		ArrayAdapter<get_posts> adapter =  new MyListAdapter();
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
				get_posts clickedpost=posts.get(position);
				String message = "You clicked "+position+" which is  "+clickedpost.getPost();
				//Toast.makeText(posts.this, message, Toast.LENGTH_LONG).show();
				int p=clickedpost.getPid();
				 Intent i = new Intent("android.intent.action.PROFILE_WALL_COMMENTS");
			/*	  i.putExtra("EMAIL",getIntent().getExtras().getString("EMAIL"));
			  i.putExtra("name",clickedpost.getName());
			  i.putExtra("batch",clickedpost.getBatch());
			  i.putExtra("clgname",clickedpost.getCollege());
			  i.putExtra("branch",clickedpost.getBranch());
			  i.putExtra("image",clickedpost.getImage());
			  i.putExtra("pi",""+clickedpost.getPid());
			  startActivity(i);*/
				 i.putExtra("name", clickedpost.getName());
				 i.putExtra("batch", clickedpost.getBatch());
				 i.putExtra("clgname", clickedpost.getCollege());
				 i.putExtra("branch", getIntent().getExtras().getString("branch"));
				 i.putExtra("image", getIntent().getExtras().getString("image"));
			//	 i.putExtra("email", getIntent().getExtras().getString("EMAIL"));
			  i.putExtra("pid",""+clickedpost.getPid());
			  i.putExtra("email", getIntent().getExtras().getString("EMAIL"));
			//  i.putExtra("discuss", getIntent().getExtras().getString("discuss"));
			 // i.putExtra("challenge", getIntent().getExtras().getString("challenge"));
			  startActivity(i);
			  Toast.makeText(posts.this,p+"", Toast.LENGTH_LONG).show();
			}
		});
	}
	private class MyListAdapter extends ArrayAdapter<get_posts>{

		public MyListAdapter() {
			super(posts.this,R.layout.item_view,posts);
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
			get_posts Currentpost = posts.get(position); 
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
			//startActivity(new Intent("android.intent.action.HOME" ));
		//	get_home_details get = new get_home_details(); 
			 Intent i = new Intent("android.intent.action.HOME");
			 startActivity(i);
			return true;
		case R.id.vibrate:
			
			return true;
		}
		
		
		return true;
	}

}
