package smartfarmer;
import googleme.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import smartfarmer.model.Point;

//import java.io.IOException;

import android.app.Activity;
//import android.app.Dialog;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.content.Context;
import android.content.Intent;
//import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.gms.maps.CameraUpdate;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;

public class GMap extends Activity implements LocationListener {

	// Google Map
	private GoogleMap googleMap;

	double CurLatitude, CurLongitude;
	
	Point AUST = new Point(23.7633516  , 90.4062796);
	Point BRRI = new Point(23.9918226 , 90.4089028);
	Point AgriMinistry = new Point(23.89  , 90.4058333);
	Point AgriUniversity = new Point(23.709921  , 90.407143);
	Point BARI = new Point(23.7025  , 91.590143);
	
	Spinner Places ;
	Button Go ;
	
	Location LOC ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.googlemap);
		
		
		try {

			initilizeMap();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		getCurLocation();
		
		
		Init();
		addItemToSpinner();
		ButtonWork();
		

		MarkerOptions marker1 = new MarkerOptions().position(new LatLng( BRRI.getLatiTude() , BRRI.getLongiTude() )).title("BRRI");
		MarkerOptions marker2 = new MarkerOptions().position(new LatLng( AUST.getLatiTude() , AUST.getLongiTude() )).title("AUST");
		MarkerOptions marker3 = new MarkerOptions().position(new LatLng( AgriMinistry.getLatiTude() , AgriMinistry.getLongiTude() )).title("Ministry of Agriculture");
		MarkerOptions marker4 = new MarkerOptions().position(new LatLng( AgriUniversity.getLatiTude() , AgriUniversity.getLongiTude() )).title("Bangladesh Agriculture University");
		MarkerOptions marker5 = new MarkerOptions().position(new LatLng( BARI.getLatiTude() , BARI.getLongiTude() )).title("BARI");
		
		
		// YOU ARE HERE
		MarkerOptions myMarker = new MarkerOptions().position(new LatLng(CurLatitude, CurLongitude)).title("You are here");
		
		
	    marker1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
	    marker2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
	    marker3.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
	    marker4.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
	    marker5.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
		  
		  // GREEN color icon
		myMarker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)); // adding marker
		 
		  
		googleMap.addMarker(marker1);
		googleMap.addMarker(marker2);
		googleMap.addMarker(marker3);
		googleMap.addMarker(marker4);
		googleMap.addMarker(marker5);
		googleMap.addMarker(myMarker);

		CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(23.7000, 90.3750)).zoom(11).build();

		googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

	}

	/**
	 * function to load map. If map is not created it will create it for you
	 * */
	private void initilizeMap() {
		if (googleMap == null) {
			googleMap = ((MapFragment) getFragmentManager().findFragmentById(
					R.id.map)).getMap();

			// check if map is created successfully or not
			if (googleMap == null) {
				Toast.makeText(getApplicationContext(),
						"Sorry! unable to create maps", Toast.LENGTH_SHORT)
						.show();
			}

		}
	}

	
	public boolean servicesOK() {

	    int isAvailable = GooglePlayServicesUtil
	            .isGooglePlayServicesAvailable(this);

	    if (isAvailable == ConnectionResult.SUCCESS) {

	        return true;

	    }  else {

	        Toast.makeText(this, "Cant connect!!", Toast.LENGTH_SHORT).show();

	    }
	    return false;
	}
	

	@Override
	protected void onResume() {
		super.onResume();
		initilizeMap();
	}

	public void getCurLocation() {
		
		LocationManager lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		Criteria c = new Criteria();
		String provider = lm.getBestProvider(c, false);
		LOC = lm.getLastKnownLocation(provider);
		
		if ( LOC != null) {
			CurLatitude = LOC.getLatitude();
			CurLongitude = LOC.getLongitude();
		}

	}

	// If you want location on changing place also than use below method
	// otherwise remove all below methods and don't implement location listener
	@Override
	public void onLocationChanged(Location arg0) {
		CurLongitude = LOC.getLongitude();
		CurLatitude = LOC.getLatitude();
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
	}
	
	
	public void Init(){
		Places = (Spinner ) findViewById(R.id.spinnerLocation );
		Go = ( Button ) findViewById(R.id.buttonDir);
	}
	
	
	
	public void addItemToSpinner(){
		
		List<String> list = new ArrayList<String>();
		
		list.add("AUST");
		list.add("BRRI");
		list.add("Ministry of Agriculture");
		list.add("Bangladesh Agriculture University");
		list.add("BARI");
		Collections.sort(list);
		
		//**
		List<String> Tmp = new ArrayList<String>();
		Tmp.add("Select Location");
		for(String x : list) Tmp.add(x);
		//list = Tmp ;
		//***
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, Tmp);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Places.setAdapter(dataAdapter);
		
	}
	
	public void ButtonWork(){
		
		Go.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
				Intent myInt = new Intent(GMap.this, NavigationActivity.class);
				myInt.putExtra("A",String.valueOf(CurLatitude));
				myInt.putExtra("B",String.valueOf(CurLongitude));
				
				if( Places.getSelectedItem().equals("Select Location") ){
						GiveToast();
				}
				else if( Places.getSelectedItem().equals("AUST") ){
					
					myInt.putExtra("C",String.valueOf(AUST.getLatiTude()));
					myInt.putExtra("D",String.valueOf(AUST.getLongiTude()));
					startActivity(myInt);
					
				}
				else if( Places.getSelectedItem().equals("Ministry of Agriculture") ){
					myInt.putExtra("C",String.valueOf(AgriMinistry.getLatiTude()));
					myInt.putExtra("D",String.valueOf(AgriMinistry.getLongiTude()));
					startActivity(myInt);
				}
				else if( Places.getSelectedItem().equals("BARI") ){
					myInt.putExtra("C",String.valueOf(BARI.getLatiTude()));
					myInt.putExtra("D",String.valueOf(BARI.getLongiTude()));
					startActivity(myInt);
				}
				else if( Places.getSelectedItem().equals("BRRI") ){
					myInt.putExtra("C",String.valueOf(BRRI.getLatiTude()));
					myInt.putExtra("D",String.valueOf(BRRI.getLongiTude()));
					startActivity(myInt);
				}
				else if( Places.getSelectedItem().equals("Bangladesh Agriculture University") ){
					myInt.putExtra("C",String.valueOf(AgriUniversity.getLatiTude()));
					myInt.putExtra("D",String.valueOf(AgriUniversity.getLongiTude()));
					startActivity(myInt);
				}
				
			}
		});
		
	}
	
	public Point getFromFile( String pp ){
		InputStream inputStream = null;
		String st[] = new String[107];
		int cnt = 0 ;
		try {
		    inputStream =  getResources().openRawResource(R.raw.coord);
		    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		    String line = null;
		    while ((line = reader.readLine()) !=null) {
		        st[ cnt++ ] = line;
		    }
		    inputStream.close();
		    reader.close();
		} catch(Exception e) {
		    Toast.makeText(getApplicationContext(), String.valueOf(e) , Toast.LENGTH_LONG).show();
		}
		finally {
		    if (inputStream != null) {
		        try {
		            inputStream.close();
		        } catch (IOException e) {
		            Toast.makeText(getApplicationContext(), String.valueOf(e) , Toast.LENGTH_LONG).show();
		        }
		    }
		}
		return LatLong.getPoint(st,pp);
	}
	
	 public void GiveToast(){
	    	Context context = getApplicationContext();
	    	CharSequence text = "Please select a location to see the direction";
	    	int duration = Toast.LENGTH_LONG;
	    	Toast toast = Toast.makeText(context, text, duration);
	    	
	    	toast.show();
	    }

}