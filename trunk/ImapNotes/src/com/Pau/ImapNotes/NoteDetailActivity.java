package com.Pau.ImapNotes;

import com.Pau.ImapNotes.Miscs.OneNote;

import android.app.Activity;
import android.graphics.Color;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.os.Bundle;

public class NoteDetailActivity extends Activity{
	
	private OneNote currentNote;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_detail);
        
        //this.currentNote = getIntent().getIntExtra("selection", -1);
        this.currentNote = ((ImapNotes)this.getApplicationContext()).GetNotesList().get(getIntent().getIntExtra("selection", -1));

        String plainText = Html.fromHtml(this.currentNote.GetBody()).toString();
       ((EditText)findViewById(R.id.bodyView)).setText(plainText);
       this.ResetColors();
       
        
	}
	
	public void BeginEditMode(View v){
		((EditText)findViewById(R.id.bodyView)).setEnabled(true);

	}
	
	private void ResetColors(){
		((EditText)findViewById(R.id.bodyView)).setBackgroundColor(Color.TRANSPARENT);
	    ((EditText)findViewById(R.id.bodyView)).setTextColor(Color.BLACK);
		
	}

}
