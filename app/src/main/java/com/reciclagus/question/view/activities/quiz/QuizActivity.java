package com.reciclagus.question.view.activities.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.reciclagus.question.R;
import com.reciclagus.question.model.util.ComunicationFragment;
import com.reciclagus.question.model.quiz.Module;
import com.reciclagus.question.model.quiz.Question;
import com.reciclagus.question.model.util.Result;
import com.reciclagus.question.view.fragments.ModuleContentFragment;
import com.reciclagus.question.view.fragments.QuizFragment;

import java.util.List;

public class QuizActivity extends AppCompatActivity implements ComunicationFragment {

    FragmentManager fm;
    Module module;
    int indexLastQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        List<Question> questions;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            module = (Module) extras.getSerializable("module");
        }

        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment f = new ModuleContentFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("module", module);
        f.setArguments(bundle);

        ft.replace(R.id.host_quiz, f);
        ft.commit();
    }

    public void openFragmentInCourses(Question question) {
        Fragment f = new QuizFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("question", question);
        f.setArguments(bundle);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.host_quiz, f);
        ft.commit();
    }

    @Override
    public void eventQuiz(Result resul) {
        /*Question q = module.getQuestions().get(0);
        this.indexLastQuestion++;

        openFragmentInCourses(q);*/

        String s = new String(resul.toString());
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

        Fragment f = new QuizFragment();

        if (this.indexLastQuestion <= module.getQuestions().size()-1){
            Bundle bundle = new Bundle();
            bundle.putSerializable("question", module.getQuestions().get(this.indexLastQuestion));
            f.setArguments(bundle);
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.host_quiz,f);
        ft.commit();

        this.indexLastQuestion++;
    }

    @Override
    public void eventStart() {
        Question q = module.getQuestions().get(0);
        openFragmentInCourses(q);
        this.indexLastQuestion++;
    }
}
