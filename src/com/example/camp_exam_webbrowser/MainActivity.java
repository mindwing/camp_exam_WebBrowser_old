// package 는 소스파일이 위치하는 디렉토리를 지정하는 것이라고 생각하세요.
// .java 소스파일이 저장되는 고유의 저장공간이라고 생각하면 쉽습니다.
package com.example.camp_exam_webbrowser;

// import 는 필요한 라이브러리들을 가져오는 기능을 합니다.
// 소문자로 되어 있는 부분들은 package 이며, 맨 마지막에 대문자로 시작하는 부분은 .class 파일의 이름입니다.
// .class 는 .java 소스파일을 안드로이드가 해석하기 쉽도록 안드로이드 언어로 번역한 파일입니다.
// 그와 단대로 .java 파일은 인간이 비교적 알아보기 더 쉬운 언어인 것을 생각하시면 됩니다.
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

// 우리가 만들 소스코드 파일이름은 MainActivity.java 이며, 안드로이드용으로 해석되면 MainActivity.class 파일이 생성됩니다.
// .class 파일이 생성되는 과정은 자동으로 이루어지므로, 우리는 소스코드에만 집중하면 됩니다.
// "extends Activity" 라는 부분을 잘 보세요.
// 이것은 Activity.class 파일을 가져다가 쓰겠다는 뜻입니다.
// 맨 앞의 public 은 어떤 다른 소스코드에서라도 MainActivity 를 extends 해서 쓸 수 있도록 해주겠다는 뜻입니다.
public class MainActivity extends Activity {

	// EditText 는 
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
