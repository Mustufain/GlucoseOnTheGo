package com.saad.theglucoseonthego;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.saad.datasource.NoteDataSource;
import com.saad.model.Note;

@SuppressLint("SimpleDateFormat")
public class NoteActivity extends Activity {

	int x = 0;
	SQLiteOpenHelper db;
	SQLiteDatabase sqlDb;
	String ToayDate;
	EditText mEditTextAddNote;
	SQLiteDatabase mydb;
	TextView tvShowNote;
	ArrayList<Note> array_list;
	ArrayList<String> dates;
	String[]  dates_filter;
	NoteDataSource mNoteDataSource;
	ImageButton previous, next;
	Integer pointer = 0;
	Note [] arr;
	StringBuffer s = new StringBuffer();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note);
		mNoteDataSource = new NoteDataSource(NoteActivity.this);
		mEditTextAddNote = (EditText) findViewById(R.id.etAddNote);
		tvShowNote = (TextView) findViewById(R.id.tvShowNote);
		tvShowNote.setText(NoteText.note);
		previous = (ImageButton) findViewById(R.id.Previous);
		arr = new Note[NoteText.list.size()];
		NoteText.list.toArray(arr);
		x = NoteText.list.size();
		previous.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				if(x>0){
					x--;
					String NoteName = "" + arr[x].getNote();
					if (!NoteName.equals("")) {
						NoteText.note = NoteName.toString();
						mEditTextAddNote.setText("");
						tvShowNote.setText(NoteText.note);
					}
				}

			}
		});
	/*	next = (ImageButton) findViewById(R.id.Next);
		next.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				if(x < NoteText.list.size()-1){
					x++;
					String NoteName = "" + arr[x].getNote();
					if (!NoteName.equals("")) {
						NoteText.note = NoteName.toString();
						mEditTextAddNote.setText("");
						tvShowNote.setText(NoteText.note);
					}
				}
				else{
					mEditTextAddNote.setText("");
					tvShowNote.setText("");
				}
			}
		});*/

		// Show time on screen
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = sdf.format(c.getTime());
		ToayDate = sdfDate.format(c.getTime());

		Button btn = (Button) findViewById(R.id.noteTime);
		btn.setText(strDate);
	}

	public void onClick_Back(View view) {
		finish();
	}

	public void onClick_AddNote(View view) {

		String NoteName = mEditTextAddNote.getText().toString().trim();
		s.append("*" + NoteName + "\n");
		if (!s.equals("")) {
			NoteText.note = s.toString();
			mEditTextAddNote.setText("");
			tvShowNote.setText(NoteText.note);
		} else {
			Toast.makeText(getApplicationContext(), "Please Add Note",
					Toast.LENGTH_LONG).show();

		}
	}

	public void onClick_NewEnty(View view){

	}

	public void onClick_Home(View view) {
		Intent inte = new Intent(getApplicationContext(),HomeActivity.class);
		startActivity(inte);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.note, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
