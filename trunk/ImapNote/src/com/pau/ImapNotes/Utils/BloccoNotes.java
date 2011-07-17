package com.pau.ImapNotes.Utils;

import java.util.Vector;
import javax.mail.Message;

import android.app.ProgressDialog;
import android.util.Log;

public class BloccoNotes {

	private Vector<String> notesTitle;
	private Vector<String> notes;
	private ImapController imapBridge;
	private ConfigurationFile configurations;
	
	public BloccoNotes(ConfigurationFile myConfiguration){
		this.configurations = myConfiguration;
		this.notesTitle = this.configurations.GetTitles();
		this.notes = this.configurations.GetNotes();
		
		this.imapBridge = new ImapController();
	
	}
	
	public String GetNote(int item){
		return this.notes.get(item);
		
	}
	
	public boolean RefreshTitleList(){			
		this.notesTitle.removeAllElements();
		this.notes.removeAllElements();
		
		Message[] list;
		
		try {
			list = this.imapBridge.GetImapMessagges(this.configurations.GetUsername(), this.configurations.GetPassword());
			for (Message refreshedNote : list){
				this.notesTitle.add(refreshedNote.getSubject());
				this.notes.add((String)refreshedNote.getContent());
			}
			this.configurations.SaveConfigurationToXML();
		} catch (Exception e) {
			Log.v("ImapNote", e.getMessage());
			return false;
		}
		
		return true;
	}
	
}
