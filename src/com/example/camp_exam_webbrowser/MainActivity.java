package com.example.camp_exam_webbrowser;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText textUrl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textUrl = (EditText) findViewById(R.id.text_url);
		textUrl.setOnKeyListener(new OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() != KeyEvent.ACTION_DOWN) {
					return false;
				}

				boolean processed = false;

				switch (keyCode) {
				case KeyEvent.KEYCODE_ENTER:
					Toast.makeText(
							MainActivity.this,
							textUrl.getText().toString() + ": "
									+ event.getAction(), Toast.LENGTH_SHORT)
							.show();

					processed = true;

					break;

				default:

					break;
				}

				return processed;
			}

		});
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
