package smartfarmer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondPage extends Activity {
	
	
	Button Rice , Jute , Tea , Wheat , Chilli , Pulse , Potato , Sugar , Mustard , Cotton ;
	
	TextView Txt1 , Txt2 ;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crops);
        Init();
        
        Rice.setOnClickListener( new OnClickListener() {
			public void onClick(View v) {
				Intent myInt = new Intent(SecondPage.this,  Process.class );
				myInt.putExtra("NAME", "Rice");
				startActivity(myInt);
			}
		});
        Jute.setOnClickListener( new OnClickListener() {
			public void onClick(View v) {
				Intent myInt = new Intent(SecondPage.this,  Process.class );
				myInt.putExtra("NAME", "Jute");
				startActivity(myInt);
			}
		});
        Tea.setOnClickListener( new OnClickListener() {
			public void onClick(View v) {
				Intent myInt = new Intent(SecondPage.this,  Process.class );
				myInt.putExtra("NAME", "Tea");
				startActivity(myInt);
			}
		});
        Wheat.setOnClickListener( new OnClickListener() {
			public void onClick(View v) {
				Intent myInt = new Intent(SecondPage.this,  Process.class );
				myInt.putExtra("NAME", "Wheat");
				startActivity(myInt);
			}
		});
        Chilli.setOnClickListener( new OnClickListener() {
			public void onClick(View v) {
				Intent myInt = new Intent(SecondPage.this,  Process.class );
				myInt.putExtra("NAME", "Chilli");
				startActivity(myInt);
			}
		});
        Pulse.setOnClickListener( new OnClickListener() {
			public void onClick(View v) {
				Intent myInt = new Intent(SecondPage.this,  Process.class );
				myInt.putExtra("NAME", "Pulse");
				startActivity(myInt);
			}
		});
        Potato.setOnClickListener( new OnClickListener() {
			public void onClick(View v) {
				Intent myInt = new Intent(SecondPage.this,  Process.class );
				myInt.putExtra("NAME", "Potato");
				startActivity(myInt);
			}
		});
        Sugar.setOnClickListener( new OnClickListener() {
			public void onClick(View v) {
				Intent myInt = new Intent(SecondPage.this,  Process.class );
				myInt.putExtra("NAME", "Sugar");
				startActivity(myInt);
			}
		});
        Mustard.setOnClickListener( new OnClickListener() {
			public void onClick(View v) {
				Intent myInt = new Intent(SecondPage.this,  Process.class );
				myInt.putExtra("NAME", "Mustard");
				startActivity(myInt);
			}
		});
        Cotton.setOnClickListener( new OnClickListener() {
			public void onClick(View v) {
				Intent myInt = new Intent(SecondPage.this,  Process.class );
				myInt.putExtra("NAME", "Cotton");
				startActivity(myInt);
			}
		});
    }
	
	public void Init(){
		Rice = (Button) findViewById(R.id.RICE);
		Jute = (Button) findViewById(R.id.JUTE);
		Tea = (Button) findViewById(R.id.TEA);
		Wheat = (Button) findViewById(R.id.WHEAT);
		Chilli = (Button) findViewById(R.id.CHILLI);
		Pulse = (Button) findViewById(R.id.PULSE);
		Potato = (Button) findViewById(R.id.POTATO);
		Sugar = (Button) findViewById(R.id.SUGAR);
		Mustard = (Button) findViewById(R.id.MUSTARD);
		Cotton = (Button) findViewById(R.id.COTTON);
		
	}
	

}
