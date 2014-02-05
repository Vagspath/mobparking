package com.example.mobileapplicationapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	private String pinakides;
	private EditText editText1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText1 = (EditText) findViewById(R.id.editText1);	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		pinakides="";
		return true;
	}
	
	public void goToNewParkingRequest(View v){
		pinakides= editText1.getText().toString();
		 Bundle bundle=new Bundle();
		  Intent i = new Intent(MainActivity.this, MenuActivity.class);
		  bundle.putString("pinakides", pinakides);
		      i.putExtras(bundle);
		          startActivity(i);
		           finish();
	}

}
