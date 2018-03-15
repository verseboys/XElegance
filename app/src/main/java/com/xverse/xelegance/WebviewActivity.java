package com.xverse.xelegance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.xverse.xelegance.common.BaseActivity;
import com.xverse.xelegance.webview.WebViewLoadHtml;
import com.xverse.xelegance.webview.WebViewLoadWeb;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebviewActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);
    }

    @Override
    @OnClick({R.id.bu_load_web, R.id.bu_load_html})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.bu_load_web:
                Toast.makeText(this, "你按到我了啦1!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, WebViewLoadWeb.class);
                startActivity(intent);

                break;
            case R.id.bu_load_html:
                intent = new Intent(this, WebViewLoadHtml.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    protected void initView() {

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
