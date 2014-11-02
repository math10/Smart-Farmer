package smartfarmer;

import java.util.List;

import smartfarmer.doa.DatabaseHandler;
import smartfarmer.model.Crop;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DataTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dtest);
		TextView tv = (TextView) findViewById(R.id.tv_test);
		DatabaseHandler db = new DatabaseHandler(this);

		/**
		 * CRUD Operations
		 * */
		// Inserting Contacts
		Log.d("Insert: ", "Inserting ..");
		db.addContact(new Crop(1, "Ravi", "9100000000", "er", "er", "er"));
		db.addContact(new Crop(2, "asd", "9100000000", "er", "er", "er"));
		db.addContact(new Crop(3, "asd", "9100000000", "er", "er", "er"));

		// Reading all contacts
		Log.d("Reading: ", "Reading all contacts..");
		List<Crop> contacts = db.getAllContacts();

		String some = null;
		for (Crop cn : contacts) {
			String log = "Id: " + cn.getId() + " ,Name: " + cn.getName();
			// Writing Contacts to log
			some = some + " " + log;
			Log.d("Name: ", log);
		}
		tv.setText(some);
	}

}
