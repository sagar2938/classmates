package com.classmates.classmates;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Register2 extends Activity {
	Context ctx=this;
	private ProgressDialog pDialog;
	int flag = 0;
	Spinner universities;
	Spinner branches;
	String message="";
	JSONParser jsonParser = new JSONParser();
	private static String url = "http://192.168.145.1/classmates/register.php";
	private static final String TAG_SUCCESS = "success";
	static final String[]university=new String[]{
		"RGUKT RKVALLEY","RGUKT-N","RGUKT-B"
	};
	static final String[]branch=new String[]{"CSE","ECE","MECH","CIVIL","CHEMICAL","MME"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register2);
		universities=(Spinner)findViewById(R.id.register_clg);
		ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,university);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		universities.setAdapter(adapter);
		branches=(Spinner)findViewById(R.id.register_branch);
		ArrayAdapter<String>adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,branch);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		branches.setAdapter(adapter2);
		Button b=(Button)findViewById(R.id.register_click);
		final String fname = getIntent().getExtras().getString("FNAME");
		final String lname = getIntent().getExtras().getString("LNAME");;
		final String gender = getIntent().getExtras().getString("GENDER");;
		final String email = getIntent().getExtras().getString("EMAIL");;
		final String password = getIntent().getExtras().getString("PASSWORD");;
		final String seq_ques = getIntent().getExtras().getString("SEQ_QUES");;
		final String seq_ans = getIntent().getExtras().getString("SEQ_ANS");;
		final String clg = universities.getSelectedItem().toString();
		final String branch = branches.getSelectedItem().toString();
		EditText batch = (EditText) findViewById(R.id.batch);
		final String btch=batch.toString();
		Button b2 = (Button) findViewById(R.id.button1);
		b2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextView tv = (TextView) findViewById(R.id.textView3);
				TextView tv1 = (TextView) findViewById(R.id.textView6);
				TextView tv2 = (TextView) findViewById(R.id.textView8);
				TextView tv3 = (TextView) findViewById(R.id.textView7);
				TextView tv4 = (TextView) findViewById(R.id.textView9);
				TextView tv5 = (TextView) findViewById(R.id.textView10);
				TextView tv6 = (TextView) findViewById(R.id.textView11);
				TextView tv7 = (TextView) findViewById(R.id.textView12);
				tv.setText(fname);
				tv1.setText(lname);
				tv2.setText(gender);
				tv3.setText(email);
				tv4.setText(password);
				tv5.setText(seq_ans);
				tv6.setText(seq_ques);
				tv7.setText(btch);
			}
		});
		b.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//startActivity(new Intent("android.intent.action.HOME"));
				//add security code here
				//DatabaseOperations DB = new DatabaseOperations(ctx);
			//	DB.putInformaiton(DB, fname, lname, gender, email, password, seq_ques, seq_ans, clg, btch, branch, "");
			//	Toast.makeText(getBaseContext(), "Registration Success", Toast.LENGTH_LONG).show();
			//	Intent reg2_intent1=new Intent("android.intent.action.HOME");
			//	reg2_intent1.putExtra("USER_NAME", email);
			//	startActivity(reg2_intent1);
			/*	EditText batch1 = (EditText) findViewById(R.id.batch);
				String bat = batch1.toString();
				int num=0;
				try{
					 num = Integer.parseInt(bat);
					new loginAccess().execute();
				}
				catch(NumberFormatException e){
					Toast.makeText(Register2.this,"enter your batch number  "+Integer.parseInt(bat), Toast.LENGTH_LONG).show();
					
				}*/
				new loginAccess().execute();
			}
			private boolean isOnline(Context mContext) {
				ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
				NetworkInfo netInfo = cm.getActiveNetworkInfo();
				if (netInfo != null && netInfo.isConnectedOrConnecting())
			   	  {
					return true;
		     		}
				    return false;
		       	}
		});
	}
	class loginAccess extends AsyncTask<String, String, String> {

		String message;
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(Register2.this);
			pDialog.setMessage("Sig in...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}
		@Override
		protected String doInBackground(String... arg0) {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			final String fname = getIntent().getExtras().getString("FNAME");
			final String lname = getIntent().getExtras().getString("LNAME");
			final String gender = getIntent().getExtras().getString("GENDER");
			final String email = getIntent().getExtras().getString("EMAIL");
			final String password = getIntent().getExtras().getString("PASSWORD");
			final String seq_ques = getIntent().getExtras().getString("SEQ_QUES");
			final String seq_ans = getIntent().getExtras().getString("SEQ_ANS");
			final String clg = universities.getSelectedItem().toString();
			final String branch = branches.getSelectedItem().toString();
			EditText batch = (EditText) findViewById(R.id.batch);
			final String btch=batch.toString();
			message=fname+"\n "+lname+"\n "+gender+"\n "+email+"\n "+password+"\n "+seq_ques+"\n "+seq_ans+"\n "+clg+branch+"\n "+batch.getText().toString();
			params.add(new BasicNameValuePair("firstname", fname));
			params.add(new BasicNameValuePair("lastname", lname));
			params.add(new BasicNameValuePair("gend", gender));
			params.add(new BasicNameValuePair("email_id", email));
			params.add(new BasicNameValuePair("pass", password));
			params.add(new BasicNameValuePair("ques", seq_ques));
			params.add(new BasicNameValuePair("ans", seq_ans));
			params.add(new BasicNameValuePair("college", clg));
			params.add(new BasicNameValuePair("batc", batch.getText().toString()));
			params.add(new BasicNameValuePair("bran", branch));
			params.add(new BasicNameValuePair("image", "nothing"));
			
			JSONObject json = jsonParser.makeHttpRequest(url,"POST", params);
			
			Log.d("Create Response", json.toString());
			
			try {
				int success = json.getInt(TAG_SUCCESS);
				if (success == 1) 
				 {
				  flag=0;	
				  Intent i = new Intent("android.intent.action.HOME");
				  i.putExtra("EMAIL",email);
				  i.putExtra("password",password);
				  startActivity(i);
				  finish();
				 }
				 else
				 {
					// failed to Sign in
					flag=1;
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return null;
		}
		protected void onPostExecute(String file_url) {
			pDialog.dismiss();
			if(flag==1)
				Toast.makeText(Register2.this,message, Toast.LENGTH_LONG).show();
			
		}
		
	  }
	
	

}
