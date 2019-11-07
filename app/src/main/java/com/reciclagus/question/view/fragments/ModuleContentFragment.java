package com.reciclagus.question.view.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.reciclagus.question.R;
import com.reciclagus.question.model.quiz.Module;
import com.reciclagus.question.model.util.ComunicationFragment;
import com.reciclagus.question.model.util.Result;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModuleContentFragment extends Fragment{

    TextView txtModule, txtContent, txtExample;
    Button btnQuestion;
    Module module;
    ComunicationFragment comunicationListener;

    public ModuleContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_courses_module, container, false);

        txtContent = view.findViewById(R.id.courses_txt_content);
        txtExample = view.findViewById(R.id.courses_txt_example);
        txtModule =  view.findViewById(R.id.courses_txt_module);

        btnQuestion = view.findViewById(R.id.courses_bt_question);

        Bundle bundle = getArguments();
        if (bundle != null) {
            module = (Module) bundle.getSerializable("module");

            txtContent.setText(module.getContent().getTxtMain());
            txtExample.setText(module.getContent().getTxtExemple());
            txtModule.setText(module.getTitle());
        }

        btnQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (comunicationListener != null) {
                    comunicationListener.eventStart();
                }
            }
        });

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
