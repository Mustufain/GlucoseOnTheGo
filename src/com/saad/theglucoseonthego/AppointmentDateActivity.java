package com.saad.theglucoseonthego;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AppointmentDateActivity extends Activity {

	ArrayList<String> Date;
	String[] dates;
	int x; 
	TextView tvAppDate;
	int counter = 0;

	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_appointment_date);

		//Show time on Screen
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		String strDate = sdf.format(c.getTime());
		Button btn = (Button) findViewById(R.id.appointmentDateTime);
		btn.setText(strDate);

		Date = new ArrayList<String>(NoteText.dates);

		Collections.sort(Date, new Comparator<String>() {
			SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
			@Override
			public int compare(String o1, String o2) {
				try {
					return f.parse(o1).compareTo(f.parse(o2));
				} catch (ParseException e) {
					throw new IllegalArgumentException(e);
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 0;
			}
		});

		x = Date.size();
		dates = new String[x];
		Date.toArray(dates);
		tvAppDate = (TextView) findViewById(R.id.tvAppDateDay);
		//Change date dynamically from array 
		tvAppDate.setText(dates[counter]);
	}

	public void onclickback(View view) {
		finish();
	}

	public void onclickhome(View view) {
		Intent inte = new Intent(getApplicationContext(), HomeActivity.class);
		startActivity(inte);
		finish();
	}

	public void onclicknext(View view) {
		if(counter<x-1){
			counter++;
			tvAppDate.setText(dates[counter]);
		}

	}

	public void onclickprevious(View view) {
		if(counter>0){
			counter--;
			tvAppDate.setText(dates[counter]);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.appointment_date, menu);
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
