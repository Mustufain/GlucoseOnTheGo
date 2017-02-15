package com.saad.theglucoseonthego;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.saad.datasource.NoteDataSource;
import com.saad.model.Note;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("SimpleDateFormat")
public class RepeatPresActivity extends Activity {
    EditText et;
    public static ArrayList<Note> get_list = new ArrayList<Note>();
    public static ArrayList<Note> array_list = new ArrayList<Note>();
    Note [] arr;
    NoteDataSource mEntryDataSource;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_repeat_pres);
		et = (EditText)findViewById(R.id.number);
		// Show time on screen
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		String strDate = sdf.format(c.getTime());
		Button btn = (Button) findViewById(R.id.repeatPresTime);
		btn.setText(strDate);
		
		et.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				et.setText("");
			}
		});
	}

	public void sendEmail(View view) {

		String[] TO = { "smith@nhs.org.uk" };
		// String[] CC = {"saadsheikh.official@gmail.com"};
		Intent emailIntent = new Intent(Intent.ACTION_SEND);
		emailIntent.setData(Uri.parse("mailto:"));
		emailIntent.setType("text/plain");
		emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
		// emailIntent.putExtra(Intent.EXTRA_CC, CC);
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
		emailIntent.putExtra(Intent.EXTRA_TEXT, "");

		try {
			startActivity(Intent.createChooser(emailIntent, "Send mail..."));
			finish();
			Log.i("Finished sending email...", "");
		} catch (android.content.ActivityNotFoundException ex) {
			Toast.makeText(getApplicationContext(),
					"There is no email client installed.", Toast.LENGTH_SHORT)
					.show();
		}
	}
	
	

	public void onClick_CallGP(View view) {
		Intent callIntent = new Intent(Intent.ACTION_CALL);
		
		callIntent.setData(Uri.parse("tel:" + et.getText().toString()));
		startActivity(callIntent);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.repeat_pres, menu);
		return true;
	}

	public void onClick_Back(View view) {
		finish();
	}

	public void onClick_Home(View view) {
		Intent inte = new Intent(getApplicationContext(),HomeActivity.class);
		startActivity(inte);
		finish();
		
	}
	public void onClick_Save(View view)
	{  
		if(!NoteText.GP_Tel_No.equals(""))
		{
		NoteText.GP_Tel_No = et.getText().toString().trim();
		Note item = new Note();
		item.setNumber(NoteText.GP_Tel_No);
	    mEntryDataSource = new NoteDataSource(RepeatPresActivity.this);
	    //get_list = mEntryDataSource.getList();
	    mEntryDataSource.insert(item);
		array_list.add(item);
		NoteText.list_num.add(item);
		NoteText.x = NoteText.list_num.size();
		arr = new Note[NoteText.list_num.size()];
		NoteText.list_num.toArray(arr);
		NoteText.note = null;
		Toast t = Toast.makeText(getApplicationContext(), "Successfully recorded", Toast.LENGTH_LONG);
		t.show();
		}
		else
		{
			Toast t = Toast.makeText(getApplicationContext(), "Please fill all the required fields", Toast.LENGTH_LONG);
			t.show();
		
			
		}
       
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
