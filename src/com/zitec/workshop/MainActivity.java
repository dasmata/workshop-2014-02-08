package com.zitec.workshop;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.splash);
		this.setActions();
	}

	
	protected void setActions(){
		Button btn = (Button) this.findViewById(R.id.refresh_conection2);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				MainActivity.this.checkInternetConnection();
			}
		});
	}
	
	protected void showErrorMessage(){
		TextView txt = (TextView)this.findViewById(R.id.splash_text);
		txt.setText(this.getResources().getString(R.string.splash_error_message));
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.d("workshop", "start");
	}
	
	protected void checkInternetConnection(){
		ConnectivityManager conManager = (ConnectivityManager)this.getSystemService(
				Context.CONNECTIVITY_SERVICE);
		
		NetworkInfo info = conManager.getActiveNetworkInfo();
		if(info != null && info.isConnected()){
			
		} else {
			this.showErrorMessage();
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		this.checkInternetConnection();
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
