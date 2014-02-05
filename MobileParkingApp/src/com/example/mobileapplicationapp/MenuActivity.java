package com.example.mobileapplicationapp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

		 final ListView listview = (ListView) findViewById(R.id.listView1);
		    String[] values = new String[] { "Αίτηση παρκαρίσματος", "τίποτα", "έξοδος"};
		    final ArrayList<String> list = new ArrayList<String>();
		    for (int i = 0; i < values.length; ++i) {
		      list.add(values[i]);
		    }
		    final StableArrayAdapter adapter = new StableArrayAdapter(this,
			        android.R.layout.simple_list_item_1, list);
			    listview.setAdapter(adapter);

			    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			 public void onItemClick(AdapterView<?> parent, final View view,
			          int position, long id) {

						
					
						final String item = (String) parent.getItemAtPosition(position);
											
						if(item.equals("Αίτηση παρκαρίσματος")){
							ClickParkingRequest();
						}
						else if(item.equals("τίποτα"))ClickParkingRequest();
						else if(item.equals("έξοδος"))ClickParkingRequest();
				
						
						
		  
		}
		
		 public void ClickParkingRequest()
		    {
			 Bundle bundle=new Bundle();
			  Intent i = new Intent(MenuActivity.this, ParkingRequest.class);
			  
			   // bundle.putStringArray("paraggelia", paraggelia);
			   //i.putExtras(bundle);
			            startActivity(i);
			        

		    }

	
		
			    });
		
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    
    
    
    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
            List<String> objects) {
          super(context, textViewResourceId, objects);
          for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), i);
          }
        }

        @Override
        public long getItemId(int position) {
          String item = getItem(position);
          return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
          return true;
        }

      
    }
    
}
