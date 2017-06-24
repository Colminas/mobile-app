package com.example.blue_fi1;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	ImageButton button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (ImageButton)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){

  		@Override
  		public void onClick(View view) {
  			// TODO Auto-generated method stub
  		 Intent b = new Intent(getApplicationContext(),SecondPage.class);
  		 startActivity(b);
  		}
      	  
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
