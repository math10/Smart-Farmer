package smartfarmer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class FirstPage extends Activity {

	Button ViewStat, CropInfo, GetSugg, FindExpert, About;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_page);
		Init();
		ButtonCheck();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first_page, menu);
		return true;
	}

	public void Init() {
		ViewStat = (Button) findViewById(R.id.button1);
		CropInfo = (Button) findViewById(R.id.button2);
		GetSugg = (Button) findViewById(R.id.button3);
		FindExpert = (Button) findViewById(R.id.button4);
		About = (Button) findViewById(R.id.button5);
	}

	public void ButtonCheck() {

		ViewStat.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myInt = new Intent(FirstPage.this,
						AChartEnginePieChartActivity.class);
				startActivity(myInt);
			}
		});

		CropInfo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myInt = new Intent(FirstPage.this, SecondPage.class);
				startActivity(myInt);
			}
		});

		GetSugg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// Intent myInt = new Intent(FirstPage.this, Expert.class );
				// startActivity(myInt);

			}
		});

		FindExpert.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myInt = new Intent(FirstPage.this, Expert.class);
				startActivity(myInt);
			}
		});

		About.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// GiveToast();
				// new CustomToast(t, "");
				new CustomToast(FirstPage.this, "Hi Brinta");
			}
		});

	}

	public void GiveToast() {
		Context context = getApplicationContext();
		CharSequence text = "Hi Brinta!";
		// Kire hala Thesis shesh tor ??
		int duration = Toast.LENGTH_LONG;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
}