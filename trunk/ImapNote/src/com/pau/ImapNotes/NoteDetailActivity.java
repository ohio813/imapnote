package com.pau.ImapNotes;

import com.pau.ImapNotes.Utils.BloccoNotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NoteDetailActivity extends Activity{
	
	private TextView noteView;
	
	private BloccoNotes notesConteiner;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notedetail);
        
        this.noteView = (TextView)findViewById(R.id.noteBodyWidget);
        
        this.notesConteiner = ((ImapNotes)getApplicationContext()).GetDefaultBloccoNotes();

        
        Intent myIntent = getIntent();        
        this.noteView.setText(this.notesConteiner.GetNote(myIntent.getIntExtra("itemSelected", -1)));
	
	}
       

}
