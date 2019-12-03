package com.reciclagus.question.view.activities;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.reciclagus.question.R;
import com.reciclagus.question.controller.crud.NotesCRUD;
import com.reciclagus.question.model.Note;

public class EditNoteActivity extends AppCompatActivity {

    TextInputEditText title, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        title = findViewById(R.id.edit_note_title);
        content = findViewById(R.id.it_note_content);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotesCRUD crud = new NotesCRUD(getApplicationContext());
                if(!title.getText().toString().equals("") && !content.getText().toString().equals("")){
                    crud.inserir(new Note(1, title.getText().toString(),content.getText().toString()));
                    finish();
                }else{
                    Toast.makeText(EditNoteActivity.this, "Preecha os campos!", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }

}
