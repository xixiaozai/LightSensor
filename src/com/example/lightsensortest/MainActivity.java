package com.example.lightsensortest;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
//这是一个关于传感器的测试
public class MainActivity extends Activity {
	private TextView light_text;
	private SensorManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		light_text = (TextView) findViewById(R.id.light_text);
		manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		Sensor sensor = manager.getDefaultSensor(Sensor.TYPE_LIGHT);
		manager.registerListener(listener, sensor,
				SensorManager.SENSOR_DELAY_NORMAL);
	}

	private SensorEventListener listener = new SensorEventListener() {

		@Override
		public void onSensorChanged(SensorEvent event) {
			// TODO Auto-generated method stub
			// values数组中第一个下标的值就是当前光照强度
			float value = event.values[0];
			light_text.setText("当前光照强度为：" + value + "lx");
		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub

		}
	};
 
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (manager != null) {
			manager.unregisterListener(listener);
		}
	}

}
