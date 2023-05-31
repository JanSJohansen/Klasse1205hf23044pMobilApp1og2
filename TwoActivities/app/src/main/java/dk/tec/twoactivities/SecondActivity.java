package dk.tec.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtFromMain;
    Button btnGoBack;
    EditText txtToMain;
    Intent calledIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        calledIntent = getIntent();
        String strFromMain = calledIntent.getStringExtra(MainActivity.TEXT_FROM_MAIN);
        txtFromMain = findViewById(R.id.txtFromMain);
        txtFromMain.setText(strFromMain);

        txtToMain = findViewById(R.id.txtToMain);

        btnGoBack = findViewById(R.id.btnGoBack);
        btnGoBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        String strToMain = txtToMain.getText().toString();
        calledIntent.putExtra(MainActivity.TEXT_FROM_SECOND, strToMain);

        setResult(Activity.RESULT_OK, calledIntent); // sender den tilbage
        finish();
    }
}