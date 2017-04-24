package com.classmates.classmates;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ClassmatesActivity extends Activity {
    /** Called when the activity is first created. */
	MediaPlayer logoMusic;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        logoMusic=MediaPlayer.create(ClassmatesActivity.this, R.raw.all);
        logoMusic.start();
        Thread logoTimer=new Thread(){
        	public void run(){
        		try{
        			sleep(5000);
        			Intent in=new Intent("android.intent.action.LOGIN");
        			startActivity(in);
        		}
        		catch(Exception e){e.printStackTrace();}
        		finally{
        			finish();
        		}
        	}
        };
        logoTimer.start();
    }
 
    
}