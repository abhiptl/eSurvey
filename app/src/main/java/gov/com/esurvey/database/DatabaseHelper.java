package gov.com.esurvey.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Abhishek on 3/16/2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

	// Database Information
	static final String DB_NAME = "SURVEYS.DB";

	// database version
	static final int DB_VERSION = 1;


	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SurveyDAOManager.createTableQuery());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + SurveyDAOManager.TABLE_NAME);
		onCreate(db);
	}

}
