package com.example.nerd;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ThoiKhoaBieu extends AppCompatActivity {
    CompactCalendarView compactCalendar;
    SimpleDateFormat dateFormatMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thoi_khoa_bieu);

       ImageButton imbBack = findViewById(R.id.imbBack);
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(null);

        compactCalendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);

        dateFormatMonth = new SimpleDateFormat("MMMM - yyyy", Locale.getDefault());

        compactCalendar.setCurrentDayBackgroundColor(Color.LTGRAY);

        //set lịch học tháng 12 thứ 4,6
        Event ev1 = new Event(Color.RED, 1669972519000L, "");
        compactCalendar.addEvent(ev1);
        Event ev2 = new Event(Color.RED, 1670404519000L, "");
        compactCalendar.addEvent(ev2);
        Event ev3 = new Event(Color.RED, 1670577319000L, "");
        compactCalendar.addEvent(ev3);
        Event ev4 = new Event(Color.RED, 1671009319000L, "");
        compactCalendar.addEvent(ev4);
        Event ev5 = new Event(Color.RED, 1671182119000L, "");
        compactCalendar.addEvent(ev5);
        Event ev6 = new Event(Color.RED, 1671614119000L, "");
        compactCalendar.addEvent(ev6);
        Event ev7 = new Event(Color.RED, 1671786919000L, "");
        compactCalendar.addEvent(ev7);
        Event ev8 = new Event(Color.RED, 1672218919000L, "");
        compactCalendar.addEvent(ev8);
        Event ev9 = new Event(Color.RED, 1672391719000L, "");
        compactCalendar.addEvent(ev9);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
            }
        });
    }
}