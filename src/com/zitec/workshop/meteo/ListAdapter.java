package com.zitec.workshop.meteo;

import java.util.ArrayList;

import org.json.JSONObject;

import android.content.Context;
import android.widget.ArrayAdapter;

public class ListAdapter extends ArrayAdapter<JSONObject> {

	public ListAdapter(Context context, int resource, int textViewResourceId, ArrayList<JSONObject> list) {
		super(context, resource, textViewResourceId);
		// TODO Auto-generated constructor stub
	}

}
