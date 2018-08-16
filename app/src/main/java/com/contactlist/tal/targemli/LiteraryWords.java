package com.contactlist.tal.targemli;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;

public class LiteraryWords extends AppCompatActivity {
    static boolean newsGame;
    String[] answerLiterary;
    GridView gridView;
    String[] literaryWords;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_literary_words);
        this.gridView = (GridView) findViewById(R.id.gri);
        Resources res = getResources();
        this.literaryWords = res.getStringArray(R.array.LiteraryWords);
        this.answerLiterary = res.getStringArray(R.array.LiteraryWordsAnswers);
        this.gridView.setAdapter(new WordsAdapter(this, this.literaryWords, this.answerLiterary));
    }

    public void go(View view) {
        Intent intent = new Intent(this, LiteraryTestScreen.class);
        newsGame = true;
        startActivity(intent);
    }
}
