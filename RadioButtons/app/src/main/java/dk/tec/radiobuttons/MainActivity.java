package dk.tec.radiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    RadioGroup rdgChoose;
    TextView txtChosen;
    Button btnWho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdgChoose = findViewById(R.id.rdgChoose);
        txtChosen = findViewById(R.id.txtChosenOne);
        btnWho = findViewById(R.id.btnWho);
        btnWho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                switch(rdgChoose.getCheckedRadioButtonId())
                {
                    case R.id.rdbNicklas:  // error: constant expression required
                        txtChosen.setText("Nicklas");
                        break;
                    case R.id.rdbNicolas:
                        txtChosen.setText("Nicolas");
                        break;
                    case R.id.rdbNikolaj:
                        txtChosen.setText("Nikolaj");
                        break;
                    case R.id.rdbNiyazi:
                    txtChosen.setText("Niyazi");
                    break;
                }
            }
        });

        rdgChoose.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                if(checkedId == R.id.rdbNicklas)
                    txtChosen.setText("Nicklas");
                if(checkedId == R.id.rdbNicolas)
                    txtChosen.setText("Nicolas");
                if(checkedId == R.id.rdbNikolaj)
                    txtChosen.setText("Nikolaj");
                if(checkedId == R.id.rdbNiyazi)
                    txtChosen.setText("Niyazi");
            }
        });
    }
}