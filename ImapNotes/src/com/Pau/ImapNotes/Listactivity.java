package com.Pau.ImapNotes;

import java.util.ArrayList;
import java.util.Random;

import com.Pau.ImapNotes.Data.ConfigurationFile;
import com.Pau.ImapNotes.Miscs.Imaper;
import com.Pau.ImapNotes.Miscs.OneNote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.ListView;

public class Listactivity extends Activity {
	private static final int LOGIN_BUTTON = 0;
		
	private ArrayList<OneNote> noteList;
	private SimpleAdapter listToView;
	
	private ConfigurationFile settings;
	private Imaper imapFolder;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.noteList = new ArrayList<OneNote>();
        this.listToView = new SimpleAdapter(
        		getApplicationContext(),
                this.noteList,
                R.layout.note_element,
                new String[]{"title","date"},
                new int[]{R.id.noteTitle, R.id.noteInformation});
        ((ListView)findViewById(R.id.notesList)).setAdapter(this.listToView);
        
        this.settings = new ConfigurationFile(this.getApplicationContext());
        ((ImapNotes)this.getApplicationContext()).SetConfigurationFile(this.settings);
        
        this.imapFolder = new Imaper();
        ((ImapNotes)this.getApplicationContext()).SetImaper(this.imapFolder);
        
        if (this.settings.GetUsername()==null && this.settings.GetPassword()==null){
        	this.AccountLoader();
        
        }
                
    }
    
    public void DeleteItem(View v){
    	this.noteList.remove(this.noteList.size()-1);
    	this.listToView.notifyDataSetChanged();
    	
    }
    
    public void RefreshList(View v){
        for(int i=0; i<new Random().nextInt(); i++){
        	this.noteList.add(new OneNote("Note number "+i,"This is the note number "+i,"just now!"));
        	
        }
    	this.listToView.notifyDataSetChanged();

    }
    
    private void AccountLoader(){
    	Intent goToAccountConfiguration = new Intent(this, AccontConfigurationActivity.class);
        startActivity(goToAccountConfiguration);
        
    }
    
    /***************************************************/
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0, Listactivity.LOGIN_BUTTON, 0, "Account");
        //.setIcon(R.drawable.ic_menu_barcode);
        
        return true;

    }
    
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
        	case Listactivity.LOGIN_BUTTON:
        		this.AccountLoader();
                return true;
                    
        }
        
        return false;
        
    }
    
    /***************************************************/
    
    
    
}