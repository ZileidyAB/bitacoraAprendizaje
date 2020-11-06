package py.com.misgruposv01.datos;

import java.util.ArrayList;

public class Materia {
    private int id;
    private String codigo;
    private String nombre;
    private ArrayList<Tema> temas;
    private static ArrayList<Materia> materias;

    static {
        materias = new ArrayList<>();
        materias.add(new Materia("mkt1", "Marketing"));
        materias.add(new Materia("proyTIC", "Proyecto TIC"));
    }

    public Materia(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Tema> getTemas() {
        return temas;
    }

    public void setTemas(ArrayList<Tema> temas) {
        this.temas = temas;
    }

    public static ArrayList<Materia> getMaterias() {
        return materias;
    }

    public static void setMaterias(ArrayList<Materia> materias) {
        Materia.materias = materias;
    }
}
