package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.adapters.DetailNewsAdapter;
import com.example.adapters.NewsAdapter;
import com.example.model.MDNews;
import com.example.model.MNews;
import com.example.nerd.databinding.ActivityChitietblogBinding;
import com.example.nerd.databinding.ActivityNewsBinding;

import java.util.ArrayList;

public class news extends AppCompatActivity {
    ListView lvNews;
    ImageView imvBack;
    ActivityNewsBinding binding;
    NewsAdapter adapter;
    ArrayList<MNews> newsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        binding = ActivityNewsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        linkview();
        loadData();
        setEvents();
    }

    private void linkview() {
        lvNews = findViewById(R.id.lv_News);
        imvBack = findViewById(R.id.imv_back);
    }

    private void loadData() {
        newsList = new ArrayList<>();
        newsList.add(new MNews(R.drawable.nerd17,"TỔNG HỢP CÁC CÂU HỎI PHỎNG VẤN DU HỌC BẰNG TIẾNG ANH THEO TỪNG CHỦ ĐỀ", "Nếu muốn đi du học tại các quốc gia châu Âu, đặc biệt là Mỹ thì xin visa là một trong những công đoạn tiên quyết vô cùng quan trọng. Lúc này, đương đơn sẽ phải trực tiếp đối mặt với viên chức lãnh sự quán, trả lời các câu hỏi giám khảo đưa ra một cách thành thực nhất để chứng minh được tấm lòng ham học hỏi và ý chí kiên định quay trở về quê hương làm việc, cống hiến của bản thân. " ));
        newsList.add(new MNews(R.drawable.nerd18,"NÊN TRẢ LỜI PHỎNG VẤN DU HỌC BẰNG TIẾNG ANH HAY TIẾNG VIỆT?",  "Biết được rằng xin visa đi Mỹ có thể sử dụng tiếng Việt với nhân viên Lãnh sự quán, rất nhiều thí người chưa tự tin vào khả năng giao tiếp của mình băn khoăn trong đầu rằng có nên trả lời phỏng vấn du học bằng tiếng Anh hay không? Cùng Nerd giải đáp câu hỏi đó trong bài viết sau nhé!"));
        newsList.add(new MNews(R.drawable.nerd19,"3 “TUYỆT CHIÊU” LUYỆN NGHE TIẾNG ANH CẤP TỐC CHO NGƯỜI DU HỌC", "Luyện nghe tiếng Anh cấp tốc cho người du học là một vấn đề được nhiều người quan tâm. Lý do vì kỹ năng nghe thường khó nhằn, khó chinh phục và khiến người học phải dành nhiều thời gian lẫn công sức để tập trung rèn luyện. Cùng Nerd khám phá 3 tuyệt chiêu giúp bạn nhanh chóng cải thiện trình độ nghe hiểu tiếng Anh cực kỳ thú vị trong bài viết sau nhé!"));
        newsList.add(new MNews(R.drawable.nerd20,"6 YẾU TỐ QUYẾT ĐỊNH HỌC TIẾNG ANH GIAO TIẾP CẤP TỐC Ở ĐÂU TỐT?", "Giữa thị trường tràn lan các cơ sở giáo dục, các trung tâm ngoại ngữ mọc lên như nấm, câu hỏi học tiếng Anh giao tiếp cấp tốc ở đâu tốt là băn khoăn của rất nhiều người đang có nhu cầu nâng cao khả năng bản thân trong thời gian ngắn. Cùng khám phá 7 yếu tố ảnh hưởng tới quyết định lựa chọn trung tâm phù hợp trong bài viết sau nhé!"));
        newsList.add(new MNews(R.drawable.nerd21,"DẠY TIẾNG ANH CẤP TỐC CHO NGƯỜI MẤT GỐC – ĐỔI ĐỜI CHỈ SAU VÀI TUẦN HỌC", "Với những người mất gốc tiếng Anh thì việc phải bắt đầu học tiếng Anh lại từ đầu chẳng khác nào cực hình. Nhưng với việc dạy tiếng Anh cấp tốc tại English Town, việc học tiếng Anh sẽ trở nên đơn giản hơn bạn nghĩ! Vậy lý do là gì? Hãy cùng Nerd tìm hiểu trong bài viết dưới đây nhé!"));

        //Init apdater
        adapter = new NewsAdapter(news.this, R.layout.activity_item_list, newsList);
        binding.lvNews.setAdapter(adapter);


    }

    private void setEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lvNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(news.this, Blog.class);
                startActivity(intent);
            }
        });
    }

}