package com.classmates.classmates;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class college_wall extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.college_wall);
		TextView name = (TextView) findViewById(R.id.college_wall_name);
		name.setText(getIntent().getExtras().getString("clgname"));
		Button college_posts = (Button) findViewById(R.id.college_posts);
		Button college_discussions = (Button) findViewById(R.id.college_discussions);
		Button college_challenges = (Button) findViewById(R.id.college_challenges);
		Button college_friends = (Button) findViewById(R.id.college_students);
		
		college_posts.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				  Intent i = new Intent("android.intent.action.POSTS");
				  i.putExtra("EMAIL",getIntent().getExtras().getString("EMAIL"));
			  i.putExtra("name",getIntent().getExtras().getString("name"));
			  i.putExtra("batch",getIntent().getExtras().getString("batch"));
			  i.putExtra("clgname",getIntent().getExtras().getString("clgname"));
			  i.putExtra("branch",getIntent().getExtras().getString("branch"));
			  i.putExtra("image",getIntent().getExtras().getString("image"));
			  i.putExtra("discuss","no");
			  i.putExtra("challenge","no");
				  startActivity(i);
			}
		});
		
		college_discussions.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent("android.intent.action.DISCUSSION");
				 i.putExtra("EMAIL",getIntent().getExtras().getString("EMAIL"));
				 i.putExtra("batch",getIntent().getExtras().getString("batch"));
				 i.putExtra("branch",getIntent().getExtras().getString("branch"));
				 i.putExtra("clgname",getIntent().getExtras().getString("clgname"));
				 i.putExtra("name",getIntent().getExtras().getString("name"));
				 i.putExtra("image",getIntent().getExtras().getString("image"));
				 i.putExtra("thisname","discussions");
				  i.putExtra("discuss","yes");
				  i.putExtra("challenge","no");
				 startActivity(i);
			}
		});
		
		college_challenges.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent("android.intent.action.CHALLANGES");
				 i.putExtra("EMAIL",getIntent().getExtras().getString("EMAIL"));
				 i.putExtra("batch",getIntent().getExtras().getString("batch"));
				 i.putExtra("branch",getIntent().getExtras().getString("branch"));
				 i.putExtra("clgname",getIntent().getExtras().getString("clgname"));
				 i.putExtra("name",getIntent().getExtras().getString("name"));
				 i.putExtra("image",getIntent().getExtras().getString("image"));
				 i.putExtra("thisname","challenges");
				  i.putExtra("discuss","no");
				  i.putExtra("challenge","yes");
				 startActivity(i);
			}
		});
		
		college_friends.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent i = new Intent("android.intent.action.CHAT");
				 i.putExtra("EMAIL",getIntent().getExtras().getString("EMAIL"));
				 i.putExtra("batch",getIntent().getExtras().getString("batch"));
				 i.putExtra("branch",getIntent().getExtras().getString("branch"));
				 i.putExtra("clgname",getIntent().getExtras().getString("clgname"));
				 i.putExtra("from_nam",getIntent().getExtras().getString("name"));
				 i.putExtra("image",getIntent().getExtras().getString("image"));
				 startActivity(i);
				 //Toast.makeText(college_wall.this,getIntent().getExtras().getString("name"), Toast.LENGTH_LONG).show();
			}
		});
	}

	
}
