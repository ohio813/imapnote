package com.pau.ImapNotes.Utils;

import java.util.Vector;
import javax.mail.Message;
import android.text.Html;
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
			for (int index=list.length-1; index>=0; index--){
				this.notesTitle.add(list[index].getSubject());
				String htmlBody = (String)list[index].getContent();
				this.notes.add(Html.fromHtml(htmlBody).toString());
			}
			this.configurations.SaveConfigurationToXML();
		} catch (Exception e) {
			Log.v("ImapNote", e.getMessage());
			return false;
		}
		
		return true;
	}
	
}
