package com.classmates.classmates;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class find_frnd_results extends Activity{
	static final String[]university=new String[]{
		"RGUKT RKVALLEY","RGUKT-N","RGUKT-B","OTHER"
	};
	static final String[]branch=new String[]{"CSE","ECE","MECH","CIVIL","CHEMICAL","MME","OTHERS"};
	static final String[]batches=new String[]{"2008","2009","2010","2011","2012","2013"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.find_friends);
		final Spinner univ=(Spinner)findViewById(R.id.find_universpinner1);
		final Spinner bra=(Spinner)findViewById(R.id.find_branchspinner2);
		final Spinner bach=(Spinner)findViewById(R.id.find_batchspinner1);
		ArrayAdapter<String>univadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,university);
		ArrayAdapter<String>braadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,branch);
		ArrayAdapter<String>bachadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,batches);
		univadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		braadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bachadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		univ.setAdapter(univadapter);
		bra.setAdapter(braadapter);
		bach.setAdapter(bachadapter);
		Button ser=(Button)findViewById(R.id.find_friend_button1);
		ser.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("android.intent.action.FIND_FRND_CLICK"));
				
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
			startActivity(new Intent("android.intent.action.HOME" ));
			return true;
		case R.id.vibrate:
			
			return true;
		}
		
		
		return true;
	}
}
