package com.example.mobileapplicationapp;


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class ParkingRequest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_request);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.parking_request, menu);
        return true;
    }
    
    @SuppressWarnings("unchecked")
 	public  void callWebService(View view) {
     	String resp="";
     	Log.d(" call web service method ", "none");
     	//resp = (String) textView01.getText();
     //	if(!(resp).equals(""))
     	{CustomAsyncTask c = new CustomAsyncTask();
     	c.execute(new String[] {resp  });
     	}
     	// finish();
 }
         
    
}
