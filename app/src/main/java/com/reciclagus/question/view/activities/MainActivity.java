package com.reciclagus.question.view.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
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
import com.reciclagus.question.model.quiz.Alternative;
import com.reciclagus.question.model.quiz.Content;
import com.reciclagus.question.model.quiz.Course;
import com.reciclagus.question.model.quiz.Module;
import com.reciclagus.question.model.quiz.Question;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private AppBarConfiguration mAppBarConfiguration;
    private FragmentManager fragmentManager;
    Module module;
    Module module2;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        preferences = getSharedPreferences("settings", MODE_PRIVATE);
        boolean modoNoturno = preferences.getBoolean(getString(R.string.txt_mode_nigth), false);
        Toast.makeText(this, "noturno"+modoNoturno, Toast.LENGTH_SHORT).show();
        if(!modoNoturno) setTheme(R.style.MeuTheme);

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
        a1.add(new Alternative("1,3", false));
        a1.add(new Alternative("0,0003", false));
        a1.add(new Alternative("5", true));
        a1.add(new Alternative("1,0f", false));

        List<Alternative> a2 = new ArrayList<Alternative>();
        a2.add(new Alternative("ananda", true));
        a2.add(new Alternative("aaaaa", false));
        a2.add(new Alternative("alterssssss", false));
        a2.add(new Alternative("awwwwwwwwww", false));

        List<Alternative> a3 = new ArrayList<Alternative>();
        a3.add(new Alternative("int , double , float", true));
        a3.add(new Alternative("batata", false));
        a3.add(new Alternative("fffffff", false));
        a3.add(new Alternative("String", false));

        List<Question> questions1 = new ArrayList<Question>();
        Question q1 = new Question("O que tipo de dados armazena uma varivael do tipo int", a1);
        Question q2 = new Question("o que é herença qualquerm coisa", a2);
        Question q3 = new Question("Quias são os tipos primitivos?", a3);
        questions1.add(q1);
        questions1.add(q2);
        questions1.add(q3);

        module = new Module("bolinha básico", new Content("Jacare muito básico", "int i = 0"), 1, questions1);


        module2 = new Module("bolao 2", new Content("teste muito básico", "double i = 0.6"), 1, questions1);
        //List<Course> s =  getCourses();

       // addCourse(new Course());

    }

    public void addCourse(Course c){
        DatabaseReference cursos = referencia.child("cursos");

        ArrayList<Module> listModule = new ArrayList<>();
        listModule.add(module);
        listModule.add(module2);

        c.setTitle("javascript");
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
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}
