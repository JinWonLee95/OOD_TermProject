package kr.ac.cnu.jin.workoutapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jin on 2015-11-27.
 */
public class TimeDataBase extends SQLiteOpenHelper {

    public TimeDataBase (Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE WorkoutTime(date varchar(20), time INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public void update(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public void delete(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public String PrintData() {
        SQLiteDatabase db = getReadableDatabase();
        String str = "";

        Cursor cursor = db.rawQuery("select * from WorkoutTime", null);
        while(cursor.moveToNext()) {
            str += cursor.getString(0)
                    + " : Date "
                    + cursor.getInt(1)
                    + " : Time "
            ;
        }
        return str;
    }

    public String DateData() {
        SQLiteDatabase db = getReadableDatabase();
        String str = "";

        Cursor cursor = db.rawQuery("select * from WorkoutTime", null);
        while(cursor.moveToNext()) {
            str += cursor.getString(0);                    ;
        }

        return str;
    }

    public int TimeData() {
        SQLiteDatabase db = getReadableDatabase();
        int str = 0;

        Cursor cursor = db.rawQuery("select * from WorkoutTime", null);
        while(cursor.moveToNext()) {
            str += Integer.valueOf(cursor.getString(1));
        }

        return str;
    }


}
