package com.contactlist.tal.targemli;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class FinishScreen extends AppCompatActivity {
    static boolean finishExam = false;
    TextView finishText;
    TextView textView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_finish_screen);
        this.textView = (TextView) findViewById(R.id.finishWord);
        this.finishText = (TextView) findViewById(R.id.textFinish);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "Dorian.ttf");
        this.textView.setTypeface(myTypeface);
        this.finishText.setTypeface(myTypeface);
        finishExam = true;
    }

    public void newGame(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void onBackPressed() {
        super.onBackPressed();
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

    protected void onPause() {
        super.onPause();
        finish();
    }
}
