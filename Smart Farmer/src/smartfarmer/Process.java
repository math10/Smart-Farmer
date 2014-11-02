package smartfarmer;




import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class Process extends Activity {


	Button GenInfo , Cultivation , Harvest , HarvestTime , Irrigation , Diesies , Fertilizer , Place ;

	String GenInfo1 = "" , Cultivation1 = "", Harvest1 = "" , HarvestTime1 = "" , Irrigation1 = "" , Diesies1 = "", Fertilizer1 = "" , Place1 = "";


	String CropName ;



	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.process);
        Init();
        Work();
        SetData();
    }

	public void Init(){
		GenInfo = (Button) findViewById(R.id.GENINFO);
		Cultivation = (Button) findViewById(R.id.CULTIVATION);
		Harvest = (Button) findViewById(R.id.HARVEST);
		HarvestTime = (Button) findViewById(R.id.HARVEST_TIME);
		Irrigation = (Button) findViewById(R.id.IRRIGATION);
		Diesies = (Button) findViewById(R.id.DISEASE);
		Fertilizer = (Button) findViewById(R.id.FERTILIZER);
		Place = (Button) findViewById(R.id.PLACES);
		CropName = getIntent().getStringExtra("NAME").toString() ;
		this.setTitle( CropName );
	}
	public void Work(){



        GenInfo.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View arg0) {
				LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
				View popupView = layoutInflater.inflate(R.layout.popup, null);
				final PopupWindow popupWindow = new PopupWindow(popupView,LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				Button btnDismiss = (Button) popupView.findViewById(R.id.dismiss);
				TextView Txt2 = (TextView) popupView.findViewById(R.id.textHead);
				TextView Txt1 = (TextView) popupView.findViewById(R.id.textData);




				Txt2.setText( CropName + " " +"General Information" );
				Txt1.setText( GenInfo1 );

				Txt1.setMovementMethod(new ScrollingMovementMethod());



				btnDismiss.setOnClickListener(new Button.OnClickListener() {
					public void onClick(View v) {
						popupWindow.dismiss();
					}
				});
				popupWindow.showAsDropDown(GenInfo, 15,-40); // with respect to whom
			}
		});
        Cultivation.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
				View popupView = layoutInflater.inflate(R.layout.popup, null);
				final PopupWindow popupWindow = new PopupWindow(popupView,LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				Button btnDismiss = (Button) popupView.findViewById(R.id.dismiss);
				TextView Txt2 = (TextView) popupView.findViewById(R.id.textHead);
				TextView Txt1 = (TextView) popupView.findViewById(R.id.textData);


				Txt2.setText(  CropName + " " +"Cultivation Process" );
				Txt1.setText(Cultivation1);
				Txt1.setMovementMethod(new ScrollingMovementMethod());
				btnDismiss.setOnClickListener(new Button.OnClickListener() {
					public void onClick(View v) {
						popupWindow.dismiss();
					}
				});
				popupWindow.showAsDropDown(GenInfo, 15,-40);
			}
		});
        Harvest.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
				View popupView = layoutInflater.inflate(R.layout.popup, null);
				final PopupWindow popupWindow = new PopupWindow(popupView,LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				Button btnDismiss = (Button) popupView.findViewById(R.id.dismiss);
				TextView Txt2 = (TextView) popupView.findViewById(R.id.textHead);
				TextView Txt1 = (TextView) popupView.findViewById(R.id.textData);
				Txt1.setMovementMethod(new ScrollingMovementMethod());

				Txt2.setText(  CropName + " " +"Harvest Collection" );
				Txt1.setText(Harvest1);

				btnDismiss.setOnClickListener(new Button.OnClickListener() {
					public void onClick(View v) {
						popupWindow.dismiss();
					}
				});
				popupWindow.showAsDropDown(GenInfo, 15,-40);
			}
		});
        HarvestTime.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
				View popupView = layoutInflater.inflate(R.layout.popup, null);
				final PopupWindow popupWindow = new PopupWindow(popupView,LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				Button btnDismiss = (Button) popupView.findViewById(R.id.dismiss);
				TextView Txt2 = (TextView) popupView.findViewById(R.id.textHead);
				TextView Txt1 = (TextView) popupView.findViewById(R.id.textData);


				Txt2.setText(  CropName + " " +"Harvest Time" );
				Txt1.setText(HarvestTime1);
				Txt1.setMovementMethod(new ScrollingMovementMethod());
				btnDismiss.setOnClickListener(new Button.OnClickListener() {
					public void onClick(View v) {
						popupWindow.dismiss();
					}
				});
				popupWindow.showAsDropDown(GenInfo, 15,-40);
			}
		});
        Irrigation.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
				View popupView = layoutInflater.inflate(R.layout.popup, null);
				final PopupWindow popupWindow = new PopupWindow(popupView,LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				Button btnDismiss = (Button) popupView.findViewById(R.id.dismiss);
				TextView Txt2 = (TextView) popupView.findViewById(R.id.textHead);
				TextView Txt1 = (TextView) popupView.findViewById(R.id.textData);


				Txt2.setText(  CropName + " " +"Irrigation Process" );
				Txt1.setText( Irrigation1 );
				Txt1.setMovementMethod(new ScrollingMovementMethod());
				btnDismiss.setOnClickListener(new Button.OnClickListener() {
					public void onClick(View v) {
						popupWindow.dismiss();
					}
				});
				popupWindow.showAsDropDown(GenInfo, 15,-40);
			}
		});
        Diesies.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
				View popupView = layoutInflater.inflate(R.layout.popup, null);
				final PopupWindow popupWindow = new PopupWindow(popupView,LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				Button btnDismiss = (Button) popupView.findViewById(R.id.dismiss);
				TextView Txt2 = (TextView) popupView.findViewById(R.id.textHead);
				TextView Txt1 = (TextView) popupView.findViewById(R.id.textData);


				Txt2.setText(  CropName + " " +"Crop Diesies" );
				Txt1.setText(Diesies1);
				Txt1.setMovementMethod(new ScrollingMovementMethod());
				btnDismiss.setOnClickListener(new Button.OnClickListener() {
					public void onClick(View v) {
						popupWindow.dismiss();
					}
				});
				popupWindow.showAsDropDown(GenInfo, 15,-40);
			}
		});
        Fertilizer.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
				View popupView = layoutInflater.inflate(R.layout.popup, null);
				final PopupWindow popupWindow = new PopupWindow(popupView,LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				Button btnDismiss = (Button) popupView.findViewById(R.id.dismiss);
				TextView Txt2 = (TextView) popupView.findViewById(R.id.textHead);
				TextView Txt1 = (TextView) popupView.findViewById(R.id.textData);


				Txt2.setText(  CropName + " " +"Fertilizer Process" );
				Txt1.setText(Fertilizer1);
				Txt1.setMovementMethod(new ScrollingMovementMethod());
				btnDismiss.setOnClickListener(new Button.OnClickListener() {
					public void onClick(View v) {
						popupWindow.dismiss();
					}
				});
				popupWindow.showAsDropDown(GenInfo, 15,-40);
			}
		});
        Place.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
				View popupView = layoutInflater.inflate(R.layout.popup, null);
				final PopupWindow popupWindow = new PopupWindow(popupView,LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				Button btnDismiss = (Button) popupView.findViewById(R.id.dismiss);
				TextView Txt2 = (TextView) popupView.findViewById(R.id.textHead);
				TextView Txt1 = (TextView) popupView.findViewById(R.id.textData);


				Txt2.setText(  CropName + " " +"Productive Places" );
				Txt1.setText(Place1);
				Txt1.setMovementMethod(new ScrollingMovementMethod());
				btnDismiss.setOnClickListener(new Button.OnClickListener() {
					public void onClick(View v) {
						popupWindow.dismiss();
					}
				});
				popupWindow.showAsDropDown(GenInfo, 15,-40);
			}
		});
	}
	public void SetData() {

		//Log.d("CropName :: " , CropName );

		if( CropName.equals("Rice") ){

			GenInfo1 = "Rice is the seed of the monocot plants Oryza sativa (Asian rice) or Oryza glaberrima (African rice). As a cereal grain, it is the most widely consumed staple food for a large part of the world's human population, especially in Asia. It is the grain with the second-highest worldwide production, after corn, according to data for 2010.Oryza sativa with small wind pollinated flowers Since a large portion of maize crops are grown for purposes other than human consumption, rice is the most important grain with regard to human nutrition and caloric intake, providing more than one fifth of the calories consumed worldwide by humans." ;
			Cultivation1 = "Rice is mainly grown in two types of soils i.e., (i) uplands and (ii) low lands. The method of cultivation of rice in a particular region depends largely on factors such as situation of land, type of soils, irrigation facilities, availability of labourers intensity and distribution of rainfalls. The crop of rice is grown with the following methods : \nDry or Semi-dry upland cultivation (a) Broadcasting the seed (b) Sowing the seed behind the plough or drilling. Wet or lowland cultivation (a) Transplanting in puddled fields. (b) Broadcasting sprouted seeds in puddled fields." ;
			Harvest1 = "";
			HarvestTime1 = "" ;
			Irrigation1 = "";
			Diesies1 = "";
			Fertilizer1 = "";
			Place1 = "" ;
		}
		else if(CropName.equals("Jute") ){
			GenInfo1 = "" ;
			Cultivation1 = "" ;
			Harvest1 = "";
			HarvestTime1 = "" ;
			Irrigation1 = "";
			Diesies1 = "";
			Fertilizer1 = "";
			Place1 = "" ;

		}
		else if( CropName.equals( "Tea") ){
			GenInfo1 = "" ;
			Cultivation1 = "" ;
			Harvest1 = "";
			HarvestTime1 = "" ;
			Irrigation1 = "";
			Diesies1 = "";
			Fertilizer1 = "";
			Place1 = "" ;
		}
		else if( CropName.equals("Wheat") ){
			GenInfo1 = "" ;
			Cultivation1 = "" ;
			Harvest1 = "";
			HarvestTime1 = "" ;
			Irrigation1 = "";
			Diesies1 = "";
			Fertilizer1 = "";
			Place1 = "" ;
		}
		else if( CropName.equals("Chilli") ){
			GenInfo1 = "" ;
			Cultivation1 = "" ;
			Harvest1 = "";
			HarvestTime1 = "" ;
			Irrigation1 = "";
			Diesies1 = "";
			Fertilizer1 = "";
			Place1 = "" ;
		}
		else if( CropName.equals( "Pulse") ){
			GenInfo1 = "" ;
			Cultivation1 = "" ;
			Harvest1 = "";
			HarvestTime1 = "" ;
			Irrigation1 = "";
			Diesies1 = "";
			Fertilizer1 = "";
			Place1 = "" ;
		}
		else if(CropName.equals("Potato") ){
			GenInfo1 = "" ;
			Cultivation1 = "" ;
			Harvest1 = "";
			HarvestTime1 = "" ;
			Irrigation1 = "";
			Diesies1 = "";
			Fertilizer1 = "";
			Place1 = "" ;
		}
		else if( CropName.equals("Sugar") ){
			GenInfo1 = "" ;
			Cultivation1 = "" ;
			Harvest1 = "";
			HarvestTime1 = "" ;
			Irrigation1 = "";
			Diesies1 = "";
			Fertilizer1 = "";
			Place1 = "" ;
		}
		else if( CropName.equals( "Mustard" ) ){
			GenInfo1 = "" ;
			Cultivation1 = "" ;
			Harvest1 = "";
			HarvestTime1 = "" ;
			Irrigation1 = "";
			Diesies1 = "";
			Fertilizer1 = "";
			Place1 = "" ;
		}
		else if(CropName.equals( "Cutton") ){
			GenInfo1 = "" ;
			Cultivation1 = "" ;
			Harvest1 = "";
			HarvestTime1 = "" ;
			Irrigation1 = "";
			Diesies1 = "";
			Fertilizer1 = "";
			Place1 = "" ;
		}
	}
}
