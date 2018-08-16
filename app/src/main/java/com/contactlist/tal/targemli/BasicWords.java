package com.contactlist.tal.targemli;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;

public class BasicWords extends AppCompatActivity {
    static boolean newsGame;
    String[] answerBasic;
    String[] basicWords;
    GridView gridView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_words);
        Resources res = getResources();
        this.basicWords = res.getStringArray(R.array.basicWords);
        this.answerBasic = res.getStringArray(R.array.basicWordsAnswers);
        this.gridView = (GridView) findViewById(R.id.gri);
        this.gridView.setAdapter(new WordsAdapter(this, this.basicWords, this.answerBasic));
    }

    public void go(View view) {
        Intent intent = new Intent(this, BasicTestScreen.class);
        newsGame = true;
        startActivity(intent);
    }
}
