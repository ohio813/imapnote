package com.Configuration;

import java.io.IOException;
import java.util.Hashtable;

import com.Configuration.Utility.ConfigurationFile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ConfigurationActivity extends Activity {
    
	TextView label;
	EditText username, password;

	ConfigurationFile configurations;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.label = (TextView)findViewById(R.id.widget);
        this.username = (EditText)findViewById(R.id.usernameWidget);
        this.password = (EditText)findViewById(R.id.passwordWidget);
        
        this.configurations = new ConfigurationFile(this);
        
        this.LoadButton(this.label);
        
    }
    
    public void LoadButton(View view){
    	String message = this.configurations.GetUsername()==null ? "Niente" : this.configurations.GetUsername(); 
        message += " ";
        message += this.configurations.GetPassword()==null ? "Niente" : this.configurations.GetPassword();
        
        this.label.setText(message);
    	
    }
    
    public void SaveButton(View view){
    	this.configurations.SetUsername(this.username.getText().toString());
    	this.configurations.SetPassword(this.password.getText().toString());
    	
    	try {
			this.configurations.SaveConfigurationToXML();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.Via();
    	
    }
    
    public void ClearButton(View view){
    	this.configurations.Clear();
    	this.LoadButton(view);
    	
    }
    
    public void Via(){
    	//Hashtable<String,ConfigurationFile> table = new Hashtable<String,ConfigurationFile>();
    	
    	//table.put("conf", this.configurations);
    	Intent intent = new Intent(this, SecondActivity.class);
    	intent.putExtra("var", this.configurations);
    	//intent.putExtra("vars", table);
    	//startActivity(intent);
    }
}