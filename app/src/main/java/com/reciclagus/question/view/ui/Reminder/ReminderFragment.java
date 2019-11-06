package com.reciclagus.question.view.ui.Reminder;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.reciclagus.question.R;
import com.reciclagus.question.model.Note;
import com.reciclagus.question.model.Reminder;
import com.reciclagus.question.view.activities.ReminderManagerActivity;
import com.reciclagus.question.view.ui.notes.NoteAdapter;

import java.util.ArrayList;
import java.util.List;

public class ReminderFragment extends Fragment {

    private ReminderViewModel slideshowViewModel;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(ReminderViewModel.class);
        View root = inflater.inflate(R.layout.fragment_reminder, container, false);
       // final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
      //          textView.setText(s);
            }
        });
        FloatingActionButton fab = root.findViewById(R.id.reminderFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), ReminderManagerActivity.class);
                startActivity(i);
            }
        });


        recyclerView = root.findViewById(R.id.sticky_notes_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        List<Reminder> r = new ArrayList<Reminder>();
        r.add(new Reminder(0, "teste1", "teste1conteudo",false, ""));
        r.add(new Reminder(1, "teste2", "teste1\nconteudo\nteste1\nteste1conteudo",false, ""));
        r.add(new Reminder(2, "teste3", "aaa\naaa\nssss\naa\ns\nss\nssss\naaaa",false, ""));

        recyclerView.setAdapter(new ReminderAdapter(r));

        return root;
    }
}