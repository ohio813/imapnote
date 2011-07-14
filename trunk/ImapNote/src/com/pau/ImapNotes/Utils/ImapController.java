package com.pau.ImapNotes.Utils;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class ImapController {
	private Session imapSession;
	
	public ImapController(){
		Properties mailProperties = System.getProperties();
		mailProperties.setProperty("mail.store.protocol", "imaps");
		this.imapSession = Session.getDefaultInstance(mailProperties, null);
	
	}
	
	public Message[] GetNotesFromServer(String username, String password) throws MessagingException{
		Store account = this.imapSession.getStore("imaps");
		account.connect("imap.gmail.com", username, password);
		Folder notesFolder = account.getFolder("Notes");
		notesFolder.open(Folder.READ_ONLY);
		
		return notesFolder.getMessages();
	}
}
