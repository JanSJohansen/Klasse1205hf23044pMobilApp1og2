package dk.tec.ourfirstproject;

import android.view.View;

public class MyHandler implements View.OnClickListener
{
    MainActivity main;
    public MyHandler(MainActivity mainActivity)
    {
        main = mainActivity;
    }

    @Override
    public void onClick(View v)
    {
        String message = main.txtWrite.getText().toString();
        main.txtShow.setText(message);
    }
}
