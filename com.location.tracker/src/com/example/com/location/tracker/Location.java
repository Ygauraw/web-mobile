package com.example.com.location.tracker;

import com.example.com.location.tracker.service.ExampleService;
import com.example.com.location.tracker.service.GPSTracker;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Location extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    GPSTracker mGPS = new GPSTracker(this);

    TextView text = (TextView) findViewById(R.id.texts);
    if(mGPS.canGetLocation ){
    	mGPS.getLocation();
   //text.setText("Lat"+mGPS.getLatitude()+"Lon"+mGPS.getLongitude());
    }else{
        text.setText("Unabletofind");
        System.out.println("Unable");
    }
}

public void onToggleClicked(View view) {
    // Is the toggle on?
    boolean on = ((ToggleButton) view).isChecked();
    System.out.println(" tracker ---toggled");
    if (on) {
        // Enable vibrate
    	
    	Intent in = new Intent(this, ExampleService.class);
    	this.startService(in);
    	
    } else {
        // Disable vibrate
    	Intent in = new Intent(this, ExampleService.class);
    	this.stopService(in);
    }
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}
}