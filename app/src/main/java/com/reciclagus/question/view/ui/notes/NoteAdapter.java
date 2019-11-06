package com.reciclagus.question.view.ui.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reciclagus.question.R;
import com.reciclagus.question.model.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter {

    private List<Note> notes;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_notes, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder v = (MyViewHolder)holder;
        v.txtTitle.setText(notes.get(position).getTitle());
        v.txtContent.setText(notes.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtTitle, txtContent;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.note_txt_title);
            txtContent = itemView.findViewById(R.id.notes_txt_content);
        }
    }
}
