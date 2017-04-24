package com.classmates.classmates;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class view_data extends Activity {

	final Context CTX = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sql_view);
		TextView tv=(TextView)findViewById(R.id.tvSQLinfo);
		
		String result = "";
		DatabaseOperations DOP = new DatabaseOperations(CTX);
		Cursor CR = DOP.getInformation(DOP);
		for(CR.moveToFirst();!CR.isAfterLast();CR.moveToNext()){
			result = result + CR.getString(0)+CR.getString(1)+"\n";
		}
		tv.setText(result);
		
	}
	
	

}
