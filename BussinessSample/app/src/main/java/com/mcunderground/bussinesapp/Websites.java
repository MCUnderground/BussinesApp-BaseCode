package com.mcunderground.bussinesapp;
import android.app.*;
import android.os.*;
import android.webkit.*;
import android.content.*;

public class Websites extends Activity
{
	
	WebView myWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.website);
		
		myWebView = (WebView)findViewById(R.id.web);
		
		//This is link that will load
		myWebView.loadUrl("http://lostteam.github.io");
		
		//Stays in app
		myWebView.setWebViewClient(new myWebViewClient(){
				
				public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
					AlertDialog.Builder errorDialog = new AlertDialog.Builder(Websites.this);
					errorDialog.setMessage("---------\nError occured.\n\n\n1. Check your Connection\n\n2. Website is down\n\n3. Restart application\n---------")
						.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
							public void onClick(DialogInterface dialog, int which){
								Intent error = new Intent(Websites.this, MainActivity.class);
								startActivity(error);
								finish();
							}

						})
						.setTitle("Website Error")
						.create();
					errorDialog.show();
					
				}  
			
		});
	}
	
	public class myWebViewClient extends WebViewClient
	{

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url)
		{
			view.loadUrl(url);
			return true;
		}
		
		
		
	}
	
	@Override
	public void onBackPressed()
	{
		if (myWebView.canGoBack())
		{
			myWebView.goBack();
		}
		else
		{
			super.onBackPressed();
		}
	}
	
	
	
	
}
