package com.test.androidstudynotes.eventbus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.test.androidstudynotes.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventbusActivity extends AppCompatActivity {
    private Context mContext;
    private TextView tv_click;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
        EventBus.getDefault().register(this);

        mContext = this;
        tv_click = findViewById(R.id.tv_click);
        tv_result = findViewById(R.id.tv_result);

        tv_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, EventbusNextActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * threadMode 执行线程的方式
     * priority 执行的优先级，值越大优先级越高
     * sticky 粘性事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = true)
    public void myEventBusMessage(MyMessageEvent myMessageEvent){
        System.out.println("myEventBusMessage： MyMessageEvent");
        tv_result.setText(myMessageEvent.name);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = true)
    public void myEventBusMessage(String msg){
        System.out.println("myEventBusMessage： String");
        tv_result.setText(msg);
    }

}
