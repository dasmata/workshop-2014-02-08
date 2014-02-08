package com.zitec.workshop;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ConnectivityManager conManager = (ConnectivityManager)this.getSystemService(
				Context.CONNECTIVITY_SERVICE);
		
		NetworkInfo info = conManager.getActiveNetworkInfo();
		if(info != null && info.isConnected()){
			
			//stuff goes on here
		}
		
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d("workshop", "start");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.d("workshop", "resume");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.d("workshop", "stop");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d("workshop", "pause");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("workshop", "destroy");
	}

}
