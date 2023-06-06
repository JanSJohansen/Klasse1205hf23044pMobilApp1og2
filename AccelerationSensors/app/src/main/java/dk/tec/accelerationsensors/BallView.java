package dk.tec.accelerationsensors;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;

public class BallView extends View implements SensorEventListener
{
    MainActivity main;
    public BallView(MainActivity mainActivity)
    {
        super(mainActivity);
        main = mainActivity;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setTextSize(50);

        canvas.drawText("Hej fra Ball", 100, 100, paint);
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            main.upDateScrenValues(event.values);

            
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
