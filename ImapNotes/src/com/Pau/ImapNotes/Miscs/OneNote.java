package com.Pau.ImapNotes.Miscs;

import java.util.HashMap;

public class OneNote extends HashMap<String,String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OneNote(){
		super();
		this.put("title", "No Title");
		this.put("body", "No Body");
		this.put("date", "No Date");
		
	}
	
	public OneNote(String title, String body, String date){
		super();
		this.put("title", title);
		this.put("body", body);
		this.put("date", date);
	}
	
}
