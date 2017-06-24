package com.example.blue_fi1;



import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SecondPage extends Activity {
	ImageButton button1,button2,button3;
	WifiManager wm;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second_page);
		final TextView textView1 = (TextView) findViewById(R.id.textView1);
		button1 = (ImageButton)findViewById(R.id.imageButton1);
		button2 = (ImageButton)findViewById(R.id.imageButton2);
		button3 = (ImageButton)findViewById(R.id.imageButton3);
		final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		
		if(mBluetoothAdapter == null){
    		textView1.append("device not supported");
    	}
		button1.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View v) {
				wm = (WifiManager)getSystemService(WIFI_SERVICE);
				if(wm.isWifiEnabled()){
					Toast.makeText(SecondPage.this,
							"WIFI OFF!",
							Toast.LENGTH_SHORT).show();
				// TODO Auto-generated method stub
				 wm.setWifiEnabled(false);
				 button1.setImageResource(R.drawable.wifi);
			
			}else {
				Toast.makeText(SecondPage.this,
						"WIFI ON!",
						Toast.LENGTH_SHORT).show();
				wm.setWifiEnabled(true);
				button1.setImageResource(R.drawable.wifi1);
				
			}
			}
		});
		
		button2.setOnClickListener(new OnClickListener(){

			@SuppressLint("ShowToast") @Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!mBluetoothAdapter.isEnabled()) {
					mBluetoothAdapter.enable();
					Context context = getApplicationContext();
					CharSequence text = "TURNING ON BLUETOOTH";
					int duration = Toast.LENGTH_LONG;
					Toast toast = Toast.makeText(context, text, 15);
					toast.show();
					 button2.setImageResource(R.drawable.bluetooth1);
					
				}else {
					mBluetoothAdapter.disable();
					Context context = getApplicationContext();
					CharSequence text = "TURNING OFF BLUETOOTH";
					int duration = Toast.LENGTH_LONG;
					Toast toast = Toast.makeText(context, text, 15);
					toast.show();
					 button2.setImageResource(R.drawable.bluetooth);
					
				}
			}
			
		});
		
		button3.setOnClickListener(new OnClickListener(){

			@SuppressLint("ShowToast") @Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				wm = (WifiManager)getSystemService(WIFI_SERVICE);
				if(wm.isWifiEnabled()){
				// TODO Auto-generated method stub
				 wm.setWifiEnabled(false);
				 button3.setImageResource(R.drawable.wifibluetooth);
				 button1.setImageResource(R.drawable.wifi);
				 button2.setImageResource(R.drawable.bluetooth);
				 mBluetoothAdapter.disable();
					int duration = Toast.LENGTH_LONG;
					Toast toast = Toast.makeText(getApplicationContext(), "TURNING OFF WIFI AND BLUETOOTH", 15);
					toast.show();
			 
			}else {
			
				wm.setWifiEnabled(true);
				button3.setImageResource(R.drawable.wifibluetooth1);
				button1.setImageResource(R.drawable.wifi1);
				button2.setImageResource(R.drawable.bluetooth1);
				mBluetoothAdapter.enable();
				Context context = getApplicationContext();
				CharSequence text = "TURNING ON WIFI AND BLUETOOTH";
				int duration = Toast.LENGTH_LONG;
				Toast toast = Toast.makeText(context, text, 15);
				toast.show();
			}
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second_page, menu);
		return true;
	}

}
