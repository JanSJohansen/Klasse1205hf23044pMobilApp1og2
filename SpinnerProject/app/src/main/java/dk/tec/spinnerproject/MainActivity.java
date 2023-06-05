package dk.tec.spinnerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Spinner spnNames;
    TextView txtName;
    Button btnShowName;
    String[] names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnNames = findViewById(R.id.spnNames);
        txtName = findViewById(R.id.txtSpinChosenName);
        btnShowName = findViewById(R.id.btnShowName);

        names = new String[]{"Nicolas", "Alexander", "Nicklas", "Matthias", "Martin",
                "Rasmus", "Marco", "Niyazi", "Nikolaj", "Jan"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                names);
        spnNames.setAdapter(adapter);
        spnNames.setOnItemSelectedListener(this);

        btnShowName.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        String name = (String)spnNames.getSelectedItem();
        txtName.setText(name);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        //String name = names[position];
        String name2 = (String)spnNames.getSelectedItem();
        txtName.setText(name2);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}