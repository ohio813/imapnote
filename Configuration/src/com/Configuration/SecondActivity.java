package com.Configuration;

import java.util.HashMap;

import com.Configuration.Utility.ConfigurationFile;

import android.app.Activity;
import android.os.Bundle;

public class SecondActivity extends Activity{

	@SuppressWarnings("unchecked")
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two);
        
        //HashMap<String, ConfigurationFile> hashMap = (HashMap<String,ConfigurationFile>)getIntent().getSerializableExtra("vars");
		//ConfigurationFile cf = hashMap.get("conf");
        
        //String message = cf.GetUsername()==null ? "Niente" : cf.GetUsername(); 
        //message += " ";
        //message += cf.GetPassword()==null ? "Niente" : cf.GetPassword();
        
	}
	
}
