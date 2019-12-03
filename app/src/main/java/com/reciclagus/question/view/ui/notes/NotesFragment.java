package com.reciclagus.question.view.ui.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.reciclagus.question.R;
import com.reciclagus.question.controller.crud.NotesCRUD;
import com.reciclagus.question.model.Note;
import com.reciclagus.question.view.activities.EditNoteActivity;
import com.reciclagus.question.view.activities.ReminderManagerActivity;

import java.util.ArrayList;
import java.util.List;

public class NotesFragment extends Fragment {

    private NotesViewModel shareViewModel;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(NotesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notes, container, false);
        //final TextView textView = root.findViewById(R.id.text_share);
        shareViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
           //     textView.setText(s);
            }
        });

        FloatingActionButton fab = root.findViewById(R.id.notesfab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), EditNoteActivity.class);
                startActivity(i);
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        recyclerView = root.findViewById(R.id.notes_recyclerView);
        StaggeredGridLayoutManager layoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        NotesCRUD crud = new NotesCRUD(getContext());
        List<Note> notes = crud.getAll();

        recyclerView.setAdapter(new NoteAdapter(notes));



        return root;
    }
}