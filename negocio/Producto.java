/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microempresa.negocio;

/**
 *
 * @author
 */
public class Producto {

    //atributos
    private int codigo;
    private int precio;
    private int cantidad;
    private String subcategoria;
    private String descripcion;
    private char medida; //U:unidad, G:gramos

    //constructor sin parámetros
    public Producto() {
    }

    //constructor con parámetros
    public Producto(int codigo, int precio, int cantidad, String subcategoria, String descripcion, char medida) {
        this.codigo = codigo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subcategoria = subcategoria;
        this.descripcion = descripcion;
        this.medida = medida;
    }

    //accesadores y mutadores
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public char getMedida() {
        return medida;
    }

    public void setMedida(char medida) {
        this.medida = medida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
