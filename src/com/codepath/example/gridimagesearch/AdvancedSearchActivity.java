package com.codepath.example.gridimagesearch;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AdvancedSearchActivity extends Activity {
	Spinner spinnerImageSize;
	Spinner spinnerColorFilter;
	Spinner spinnerImageType;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_advanced_search);
		setupAdvViews();
		viewSpinnerOptions();
	}
	
	private void setupAdvViews() {
		// TODO Auto-generated method stub
		spinnerImageSize = (Spinner) findViewById(R.id.spImageSize);
		spinnerColorFilter = (Spinner) findViewById(R.id.spColorFilter);
		spinnerImageType = (Spinner) findViewById(R.id.spImageType);
	}

	private void viewSpinnerOptions() {
		// TODO Auto-generated method stub
		
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapterForImageSize = ArrayAdapter.createFromResource(this,
		        R.array.imageSize_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapterForImageSize.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerImageSize.setAdapter(adapterForImageSize);
		
		
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapterForColor = ArrayAdapter.createFromResource(this,
		        R.array.color_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapterForColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerColorFilter.setAdapter(adapterForColor);
		
		
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapterForImgType = ArrayAdapter.createFromResource(this,
		        R.array.imgSize_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapterForColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerImageType.setAdapter(adapterForImgType);
	}

	public void onSave(View v) {
		
		  // closes the activity and returns to first screen
		  this.finish(); 
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.advanced_search, menu);
		return true;
	}

}
