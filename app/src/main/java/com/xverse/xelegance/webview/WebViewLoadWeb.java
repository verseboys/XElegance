package com.xverse.xelegance.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.xverse.xelegance.R;

public class WebViewLoadWeb extends Activity {
	WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.itms_webview);
		webView = (WebView)findViewById(R.id.wv_webview);
		loadWeb();
		//	loadHtmlData();
	}
	@SuppressLint({ "JavascriptInterface", "SetJavaScriptEnabled" })
	public void loadWeb(){
		String url = "http://192.168.1.108:8080/Exam";

		//String url = "https://www.baidu.com";
		//此方法可以在webview中打开链接而不会跳转到外部浏览器
		webView.setWebViewClient(new WebViewClient());
		webView.getSettings().setJavaScriptEnabled(true); //支持JavaScript
		webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);//关闭缓存
		webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);//不加上，会显示白边
		//webView.loadUrl("http://192.168.0.254/jQM_demo/22.html");

		webView.getSettings().setAllowFileAccess(true);
		//如果访问的页面中有Javascript，则webview必须设置支持Javascript

		//webView.getSettings().setUserAgentString(App.getUserAgent());

		webView.getSettings().setAppCacheEnabled(true);
		webView.getSettings().setDomStorageEnabled(true);
		webView.getSettings().setDatabaseEnabled(true);
		webView.getSettings().setBlockNetworkImage(false);//解决图片不显示
		webView.getSettings().setSupportZoom(false);//是否缩放
   //手势点击缩放禁止
		webView.getSettings().setBuiltInZoomControls(false);
		webView.getSettings().setSupportZoom(false);
		webView.getSettings().setDisplayZoomControls(false);
		webView.loadUrl(url);
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//重写onKeyDown，当浏览网页，WebView可以后退时执行后退操作。
		if(keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()){
			webView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	public void loadHtmlData(){
		String data = "<html>"
				+ "<head>"
				+ "<title>欢迎您</title>"
				+ "</head>"
				+ "<body>"
				+ "<p>我是一段html代码</p>"
				+ "</body>"
				+ "</html>";
		webView.setWebViewClient(new WebViewClient());
		//使用简单的loadData()方法总会导致乱码，有可能是Android API的Bug
		//webView.loadData(data, "text/html", "GBK");
		webView.loadDataWithBaseURL(null, data, "text/html", "utf-8", null);
	}
}
