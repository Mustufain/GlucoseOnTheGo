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

public class AppointmentActivity extends Activity {

	EditText etDOB, etGender, etSmoker, etPregnant, etHyper, etHypo;
	String [] etDOBarr;
	String [] etGenderarr;
	String [] etSmokerarr;
	String [] etPregnantarr;
	String [] etHyperarr;
	String [] etHypoarr;

	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_appointment);
		etHyper = (EditText) findViewById(R.id.etAppHyper);
		etHypo = (EditText) findViewById(R.id.etAppHypo);
		etGender = (EditText) findViewById(R.id.etGender);
		etDOB = (EditText) findViewById(R.id.etDOB);
		etSmoker = (EditText) findViewById(R.id.etSmoker);
		etPregnant = (EditText) findViewById(R.id.etPregnant);

		NoteText.z = NoteText.etDOBarr.size();
		etDOBarr = new String[NoteText.etDOBarr.size()];
		NoteText.etDOBarr.toArray(etDOBarr);
		etGenderarr = new String[NoteText.etGenderarr.size()];
		NoteText.etGenderarr.toArray(etGenderarr);
		etSmokerarr = new String[NoteText.etSmokerarr.size()];
		NoteText.etSmokerarr.toArray(etSmokerarr);
		etPregnantarr = new String[NoteText.etPregnantarr.size()];
		NoteText.etPregnantarr.toArray(etPregnantarr);
		etHyperarr = new String[NoteText.etHyperarr.size()];
		NoteText.etHyperarr.toArray(etHyperarr);
		etHypoarr = new String[NoteText.etHypoarr.size()];
		NoteText.etHypoarr.toArray(etHypoarr);


		// Show time on screen
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		String strDate = sdf.format(c.getTime());
		Button btn = (Button) findViewById(R.id.appointmentTime);
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

	public void onClick_AppointmentDate(View view) {
		Intent inte = new Intent(getApplicationContext(),
				AppointmentDateActivity.class);
		startActivity(inte);
	}

	public void onClick_Save(View view) {
		if(etHypo.getText().toString().trim()==""||etHyper.getText().toString().trim()==""){
			Toast.makeText(getApplicationContext(), 
					"Please fill all the fields", Toast.LENGTH_LONG).show();

		}else{
			NoteText.etDOBarr.add(etDOB.getText().toString().trim());
			NoteText.etGenderarr.add(etGender.getText().toString().trim());
			NoteText.etSmokerarr.add(etSmoker.getText().toString().trim());
			NoteText.etPregnantarr.add(etPregnant.getText().toString().trim());
			NoteText.etHyperarr.add(etHyper.getText().toString().trim());
			NoteText.etHypoarr.add(etHypo.getText().toString().trim());

			Toast.makeText(getApplicationContext(), 
					"Record has been saved successfully!", Toast.LENGTH_LONG).show();
			
			NoteText.z = NoteText.etDOBarr.size();
			etDOBarr = new String[NoteText.etDOBarr.size()];
			NoteText.etDOBarr.toArray(etDOBarr);
			etGenderarr = new String[NoteText.etGenderarr.size()];
			NoteText.etGenderarr.toArray(etGenderarr);
			etSmokerarr = new String[NoteText.etSmokerarr.size()];
			NoteText.etSmokerarr.toArray(etSmokerarr);
			etPregnantarr = new String[NoteText.etPregnantarr.size()];
			NoteText.etPregnantarr.toArray(etPregnantarr);
			etHyperarr = new String[NoteText.etHyperarr.size()];
			NoteText.etHyperarr.toArray(etHyperarr);
			etHypoarr = new String[NoteText.etHypoarr.size()];
			NoteText.etHypoarr.toArray(etHypoarr);
		}
	}

	public void onClick_Previous(View view){

		if(NoteText.z>0){
			NoteText.z--;
			etDOB.setText("" + etDOBarr[NoteText.z]);
			etGender.setText("" + etGenderarr[NoteText.z]);
			etSmoker.setText("" + etSmokerarr[NoteText.z]);
			etPregnant.setText("" + etPregnantarr[NoteText.z]);
			etHyper.setText("" + etHyperarr[NoteText.z]);
			etHypo.setText("" + etHypoarr[NoteText.z]);	
		}
		else{
			Toast.makeText(getApplicationContext(), 
					"No previous records to show", Toast.LENGTH_LONG).show();	
		}
	}

	public void onClick_Next(View view){
		
		NoteText.z = NoteText.etDOBarr.size();
		
		if(NoteText.z < etDOBarr.length-1){
			NoteText.z++;
			etDOB.setText("" + etDOBarr[NoteText.z]);
			etGender.setText("" + etGenderarr[NoteText.z]);
			etSmoker.setText("" + etSmokerarr[NoteText.z]);
			etPregnant.setText("" + etPregnantarr[NoteText.z]);
			etHyper.setText("" + etHyperarr[NoteText.z]);
			etHypo.setText("" + etHypoarr[NoteText.z]);		
		}
		else{
			// Empty all fields
			etDOB.setText("");
			etGender.setText("");
			etSmoker.setText("");
			etPregnant.setText("");
			etHyper.setText("");
			etHypo.setText("");
			
			NoteText.z = NoteText.etDOBarr.size();
			etDOBarr = new String[NoteText.etDOBarr.size()];
			NoteText.etDOBarr.toArray(etDOBarr);
			etGenderarr = new String[NoteText.etGenderarr.size()];
			NoteText.etGenderarr.toArray(etGenderarr);
			etSmokerarr = new String[NoteText.etSmokerarr.size()];
			NoteText.etSmokerarr.toArray(etSmokerarr);
			etPregnantarr = new String[NoteText.etPregnantarr.size()];
			NoteText.etPregnantarr.toArray(etPregnantarr);
			etHyperarr = new String[NoteText.etHyperarr.size()];
			NoteText.etHyperarr.toArray(etHyperarr);
			etHypoarr = new String[NoteText.etHypoarr.size()];
			NoteText.etHypoarr.toArray(etHypoarr);
		}
	}

	public void onClick_HealthPlanner(View view) {

		if(etHypo.getText().toString().trim()==null||etHyper.getText().toString().trim()==null){
			Toast.makeText(getApplicationContext(), 
					"Please fill all the fields", Toast.LENGTH_LONG).show();

		}else{
			int hypo = Integer.parseInt(etHypo.getText().toString().trim());
			int hyper = Integer.parseInt(etHyper.getText().toString().trim());
			if(hyper>3 || hypo >3){
				Intent inte = new Intent(getApplicationContext(),
						AlertActivity.class);
				AlertActivity.Status="HIGH";
				startActivity(inte);

			}else {
				Intent inte = new Intent(getApplicationContext(),
						HealthPlannerActivity.class);
				startActivity(inte);

			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.appointment, menu);
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
