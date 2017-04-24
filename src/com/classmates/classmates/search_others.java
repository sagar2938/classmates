package com.classmates.classmates;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class search_others extends Activity {

	Spinner universities;
	Spinner branches;
	static final String[]branch=new String[]{"CSE","ECE","MECH","CIVIL","CHEMICAL","MME"};
	static final String[]university=new String[]{
		"RGUKT RKVALLEY","RGUKT-N","RGUKT-B"
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.find_other);
		universities=(Spinner)findViewById(R.id.others_clg);
		ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,university);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		universities.setAdapter(adapter);
		branches=(Spinner)findViewById(R.id.others_branch);
		ArrayAdapter<String>adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,branch);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		branches.setAdapter(adapter2);
		Button search = (Button) findViewById(R.id.others_view_details);
		search.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText batch = (EditText) findViewById(R.id.others_batch);
				Intent i = new Intent("android.intent.action.COLLEGE_WALL");
				 i.putExtra("EMAIL",getIntent().getExtras().getString("EMAIL"));
				 i.putExtra("batch",batch.getText().toString() );
				 i.putExtra("branch",branches.getSelectedItem().toString());
				 i.putExtra("clgname",universities.getSelectedItem().toString());
				 i.putExtra("name",getIntent().getExtras().getString("name"));
				 i.putExtra("image",getIntent().getExtras().getString("image"));
				  i.putExtra("discuss",getIntent().getExtras().getString("no"));
				  i.putExtra("challenge",getIntent().getExtras().getString("no"));
				startActivity(i);
			}
		});
	}

	
}
