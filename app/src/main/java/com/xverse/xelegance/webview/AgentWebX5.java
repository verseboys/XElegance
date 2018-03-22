package com.xverse.xelegance.webview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.DefaultWebClient;
import com.xverse.xelegance.R;
import com.xverse.xelegance.common.BaseActivity;

/**
 * Created by Administrator on 2018/3/22 0022.
 */

public class AgentWebX5 extends BaseActivity {
    protected AgentWeb mAgentWeb;
    private LinearLayout mLinearLayout;
    private TextView mTitleTextView;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String url = "http://192.168.1.108:8080/Exam";

        setContentView(R.layout.activity_web);
        mLinearLayout = (LinearLayout) this.findViewById(R.id.container);
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent((mLinearLayout) , new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
                .useDefaultIndicator(-1, 3)

                .setWebViewClient(mWebViewClient)
                .setWebChromeClient(mWebChromeClient)

                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)

                .setMainFrameErrorView(R.layout.agentweb_error_page, -1)

                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.DISALLOW)
                .interceptUnkownUrl()
                .createAgentWeb()
                .ready()
                .go(url);
    }

    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            //do you  work
            Log.i("Info", "BaseWebActivity onPageStarted");
        }
    };
    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            //do you work
//            Log.i("Info","onProgress:"+newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            if (mTitleTextView != null) {
                mTitleTextView.setText(title);
            }
        }
    };

    @Override
    public void onClick(View view) {
        super.onClick(view);
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
