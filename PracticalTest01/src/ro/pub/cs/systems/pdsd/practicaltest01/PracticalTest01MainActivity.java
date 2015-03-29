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


public class PracticalTest01MainActivity extends Activity {

	protected EditText editTextLeft, editTextRight;
	protected Button buttonLeft, buttonRight, navigateButton;
	
	protected ButtonClickListener b = new ButtonClickListener();
	
	protected class ButtonClickListener implements Button.OnClickListener {

		@Override
		public void onClick(View view) {
			switch(view.getId()) {
			case R.id.button_left:
				editTextLeft.setText(String.valueOf(Integer.parseInt(editTextLeft.getText().toString()) + 1));
				break;
			case R.id.button_right:
				editTextRight.setText(String.valueOf(Integer.parseInt(editTextRight.getText().toString()) + 1));
				break;
			
			case R.id.navigate_button:
				Intent i = new Intent("ro.pub.cs.systems.pdsd.intent.action.Secondary");
				i.putExtra("no_of_clicks", String.valueOf(Integer.parseInt(editTextLeft.getText().toString()) + Integer.parseInt(editTextRight.getText().toString())));
				
				startActivityForResult(i,1);
				break;
			}	
			
		}
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
              
        editTextLeft = (EditText)findViewById(R.id.edit_text_left);
        editTextRight = (EditText)findViewById(R.id.edit_text_right);
        
        editTextLeft.setText(String.valueOf(0));
        editTextRight.setText(String.valueOf(0));   
        
        buttonLeft = (Button) findViewById(R.id.button_left);
        buttonRight = (Button) findViewById(R.id.button_right);
        navigateButton = (Button) findViewById(R.id.navigate_button);
        
        buttonLeft.setOnClickListener(b);
        buttonRight.setOnClickListener(b);
        navigateButton.setOnClickListener(b);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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
    
    @Override
    public void onSaveInstanceState(Bundle saved) {
    	saved.putString("leftEditText", editTextLeft.getText().toString());
    	saved.putString("rightEditText", editTextRight.getText().toString());   	
    	
    }
    
    @Override
    public void onRestoreInstanceState(Bundle restored) {    
    	editTextLeft.setText(restored.get("leftEditText").toString());
    	editTextRight.setText(restored.get("rightEditText").toString());
    }
    
	  @Override
	  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    Toast.makeText(this, "The activity returned with result "+resultCode, Toast.LENGTH_LONG).show();
	  }
}
