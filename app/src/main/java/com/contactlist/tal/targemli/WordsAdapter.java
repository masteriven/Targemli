package com.contactlist.tal.targemli;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class WordsAdapter extends BaseAdapter {
    String[] answers;
    Context context;
    String[] englishWords;
    LayoutInflater inflater;

    static class Wordholder {
        TextView textView;
        TextView textViewanswer;

        Wordholder() {
        }
    }

    public WordsAdapter(Context context, String[] englishWords, String[] answers) {
        this.context = context;
        this.englishWords = englishWords;
        this.answers = answers;
    }

    public Object getItem(int position) {
        return Integer.valueOf(this.englishWords.length);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public int getCount() {
        return this.englishWords.length;
    }

    @SuppressLint("WrongConstant")
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Wordholder wordholder = new Wordholder();
        if (convertView == null) {
            this.inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            view = this.inflater.inflate(R.layout.words_inflater, parent, false);
        } else {
            view = convertView;
        }
        wordholder.textView = (TextView) view.findViewById(R.id.mySelectionn);
        wordholder.textViewanswer = (TextView) view.findViewById(R.id.textviewWordAnswer);
        wordholder.textView.setText(this.englishWords[position]);
        wordholder.textViewanswer.setText(this.answers[position]);
        wordholder.textView.setTypeface(Typeface.createFromAsset(this.context.getAssets(), "Filmcryptic.ttf"));
        if (position == 31) {
            wordholder.textView.setText("");
            wordholder.textViewanswer.setText("");
        }
        return view;
    }
}
