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

public class outbox extends Activity{

	private List<get_outbox> messag = new ArrayList<get_outbox>();
	JSONParser jsonParser = new JSONParser();
	private static String url3 = "http://192.168.145.1/classmates/outbox.php";
	private static final String TAG_SUCCESS = "success";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.outbox);
		Log.d("create Response. in the main Activity..", "");
		populatePost();
		populateListView();
		registerClickCallBack();
		
		
	}
	private void populatePost() {
		// TODO Auto-generated method stub
		Log.d("before Response.",getIntent().getExtras().getString("EMAIL"));
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("email", getIntent().getExtras().getString("EMAIL")));
		
	
		JSONObject json1 = jsonParser.makeHttpRequest(url3,"POST", params);
		Log.d("create Response. in populatePost of messages..", json1.toString());
		try{
			
			JSONArray jsonMainNode = json1.getJSONArray("all_messages");
			int len = jsonMainNode.length();
			for(int j=(len-1);j>=0;j--){
				JSONObject jsonChildNode = jsonMainNode.getJSONObject(j);
				String from_addr = jsonChildNode.getString("from_addr");
				String from_image = jsonChildNode.getString("from_image");
				String from_name = jsonChildNode.getString("from_name");
				String to_addr = jsonChildNode.getString("to_addr");
				String to_image = jsonChildNode.getString("to_image");
				String to_name = jsonChildNode.getString("to_name");
				String message = jsonChildNode.getString("message_body");
				//messag.add(new get_posts(from_addr,from_image,from_name,to_addr,to_image,to_name,message));
				messag.add(new get_outbox(from_addr,from_image,from_name,to_addr,to_image,to_name,message));
			}
		}
		catch(JSONException e){
			e.printStackTrace();
		}
	}
	private void populateListView() {
		// TODO Auto-generated method stub
		Log.d("inside the populate list view..", "adfafa");
		ArrayAdapter<get_outbox> adapter =  new MyListAdapter();
		ListView list = (ListView)findViewById(R.id.view_outbox);
		list.setAdapter(adapter);
	}

	public void registerClickCallBack() {
		// TODO Auto-generated method stub
		ListView list1 =(ListView) findViewById(R.id.view_outbox);
		list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View viewClicked,
					int position, long id) {
				// TODO Auto-generated method stub
				get_outbox clickedpost=messag.get(position);
				String message = "You clicked "+position+" which is  "+clickedpost.getmessage();
				//Toast.makeText(posts.this, message, Toast.LENGTH_LONG).show();
				//int p=clickedpost.getPid();
				Toast.makeText(outbox.this,""+clickedpost.getmessage(),Toast.LENGTH_LONG).show();
				
			}
		});
	}
	private class MyListAdapter extends ArrayAdapter<get_outbox>{

		public MyListAdapter() {
			//Log.d("inside the list adapter..", "adfafa");
			super(outbox.this,R.layout.outbox_item_view,messag);
			// TODO Auto-generated constructor stub
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			Log.d(" entered get view of mylistadapter", "msg");
			View itemView = convertView;
			if(itemView == null){
				
					itemView = getLayoutInflater().inflate(R.layout.outbox_item_view, parent,false); 
				
			}
			get_outbox Currentpost = messag.get(position); 
			ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView1);
			imageView.setImageResource(R.drawable.friends);
			
			TextView makeText = (TextView) itemView.findViewById(R.id.get_mess);
			makeText.setText(Currentpost.getmessage());
			 
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