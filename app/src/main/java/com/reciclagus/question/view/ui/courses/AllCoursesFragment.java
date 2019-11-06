package com.reciclagus.question.view.ui.courses;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.reciclagus.question.R;
import com.reciclagus.question.model.quiz.Course;
import com.reciclagus.question.view.activities.MainActivity;
import com.reciclagus.question.view.activities.ReminderManagerActivity;

import java.util.ArrayList;
import java.util.List;

public class AllCoursesFragment extends Fragment {

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private RecyclerView recyclerView;
    private List<Course> courses;
    private FloatingActionButton fab;


    public AllCoursesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_courses_all, container, false);
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
