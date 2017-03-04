package com.example.administrator.demos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.demos.ui.BezierActivity;
import com.example.administrator.demos.ui.ElemeSearchActivity;
import com.example.administrator.demos.ui.ZhihuActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.menu_btn01)
    Button menuZhihu;
    @BindView(R.id.menu_btn02)
    Button menuElemeSearch;
    @BindView(R.id.menu_btn03)
    Button menuBezier;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        addEvent();
    }

    private void addEvent() {
        menuZhihu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ZhihuActivity.class);
                startActivity(intent);
            }
        });
        menuElemeSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,ElemeSearchActivity.class);
                startActivity(intent);
            }
        });
        menuBezier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BezierActivity.class);
                startActivity(intent);
            }
        });
    }
}
