package dk.tec.accelerationsensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener
{
    TextView txtXY, txtXZ, txtZY;
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtXY = findViewById(R.id.txtXY);
        txtXZ = findViewById(R.id.txtXZ);
        txtZY = findViewById(R.id.txtZY);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
    }


    @Override
    public void onSensorChanged(SensorEvent event)
    {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            txtXY.setText(String.format("%8.1f", event.values[0]));
            txtXZ.setText(String.format("%8.1f", event.values[1]));
            txtZY.setText(String.format("%8.1f", event.values[2]));
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {   }

    @Override
    protected void onResume()
    {
        super.onResume();
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                10000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
    }
}