package com.Pau.ImapNotes.Miscs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class Imaper {
	
	private Store store;
	
	public void ConnectToProvider(String username, String password) throws MessagingException{
		if (this.IsConnected())
			this.store.close();
		
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");
		props.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		Session session = Session.getDefaultInstance(props, null);
		this.store = session.getStore("imaps");
		this.store.connect("imap.gmail.com", username, password);

	}
	
	public void GetNotes(ArrayList<OneNote> notesList) throws MessagingException, IOException{
		Folder notesFolder = this.store.getFolder("Notes");
		notesFolder.open(Folder.READ_ONLY);
		Message[] notesMessages = notesFolder.getMessages();
		
		notesList.clear();
		for(Message m : notesMessages){
			OneNote aNote = new OneNote(m.getSubject(), ((String)m.getContent()), m.getReceivedDate().toLocaleString());
			notesList.add(aNote);
		}
		
	}
	
	public boolean IsConnected(){
		return this.store!=null && this.store.isConnected();
		
	}

}
