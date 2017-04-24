package com.classmates.classmates;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class profile extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_home);
		TextView branch = (TextView) findViewById(R.id.profile_branch);
		TextView batch = (TextView) findViewById(R.id.profile_batch);
		TextView name = (TextView) findViewById(R.id.profile_name);
		TextView collg = (TextView) findViewById(R.id.profile_college);
		branch.setText(getIntent().getExtras().getString("branch"));
		batch.setText(getIntent().getExtras().getString("batch"));
		name.setText(getIntent().getExtras().getString("name"));
		collg.setText(getIntent().getExtras().getString("clgname"));
		Button wall =(Button) findViewById(R.id.profile_wall);
		final Intent i = new Intent("android.intent.action.PROFILE_POSTS");
		i.putExtra("EMAIL", getIntent().getExtras().getString("FEMAIL"));
		i.putExtra("name", getIntent().getExtras().getString("name"));
		i.putExtra("batch", getIntent().getExtras().getString("batch"));
		i.putExtra("clgname", getIntent().getExtras().getString("clgname"));
		i.putExtra("branch", getIntent().getExtras().getString("branch"));
		i.putExtra("image", getIntent().getExtras().getString("image"));
		Button send_message = (Button) findViewById(R.id.send_message);
		send_message.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	Intent i = new Intent("android.intent.action.MESSAGE_REPLY");
				 Intent i = new Intent("android.intent.action.MESSAGE_REPLY");
				 i.putExtra("FROM_NAME",getIntent().getExtras().getString("from_name"));
				 i.putExtra("FROM_ADDR",getIntent().getExtras().getString("EMAIL"));
				 i.putExtra("TO_ADDR",getIntent().getExtras().getString("FEMAIL"));
				 i.putExtra("TO_NAME",getIntent().getExtras().getString("name"));
				 i.putExtra("TO_IMAGE",getIntent().getExtras().getString("image"));
				 i.putExtra("FROM_IMAGE",getIntent().getExtras().getString("from_image"));
				 startActivity(i);
				 Toast.makeText(profile.this,getIntent().getExtras().getString("from_name")+"\n"+getIntent().getExtras().getString("name") , Toast.LENGTH_LONG).show();
			}
		});
		wall.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				  i.putExtra("discuss","no");
				  i.putExtra("challenge","no");
				startActivity(i);
			}
		});
		Button profile_discussions = (Button) findViewById(R.id.profile_discussions);
		Button profile_challenges = (Button) findViewById(R.id.profile_challenges);
	profile_discussions.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				  i.putExtra("discuss","yes");
				  i.putExtra("challenge","no");
				startActivity(i);
			}
		});
	profile_challenges.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			
			  i.putExtra("discuss","no");
			  i.putExtra("challenge","yes");
			startActivity(i);
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
