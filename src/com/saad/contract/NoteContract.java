package com.saad.contract;

import android.provider.BaseColumns;

public class NoteContract {

	public static abstract class NoteEntry implements BaseColumns {
		public static final String TABLE_NAME = "tbl_note";
		public static final String COLUMN_FEELING_ID = "feelingid";
		public static final String COLUMN_NAME_DATE = "date";
		public static final String COLUMN_NAME_NOTE = "note";
		public static final String COLUMN_NAME_GLUCOSE = "glucose";
		public static final String COLUMN_NAME_BASAL = "basal";
		public static final String COLUMN_NAME_BOLUS = "bolus";
		public static final String COLUMN_NAME_CARBOHYDRATES = "carbohydrates";
		public static final String COLUMN_NAME_CALORIED = "caloried";
		public static final String COLUMN_NAME_WEIGHT = "weight";
		public static final String COLUMN_NAME_KETONES = "ketones";
		// other columns variables - -
	}

	private static final String TEXT_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";
	public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS "
			+ NoteEntry.TABLE_NAME + " (" + NoteEntry._ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + NoteEntry.COLUMN_FEELING_ID 
			+ " INTEGER" + COMMA_SEP + NoteEntry.COLUMN_NAME_DATE
			+ TEXT_TYPE + COMMA_SEP + NoteEntry.COLUMN_NAME_NOTE
			+ TEXT_TYPE + COMMA_SEP + NoteEntry.COLUMN_NAME_GLUCOSE
			+ TEXT_TYPE + COMMA_SEP + NoteEntry.COLUMN_NAME_BASAL
			+ TEXT_TYPE + COMMA_SEP + NoteEntry.COLUMN_NAME_BOLUS
			+ TEXT_TYPE + COMMA_SEP + NoteEntry.COLUMN_NAME_CARBOHYDRATES
			+ TEXT_TYPE + COMMA_SEP + NoteEntry.COLUMN_NAME_CALORIED
			+ TEXT_TYPE + COMMA_SEP + NoteEntry.COLUMN_NAME_WEIGHT
			+ TEXT_TYPE + COMMA_SEP + NoteEntry.COLUMN_NAME_KETONES
			+ TEXT_TYPE + " )";

	public static final String SQL_DROP = "DROP TABLE IF EXISTS "
			+ NoteEntry.TABLE_NAME;
	public static final String SQL_SELECT_ALL = "SELECT * FROM "
			+ NoteEntry.TABLE_NAME ;
	public static final String SQL_DELETE_ALL = "DELETE FROM "
			+ NoteEntry.TABLE_NAME;

}
