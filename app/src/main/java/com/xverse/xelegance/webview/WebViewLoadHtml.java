package com.xverse.xelegance.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.xverse.xelegance.R;

/**
 * @author Administrator
 */
public class WebViewLoadHtml extends Activity {
	private String url;
	WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//将屏幕设置为全屏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		//去掉标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.itms_webview);
		webView = (WebView)findViewById(R.id.wv_webview);

//		WebSettings webSettings = webView.getSettings();
//		webSettings.setJavaScriptEnabled(true);
//
//		webSettings.setAppCacheEnabled(false);
//		webSettings.setBuiltInZoomControls(false);
//		webSettings.setUseWideViewPort(true);
//		webSettings.setLoadWithOverviewMode(true);
//		webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//		webView.loadUrl(url);




		url = "file:///android_asset/guide/index.html";
		loadLocalHtml(url);
	}

	@SuppressLint({ "JavascriptInterface", "SetJavaScriptEnabled" })
	public void loadLocalHtml(String url){
		WebSettings ws = webView.getSettings();
		ws.setJavaScriptEnabled(true);
		ws.setBuiltInZoomControls(true);
		ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
		ws.setUseWideViewPort(true);
		ws.setLoadWithOverviewMode(true);

		ws.setSaveFormData(true);
		// enable navigator.geolocation
		ws.setJavaScriptEnabled(true);
		ws.setGeolocationEnabled(true);
		// enable Web Storage: localStorage, sessionStorage
		ws.setGeolocationDatabasePath("/data/data/org.itri.html5webview/databases/");
		ws.setDomStorageEnabled(true);
		webView.requestFocus();

		//开启JavaScript支持
		webView.setWebViewClient(new WebViewClient(){
			@Override
			//该方法返回值必须为false,否则html上所有的超链接失效
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				//重写此方法，用于捕捉页面上的跳转链接
//				if ("AED.html".equals(url)){
//					//在html代码中的按钮跳转地址需要同此地址一致
//					Toast.makeText(getApplicationContext(), "开始体验", Toast.LENGTH_SHORT).show();
//					finish();
//				}
				return false;
			}
		});
		webView.loadUrl(url);


		webView.setWebChromeClient(new WebChromeClient(){

		});
	}
}
