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

public class HealthPlannerActivity extends Activity {

	EditText etBP, etFC, etEC, etSS, etAS, etFP, etPS, etCK;
	String [] etBParr;
	String [] etFCarr;
	String [] etECarr;
	String [] etSSarr;
	String [] etASarr;
	String [] etFParr;
	String [] etPSarr;
	String [] etCKarr;
	
	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_health_planner);
		etBP = (EditText) findViewById(R.id.BP);
		etFC = (EditText) findViewById(R.id.FC);
		etEC = (EditText) findViewById(R.id.EC);
		etSS = (EditText) findViewById(R.id.SS);
		etAS = (EditText) findViewById(R.id.AS);
		etFP = (EditText) findViewById(R.id.FP);
		etPS = (EditText) findViewById(R.id.PS);
		etCK = (EditText) findViewById(R.id.CK);

		NoteText.z = NoteText.etBP.size();
		etBParr = new String[NoteText.etBP.size()];
		NoteText.etBP.toArray(etBParr);
		etFCarr = new String[NoteText.etFC.size()];
		NoteText.etFC.toArray(etFCarr);
		etECarr = new String[NoteText.etEC.size()];
		NoteText.etEC.toArray(etECarr);
		etSSarr = new String[NoteText.etSS.size()];
		NoteText.etSS.toArray(etSSarr);
		etASarr= new String[NoteText.etAS.size()];
		NoteText.etAS.toArray(etASarr);
		etFParr = new String[NoteText.etFP.size()];
		NoteText.etFP.toArray(etFParr);
		etPSarr= new String[NoteText.etPS.size()];
		NoteText.etPS.toArray(etPSarr);
		etCKarr = new String[NoteText.etCK.size()];
		NoteText.etCK.toArray(etCKarr);

		// Show time on screen
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		String strDate = sdf.format(c.getTime());
		Button btn = (Button) findViewById(R.id.healthPlannerTime);
		btn.setText(strDate);
	}

	public void onClick_Back(View view) {
		finish();
	}

	public void onClick_Home(View view) {
		Intent inte = new Intent(getApplicationContext(), HomeActivity.class);
		startActivity(inte);
		finish();
	}

	public void onClick_Daily(View view) {
		Intent daily = new Intent(this, AppointmentDateActivity.class);
		startActivity(daily);
	}

	public void onClick_Weekly(View view) {
		Intent weekly = new Intent(this, AppointmentWeeklyActivity.class);
		startActivity(weekly);
	}

	public void onClick_Monthly(View view) {

		Intent monthly = new Intent(this, AppointmentMonthlyActivity.class);
		startActivity(monthly);
	}

	public void onClick_Save(View view) {
		if(etBP.getText().toString().trim()==""||etSS.getText().toString().trim()==""||etCK.getText().toString().trim()==""){
			Toast.makeText(getApplicationContext(), 
					"Please fill all the fields", Toast.LENGTH_LONG).show();

		}else{
		NoteText.etBP.add(etBP.getText().toString().trim());
		NoteText.etFC.add(etFC.getText().toString().trim());
		NoteText.etEC.add(etEC.getText().toString().trim());
		NoteText.etSS.add(etSS.getText().toString().trim());
		NoteText.etAS.add(etAS.getText().toString().trim());
		NoteText.etFP.add(etFP.getText().toString().trim());
		NoteText.etPS.add(etPS.getText().toString().trim());
		NoteText.etCK.add(etCK.getText().toString().trim());

		NoteText.dates.add(etBP.getText().toString().trim());
		NoteText.dates.add(etFC.getText().toString().trim());
		NoteText.dates.add(etEC.getText().toString().trim());
		NoteText.dates.add(etSS.getText().toString().trim());
		NoteText.dates.add(etAS.getText().toString().trim());
		NoteText.dates.add(etFP.getText().toString().trim());
		NoteText.dates.add(etPS.getText().toString().trim());
		NoteText.dates.add(etCK.getText().toString().trim());
		
		Toast.makeText(getApplicationContext(), 
				"Record has been saved successfully!", Toast.LENGTH_LONG).show();
		NoteText.z = NoteText.etBP.size();
		etBParr = new String[NoteText.etBP.size()];
		NoteText.etBP.toArray(etBParr);
		etFCarr = new String[NoteText.etFC.size()];
		NoteText.etFC.toArray(etFCarr);
		etECarr = new String[NoteText.etEC.size()];
		NoteText.etEC.toArray(etECarr);
		etSSarr = new String[NoteText.etSS.size()];
		NoteText.etSS.toArray(etSSarr);
		etASarr= new String[NoteText.etAS.size()];
		NoteText.etAS.toArray(etASarr);
		etFParr = new String[NoteText.etFP.size()];
		NoteText.etFP.toArray(etFParr);
		etPSarr= new String[NoteText.etPS.size()];
		NoteText.etPS.toArray(etPSarr);
		etCKarr = new String[NoteText.etCK.size()];
		NoteText.etCK.toArray(etCKarr);

		}
	}

	public void onClick_Previous(View view){

		if(NoteText.v>0){
			NoteText.v--;
			etBP.setText("" + etBParr[NoteText.v]);
			etFC.setText("" + etFCarr[NoteText.v]);
			etEC.setText("" + etECarr[NoteText.v]);
			etSS.setText("" + etSSarr[NoteText.v]);
			etAS.setText("" + etASarr[NoteText.v]);
			etFP.setText("" + etFParr[NoteText.v]);	
			etPS.setText("" + etPSarr[NoteText.v]);
			etCK.setText("" + etCKarr[NoteText.v]);	
		}else{
			Toast.makeText(getApplicationContext(), 
					"No previous records to show", Toast.LENGTH_LONG).show();	
		}
	}

	public void onClick_Next(View view){

		if(NoteText.v < etBParr.length-1){
			NoteText.v++;
			etBP.setText("" + etBParr[NoteText.v]);
			etFC.setText("" + etFCarr[NoteText.v]);
			etEC.setText("" + etECarr[NoteText.v]);
			etSS.setText("" + etSSarr[NoteText.v]);
			etAS.setText("" + etASarr[NoteText.v]);
			etFP.setText("" + etFParr[NoteText.v]);
			etPS.setText("" + etPSarr[NoteText.v]);
			etCK.setText("" + etCKarr[NoteText.v]);
		}
		else{
			// Empty all fields
			etBP.setText("");
			etFC.setText("");
			etEC.setText("");
			etSS.setText("");
			etAS.setText("");
			etFP.setText("");
			etPS.setText("");
			etCK.setText("");
			
			NoteText.z = NoteText.etBP.size();
			etBParr = new String[NoteText.etBP.size()];
			NoteText.etBP.toArray(etBParr);
			etFCarr = new String[NoteText.etFC.size()];
			NoteText.etFC.toArray(etFCarr);
			etECarr = new String[NoteText.etEC.size()];
			NoteText.etEC.toArray(etECarr);
			etSSarr = new String[NoteText.etSS.size()];
			NoteText.etSS.toArray(etSSarr);
			etASarr= new String[NoteText.etAS.size()];
			NoteText.etAS.toArray(etASarr);
			etFParr = new String[NoteText.etFP.size()];
			NoteText.etFP.toArray(etFParr);
			etPSarr= new String[NoteText.etPS.size()];
			NoteText.etPS.toArray(etPSarr);
			etCKarr = new String[NoteText.etCK.size()];
			NoteText.etCK.toArray(etCKarr);

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.health_planner, menu);
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
