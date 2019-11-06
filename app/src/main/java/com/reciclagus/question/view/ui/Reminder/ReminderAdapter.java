package com.reciclagus.question.view.ui.Reminder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reciclagus.question.R;
import com.reciclagus.question.model.Reminder;

import java.util.List;

public class ReminderAdapter extends RecyclerView.Adapter {

    private List<Reminder> reminders;

    public ReminderAdapter(List<Reminder> reminders) {
        this.reminders = reminders;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_reminder, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder v = (MyViewHolder)holder;
        v.txtTitle.setText(reminders.get(position).getTitle());
        v.txtContent.setText(reminders.get(position).getContent());
        //v.aSwitch.setChecked();

    }

    @Override
    public int getItemCount() {
        return this.reminders.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtTitle, txtContent;
        Switch aSwitch;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.reminder_title);
            txtContent = itemView.findViewById(R.id.reminder_content);
            aSwitch = itemView.findViewById(R.id.reminder_switch_off_on);

        }
    }

}
