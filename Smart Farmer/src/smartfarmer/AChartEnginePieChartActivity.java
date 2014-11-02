package smartfarmer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

public class AChartEnginePieChartActivity extends Activity implements OnItemSelectedListener{

	Spinner District , Division ;
	
	Button btnChart ;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pie);
        
        Init();
        ShowDistrict(false);
        
        addDivision();
        
        OnClickListener clickListener = new OnClickListener() {
			
			public void onClick(View v) {
				
				double[] distribution = { 20 , 12.9, 8.7 , 14.0, 1.9, 17.7, 6.8 , 6.0 , 5.0 , 7.0 } ;
				
				if( Division.getSelectedItem().equals("Get Full Statistics") ) {
					
					openChart(distribution , "Bangladesh Agro Pie Chart" , "nai" );
				}
				else {
					String St [] = getData( District.getSelectedItem().toString() );
					distribution = Parser.parse(St, District.getSelectedItem().toString() );
					//for( int i = 0 ; i < 10 ; i++ ) Log.d("pp :: " , String.valueOf( distribution[i]) );
					String my = "" ;
					my +=  District.getSelectedItem().toString() ;
					my += " " ;
					my += "Zilla Agro Pie Chart";
					openChart(distribution , my , District.getSelectedItem().toString() );
				}			
			}
		};
		
		btnChart.setOnClickListener(clickListener);
    
    }
    
    private void openChart(double[] distribution  , String StrTitle , String zilla){    	
    	
    	
    	
    	int LEN = 10 ;
    	// Pie Chart Section Names
    	String[] code = new String[] {
    			"Rice", "Jute", "Tea" , "Wheat", "Chilli", "Pulse", "Potato" , "Sugar" , "Mustard" , "Cotton" };    	
    	
    	// Color of each Pie Chart Sections
    	int[] colors = { Color.BLUE, Color.MAGENTA, Color.GREEN, Color.CYAN, Color.RED,
    					 Color.YELLOW , Color.LTGRAY , Color.DKGRAY , Color.parseColor("#69803D") , Color.parseColor("#FF0095") };
    	
    	// Instantiating CategorySeries to plot Pie Chart    	
    	CategorySeries distributionSeries = new CategorySeries( StrTitle );
    	for(int i=0 ;i < LEN ;i++){
    		// Adding a slice with its values and name to the Pie Chart
    		distributionSeries.add(  code[i] , distribution[i]);
    	}   
    	
    	// Instantiating a renderer for the Pie Chart
    	DefaultRenderer defaultRenderer  = new DefaultRenderer();    	
    	for(int i = 0 ;i< LEN ;i++){    		
    		SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();    	
    		seriesRenderer.setColor(colors[i]);
    		seriesRenderer.setDisplayChartValues(true);
    		
    		// Adding a renderer for a slice
    		defaultRenderer.addSeriesRenderer(seriesRenderer);
    	}
    	
    	defaultRenderer.setChartTitle(StrTitle);
    	
    	defaultRenderer.isInScroll();
    	defaultRenderer.setChartTitleTextSize(20);
    	defaultRenderer.setZoomButtonsVisible(true);    	    		
    	defaultRenderer.setApplyBackgroundColor(true);
    	defaultRenderer.setBackgroundColor( Color.BLACK ); //set background color
    	
    	
    	defaultRenderer.setShowLabels(true);  
    	defaultRenderer.setLabelsTextSize(20);
    	defaultRenderer.setLegendTextSize(25);
    	
    	
    	
    	String TT = "Statistics";
    	if( zilla.equals("nai") == false ) TT = zilla + " " + "Statistics";
    	
    	
    	// Creating an intent to plot bar chart using dataset and multipleRenderer    	
    	Intent intent = ChartFactory.getPieChartIntent(getBaseContext(), distributionSeries , defaultRenderer, TT);    	
    	
    	// Start Activity
    	startActivity(intent);
    	
    }
    
    public void Init(){
		Division = (Spinner) findViewById(R.id.spinner1);
		District = (Spinner) findViewById(R.id.spinner2);
		btnChart = (Button) findViewById(R.id.btn_chart);
		Division.setOnItemSelectedListener((OnItemSelectedListener) this);
	}
    
    public void addDivision() {
		
		List<String> list = new ArrayList<String>();
		list.add("Dhaka");
		list.add("Rajshahi");
		list.add("Khulna");
		list.add("Chittagong");
		list.add("Barisal");
		list.add("Rangpur");
		list.add("Sylhet");
		Collections.sort(list);
		
		//**
		List<String> Tmp = new ArrayList<String>();
		Tmp.add("Get Full Statistics");
		for(String x : list) Tmp.add(x);
		//list = Tmp ;
		//***
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,R.layout.spinner_draw_latest, Tmp);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		
		
		Division.setAdapter(dataAdapter);
	
	}
    public void SetDistrict(){
		
		String Dhaka[] = {"Dhaka","Faridpur","Gazipur","Gopalganj","Jamalpur","Kishoreganj","Madaripur","Manikganj","Munshiganj","Mymensingh","Narayanganj","Narsingdi","Netrakona","Rajbari","Shariatpur","Sherpur","Tangail"};
		String Rajshahi[] = {"Bogra","Joypurhat","Naogaon","Natore","Nawabganj","Pabna","Rajshahi","Sirajganj"};
		String Khulna[] = {"Bagerhat","Chuadanga","Jessore","Jhenaidah","Khulna","Kushtia","Magura","Meherpur","Narail","Satkhira"};
		String Chittagong[] = {"Bandarban","Brahmanbaria","Chandpur","Chittagong","Comilla","Cox'sBazar","Feni","Khagrachhari","Lakshmipur","Noakhali","Rangamati"};
		String Barisal[] = {"Barguna","Barisal","Bhola","Jhalokati","Patuakhali","Pirojpur"};
		String Rangpur[] = {"Dinajpur","Gaibandha","Kurigram","Lalmonirhat","Nilphamari","Panchagarh","Rangpur","Thakurgaon"};
		String Sylhet[] = {"Habiganj","Moulvibazar","Sunamganj","Sylhet"};
		
		List<String> myList = new ArrayList<String>();
		myList.clear();
		
		if( Division.getSelectedItem().equals("Dhaka") ) {
			ShowDistrict(true);
			Collections.addAll(myList,Dhaka);
		}
		else if( Division.getSelectedItem().equals("Rajshahi") ) {
			ShowDistrict(true);
			Collections.addAll(myList,Rajshahi);
		}
		else if( Division.getSelectedItem().equals("Khulna") ) {
			ShowDistrict(true);
			Collections.addAll(myList,Khulna);
		}
		else if( Division.getSelectedItem().equals("Chittagong") ) {
			ShowDistrict(true);
			Collections.addAll(myList,Chittagong);
		}
		
		else if( Division.getSelectedItem().equals("Rangpur") ) {
			ShowDistrict(true);
			Collections.addAll(myList,Rangpur);
		}
		else if( Division.getSelectedItem().equals("Sylhet") ) {
			ShowDistrict(true);
			Collections.addAll(myList,Sylhet);
		}
		else if( Division.getSelectedItem().equals("Barisal") ){
			ShowDistrict(true);
			Collections.addAll(myList,Barisal);
		}
		else {
			ShowDistrict(false);
		}
		
		if( myList.size() > 0 )Collections.sort(myList);
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,R.layout.spinner_draw_latest, myList);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		
		
		District.setAdapter(dataAdapter);
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		// TODO Auto-generated method stub
		((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
	   // ((TextView) parent.getChildAt(0)).setTextSize(5);
		
		SetDistrict();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void ShowDistrict( boolean x ) {
		if( x == false ) District.setVisibility(View.GONE);
		else District.setVisibility(View.VISIBLE);
	}
	
	String[] getData(String dis ){
		InputStream inputStream = null;
		String st[] = new String[207];
		int cnt = 0 ;
		try {
		    inputStream =  getResources().openRawResource(R.raw.input);
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
		return st ;
	}
	
	public static String[] Split(String x, String tkn) {
        StringTokenizer StrTkn = new StringTokenizer(x, tkn);
        ArrayList<String> ArrLis = new ArrayList<String>(x.length());
        while (StrTkn.hasMoreTokens()) ArrLis.add(StrTkn.nextToken());
        return ArrLis.toArray(new String[0]);
	}
}
