package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDeatilActivity extends AppCompatActivity {
    String title,desc,content,imageURL,url;
    private TextView titleTV,contentTV;
    private ImageView newIV;
    private Button readNewsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_deatil);
        title = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("description");
        content = getIntent().getStringExtra("content");
        imageURL = getIntent().getStringExtra("image");
        url = getIntent().getStringExtra("url");
        titleTV=findViewById(R.id.idTVTitle);
        contentTV=findViewById(R.id.idContent);
        newIV=findViewById(R.id.idIVNews);
        readNewsBtn=findViewById(R.id.idBtnReadNews);
        titleTV.setText(title);
        contentTV.setText(content);
        Picasso.get().load(imageURL).into(newIV);
        readNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}