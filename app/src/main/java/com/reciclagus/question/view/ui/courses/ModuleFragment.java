package com.reciclagus.question.view.ui.courses;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.reciclagus.question.R;
import com.reciclagus.question.adapters.ComunicationFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModuleFragment extends Fragment{

    public static final String ID = "moduleFragment";


    ComunicationFragment comunicationListener;
    Button btnStartCourses;

    public ModuleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_courses_module, container, false);

        btnStartCourses = root.findViewById(R.id.courses_bt_question);
        btnStartCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(comunicationListener != null){

                    int idQuestion = 0;
                    comunicationListener.event(QuizFragment.ID, idQuestion);
                }
            }
        });
        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ComunicationFragment) {
           comunicationListener = (ComunicationFragment) context;
        } else {
            throw new ClassCastException();
        }
    }
    public void mudarNomeButton(){
        btnStartCourses.setText("kkkk");
    }
}
