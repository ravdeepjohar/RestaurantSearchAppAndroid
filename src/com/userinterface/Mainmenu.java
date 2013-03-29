package com.userinterface;

import com.userinterface.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mainmenu extends Activity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button bsearch = (Button) findViewById(R.id.searchloc);
		bsearch.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.domain.S1"));
			}
		});
		Button bsearchres = (Button) findViewById(R.id.searchres);
		bsearchres.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.userinterface.S2"));
			}
		});
		Button bsearchcu = (Button) findViewById(R.id.searchcu);
		bsearchcu.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.userinterface.S5"));
			}
		});

	}


}
