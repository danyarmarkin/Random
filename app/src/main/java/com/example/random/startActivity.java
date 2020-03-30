package com.example.random;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class startActivity extends Activity {

    private static int time = 2500,p;
    public  TextView tv;
    public  ProgressBar pb;
    public static String t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        tv = findViewById(R.id.numbers);
        pb = findViewById(R.id.progressBar);

        MyThread myThread = new MyThread();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(startActivity.this, MainActivity.class);
                startActivity.this.startActivity(mainIntent);
                startActivity.this.finish();
            }
        }, time+300);
    }

    public class MyThread extends Thread {

        // Конструктор
        MyThread() {
            // Создаём новый поток
            super("Второй поток");
            start(); // Запускаем поток
        }

        public void run() {
            try {
                for (int i = 100; i > 0; i--) {
                    int n = (int) (100000+(Math.random()*999999));
                    t = Integer.toString(n);
                    p = 100-i;
                    setText();
                    Thread.sleep(time/100);
                }
                p=100;
                t="239 8-4";
                setText();
                Thread.sleep(300);

            } catch (InterruptedException e) {
            }
        }
    }

    public void setText(){
        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                tv.setText(t);
                pb.setProgress(p);

            }
        });

    }
}
