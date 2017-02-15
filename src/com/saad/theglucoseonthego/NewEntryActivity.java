package com.saad.theglucoseonthego;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.saad.datasource.NoteDataSource;
import com.saad.model.Note;

public class NewEntryActivity extends Activity {

	public static ArrayList<Note> array_list = new ArrayList<Note>();
	public static ArrayList<Note> get_list = new ArrayList<Note>();
	EditText EditTextBasalInsulin, EditTextBloodGlucose, EditTextBolus,
	EditTextCaloried, EditTextCarbohydrates, EditTextKetones,
	EditTextWeight;
	LinearLayout llsad, llhappy;
	String ToayDate;
	TextView feel;
	TextView note;
	StringBuilder sb = new StringBuilder();
	ImageView feeling;
	NoteDataSource mEntryDataSource;
	Note [] arr;

	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_entry);

		init();

		arr = new Note[NoteText.list.size()];
		NoteText.list.toArray(arr);

		mEntryDataSource = new NoteDataSource(NewEntryActivity.this);

		get_list = mEntryDataSource.getList();
		NoteText.x = NoteText.list.size();

		Intent iin = getIntent();
		Bundle b = iin.getExtras();
		if(b!=null)
		{
			NoteText.select = (Integer) b.get("selection");

		}
		setImage(NoteText.select);

		// Show time on screen
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = sdf.format(c.getTime());
		ToayDate = sdfDate.format(c.getTime());
		Button btn = (Button) findViewById(R.id.newEntryTime);
		btn.setText(strDate);

	}

	private void init() {
		llhappy = (LinearLayout) findViewById(R.id.llSmile);
		EditTextBasalInsulin = (EditText) findViewById(R.id.etBasalInsulin);
		EditTextBloodGlucose = (EditText) findViewById(R.id.etBloodGlucose);
		EditTextBolus = (EditText) findViewById(R.id.etBolus);
		EditTextCaloried = (EditText) findViewById(R.id.etCaloried);
		EditTextCarbohydrates = (EditText) findViewById(R.id.etCarbohydrates);
		EditTextKetones = (EditText) findViewById(R.id.etKetones);
		EditTextWeight = (EditText) findViewById(R.id.etWeight);
		feeling = (ImageView) findViewById(R.id.imageView1);

		EditTextBasalInsulin.setText(NoteText.BasalInsulin);
		EditTextBloodGlucose.setText(NoteText.BloodGlucose);
		EditTextBolus.setText(NoteText.Bolus);
		EditTextCaloried.setText(NoteText.Caloried);
		EditTextCarbohydrates.setText(NoteText.Carbohydrates);
		EditTextKetones.setText(NoteText.Ketones);
		EditTextWeight.setText(NoteText.Weight);

		setImage(NoteText.select);

		feel = (TextView)findViewById(R.id.feeling);	
		feel.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				NoteText.BasalInsulin = EditTextBasalInsulin.getText().toString().trim();
				NoteText.BloodGlucose = EditTextBloodGlucose.getText().toString().trim();
				NoteText.Bolus = EditTextBolus.getText().toString().trim();
				NoteText.Caloried = EditTextCaloried.getText().toString().trim();
				NoteText.Carbohydrates = EditTextCarbohydrates.getText().toString().trim();
				NoteText.Ketones = EditTextKetones.getText().toString().trim();
				NoteText.Weight = EditTextWeight.getText().toString().trim();
				Intent intent = new Intent(getApplicationContext(), FeelingActivity.class);
				startActivity(intent);
			}
		});
		note = (TextView)findViewById(R.id.note);	
		note.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				NoteText.BasalInsulin = EditTextBasalInsulin.getText().toString().trim();
				NoteText.BloodGlucose = EditTextBloodGlucose.getText().toString().trim();
				NoteText.Bolus = EditTextBolus.getText().toString().trim();
				NoteText.Caloried = EditTextCaloried.getText().toString().trim();
				NoteText.Carbohydrates = EditTextCarbohydrates.getText().toString().trim();
				NoteText.Ketones = EditTextKetones.getText().toString().trim();
				NoteText.Weight = EditTextWeight.getText().toString().trim();
				Intent inte = new Intent(getApplicationContext(), NoteActivity.class);
				startActivity(inte);
			}
		});
	}

	private void setImage(int sel){	
		switch(sel){
		case -1:
			feeling.setImageResource(R.drawable.transparent);
			break;
		case 0:
			feeling.setImageResource(R.drawable.cry);
			break;
		case 1:
			feeling.setImageResource(R.drawable.veryupset);
			break;
		case 2:
			feeling.setImageResource(R.drawable.upset);
			break;
		case 3:
			feeling.setImageResource(R.drawable.nointerest);
			break;
		case 4:
			feeling.setImageResource(R.drawable.weak);
			break;
		case 5:
			feeling.setImageResource(R.drawable.totallysurprised);
			break;
		case 6:
			feeling.setImageResource(R.drawable.good);
			break;
		case 7:
			feeling.setImageResource(R.drawable.laughing);
			break;
		case 8:
			feeling.setImageResource(R.drawable.studious);
			break;
		case 9:
			feeling.setImageResource(R.drawable.yawning);
			break;
		case 10:
			feeling.setImageResource(R.drawable.fit);
			break;
		case 11:
			feeling.setImageResource(R.drawable.bored);
			break;
		case 12:
			feeling.setImageResource(R.drawable.worry);
			break;
		case 13:
			feeling.setImageResource(R.drawable.strong);
			break;
		case 14:
			feeling.setImageResource(R.drawable.surprised);
			break;
		case 15:
			feeling.setImageResource(R.drawable.smart);
			break;
		default:

		}
	}

	public void onClick_Save(View view) {

		NoteText.BasalInsulin = EditTextBasalInsulin.getText().toString().trim();
		NoteText.BloodGlucose = EditTextBloodGlucose.getText().toString().trim();
		NoteText.Bolus = EditTextBolus.getText().toString().trim();
		NoteText.Caloried = EditTextCaloried.getText().toString().trim();
		NoteText.Carbohydrates = EditTextCarbohydrates.getText().toString().trim();
		NoteText.Ketones = EditTextKetones.getText().toString().trim();
		NoteText.Weight = EditTextWeight.getText().toString().trim();


		if (!NoteText.BasalInsulin.equals("") || !NoteText.BloodGlucose.equals("")
				|| !NoteText.Bolus.equals("") || !NoteText.Caloried.equals("")
				|| !NoteText.Carbohydrates.equals("") || !NoteText.Ketones.equals("")
				|| !NoteText.Weight.equals("")) {

			Note item = new Note();
			item.setfeelingId(NoteText.select);
			item.setNote(NoteText.note);
			item.setDate(ToayDate);
			item.setBasal(NoteText.BasalInsulin);
			item.setGlucose(NoteText.BloodGlucose);
			item.setBolus(NoteText.Bolus);
			item.setCaloried(NoteText.Caloried);
			item.setCarbohydrates(NoteText.Carbohydrates);
			item.setKetones(NoteText.Ketones);
			item.setWeight(NoteText.Weight);
			mEntryDataSource.insert(item);
			array_list.add(item);
			NoteText.list.add(item);
			NoteText.x = NoteText.list.size();

			arr = new Note[NoteText.list.size()];
			NoteText.list.toArray(arr);
			NoteText.note = null;


			int BldGlu = Integer.parseInt(NoteText.BloodGlucose);
			NoteText.BasalInsulin = "0";
			NoteText.BloodGlucose = "0";
			NoteText.Bolus = "0";
			NoteText.Caloried = "0";
			NoteText.Carbohydrates = "0";
			NoteText.Ketones = "0";
			NoteText.Weight = "0";
			NoteText.select = -1;

			if (BldGlu >= 9) {

				Intent inte = new Intent(getApplicationContext(),
						AlertActivity.class);
				AlertActivity.Status = "HIGH";
				startActivity(inte);

			} else if (BldGlu > 3 || BldGlu < 9) {

				Intent inten = new Intent(getApplicationContext(),
						RepeatPresActivity.class);
				startActivity(inten);

			} else if (BldGlu <= 3) {

				Intent inte = new Intent(getApplicationContext(),
						AlertActivity.class);
				AlertActivity.Status = "LOW";
				startActivity(inte);
			}

			Toast.makeText(getApplicationContext(),
					"Your Record has been saved successfully",
					Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(getApplicationContext(),
					"Please fill all the field", Toast.LENGTH_LONG).show();
		}

	}

	public void onClick_Previous(View view){

		if(NoteText.x>0){
			NoteText.x--;
			EditTextBasalInsulin.setText("" + arr[NoteText.x].getBasal());
			EditTextBloodGlucose.setText("" + arr[NoteText.x].getGlucose());
			EditTextBolus.setText("" + arr[NoteText.x].getBolus());
			EditTextCaloried.setText("" + arr[NoteText.x].getCaloried());
			EditTextCarbohydrates.setText("" + arr[NoteText.x].getCarbohydrates());
			EditTextKetones.setText("" + arr[NoteText.x].getKetones());
			EditTextWeight.setText("" + arr[NoteText.x].getWeight());
			setImage(arr[NoteText.x].getfeelingId());
			NoteText.note = arr[NoteText.x].getNote();		
		}
	}

	public void onClick_Next(View view){

		if(NoteText.x < arr.length-1){
			NoteText.x++;
			EditTextBasalInsulin.setText("" + arr[NoteText.x].getBasal());
			EditTextBloodGlucose.setText("" + arr[NoteText.x].getGlucose());
			EditTextBolus.setText("" + arr[NoteText.x].getBolus());
			EditTextCaloried.setText("" + arr[NoteText.x].getCaloried());
			EditTextCarbohydrates.setText("" + arr[NoteText.x].getCarbohydrates());
			EditTextKetones.setText("" + arr[NoteText.x].getKetones());
			EditTextWeight.setText("" + arr[NoteText.x].getWeight());
			setImage(arr[NoteText.x].getfeelingId());
			NoteText.note = arr[NoteText.x].getNote();		
		}
		else{
			// Empty all fields
			EditTextBasalInsulin.setText("");
			EditTextBloodGlucose.setText("");
			EditTextBolus.setText("");
			EditTextCaloried.setText("");
			EditTextCarbohydrates.setText("");
			EditTextKetones.setText("");
			EditTextWeight.setText("");
			setImage(-1);

			NoteText.x = NoteText.list.size();
			arr = new Note[NoteText.list.size()];
			NoteText.list.toArray(arr);
		}
	}

	public void onClick_Home (View view){
		Intent inte = new Intent(getApplicationContext(),HomeActivity.class);
		startActivity(inte);
		finish();
	}

	public void onClick_Share(View view) {

		//Intent i = new Intent(NewEntryActivity.this,LineGraph.class);
		//startActivity(i);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_entry, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mEntryDataSource.mDbHelper != null) {
			mEntryDataSource.mDbHelper.close();
		}
		if (mEntryDataSource.mDb != null) {
			mEntryDataSource.mDb.close();
		}
	}
}
