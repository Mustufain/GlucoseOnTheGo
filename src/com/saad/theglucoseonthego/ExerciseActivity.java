package com.saad.theglucoseonthego;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ExerciseActivity extends Activity {

	public static int CaloriesRequired;
	ImageView ImageViewStatus;
	EditText mEditTextWeight, mEditTextTime, mEditTextCals;
	TextView tvCalReq;
	Button mButtonCalculate, mButtonStart, mButtonStop;
	int time;
	TimerTask timerTask;
	int n;;
	public static String myType;
	private static final int MINUTES_IN_AN_HOUR = 60;
	private static final int SECONDS_IN_A_MINUTE = 60;

	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercise);
		ImageViewStatus = (ImageView) findViewById(R.id.imgstatus);
		mEditTextTime = (EditText) findViewById(R.id.etExerciseTime);
		mEditTextCals = (EditText) findViewById(R.id.etExerciseCals);
		mEditTextWeight = (EditText) findViewById(R.id.etExerciseWeight);
		tvCalReq = (TextView) findViewById(R.id.tvCaloriesRequired);
		mButtonCalculate = (Button) findViewById(R.id.btnCalculate);
		mButtonStart = (Button) findViewById(R.id.btnStart);
		mButtonStart = (Button) findViewById(R.id.btnStart);

		if (CaloriesRequired != 0) {
			tvCalReq.setText(CaloriesRequired + " Cals Required to burn");
			tvCalReq.setVisibility(View.VISIBLE);
		}

		// Show time on screen
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		String strDate = sdf.format(c.getTime());
		Button btn = (Button) findViewById(R.id.exerciseTime);
		btn.setText(strDate);

	}

	public void onClick_Submit(View view) {
		String cals = mEditTextCals.getText().toString().trim();
		if (!cals.equals("")) {
			int cal = Integer.parseInt(cals);
			time = (cal * 12);
			n = time;
			mButtonCalculate.setText("Time Required for " + myType + " = "
					+ timeConversion(time));
		} else {
			Toast.makeText(getApplicationContext(), "Please Enter Calories",
					Toast.LENGTH_LONG).show();
		}

	}

	public void startTimer(View view) {

		if (n > 0) {
			final Handler handler = new Handler();

			ImageViewStatus.setVisibility(view.GONE);
			Timer ourtimer = new Timer();
			timerTask = new TimerTask() {
				public void run() {
					handler.post(new Runnable() {
						public void run() {
							Button timer = (Button) findViewById(R.id.btnStopWatch);

							timer.setText(timeConversion(n) + " Sec");
							n--;

						}
					});
					if (n <= 0) {

						timerTask.cancel();
						timerTask = null;
					}
				}
			};

			ourtimer.schedule(timerTask, 0, 1000);
		} else {
			Toast.makeText(getApplicationContext(),
					"Please Enter Cals and Calculate", Toast.LENGTH_LONG)
					.show();

		}
	}

	public void stopTimer(View view) {
		
		if (n > 0) {
			if (null != timerTask) {
				timerTask.cancel();
				timerTask = null;
				ImageViewStatus.setVisibility(view.VISIBLE);
				ImageViewStatus.setImageDrawable(getResources().getDrawable(
						R.drawable.ic_arrow_start_mid));
			}
		}
		else{
			ImageViewStatus.setVisibility(view.VISIBLE);
			ImageViewStatus.setImageDrawable(getResources().getDrawable(
					R.drawable.ic_arrow_start_high));
		}
	}

	private static String timeConversion(int totalSeconds) {
		int hours = totalSeconds / MINUTES_IN_AN_HOUR / SECONDS_IN_A_MINUTE;
		int minutes = (totalSeconds - (hoursToSeconds(hours)))
				/ SECONDS_IN_A_MINUTE;
		int seconds = totalSeconds
				- ((hoursToSeconds(hours)) + (minutesToSeconds(minutes)));

		return hours + " : " + minutes + " : " + seconds + "";
	}

	private static int hoursToSeconds(int hours) {
		return hours * MINUTES_IN_AN_HOUR * SECONDS_IN_A_MINUTE;
	}

	private static int minutesToSeconds(int minutes) {
		return minutes * SECONDS_IN_A_MINUTE;
	}

	public void onClick_Clear(View view) {
		mEditTextTime.setText("");
		mEditTextWeight.setText("");
		ImageViewStatus.setImageDrawable(getResources().getDrawable(
				R.drawable.ic_arrow_start_no));
	}

	public void onClick_Steps(View view) {
		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setTitle("Steps Required");
		alert.setMessage("" + (CaloriesRequired * 20));

		alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				// Your action here
			}
		});

		alert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
			}
		});

		alert.show();
	}

	public void onClick_Start(View view) {
		// String mWeight = mEditTextWeight.getText().toString().trim();

		String mTime = mEditTextTime.getText().toString().trim();

		if (!mTime.equals("")) {
			int Time = Integer.parseInt(mTime);

			if (Time > 40) {
				ImageViewStatus.setImageDrawable(getResources().getDrawable(
						R.drawable.ic_arrow_start_high));
			} else {
				ImageViewStatus.setImageDrawable(getResources().getDrawable(
						R.drawable.ic_arrow_start_mid));
			}
		} else {
			Toast.makeText(getApplicationContext(), "Please Enter Time",
					Toast.LENGTH_LONG).show();
		}
	}

	public void onClick_Home(View view) {
		Intent inte = new Intent(getApplicationContext(),HomeActivity.class);
		startActivity(inte);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.exercise, menu);
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
