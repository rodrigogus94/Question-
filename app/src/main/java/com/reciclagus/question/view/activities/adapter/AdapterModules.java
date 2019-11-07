package com.reciclagus.question.view.activities.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.reciclagus.question.R;
import com.reciclagus.question.model.quiz.Module;
import com.reciclagus.question.view.activities.quiz.ModulesActivity;
import com.reciclagus.question.view.activities.quiz.QuizActivity;

import java.io.Serializable;
import java.util.List;

public class AdapterModules extends RecyclerView.Adapter {

    List<Module> module;

    public AdapterModules(List<Module> module) {
        this.module = module;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_module, parent, false);

        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final MyViewholder m = (MyViewholder)holder;
        m.txt.setText(this.module.get(position).getTitle());
        m.box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(m.box.getContext(), QuizActivity.class);
               i.putExtra("module" , (Serializable) module.get(position));
               m.box.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.module.size();
    }
    public class MyViewholder extends RecyclerView.ViewHolder{

        TextView txt;
        ConstraintLayout box;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            txt = itemView.findViewById(R.id.adapter_title_module);
            box = itemView.findViewById(R.id.boxmodule);
        }
    }

}
