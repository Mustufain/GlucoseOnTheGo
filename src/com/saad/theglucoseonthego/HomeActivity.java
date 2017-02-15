package com.saad.theglucoseonthego;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

@SuppressLint("SimpleDateFormat")
public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		// Show time on screen
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		String strDate = sdf.format(c.getTime());
		Button btn = (Button) findViewById(R.id.home_time);
		btn.setText(strDate);

	}

	public void onClick_NewEnty(View view) {
		Intent intent = new Intent(this, NewEntryActivity.class);
		startActivity(intent);
	}

	public void onClick_Diet(View view) {
		Intent intent = new Intent(this, DietActivity.class);
		startActivity(intent);
	}

	public void onClick_Exercise(View view) {
		Intent intent = new Intent(this, SelectExerciseActivity.class);
		startActivity(intent);
	}

	public void onClick_Appointment(View view) {
		Intent intent = new Intent(this, AppointmentActivity.class);
		startActivity(intent);
	}

	public void onClick_Medication(View view) {
		Intent intent = new Intent(this, MedicationActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
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
