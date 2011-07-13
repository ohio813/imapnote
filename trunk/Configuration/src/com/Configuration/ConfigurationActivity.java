package com.Configuration;

import com.Configuration.Utility.ConfigurationFile;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfigurationActivity extends Activity {
    
	TextView label;
	Button load;
	ConfigurationFile configurations;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.label = (TextView)findViewById(R.id.widget);
        this.load = (Button)findViewById(R.id.loadWidget);
        
        this.configurations = new ConfigurationFile(this);
        
        this.LoadButton(this.load);
        
    }
    
    public void LoadButton(View view){
    	String message = this.configurations.GetUsername()==null ? "Niente" : this.configurations.GetUsername(); 
        message += " ";
        message += this.configurations.GetPassword()==null ? "Niente" : this.configurations.GetPassword();
        
        this.label.setText(message);
    	
    }
}