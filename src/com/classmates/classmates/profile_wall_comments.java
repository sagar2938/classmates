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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class profile_wall_comments extends Activity {

	private List<get_comments2> comments = new ArrayList<get_comments2>();
	JSONParser jsonParser = new JSONParser();
	//private static String url = "http://192.168.145.1/classmates/login2.php";
	private static String url3 = "http://192.168.145.1/classmates/retrieve_profile_comment.php";
	private static String url4 = "http://192.168.145.1/classmates/insert_comments.php";
	private static final String TAG_SUCCESS = "success";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.news_feed2);
		populatePost();
		populateListView();
		//registerClickCallBack();
		final EditText comm = (EditText) findViewById(R.id.comment_text);
		Button post_comment = (Button) findViewById(R.id.post_comment);
		post_comment.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(profile_wall_comments.this,getIntent().getExtras().getString("email")+getIntent().getExtras().getString("name")+getIntent().getExtras().getString("image")+getIntent().getExtras().getString("clgname")+getIntent().getExtras().getString("batch")+getIntent().getExtras().getString("branch")+getIntent().getExtras().getString("pid")+comm.getText().toString(), Toast.LENGTH_LONG).show();
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			/*	params.add(new BasicNameValuePair("email", getIntent().getExtras().getString("email")));
				params.add(new BasicNameValuePair("name", getIntent().getExtras().getString("name")));
				params.add(new BasicNameValuePair("image", getIntent().getExtras().getString("image")));
				params.add(new BasicNameValuePair("clgame", getIntent().getExtras().getString("clgname")));
				params.add(new BasicNameValuePair("batch", getIntent().getExtras().getString("batch")));
				params.add(new BasicNameValuePair("branch", getIntent().getExtras().getString("branch")));
				
				params.add(new BasicNameValuePair("comment",comm.getText().toString()));*/
				
				params.add(new BasicNameValuePair("email_id", getIntent().getExtras().getString("email")));
				params.add(new BasicNameValuePair("fname", getIntent().getExtras().getString("name")));
				params.add(new BasicNameValuePair("image", getIntent().getExtras().getString("image")));
				params.add(new BasicNameValuePair("clg_name",getIntent().getExtras().getString("clgname")));
				params.add(new BasicNameValuePair("batch", getIntent().getExtras().getString("batch")));
				params.add(new BasicNameValuePair("branch", getIntent().getExtras().getString("branch")));
				
				params.add(new BasicNameValuePair("pid", ""+getIntent().getExtras().getString("pid")));
				params.add(new BasicNameValuePair("comment", comm.getText().toString()));
				JSONObject json1 = jsonParser.makeHttpRequest(url4,"POST", params);	
				Log.d("after getting Response.", json1.toString());
				try {
					int success = json1.getInt(TAG_SUCCESS);
					if (success == 1) 
					 {
						
					//	Toast.makeText(comment_display.this,"successfully posted ", Toast.LENGTH_LONG).show();
						Intent i = new Intent("android.intent.action.PROFILE_WALL_COMMENTS");
						 i.putExtra("name", getIntent().getExtras().getString("name"));
						 i.putExtra("batch", getIntent().getExtras().getString("batch"));
						 i.putExtra("clgname", getIntent().getExtras().getString("clgname"));
						 i.putExtra("branch", getIntent().getExtras().getString("branch"));
						 i.putExtra("image", getIntent().getExtras().getString("image"));
					//	 i.putExtra("email", getIntent().getExtras().getString("EMAIL"));
					  i.putExtra("pid",""+getIntent().getExtras().getString("pid"));
					  i.putExtra("email", getIntent().getExtras().getString("email"));
					  i.putExtra("discuss", getIntent().getExtras().getString("discuss"));
					  i.putExtra("challenge", getIntent().getExtras().getString("challenge"));
					  startActivity(i);
						
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
	private void populatePost() {
		// TODO Auto-generated method stub
		Log.d("COMMENT :BEFORE RESPONSE.",getIntent().getExtras().getString("pid"));
		List<NameValuePair> params = new ArrayList<NameValuePair>();
	//	String p = "3344";
		params.add(new BasicNameValuePair("pid", ""+getIntent().getExtras().getString("pid")));
		//params.add(new BasicNameValuePair("pid", p));
		JSONObject json1 = jsonParser.makeHttpRequest(url3,"POST", params);

		try{
			
			JSONArray jsonMainNode = json1.getJSONArray("all_comments");
			int len = jsonMainNode.length();
			for(int j=(len-1);j>=0;j--){
				JSONObject jsonChildNode = jsonMainNode.getJSONObject(j);
				String image = jsonChildNode.getString("image");
				String college = jsonChildNode.getString("college");
				String batch = jsonChildNode.getString("batch");
				String branch = jsonChildNode.getString("branch");
				String from_add = jsonChildNode.getString("from_add");
				String post = jsonChildNode.getString("comment");
				String name = jsonChildNode.getString("name");
			//	int pid = jsonChildNode.getInt("id");
				comments.add(new get_comments2(post));
				
			}
		}
		catch(JSONException e){
			e.printStackTrace();
		}
	}
	private void populateListView() {
		// TODO Auto-generated method stub
		ArrayAdapter<get_comments2> adapter =  new MyListAdapter();
		ListView list = (ListView)findViewById(R.id.view_posts);
		list.setAdapter(adapter);
	}

/*	public void registerClickCallBack() {
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
				 Intent i = new Intent("android.intent.action.COMMENT_DISPLAY");
				  i.putExtra("EMAIL",getIntent().getExtras().getString("EMAIL"));
			  i.putExtra("name",clickedpost.getName());
			  i.putExtra("batch",clickedpost.getBatch());
			  i.putExtra("clgname",clickedpost.getCollege());
			  i.putExtra("branch",clickedpost.getBranch());
			  i.putExtra("image",clickedpost.getImage());
			  i.putExtra("pid",""+p);
			  startActivity(i);
			  Toast.makeText(posts.this,p+"", Toast.LENGTH_LONG).show();
			}
		});
	}*/
	private class MyListAdapter extends ArrayAdapter<get_comments2>{

		public MyListAdapter() {
			super(profile_wall_comments.this,R.layout.item_view,comments);
			// TODO Auto-generated constructor stub
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			Log.d("PROFILE::", "MY LIST ADAPTER");
			View itemView = convertView;
			if(itemView == null){
				
					itemView = getLayoutInflater().inflate(R.layout.item_view, parent,false); 
				
			}
			Log.d("PROFILE INSIDE::", "MY LIST ADAPTER");
			get_comments2 Currentpost = comments.get(position);
			Log.d("PROFILE RETURN VIEW BEFORE::", "MY LIST ADAPTER");
			ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView1);
			imageView.setImageResource(R.drawable.friends);
			Log.d("PROFILE RETURN VIEW AFTER::", "MY LIST ADAPTER");
			TextView makeText = (TextView) itemView.findViewById(R.id.get_post);
			makeText.setText(Currentpost.getComment());
			Log.d("PROFILE RETURN VIEW END::", "MY LIST ADAPTER");
			//return super.getView(position, convertView, parent);
			
			return itemView;
		}
	
		

		
	
		
	}
	
}
