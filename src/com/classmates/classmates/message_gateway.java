package com.classmates.classmates;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class message_gateway extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.messagegateway);
		Button inbox = (Button) findViewById(R.id.inbox);
		Button outbox = (Button) findViewById(R.id.outbox);
		inbox.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent i = new Intent("android.intent.action.MESSAGES");
				  i.putExtra("EMAIL",getIntent().getExtras().getString("EMAIL"));
				  startActivity(i);
				
			}
		});
		outbox.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent("android.intent.action.OUTBOX");
				i.putExtra("EMAIL",getIntent().getExtras().getString("EMAIL"));
				startActivity(i);
				
			}
		});
	}
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
			
			return true;
		case R.id.vibrate:
			
			return true;
		}
		
		
		return true;
	}
	

}
