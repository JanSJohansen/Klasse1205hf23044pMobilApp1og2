package dk.tec.regner4knapperlinearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtTal1, txtTal2, txtResult;
    Button btnAdd, btnSub, btnMul, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTal1 = findViewById(R.id.txtTal1);
        txtTal2 = findViewById(R.id.txtTal2);
        txtResult = findViewById(R.id.txtResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnMul = findViewById(R.id.btnMul);
        btnSub = findViewById(R.id.btnSub);
        btnDiv = findViewById(R.id.btnDiv);
        //int strId = R.string.app_name;

        btnAdd.setOnClickListener(this);

        btnSub.setOnClickListener(new SubHandler(this));

        btnMul.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int tal1 = Integer.parseInt(txtTal1.getText().toString());
                int tal2 = Integer.parseInt(txtTal2.getText().toString());
                txtResult.setText((tal1 * tal2) + "");
            }
        });
    }

    @Override
    public void onClick(View v)
    {
        int tal1 = Integer.parseInt(txtTal1.getText().toString());
        int tal2 = Integer.parseInt(txtTal2.getText().toString());
        txtResult.setText((tal1+tal2) + "");
    }

    public void btnDivOnClick(View v)
    {
        int tal1 = Integer.parseInt(txtTal1.getText().toString());
        int tal2 = Integer.parseInt(txtTal2.getText().toString());
        txtResult.setText((tal1 / tal2) + "");
    }


}