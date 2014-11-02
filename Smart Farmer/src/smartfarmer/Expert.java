package smartfarmer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class Expert extends Activity implements OnItemSelectedListener{

	Button gglemap , Call , CalBtn;

	Spinner District , Division ;

	boolean State = false ;

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expert);
        Init();
        addDivision();

        Work();
    }

	public void Init(){
		gglemap = (Button) findViewById(R.id.button1);
		Call = (Button) findViewById(R.id.button2);
		CalBtn = (Button) findViewById(R.id.buttonCall);

		Division = (Spinner) findViewById(R.id.spinner1);
		District = (Spinner) findViewById(R.id.spinner2);

		Division.setOnItemSelectedListener((OnItemSelectedListener) this);

		ShowHidden(false);
	}

	public void ShowHidden( boolean x ) {
		if( x == false ) {
			District.setVisibility(View.GONE);
			Division.setVisibility(View.GONE);
			CalBtn.setVisibility(View.GONE);
		}
		else {
			//District.setVisibility(View.VISIBLE);
			Division.setVisibility(View.VISIBLE);
			//CalBtn.setVisibility(View.VISIBLE);
		}
	}

	public void Work(){

		gglemap.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myInt = new Intent(Expert.this,  GMap.class );
				startActivity(myInt);
			}
		});

		Call.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				State ^= true ;
				if( State == false ) addDivision();
				ShowHidden(State);
			}
		});




		CalBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if( District.getSelectedItem().equals("Dhaka") ){
					Intent callIntent = new Intent(Intent.ACTION_CALL);
					callIntent.setData( Uri.parse("tel:01674164319"));
					startActivity(callIntent);
				}
				else if( District.getSelectedItem().equals("Pabna") ){
					Intent callIntent = new Intent(Intent.ACTION_CALL);
					callIntent.setData( Uri.parse("tel:017715257212"));
					startActivity(callIntent);
				}
				else if( District.getSelectedItem().equals("Bogura") ){
					Intent callIntent = new Intent(Intent.ACTION_CALL);
					callIntent.setData( Uri.parse("tel:01673700057"));
					startActivity(callIntent);
				}
				else {
					Intent callIntent = new Intent(Intent.ACTION_CALL);
					callIntent.setData( Uri.parse("tel:1234"));
					startActivity(callIntent);
				}
			}
		});

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

			List<String> Tmp = new ArrayList<String>();

			Tmp.add("Select Division");
			for(String st : list  ) Tmp.add(st);

			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,R.layout.spinner_draw_latest, Tmp );
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
				District.setVisibility(View.VISIBLE);
				CalBtn.setVisibility(View.VISIBLE);
				Collections.addAll(myList,Dhaka);
			}
			else if( Division.getSelectedItem().equals("Rajshahi") ) {
				District.setVisibility(View.VISIBLE);
				CalBtn.setVisibility(View.VISIBLE);
				Collections.addAll(myList,Rajshahi);
			}
			else if( Division.getSelectedItem().equals("Khulna") ) {
				District.setVisibility(View.VISIBLE);
				CalBtn.setVisibility(View.VISIBLE);
				Collections.addAll(myList,Khulna);
			}
			else if( Division.getSelectedItem().equals("Chittagong") ) {
				District.setVisibility(View.VISIBLE);
				CalBtn.setVisibility(View.VISIBLE);
				Collections.addAll(myList,Chittagong);
			}

			else if( Division.getSelectedItem().equals("Rangpur") ) {
				District.setVisibility(View.VISIBLE);
				CalBtn.setVisibility(View.VISIBLE);
				Collections.addAll(myList,Rangpur);
			}
			else if( Division.getSelectedItem().equals("Sylhet") ) {
				District.setVisibility(View.VISIBLE);
				CalBtn.setVisibility(View.VISIBLE);
				Collections.addAll(myList,Sylhet);
			}
			else if( Division.getSelectedItem().equals("Barisal") ){
				District.setVisibility(View.VISIBLE);
				CalBtn.setVisibility(View.VISIBLE);
				Collections.addAll(myList,Barisal);
			}else {
				CalBtn.setVisibility(View.GONE);
				District.setVisibility(View.GONE);
			}

			Collections.sort(myList);

			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,R.layout.spinner_draw_latest, myList);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			District.setAdapter(dataAdapter);

		}

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			SetDistrict();
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}
}
