package com.mcunderground.bussinesapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.content.*;
import android.net.*;
import android.graphics.*;

public class MainActivity extends Activity implements OnClickListener
{
	Button websites;
	Button about;
	Button contact;
	Button exit;
	TextView title;
	ImageView share;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		websites = (Button)findViewById(R.id.webBtn);
		about = (Button)findViewById(R.id.aboutBtn);
		contact = (Button)findViewById(R.id.contactBtn);
		exit = (Button)findViewById(R.id.exitBtn);
		title = (TextView)findViewById(R.id.title);
		share = (ImageView)findViewById(R.id.shareImg);
		
		
		websites.setOnClickListener(this);
		about.setOnClickListener(this);
		contact.setOnClickListener(this);
		exit.setOnClickListener(this);
		share.setOnClickListener(this);
    }
	
	@Override
	public void onClick(View v){
		if(v == websites){
			Intent web = new Intent(this, Websites.class);
			startActivity(web);
			
		}
		
		if(v == about){
			Intent about = new Intent(this, About.class);
			startActivity(about);
		}
		
		if(v == contact){
			AlertDialog.Builder contactAlert = new AlertDialog.Builder(this);
			contactAlert.setIcon(R.drawable.contact);
			contactAlert.setMessage("Contact us by mailing, or calling us")
			.setPositiveButton("Call", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int which){
						Intent call = new Intent(Intent.ACTION_CALL);
						call.setData(Uri.parse("tel:123"));
						startActivity(call);
					}

				})
				.setNegativeButton("Mail", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int which){
						Intent mail = new Intent(Intent.ACTION_SEND);
						mail.putExtra(Intent.EXTRA_EMAIL, new String[]{"daniel.barinak@gmail.com"});
						mail.putExtra(Intent.EXTRA_SUBJECT, "Contact from app");
						mail.putExtra(Intent.EXTRA_TEXT, "Message Below:");
						
						mail.setType("message/rfc822");
						startActivity(Intent.createChooser(mail, "Choose from following:"));
					}

				})
				.setTitle("Contact Us")
				.create();
			contactAlert.show();
			
		}
		if(v == share){
			Intent shareInt = new Intent(Intent.ACTION_SEND);
			shareInt.setType("text/plain");
			// Subject for sharing(email-
			shareInt.putExtra(Intent.EXTRA_SUBJECT, "This 'company' is awesome check it out!");
			// Body, also text that is used in emails, messages and more
			shareInt.putExtra(Intent.EXTRA_TEXT, "This 'company' provides alot of things, check it out and download app here: 'link'");
			startActivity(Intent.createChooser(shareInt, "Tell about us"));
			
		}
		
		if(v == exit){
			finish();
		}
		
	}
}
