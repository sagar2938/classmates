package com.classmates.classmates;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Forgot_Password extends Activity{
	JSONParser jsonParser = new JSONParser();
	private static String url = "http://192.168.145.1/classmates/update_password.php";
	private static final String TAG_SUCCESS = "success";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forgot_password);
		TextView sequrity = (TextView) findViewById(R.id.forgot_sequestion);
		sequrity.setText(getIntent().getExtras().getString("seques")+"");
		//Toast.makeText(Forgot_Password.this,getIntent().getExtras().getString("seqans"),Toast.LENGTH_LONG).show();
		Button b=(Button)findViewById(R.id.forgot_confirm_buttn);
		b.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//startActivity(new Intent("android.intent.action.HOME"));
				String empty="";
				EditText answer = (EditText) findViewById(R.id.forgot_paswd_answer);
				EditText pass = (EditText) findViewById(R.id.forgot_paswd_newpaswd);
				EditText newpass = (EditText) findViewById(R.id.forgot_paswd_confirmpaswd);
				if(answer.getText().toString().equals(getIntent().getExtras().getString("seqans"))){
					if(!pass.getText().toString().equals(empty)){
						
						Log.d("before sending....","sending data");
						List<NameValuePair> params = new ArrayList<NameValuePair>();
						params.add(new BasicNameValuePair("email_id",getIntent().getExtras().getString("email") ));
						params.add(new BasicNameValuePair("pass", newpass.getText().toString()));
						
						JSONObject json3 = jsonParser.makeHttpRequest(url,"POST", params);
						Log.d("after getting Response.", json3.toString());
						try {
							int success = json3.getInt(TAG_SUCCESS);
							if (success == 1) 
							 {
							 	
							  Intent i = new Intent("android.intent.action.LOGIN");
							 
							  startActivity(i);
							  finish();
							 }
							 else
							 {
								// failed to Sign in
								
							}
						} catch (JSONException e) {
							e.printStackTrace();
						}
						
					}
					else{
					if(pass.getText().toString().equals(newpass.getText().toString())){
						
						Toast.makeText(Forgot_Password.this,"passwords should not be empty",Toast.LENGTH_LONG).show();
						
					}
					else{
						Toast.makeText(Forgot_Password.this,"both passwords are not matchig",Toast.LENGTH_LONG).show();
						answer.setText("");
						pass.setText("");
						newpass.setText("");
					}
					}
				}
				else{
					Toast.makeText(Forgot_Password.this,"Wrong Answer..",Toast.LENGTH_LONG).show();
					answer.setText("");
					pass.setText("");
					newpass.setText("");
				}
			}
		});
	}
	
	

}
