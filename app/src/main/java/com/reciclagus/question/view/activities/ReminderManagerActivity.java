package com.reciclagus.question.view.activities;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.reciclagus.question.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReminderManagerActivity extends AppCompatActivity {


    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");
    SimpleDateFormat dateFormat_hora = new SimpleDateFormat("HH:mm:ss");
    TextInputEditText txt;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_manager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Date data = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        Date data_atual = cal.getTime();

        final String data_completa = dateFormat.format(data_atual);
        String hora_atual = dateFormat_hora.format(data_atual);

        cal.setTime(data);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Snackbar.make(view, "Data Atual" + data_completa, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });






















    }


    /*

        final Calendar cal2 = Calendar.getInstance();
        cal2.setTime(data);

        calendarView = findViewById(R.id.calendarView_reminder_edit);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {


                if (cal2.getTime().getMonth() > dayOfMonth) {
                    Toast.makeText(ReminderManagerActivity.this, "voçê não pode fazer< otario", Toast.LENGTH_SHORT).show();

                }

                Toast.makeText(ReminderManagerActivity.this, "" + month + " " + dayOfMonth, Toast.LENGTH_SHORT).show();
            }
        });
        criarNotificacaoSimples();



    }
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public void criarNotificacaoSimples(){
            int id = 1;
            String titulo = "Título da Notificação";
            String texto = "Texto da notificação Simples";
            int icone = android.R.drawable.ic_dialog_info;

            Intent intent = new Intent(this, MainActivity.class);
            PendingIntent p = getPendingIntent(id, intent, this);

            NotificationCompat.Builder notificacao = new NotificationCompat.Builder(this);
            notificacao.setSmallIcon(icone);
            notificacao.setContentTitle(titulo);
            notificacao.setContentText(texto);
            notificacao.setContentIntent(p);

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, 8);

            NotificationManagerCompat nm = NotificationManagerCompat.from(this);
            nm.notify(id, notificacao.build());
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        private PendingIntent getPendingIntent(int id, Intent intent, Context context){
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addParentStack(intent.getComponent());
            stackBuilder.addNextIntent(intent);

            PendingIntent p = stackBuilder.getPendingIntent(id, PendingIntent.FLAG_UPDATE_CURRENT);
            return p;
        }

*/


    }
