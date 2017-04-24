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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgot_password1 extends Activity {

	JSONParser jsonParser = new JSONParser();
	private static String url = "http://192.168.145.1/classmates/forgot_password.php";
	private static final String TAG_SUCCESS = "success";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forgot_password1);
		Button next = (Button) findViewById(R.id.forgot_next);;
		final EditText comm = (EditText) findViewById(R.id.forgot_email);
		next.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			//	String emai=em.getText().toString();
				//Toast.makeText(forgot_password1.this,emai,Toast.LENGTH_LONG).show();
				Log.d("before sending....","sending data");
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("email_id", comm.getText().toString()));
				JSONObject json3 = jsonParser.makeHttpRequest(url,"POST", params);
				Log.d("after getting Response.", json3.toString());
				
				String seqqu="";
				String seqans="";
				String empty="";
				try{
					
					JSONArray jsonMainNode = json3.getJSONArray("seq");
					int len = jsonMainNode.length();
					for(int j=(len-1);j>=0;j--){
						JSONObject jsonChildNode = jsonMainNode.getJSONObject(j);
						seqqu=jsonChildNode.getString("seqques");
						seqans=jsonChildNode.getString("seqans");
						//Toast.makeText(forgot_password1.this,jsonChildNode.getString("seqques"),Toast.LENGTH_LONG).show();
						//messag.add(new get_posts(from_addr,from_image,from_name,to_addr,to_image,to_name,message));
						//messag.add(new get_messages(from_addr,from_image,from_name,to_addr,to_image,to_name,message));
					}
				}
				catch(JSONException e){
					e.printStackTrace();
				}
				if(seqqu.equals(empty)){
					Toast.makeText(forgot_password1.this,""+comm.getText().toString()+" is not found",Toast.LENGTH_LONG).show();
					comm.setText("");
				}
				else{
					Intent i = new Intent("android.intent.action.FORGOT_PASSWORD");
					i.putExtra("email", comm.getText().toString());
					i.putExtra("seques", seqqu);
					i.putExtra("seqans", seqans);
					startActivity(i);
				}
				
				//Toast.makeText(forgot_password1.this,seqqu,Toast.LENGTH_LONG).show();
				
			}
		});
	}

	
}
