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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class events extends Activity {

	private List<get_notices> posts = new ArrayList<get_notices>();
	JSONParser jsonParser = new JSONParser();
	//private static String url = "http://192.168.145.1/classmates/login2.php";
	private static String url3 = "http://192.168.145.1/classmates/retrieve_notices.php";
	private static final String TAG_SUCCESS = "success";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.events);
		Button post_announcement = (Button) findViewById(R.id.event_post_announcement);
		post_announcement.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent("android.intent.action.POST_NOTICE");
				 i.putExtra("EMAIL",getIntent().getExtras().getString("EMAIL"));
				 i.putExtra("batch",getIntent().getExtras().getString("batch"));
				 i.putExtra("branch",getIntent().getExtras().getString("branch"));
				 i.putExtra("clgname",getIntent().getExtras().getString("clgname"));
				 i.putExtra("name",getIntent().getExtras().getString("name"));
				 i.putExtra("image",getIntent().getExtras().getString("image"));
				 startActivity(i);
				
			}
		});
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

		
		JSONObject json1 = jsonParser.makeHttpRequest(url3,"POST", params);
		//Log.d("create Response. in posts.."+getIntent().getExtras().getString("batch")+"--"+getIntent().getExtras().getString("clgname")+"--"+getIntent().getExtras().getString("branch"), json1.toString());
		try{
			
			JSONArray jsonMainNode = json1.getJSONArray("all_notices");
			int len = jsonMainNode.length();
			for(int j=(len-1);j>=0;j--){
				JSONObject jsonChildNode = jsonMainNode.getJSONObject(j);
				String image = jsonChildNode.getString("image");
				String college = jsonChildNode.getString("college");
				String batch = jsonChildNode.getString("batch");
				String branch = jsonChildNode.getString("branch");
				String subject = jsonChildNode.getString("subject");
				String date = jsonChildNode.getString("Date");
				String name = jsonChildNode.getString("name");
				String time = jsonChildNode.getString("time_of");
				String venue = jsonChildNode.getString("venue");
				String notice = jsonChildNode.getString("notice");
				posts.add(new get_notices(image,college,batch,branch,subject,date,name,time,venue,notice));
				
			}
		}
		catch(JSONException e){
			e.printStackTrace();
		}
	}
	private void populateListView() {
		// TODO Auto-generated method stub
		ArrayAdapter<get_notices> adapter =  new MyListAdapter();
		ListView list = (ListView)findViewById(R.id.view_events);
		list.setAdapter(adapter);
	}
	private class MyListAdapter extends ArrayAdapter<get_notices>{

		public MyListAdapter() {
			super(events.this,R.layout.item_view,posts);
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
			get_notices Currentpost = posts.get(position); 
			ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView1);
			imageView.setImageResource(R.drawable.friends);
			
			TextView makeText = (TextView) itemView.findViewById(R.id.get_post);
			makeText.setText(Currentpost.getSubject());
			 
			//return super.getView(position, convertView, parent);
			return itemView;
		}
	}

	public void registerClickCallBack() {
		// TODO Auto-generated method stub
		ListView list1 =(ListView) findViewById(R.id.view_events);
		list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View viewClicked,
					int position, long id) {
				// TODO Auto-generated method stub
				get_notices clickedpost=posts.get(position);
				String message = "You clicked "+position+" which is  "+clickedpost.getSubject();
				//Toast.makeText(posts.this, message, Toast.LENGTH_LONG).show();
				//int p=clickedpost.getPid();
				 Intent i = new Intent("android.intent.action.NOTICE_DISPLAY");
			/*	  i.putExtra("EMAIL",getIntent().getExtras().getString("EMAIL"));
			  i.putExtra("name",clickedpost.getName());
			  i.putExtra("batch",clickedpost.getBatch());
			  i.putExtra("clgname",clickedpost.getCollege());
			  i.putExtra("branch",clickedpost.getBranch());
			  i.putExtra("image",clickedpost.getImage());
			  i.putExtra("pi",""+clickedpost.getPid());
			  startActivity(i);*/
				 i.putExtra("name", clickedpost.getName());
				 i.putExtra("subject", clickedpost.getSubject());
				 i.putExtra("clgname", clickedpost.getCollege());
				 i.putExtra("date", clickedpost.getDate());
				 i.putExtra("venue", clickedpost.getVenue());
			//	 i.putExtra("email", getIntent().getExtras().getString("EMAIL"));
			//  i.putExtra("pid",""+clickedpost.getPid());
			  i.putExtra("time", clickedpost.getTime());
			  i.putExtra("notice", clickedpost.getNotice());
			  i.putExtra("image", clickedpost.getImage());
			//  i.putExtra("discuss", getIntent().getExtras().getString("discuss"));
			 // i.putExtra("challenge", getIntent().getExtras().getString("challenge"));
			  startActivity(i);
			//  Toast.makeText(events.this,"", Toast.LENGTH_LONG).show();
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
