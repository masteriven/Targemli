package com.contactlist.tal.targemli;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_splash_screen);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                    SplashScreen.this.startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    SplashScreen.this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    protected void onPause() {
        super.onPause();
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    protected void onStop() {
        super.onStop();
        finish();
    }
}
