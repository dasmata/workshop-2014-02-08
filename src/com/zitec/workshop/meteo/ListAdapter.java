package com.zitec.workshop.meteo;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.zitec.workshop.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<JSONObject> {
	Context ctx;
	ArrayList<JSONObject> elementsList;
	public ListAdapter(Context context, int resource, int textViewResourceId, ArrayList<JSONObject> list) {
		super(context, resource, textViewResourceId, list);
		ctx = context;
		this.elementsList = list;
	}

	
	@Override
	public View getView(int position, View recycledView, ViewGroup parent){
		View v;
		LayoutInflater inflater = LayoutInflater.from(this.ctx);
		if(recycledView == null){
			v = inflater.inflate(R.layout.meteo_element, null);
		} else {
			v = recycledView;
		}
		TextView txt = (TextView)v.findViewById(R.id.meteo_element);
		try {
			txt.setText(this.elementsList.get(position).getString("text"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return v;
	}
}
