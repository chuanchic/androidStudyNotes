package com.test.androidstudynotes.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.test.androidstudynotes.R;

import org.greenrobot.eventbus.EventBus;

public class EventbusNextActivity extends AppCompatActivity {
    private TextView tv_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus_next);

        tv_send = findViewById(R.id.tv_send);
        tv_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MyMessageEvent myMessageEvent = new MyMessageEvent("我是消息");
//                EventBus.getDefault().post(myMessageEvent);
                EventBus.getDefault().post("hahaha");
                finish();
            }
        });
    }

}
