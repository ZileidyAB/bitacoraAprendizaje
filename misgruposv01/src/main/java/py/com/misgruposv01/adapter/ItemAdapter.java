package py.com.misgruposv01.adapter;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import py.com.misgruposv01.R;
import java.util.ArrayList;

import py.com.misgruposv01.datos.Item;

public class ItemAdapter extends BaseAdapter {

    private final Activity actividad;
    private final ArrayList<Item> lista;

    public ItemAdapter(Activity actividad, ArrayList<Item> lista) {
        super();
        this.actividad = actividad;
        this.lista = lista;
    }

    @Override
    public View getView(int posicion, View vista, ViewGroup padre) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.elementos_listar_temas, null, true);

        TextView conceptoElemento = (TextView) view.findViewById(R.id.concepto_items);
        conceptoElemento.setText(lista.get(posicion).getConcepto());

        TextView descripcion = (TextView) view.findViewById(R.id.descripcion_items);
        descripcion.setText("" + lista.get(posicion).getDescripcion());

        TextView duda = (TextView) view.findViewById(R.id.dudas_items);
        duda.setText("" + lista.get(posicion).getDuda());

        CheckBox aprendido = (CheckBox) view.findViewById(R.id.checkboxAprendido);
        aprendido.setText("" + lista.get(posicion).isEntendido());
        return view;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int arg0) {
        if (lista != null) {
            return lista.get(arg0);
        }
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        Item unItem = lista.get(arg0);
        return unItem.getId();

    }
}
