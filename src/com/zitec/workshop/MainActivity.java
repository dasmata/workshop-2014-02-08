package com.zitec.workshop;

import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity{
	protected TextView txt;
	protected Button btn;
	protected Button btn2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.splash);
		this.txt = (TextView)this.findViewById(R.id.splash_text);
		this.btn = (Button) this.findViewById(R.id.refresh_conection);
		this.btn2 = (Button) this.findViewById(R.id.refresh_conection2);
		this.setActions();
	}

	
	protected void setActions(){
		this.btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				MainActivity.this.checkInternetConnection();
			}
		});
	}
	
	protected void showErrorMessage(){
		txt.setText(this.getResources().getString(R.string.splash_error_message));
		this.btn.setVisibility(View.VISIBLE);
		this.btn2.setVisibility(View.VISIBLE);
	}
	
	protected void showLoading(){
		txt.setText(this.getResources().getString(R.string.splash_text));
		this.btn.setVisibility(View.GONE);
		this.btn2.setVisibility(View.GONE);
	}
	
	protected void checkInternetConnection(){
		ConnectivityManager conManager = (ConnectivityManager)this.getSystemService(
				Context.CONNECTIVITY_SERVICE);
		
		NetworkInfo info = conManager.getActiveNetworkInfo();
		if(info != null && info.isConnected()){
			this.showLoading();
			this.loadData();
		} else {
			this.showErrorMessage();
		}
	}
	
	protected void loadData(){
		String url = "http://query.yahooapis.com/v1/public/yql?q=select%20item%20from%20weather.forecast%20where%20location%3D%2248907%22&format=json";
		RequestQueue reqQueue = Volley.newRequestQueue(this);
		
		JsonObjectRequest req = new JsonObjectRequest(
			Request.Method.GET,
			url,
			null,
			new Response.Listener<JSONObject>(){

				@Override
				public void onResponse(JSONObject response) {
					Intent i = new Intent(MainActivity.this, Meteo.class);
					i.putExtra("response", response.toString());
					MainActivity.this.startActivity(i);
					MainActivity.this.finish();
				}
				
			},
			new Response.ErrorListener(){

				@Override
				public void onErrorResponse(VolleyError error) {
					Log.d("workshop", "An error poccured:"+error.getMessage());
					
				}
			}
		);
		reqQueue.add(req);
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

}
