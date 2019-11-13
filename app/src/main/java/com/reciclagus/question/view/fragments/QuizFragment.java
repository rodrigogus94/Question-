package com.reciclagus.question.view.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.reciclagus.question.R;
import com.reciclagus.question.model.quiz.Alternative;
import com.reciclagus.question.model.quiz.Module;
import com.reciclagus.question.model.quiz.Question;
import com.reciclagus.question.model.util.ComunicationFragment;
import com.reciclagus.question.model.util.Result;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment {

    LinearLayout hostBtns;
    TextView title;
    Question question;

    ComunicationFragment comunicationListener;

    public QuizFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        hostBtns = view.findViewById(R.id.fragment_quiz_linearlayout);
        title = view.findViewById(R.id.fragment_quiz_title);

        Bundle bundle = getArguments();
        if (bundle != null) {
            question = (Question) bundle.getSerializable("question");
        }

        if (question.getAlternatives() != null) {// aqui oh
            for (final Alternative a : question.getAlternatives()) {
                Button b = new Button(getContext());
                b.setText(a.getTxt());
                hostBtns.addView(b);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (comunicationListener != null) {
                            if(a.isCorrect()){
                                comunicationListener.eventQuiz(new Result(a.isCorrect(), a.getTxt()));
                            }
                        }
                    }
                });
            }
        }

        return view;
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

}
