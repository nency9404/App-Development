package com.example.sevva;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class Database extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "userdb";
    private static final String TABLE_USERS = "userdetails";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_MESSAGE = "message";

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAME + " TEXT, "
                + KEY_ADDRESS + " TEXT, "
                + KEY_PHONE + " TEXT, "
                + KEY_EMAIL + " TEXT, "
                + KEY_MESSAGE + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        // Create tables again
        onCreate(db);
    }

    // Adding new User Details
    public void insertUserDetails(String name, String address, String phone,String email,String message) {
        // Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_ADDRESS, address);
        values.put(KEY_PHONE, phone);
        values.put(KEY_EMAIL, email);
        values.put(KEY_MESSAGE, message);
        // Insert the new row, returning the primary key value of the new row
        db.insert(TABLE_USERS, null, values);
        db.close(); // Close the database connection
    }

    // Get User Details
    @SuppressLint("Range")
    public ArrayList<HashMap<String, String>> getUserDetails() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_USERS;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            HashMap<String, String> user = new HashMap<>();
            user.put("id", cursor.getString(cursor.getColumnIndex(KEY_ID)));
            user.put("name", cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            user.put("address", cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
            user.put("phone", cursor.getString(cursor.getColumnIndex(KEY_PHONE)));
            user.put("email", cursor.getString(cursor.getColumnIndex(KEY_EMAIL)));
            user.put("message", cursor.getString(cursor.getColumnIndex(KEY_MESSAGE)));
            userList.add(user);
        }
        cursor.close();
        db.close();
        return userList;
    }

    // Get User Details based on user ID
    @SuppressLint("Range")
    public HashMap<String, String> getUserById(int userId) {
        SQLiteDatabase db = this.getReadableDatabase();
        HashMap<String, String> user = new HashMap<>();
        Cursor cursor = db.query(TABLE_USERS, null, KEY_ID + "=?",
                new String[]{String.valueOf(userId)}, null, null, null);
        if (cursor.moveToFirst()) {
            user.put("id", cursor.getString(cursor.getColumnIndex(KEY_ID)));
            user.put("name", cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            user.put("address", cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
            user.put("phone", cursor.getString(cursor.getColumnIndex(KEY_PHONE)));
            user.put("email", cursor.getString(cursor.getColumnIndex(KEY_EMAIL)));
            user.put("message", cursor.getString(cursor.getColumnIndex(KEY_MESSAGE)));
        }
        cursor.close();
        db.close();
        return user;
    }

    // Delete User Details
    public void deleteUser(int userId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, KEY_ID + " = ?", new String[]{String.valueOf(userId)});
        db.close();
    }

    // Update User Details
    public int updateUserDetails(int userId, String name, String address, String phone, String email, String message) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_ADDRESS, address);
        values.put(KEY_PHONE, phone);
        values.put(KEY_EMAIL, email);
        values.put(KEY_MESSAGE, message);
        return db.update(TABLE_USERS, values, KEY_ID + " = ?", new String[]{String.valueOf(userId)});
    }
}
