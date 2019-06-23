package com.example.minipro;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
public class DatabaseHelper extends SQLiteOpenHelper {
public static final String DATABASE_NAME = "dictionary";
public static final String TABLE_NAME = "mean";
public static final String COL_1 = "WORD";
public static final String COL_2 = "MEANING";
public DatabaseHelper(Context context) {
super(context, DATABASE_NAME, null, 1);
}
@Override
public void onCreate(SQLiteDatabase db) {
db.execSQL("CREATE TABLE " + TABLE_NAME + " ( " + COL_1 + " TEXT, " + COL_2 + " TEXT)");
}
@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
onCreate(db);
}
public boolean insert(String WORD, String MEANING) {
SQLiteDatabase db = getWritableDatabase();
ContentValues contentValues = new ContentValues();
contentValues.put(COL_1, WORD);
contentValues.put(COL_2, MEANING);
long result = db.insert(TABLE_NAME, null, contentValues);
if (result != -1) return true;
else return false;
}
public boolean update(String WORD, String MEANING) {
SQLiteDatabase db = getWritableDatabase();
ContentValues contentValues = new ContentValues();
contentValues.put(COL_1, WORD);
contentValues.put(COL_2, MEANING);
db.update(TABLE_NAME, contentValues, "WORD = ?", new String[]{WORD});
return true;
}
public boolean delete(String WORD){
SQLiteDatabase db = getWritableDatabase();
db.delete(TABLE_NAME,"WORD= ?", new String[]{WORD});
return true;
}

public Cursor searchData(String str1) {
SQLiteDatabase db = getWritableDatabase();
// TODO Auto-generated method stub
//String query="SELECT * FROM " +TABLE_NAME + "WHERE WORD ="+str1;
String query="SELECT * FROM " + TABLE_NAME + " WHERE " + COL_1 + " LIKE '%" + str1 + "%'";
Cursor res=db.rawQuery(query,null);
return res;   }
public Cursor getAllData() {
// TODO Auto-generated method stub
SQLiteDatabase db = getWritableDatabase();
Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
return res;

}}
