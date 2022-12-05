package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.gvAdapter.ItemNotificationAdapter;

import java.util.ArrayList;

public class Notification extends AppCompatActivity {
    ListView lvNotification;
    ArrayList<com.example.model.Notifications> notifications;
    ItemNotificationAdapter notificationAdapter;
    ImageButton ibBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        linkView();
        initData();
        addEvents();
    }

    private void addEvents() {
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initData() {
        notifications = new ArrayList<>();
        notifications.add(new com.example.model.Notifications("Bạn còn 1 tiếng trước buổi học Ielts của giáo viên Trần Dần"));
        notifications.add(new com.example.model.Notifications("Còn 1 ngày nữa là hạn chót nộp bài viết Writing"));
        notifications.add(new com.example.model.Notifications("Tài khoản Premium của bạn đã được kích hoạt thành công"));
        notifications.add(new com.example.model.Notifications("Cảm ơn bạn đã đánh giá giảng viên. Những feedback của bạn là nguồn động lực để giúp Nerd phát triển hơn"));
        notifications.add(new com.example.model.Notifications("Giáo viên Tường Thanh đã update tài liệu sau buổi học ngày 28/11/2021. Chúc bạn học tập vui vẻ."));
        notifications.add(new com.example.model.Notifications("Giáo viên Trần Tùng đã update tài liệu sau buổi học ngày 1/11/2021. Chúc bạn học tập vui vẻ."));
        notificationAdapter = new ItemNotificationAdapter(this, notifications);
        lvNotification.setAdapter(notificationAdapter);
    }

    private void linkView() {
        lvNotification = findViewById(R.id.lv_Notification);
        ibBack = findViewById(R.id.imbBack);
    }

}