package com.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import androidx.annotation.Nullable;

public class GiangVienDataBase extends SQLiteOpenHelper {
    public static final int GVD_VERSION = 1;
    public static final String GVD_NAME = "Account.sqlite";
    public static final String TBL_NAME = "GiangVien";
    public static final String COL_GV_ID = "GV_Id";
    public static final String COL_GV_NAME = "GV_Name";
    public static final String COL_GV_BIRTH = "GV_Birth";
    public static final String COL_GV_GENDER = "GV_Gender";
    public static final String COL_GV_PHONE = "GV_Phone";
    public static final String COL_GV_ACHIEVEMENT = "GV_Achievement";
    public static final String COL_GV_COMMENT = "GV_Comment";
    public static final String COL_GV_PHOTO = "GV_Photo";

    public GiangVienDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, GVD_NAME, factory, GVD_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + "(" + COL_GV_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_GV_NAME + " VARCHAR(100), " + COL_GV_BIRTH + " VARCHAR(50), " + COL_GV_GENDER + " VARCHAR(50), "+ COL_GV_PHONE + " VARCHAR(500), "
                    + COL_GV_ACHIEVEMENT + " VARCHAR(500), " + COL_GV_COMMENT + " VARCHAR(500), " + COL_GV_PHOTO + " BLOB)";
            sqLiteDatabase.execSQL(sql);
        }catch (Exception e){
            Log.e("Error:", e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(sqLiteDatabase);
    }
    public  boolean insertData(String name, String birth,String gender, String phone, String achievement,  String comment, byte[] photo){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO " + TBL_NAME + " VALUES(null,?,?,?, ?, ?, ?,?)";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.bindString(1, name);
        statement.bindString(2, birth);
        statement.bindString(3, gender);
        statement.bindString(4, phone);
        statement.bindString(5, achievement);
        statement.bindString(6, comment);
        statement.bindBlob(7, photo);
        statement.executeInsert();
        return true;
    }
}
