package com.Pau.ImapNotes.Miscs;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class Imaper {
	
	private Store store;
	
	public void ConnectToProvider(String username, String password) throws MessagingException{
		if (this.store!=null && this.store.isConnected())
			this.store.close();
		
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");
		props.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		Session session = Session.getDefaultInstance(props, null);
		this.store = session.getStore("imaps");
		this.store.connect("imap.gmail.com", username, password);

	}
	
	public boolean IsConnected(){
		return this.store.isConnected();
		
	}

}
