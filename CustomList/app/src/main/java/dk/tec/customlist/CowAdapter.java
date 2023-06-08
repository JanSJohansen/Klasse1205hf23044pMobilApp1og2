package dk.tec.customlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CowAdapter extends BaseAdapter
{
    List<Cow> cows;
    MainActivity main;

    public CowAdapter(List<Cow> cows, MainActivity mainActivity)
    {
        this.cows = cows;
        this.main = mainActivity;
    }

    @Override
    public int getCount() {
        return cows.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Cow cow = cows.get(position);
        LayoutInflater inflater = LayoutInflater.from(main);
        View view = inflater.inflate(R.layout.cow_item, null);
        ImageView drwCowPict = view.findViewById(R.id.drwCowPict);
        drwCowPict.setImageResource(cow.getPictureId());
        TextView txtTitel = view.findViewById(R.id.txtTitle);
        txtTitel.setText(cow.getTitle());
        TextView txtDesc = view.findViewById(R.id.txtDesc);
        txtDesc.setText(cow.getDescription());
        Button btnDelete = view.findViewById(R.id.btnDelete);
        btnDelete.setText("Delete " + cow.getTitle());

        return view;
    }
}






