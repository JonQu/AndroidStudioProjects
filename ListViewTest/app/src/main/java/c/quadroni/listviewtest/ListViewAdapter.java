package c.quadroni.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    protected List<Train> data;
    protected Context context;

    public ListViewAdapter(List<Train> _data, Context _context){
        data = _data;
        context = _context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vi = view;
        if(vi == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.cell_layout, null);
        }
        TextView departure = vi.findViewById(R.id.departure);
        TextView to = vi.findViewById(R.id.to);
        TextView name = vi.findViewById(R.id.name);

        Train train = data.get(i);

        departure.setText(train.stop.getDepartureTime());
        to.setText(train.to);
        name.setText(train.name);

        return vi;
    }
}
