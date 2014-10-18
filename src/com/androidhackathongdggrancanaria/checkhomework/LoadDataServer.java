package com.androidhackathongdggrancanaria.checkhomework;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import com.google.gson.Gson;

public class LoadDataServer implements LoadData {
	ArrayList<Task> res;
	@Override
	public ArrayList<Task> loadTasks() {
		new RequestTaskToserver().execute();
		return res;
		
	}
	
	private class RequestTaskToserver extends AsyncTask<String, Void, String> {

        private static final String SERVER_URL = "http://hackhomework.appspot.com/api/task?parentID=%22parentID1%22";

		@Override
        protected String doInBackground(String... params) {
        	//pillar json
        	String json = getJSONFromServer();
        	//gson get arraylist
        	Gson gson = new Gson();
        	
        	res = gson.fromJson(json, Response.class).getTasks();
        	//poner array list en res
            return "";
        }

        private String getJSONFromServer() {
        	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
    		try {
    			HttpClient httpclient = new DefaultHttpClient();
    			// Prepare a request object
    			HttpGet httpget = new HttpGet(this.SERVER_URL);
       			HttpResponse response = httpclient.execute(httpget);

    			Log.e("ASYNCTASK", "HTTP Code: " + response.getStatusLine().getStatusCode());
    			if (response.getStatusLine().getStatusCode() != 200)
    				return "";
    			else
    				return EntityUtils.toString(response.getEntity());
    		} catch (ClientProtocolException e) {
    			// TODO Auto-generated catch block
    			
    			e.printStackTrace();
    			return "";
    		} catch (IOException e) {
    			// TODO Auto-generatxed catch block
    			
    			return "";
    		}
    	}


		@Override
        protected void onPostExecute(String result) {
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }

}
