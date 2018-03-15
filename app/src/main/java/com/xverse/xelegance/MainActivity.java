package com.xverse.xelegance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.xverse.xelegance.common.BaseActivity;
import com.xverse.xelegance.webview.WebViewLoadWeb;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bt_webview)
    Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override//多事件绑定
    @OnClick({R.id.bt_webview, R.id.tv_text2, R.id.tv_text3, R.id.tv_text4})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.bt_webview:
                Toast.makeText(this, "你按到我了啦1!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, WebviewActivity.class);
                startActivity(intent);

                break;
//            case :
////            intent = new Intent(this, WebViewLoadHtml.class);
////            startActivity(intent);
//            break;
        }
    }


    @Override
    protected void initView() {

        //mButton.setOnClickListener(this);

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void processClick(View view) {

    }
}
