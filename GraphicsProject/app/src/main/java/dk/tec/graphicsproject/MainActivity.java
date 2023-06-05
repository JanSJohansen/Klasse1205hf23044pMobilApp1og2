package dk.tec.graphicsproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity
{
    LinearLayout theLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theLayout = findViewById(R.id.theLayout);
        Button btn = new Button(this);
        btn.setText("OK");
        theLayout.addView(btn);

        MyView mv = new MyView(this);
        theLayout.addView(mv);

    }
}