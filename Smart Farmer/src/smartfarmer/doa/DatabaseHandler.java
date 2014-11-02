package smartfarmer.doa;

import java.util.ArrayList;
import java.util.List;

import smartfarmer.model.Crop;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "agri";

	// Contacts table name
	private static final String TABLE_CONTACTS = "crop";

	// Contacts Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "crop_name";
	private static final String KEY_CULTIVATION = "cultivation";
	private static final String KEY_TEMPARATURE = "temparature";
	private static final String KEY_PLACE = "place";
	private static final String KEY_WEATHER = "weather";



	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," 
				+ KEY_NAME + " TEXT,"
				+ KEY_CULTIVATION + " TEXT,"
				+KEY_TEMPARATURE +" TEXT,"
				+KEY_PLACE + " TEXT,"
				+KEY_WEATHER + " TEXT"+")";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

		// Create tables again
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	public void addContact(Crop crop) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, crop.getName()); // Contact Name
		
		values.put(KEY_CULTIVATION, crop.getCultivation()); 
		values.put(KEY_TEMPARATURE, crop.getTemparature());
		values.put(KEY_PLACE, crop.getPlace());
		
		values.put(KEY_WEATHER, crop.getWeather());
		// Contact Phone

		// Inserting Row
		db.insert(TABLE_CONTACTS, null, values);
		db.close(); // Closing database connection
	}

	// Getting single contact
	/*Contact getContact(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
				KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2));
		// return contact
		return contact;
	}*/
	
	// Getting All Contacts
	public List<Crop> getAllContacts() {
		List<Crop> contactList = new ArrayList<Crop>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Crop crop = new Crop();
				crop.setId(Integer.parseInt(cursor.getString(0)));
				crop.setName(cursor.getString(1));
				crop.setCultivation(cursor.getString(2));
				crop.setTemparature(cursor.getString(3));
				crop.setPlace(cursor.getString(4));
				crop.setWeather(cursor.getString(2));
				// Adding contact to list
				contactList.add(crop);
			} while (cursor.moveToNext());
		}

		// return contact list
		return contactList;
	}




	// Getting contacts Count
	public int getContactsCount() {
		String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

}
