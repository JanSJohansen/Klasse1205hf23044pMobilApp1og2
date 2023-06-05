package dk.tec.movepicturethread;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class MyView extends View implements Runnable
{
    MainActivity main;
    Drawable drwDog;
    int xDog = 0, yDog = 0;
    int xMove = 5, yMove = 5;
    int dogWidth, dogHeight;
    int viewWidth, viewHeight;

    public MyView(MainActivity mainActivity)
    {
        super(mainActivity);
        main = mainActivity;
        drwDog = main.getResources().getDrawable(R.drawable.dog, null);
        dogWidth = drwDog.getMinimumWidth()/3;
        dogHeight = drwDog.getMinimumHeight()/3;
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
        drwDog.setBounds(xDog, yDog, xDog + dogWidth, yDog + dogHeight);
        drwDog.draw(canvas);
    }

    @Override
    public void run()
    {
        while(true)
        {
            xDog += xMove;
            yDog += yMove;
            if(xDog > (viewWidth - dogWidth) )
                xMove = Math.abs(xMove) * -1;
            if(xDog < 0)
                xMove = Math.abs(xMove) * 1;
            if(yDog > (viewHeight - dogHeight))
                yMove = Math.abs(yMove) * -1;
            if(yDog < 0)
                yMove = Math.abs(yMove) * 1;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            postInvalidate();
        }
    }
}
