package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01SecondaryActivity extends Activity {

	protected EditText editText;
	protected Button buttonOk, buttonCancel;
	
	protected ButtonClickListener buttonListener = new ButtonClickListener();
	
	protected class ButtonClickListener implements Button.OnClickListener {

		@Override
		public void onClick(View view) {
			switch(view.getId()) {
			case R.id.button_ok:
				setResult(RESULT_OK, new Intent());
				finish();
				break;
			case R.id.button_cancel:
				setResult(RESULT_CANCELED, new Intent());
				finish();
				break;
			}
			
		}
	}	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_secondary);
		
		editText = (EditText) findViewById(R.id.edit_text);
		
		Intent intent = getIntent();
		if (intent != null) {
			String no = intent.getStringExtra("no_of_clicks");
			if(no != null) {
				editText.setText(no.toString());
			}
		}
		
		
		buttonOk =  (Button) findViewById(R.id.button_ok);
		buttonCancel =  (Button) findViewById(R.id.button_cancel);
		
		buttonOk.setOnClickListener(buttonListener);
		buttonCancel.setOnClickListener(buttonListener);
			
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_secondary, menu);
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
