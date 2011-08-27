package com.Pau.ImapNotes;

import java.io.IOException;

import com.Pau.ImapNotes.Data.ConfigurationFile;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AccontConfigurationActivity extends Activity {
	
	private ConfigurationFile settings;
	
	private TextView usernameTextView;
	private TextView passwordTextView;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_selection);
        this.usernameTextView = (TextView)findViewById(R.id.usernameEdit);
        this.passwordTextView = (TextView)findViewById(R.id.passwordEdit);
        
        this.settings = ((ImapNotes)getApplicationContext()).GetConfigurationFile();
        
        this.usernameTextView.setText(this.settings.GetUsername()==null ? "you@gmail.com" : this.settings.GetUsername());
        this.passwordTextView.setText(this.settings.GetPassword()==null ? "your password" : this.settings.GetPassword());
        
	
	}
	
	public void DoLogin(View v){
		this.settings.SetUsername(this.usernameTextView.getText().toString());
		this.settings.SetPassword(this.passwordTextView.getText().toString());
		
		try {
			this.settings.SaveConfigurationToXML();
		} catch (Exception e) {
			Log.v("ImapNotes", e.getMessage());
		}
		
		this.finish();
		
	}
	
}
