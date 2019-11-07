package com.reciclagus.question.view.activities.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.reciclagus.question.R;
import com.reciclagus.question.model.quiz.Course;
import com.reciclagus.question.model.quiz.Module;
import com.reciclagus.question.model.quiz.Question;
import com.reciclagus.question.view.activities.adapter.AdapterModules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * classe responsavel por listar os modulos
 */
public class ModulesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Module> modules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);


        recyclerView = findViewById(R.id.all_modules);

        //LinearLayoutManager lm = new LinearLayoutManager(getContext());
        //LinearLayoutManager lm
        //      = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager lm = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(lm);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            modules = (List<Module>) extras.getSerializable("modules");
            recyclerView.setAdapter(new AdapterModules(modules));
        }
    }

}
