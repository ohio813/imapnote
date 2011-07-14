package com.pau.ImapNotes;

import com.pau.ImapNotes.Utils.ConfigurationFile;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserInfoActivity extends Activity{
	
	private ConfigurationFile configurations;
	
	private TextView usernameForm;
	private TextView passwordForm;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinfo);
        
        this.usernameForm = (TextView)findViewById(R.id.mailWidget);
        this.passwordForm = (TextView)findViewById(R.id.passwordWidget);
        this.configurations = ((ImapNotes)getApplicationContext()).GetDefaultConfigurationFile();
                	
        this.Refresh();
        
	}
	
	public void SaveButton(View view){
		this.configurations.SetUsername(this.usernameForm.getText().toString());
		this.configurations.SetPassword(this.passwordForm.getText().toString());
		
		this.finish();
		
	}
	
	public void ClearButton(View view){
		this.configurations.Clear();
		
		this.Refresh();
		
	}
	
	private void Refresh(){
		String username = this.configurations.GetUsername()==null ? "you@gmail.com" : this.configurations.GetUsername();
        String password = this.configurations.GetPassword()==null ? "your password" : this.configurations.GetPassword();

        this.usernameForm.setText(username);
        this.passwordForm.setText(password);
        
	}

}
