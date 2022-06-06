package Util;

public class Node {
    public String nombre, direccion;
    public Node siguiente,anterior;

    public Node(String nombre,String direccion){
        this.nombre=nombre;
        this.direccion=direccion;
        siguiente=null;
        anterior=null;
    }
}
