package com.classmates.classmates;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class E_services extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.engg_services_home);
		Button announce=(Button)findViewById(R.id.eserbutton1);
		Button challange=(Button)findViewById(R.id.eserbutton2);
		Button discuss=(Button)findViewById(R.id.eserbutton3);
		
		announce.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("android.intent.action.ANNOUNCEMENTS" ));
			}
		});
		
		challange.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//startActivity(new Intent("android.intent.action.CHALLANGES"));
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
		
		discuss.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//startActivity(new Intent("android.intent.action.DISCUSSION"));
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
