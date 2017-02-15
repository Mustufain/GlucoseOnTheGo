package com.saad.datasource;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.saad.contract.NoteContract;
import com.saad.contract.NoteContract.NoteEntry;
import com.saad.dbhelper.SaadDbHelper;
import com.saad.model.Note;

public class NoteDataSource {
	public final SQLiteDatabase mDb;
	public final SaadDbHelper mDbHelper;
	Cursor myCursor  = null;

	public NoteDataSource(Context context) {
		mDbHelper = new SaadDbHelper(context);
		mDb = mDbHelper.getWritableDatabase();
	}

	public long insert(Note item) {

		ContentValues values = new ContentValues();
		values.put(NoteEntry._ID, item.getId());
		values.put(NoteEntry.COLUMN_FEELING_ID, item.getfeelingId());
		values.put(NoteEntry.COLUMN_NAME_NOTE, item.getNote());
		values.put(NoteEntry.COLUMN_NAME_GLUCOSE, item.getGlucose());
		values.put(NoteEntry.COLUMN_NAME_BASAL, item.getBasal());
		values.put(NoteEntry.COLUMN_NAME_BOLUS, item.getBolus());
		values.put(NoteEntry.COLUMN_NAME_CARBOHYDRATES, item.getCarbohydrates());
		values.put(NoteEntry.COLUMN_NAME_CALORIED, item.getCaloried());
		values.put(NoteEntry.COLUMN_NAME_WEIGHT, item.getWeight());
		values.put(NoteEntry.COLUMN_NAME_KETONES, item.getKetones());
		values.put(NoteEntry.COLUMN_NAME_DATE, item.getDate());


		long newRowId;
		newRowId = mDb.insert(NoteEntry.TABLE_NAME, null, values);
		return newRowId;

	}

	public ArrayList<Note> getList() {
		ArrayList<Note> array_list = new ArrayList<Note>();

		myCursor = mDb.rawQuery(NoteContract.SQL_SELECT_ALL, null);

		if(myCursor!= null && myCursor.getCount() > 0){
			myCursor.moveToFirst();

			while (myCursor.moveToNext()) {
				Note item = new Note();
				item.setId(myCursor.getInt(myCursor
						.getColumnIndex(NoteEntry._ID)));
				item.setfeelingId(myCursor.getInt(myCursor
						.getColumnIndex(NoteEntry.COLUMN_FEELING_ID)));
				item.setDate(myCursor.getString(myCursor
						.getColumnIndex(NoteEntry.COLUMN_NAME_DATE)));
				item.setNote(myCursor.getString(myCursor
						.getColumnIndex(NoteEntry.COLUMN_NAME_NOTE)));
				item.setGlucose(myCursor.getString(myCursor
						.getColumnIndex(NoteEntry.COLUMN_NAME_GLUCOSE)));
				item.setBasal(myCursor.getString(myCursor
						.getColumnIndex(NoteEntry.COLUMN_NAME_BASAL)));
				item.setBolus(myCursor.getString(myCursor
						.getColumnIndex(NoteEntry.COLUMN_NAME_BOLUS)));
				item.setCarbohydrates(myCursor.getString(myCursor
						.getColumnIndex(NoteEntry.COLUMN_NAME_CARBOHYDRATES)));
				item.setCaloried(myCursor.getString(myCursor
						.getColumnIndex(NoteEntry.COLUMN_NAME_CALORIED)));
				item.setWeight(myCursor.getString(myCursor
						.getColumnIndex(NoteEntry.COLUMN_NAME_WEIGHT)));
				item.setKetones(myCursor.getString(myCursor
						.getColumnIndex(NoteEntry.COLUMN_NAME_KETONES)));
				array_list.add(item);

			}
		}
		myCursor.close();
		return array_list;
	}

	public void deleteAll() {

		mDb.execSQL(NoteContract.SQL_DELETE_ALL);

	}
	public void bulkInsert(ArrayList<Note> array_list) {

		for (Note item : array_list) {

			insert(item) ;

		}

	}

}
