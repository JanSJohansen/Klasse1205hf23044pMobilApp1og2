package dk.tec.accelerationsensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;

public class BallView extends View implements SensorEventListener {
    public BallView(MainActivity mainActivity)
    {
        super(mainActivity);

    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
