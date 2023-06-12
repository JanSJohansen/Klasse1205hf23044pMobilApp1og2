package dk.tec.elevclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtElevName = findViewById(R.id.txtElevName);

        IElevService service = ServiceBuilder.buildService(IElevService.class);
        Call<Elev> request = service.getElevById(1007);
        request.enqueue(new Callback<Elev>() {
            @Override
            public void onResponse(Call<Elev> call, Response<Elev> response) {
                Elev elev = response.body();
                txtElevName.setText(elev.getNavn());
            }

            @Override
            public void onFailure(Call<Elev> call, Throwable t)
            {
                txtElevName.setText(t.getMessage());
            }
        });
    }
}