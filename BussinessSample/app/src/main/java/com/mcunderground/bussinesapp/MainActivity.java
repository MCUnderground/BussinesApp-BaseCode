package com.mcunderground.bussinesapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.content.*;
import android.net.*;

public class MainActivity extends Activity implements OnClickListener
{
	Button websites;
	Button about;
	Button contact;
	Button exit;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		websites = (Button)findViewById(R.id.webBtn);
		about = (Button)findViewById(R.id.aboutBtn);
		contact = (Button)findViewById(R.id.contactBtn);
		exit = (Button)findViewById(R.id.exitBtn);
		
		websites.setOnClickListener(this);
		about.setOnClickListener(this);
		contact.setOnClickListener(this);
		exit.setOnClickListener(this);
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
		
		if(v == exit){
			finish();
		}
		
	}
}
