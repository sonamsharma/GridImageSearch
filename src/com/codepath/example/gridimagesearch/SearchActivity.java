package com.codepath.example.gridimagesearch;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

public class SearchActivity extends Activity {
EditText etQuery;
Button btnSearch;
GridView gvResults;
ArrayList<ImageResult> imageResults = new ArrayList<ImageResult>();
ImageResultArrayAdapter imageAdapter;
AdvanceSettings settings;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		setupViews();
		imageAdapter = new ImageResultArrayAdapter(this, imageResults);
		gvResults.setAdapter(imageAdapter);
		gvResults.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> adapter, View parent, int position,
					long rowId) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), ImageDisplayActivity.class);
				ImageResult imageResult = imageResults.get(position);
				i.putExtra("result", imageResult);
				startActivity(i);
				
			}
			
		});
	}
	
	public void onSettings(MenuItem mi){
		Intent i = new Intent(this,AdvancedSearchActivity.class);
		if(settings != null){
			 i.putExtra("previous", settings);
		}
		startActivityForResult(i, 123);
		
		
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			if (requestCode == 123) {
				settings = (AdvanceSettings) data.getSerializableExtra("filters");
				Toast.makeText(this, settings.toString(), Toast.LENGTH_LONG).show();
			}
		}
	}

	private void setupViews() {
		// TODO Auto-generated method stub
		etQuery = (EditText) findViewById(R.id.etQuery);
		btnSearch = (Button) findViewById(R.id.btnSearch);
		gvResults = (GridView) findViewById(R.id.gvResults);
	}
	
	public void onImageSearch(View v){
		String query = etQuery.getText().toString();
		AsyncHttpClient client = new AsyncHttpClient();
		String url = "https://ajax.googleapis.com/ajax/services/search/images?rsz=8&"+
			"start=" +0+"&v=1.0&q="+ Uri.encode(query);
		
		String settingsFilter = new String();
		if(settings != null){
			settingsFilter = "&imgsz=";
		
			if(settings.getSize().equals("small")){
				settingsFilter= settingsFilter+"icon";
				
			}
			if(settings.getSize().equals("medium")){
				settingsFilter= settingsFilter+"small";
				
			}
			else if(settings.getSize().equals("large")){
				settingsFilter= settingsFilter+"xxlarge";
				
			}
			else if(settings.getSize().equals("x-large")){
				settingsFilter= settingsFilter+"huge";
				
			}
			else{
					settingsFilter=settingsFilter+"small";
			}
			settingsFilter = settingsFilter + "&imgtype"+settings.getType()+ "&imgcolor="+
							 settings.getColor() + "&as_sitesearch="+
							 settings.getSiteFilter();
							 
			
		}
		
		Toast.makeText(this, "Fetching images for : " + url + settingsFilter, Toast.LENGTH_LONG).show();
;		client.get(url+settingsFilter, new JsonHttpResponseHandler(){
		@Override
		public void onSuccess(JSONObject response){
			JSONArray imageJsonResults = null;
			try{
				imageJsonResults = response.getJSONObject("responseData").getJSONArray("results");
				imageResults.clear();
				imageAdapter.addAll(ImageResult.fromJSONArray(imageJsonResults));
				Log.d("DEBUG",imageResults.toString());
			}catch(JSONException e){
				e.printStackTrace();
			}
			
		}
});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}

}
