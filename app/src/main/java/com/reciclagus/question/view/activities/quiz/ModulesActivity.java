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

import java.util.ArrayList;
import java.util.List;

public class ModulesActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("course");
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        }

        recyclerView = findViewById(R.id.all_modules);

        //LinearLayoutManager lm = new LinearLayoutManager(getContext());
        //LinearLayoutManager lm
        //      = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager lm = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(lm);

        List<Module> m = new ArrayList<>();
        Module mm = new Module();
        mm.setTitle("teste");
        m.add(mm);


        recyclerView.setAdapter(new AdapterModules(m));
    }
}
