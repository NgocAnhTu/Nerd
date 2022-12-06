package com.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.nerd.R;

import java.util.ArrayList;

public class FeedbackAdapter extends BaseAdapter {
    Context context;
    String[] questionsList;
    LayoutInflater inflter;
    public static ArrayList<String> selectedAnswers;

    public FeedbackAdapter(Context applicationContext, String[] questionsList) {
        this.context = context;
        this.questionsList = questionsList;
        selectedAnswers = new ArrayList<>();
        for (int i = 0; i < questionsList.length; i++) {
            selectedAnswers.add("Chưa chọn câu trả lời");
        }
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return questionsList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.list_items_feedback, null);
        // get the reference of TextView and Button's
        TextView question = (TextView) view.findViewById(R.id.question);
        RadioButton hailong = (RadioButton) view.findViewById(R.id.hl);
        RadioButton khonghailong = (RadioButton) view.findViewById(R.id.khl);
        RadioButton rathailong = (RadioButton) view.findViewById(R.id.rathl);
        RadioButton ratkhonghailong = (RadioButton) view.findViewById(R.id.ratkhl);

        // perform setOnCheckedChangeListener event on yes button
        hailong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                if (isChecked)
                    selectedAnswers.set(i, "Hài lòng");
            }
        });
        // perform setOnCheckedChangeListener event on no button
        khonghailong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set No values in ArrayList if RadioButton is checked
                if (isChecked)
                    selectedAnswers.set(i, "Không hài lòng");

            }
        });
        // perform setOnCheckedChangeListener event on yes button
        rathailong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                if (isChecked)
                    selectedAnswers.set(i, "Rất hài lòng");
            }
        });
        // perform setOnCheckedChangeListener event on no button
        ratkhonghailong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set No values in ArrayList if RadioButton is checked
                if (isChecked)
                    selectedAnswers.set(i, "Rất không hài lòng");

            }
        });
        // set the value in TextView
        question.setText(questionsList[i]);
        return view;

    }
}
