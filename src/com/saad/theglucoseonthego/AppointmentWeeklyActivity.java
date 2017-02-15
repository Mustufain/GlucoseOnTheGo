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
import android.widget.TextView;

public class AppointmentWeeklyActivity extends Activity {
	int counter = 1;
	TextView TextViewMonday, TextViewTuesday, TextViewWednesday,
			TextViewThursday, TextViewFriday, TextViewSaturday, TextViewSunday;

	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_appointment_weekly);
		// Show time on screen
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		String strDate = sdf.format(c.getTime());
		Button btn = (Button) findViewById(R.id.appointmentWeeklyTime);
		btn.setText(strDate);
		init();
		SelectDays();
	}

	private void init() {

		TextViewMonday = (TextView) findViewById(R.id.tvMonday);
		TextViewTuesday = (TextView) findViewById(R.id.tvTuesday);
		TextViewWednesday = (TextView) findViewById(R.id.tvWednesday);
		TextViewThursday = (TextView) findViewById(R.id.tvThursday);
		TextViewFriday = (TextView) findViewById(R.id.tvFriday);
		TextViewSaturday = (TextView) findViewById(R.id.tvSaturday);
		TextViewSunday = (TextView) findViewById(R.id.tvSunday);

	}

	public void onClick_Next(View view) {
		if (counter < 4) {
			counter++;

			SelectDays();
		}

	}

	public void onClick_Previous(View view) {
		if (counter > 1) {
			counter--;
			SelectDays();
		}
	}

	public void SelectDays() {
		if (counter == 1) {

			TextViewMonday.setTextColor(getResources().getColor(R.color.red));
			TextViewTuesday
					.setTextColor(getResources().getColor(R.color.black));
			TextViewWednesday
					.setTextColor(getResources().getColor(R.color.red));
			TextViewThursday.setTextColor(getResources()
					.getColor(R.color.black));

			TextViewFriday.setTextColor(getResources().getColor(R.color.red));
			TextViewSaturday.setTextColor(getResources()
					.getColor(R.color.black));
			TextViewSunday.setTextColor(getResources().getColor(R.color.black));

		} else if (counter == 2) {
			// 2
			TextViewTuesday.setTextColor(getResources().getColor(R.color.red));
			TextViewMonday.setTextColor(getResources().getColor(R.color.black));
			TextViewWednesday.setTextColor(getResources().getColor(
					R.color.black));
			TextViewThursday.setTextColor(getResources()
					.getColor(R.color.black));
			TextViewFriday.setTextColor(getResources().getColor(R.color.black));
			TextViewSaturday.setTextColor(getResources()
					.getColor(R.color.black));
			TextViewSunday.setTextColor(getResources().getColor(R.color.black));
		} else if (counter == 3) {
			// 3
			TextViewMonday.setTextColor(getResources().getColor(R.color.red));
			TextViewFriday.setTextColor(getResources().getColor(R.color.red));

			TextViewTuesday
					.setTextColor(getResources().getColor(R.color.black));
			TextViewWednesday.setTextColor(getResources().getColor(
					R.color.black));
			TextViewThursday.setTextColor(getResources()
					.getColor(R.color.black));

			TextViewSaturday.setTextColor(getResources()
					.getColor(R.color.black));
			TextViewSunday.setTextColor(getResources().getColor(R.color.black));

		} else if (counter == 4) {
			// 4
			TextViewTuesday.setTextColor(getResources().getColor(R.color.red));
			TextViewThursday.setTextColor(getResources().getColor(R.color.red));

			TextViewMonday.setTextColor(getResources().getColor(R.color.black));
			TextViewWednesday.setTextColor(getResources().getColor(
					R.color.black));

			TextViewFriday.setTextColor(getResources().getColor(R.color.black));
			TextViewSaturday.setTextColor(getResources()
					.getColor(R.color.black));
			TextViewSunday.setTextColor(getResources().getColor(R.color.black));

		}
	}

	public void onClick_Back(View view) {
		finish();
	}

	public void onClick_Home(View view) {
		Intent inte = new Intent(getApplicationContext(), HomeActivity.class);
		startActivity(inte);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.appointment_weekly, menu);
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
