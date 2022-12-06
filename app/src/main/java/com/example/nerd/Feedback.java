package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.adapters.FeedbackAdapter;

public class Feedback extends AppCompatActivity {

    ListView simpleList;
    String[] questions;
    Button submit;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        linkview();


// get the string array from string.xml file
        questions = getResources().getStringArray(R.array.questions);

        // get the reference of ListView and Button
        simpleList = (ListView) findViewById(R.id.simpleListView);
        submit = (Button) findViewById(R.id.btn_feedback_gv);

        // set the adapter to fill the data in the ListView
        FeedbackAdapter adapter = new FeedbackAdapter(getApplicationContext(), questions);
        simpleList.setAdapter(adapter);

        // perform setOnClickListerner event on Button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i == FeedbackAdapter.selectedAnswers.size(); i++) {
                    rg.clearCheck();
                    Toast.makeText(Feedback.this, "Cảm ơn bạn đã thực hiện khảo sát", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(Feedback.this, "Bạn chưa trả lời hết các câu", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void linkview() {
        rg = findViewById(R.id.rdg_danhgia);
    }



}