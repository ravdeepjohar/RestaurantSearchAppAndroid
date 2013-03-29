package com.domain;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.domain.JSONfunctions;
import com.userinterface.R;



import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class SearchByLocation extends ListActivity {


	protected  String s=null;	
	String reference[]=new String[20];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listplaceholder);


		ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

		String url="https://maps.googleapis.com/maps/api/place/search/json?location=41.8584,-87.6307&radius=5000&types=food&sensor=false&key=AIzaSyA_MHRnqvU3DPXn3qpfLYF_7_RkOSBEcR8";
		JSONObject json = JSONfunctions.getJSONfromURL(url);

		try{

			JSONArray  searchrestaurants = json.getJSONArray("results");

			for(int i=1;i<searchrestaurants.length();i++){						
				HashMap<String, String> map = new HashMap<String, String>();	
				JSONObject e = searchrestaurants.getJSONObject(i);
				map.put("id",  String.valueOf(i));
				map.put("name", "Name:" + e.getString("name"));
				map.put("magnitude", "Rating: " +  e.getString("rating"));
				map.put("vicinity", "Vicinity: "+ e.getString("vicinity"));
				reference[i]=e.getString("reference");
				mylist.add(map);		

			}		
		}catch(JSONException e)        {
			Log.e("log_tag", "Error parsing data "+e.toString());
		}

		ListAdapter adapter = new SimpleAdapter(this, mylist , R.layout.httpex, 
				new String[] { "name", "magnitude","vicinity" }, 
				new int[] { R.id.item_title, R.id.item_subtitle,R.id.item_subtitle2 });

		setListAdapter(adapter);

		final ListView lv = getListView();
		lv.setTextFilterEnabled(true);	
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {        		
				@SuppressWarnings("unchecked")
				HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);	        		
				Toast.makeText(SearchByLocation.this, "ID '" + o.get("id") + "' was clicked.", Toast.LENGTH_SHORT).show(); 
				s=reference[position];
				startActivity(new Intent("com.domain.D"));//Start Details class
				SearchSingleton.getInstance().setter(s);
			}
		});



	}

}

