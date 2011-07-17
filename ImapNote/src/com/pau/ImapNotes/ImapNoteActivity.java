package com.pau.ImapNotes;

import com.pau.ImapNotes.Utils.BloccoNotes;
import com.pau.ImapNotes.Utils.ConfigurationFile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;


public class ImapNoteActivity extends Activity {
   
	private final static int REFRESH_BUTTON = 0;
    private final static int LOGIN_BUTTON = 1;
    private final static int ADD_NOTE = 2;
	
	private ArrayAdapter<String> notesList;
    private BloccoNotes notesConteiner;
    private ConfigurationFile configurations;
	
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.main);
       
       this.configurations = new ConfigurationFile(this);
       ((ImapNotes)getApplicationContext()).SetDefaultConfigurationFile(this.configurations);
       
       this.notesConteiner = new BloccoNotes(this.configurations);
       ((ImapNotes)getApplicationContext()).SetDefaultBloccoNotes(this.notesConteiner);
       
       this.notesList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.configurations.GetTitles());
       
       ListView listWidget = (ListView)findViewById(R.id.notesListView);
       listWidget.setAdapter(this.notesList);
       
       listWidget.setOnItemClickListener(
    		   new AdapterView.OnItemClickListener() {
                       public void onItemClick(AdapterView parent, View v,int position, long id) {
                    	   Intent goToDetail = new Intent(parent.getContext(), NoteDetailActivity.class);
                    	   goToDetail.putExtra("itemSelected", position);
                    	   startActivity(goToDetail);
                       }
               }
       	);
       
       if(this.configurations.GetUsername()==null){
    	   Intent goToLogin = new Intent(this,UserInfoActivity.class);
			startActivity(goToLogin);
       }
    }
   
    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     * 
     * Methods used to create a contextual menu. Here you'll find the definition
     * of buttons used to refresh the notes title list and to switch to the
     * login activity.
     * 
     */
    
	public boolean onCreateOptionsMenu(Menu menu){
		menu.add(0, ImapNoteActivity.ADD_NOTE, 0, "Add").setIcon(R.drawable.ic_menu_puzzle);
		menu.add(0, ImapNoteActivity.REFRESH_BUTTON, 0, "Refresh").setIcon(R.drawable.ic_menu_wizard);
		menu.add(0, ImapNoteActivity.LOGIN_BUTTON, 0, "Set user info").setIcon(R.drawable.ic_menu_barcode);
		
		return true;

	}
	
	public boolean onOptionsItemSelected (MenuItem item){
		switch (item.getItemId()){
			case ImapNoteActivity.REFRESH_BUTTON:
				if (this.notesConteiner.RefreshTitleList())
					this.notesList.notifyDataSetChanged();
				else
		    		Toast.makeText(this, "Error refreshing notes list!", Toast.LENGTH_LONG).show();	
				return true;
			case ImapNoteActivity.LOGIN_BUTTON:
				Intent goToLogin = new Intent(this,UserInfoActivity.class);
				startActivity(goToLogin);
				return true;
		}

		return false;
		
	}
	
	
}