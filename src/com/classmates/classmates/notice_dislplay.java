package com.classmates.classmates;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class notice_dislplay extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notice_display);
		TextView sub = (TextView) findViewById(R.id.notice_display_subject);
		TextView date = (TextView) findViewById(R.id.notice_display_date);
		TextView venue = (TextView) findViewById(R.id.notice_display_venue);
		TextView time = (TextView) findViewById(R.id.notice_display_time);
		TextView full_desc = (TextView) findViewById(R.id.notice_display_full_description);
		TextView name = (TextView) findViewById(R.id.notice_display_name);
		TextView image = (TextView) findViewById(R.id.notice_display_image);
		sub.setText(getIntent().getExtras().getString("subject"));
		date.setText(getIntent().getExtras().getString("date"));
		venue.setText(getIntent().getExtras().getString("venue"));
		time.setText(getIntent().getExtras().getString("time"));
		full_desc.setText(getIntent().getExtras().getString("notice"));
		name.setText(getIntent().getExtras().getString("name"));
		image.setText(getIntent().getExtras().getString("image"));
	}

	
}
