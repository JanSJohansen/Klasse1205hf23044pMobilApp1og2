package dk.tec.accelerationsensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener
{
    TextView txtXY, txtXZ, txtZY;
    Button btnShowBall;
    SensorManager sensorManager;
    LinearLayout theLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtXY = findViewById(R.id.txtXY);
        txtXZ = findViewById(R.id.txtXZ);
        txtZY = findViewById(R.id.txtZY);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        theLayout = findViewById(R.id.theLayout);
        btnShowBall = findViewById(R.id.btnShowBall);
        btnShowBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                BallView ballView = new BallView(MainActivity.this);
                theLayout.addView(ballView);
                sensorManager.unregisterListener(MainActivity.this,
                        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
                sensorManager.registerListener(ballView,
                        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                        10000);
            }
        });
    }


    @Override
    public void onSensorChanged(SensorEvent event)
    {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            upDateScrenValues(event.values);
        }
    }

    public void upDateScrenValues(float[] values)
    {
        txtXY.setText(String.format("%8.1f", values[0]));
        txtXZ.setText(String.format("%8.1f", values[1]));
        txtZY.setText(String.format("%8.1f", values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {   }

    @Override
    protected void onResume()
    {
        super.onResume();
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                100000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
    }
}