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
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class DietActivity extends Activity {

	RadioGroup radioGroup;
	EditText mEditTextBreakfast, mEditTextLunch, mEditTextSnacks,
	mEditTextDinner,  EditTextBreakfast, EditTextLunch, EditTextSnacks,
	EditTextDinner;
	TextView tvTotalCals, tvStatus, tvExtraCals;
	LinearLayout llDietStatus;

	int TotalCalories = 0;
	int GraterCalories;
	int status = 1;
	String [] breakf;
	String [] breakfcal;
	String [] lunch;
	String [] lunchcal;
	String [] snack;
	String [] snackcal;
	String [] dinner;
	String [] dinnercal;


	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_diet);
		// Show time on screen

		init();
		NoteText.y = NoteText.breakfast.size();
		breakf = new String[NoteText.breakfast.size()];
		NoteText.breakfast.toArray(breakf);
		breakfcal = new String[NoteText.breakfastcal.size()];
		NoteText.breakfastcal.toArray(breakfcal);
		lunch = new String[NoteText.lunch.size()];
		NoteText.lunch.toArray(lunch);
		lunchcal = new String[NoteText.lunchcal.size()];
		NoteText.lunchcal.toArray(lunchcal);
		snack = new String[NoteText.snack.size()];
		NoteText.snack.toArray(snack);
		snackcal = new String[NoteText.snackcal.size()];
		NoteText.snackcal.toArray(snackcal);
		dinner = new String[NoteText.dinner.size()];
		NoteText.dinner.toArray(dinner);
		dinnercal = new String[NoteText.dinnercal.size()];
		NoteText.dinnercal.toArray(dinnercal);

		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		String strDate = sdf.format(c.getTime());
		Button btn = (Button) findViewById(R.id.dietTime);
		btn.setText(strDate);

		radioGroup = (RadioGroup) findViewById(R.id.radioGroupMaleFemale);

		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				// find which radio button is selected

				if (checkedId == R.id.radioButtonMale) {

					Toast.makeText(getApplicationContext(), "choice: Male",Toast.LENGTH_SHORT).show();
					status = 1;

				} else if (checkedId == R.id.radioButtonFemale) {

					Toast.makeText(getApplicationContext(), "choice: Female",Toast.LENGTH_SHORT).show();
					status = 2;
				}
			}
		});

	}

	public void init() {
		EditTextBreakfast = (EditText) findViewById(R.id.Breakfast);
		EditTextLunch = (EditText) findViewById(R.id.Lunch);
		EditTextSnacks = (EditText) findViewById(R.id.Snacks);
		EditTextDinner = (EditText) findViewById(R.id.Dinner);
		mEditTextBreakfast = (EditText) findViewById(R.id.etBreakfast);
		mEditTextLunch = (EditText) findViewById(R.id.etLunch);
		mEditTextSnacks = (EditText) findViewById(R.id.etSnacks);
		mEditTextDinner = (EditText) findViewById(R.id.etDinner);
		tvTotalCals = (TextView) findViewById(R.id.tvTotalCalories);
		tvExtraCals = (TextView) findViewById(R.id.tvExtraCalories);
		tvStatus = (TextView) findViewById(R.id.tvDietStatus);
		llDietStatus = (LinearLayout) findViewById(R.id.llDietStatus);
		llDietStatus.setVisibility(View.GONE);

	}

	public void onClick_Total(View view) {

		TotalCalories = 0;
		String brkfst = mEditTextBreakfast.getText().toString().trim();
		String lnch = mEditTextLunch.getText().toString().trim();
		String snks = mEditTextSnacks.getText().toString().trim();
		String dnr = mEditTextDinner.getText().toString().trim();
		if (!brkfst.equals("") && !lnch.equals("") && !snks.equals("")
				&& !dnr.equals("")) {
			int Breakfast = Integer.parseInt(brkfst);
			int Lunch = Integer.parseInt(lnch);
			int Snacks = Integer.parseInt(snks);
			int Dinner = Integer.parseInt(dnr);

			TotalCalories = Breakfast + Lunch + Snacks + Dinner;
			if (TotalCalories > 0) {
				tvTotalCals.setText("Total Calories = " + TotalCalories);
				if (status == 1) {
					// male selected
					if (TotalCalories > 2500) {
						// calories grater then 2500
						GraterCalories = TotalCalories - 2500;
						llDietStatus.setVisibility(View.VISIBLE);
						tvExtraCals.setText("+ " + GraterCalories + " cals Exercise");
						tvExtraCals.setVisibility(View.VISIBLE);
						//tvStatus.setVisibility(View.GONE);

					} else {
						// set text well done
						llDietStatus.setVisibility(View.VISIBLE);
						tvStatus.setText("Well Done");
						//tvExtraCals.setVisibility(View.GONE);
					}

				} else {
					// female selected
					if (TotalCalories > 1800) {
						// caloried grater then 1800
						GraterCalories = TotalCalories - 1800;
						llDietStatus.setVisibility(View.VISIBLE);
						tvExtraCals.setText("+ " + GraterCalories + " cals Exercise");
						tvExtraCals.setVisibility(View.VISIBLE);
						//tvStatus.setVisibility(View.GONE);

					} else {
						// set text well done
						llDietStatus.setVisibility(View.VISIBLE);
						tvStatus.setText("Well Done");
						//tvExtraCals.setVisibility(View.GONE);
					}

				}
			} else {
				Toast.makeText(getApplicationContext(),
						"Please enter Calories", Toast.LENGTH_LONG).show();

			}
		} else {
			Toast.makeText(getApplicationContext(), "Please enter Calories",
					Toast.LENGTH_LONG).show();
		}
	}

	public void onClick_Save(View view) {
		NoteText.breakfast.add(EditTextBreakfast.getText().toString().trim());
		NoteText.breakfastcal.add(mEditTextBreakfast.getText().toString().trim());
		NoteText.lunch.add(EditTextLunch.getText().toString().trim());
		NoteText.lunchcal.add(mEditTextLunch.getText().toString().trim());
		NoteText.snack.add(EditTextSnacks.getText().toString().trim());
		NoteText.snackcal.add(mEditTextSnacks.getText().toString().trim());
		NoteText.dinner.add(EditTextDinner.getText().toString().trim());
		NoteText.dinnercal.add(mEditTextDinner.getText().toString().trim());
	}

	public void onClick_Home(View view) {
		Intent inte = new Intent(getApplicationContext(),HomeActivity.class);
		startActivity(inte);
		finish();
	}

	public void onClick_Previous(View view){

		if(NoteText.y>0){
			NoteText.y--;
			EditTextBreakfast.setText("" + breakf[NoteText.y]);
			mEditTextBreakfast.setText("" + breakfcal[NoteText.y]);
			EditTextLunch.setText("" + lunch[NoteText.y]);
			mEditTextLunch.setText("" + lunchcal[NoteText.y]);
			EditTextSnacks.setText("" + snack[NoteText.y]);
			mEditTextSnacks.setText("" + snackcal[NoteText.y]);
			EditTextDinner.setText("" + dinner[NoteText.y]);
			mEditTextDinner.setText("" + dinnercal[NoteText.y]);	
		}
	}


	public void onClick_Next(View view){

		if(NoteText.y < breakf.length-1){
			NoteText.y++;
			EditTextBreakfast.setText("" + breakf[NoteText.y]);
			mEditTextBreakfast.setText("" + breakfcal[NoteText.y]);
			EditTextLunch.setText("" + lunch[NoteText.y]);
			mEditTextLunch.setText("" + lunchcal[NoteText.y]);
			EditTextSnacks.setText("" + snack[NoteText.y]);
			mEditTextSnacks.setText("" + snackcal[NoteText.y]);
			EditTextDinner.setText("" + dinner[NoteText.y]);
			mEditTextDinner.setText("" + dinnercal[NoteText.y]);		
		}
		else{
			// Empty all fields
			EditTextBreakfast.setText("");
			mEditTextBreakfast.setText("");
			EditTextLunch.setText("");
			mEditTextLunch.setText("");
			EditTextSnacks.setText("");
			mEditTextSnacks.setText("");
			EditTextDinner.setText("");
			mEditTextDinner.setText("");	
		}
	}

	public void onClick_Exercise(View view) {
		Intent intent = new Intent(this, SelectExerciseActivity.class);
		ExerciseActivity.CaloriesRequired = GraterCalories;
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.diet, menu);
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
