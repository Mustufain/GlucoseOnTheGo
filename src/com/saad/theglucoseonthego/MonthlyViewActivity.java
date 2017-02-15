package com.saad.theglucoseonthego;

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


public class MonthlyViewActivity extends Activity {

	int month = 0;
	int []selected; 
	Button[]but;
	
	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.monthly_view);

		but = new Button[31];
		but[0] = (Button) findViewById(R.id.button1);
		but[1] = (Button) findViewById(R.id.button2);
		but[2] = (Button) findViewById(R.id.button3);
		but[3] = (Button) findViewById(R.id.button4);
		but[4] = (Button) findViewById(R.id.button5);
		but[5] = (Button) findViewById(R.id.button6);
		but[6] = (Button) findViewById(R.id.button7);
		but[7] = (Button) findViewById(R.id.button8);
		but[8] = (Button) findViewById(R.id.button9);
		but[9] = (Button) findViewById(R.id.button10);
		but[10] = (Button) findViewById(R.id.button11);
		but[11] = (Button) findViewById(R.id.button12);
		but[12] = (Button) findViewById(R.id.button13);
		but[13] = (Button) findViewById(R.id.button14);
		but[14] = (Button) findViewById(R.id.button15);
		but[15] = (Button) findViewById(R.id.button16);
		but[16] = (Button) findViewById(R.id.button17);
		but[17] = (Button) findViewById(R.id.button18);
		but[18] = (Button) findViewById(R.id.button19);
		but[19] = (Button) findViewById(R.id.button20);
		but[20] = (Button) findViewById(R.id.button21);
		but[21] = (Button) findViewById(R.id.button22);
		but[22] = (Button) findViewById(R.id.button23);
		but[23] = (Button) findViewById(R.id.button24);
		but[24] = (Button) findViewById(R.id.button25);
		but[25] = (Button) findViewById(R.id.button26);
		but[26] = (Button) findViewById(R.id.button27);
		but[27] = (Button) findViewById(R.id.button28);
		but[28] = (Button) findViewById(R.id.button29);
		but[29] = (Button) findViewById(R.id.button30);
		but[30] = (Button) findViewById(R.id.button31);
		
		//Show time on screen
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		String strDate = sdf.format(c.getTime());
		Button btn = (Button) findViewById(R.id.monthly_view_time);
		btn.setText(strDate);
		TextView name = (TextView)findViewById(R.id.month_name);

		selected = new int[31];  
		Intent iin = getIntent();
		Bundle b = iin.getExtras();
		if(b!=null)
		{
			month = (Integer) b.get("selection");
			selected = (int[]) b.get("selecteddays");

		}
		if(month%2==0){
			if(month==2){
				but[29].setVisibility(View.GONE);
				but[30].setVisibility(View.GONE);
			}
			else{
				but[30].setVisibility(View.GONE);
			}
		}

		switch(month)
		{
		case 1:
			name.setText("January");
			break;
		case 2:
			name.setText("February");
			break;
		case 3:
			name.setText("March");
			break;
		case 4:
			name.setText("April");
			break;
		case 5:
			name.setText("May");
			break;
		case 6:
			name.setText("June");
			break;
		case 7:
			name.setText("July");
			break;
		case 8:
			name.setText("August");
			break;
		case 9:
			name.setText("September");
			break;
		case 10:
			name.setText("October");
			break;
		case 11:
			name.setText("November");
			break;
		case 12:
			name.setText("December");
			break;
		default:
			throw new RuntimeException("Unknow button ID");
		}
		
		for(int i=0; i < 31; i++){
			if(selected[i]==1){
				but[i].setTextColor(getApplication().getResources().getColor(R.color.red));
			}
		}

	}

	public void onClick_Back(View view) {
		finish();
	}

	public void onClickHome(View view) {
		Intent inte = new Intent(getApplicationContext(), HomeActivity.class);
		startActivity(inte);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alert, menu);
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
