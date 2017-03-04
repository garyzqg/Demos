package com.example.administrator.demos.ui;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.administrator.demos.R;
import com.example.administrator.demos.adapter.ListRecyclerAdapter;
import com.example.administrator.demos.behavior.ScaleDownShowBehavior;

import java.util.ArrayList;
import java.util.List;

public class ZhihuActivity extends AppCompatActivity {

    private FloatingActionButton FAB;

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private BottomSheetBehavior mBottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhihu);

        //toolbar使用
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);//使RecyclerView保持固定的大小，该信息被用于自身的优化
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("我是第" + i + "个item");
        }
        linearLayoutManager = new LinearLayoutManager(this);
        //是否启用平滑滚动
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        ListRecyclerAdapter adapter = new ListRecyclerAdapter(list);
        recyclerView.setAdapter(adapter);
        //FloatingActionButton
        FAB = (FloatingActionButton) findViewById(R.id.fab);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar
                Snackbar.make(FAB, "点我干啥", Snackbar.LENGTH_SHORT).show();
            }
        });

        //获取ScaleDownShowBehavior对象,必须通过from获取behavior!!!所以自定义ScaleDownShowBehavior时要定义from()方法
        ScaleDownShowBehavior scaleDownShowFab = ScaleDownShowBehavior.from(FAB);
        scaleDownShowFab.setOnStateChangedListener(onStateChangedListener);

        //获取BottomSheetBehavior对象,必须通过from()!!!!
        mBottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.tab_layout));
    }


    private ScaleDownShowBehavior.OnStateChangedListener onStateChangedListener =
            new ScaleDownShowBehavior.OnStateChangedListener() {
        @Override
        public void onChanged(boolean isShow) {
            mBottomSheetBehavior.setState(isShow ? BottomSheetBehavior.STATE_EXPANDED : BottomSheetBehavior.STATE_COLLAPSED);
        }
    };

    private boolean initialize = false;
    //页面初始化好后显示Tab导航(添加了BottomSheetBehavior属性的View，默认是隐藏的)
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (!initialize) {
            initialize = true;
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }
    //点击toolbar返回键finish
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
}