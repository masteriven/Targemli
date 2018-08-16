package com.contactlist.tal.targemli;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;

public class DailyWords extends AppCompatActivity {
    public static boolean newsGame;
    String[] answerDaily;
    String[] dailyWords;
    GridView gridView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_daily_words);
        this.gridView = (GridView) findViewById(R.id.gri);
        Resources res = getResources();
        this.dailyWords = res.getStringArray(R.array.dailyWords);
        this.answerDaily = res.getStringArray(R.array.dailyWordsAnswers);
        this.gridView.setAdapter(new WordsAdapter(this, this.dailyWords, this.answerDaily));
    }

    public void gos(View view) {
        Intent intent = new Intent(this, DailyTestScreen.class);
        newsGame = true;
        startActivity(intent);
    }
}
