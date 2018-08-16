package com.contactlist.tal.targemli;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView title;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        this.title = (TextView) findViewById(R.id.title);
        this.title.setTypeface(Typeface.createFromAsset(getAssets(), "Dorian.ttf"));
    }

    public void BasicWords(View view) {
        startActivity(new Intent(this, BasicWords.class));
    }

    public void DailyWords(View view) {
        startActivity(new Intent(this, DailyWords.class));
    }

    public void AdvancedWords(View view) {
        startActivity(new Intent(this, AdvancedWords.class));
    }

    public void LiteraryWords(View view) {
        startActivity(new Intent(this, LiteraryWords.class));
    }

    protected void onPause() {
        super.onPause();
        AdvancedWords.newsGame = true;
    }

    protected void onStop() {
        super.onStop();
        AdvancedWords.newsGame = true;
    }

    protected void onDestroy() {
        super.onDestroy();
        AdvancedWords.newsGame = true;
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
