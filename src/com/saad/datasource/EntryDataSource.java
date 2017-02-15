package com.saad.datasource;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.saad.contract.NewEntryContract;
import com.saad.contract.NewEntryContract.NewDataEntry;
import com.saad.dbhelper.EntryDbHelper;
import com.saad.model.NewEntry;

public class EntryDataSource {
	//SaadDbHelper dbh = new SaadDbHelper(null);
	public final SQLiteDatabase mDb;
	public final EntryDbHelper mDbHelper;

	public EntryDataSource(Context context) {
		mDbHelper = new EntryDbHelper(context);
		mDb = mDbHelper.getWritableDatabase();
	}

	public long insert(NewEntry item){

		ContentValues values = new ContentValues();
		values.put(NewDataEntry.COLUMN_NAME_ENTRY_DATE, item.getDate());
		values.put(NewDataEntry.COLUMN_NAME_GLUCOSE, item.getGlucose());
		values.put(NewDataEntry.COLUMN_NAME_BASAL, item.getBasal());
		values.put(NewDataEntry.COLUMN_NAME_BOLUS, item.getBolus());
		values.put(NewDataEntry.COLUMN_NAME_CARBOHYDRATES, item.getCarbohydrates());
		values.put(NewDataEntry.COLUMN_NAME_CALORIED, item.getCaloried());
		values.put(NewDataEntry.COLUMN_NAME_WEIGHT, item.getWeight());
		values.put(NewDataEntry.COLUMN_NAME_KETONES, item.getKetones());

		long newRowId;
		newRowId = mDb.insert(NewDataEntry.TABLE_NAME, null, values);
		return newRowId;

	}

	public ArrayList<NewEntry> getList() {
		ArrayList<NewEntry> array_list = new ArrayList<NewEntry>();
		Cursor mCursor = mDb.rawQuery(NewEntryContract.SQL_SELECT_ALL, null);
		mCursor.moveToFirst();
		while (mCursor.moveToNext()) {
			NewEntry item = new NewEntry();
			item.setId(mCursor.getInt(mCursor
					.getColumnIndex(NewDataEntry._ID )));
			item.setDate(mCursor.getString(mCursor
					.getColumnIndex(NewDataEntry.COLUMN_NAME_ENTRY_DATE)));
			item.setGlucose(mCursor.getString(mCursor
					.getColumnIndex(NewDataEntry.COLUMN_NAME_GLUCOSE)));
			item.setBasal(mCursor.getString(mCursor
					.getColumnIndex(NewDataEntry.COLUMN_NAME_BASAL)));
			item.setBolus(mCursor.getString(mCursor
					.getColumnIndex(NewDataEntry.COLUMN_NAME_BOLUS)));
			item.setCarbohydrates(mCursor.getString(mCursor
					.getColumnIndex(NewDataEntry.COLUMN_NAME_CARBOHYDRATES)));
			item.setCaloried(mCursor.getString(mCursor
					.getColumnIndex(NewDataEntry.COLUMN_NAME_CALORIED)));
			item.setWeight(mCursor.getString(mCursor
					.getColumnIndex(NewDataEntry.COLUMN_NAME_WEIGHT)));
			item.setKetones(mCursor.getString(mCursor
					.getColumnIndex(NewDataEntry.COLUMN_NAME_KETONES)));
			array_list.add(item);
		} 

		return array_list;
	}

	public void deleteAll() {

		mDb.execSQL(NewEntryContract.SQL_DELETE_ALL);

	}
	public void bulkInsert(ArrayList<NewEntry> array_list) {

		for (NewEntry item : array_list) {

			insert(item) ;

		}

	}

}
