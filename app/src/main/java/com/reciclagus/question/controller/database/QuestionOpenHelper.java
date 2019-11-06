package com.reciclagus.question.controller.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuestionOpenHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_TABLE_NOTES = "CREATE TABLE "+ QContract.Note.NAME +"(" +
            QContract.Note._ID +" INTEGER PRIMARY KEY , " +
            QContract.Note.TITLE +" TEXT, " +
            QContract.Note.CONTENT+" TEXT)";
    private static final String SQL_DROP_TABLE_NOTES = "DROP TABLE IF EXISTS "+ QContract.Note.NAME;

    private static final String SQL_CREATE_TABLE_REMINDER = "CREATE TABLE "+ QContract.Reminder.NAME +"(" +
            QContract.Reminder._ID +" INTEGER PRIMARY KEY , " +
            QContract.Reminder.TITLE +" TEXT, " +
            QContract.Reminder.CONTENT +" TEXT, " +
            QContract.Reminder.DATE +" TEXT, " +
            QContract.Reminder.ACTIVE +" TEXT)";
    private static final String SQL_DROP_TABLE_REMINDER = "DROP TABLE IF EXISTS "+ QContract.Reminder.NAME;

    public static final String NOME_DATABASE = "question.db";
    private static final int DATABASE_VERSION = 1;

    public QuestionOpenHelper(Context context) {
        super(context, NOME_DATABASE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_NOTES);
        db.execSQL(SQL_CREATE_TABLE_REMINDER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TABLE_NOTES);
        db.execSQL(SQL_DROP_TABLE_REMINDER);
        onCreate(db);

    }
}
