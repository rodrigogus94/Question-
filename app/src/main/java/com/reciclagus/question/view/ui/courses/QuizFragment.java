package com.reciclagus.question.view.ui.courses;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.reciclagus.question.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment {

    public static final String ID = "quizfragment";

    public QuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_courses_quiz, container, false);


        return root;
    }

}
