package py.com.misgruposv01.datos;

import java.util.ArrayList;

public class Tema {
    private int id;
    private String codigo;
    private String nombre;
    private String fecha;
    private ArrayList<Investigacion> investigaciones;
    private ArrayList<Item> items;
    private ArrayList<Ejercicio> ejercicios;

    private static ArrayList<Tema> temas;

//    static {
//        temas = new ArrayList<>();
//        temas.add(new Tema("poo", "Programacion Orientada a Objetos - POO", "15/08/2020"));
//        temas.add(new Tema("mates", "Matematicas", "09/07/2018"));
//        temas.add(new Tema("comun", "Comunicacion", "11/06/2019"));
//    }
public static void agregarTema( Tema unTema ) {
    temas.add( unTema );
}
    public Tema(String codigo, String nombre, String fecha) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public Tema (String codigo, String nombre, String fecha, ArrayList investigaciones, ArrayList items, ArrayList ejercicios ) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.investigaciones = investigaciones;
        this.items = items;
        this.ejercicios = ejercicios;
    }

    //NO SE
    public Item temasPendientes() {
        for (int i = 0; i < items.size(); i++) {
            Item unItem= items.get(i);
            if (unItem.isAprendido() == false) {
                return unItem;
//                System.out.println("Concepto: " + unConocimiento.getConceptoConocimiento()); //CREO QUE ACA SOLO ESTO
            }
        }
        return null;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Investigacion> getInvestigaciones() {
        return investigaciones;
    }

    public void setInvestigaciones(ArrayList<Investigacion> investigaciones) {
        this.investigaciones = investigaciones;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public static ArrayList<Tema> getTemas() {
        return temas;
    }

    public static void setTemas(ArrayList<Tema> temas) {
        Tema.temas = temas;
    }
}
