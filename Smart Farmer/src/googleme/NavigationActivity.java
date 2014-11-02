package googleme;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import smartfarmer.*;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.widget.TextView;

public class NavigationActivity extends FragmentActivity {

	 LatLng StartPosition = new LatLng(23.7633516  , 90.4062796); // setted to AUST
	 LatLng EndPosition = new LatLng(24.36666670, 88.60000000000002); //
	
	private GoogleMap map;
	private SupportMapFragment fragment;
	private LatLngBounds latlngBounds;
	private Polyline newPolyline;
	private int width, height;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.googlemap2);
		
		
		SetPositions();
		
		
	
		
		TextView Txt = ( TextView ) findViewById(R.id.textDist);
		
		String Str =   String.valueOf(   CalcDist.distance(StartPosition.latitude, StartPosition.longitude,EndPosition.latitude, EndPosition.longitude,'K')   )   ;
		
		Txt.setText( "You are only "+ Str + " Km away !" /*+ "  " +StartPosition.latitude
				+ "  " +StartPosition.longitude
				+ "  " +EndPosition.latitude
				+ "  " +EndPosition.longitude*/);
		
		getSreenDimanstions();
	    fragment = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
		map = fragment.getMap(); 	
		


		findDirections( StartPosition.latitude, StartPosition.longitude,EndPosition.latitude, EndPosition.longitude, GMapV2Direction.MODE_DRIVING );

	}
	
	@Override
	protected void onResume() {
		
		super.onResume();
    	latlngBounds = createLatLngBoundsObject(StartPosition, EndPosition);
        map.moveCamera(CameraUpdateFactory.newLatLngBounds(latlngBounds, width, height, 150));

	}

	public void handleGetDirectionsResult(ArrayList<LatLng> directionPoints) {
		PolylineOptions rectLine = new PolylineOptions().width(5).color(Color.parseColor("#AF07DE"));

		for(int i = 0 ; i < directionPoints.size() ; i++) 
		{          
			rectLine.add(directionPoints.get(i));
		}
		if (newPolyline != null)
		{
			newPolyline.remove();
		}
		newPolyline = map.addPolyline(rectLine);
		
		latlngBounds = createLatLngBoundsObject(StartPosition, EndPosition);
	    map.animateCamera(CameraUpdateFactory.newLatLngBounds(latlngBounds, width, height, 150));
		
		
		
	}
	
	private void getSreenDimanstions()
	{
		Display display = getWindowManager().getDefaultDisplay();
		width = display.getWidth(); 
		height = display.getHeight(); 
	}
	
	private LatLngBounds createLatLngBoundsObject(LatLng firstLocation, LatLng secondLocation)
	{
		if (firstLocation != null && secondLocation != null)
		{
			LatLngBounds.Builder builder = new LatLngBounds.Builder();    
			builder.include(firstLocation).include(secondLocation);
			
			return builder.build();
		}
		return null;
	}
	
	public void findDirections(double fromPositionDoubleLat, double fromPositionDoubleLong, double toPositionDoubleLat, double toPositionDoubleLong, String mode)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put(GetDirectionsAsyncTask.USER_CURRENT_LAT, String.valueOf(fromPositionDoubleLat));
		map.put(GetDirectionsAsyncTask.USER_CURRENT_LONG, String.valueOf(fromPositionDoubleLong));
		map.put(GetDirectionsAsyncTask.DESTINATION_LAT, String.valueOf(toPositionDoubleLat));
		map.put(GetDirectionsAsyncTask.DESTINATION_LONG, String.valueOf(toPositionDoubleLong));
		map.put(GetDirectionsAsyncTask.DIRECTIONS_MODE, mode);
		
		GetDirectionsAsyncTask asyncTask = new GetDirectionsAsyncTask(this);
		asyncTask.execute(map);	
	}
	
	
	public void SetPositions(){
		
		//double latitude = Double.parseDouble(getIntent().getStringExtra("A"));
	//	double longitude = Double.parseDouble(getIntent().getStringExtra("B"));
	  //  StartPosition = new LatLng(latitude, longitude);
	    
	    double latitude = Double.parseDouble(getIntent().getStringExtra("C"));
		double longitude = Double.parseDouble(getIntent().getStringExtra("D"));
	    
		EndPosition = new LatLng(latitude, longitude);
	    
	}
	
	
	
}
