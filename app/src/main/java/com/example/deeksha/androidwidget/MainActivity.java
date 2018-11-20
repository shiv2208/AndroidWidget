package com.example.deeksha.androidwidget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private android.widget.TextView textView1;
    private android.widget.TextView textView2;
    private android.widget.TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textView3 = (TextView) findViewById(R.id.textView3);
        this.textView2 = (TextView) findViewById(R.id.textView2);
        this.textView1 = (TextView) findViewById(R.id.textView1);
        //for update widget
        int widgetIDs[] = AppWidgetManager.getInstance(getApplication()).getAppWidgetIds(new ComponentName(getApplication(), StackWidgetProvider.class));
        for (int id : widgetIDs)
            AppWidgetManager.getInstance(getApplication()).notifyAppWidgetViewDataChanged(id, R.id.stack_view);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int position = intent.getIntExtra("position", 0);
        String name = intent.getStringExtra("Name");
        String phone = intent.getStringExtra("Phone");
        textView1.setText(""+position);
        textView2.setText(name);
        textView3.setText(phone);
        Log.d("dada", name);
        Log.d("phone", phone);
        Log.d("dada", String.valueOf(position));

    }
}
