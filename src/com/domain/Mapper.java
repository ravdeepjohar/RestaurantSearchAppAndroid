
package com.domain;

import java.util.List;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;


import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

import com.userinterface.R;

public class Mapper extends MapActivity{

	MapView mapView;
	String lat1=MapSingleton.getInstance().getlat();
	String lng1=MapSingleton.getInstance().getlog();
	MapController mc;
	GeoPoint p;
	class MapOverlay extends com.google.android.maps.Overlay
	{
		@Override
		public boolean draw(Canvas canvas, MapView mapView, boolean shadow, long when) 
		{
			super.draw(canvas, mapView, shadow);                   

			//---translate the GeoPoint to screen pixels---
			Point screenPts = new Point();
			mapView.getProjection().toPixels(p, screenPts);

			//---add the marker---
			Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.pin);            
			canvas.drawBitmap(bmp, screenPts.x, screenPts.y-50, null);         
			return true;
		}
	} 

	public String getmap(String S)
	{
		return S;

	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapholder);

		mapView=(MapView)findViewById(R.id.mv);
		mapView.setBuiltInZoomControls(true);

		MapController mc = mapView.getController();
		double lat = Double.parseDouble(lat1);
		double lng = Double.parseDouble(lng1);

		p = new GeoPoint(
				(int) (lat * 1E6), 
				(int) (lng * 1E6));

		mc.animateTo(p);
		mc.setZoom(20);

		MapOverlay mapOverlay = new MapOverlay();
		List<Overlay> listOfOverlays = mapView.getOverlays();
		listOfOverlays.clear();
		listOfOverlays.add(mapOverlay);

	}


	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}



}
