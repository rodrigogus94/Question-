package com.reciclagus.question.controller.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.reciclagus.question.controller.database.QContract;
import com.reciclagus.question.controller.database.QuestionOpenHelper;
import com.reciclagus.question.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NotesCRUD {

    QuestionOpenHelper db;

    public NotesCRUD(Context context){
        db = new QuestionOpenHelper(context);
    }

    public long inserir(Note a){
        SQLiteDatabase d = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(QContract.Note.TITLE, a.getTitle());
        values.put(QContract.Note.CONTENT, a.getContent());
        Long result = d.insert(QContract.Note.NAME, null, values);
        d.close();
        return result;
    }
    public List<Note> getAll(){
        SQLiteDatabase d = db.getReadableDatabase();
        String[] projecao = {QContract.Note._ID, QContract.Note.TITLE, QContract.Note.CONTENT};
        List<Note> notes = new ArrayList<Note>();
        Cursor cursor = d.query(QContract.Note.NAME, projecao,null,null,null,null,null );
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                Note a = new Note();
                a.setId(cursor.getInt(0));
                a.setTitle(cursor.getString(1));
                a.setContent(cursor.getString(2));
                notes.add(a);
            }
        }
        cursor.close();
        d.close();
        return notes;
    }
    public long delete(int id){

        SQLiteDatabase d = db.getWritableDatabase();
        String selecao = QContract.Note._ID+" LIKE ?";
        String[] selecaoArgs = {id+""};
        long result = d.delete(QContract.Note.NAME, selecao,selecaoArgs);
        d.close();

        return result;
    }

}
