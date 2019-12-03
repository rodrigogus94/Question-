package com.reciclagus.question.view.ui.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.reciclagus.question.R;

public class SettingsFragment extends Fragment {

    SharedPreferences preferences;
    private SettingsViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(SettingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        preferences = getContext().getSharedPreferences("settings", Context.MODE_PRIVATE);



        Switch spinner = root.findViewById(R.id.modeNigth);
        boolean modoNoturno = preferences.getBoolean(getString(R.string.txt_mode_nigth), false);
        spinner.setChecked(modoNoturno);
        Toast.makeText(getContext(), ""+modoNoturno, Toast.LENGTH_SHORT).show();
        spinner.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean(getString(R.string.txt_mode_nigth), isChecked);
                editor.apply();
                Toast.makeText(getContext(), "Reinicie o app para aplicar alterações", Toast.LENGTH_SHORT).show();
            }
        });



        //final TextView textView = root.findViewById(R.id.text_tools);
        toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
       //         textView.setText(s);
            }
        });
        return root;
    }
}