package com.example.administrator.demos.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.demos.R;
import com.example.administrator.demos.view.DragBubbleView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BezierActivity extends AppCompatActivity {
    DragBubbleView mDragBubbleView;
    @BindView(R.id.reCreateBtn)
    Button reCreateBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier);
        ButterKnife.bind(this);
        mDragBubbleView = (DragBubbleView) findViewById(R.id.dragBubbleView);
        init();
    }

    private void init() {
        mDragBubbleView.setText("99+");
        mDragBubbleView.setOnBubbleStateListener(new DragBubbleView.OnBubbleStateListener() {
            @Override
            public void onDrag() {
                Log.e("---> ", "拖拽气泡");
            }

            @Override
            public void onMove() {
                Log.e("---> ", "移动气泡");
            }

            @Override
            public void onRestore() {
                Log.e("---> ", "气泡恢复原来位置");
            }

            @Override
            public void onDismiss() {
                Log.e("---> ", "气泡消失");
            }
        });

        reCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDragBubbleView.reCreate();
            }
        });
    }
}
