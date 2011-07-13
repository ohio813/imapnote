package com.Configuration.Utility;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import android.content.Context;

public class ConfigurationFile {
	
	private Context referredActivity;
	
	private String username;
	private String password;
	private String[] titles;
	private String[] bodies;
	
	public ConfigurationFile(Context activity){
		this.referredActivity = activity;
		
		try {
			Document fileToLoad = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(this.referredActivity.getFilesDir()+"/ImapNotes.conf"));
		
		} catch (Exception e) {
			this.username = null;
			this.password = null;
		}
	
	}
	
	public String GetUsername(){
		return this.username;
		
	}
	
	public void SetUsername(String gmailUsername){
		this.username = gmailUsername;
		
	}
	
	public String GetPassword(){
		return this.password;
		
	}
	
	public void SetPassword(String gmailPassword){
		this.password = gmailPassword;
		
	}
}
