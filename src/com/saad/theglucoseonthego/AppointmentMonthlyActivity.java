package com.saad.theglucoseonthego;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.saad.theglucoseonthego.R.color;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AppointmentMonthlyActivity extends Activity {

	int flag = 0;
	int curryear;
	int selection = 0; 
	int counter = 0;
	Date[]a;
	TextView year;
	int []check;
	int []years;
	int []months;
	int []days;
	int []selecteddays;
	String dates[];
	Button[]b;

	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_appointment_monthly);
		
		curryear = Calendar.getInstance().get(Calendar.YEAR);
		b = new Button[12];
		b[0] = (Button) findViewById(R.id.button1);
		b[1] = (Button) findViewById(R.id.button2);
		b[2] = (Button) findViewById(R.id.button3);
		b[3] = (Button) findViewById(R.id.button4);
		b[4] = (Button) findViewById(R.id.button5);
		b[5] = (Button) findViewById(R.id.button6);
		b[6] = (Button) findViewById(R.id.button7);
		b[7] = (Button) findViewById(R.id.button8);
		b[8] = (Button) findViewById(R.id.button9);
		b[9] = (Button) findViewById(R.id.button10);
		b[10] = (Button) findViewById(R.id.button11);
		b[11] = (Button) findViewById(R.id.button12);
		SelectMonthsByYear();
		
		//Show time on screen
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		String strDate = sdf.format(c.getTime());
		Button btn = (Button) findViewById(R.id.appointmentMonthlyTime);
		btn.setText(strDate);
		//SelectMonth();
	}
	
	public void SelectMonthsByYear(){
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		
		year = (TextView) findViewById(R.id.curryear);
		year.setText(Integer.toString(curryear));

		check = new int[12];
		selecteddays = new int[31];
		years = new int[NoteText.dates.size()];
		months = new int[NoteText.dates.size()];
		days = new int[NoteText.dates.size()];
		a = new Date[NoteText.dates.size()];
		dates = new String[NoteText.dates.size()];

		NoteText.dates.toArray(dates);

		for(int i = 0; i<NoteText.dates.size(); i++){
			try {
				a[i] = f.parse(dates[i]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}


		for(int i = 0; i< a.length; i++){
			Calendar cal = Calendar.getInstance();
			cal.setTime(a[i]);
			years[i] = cal.get(Calendar.YEAR);
			months[i] = cal.get(Calendar.MONTH);
			days[i] = cal.get(Calendar.DAY_OF_MONTH);
		}

		for(int i = 0; i<NoteText.dates.size(); i++){
			if(years[i]==curryear){
				check[months[i]] = 1; 
			}

		}
		
		if(check[0]==1){
			
			b[0].setTextColor(getApplication().getResources().getColor(R.color.red));
		}
		else if(check[1]==1){

			b[1].setTextColor(getApplication().getResources().getColor(R.color.red));
		}
		else if(check[2]==1){
			
			b[2].setTextColor(getApplication().getResources().getColor(R.color.red));
		}
		else if(check[3]==1){
			
			b[3].setTextColor(getApplication().getResources().getColor(R.color.red));
		}
		else if(check[4]==1){
			
			b[4].setTextColor(getApplication().getResources().getColor(R.color.red));
		}
		else if(check[5]==1){
			
			b[5].setTextColor(getApplication().getResources().getColor(R.color.red));
		}
		else if(check[6]==1){
			
			b[6].setTextColor(getApplication().getResources().getColor(R.color.red));
		}
		else if(check[7]==1){
			
			b[7].setTextColor(getApplication().getResources().getColor(R.color.red));
		}
		else if(check[8]==1){
			
			b[8].setTextColor(getApplication().getResources().getColor(R.color.red));
		}
		else if(check[9]==1){
			
			b[9].setTextColor(getApplication().getResources().getColor(R.color.red));
		}
		else if(check[10]==1){
			
			b[10].setTextColor(getApplication().getResources().getColor(R.color.red));
		}
		else if(check[11]==1){
			
			b[11].setTextColor(getApplication().getResources().getColor(R.color.red));
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

	public void onClick_Next(View view) {
		
		for(int i = 0; i < 12; i++){
			b[i].setTextColor(getApplication().getResources().getColor(R.color.black)); 
		}
		curryear++;
		year.setText(Integer.toString(curryear));
		SelectMonthsByYear();

	}

	public void onClick_Previous(View view) {
		for(int i = 0; i < 12; i++){
			b[i].setTextColor(getApplication().getResources().getColor(R.color.black)); 
		}
		curryear--;
		year.setText(Integer.toString(curryear));
		SelectMonthsByYear();
	}

	public void ShowMonthlyView(View v) {

		Intent inte = new Intent(AppointmentMonthlyActivity.this ,MonthlyViewActivity.class);

		switch(v.getId())
		{
		case R.id.button1:{
			selection = 1;
			for(int i = 0; i< a.length; i++){
				if(months[i] == 1){
					selecteddays[days[i]-1] = 1;
				}
			}
			inte.putExtra("selection", selection);
			inte.putExtra("selecteddays", selecteddays);

			break;}
		case R.id.button2:{
			selection = 2;
			for(int i = 0; i< a.length; i++){
				if(months[i] == 2){
					selecteddays[days[i]-1] = 1;
				}
			}
			inte.putExtra("selection", selection);
			inte.putExtra("selecteddays", selecteddays);

			break;}
		case R.id.button3:{
			selection = 3;
			for(int i = 0; i< a.length; i++){
				if(months[i] == 3){
					selecteddays[days[i]-1] = 1;
				}
			}
			inte.putExtra("selection", selection);
			inte.putExtra("selecteddays", selecteddays);
			break;}
		case R.id.button4:{
			selection = 4;
			for(int i = 0; i< a.length; i++){
				if(months[i] == 4){
					selecteddays[days[i]-1] = 1;
				}
			}
			inte.putExtra("selection", selection);
			inte.putExtra("selecteddays", selecteddays);
			break;}
		case R.id.button5:{
			selection = 5;
			for(int i = 0; i< a.length; i++){
				if(months[i] == 5){
					selecteddays[days[i]-1] = 1;
				}
			}
			inte.putExtra("selection", selection);
			inte.putExtra("selecteddays", selecteddays);
			break;}
		case R.id.button6:{
			selection = 6;
			for(int i = 0; i< a.length; i++){
				if(months[i] == 6){
					selecteddays[days[i]-1] = 1;
				}
			}
			inte.putExtra("selection", selection);
			inte.putExtra("selecteddays", selecteddays);
			break;}
		case R.id.button7:{
			selection = 7;
			for(int i = 0; i< a.length; i++){
				if(months[i] == 7){
					selecteddays[days[i]-1] = 1;
				}
			}
			inte.putExtra("selection", selection);
			inte.putExtra("selecteddays", selecteddays);
			break;}
		case R.id.button8:{
			selection = 8;
			for(int i = 0; i< a.length; i++){
				if(months[i] == 8){
					selecteddays[days[i]-1] = 1;
				}
			}
			inte.putExtra("selection", selection);
			inte.putExtra("selecteddays", selecteddays);
			break;}
		case R.id.button9:{
			selection = 9;
			for(int i = 0; i< a.length; i++){
				if(months[i] == 9){
					selecteddays[days[i]-1] = 1;
				}
			}
			inte.putExtra("selection", selection);
			inte.putExtra("selecteddays", selecteddays);
			break;}
		case R.id.button10:{
			selection = 10;
			for(int i = 0; i< a.length; i++){
				if(months[i] == 10){
					selecteddays[days[i]-1] = 1;	
				}
			}
			inte.putExtra("selection", selection);
			inte.putExtra("selecteddays", selecteddays);
			break;}
		case R.id.button11:{
			selection = 11;
			for(int i = 0; i< a.length; i++){
				if(months[i] == 11){
					selecteddays[days[i]-1] = 1;
				}
			}
			inte.putExtra("selection", selection);
			inte.putExtra("selecteddays", selecteddays);
			break;}
		case R.id.button12:{
			selection = 12;
			for(int i = 0; i< a.length; i++){
				if(months[i] == 12){
					selecteddays[days[i]-1] = 1;
					flag=1;
				}
			}
			inte.putExtra("selection", selection);
			inte.putExtra("selecteddays", selecteddays);
			break;}
		default:
			throw new RuntimeException("Unknow button ID");
		}

		startActivity(inte);
		finish();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.appointment_monthly, menu);
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
