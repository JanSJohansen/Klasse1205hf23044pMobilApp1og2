package dk.tec.customlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    List<Cow> cows;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cows = new ArrayList<Cow>();
        cows.add(new Cow("Rød Dansk",
                "Rød ko der er god til at slikke sig i næsen", R.drawable.ko_01));
        cows.add(new Cow("Rødbroget Dansk",
                "Super mælkeproducent. 12 liter 3 gange om dagen", R.drawable.ko_02));
        cows.add(new Cow("Karoline Ko",
                "Giver masser yoghurt med jordbærsmag", R.drawable.ko_03));
        cows.add(new Cow("Den opretgående Ko",
                "Giver go stærk ost", R.drawable.ko_04));
        cows.add(new Cow("Petting Cow",
                "Broget og Blød og dejlig", R.drawable.ko_05));
        cows.add(new Cow("Giraf Ko",
                "Masser af nakkekoteletter", R.drawable.ko_06));
        cows.add(new Cow("Brille abe ko",
                "Finder det bedste grønne græs", R.drawable.ko_07));
        cows.add(new Cow("Vild Ko",
                "Vild Beatleshår og frisure ", R.drawable.ko_08));

        ListView lstCows = findViewById(R.id.lstCows);
        CowAdapter cowAdapter = new CowAdapter(cows, this);
        lstCows.setAdapter(cowAdapter);
        lstCows.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(cows.get(position).getTitle());
            }
        });
    }
}