package com.reciclagus.question.view.activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.reciclagus.question.R;
import com.reciclagus.question.adapters.ComunicationFragment;
import com.reciclagus.question.model.quiz.Alternative;
import com.reciclagus.question.model.quiz.Content;
import com.reciclagus.question.model.quiz.Course;
import com.reciclagus.question.model.quiz.Module;
import com.reciclagus.question.model.quiz.Question;
import com.reciclagus.question.view.ui.courses.CoursesFragment;
import com.reciclagus.question.view.ui.courses.ModuleFragment;
import com.reciclagus.question.view.ui.courses.QuizFragment;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ComunicationFragment {

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private AppBarConfiguration mAppBarConfiguration;
    private FragmentManager fragmentManager;
    Module module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_courses, R.id.nav_reminder,
                R.id.nav_settings, R.id.nav_notes, R.id.nav_awards)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        List<Alternative> a1 = new ArrayList<Alternative>();
        a1.add(new Alternative("alternativa 1", true));
        a1.add(new Alternative("alternativa 2", false));
        a1.add(new Alternative("alternativa 3", false));
        a1.add(new Alternative("alternativa 4", false));

        List<Alternative> a2 = new ArrayList<Alternative>();
        a1.add(new Alternative("alternativa 1", true));
        a1.add(new Alternative("alternativa 2", false));
        a1.add(new Alternative("alternativa 3", false));
        a1.add(new Alternative("alternativa 4", false));

        List<Alternative> a3 = new ArrayList<Alternative>();
        a1.add(new Alternative("alternativa 1", true));
        a1.add(new Alternative("alternativa 2", false));
        a1.add(new Alternative("alternativa 3", false));
        a1.add(new Alternative("alternativa 4", false));

        List<Question> questions1 = new ArrayList<Question>();
        Question q1 = new Question("questao 1", a1);
        Question q2 = new Question("questao 2", a2);
        Question q3 = new Question("questao 3", a3);
        questions1.add(q1);
        questions1.add(q2);
        questions1.add(q3);

        module = new Module("teste1", new Content("texO MAIN", "TXT EXEMPLOOO"), 1, questions1);
        //List<Course> s =  getCourses();



    }

    public void addCourse(Course c){
        DatabaseReference cursos = referencia.child("cursos");

        ArrayList<Module> listModule = new ArrayList<>();
        listModule.add(module);

        c.setModules(listModule);

        cursos.push().setValue(c);

        cursos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("FireBase", dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public List<Course> getCourses(){
        DatabaseReference c = referencia.child("cursos");
        final List<Course> cursos = new ArrayList<Course>();

        this.referencia.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Course c = (Course)snapshot.getValue(Course.class);
                    Toast.makeText(MainActivity.this, c.getTitle(), Toast.LENGTH_SHORT).show();
                    cursos.add(c);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        c.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Course c = (Course)snapshot.getValue(Course.class);
                    Toast.makeText(MainActivity.this, c.getTitle(), Toast.LENGTH_SHORT).show();
                    cursos.add(c);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return cursos;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void event(String txt, int idQuestion) {
        Question q = module.getQuestions().get(0);

        switch (txt) {
            case CoursesFragment.ID:
                openFragmentInCourses(new CoursesFragment(), q);
                break;
            case ModuleFragment.ID:
                openFragmentInCourses(new ModuleFragment(), q);
                break;
            case QuizFragment.ID:
                openFragmentInCourses(new QuizFragment(), q);
                Toast.makeText(this, "batata", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
    public void openFragmentInCourses(Fragment f, Question question){

        Bundle bundle = new Bundle();
        bundle.putSerializable("question", question);
        f.setArguments(bundle);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace( R.id.nav_host_fragment, f);
        ft.commit();


    }
}
