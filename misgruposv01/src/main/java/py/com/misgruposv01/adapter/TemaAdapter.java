package py.com.misgruposv01.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.Tema;

public class TemaAdapter extends BaseAdapter {

    private final Activity actividad;
    private final ArrayList<Tema> lista;

    public TemaAdapter(Activity actividad, ArrayList<Tema> lista){
        super();
        this.actividad = actividad;
        this.lista = lista;
    }

    @Override
    public View getView(int posicion, View vista, ViewGroup padre) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.elementos_listar_temas, null, true);

        TextView nombreElemento = (TextView) view.findViewById(R.id.nombre_tema);
        nombreElemento.setText(lista.get(posicion).getNombre());

        TextView codigoMateria = (TextView) view.findViewById(R.id.fecha);
        codigoMateria.setText(""+lista.get(posicion).getFecha());

        return view;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int arg0) {
        if(lista != null){
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
