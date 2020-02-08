package com.example.random;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class startActivity extends Activity {

    private static int time = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        MyThread myThread = new MyThread();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(startActivity.this, MainActivity.class);
                startActivity.this.startActivity(mainIntent);
                startActivity.this.finish();
            }
        }, time);
    }

    public class MyThread extends Thread {
        // Конструктор
        MyThread() {
            // Создаём новый поток
            super("Второй поток");
            start(); // Запускаем поток
        }

        public void run() {
            ProgressBar pb = (ProgressBar)findViewById(R.id.progressBar);
            TextView tv = (TextView)findViewById(R.id.numbers);
            try {
                for (int i = 100; i > 0; i--) {
                    long n;
                    n = (long)(100000000+(Math.random()*999999999));
                    tv.setText(Long.toString(n));
                    pb.setProgress(100-i);
                    Thread.sleep(time/100);
                }

            } catch (InterruptedException e) {
            }
        }
    }
}
