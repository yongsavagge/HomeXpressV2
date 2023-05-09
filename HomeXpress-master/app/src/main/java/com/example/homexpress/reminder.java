package com.example.homexpress;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class reminder extends AppCompatActivity implements View.OnClickListener {
    private Button btn_alarma1;
    private Button btn_alarma2;
    private int notificationId = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        btn_alarma1 = findViewById(R.id.btn_alarma1);
        btn_alarma2 = findViewById(R.id.btn_alarma2);

        btn_alarma1.setOnClickListener(this);
        btn_alarma2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        EditText etAlarm = findViewById(R.id.etAlarma);
        TimePicker timePicker = findViewById(R.id.timePicker);

        Intent intent = new Intent(this, AlarmReciever.class);
        intent.putExtra("notificationId", notificationId);
        intent.putExtra("todo", etAlarm.getText().toString());
        PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);

        switch(view.getId()){
            case R.id.btn_alarma1:
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, hour);
                startTime.set(Calendar.MINUTE, minute);
                startTime.set(Calendar.SECOND, 0);
                long alarmStartTime = startTime.getTimeInMillis();

                alarm.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);
                Toast.makeText(this, "Listo!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_alarma2:
                alarm.cancel(alarmIntent);
                Toast.makeText(this, "La alarma ha sido cancelada", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}