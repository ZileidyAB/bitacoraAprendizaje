package py.com.misgruposv01.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.Investigacion;

public class InvestigacionAdapter extends BaseAdapter {
    private final Activity actividad;
    private final ArrayList<Investigacion> lista;

    public InvestigacionAdapter(Activity actividad, ArrayList<Investigacion> lista) {
        super();
        this.actividad = actividad;
        this.lista = lista;
    }

    @Override
    public View getView(int posicion, View vista, ViewGroup padre) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.elementos_listar_investigacion, null, true);

        TextView tituloInvestigacion = (TextView) view.findViewById(R.id.titulo_investigacion);
        tituloInvestigacion.setText("Tema: " + lista.get(posicion).getTemaInvestigado());

        TextView porcentajeLogrado = (TextView) view.findViewById(R.id.nivel_comprension);
        porcentajeLogrado.setText("NC: " + lista.get(posicion).getNivelComprension() + " %");

        TextView tiempoDedicado = (TextView) view.findViewById(R.id.tiempo_dedicado);
        tiempoDedicado.setText(" " + lista.get(posicion).getTiempoDedicado());

        TextView comentarios = (TextView) view.findViewById(R.id.comentarios);
        comentarios.setText("Comentarios: " + lista.get(posicion).getComentarios());

        TextView duda = (TextView) view.findViewById(R.id.dudas);
        duda.setText("Dudas: " + lista.get(posicion).getDudas());

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
        Investigacion unaInvestigacion = lista.get(arg0);
        return unaInvestigacion.getId();
    }


}
