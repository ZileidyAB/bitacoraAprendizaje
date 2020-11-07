package py.com.misgruposv01.datos;

import java.util.ArrayList;

public class Tema {
    private int id;
    private String codigo;
    private String nombre;
    private String fecha;
    private ArrayList<Investigacion> investigaciones;
    private ArrayList<Conocimiento> conocimientos;
    private ArrayList<Ejercicio> ejercicios;

    private static ArrayList<Tema> temas;

//    static {
//        temas = new ArrayList<>();
//        temas.add(new Tema("poo", "Programacion Orientada a Objetos - POO", "15/08/2020"));
//        temas.add(new Tema("mates", "Matematicas", "09/07/2018"));
//        temas.add(new Tema("comun", "Comunicacion", "11/06/2019"));
//    }

    public Tema(String codigo, String nombre, String fecha) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public Tema (String codigo, String nombre, String fecha, ArrayList investigaciones, ArrayList conocimientos, ArrayList ejercicios ) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.investigaciones = investigaciones;
        this.conocimientos = conocimientos;
        this.ejercicios = ejercicios;
    }

    //NO SE
    public Conocimiento temasPendientes() {
        for (int i = 0; i < conocimientos.size(); i++) {
            Conocimiento unConocimiento = conocimientos.get(i);
            if (unConocimiento.isAprendido() == false) {
                return unConocimiento;
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

    public ArrayList<Conocimiento> getConocimientos() {
        return conocimientos;
    }

    public void setConocimientos(ArrayList<Conocimiento> conocimientos) {
        this.conocimientos = conocimientos;
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
