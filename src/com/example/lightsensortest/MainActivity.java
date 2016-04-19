package com.example.lightsensortest;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
//����һ�����ڴ������Ĳ���
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
			// values�����е�һ���±��ֵ���ǵ�ǰ����ǿ��
			float value = event.values[0];
			light_text.setText("��ǰ����ǿ��Ϊ��" + value + "lx");
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
