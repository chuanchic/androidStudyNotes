package com.test.androidstudynotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.test.androidstudynotes.eventbus.EventbusActivity;

public class MainActivity extends AppCompatActivity {
    private MainActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        TextView tv_eventbus_click = findViewById(R.id.tv_eventbus_click);
        tv_eventbus_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, EventbusActivity.class));
            }
        });


    }

}
