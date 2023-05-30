package dk.tec.regner4knapperlinearlayout;

import android.view.View;
public class SubHandler implements View.OnClickListener
{
    MainActivity main;
    public SubHandler(MainActivity main)
    {
        this.main = main;
    }
    @Override
    public void onClick(View v)
    {
       int tal1 = Integer.parseInt(main.txtTal1.getText().toString());
       int tal2 = Integer.parseInt(main.txtTal2.getText().toString());
       main.txtResult.setText((tal1 - tal2) + "");
    }
}
