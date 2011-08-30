package com.Pau.ImapNotes;

import com.Pau.ImapNotes.Data.ConfigurationFile;
import com.Pau.ImapNotes.Miscs.Imaper;
import com.Pau.ImapNotes.Miscs.OneNote;

import android.app.Application;

public class ImapNotes extends Application {
	
	private ConfigurationFile thisSessionConfigurationFile;
	private Imaper thisSessionImapFolder;
	private OneNote selectedNote;
	
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
	
	public void SetSelectedNote(OneNote theNote){
		this.selectedNote = theNote;
		
	}
	
	public OneNote GetSelectedNote(){
		return this.selectedNote;
		
	}

}
