
package com.mycompany.modell;

public class Producto {
    String id_producto, id_categoria, id_unimed, nombre, descripcion, codigo;

    public Producto(String id_producto, String id_categoria, String id_unimed, String nombre, String descripcion, String codigo) {
        this.id_producto = id_producto;
        this.id_categoria = id_categoria;
        this.id_unimed = id_unimed;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    public Producto() {
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getId_unimed() {
        return id_unimed;
    }

    public void setId_unimed(String id_unimed) {
        this.id_unimed = id_unimed;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
}
