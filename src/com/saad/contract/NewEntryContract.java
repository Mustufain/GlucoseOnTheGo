package com.saad.contract;

import android.provider.BaseColumns;

public class NewEntryContract {
	public static abstract class NewDataEntry implements BaseColumns {
		public static final String TABLE_NAME = "tbl_entry";
		public static final String COLUMN_NAME_ENTRY_DATE = "entry_date";
		public static final String COLUMN_NAME_GLUCOSE = "glucose";
		public static final String COLUMN_NAME_BASAL = "basal";
		public static final String COLUMN_NAME_BOLUS = "bolus";
		public static final String COLUMN_NAME_CARBOHYDRATES = "carbohydrates";
		public static final String COLUMN_NAME_CALORIED = "caloried";
		public static final String COLUMN_NAME_WEIGHT = "weight";
		public static final String COLUMN_NAME_KETONES = "ketones";
	}

	private static final String TEXT_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";
	public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS "
			+ NewDataEntry.TABLE_NAME + " (" + NewDataEntry._ID 
			+ " INTEGER PRIMARY KEY," + NewDataEntry.COLUMN_NAME_ENTRY_DATE
			+ TEXT_TYPE + COMMA_SEP + NewDataEntry.COLUMN_NAME_GLUCOSE 
			+ TEXT_TYPE + COMMA_SEP + NewDataEntry.COLUMN_NAME_BASAL 
			+ TEXT_TYPE + COMMA_SEP + NewDataEntry.COLUMN_NAME_BOLUS
			+ TEXT_TYPE + COMMA_SEP + NewDataEntry.COLUMN_NAME_CARBOHYDRATES
			+ TEXT_TYPE + COMMA_SEP + NewDataEntry.COLUMN_NAME_CALORIED
			+ TEXT_TYPE + COMMA_SEP + NewDataEntry.COLUMN_NAME_WEIGHT 
			+ TEXT_TYPE + COMMA_SEP + NewDataEntry.COLUMN_NAME_KETONES + " )";

	public static final String SQL_DROP = "DROP TABLE IF EXISTS "
			+ NewDataEntry.TABLE_NAME;
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + NewDataEntry.TABLE_NAME + " ORDER BY " + NewDataEntry.COLUMN_NAME_ENTRY_DATE;
	public static final String SQL_DELETE_ALL = "DELETE FROM "
			+ NewDataEntry.TABLE_NAME;

}


