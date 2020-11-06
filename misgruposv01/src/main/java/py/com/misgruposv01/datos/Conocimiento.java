package py.com.misgruposv01.datos;

import java.util.ArrayList;

public class Conocimiento {
    private int id;
    private String codigo;
    private String concepto;
    private String descripcion;
    private String dudas;
    private boolean aprendido;

    private static ArrayList<Conocimiento> conocimientos;

    static {
        conocimientos = new ArrayList<>();
        conocimientos.add(new Conocimiento("num1", "POO", "Significa Programacion Orientada a Objetos", "Ninguna", true));
        conocimientos.add(new Conocimiento("num2", "Lenguas", "Son un sistema de signos lingüísticos", "Ninguna", false));
        conocimientos.add(new Conocimiento("num3", "Radicales", "Es el proceso de hallar raíces de orden n de un número a", "Ninguna", false));
    }

    public Conocimiento(String codigo, String concepto, String descripcion, String dudas, boolean aprendido) {
        this.codigo = codigo;
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.dudas = dudas;
        this.aprendido = aprendido;
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

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDudas() {
        return dudas;
    }

    public void setDudas(String dudas) {
        this.dudas = dudas;
    }

    public boolean isAprendido() {
        return aprendido;
    }

    public void setAprendido(boolean aprendido) {
        this.aprendido = aprendido;
    }

    public static ArrayList<Conocimiento> getConocimientos() {
        return conocimientos;
    }

    public static void setConocimientos(ArrayList<Conocimiento> conocimientos) {
        Conocimiento.conocimientos = conocimientos;
    }
}
