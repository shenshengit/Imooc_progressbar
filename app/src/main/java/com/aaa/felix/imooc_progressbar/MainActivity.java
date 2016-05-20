package com.aaa.felix.imooc_progressbar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.aaa.felix.imooc_progressbar.view.HorizontalProgressbarWithProgress;

public class MainActivity extends AppCompatActivity {

    private HorizontalProgressbarWithProgress p1;

    private static final int MSG_UPDATE = 0X110;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int progress = p1.getProgress();
            p1.setProgress(++progress);
            if (progress >= 100) {
                handler.removeMessages(MSG_UPDATE);
            }
            handler.sendEmptyMessageDelayed(MSG_UPDATE, 100);
        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1 = (HorizontalProgressbarWithProgress) findViewById(R.id.my1);
        handler.sendEmptyMessage(MSG_UPDATE);
    }
}
