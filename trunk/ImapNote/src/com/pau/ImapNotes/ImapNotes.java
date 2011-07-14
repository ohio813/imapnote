package com.pau.ImapNotes;

import com.pau.ImapNotes.Utils.BloccoNotes;
import com.pau.ImapNotes.Utils.ConfigurationFile;

import android.app.Application;

public class ImapNotes extends Application{
	
	private ConfigurationFile configuration;
	private BloccoNotes bloccoNotes;
	
	public void SetDefaultConfigurationFile(ConfigurationFile c){
		this.configuration=c;
		
	}
	
	public ConfigurationFile GetDefaultConfigurationFile(){
		return this.configuration;
		
	}
	
	public void SetDefaultBloccoNotes(BloccoNotes b){
		this.bloccoNotes=b;
		
	}
	
	public BloccoNotes GetDefaultBloccoNotes(){
		return this.bloccoNotes;
		
	}

}
