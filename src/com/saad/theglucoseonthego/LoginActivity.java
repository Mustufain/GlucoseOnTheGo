package com.saad.theglucoseonthego;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private static final String LOGTAG = "MainActivity";
	EditText user,pass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);
		
		pass = (EditText)findViewById(R.id.editText1);
		user = (EditText)findViewById(R.id.editText2);
	}

	@Override
	protected void onResume(){
		super.onResume();
		Log.d(LOGTAG,"Resume");
	}

	@Override
	protected void onStart(){
		super.onStart();
		Log.d(LOGTAG,"Start");
	}

	@Override
	protected void onRestart(){
		super.onRestart();
		Log.d(LOGTAG,"Restart");
	}

	@Override
	protected void onPause(){
		super.onPause();
		Log.d(LOGTAG,"Pause");
	}

	@Override
	protected void onStop(){
		super.onStop();
		Log.d(LOGTAG,"Stop");
	}

	@Override
	protected void onDestroy(){
		super.onDestroy();
		Log.d(LOGTAG,"Destroy");
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

	public void LogIn(View v) {
		
		if(user.getText().toString().equals("") || pass.getText().toString().equals(""))
		{
		Toast t = Toast.makeText(getApplicationContext(), "Please fill all the required fields", Toast.LENGTH_LONG);
		t.show();
			
		}
		else 
		{
		Intent intent  = new Intent(this,HomeActivity.class);
		startActivity(intent);
		}
	}
}


