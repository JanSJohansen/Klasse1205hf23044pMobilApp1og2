package dk.tec.twoactivities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    public final static String TEXT_FROM_MAIN = "TextFromMain";
    public final static String TEXT_FROM_SECOND = "TextFromSecond";

    TextView txtFromSecond;
    Button btnGoToSecond;
    EditText txtToSecond;

    ActivityResultLauncher<Intent> secondActivityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFromSecond = findViewById(R.id.txtFromSecond);
        btnGoToSecond = findViewById(R.id.btnGoToSecond);
        txtToSecond = findViewById(R.id.txtWriteToSecond);

        secondActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result)
                    {
                        if(result.getResultCode() == Activity.RESULT_OK)
                        {
                            Intent intent = result.getData();
                            String strFromSecond = intent.getStringExtra(MainActivity.TEXT_FROM_SECOND);
                            txtFromSecond.setText(strFromSecond);
                        }
                    }
                }
        );

        btnGoToSecond.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String strToSecond = txtToSecond.getText().toString();
                intent.putExtra(MainActivity.TEXT_FROM_MAIN, strToSecond);
                //startActivity(intent); // bruges til at skifte og få data over til SecondActivity
                ////startActivityForResult(intent, 1); // få data tilbage på deprecated måde
                secondActivityLauncher.launch(intent); // få data tilbage ny måde
            }
        });

    }
}