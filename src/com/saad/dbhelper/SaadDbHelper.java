package com.saad.dbhelper;

import com.saad.contract.NoteContract;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SaadDbHelper extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "glucose";
	public static final int DATABASE_VERSION = 1;

	public SaadDbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(NoteContract.SQL_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE tbl_note IF EXIST");
		onCreate(db);

	}

}
