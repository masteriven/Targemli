package com.contactlist.tal.targemli;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

public class AdvancedWords extends AppCompatActivity {
    public static boolean newsGame = false;
    String[] advancedWords;
    String[] answerAdvanced = null;
    Button go;
    GridView gridView;
    Handler handler;
    int i;
    Runnable runnable;
    Thread thread;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_advanced_words);
        this.gridView = (GridView) findViewById(R.id.gri);
        Resources res = getResources();
        go = findViewById(R.id.go);
        this.advancedWords = res.getStringArray(R.array.AdvancedWords);
        this.answerAdvanced = res.getStringArray(R.array.AdvancedWordsAnswers);
        this.gridView.setAdapter(new WordsAdapter(this, this.advancedWords, this.answerAdvanced));
        if (FinishScreen.finishExam) {
            this.go.setText("התחל משחק");
        }
    }

    public void go(View view) {
        startActivity(new Intent(this, AdvancedTestScreen.class));
        this.handler = new Handler();
        newsGame = true;
    }
}
