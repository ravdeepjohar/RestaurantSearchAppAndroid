package com.userinterface;

import com.userinterface.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SearchRestaurantInterface extends Activity{
	
	public static EditText searchText ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stubay
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchres);

		Button search = (Button) findViewById(R.id.button1);

		search.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				searchText=(EditText) findViewById (R.id.searchr);
				startActivity(new Intent("com.domain.S3"));

			}
		});

	}
}



