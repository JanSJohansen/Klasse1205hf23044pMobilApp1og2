package dk.tec.ourfirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//import android.widget.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnTryk;
    TextView txtShow;
    EditText txtWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtShow = findViewById(R.id.txtShow);
        txtWrite = findViewById(R.id.txtWrite);

        btnTryk = findViewById(R.id.btnTryk);

        //btnTryk.setOnClickListener(this);
        //btnTryk.setOnClickListener(new MyHandler(this));
        btnTryk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                txtShow.setText(txtWrite.getText());
            }
        });


    }

    @Override
    public void onClick(View v)
    {
        Button btn = (Button)v;
        btn.setText("Der blev trykket");

        //String talStr = "123";
        //int tal = Integer.parseInt(talStr);
    }
}