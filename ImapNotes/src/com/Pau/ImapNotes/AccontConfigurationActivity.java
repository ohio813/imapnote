package com.Pau.ImapNotes;

import com.Pau.ImapNotes.Data.ConfigurationFile;
import com.Pau.ImapNotes.Miscs.Imaper;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AccontConfigurationActivity extends Activity {
	public static final int TO_REFRESH = 999;
	
	private ConfigurationFile settings;
	private Imaper imapFolder;
	
	private TextView usernameTextView;
	private TextView passwordTextView;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_selection);
        this.usernameTextView = (TextView)findViewById(R.id.usernameEdit);
        this.passwordTextView = (TextView)findViewById(R.id.passwordEdit);
        
        this.settings = ((ImapNotes)getApplicationContext()).GetConfigurationFile();
        this.imapFolder = ((ImapNotes)getApplicationContext()).GetImaper();
        
        this.usernameTextView.setText(this.settings.GetUsername()==null ? "you@gmail.com" : this.settings.GetUsername());
        this.passwordTextView.setText(this.settings.GetPassword()==null ? "your password" : this.settings.GetPassword());
        
	
	}
	
	public void DoLogin(View v) {
		ProgressDialog loadingDialog = ProgressDialog.show(this, "ImapNotes" , "Logging in to your Gmail account... ", true);

		this.settings.SetUsername(this.usernameTextView.getText().toString());
		this.settings.SetPassword(this.passwordTextView.getText().toString());
		
		new LoginThread().execute(this.imapFolder, this.settings, loadingDialog, this);
		
	}
	
	class LoginThread extends AsyncTask<Object, Void, Boolean>{
		
		protected Boolean doInBackground(Object... stuffs) {			
			try {
				((Imaper)stuffs[0]).ConnectToProvider(((ConfigurationFile)stuffs[1]).GetUsername(), ((ConfigurationFile)stuffs[1]).GetPassword());
				((ConfigurationFile)stuffs[1]).SaveConfigurationToXML();
				((AccontConfigurationActivity)stuffs[3]).setResult(AccontConfigurationActivity.TO_REFRESH);
				((AccontConfigurationActivity)stuffs[3]).finish();
				return true;
	        } catch (Exception e) {
				Log.v("ImapNotes", e.getMessage());
			} finally {
				((ProgressDialog)stuffs[2]).dismiss();
			}
			
			return false;
		}
		
	}
	
}

