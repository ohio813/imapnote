package com.Pau.ImapNotes;

import com.Pau.ImapNotes.Data.ConfigurationFile;
import com.Pau.ImapNotes.Miscs.Imaper;

import android.app.Application;

public class ImapNotes extends Application {
	
	private ConfigurationFile thisSessionConfigurationFile;
	private Imaper thisSessionImapFolder;
	
	public void SetConfigurationFile(ConfigurationFile currentSettings){
		this.thisSessionConfigurationFile = currentSettings;
		
	}
	
	public ConfigurationFile GetConfigurationFile(){
		return this.thisSessionConfigurationFile;
		
	}
	
	public void SetImaper(Imaper currentImaper){
		this.thisSessionImapFolder = currentImaper;
		
	}
	
	public Imaper GetImaper(){
		return this.thisSessionImapFolder;
		
	}

}
