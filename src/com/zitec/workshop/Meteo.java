package com.zitec.workshop;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;

public class Meteo extends Activity {

	@Override
	public void onCreate(Bundle savedInstance){
		super.onCreate(savedInstance);
		
		String meteo= this.getIntent().getStringExtra("response");
		
		try {
			JSONObject objResponse = new JSONObject(meteo);
			JSONArray results = objResponse
					.getJSONObject("query")
					.getJSONObject("results")
					.getJSONObject("channel")
					.getJSONObject("item")
					.getJSONArray("forecast");
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
