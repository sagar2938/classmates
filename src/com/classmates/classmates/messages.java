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

public class messages extends Activity{

	private List<get_messages> messag = new ArrayList<get_messages>();
	JSONParser jsonParser = new JSONParser();
	private static String url3 = "http://192.168.145.1/classmates/retrieve_messages.php";
	private static final String TAG_SUCCESS = "success";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inbox);
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
				messag.add(new get_messages(from_addr,from_image,from_name,to_addr,to_image,to_name,message));
			}
		}
		catch(JSONException e){
			e.printStackTrace();
		}
	}
	private void populateListView() {
		// TODO Auto-generated method stub
		Log.d("inside the populate list view..", "adfafa");
		ArrayAdapter<get_messages> adapter =  new MyListAdapter();
		ListView list = (ListView)findViewById(R.id.view_inbox);
		list.setAdapter(adapter);
	}

	public void registerClickCallBack() {
		// TODO Auto-generated method stub
		ListView list1 =(ListView) findViewById(R.id.view_inbox);
		list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View viewClicked,
					int position, long id) {
				// TODO Auto-generated method stub
				get_messages clickedpost=messag.get(position);
				String message = "You clicked "+position+" which is  "+clickedpost.getmessage();
				//Toast.makeText(posts.this, message, Toast.LENGTH_LONG).show();
				//int p=clickedpost.getPid();
				Toast.makeText(messages.this,""+message,Toast.LENGTH_LONG).show();
				 Intent i = new Intent("android.intent.action.MESSAGE_REPLY");
				 i.putExtra("FROM_NAME",clickedpost.getfrom_name());
				 i.putExtra("FROM_ADDR",clickedpost.getfrom_addr());
				 i.putExtra("TO_ADDR",clickedpost.getto_addr());
				 i.putExtra("TO_NAME",clickedpost.getto_name());
				 i.putExtra("TO_IMAGE",clickedpost.getto_image());
				 i.putExtra("FROM_IMAGE",clickedpost.getfrom_image());
			//	  i.putExtra("EMAIL",getIntent().getExtras().getString("EMAIL"));
			//  i.putExtra("name",clickedpost.getName());
		//	  i.putExtra("batch",clickedpost.getBatch());
		//	  i.putExtra("clgname",clickedpost.getCollege());
		//	  i.putExtra("branch",clickedpost.getBranch());
		//	  i.putExtra("image",clickedpost.getImage());
		//	  i.putExtra("pid",""+p);
			  startActivity(i);
		//	  Toast.makeText(messages.this,""+Toast.LENGTH_LONG).show();
			}
		});
	}
	private class MyListAdapter extends ArrayAdapter<get_messages>{

		public MyListAdapter() {
			//Log.d("inside the list adapter..", "adfafa");
			super(messages.this,R.layout.inbox_item_view,messag);
			// TODO Auto-generated constructor stub
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			Log.d(" entered get view of mylistadapter", "msg");
			View itemView = convertView;
			if(itemView == null){
				
					itemView = getLayoutInflater().inflate(R.layout.inbox_item_view, parent,false); 
				
			}
			get_messages Currentpost = messag.get(position); 
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
