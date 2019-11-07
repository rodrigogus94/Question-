package com.reciclagus.question.view.ui.courses;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.reciclagus.question.R;
import com.reciclagus.question.model.quiz.Course;
import com.reciclagus.question.view.activities.quiz.ModulesActivity;

import java.io.Serializable;
import java.util.List;

public class AdapterListCourses extends RecyclerView.Adapter {

    List<Course> cursos;

    public AdapterListCourses(List<Course> cursos) {
        this.cursos = cursos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_courses, parent, false);

        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final MyViewholder m = (MyViewholder)holder;
        m.txt.setText(this.cursos.get(position).getTitle());
        m.box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(m.box.getContext(), ModulesActivity.class);
                i.putExtra("modules" , (Serializable) cursos.get(position).getModules());
                m.box.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.cursos.size();
    }
    public class MyViewholder extends RecyclerView.ViewHolder{

        TextView txt;
        ConstraintLayout box;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            txt = itemView.findViewById(R.id.list_courses_all);
            box = itemView.findViewById(R.id.coursebox);
        }
    }

}
