package com.mcunderground.bussinesapp;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;

public class SplashScreen extends Activity
{
	
	Thread myThread;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		myThread = new Thread(){

			@Override
			public void run(){
				try{
					sleep(3000);
					Intent afterSplash = new Intent(SplashScreen.this, MainActivity.class);
					startActivity(afterSplash);
					finish();
				} catch (InterruptedException e){
					e.printStackTrace();
				}

			}
		};
		myThread.start();

	}
}
