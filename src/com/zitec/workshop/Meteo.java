package com.zitec.workshop;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.zitec.workshop.meteo.ListAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class Meteo extends Activity {

	@Override
	public void onCreate(Bundle savedInstance){
		super.onCreate(savedInstance);
		
		String meteo= this.getIntent().getStringExtra("response");
		ArrayList<JSONObject> arrayListResponse = new ArrayList<JSONObject>();
		try {
			JSONObject objResponse = new JSONObject(meteo);
			JSONArray results = objResponse
					.getJSONObject("query")
					.getJSONObject("results")
					.getJSONObject("channel")
					.getJSONObject("item")
					.getJSONArray("forecast");
			
			for(int i = 0; i < results.length(); i++){
				arrayListResponse.add(results.getJSONObject(i));
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ListAdapter adapter = new ListAdapter(
				this,
				R.layout.meteo_element,
				R.id.meteo_element,
				arrayListResponse
		);
		
		ListView myList = (ListView)this.findViewById(R.id.meteo_holder);
		myList.setAdapter(adapter);
	}
	
	
}
