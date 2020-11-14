package py.com.misgruposv01.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;

public class TemaPendienteAdapter extends BaseAdapter {

    private final Activity actividad;
    private final ArrayList<Tema> lista;
    private final ArrayList<Materia> lista2;

    public TemaPendienteAdapter(Activity actividad, ArrayList<Tema> lista, ArrayList<Materia> lista2) {
        super();
        this.actividad = actividad;
        this.lista = lista;
        this.lista2 = lista2;
    }

    @Override
    public View getView(int posicion, View vista, ViewGroup padre) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.elementos_listar_pendientes, null, true);

        //arreglar
        TextView nombreTemaPendiente = (TextView) view.findViewById(R.id.nombre_tema_pendiente);
        nombreTemaPendiente.setText(lista.get(posicion).getNombre());

        TextView fechaTemaPendiente = (TextView) view.findViewById(R.id.fecha_tema_pendiente);
        fechaTemaPendiente.setText("" + lista.get(posicion).getFecha());

        TextView MateriaTemaPendiente = (TextView) view.findViewById(R.id.materia_tema_pendiente);
        MateriaTemaPendiente.setText("Materia correspondiente: " + lista2.get(posicion).getNombre());

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
        Tema unTema = lista.get(arg0);
        return unTema.getId();

    }


}
