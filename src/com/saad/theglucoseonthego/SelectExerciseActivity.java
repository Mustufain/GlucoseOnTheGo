package com.saad.theglucoseonthego;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectExerciseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_exercise);
	}

	public void onClick_Swim(View view) {
		Intent inetnt = new Intent(this, ExerciseActivity.class);
		ExerciseActivity.myType = "Swimming";
		startActivity(inetnt);
	}

	public void onClick_Cycle(View view) {
		Intent intent = new Intent(this, ExerciseActivity.class);
		ExerciseActivity.myType = "Cycling";
		startActivity(intent);
	}

	public void onClick_Walk(View view) {
		Intent intent = new Intent(this, ExerciseActivity.class);
		ExerciseActivity.myType = "Walking";
		startActivity(intent);
	}

}
