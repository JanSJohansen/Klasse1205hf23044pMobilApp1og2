package dk.tec.accelerationsensors;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;

public class BallView extends View implements SensorEventListener
{
    MainActivity main;
    int ballWidth, ballHeight;
    Drawable drwBall;
    float xPos = 100, yPos = 100;
    float xMove, yMove;
    int viewWidth, viewHeight;
    public BallView(MainActivity mainActivity)
    {
        super(mainActivity);
        main = mainActivity;
        drwBall = main.getResources().getDrawable(R.drawable.kugle);
        ballWidth = drwBall.getMinimumWidth()/2;
        ballHeight = drwBall.getMinimumHeight()/2;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drwBall.setBounds((int)xPos,(int)yPos, (int)xPos + ballWidth, (int)yPos + ballHeight);
        drwBall.draw(canvas);

        Paint paint = new Paint();
        paint.setStrokeWidth(2);
        paint.setColor(Color.BLUE);
        canvas.drawLine(10,10, viewWidth - 10, 10, paint);
        canvas.drawLine(viewWidth - 10,10, viewWidth - 10, viewHeight - 10, paint);
        canvas.drawLine(viewWidth - 10,viewHeight - 10, 10, viewHeight - 10, paint);
        canvas.drawLine(10,viewHeight - 10, 10, 10, paint);
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            main.upDateScrenValues(event.values);

            float valueX = event.values[0];
            float valueY = event.values[1];
            xMove += -valueX/10;
            yMove += valueY/10;
            xPos += xMove;
            yPos += yMove;

            if(xPos + ballWidth > viewWidth + 25)
            {
                xMove = -Math.abs(xMove);
                xPos += xMove;
                xMove = xMove * 0.7f;
            }
            if(xPos < 0 - 30)
            {
                xMove = Math.abs(xMove);
                xPos += xMove;
                xMove = xMove * 0.7f;
            }
            if(yPos + ballHeight > viewHeight + 27)
            {
                yMove = -Math.abs(yMove);
                yPos += yMove;
                yMove = yMove *0.7f;
            }
            if(yPos < 0 - 27)
            {
                yMove = Math.abs(yMove);
                yPos += yMove;
                yMove = yMove *0.7f;
            }
            invalidate();
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {    }
}
