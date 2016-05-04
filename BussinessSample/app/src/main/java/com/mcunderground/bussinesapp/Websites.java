package com.mcunderground.bussinesapp;
import android.app.*;
import android.os.*;
import android.webkit.*;

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
		myWebView.setWebViewClient(new myWebViewClient());
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
	
	
	
}
