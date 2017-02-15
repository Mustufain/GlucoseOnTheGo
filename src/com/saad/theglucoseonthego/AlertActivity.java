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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AlertActivity extends Activity {
	public static String Status;
	TextView tvstatus;
	EditText et1,et2;
	public static ArrayList<Note> get_list = new ArrayList<Note>();
    public static ArrayList<Note> array_list = new ArrayList<Note>();
    Note [] arr;
    NoteDataSource mEntryDataSource;

	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alert);
		et1 = (EditText)findViewById(R.id.Nurse); //Call Nurse
		et2 = (EditText)findViewById(R.id.GP);   //Call GP
		tvstatus = (TextView) findViewById(R.id.tvStatus);
		tvstatus.setText(Status);
		//Show time on screen
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		String strDate = sdf.format(c.getTime());
		Button btn = (Button) findViewById(R.id.alertTime);
		btn.setText(strDate);
		et1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				et1.setText("");	
			}
		});
		et2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				et2.setText("");	
			}
		});
	}


	public void onClick_CallGP(View view) {
		Intent callIntent = new Intent(Intent.ACTION_CALL);
		callIntent.setData(Uri.parse("tel:" + et2.getText().toString()));
		startActivity(callIntent);
	}

	public void onClick_CallNurse(View view) {
		Intent callIntent = new Intent(Intent.ACTION_CALL);
		callIntent.setData(Uri.parse("tel:" + et1.getText().toString()));
		startActivity(callIntent);
	}

	public void onClick_Back(View view) {
		finish();
	}

	public void onClick_Home(View view) {
		Intent inte = new Intent(getApplicationContext(), HomeActivity.class);
		startActivity(inte);
		finish();
	}

	public void onClick_Save(View view)
	{   
		if(!NoteText.GP_Tel_No.equals(""))
		{
		NoteText.GP_Tel_No = et2.getText().toString();
		NoteText.Nurse_Num=et1.getText().toString();
		Note item = new Note();
		item.setNumber(NoteText.GP_Tel_No);
		item.setNurse_num(NoteText.Nurse_Num);
	    mEntryDataSource = new NoteDataSource(AlertActivity.this);
	    //get_list = mEntryDataSource.getList();
	    mEntryDataSource.insert(item);
		array_list.add(item);
		NoteText.alert_activity.add(item);
		NoteText.x = NoteText.alert_activity.size();
		arr = new Note[NoteText.alert_activity.size()];
		NoteText.alert_activity.toArray(arr);
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alert, menu);
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
