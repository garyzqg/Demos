package com.example.administrator.demos.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.demos.R;

public class ElemeSearchActivity extends AppCompatActivity {
    private TextView mSearchBGTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleme_search);

        mSearchBGTxt = (TextView) findViewById(R.id.tv_search_bg);

        mSearchBGTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击跳转
                Intent intent = new Intent(ElemeSearchActivity.this,SearchActivity.class);
                int location[] = new int[2];
                //获取控件在屏幕的位置
                mSearchBGTxt.getLocationOnScreen(location);
                intent.putExtra("x",location[0]);
                intent.putExtra("y",location[1]);
                System.out.println("坐标" + location[0] + "  " + location[1]);
                startActivity(intent);
                //Activity的切换动画 0表示没有动画
                overridePendingTransition(0,0);
            }
        });
    }
}
