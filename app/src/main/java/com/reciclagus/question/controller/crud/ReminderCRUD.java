package com.reciclagus.question.controller.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.reciclagus.question.controller.database.QContract;
import com.reciclagus.question.controller.database.QuestionOpenHelper;
import com.reciclagus.question.model.Reminder;

import java.util.ArrayList;
import java.util.List;

public class ReminderCRUD {

    QuestionOpenHelper db;

    public ReminderCRUD(Context context){
        db = new QuestionOpenHelper(context);
    }

    public long inserir(Reminder a){
        SQLiteDatabase d = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(QContract.Reminder.TITLE, a.getTitle());
        values.put(QContract.Reminder.CONTENT, a.getContent());
        Long result = d.insert(QContract.Reminder.NAME, null, values);
        d.close();
        return result;
    }
    public List<Reminder> getAll(){
        SQLiteDatabase d = db.getReadableDatabase();
        String[] projecao = {QContract.Reminder._ID, QContract.Reminder.TITLE,
                QContract.Reminder.CONTENT,QContract.Reminder.DATE,QContract.Reminder.ACTIVE};
        List<Reminder> reminders = new ArrayList<Reminder>();
        Cursor cursor = d.query(QContract.Reminder.NAME, projecao,null,null,null,null,null );
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                Reminder a = new Reminder();
                a.setId(cursor.getInt(0));
                a.setTitle(cursor.getString(1));
                a.setContent(cursor.getString(2));
                a.setDate(cursor.getString(3));
                a.setOn(cursor.getString(4));
                reminders.add(a);
            }
        }
        cursor.close();
        d.close();
        return reminders;
    }
    public long delete(int id){

        SQLiteDatabase d = db.getWritableDatabase();
        String selecao = QContract.Reminder._ID+" LIKE ?";
        String[] selecaoArgs = {id+""};
        long result = d.delete(QContract.Reminder.NAME, selecao,selecaoArgs);
        d.close();

        return result;
    }
}
