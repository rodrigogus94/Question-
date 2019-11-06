package com.reciclagus.question.view.ui.courses;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import com.reciclagus.question.view.activities.ReminderManagerActivity;

import java.util.ArrayList;
import java.util.List;

public class CoursesFragment extends Fragment{

    public static final String ID = "Coursesfragment";
    private CoursesViewModel galleryViewModel;

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private RecyclerView recyclerView;
    private List<Course> courses;
    private FloatingActionButton fab;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(CoursesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_courses, container, false);
        //  final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //         textView.setText(s);
            }
        });
/*
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace( R.id.nav_host_fragment, new AllCoursesFragment());
        ft.commit();*/

        FloatingActionButton fab = root.findViewById(R.id.reminderAllCourses);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), ReminderManagerActivity.class);
                startActivity(i);
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        recyclerView = root.findViewById(R.id.courses_recyclerview_all);

        //LinearLayoutManager lm = new LinearLayoutManager(getContext());
        //LinearLayoutManager lm
        //      = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager lm = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(lm);

        courses = getCourses();
        return root;
    }
    public void updateList(){
        recyclerView.setAdapter(new AdapterListCourses(courses));
    }

    public List<Course> getCourses(){
        DatabaseReference c = referencia.child("cursos");
        courses = new ArrayList<Course>();

        c.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Course c = (Course)snapshot.getValue(Course.class);
                    courses.add(c);
                }
                updateList();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return courses;
    }
}