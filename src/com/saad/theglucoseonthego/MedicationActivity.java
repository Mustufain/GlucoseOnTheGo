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
import android.widget.EditText;
import android.widget.Toast;

public class MedicationActivity extends Activity {
	public static String weight;

	EditText etWeight, etHba;

	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medication);
		// Show time on screen
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		String strDate = sdf.format(c.getTime());
		Button btn = (Button) findViewById(R.id.medicationTime);
		btn.setText(strDate);
		etHba = (EditText) findViewById(R.id.etMedHba);
		etWeight = (EditText) findViewById(R.id.etMedWeight);

	}

	public void onClick_Back(View view) {
		finish();
	}

	public void onClick_Home(View view) {
		Intent inte = new Intent(getApplicationContext(), HomeActivity.class);
		startActivity(inte);
		finish();
	}

	public void onClick_Go(View view) {

		weight = etWeight.getText().toString().trim();
		String HBA = etHba.getText().toString().trim();
		if (!HBA.equals("")) {
			int hba = Integer.parseInt(HBA);
			if (hba >= 9) {
				// High Alert

				Intent inte = new Intent(getApplicationContext(),
						AlertActivity.class);
				AlertActivity.Status = "HIGH";
				startActivity(inte);

			} else if (hba > 3 || hba < 9) {
				// Repeat Pres
				Intent inten = new Intent(getApplicationContext(),
						RepeatPresActivity.class);
				startActivity(inten);
			} else if (hba <= 3) {
				// Low Alert
				Intent inte = new Intent(getApplicationContext(),
						AlertActivity.class);
				AlertActivity.Status = "LOW";
				startActivity(inte);
			}
		} else {
			Toast.makeText(getApplicationContext(),
					"Please fill all the field", Toast.LENGTH_LONG).show();

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.medication, menu);
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
