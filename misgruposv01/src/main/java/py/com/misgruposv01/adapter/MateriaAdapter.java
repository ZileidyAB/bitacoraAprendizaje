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

public class MateriaAdapter extends BaseAdapter {

    private final Activity actividad;
    private final ArrayList<Materia> lista;

    public MateriaAdapter(Activity actividad, ArrayList<Materia> lista){
        super();
        this.actividad = actividad;
        this.lista = lista;
    }

    @Override
    public View getView(int posicion, View vista, ViewGroup padre) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.elementos_listar_materia, null, true);

        TextView nombreElemento = (TextView) view.findViewById(R.id.titulo_materia);
        nombreElemento.setText(lista.get(posicion).getNombre());

        TextView codigoMateria = (TextView) view.findViewById(R.id.codigo_materia);
        codigoMateria.setText(""+lista.get(posicion).getCodigo());

        TextView identificadorTemas = (TextView) view.findViewById(R.id.identificador_temas);
        identificadorTemas.setText("Listado de temas: ");

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
        Materia unaMateria = lista.get(arg0);
        return unaMateria.getId();

    }



}
