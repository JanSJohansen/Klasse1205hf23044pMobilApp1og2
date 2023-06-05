package dk.tec.graphicsproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View implements View.OnTouchListener
{
    MainActivity main;
    int xCenter = 100, yCenter = 100;
    int xPrev, yPrev;
    int radius = 50;
    boolean moving;

    public MyView(Context context)
    {
        super(context);
        main = (MainActivity) context;
        this.setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        //int farve = 0xFF123456;
        Paint paint = new Paint();
        paint.setColor(0xFF0000FF); //
        canvas.drawCircle(xCenter,yCenter, radius, paint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        int fingre = event.getPointerCount();  // 2 fingre
        event.getX(0); // Find afstanden imellem fingre og sæt diamter til dette.

        int xNew = (int)event.getX();
        int yNew = (int)event.getY();
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if(Math.sqrt((xNew - xCenter)*(xNew - xCenter) + ((yNew - yCenter) * (yNew - yCenter))) <= radius)
                {
                    moving = true;
                    xPrev = xNew;
                    yPrev = yNew;
                }
                break;
                case MotionEvent.ACTION_MOVE:
                    if(moving)
                    {
                        int xDelta = xNew - xPrev;
                        int yDelta = yNew - yPrev;
                        xCenter += xDelta;
                        yCenter += yDelta;
                        xPrev = xNew;
                        yPrev = yNew;
                        invalidate();
                    }
                    break;
                    case MotionEvent.ACTION_UP:
                        moving = false;
        }
        return true;
    }
}

