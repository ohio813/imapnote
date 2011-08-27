package com.Pau.ImapNotes;

import com.Pau.ImapNotes.Data.ConfigurationFile;
import android.app.Application;

public class ImapNotes extends Application {
	
	private ConfigurationFile thisSessionConfigurationFile;
	
	public void SetConfigurationFile(ConfigurationFile currentSettings){
		this.thisSessionConfigurationFile = currentSettings;
		
	}
	
	public ConfigurationFile GetConfigurationFile(){
		return this.thisSessionConfigurationFile;
		
	}

}
