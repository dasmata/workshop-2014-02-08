package com.zitec.workshop;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("workshop", "create");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d("workshop", "start");
	}
	
	@Override
	protected void onResume() {
		super.onStart();
		Log.d("workshop", "resume");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
