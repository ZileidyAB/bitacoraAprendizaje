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

import py.com.misgruposv01.datos.Ejercicio;
import py.com.misgruposv01.datos.Item;

public class EjercicioAdapter extends BaseAdapter {
    private final Activity actividad;
    private final ArrayList<Ejercicio> lista;

    public EjercicioAdapter(Activity actividad, ArrayList<Ejercicio> lista) {
        super();
        this.actividad = actividad;
        this.lista = lista;
    }

    @Override
    public View getView(int posicion, View vista, ViewGroup padre) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.elementos_listar_ejercicio, null, true);

        TextView porcentajeLogrado = (TextView) view.findViewById(R.id.porcentaje_logrado);
        porcentajeLogrado.setText("" + lista.get(posicion).getPorcLogrado());

        TextView tiempoDedicado = (TextView) view.findViewById(R.id.tiempo_dedicado);
        tiempoDedicado.setText(lista.get(posicion).getTiempoDedicado());

        TextView experiencia = (TextView) view.findViewById(R.id.experiencia);
        experiencia.setText("" + lista.get(posicion).getExperiencia());

        TextView duda = (TextView) view.findViewById(R.id.dudas);
        duda.setText("" + lista.get(posicion).getDudas());

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
        Ejercicio unEjercicio = lista.get(arg0);
        return unEjercicio.getId();
    }


}
