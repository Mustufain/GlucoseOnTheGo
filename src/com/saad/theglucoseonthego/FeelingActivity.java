package com.saad.theglucoseonthego;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FeelingActivity extends Activity {

	int x = -1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feelings);

		// Show time on screen
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		String strDate = sdf.format(c.getTime());
		Button btn = (Button) findViewById(R.id.home_time);
		btn.setText(strDate);
		final ImageButton button0  = (ImageButton) findViewById(R.id.ImageButton00);
		final ImageButton button1  = (ImageButton) findViewById(R.id.ImageButton01);
		final ImageButton button2  = (ImageButton) findViewById(R.id.ImageButton02);
		final ImageButton button3  = (ImageButton) findViewById(R.id.ImageButton03);
		final ImageButton button4  = (ImageButton) findViewById(R.id.ImageButton04);
		final ImageButton button5  = (ImageButton) findViewById(R.id.ImageButton05);
		final ImageButton button6  = (ImageButton) findViewById(R.id.ImageButton06);
		final ImageButton button7  = (ImageButton) findViewById(R.id.ImageButton07);
		final ImageButton button8  = (ImageButton) findViewById(R.id.ImageButton08);
		final ImageButton button9  = (ImageButton) findViewById(R.id.ImageButton09);
		final ImageButton button10  = (ImageButton) findViewById(R.id.ImageButton10);
		final ImageButton button11  = (ImageButton) findViewById(R.id.ImageButton11);
		final ImageButton button12  = (ImageButton) findViewById(R.id.ImageButton12);
		final ImageButton button13  = (ImageButton) findViewById(R.id.ImageButton13);
		final ImageButton button14  = (ImageButton) findViewById(R.id.ImageButton14);
		final ImageButton button15  = (ImageButton) findViewById(R.id.ImageButton15);
		button0.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				x = 0;
			}
		});
		button1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				x = 1;
			}
		});
		button2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				x = 2;
			}
		});
		button3.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				x = 3;
			}
		});
		button4.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				x = 4;
			}
		});
		button5.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				x = 5;
			}
		});
		button6.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				x = 6;
			}
		});
		button7.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				x = 7;
			}
		});
		button8.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				x = 8;
			}
		});
		button9.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				x = 9;
			}
		});
		button10.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				x = 10;
			}
		});
		button11.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				x = 11;
			}
		});
		button12.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				x = 12;
			}
		});
		button13.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				x = 13;
			}
		});
		button14.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				x = 14;
			}
		});
		button15.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				x = 15;
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	public void onClick_Add(View view) {
		Intent inte = new Intent(getApplicationContext(), NewEntryActivity.class);
		inte.putExtra("selection", x);
		startActivity(inte);
		finish();
	}
	
	public void onClick_Home(View view) {
		Intent inte = new Intent(getApplicationContext(), HomeActivity.class);
		
		
		//inte.putExtra("selection", x);
		startActivity(inte);
		finish();
	}
}
