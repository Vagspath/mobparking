package com.example.mobileapplicationapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.json.JSONStringer;

import android.os.AsyncTask;
import android.util.Log;

class CustomAsyncTask extends AsyncTask{
	//{"duration":5,"timeOfEntrance":"2012-12-12" ,"timeOfExit":"2012-12-12","customer":"vaggelis","carLicence":"eez","cost":12.2,"payed":"true"}
	private final String SERVICE_URI = "http://192.168.1.2:8080/MobParkingBackEnd/api/parking";
	@Override
	protected Object doInBackground(Object... arg0) {
        try {
        	Log.d("trying to call web service ", "none");
               // make web service connection
               HttpPost request = new HttpPost(SERVICE_URI + "");
               request.setHeader("Accept", "application/json");
               request.setHeader("Content-type", "application/json");
               // Build JSON string
               Date d = new Date();
              
              //Log.d("****servitoros****", "a");
            //   Log.d("****paraggelia ",paraggelia[2] );
               //Log.d("**** arOmprelas ",omprela);
               //Log.d("**** poso ",100+"");

              JSONStringer TestApp = new JSONStringer().object().key("duration").value(5).endObject();
               
               StringEntity entity = new StringEntity(TestApp.toString(), HTTP.UTF_8);
          
            
               request.setEntity(entity);
               // Send request to WCF service
               DefaultHttpClient httpClient = new DefaultHttpClient();
               HttpResponse response = httpClient.execute(request);
               Header[] headers = response.getAllHeaders();
               String h="";
           	for (Header header : headers) {
           		h += "Key : " + header.getName() 
           		      + " ,Value : " + header.getValue()+"\n";
           	}
           	//Toast.makeText(getApplicationContext(), "msg msg",3500).show();
               // Get the status of web service
           	Log.d("headers from pc " , h);
           	BufferedReader rd = new BufferedReader(new InputStreamReader(
                            response.getEntity().getContent()));
               // print status in log
              
           

        } catch (Exception ee){ 
        	Log.d("exception leme" , "n");
        	System.exit(0);
        	;}
        
		return null;
	}
	
}
