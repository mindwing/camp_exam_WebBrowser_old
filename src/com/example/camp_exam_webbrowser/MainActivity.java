package com.example.camp_exam_webbrowser;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText textUrl;
	private WebView webView;
	private Button backButton, forwardButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		backButton = (Button) findViewById(R.id.back);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (webView.canGoBack()) {
					webView.goBack();
				} else {
					Toast.makeText(MainActivity.this, "맨 뒷페이지 입니다.",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
		forwardButton = (Button) findViewById(R.id.forward);

		textUrl = (EditText) findViewById(R.id.text_url);
		textUrl.setText("http://google.com");
		textUrl.setOnKeyListener(new OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() != KeyEvent.ACTION_DOWN) {
					return false;
				}

				boolean processed = false;

				switch (keyCode) {
				case KeyEvent.KEYCODE_ENTER:
					webView.loadUrl(textUrl.getText().toString());

					processed = true;

					break;

				default:

					break;
				}

				return processed;
			}

		});

		webView = (WebView) findViewById(R.id.webview);
		webView.setWebViewClient(new WebViewClient());
	}

	public void goForward(View view) {
		if (webView.canGoForward()) {
			webView.goForward();
		} else {
			Toast.makeText(MainActivity.this, "맨 앞페이지 입니다.", Toast.LENGTH_SHORT)
					.show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

}
