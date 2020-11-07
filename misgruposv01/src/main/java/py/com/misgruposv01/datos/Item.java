package py.com.misgruposv01.datos;

import java.util.ArrayList;

public class Item {
    private int id;
    private String codigo;
    private String concepto;
    private String descripcion;
    private String duda;
    private boolean entendido;

    private static ArrayList<Item> items;

//    static {
//        items = new ArrayList<>();
//        items.add(new Item("num1", "POO", "Significa Programacion Orientada a Objetos", "Ninguna", true));
//        items.add(new Item("num2", "Lenguas", "Son un sistema de signos lingüísticos", "Ninguna", false));
//        items.add(new Item("num3", "Radicales", "Es el proceso de hallar raíces de orden n de un número a", "Ninguna", false));
//    }

    public Item (String codigo, String concepto, String descripcion, String duda, boolean entendido){
        this.codigo=codigo;
        this.concepto =concepto;
        this.descripcion =descripcion;
        this.duda =duda;
        this.entendido = entendido;
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

    public String getDuda() {
        return duda;
    }

    public void setDuda(String duda) {
        this.duda = duda;
    }

    public boolean isEntendido() {
        return entendido;
    }

    public void setEntendido(boolean entendido) {
        this.entendido = entendido;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }
}
