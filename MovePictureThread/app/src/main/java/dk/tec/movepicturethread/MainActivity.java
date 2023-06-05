package dk.tec.movepicturethread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout theLayout = findViewById(R.id.theLayout);
        MyView mv = new MyView(this);
        theLayout.addView(mv);
        Thread t = new Thread(mv);
        t.start();
    }
}