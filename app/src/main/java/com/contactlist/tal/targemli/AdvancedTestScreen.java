package com.contactlist.tal.targemli;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdvancedTestScreen extends AppCompatActivity {
    static int i =0;
    String[] answers;
    String[] englishWords;
    String name;
    EditText translate;
    TextView word;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_advanced_test_screen);
        this.word = (TextView) findViewById(R.id.Theword);
        this.word.setTypeface(Typeface.createFromAsset(getAssets(), "Filmcryptic.ttf"));
        this.translate = (EditText) findViewById(R.id.translate);
        Intent intent = getIntent();
        intent.getStringArrayExtra("advancedWordsContinue");
        this.translate.getBackground().setColorFilter(-1, Mode.SRC_IN);
        intent.getBooleanExtra("continueGame", false);
        if (AdvancedWords.newsGame) {
            basicWords();
        }
    }

    private String[] basicWords() {
        SharedPreferences sharedPreferences = getSharedPreferences("saveContinueGameAdvanced", 0);
        Resources res = getResources();
        this.englishWords = res.getStringArray(R.array.AdvancedWords);
        this.answers = res.getStringArray(R.array.AdvancedWordsAnswers);
        if (i == 0) {
            this.word.setText(this.englishWords[i]);
        } else {
            this.englishWords[i] = sharedPreferences.getString("saveKey", null);
            this.answers[i+1] = sharedPreferences.getString("anwerkey", null);
            this.word.setText(this.englishWords[i]);
        }
        return this.englishWords;
    }

    @SuppressLint("WrongConstant")
    public void check(View view) {
        if (AdvancedWords.newsGame) {
            SharedPreferences sharedPreferencess = getSharedPreferences("saveContinueGameAdvanced", 0);
            if (this.translate.getText().toString().trim().equals(this.answers[i])) {
                Toast.makeText(getApplicationContext(), "תשובה נכונה", 0).show();
                i = sharedPreferencess.getInt("saveint", i);
                TextView textView = this.word;
                String[] strArr = this.englishWords;
                textView.setText(strArr[i+=1]);
                if (i == 1 && AdvancedWords.newsGame) {
                    this.name = "המשך משחק";
                }
                this.translate.clearFocus();
                this.translate.getText().clear();
                sharedPreferencess = getSharedPreferences("saveContinueGameAdvanced", 0);
                Editor editor = sharedPreferencess.edit();
                editor.putString("anwerkey", this.answers[i+1]);
                editor.putInt("saveint", i);
                editor.putString("saveKey", this.englishWords[i]);
                editor.commit();
                if (i == 31) {
                    getIntent().putExtra("continu", false);
                    sharedPreferencess.edit().clear().apply();
                    this.word.setText("");
                    startActivity(new Intent(this, FinishScreen.class));
                    i = 0;
                    overridePendingTransition(0, 0);
                    this.translate.getText().toString().trim().equals(this.answers[i]);
                    finish();
                    onBackPressed();
                    return;
                }
                return;
            }
            Toast.makeText(getApplicationContext(), "תשובה שגויה נסה שנית", 0).show();
        }
    }
}
