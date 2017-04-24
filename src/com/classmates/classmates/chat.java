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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class chat extends Activity {

	private List<get_friends> friends = new ArrayList<get_friends>();
	JSONParser jsonParser = new JSONParser();
	//private static String url = "http://192.168.145.1/classmates/login2.php";
	private static String url3 = "http://192.168.145.1/classmates/retrieve_friends.php";
	
	private static final String TAG_SUCCESS = "success";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friends_list);
		//String from_name = getIntent().getExtras().getString("");
		populatePost();
		populateListView();
		registerClickCallBack();
		
		
	}
	private void populatePost() {
		// TODO Auto-generated method stub
		Log.d("Chat before response.",getIntent().getExtras().getString("EMAIL"));
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("batch", getIntent().getExtras().getString("batch")));
		params.add(new BasicNameValuePair("clgname", getIntent().getExtras().getString("clgname")));
		params.add(new BasicNameValuePair("branch", getIntent().getExtras().getString("branch")));
		JSONObject json1 = jsonParser.makeHttpRequest(url3,"POST", params);
		try{
			
			JSONArray jsonMainNode = json1.getJSONArray("all_friends");
			int len = jsonMainNode.length();
			for(int j=(len-1);j>=0;j--){
				JSONObject jsonChildNode = jsonMainNode.getJSONObject(j);
				String fimage = jsonChildNode.getString("image");
				String fcollege = jsonChildNode.getString("clgname");
				String fbatch = jsonChildNode.getString("batch");
				String fbranch = jsonChildNode.getString("branch");
				String femail = jsonChildNode.getString("email");
				String fname = jsonChildNode.getString("firstname");
				String lname = jsonChildNode.getString("lastname");
				friends.add(new get_friends(fimage,fcollege,fbatch,fbranch,femail,fname,lname));
				
			}
		}
		catch(JSONException e){
			e.printStackTrace();
		}
	}
	public void registerClickCallBack() {
		// TODO Auto-generated method stub
		ListView list1 =(ListView) findViewById(R.id.view_friends_list);
		list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View viewClicked,
					int position, long id) {
				// TODO Auto-generated method stub
				get_friends clickedpost=friends.get(position);
				//String message = "You clicked "+position+" which is  "+clickedpost.getPost();
				//Toast.makeText(posts.this, message, Toast.LENGTH_LONG).show();
				//int p=clickedpost.getPid();
				 Intent i = new Intent("android.intent.action.PROFILE");
				  i.putExtra("EMAIL",getIntent().getExtras().getString("EMAIL"));
				  i.putExtra("from_image",getIntent().getExtras().getString("image"));
				  i.putExtra("from_name",getIntent().getExtras().getString("from_nam"));
				  i.putExtra("FEMAIL", clickedpost.getfemail());
			  i.putExtra("name",clickedpost.getfname());
			  i.putExtra("batch",clickedpost.getfbatch());
			  i.putExtra("clgname",clickedpost.getfcollege());
			  i.putExtra("branch",clickedpost.getfbranch());
			  i.putExtra("image",clickedpost.getfimage());
			  //i.putExtra("pid",""+p);
			 // Toast.makeText(chat.this,""+clickedpost.getfemail(), Toast.LENGTH_LONG).show();
			 startActivity(i);
			 // Toast.makeText(chat.this,"from::"+getIntent().getExtras().getString("from_nam")+"\n"+clickedpost.getfname(), Toast.LENGTH_LONG).show();
			}
		});
	}
	private void populateListView() {
		// TODO Auto-generated method stub
		ArrayAdapter<get_friends> adapter =  new MyListAdapter();
		ListView list = (ListView)findViewById(R.id.view_friends_list);
		list.setAdapter(adapter);
	}
	
	private class MyListAdapter extends ArrayAdapter<get_friends>{

		public MyListAdapter() {
			super(chat.this,R.layout.friend_item_view,friends);
			// TODO Auto-generated constructor stub
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			Log.d("CHAT:: entered get view of mylistadapter", "msg");
			View itemView = convertView;
			if(itemView == null){
				
					itemView = getLayoutInflater().inflate(R.layout.friend_item_view, parent,false); 
				
			}
			get_friends Currentpost = friends.get(position); 
			ImageView imageView = (ImageView) itemView.findViewById(R.id.friend_pic);
			imageView.setImageResource(R.drawable.friends);
			
			TextView makeText = (TextView) itemView.findViewById(R.id.friend_name);
			makeText.setText(Currentpost.getfname()+" "+Currentpost.getlname());
			 
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
