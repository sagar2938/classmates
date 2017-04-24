package com.classmates.classmates;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;

public class Register extends Activity implements OnCheckedChangeListener{

	String gend="";
	static final String[]seq_question=new String[]{
		"What is favourite hero name?","What is your favourite hobbie?","What is your favourite sport?","What is your friend name?"
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register1);
		final Spinner seq_ques=(Spinner)findViewById(R.id.register_seq_ques);
		ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,seq_question);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		seq_ques.setAdapter(adapter);
		
		Button reg=(Button)findViewById(R.id.reg_button_click1);
		
		
		final EditText first_name = (EditText) findViewById(R.id.register_firstname);
		final EditText last_name = (EditText) findViewById(R.id.register_lastname);
		final EditText email = (EditText) findViewById(R.id.register_mail);
		final EditText password = (EditText) findViewById(R.id.register_password);
		final EditText seq_ans = (EditText) findViewById(R.id.register_seq_ans);
		final String fname=first_name.getText().toString();
		final String lname = last_name.getText().toString();
		final String mail = email.getText().toString();
		final String pswd = password.getText().toString();
		final String seqans = seq_ans.getText().toString();
		RadioGroup security ;
		security = (RadioGroup) findViewById(R.id.register_gender);
		security.setOnCheckedChangeListener(this);
		
		reg.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String seqques = seq_ques.getSelectedItem().toString();
				String message;
				message= fname+"\n"+lname+"\n"+mail+"\n"+pswd+"\n"+seqans+"\n"+seqques;
				//Toast.makeText(Register.this,first_name.getText().toString()+"\n"+last_name.getText().toString()+"\n"+email.getText().toString()+"\n"+password.getText().toString()+"\n"+seq_ques.getSelectedItem().toString()+"\n"+seq_ans.getText().toString(), Toast.LENGTH_LONG).show();
if(first_name.getText().toString().equals("")||last_name.getText().toString().equals("")||email.getText().toString().equals("")||seq_ans.getText().toString().equals("")||password.getText().toString().length()<8){
					
					Toast.makeText(Register.this, "no field should be left \n password length should not be less than 8 ", Toast.LENGTH_LONG).show();
				}
else{
				Intent reg_intent1=new Intent("android.intent.action.REGISTER2");
				reg_intent1.putExtra("FNAME", first_name.getText().toString());
				reg_intent1.putExtra("LNAME", last_name.getText().toString());
				reg_intent1.putExtra("GENDER", gend);
				reg_intent1.putExtra("EMAIL", email.getText().toString());
				reg_intent1.putExtra("PASSWORD", password.getText().toString());
				reg_intent1.putExtra("SEQ_QUES", seq_ques.getSelectedItem().toString());
				reg_intent1.putExtra("SEQ_ANS", seq_ans.getText().toString());
	
			startActivity(new Intent(reg_intent1));
}
			}
		});
	}
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch(checkedId)
		{
		case R.id.male :
			gend="male";
			break;
		case R.id.female:
			gend="female";
			break;
		}
		
	}
	
	

}
