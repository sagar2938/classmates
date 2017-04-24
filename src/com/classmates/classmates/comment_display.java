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

public class comment_display extends Activity {

	private List<get_comments> comments = new ArrayList<get_comments>();
	JSONParser jsonParser = new JSONParser();
	//private static String url = "http://192.168.145.1/classmates/login2.php";
	private static String url3 = "http://192.168.145.1/classmates/retrieve_comments.php";
	private static String url4 = "http://192.168.145.1/classmates/insert_comments.php";
	private static final String TAG_SUCCESS = "success";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comment_display);
		//Toast.makeText(comment_display.this,getIntent().getExtras().getString("pid"), Toast.LENGTH_LONG).show();
		populatePost();
		populateListView();
		registerClickCallBack();
		Button post_comment = (Button) findViewById(R.id.post_comment_button);
		post_comment.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText comm = (EditText) findViewById(R.id.write_comment_text);
				
				//	Toast.makeText(home.this,email+"\n"+post.getText().toString(), Toast.LENGTH_LONG).show();
					Log.d("before sending in comments....","sending data");
					
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("email_id", getIntent().getExtras().getString("EMAIL")));
					params.add(new BasicNameValuePair("fname", getIntent().getExtras().getString("name")));
					params.add(new BasicNameValuePair("image", getIntent().getExtras().getString("image")));
					params.add(new BasicNameValuePair("clg_name",getIntent().getExtras().getString("clgname")));
					params.add(new BasicNameValuePair("batch", getIntent().getExtras().getString("batch")));
					params.add(new BasicNameValuePair("branch", getIntent().getExtras().getString("branch")));
					
					params.add(new BasicNameValuePair("pid", getIntent().getExtras().getString("pi")));
					params.add(new BasicNameValuePair("comment", comm.getText().toString()));
					JSONObject json3 = jsonParser.makeHttpRequest(url4,"POST", params);
					Log.d("after getting Response.", json3.toString());
					try {
						int success = json3.getInt(TAG_SUCCESS);
						if (success == 1) 
						 {
							
						//	Toast.makeText(comment_display.this,"successfully posted ", Toast.LENGTH_LONG).show();
						
							populatePost();
							populateListView();
							registerClickCallBack();
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
		Log.d("before Response.",getIntent().getExtras().getString("pi"));
		//List<NameValuePair> params = new ArrayList<NameValuePair>();
	//	params.add(new BasicNameValuePair("batch", getIntent().getExtras().getString("batch")));
	//	params.add(new BasicNameValuePair("clgname", getIntent().getExtras().getString("clgname")));
	//	params.add(new BasicNameValuePair("branch", getIntent().getExtras().getString("branch")));
	//	String pid1 = "";
		//pid1=pid1+getIntent().getExtras().getString("pid");
		//params.add(new BasicNameValuePair("pid",pid1));
		//Log.d("After Response.",getIntent().getExtras().getString("pid"));
	//	List<NameValuePair> params = new ArrayList<NameValuePair>();
		//params.add(new BasicNameValuePair("parent", getIntent().getExtras().getString("pid")));
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		//	String p = "3344";
		params.add(new BasicNameValuePair("parent", ""+getIntent().getExtras().getString("pi")));
		JSONObject json1 = jsonParser.makeHttpRequest(url3,"POST", params);
		//Log.d("create Response. in posts.."+getIntent().getExtras().getString("batch")+"--"+getIntent().getExtras().getString("clgname")+"--"+getIntent().getExtras().getString("branch"), json1.toString());
		Log.d("before try.",getIntent().getExtras().getString("pi"));
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
				String comment = jsonChildNode.getString("comment");
				String name = jsonChildNode.getString("name");
//				int pid = jsonChildNode.getInt("parentid");
				comments.add(new get_comments(image,college,batch,branch,from_add,comment,name));
				
			}
			Log.d("end of populate post..", "sg");
		}
		catch(JSONException e){
			e.printStackTrace();
		}
	}
	private void populateListView() {
		// TODO Auto-generated method stub
		ArrayAdapter<get_comments> adapter =  new MyListAdapter();
		ListView list1 = (ListView)findViewById(R.id.view_comments);
		list1.setAdapter(adapter);
		Log.d("end of populate list view", "msg");
	}
	public void registerClickCallBack() {
		// TODO Auto-generated method stub
		ListView list1 =(ListView) findViewById(R.id.view_comments);
		list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View viewClicked,
					int position, long id) {
				// TODO Auto-generated method stub
				get_comments clickedpost=comments.get(position);
				String message = "You clicked "+position+" which is  "+clickedpost.getComment();
				Toast.makeText(comment_display.this, message, Toast.LENGTH_LONG).show();
				
		
			}
		});
	}

	private class MyListAdapter extends ArrayAdapter<get_comments>{
		
		public MyListAdapter(){
			super(comment_display.this,R.layout.item_view2,comments);
			Log.d(" get view of mylistadapter", "msg");
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			//	return super.getView(position, convertView, parent);
				Log.d(" entered get view of mylistadapter", "msg");
				View itemView = convertView;
				if(itemView == null){
					itemView = getLayoutInflater().inflate(R.layout.item_view2, parent,false); 
					Log.d("in if condition of get view of mylistadapter", "msg");
				}
				Log.d("after if condition of  get view of mylistadapter", "msg");
				get_comments currentComment = comments.get(position);
				ImageView imageVie = (ImageView) itemView.findViewById(R.id.imageView2);
				imageVie.setImageResource(R.drawable.friends);
				
				TextView makeText = (TextView) itemView.findViewById(R.id.get_comment);
				makeText.setText(currentComment.getComment());
				Log.d("end of get view of mylistadapter", "msg");
			//	Toast.makeText(comment_display.this, currentComment.getComment(), Toast.LENGTH_LONG).show();
				 return itemView;
			//return super.getView(position, convertView, parent);
		}

		
	/* 	@Override
		public View getView(int position, View convertView, ViewGroup parent) {
	
//		}*/
		
	}
	

}

